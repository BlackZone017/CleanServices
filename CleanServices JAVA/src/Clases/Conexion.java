/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author gouripc
 */

//Los imports
	import java.sql.Connection;
	import java.sql.DriverManager;
	import javax.swing.JOptionPane;

public class Conexion {
    
    Connection conect=null;
    
    public Connection conexion(){

        try {
            //Url de la conexion Base de Datos
            String connectionUrl = "jdbc:sqlserver://;database=Cleaning;integratedSecurity=true;";
            //String connectionUrl = "jdbc:microsoft:sqlserver://GOURIPC:1433;DatabaseName=Cleaning com.microsoft.jdbc.sqlserver.SQLServerDriver";
            //jdbc:microsoft:sqlserver://HOST:1433;DatabaseName=DATABASE com.microsoft.jdbc.sqlserver.SQLServerDriver
            conect = DriverManager.getConnection(connectionUrl);
           System.out.println("Conectado.");
           JOptionPane.showMessageDialog(null, "Connected");
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error en la conexión a la Base de Datos: "+ex);

        }

        return conect;
    }
}

