package Clases;

import java.sql.*;

public class DataBase {

    Statement manipularDB;

    public DataBase() {
        String hostname = "localhost";
        String puerto = "3306";
        String database_name = "restaurante";
        String database_user = "root";
        String database_password = "";
        String url = "jdbc:mysql://" + hostname + ":" + puerto + "/" + database_name;

        try {
            Connection conexion = DriverManager.getConnection(url, database_user, database_password);
            this.manipularDB = conexion.createStatement();
            System.out.println("Conexión exitosa a: " + database_name);
        } catch (SQLException e) {
            System.out.println("Error en conexión: " + e.getMessage());
            this.manipularDB = null;
        }
    }

    public boolean registrarPlato(String codigo, String nombre, double precio) {
        String consulta = "INSERT INTO platos(codigo, nombre, precio) VALUES ('" + codigo + "','" + nombre + "','" + precio + "')";
        try {
            int respuesta = manipularDB.executeUpdate(consulta);
            if(respuesta > 0){
                System.out.println("Menu insertado con exito");
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            
            System.out.println("Error al insertar" + e.getMessage());
            return false;
        }
    }
    
    public ResultSet buscarMenu(String codigo){
        try {
            ResultSet platos = this.manipularDB.executeQuery("SELECT * FROM platos WHERE codigo='"+codigo+"'");
            if(platos != null){
                platos.next();
            }
            return platos;
        } catch (SQLException e) {
            System.out.println("Error en busqueda: " + e.getMessage());
            return null;
        }
    }
    
    public boolean modificarMenu(String codigo, String nombre, double precio){
        try {
            String consulta = "UPDATE platos SET nombre='"+nombre+"', precio='"+precio+"' WHERE codigo='"+codigo+"'";
            int resp = manipularDB.executeUpdate(consulta);
            if(resp > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en UPDATE: " + e.getMessage());
            return false;
        }
    }

}

