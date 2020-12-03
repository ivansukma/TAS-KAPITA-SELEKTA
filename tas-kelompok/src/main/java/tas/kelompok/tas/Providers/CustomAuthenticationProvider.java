/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.Providers;

import tas.kelompok.tas.entities.rest.LoginInput;
import tas.kelompok.tas.entities.rest.LoginOutput;
import tas.kelompok.tas.services.LoginRestService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import tas.kelompok.tas.services.PenggunaService;

/**
 *
 * @author ivanr
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    LoginRestService service;
    PenggunaService penggunaService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("begin authorization");
        String email = authentication.getName();
        String password = authentication.getCredentials().toString(); //digunakan untuk melakukan authentikasi dari login form dari inputan email dan juga password
        LoginInput input = new LoginInput();
        input.setEmail(email);
        input.setPassword(password);
        System.out.println(password);
        LoginOutput output = service.login(input);

        if (output.getUser() != null) {

        }
        if (output.getStatus().equals("Verified")) {
            return new UsernamePasswordAuthenticationToken(output, email, new ArrayList<>());

        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
