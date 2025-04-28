package com.mycompany.GECULL.Functions;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mycompany.GECULL.Models.Usuario;
import com.mycompany.GECULL.Repository.IRepository;


/**
 *
 * @author crism
 */
public class LogicFunctions implements IFunctions {
    
    private final IRepository BDrepository;
    
    public LogicFunctions(IRepository BDrepository){
        this.BDrepository = BDrepository;
    }
    
    @Override
    public String sha256(String mensaje){
        
        try{
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte [] digest = sha.digest(mensaje.getBytes());
            StringBuilder hexString = new StringBuilder();
    
            for(byte b:digest){
                hexString.append(String.format("%02x",b));
            }
            
            return hexString.toString();
            
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
    
    // Login
    
    @Override
    public boolean iniciarSesion(String usuario, String contrasena, String rol) {
        boolean accesoPermitido = false;
        try {
            String hashContrasena = sha256(usuario + ":" + contrasena);
    
            ResultSet resultado = BDrepository.consultarBD(
                "SELECT \"usauser\", \"usacontrasenia\", \"usarol\" FROM \"usuarios\" " +
                "WHERE \"usauser\" = '" + usuario + "' " +
                "AND \"usacontrasenia\" = '" + hashContrasena + "' " +
                "AND \"usarol\" = '" + rol + "'"
            );
    
            if (resultado.next()) {
                accesoPermitido = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(LogicFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return accesoPermitido;
    }
    
    // Registro de usuario con rol
    
    @Override
    public boolean registrarUsuario(Usuario nuevoUsuario){
        
        String hashContrasena = sha256(nuevoUsuario.getUsuario() + ":" + nuevoUsuario.getContrasena());
        
        try{
            // Verificar si el usuario ya existe
            if(BDrepository.consultarBD("select \"usauser\" from \"usuarios\" where \"usauser\" = '" + nuevoUsuario.getUsuario() + "'").next()){
                JOptionPane.showMessageDialog(null, "Usuario ya existente");
                return false; 
            }
            // Insertar nuevo usuario con su rol
            BDrepository.ejecutarSql("insert into \"usuarios\" (\"usanombre\", \"usauser\", \"usacontrasenia\", \"usarol\") values ('" + nuevoUsuario.getNombre() + "', '" + nuevoUsuario.getUsuario() + "', '" + hashContrasena + "', '" + nuevoUsuario.getRol() + "')");

            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
            return false;
        }
    }
    
    // Registro de vehículo
}
