/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.controller;

import controleacademico.model.User;

/**
 *
 * @author Double
 */
public class UsuarioLogadoController {
     private static User usuarioLogado;

    public static void login(User usuario) {
        usuarioLogado = usuario;
    }

    public static void logout() {
        usuarioLogado = null;
    }

    public static User getUsuarioLogado() {
        return usuarioLogado;
    }

    public static boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }
    
}
