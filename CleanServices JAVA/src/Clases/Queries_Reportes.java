/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gouripc
 */
public class Queries_Reportes {
    
    DefaultTableModel ModeloTabla; //Objeto para llenar la tabla
    Conexion conn=new Conexion();
    
    Statement ejecutar;
    ResultSet resultado;
    String query;

    //ReportesDiarios
    public void reportesDiarios(JTable tabla){
        String [] columnas={"Tipo de Voto","Cantidad de Votos","Fecha Actual"};
        String [] registros=new String[4];
        ModeloTabla=new DefaultTableModel(null,columnas);
        
        query = "SELECT tipo as 'Tipo de Voto', sum(voto) as 'Cantidad de Votos',CONVERT(VARCHAR(10),fecha, 105) as \"Fecha Actual\"\n" +
                "FROM votos WHERE DAY(fecha) = DAY(GETDATE())\n" +
                "GROUP BY DATEPART(day, Fecha),DATENAME(day,fecha), tipo, CONVERT(VARCHAR(10),fecha, 105)\n" +
                "ORDER BY DATEPART(day, Fecha) ASC"; //Query que ejecutare
        
        try{
            conn.conexion(); //hago la conexion
            ejecutar = conn.conexion().createStatement(); //creo mi declaracion
            resultado=ejecutar.executeQuery(query); //le paso la query a mi declaracion y le paso los valores al result set
            
            while(resultado.next()){
                registros[0]=resultado.getString("Tipo de Voto");
                registros[1]=resultado.getString("Cantidad de Votos");
                registros[2]=resultado.getString("Fecha Actual");                
                ModeloTabla.addRow(registros);
            }
            tabla.setModel(ModeloTabla);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en la tabla SQL: "+e);
        }
    }
    
    
    //REPORTES MENSUALES
    public void reportesMensuales(JTable tabla){
        String [] columnas={"Tipo de Voto","Cantidad de Votos","Mes"};
        String [] registros=new String[4];
        ModeloTabla=new DefaultTableModel(null,columnas);
        
        query = "SELECT tipo as 'Tipo de Voto', sum(voto) as 'Cantidad de Votos',DATENAME(month,fecha) +', 2019' as Mes\n" +
"FROM votos WHERE MONTH(fecha) = MONTH(GETDATE())\n" +
"GROUP BY DATEPART(month, Fecha),DATENAME(month,fecha), tipo\n" +
"ORDER BY DATEPART(month, Fecha) ASC"; //Query que ejecutare
        
        try{
            conn.conexion(); //hago la conexion
            ejecutar = conn.conexion().createStatement(); //creo mi declaracion
            resultado=ejecutar.executeQuery(query); //le paso la query a mi declaracion y le paso los valores al result set
            
            while(resultado.next()){
                registros[0]=resultado.getString("Tipo de Voto");
                registros[1]=resultado.getString("Cantidad de Votos");
                registros[2]=resultado.getString("Mes");                
                ModeloTabla.addRow(registros);
            }
            tabla.setModel(ModeloTabla);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en la tabla SQL: "+e);
        }
    }
    
    
    //REPORTES ANUALES
    public void reportesAnuales(JTable tabla){
        String [] columnas={"Tipo de Voto","Cantidad de Votos","Meses"};
        String [] registros=new String[4];
        ModeloTabla=new DefaultTableModel(null,columnas);
        
        query = "SELECT tipo as 'Tipo de Voto', sum(voto) as 'Cantidad de Votos',DATENAME(month,fecha) +', 2019' as Meses\n" +
"FROM votos WHERE YEAR(fecha) = 2019\n" +
"GROUP BY DATEPART(month, Fecha),DATENAME(month,fecha), tipo\n" +
"ORDER BY DATEPART(month, Fecha) ASC"; //Query que ejecutare
        
        try{
            conn.conexion(); //hago la conexion
            ejecutar = conn.conexion().createStatement(); //creo mi declaracion
            resultado=ejecutar.executeQuery(query); //le paso la query a mi declaracion y le paso los valores al result set
            
            while(resultado.next()){
                registros[0]=resultado.getString("Tipo de Voto");
                registros[1]=resultado.getString("Cantidad de Votos");
                registros[2]=resultado.getString("Meses");                
                ModeloTabla.addRow(registros);
            }
            tabla.setModel(ModeloTabla);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error en la tabla SQL: "+e);
        }
    }
    
}
