package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Camilo
 */
public class Cliente {
    
    //ATRIBUTOS
    private int idCliente;
    private String numeroDocumento;
    private String tipoDocumento;
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String telefonoCliente;
    private String direccionCliente;
    private String passwordCliente;

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }
    conexion objConector = new conexion();
    
    //METODO CONSTRUCTOR
    public Cliente(){
    }
    
    //GETTERS Y SETTERS

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    
    //INSERTAR
    public void insertarCliente(){
        objConector.conectar();
        
        try {
            String sql = "INSERT INTO cliente"
                    +   "(idCliente, numeroDocumento, tipoDocumento, nombreCliente, apellidoCliente, emailCliente, telefonoCliente, direccionCliente)"
                    +   "VALUES(NULL,?,?,?,?,?,?,?);";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.numeroDocumento);
            stmt.setString(2,this.tipoDocumento);
            stmt.setString(3,this.nombreCliente);
            stmt.setString(4,this.apellidoCliente);
            stmt.setString(5,this.emailCliente);
            stmt.setString(6,this.telefonoCliente);
            stmt.setString(7,this.direccionCliente);
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error al Insertar"+ error);
        }
    }
    
    //REGISTRAR CLIENTE
    public void registrarCliente(){
        objConector.conectar();
    
    try {
            String sql = "INSERT INTO cliente"
                    +   "(idCliente, numeroDocumento, tipoDocumento, nombreCliente, apellidoCliente, emailCliente, telefonoCliente, direccionCliente, passwordCliente)"
                    +   "VALUES(NULL,?,?,?,?,?,?,?,?);";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.numeroDocumento);
            stmt.setString(2,this.tipoDocumento);
            stmt.setString(3,this.nombreCliente);
            stmt.setString(4,this.apellidoCliente);
            stmt.setString(5,this.emailCliente);
            stmt.setString(6,this.telefonoCliente);
            stmt.setString(7,this.direccionCliente);
            stmt.setString(8,this.passwordCliente);
            stmt.execute();
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error al registrar"+ error);
        }
    }
    
     //LISTAR
    public ResultSet listarCliente(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cliente";
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
    
    //CONSULTAR CLIENTE POR NUMERO DE DOCUMENTO
    public ResultSet consultanumeroDocumento(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM cliente WHERE idCliente = ?";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idCliente));
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar: "+error);
        }
        return null;
    }
    
    //ELIMINAR
    
    public void eliminarCliente(){
        objConector.conectar();
        try {
            String sql = "DELETE FROM cliente "
                    + " WHERE idCliente = ?; ";
            PreparedStatement ps;
            ps = objConector.conn.prepareCall(sql);
            ps.setString(1, String.valueOf(this.idCliente));
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario"+idCliente+e);
        }
    }
    
    //ACTUALIZAR
    
    public void actualizarCliente(){
        objConector.conectar();
        try{
            
            String sql = "UPDATE cliente SET "
                        +"tipoDocumento = ?, "
                        +"numeroDocumento = ?, "
                        +"nombreCliente = ?, "
                        +"apellidocliente= ?, "
                        +"emailCliente= ?, "
                        +"telefonoCliente= ?, "
                        +"direccionCliente= ?, "
                        +"passwordCliente= ?"
                        +"WHERE idCliente = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement (sql);
            stmt.setString(1,this.tipoDocumento);
            stmt.setString(2,this.numeroDocumento);
            stmt.setString(3,this.nombreCliente);
            stmt.setString(4,this.apellidoCliente);
            stmt.setString(5,this.emailCliente);
            stmt.setString(6,this.telefonoCliente);
            stmt.setString(7,this.direccionCliente);
            stmt.setString(8,this.passwordCliente);
            stmt.setString(9,String.valueOf(this.idCliente));
            stmt.execute();
            objConector.desconectar();
        }catch (Exception error) {
            System.out.println("Error al Actualizar: "+error);
        }
    }
    
       //LOGIN
    public ResultSet loginCliente(){
        objConector.conectar();
        try {
            String sql = "SELECT * FROM cliente WHERE numeroDocumento = ? AND passwordCliente = ? ";
            PreparedStatement pst;
            
            pst = objConector.conn.prepareStatement(sql);
            pst.setString(1,String.valueOf(this.numeroDocumento));
            pst.setString(2,String.valueOf(this.passwordCliente));
            ResultSet consulta = pst.executeQuery();
            objConector.desconectar();
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al Ingresar: " + e);
        }
       return null;
    }
}
