/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author julia
 */
public class conexion {

    //ATRIBUTOS
    private String bbdd = "jdbc:mysql://localhost:3306/TecniYa";
    private String usuario = "root";
    private String clave = "";
    public Connection conn;
    
    //METODOS
    public void conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(bbdd,usuario,clave);
            System.out.println("CONECTADO CORRECTAMENTE!!");
        } catch (Exception e) {
            System.out.println("ERROR AL CONECTARSE: " +e.getMessage().toString());
        }
    }
    public void desconectar (){
        conn = null;
    }
    
}