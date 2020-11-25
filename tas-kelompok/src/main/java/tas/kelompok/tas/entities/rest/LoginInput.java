/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.entities.rest;

import lombok.Data;

/**
 *
 * @author cnugr
 */
@Data
public class LoginInput {

    private String email;
    private String password;
}
