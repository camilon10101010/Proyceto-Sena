package models;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import models.Cliente;

/**
 *
 * @author Camilo
 */
public class Cita {
    
    //ATRIBUTOS
    private int idCita;
    private String fechaCita;
    private String horaCita;
    private String estadoCita;
    private String informacionProblema;
    private String idClienteFK; 
    private String idUsuarioFK;
    private int idUsuario;
    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String direccionCliente;
    private String telefonoCliente;
    
    conexion objConector = new conexion();
    
   
       
    //METODO CONSTRUCTOR
    public Cita(){
    }

    //GETTERS Y SETTERS 
    
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }
    
    

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getInformacionProblema() {
        return informacionProblema;
    }

    public void setInformacionProblema(String informacionProblema) {
        this.informacionProblema = informacionProblema;
    }
    
    public String getIdClienteFK() {
        return idClienteFK;
    }

    public void setIdClienteFK(String idClienteFK) {
        this.idClienteFK = idClienteFK;
    }

    public String getIdUsuarioFK() {
        return idUsuarioFK;
    }

    public void setIdUsuarioFK(String idUsuarioFK) {
        this.idUsuarioFK = idUsuarioFK;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public conexion getObjConector() {
        return objConector;
    }

    public void setObjConector(conexion objConector) {
        this.objConector = objConector;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    
   //INSERTAR 
   public void insertarCita(){
       objConector.conectar();
       
       try {
           String sql = "INSERT INTO cita"
                   + "(idCita, informacionProblema, fechaCita, horaCita,estadoCita)"
                   + "VALUES(NULL,?,?,?,'Agendado');";
           PreparedStatement stmt;
           stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.informacionProblema);
            stmt.setString(2,this.fechaCita);
            stmt.setString(3,this.horaCita);
            stmt.execute();
            objConector.desconectar();   
       }catch (Exception error) {
            System.out.println("Error al Insertar"+ error);
        }
   }
    
   
    //LISTAR
    public ResultSet listarCita(){
        objConector.conectar();
        
       try {
           
            String sql = "SELECT * FROM cita";
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
    
    
   //LISTAR POR DIA
    public ResultSet listarXDia(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita WHERE estadoCita='disponible' AND fechaCita= ? ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,this.fechaCita);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar(); 
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al consultar por dia"+ e);
        }
        return null;
    }
    
    //LISTAR POR DIA PARA CADA CLIENTE
    public ResultSet listarXDiaCliente(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita inner join cliente WHERE estadoCita='disponible' AND idCliente= ? and fechaCita= ?;";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.idCliente));
            stmt.setString(2,this.fechaCita);
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar(); 
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al consultar por dia"+ e);
        }
        return null;
    }
    
    
    
    //LISTAR CON DATOS DE CLIENTE
    public ResultSet listarCitaCliente(){
        objConector.conectar();
        
       try {
           
            String sql = "SELECT * FROM cita ";
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
    
    
    //ELIMINAR
    
    public void eliminarCita(){
        objConector.conectar();
        try {
         String sql = "DELETE FROM cita "
                    + "WHERE idCita = ?; ";
            PreparedStatement ps;
            ps = objConector.conn.prepareCall(sql);
            ps.setString(1, String.valueOf(this.idCita));
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error al eliminar la cita"+idCita+e);
        }
    }
    //ACTUALIZAR
    
    public void actualizarCita(){
        objConector.conectar();
        try{
            
            String sql = "UPDATE cita SET "
                        +"informacionProblema = ?, "
                        +"fechaCita = ?, "
                        +"horaCita = ?, "
                        +"estadoCita = 'Agendado' "
                        +"WHERE idCita = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement (sql);
            stmt.setString(1,this.informacionProblema);
            stmt.setString(2,this.fechaCita);
            stmt.setString(3,this.horaCita);
            stmt.setString(4,String.valueOf(this.idCita));
            stmt.execute();
            objConector.desconectar();
        }catch (Exception error) {
            System.out.println("Error al Actualizar: "+error);
        }
    }
    
    // ECOGER CITA PARA CLIENTE

    public void escogerCitaCliente(){
        objConector.conectar();
        try{
            
            String sql = "UPDATE cita SET "
                        +"informacionProblema = ?, "
                        +"fechaCita = ?, "
                        +"horaCita = ?, "
                        +"estadoCita = 'Agendado', "
                        +"idClienteFK = ? "
                        +"WHERE idCita = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement (sql);
            stmt.setString(1,this.informacionProblema);
            stmt.setString(2,this.fechaCita);
            stmt.setString(3,this.horaCita);
            stmt.setString(4,this.idClienteFK);
            stmt.setString(5,String.valueOf(this.idCita));
            stmt.execute();
            objConector.desconectar();
        }catch (Exception error) {
            System.out.println("Error al Actualizar: "+error);
        }
    }
    
   //ASIGNAR CITA
    
       public void asignarCita(){
        objConector.conectar();
        try{
            
            String sql = "UPDATE cita SET "
                        +"informacionProblema = ?, "
                        +"fechaCita = ?, "
                        +"horaCita = ?, "
                        +"estadoCita = 'En proceso', "
                        +"idUsuarioFK = ? "
                        +"WHERE idCita = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement (sql);
            stmt.setString(1,this.informacionProblema);
            stmt.setString(2,this.fechaCita);
            stmt.setString(3,this.horaCita);
            stmt.setString(4,this.idUsuarioFK);
            stmt.setString(5,String.valueOf(this.idCita));

            stmt.execute();
            objConector.desconectar();
        }catch (Exception error) {
            System.out.println("Error al Actualizar: "+error);
        }
    }
   
    //CAMBIAR ESTADO
    
       public void cambiarEstado(){
        objConector.conectar();
        try{
            
            String sql = "UPDATE cita SET "
                        +"estadoCita = ? "
                        +"WHERE idCita = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement (sql);
            stmt.setString(1,this.estadoCita);
            stmt.setString(2,String.valueOf(this.idCita));

            stmt.execute();
            objConector.desconectar();
        }catch (Exception error) {
            System.out.println("Error al Actualizar: "+error);
        }
    }
       
    //CANCELAR CITA CLIENTE
    
       public void cancelarCita(){
        objConector.conectar();
        try{
            
            String sql = "UPDATE cita SET informacionProblema = 'Pendiente',  estadoCita = 'disponible', idClienteFK = NULL, idUsuarioFK = NULL WHERE idCita = ? ; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement (sql);
            stmt.setString(1,String.valueOf(this.idCita));

            stmt.execute();
            objConector.desconectar();
        }catch (Exception error) {
            System.out.println("Error al Actualizar: "+error);
        }
    }
    
    //LISTAR POR ID
    public ResultSet consultaXId(){
        objConector.conectar();
        
        try{
            String sql = "SELECT * FROM cita WHERE idCita = ?; ";
            PreparedStatement stmt;
            stmt = objConector.conn.prepareStatement(sql);
            stmt.setString(1,String.valueOf(this.idCita));
            ResultSet consulta = stmt.executeQuery();
            objConector.desconectar();
            return consulta;
        }
        catch (Exception error){
            System.out.println("Error al Consultar: "+error);
        }
        return null;
    }   
    
    
    
    
    
    //CREAR AGENDA
    public void crearAgenda(){
        objConector.conectar();
        LocalDate fecha = LocalDate.now();
       
        try {
            for(int a= 1; a<=31; a++){
                for(int i = 8; i < 18 ; i++ ){
                    String sql = "INSERT INTO cita"
                       + "(idCita, informacionProblema, fechaCita, horaCita,estadoCita)"
                       + "VALUES(NULL,'Pendiente',?,?,'disponible');";
                    PreparedStatement stmt;
                    stmt = objConector.conn.prepareStatement(sql);
                    stmt.setString(1,fecha.toString());
                    stmt.setString(2, i+":00");
                    stmt.execute();
                }  
                fecha = fecha.plusDays(1);
            }    
            objConector.desconectar();
        } catch (Exception e) {
            System.out.println("Error al crear agenda: "+e);
        }
    }
    
    //LISTAR CITAS DE CLIENTE
    public ResultSet listarCitaDeCliente(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita WHERE idClienteFK = ? ;";
            System.out.println(idCliente);
            PreparedStatement psl;
            psl = objConector.conn.prepareStatement(sql);
            psl.setString(1, String.valueOf(this.idCliente));
            ResultSet consulta = psl.executeQuery();
            objConector.desconectar();  
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al listar" +e);
        }
        return null;
    } 
    
     //LISTAR CITAS DE EMPLEADO
    public ResultSet listarCitaEmpleado(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita "
                        + " INNER JOIN cliente ON cita.idClienteFK=cliente.idCliente "
                        + " WHERE idusuarioFK = ? ";
            System.out.println(idUsuario);
            PreparedStatement psl;
            psl = objConector.conn.prepareStatement(sql);
            psl.setString(1, String.valueOf(this.idUsuario));
            ResultSet consulta = psl.executeQuery();
            objConector.desconectar();  
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al listar" +e);
        }
        return null;
    }   
    
    //LISTAR CITAS DE EMPLEADO CUANDO ESTEN EN PROCESO
    public ResultSet CitaEmpleadoProceso(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita INNER JOIN cliente ON cita.idClienteFK=cliente.idCliente WHERE estadoCita='En proceso' AND idusuarioFK = ?; ";
            System.out.println(idUsuario);
            PreparedStatement psl;
            psl = objConector.conn.prepareStatement(sql);
            psl.setString(1, String.valueOf(this.idUsuario));

            ResultSet consulta = psl.executeQuery();
            objConector.desconectar();  
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al listar" +e);
        }
        return null;
    }
    
    //LISTAR CITAS DE EMPLEADO CUANDO ESTEN REALIZADAS
    public ResultSet CitaEmpleadoRealizada(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita INNER JOIN cliente ON cita.idClienteFK=cliente.idCliente WHERE estadoCita='Realizada' AND idusuarioFK = ?; ";
            System.out.println(idUsuario);
            PreparedStatement psl;
            psl = objConector.conn.prepareStatement(sql);
            psl.setString(1, String.valueOf(this.idUsuario));

            ResultSet consulta = psl.executeQuery();
            objConector.desconectar();  
            return consulta;
        } catch (Exception e) {
            System.out.println("Error al listar" +e);
        }
        return null;
    }
    
    //LISTAR CITAS CUANDO ESTEN AGENDADAS
    public ResultSet CitaAgendado(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita INNER JOIN cliente ON cita.idClienteFK=cliente.idCliente WHERE estadoCita='Agendado'; ";
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
    
    //LISTAR CITAS CUANDO ESTEN EN PROCESO
    public ResultSet CitaEnProceso(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita INNER JOIN cliente ON cita.idClienteFK=cliente.idCliente WHERE estadoCita='En proceso'; ";
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
    
    //LISTAR CITAS CUANDO ESTEN EN YA REALIZADAS
    public ResultSet CitaYaRealizada(){
        objConector.conectar();
        
        try {
            String sql = "SELECT * FROM cita INNER JOIN cliente ON cita.idClienteFK=cliente.idCliente WHERE estadoCita='Realizada'; ";
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
    
}
