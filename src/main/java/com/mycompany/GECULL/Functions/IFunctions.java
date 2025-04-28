/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.GECULL.Functions;
import com.mycompany.GECULL.Models.Usuario;

/**
 *
 * @author crism
 */
public interface IFunctions {
      
    public abstract String sha256(String comando);
      
    public abstract boolean iniciarSesion(String usuario, String contrasena, String rol);
    public abstract boolean registrarUsuario(Usuario usuario);  
}
