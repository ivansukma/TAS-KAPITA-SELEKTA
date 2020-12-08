/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.SuccessHandler;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import tas.kelompok.tas.entities.rest.LoginOutput;
import org.springframework.context.annotation.Configuration;
import tas.kelompok.tas.entities.fromdatabase.Pengguna;

/**
 *
 * @author ivanr
 */
@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        String targetUrl = determineTargetUrl(authentication);
        System.out.println(targetUrl);
        if (response.isCommitted()) {
            return;
        }
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginOutput data = (LoginOutput) authentication.getPrincipal();
        String url = "/login?error=true";
        System.out.println(data);

        if (data.getUser().getRoles().contains("ROLE_LEARNER")) {
            return "";
        } else if (data.getUser().getRoles().contains("ROLE_SUPER_ADMIN")) {
            return "admin";
        }
        return url;
    }

    public String getIdEmail(Authentication authentication) {
        Pengguna pengguna = new Pengguna();

        authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginOutput data = (LoginOutput) authentication.getPrincipal();
        String url = "/login?error=true";
        System.out.println(data);
        pengguna.setIDPengguna(data.getUser().getId());
        System.out.println(data.getUser().getId());
        //pengguna.setEmail(data.getUser().getEmail());
        //System.out.println(data.getUser().getEmail());
        return url;
    }

}
