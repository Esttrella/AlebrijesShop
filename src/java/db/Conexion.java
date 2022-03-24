/* 
    
    Author : Estrella
    Fecha creacion : 08 marzo 2022
    Fecha Actualizacion : 09 marzo 2022
    Descripcion: Clase que permite hacer una conexion con la base de datos

*/
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexion {
    private   Connection conexion;
    private final String url;
    private final String user;
    private final String pwd;
    private final String nombrebd;
  

    public Conexion() {
        
        this.url = "localhost";
        this.user = "postgres";
        this.pwd = "i1806";
        this.nombrebd="bdalebrijes";
    }
    
    public Connection conectar(){
//       if(conexion==null || conexion.isClosed())

    try{
           Class.forName("org.postgresql.Driver");
             conexion= DriverManager.getConnection("jdbc:postgresql://"+url+"/"+nombrebd,user,pwd);
           System.out.println("conexión establecida"); 
           
      
       }catch(Exception ex){
           System.out.println("Error al conectar:"+ ex.getMessage());
       }
        
    return conexion;
        
    }
    
     public void desconectar(){
//    if(conexion==null || conexion.isClosed()){
   try{
       conexion.close();
       System.out.println("Desconectado correctamente");
   }catch(Exception ex){}
    
}
    

    public Connection getConexion(){
        
        return conexion;
    }
    
    public static void insertar(Connection con){
    try{
     Statement s=con.createStatement();
     String sql="insert into productos values('101','sueter','gris',100,'03/02/13','03/02/13');";
        s.executeUpdate(sql);
        System.out.println("Producto agregado correctamente");
     
     }catch(Exception ex){
    
    }
    
    }
    
    public static void consultar(Connection con){
    try{
     Statement s=con.createStatement();
     String sql="select *from productos";
     ResultSet rs=s.executeQuery(sql);
     while (rs.next()){
         System.out.println(rs.getObject("codigo"));  
         System.out.println(rs.getObject("nombre"));
         System.out.println(rs.getObject("descripcion")); 
         System.out.println(rs.getObject("precio"));
         System.out.println(rs.getObject("fecha_creacion"));
         System.out.println(rs.getObject("fecha_eliminacion"));
     }
        
    
    }catch(Exception ex){
    
    }
    
    }
 
    public static void main(String[] args) {
        
           Conexion c=new Conexion();
          
           Connection con =c.conectar();
//           insertar(con);
           c.consultar(con);
          c.desconectar();
            
    }
     
    
    
}
