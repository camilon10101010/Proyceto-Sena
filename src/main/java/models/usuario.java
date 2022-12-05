/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julia
 */
public class usuario {
    
    //ATRIBUTOS
    private int idUsuario;
    private String tipoUsuario;
    private String contrasenaUsuario;
    private String correoUsuario;
    private String numeroDocumentoU;
    private String tipoDocumentoU;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String telefonoUsuario;
    private String direccionUsuario;
    

    
    conexion objConector = new conexion();
    
    // CONTRUCTOR
    public usuario(){
    }
    
    //GET Y SETTERS
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getNumeroDocumentoU() {
        return numeroDocumentoU;
    }

    public void setNumeroDocumentoU(String numeroDocumentoU) {
        this.numeroDocumentoU = numeroDocumentoU;
    }

    public String getTipoDocumentoU() {
        return tipoDocumentoU;
    }

    public void setTipoDocumentoU(String tipoDocumentoU) {
        this.tipoDocumentoU = tipoDocumentoU;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }
    
    public conexion getObjConector() {
        return objConector;
    }

    public void setObjConector(conexion objConector) {
        this.objConector = objConector;
    }
    
    //INSERTAR
    
    public void insertarUsario (){
        objConector.conectar();
        
        try {
            String sql = "INSERT INTO usuario"
                    + "(idUsuario, tipoUsuario, contrasenaUsuario, correoUsuario, numeroDocumentoU, tipoDocumentoU, nombreUsuario, apellidoUsuario, telefonoUsuario, direccionUsuario)"
                    + "VALUES (NULL,'Empleado',?,?,?,?,?,?,?,?)";
            PreparedStatement ps;
            ps = objConector.conn.prepareStatement(sql);
            ps.setString(1, this.contrasenaUsuario);
            ps.setString(2, this.correoUsuario);
            ps.setString(3, this.numeroDocumentoU);
            ps.setString(4, this.tipoDocumentoU);
            ps.setString(5, this.nombreUsuario);
            ps.setString(6, this.apellidoUsuario);
            ps.setString(7, this.telefonoUsuario);
            ps.setString(8, this.direccionUsuario);
            ps.execute();
            objConector.desconectar();
                    
        } catch (Exception e) {
            System.out.println("Error al insertar"+e);
        }
    }
    
    
    //LISTAR
    public ResultSet listarUsuario(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM usuario";
            PreparedStatement psl;
            psl = objConector.conn.prepareStatement(sql);
            ResultSet consulta = psl.executeQuery();
            objConector.desconectar();
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al listar" +e);
        }
        return null;
    }
    
    public ResultSet listarEmpleado(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'Empleado'; ";
            PreparedStatement psl;
            psl = objConector.conn.prepareStatement(sql);
            ResultSet consulta = psl.executeQuery();
            objConector.desconectar();
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al listar" +e);
        }
        return null;
    }
    
     //CONSULTAR USUARIO POR ID
    public ResultSet consultaXId(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idUsuario));
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar: "+error);
        }
        return null;
    }
    
    //ACTUALIZAR
    public void actualizarUsuario(){
        objConector.conectar();
        try {
            String sql = "UPDATE usuario SET "
                    + "tipoUsuario = ?, "
                    + "contrasenaUsuario = ?, "
                    + "correoUsuario = ?, "
                    + "numeroDocumentoU = ?, "
                    + "tipoDocumentoU = ?, "
                    + "nombreUsuario = ?, "
                    + "apellidoUsuario = ?, "
                    + "telefonoUsuario = ?, "
                    + "direccionUsuario = ? "
                    + "WHERE idUsuario = ?; ";
            PreparedStatement ps;
            
            ps = objConector.conn.prepareStatement(sql);
            ps.setString(1, this.tipoUsuario);
            ps.setString(2, this.contrasenaUsuario);
            ps.setString(3, this.correoUsuario);
            ps.setString(4, this.numeroDocumentoU);
            ps.setString(5, this.tipoDocumentoU);
            ps.setString(6, this.nombreUsuario);
            ps.setString(7, this.apellidoUsuario);
            ps.setString(8, this.telefonoUsuario);
            ps.setString(9, this.direccionUsuario);
            ps.setString(10,String.valueOf(this.idUsuario));
            ps.execute();
            objConector.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar"+e);
        }
    }
    
    //ELIMINAR
    
    public void eliminarUsuario(){
        objConector.conectar();
        try {
            String sql = "DELETE FROM usuario "
                    + " WHERE idUsuario = ?; ";
            PreparedStatement ps;
            ps = objConector.conn.prepareCall(sql);
            ps.setString(1, String.valueOf(this.idUsuario));
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario"+idUsuario+e);
        }
    }
    
    //LOGIN
    public ResultSet login(){
        objConector.conectar();
        try {
            String sql = "SELECT * FROM usuario WHERE correoUsuario = ? AND contrasenaUsuario = ? ";
            PreparedStatement pst;
            
            pst = objConector.conn.prepareStatement(sql);
            pst.setString(1,String.valueOf(this.correoUsuario));
            pst.setString(2,String.valueOf(this.contrasenaUsuario));
            ResultSet consulta = pst.executeQuery();
            objConector.desconectar();
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al Ingresar: " + e);
        }
       return null;
    }
}
