package Clases;

import java.sql.*;

public class DataBase {
    
    Statement manipularDB;
    
    public DataBase(){
        String hostname = "localhost";
        String puerto = "3306";
        String database_name = "almacenes";
        String database_user = "root";
        String database_password = "";
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+database_name;
        
        try{
            Connection conexion = DriverManager.getConnection(url, database_user, database_password);
            this.manipularDB = conexion.createStatement();
            System.out.println("Conexion Exitosa a: "+database_name);
        }catch(SQLException e){
            System.out.println("Error en conexion: "+e.getMessage());
            this.manipularDB = null;
        }
    }
    
    public Persona[] listaClientes(){
        Persona [] listaClientes = new Persona [100];
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM clientes");
            registros.next();
            if (registros.getRow()==1) {
                int indice = 0;
                do{
                    Persona temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );
                    listaClientes[indice] = temp;
                    indice++;
                }while(registros.next());
            }
            return listaClientes;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return listaClientes;
        }
    }
    
    public Persona[] listaVendedores(){
        Persona [] listaClientes = new Persona [100];
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM vendedores");
            registros.next();
            if (registros.getRow()==1) {
                int indice = 0;
                do{
                    Persona temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );
                    listaClientes[indice] = temp;
                    indice++;
                }while(registros.next());
            }
            return listaClientes;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return listaClientes;
        }
    }
    
    public Persona buscarCliente(String cedula){
        Persona temp = null;
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM clientes WHERE cedula='"+cedula+"' ");
            registros.next();
            if (registros.getRow()==1) {
                temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );
            }
            return temp;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return temp;
        }
    }
    
    public Persona buscarVendedor(String cedula){
        Persona temp = null;
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM vendedores WHERE cedula='"+cedula+"' ");
            registros.next();
            if (registros.getRow()==1) {
                temp = new Persona( registros.getString("cedula"),registros.getString("nombres"), registros.getString("apellidos"), registros.getString("telefono"), registros.getString("direccion"), registros.getString("email") );
            }
            return temp;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return temp;
        }
    }
    
    public boolean editarCliente(Persona persona){
        boolean respuesta = false;
        String cedula = persona.getCedula();
        String nombres = persona.getNombres();
        String apellidos = persona.getApellidos();
        String telefono = persona.getTelefono();
        String direccion = persona.getDireccion();
        String email = persona.getEmail();
        
        try {
            String consulta = "UPDATE clientes SET nombres='"+nombres+"', apellidos='"+apellidos+"', telefono='"+telefono+"', direccion='"+direccion+"', email='"+email+"' WHERE cedula='"+cedula+"'";
            int resp = manipularDB.executeUpdate(consulta);
            if (resp>0) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en UPDATE: "+ex.getMessage());
        }
        return respuesta;
    }
    
    public boolean editarVendedor(Persona persona){
        boolean respuesta = false;
        String cedula = persona.getCedula();
        String nombres = persona.getNombres();
        String apellidos = persona.getApellidos();
        String telefono = persona.getTelefono();
        String direccion = persona.getDireccion();
        String email = persona.getEmail();
        
        try {
            String consulta = "UPDATE vendedores SET nombres='"+nombres+"', apellidos='"+apellidos+"', telefono='"+telefono+"', direccion='"+direccion+"', email='"+email+"' WHERE cedula='"+cedula+"'";
            int resp = manipularDB.executeUpdate(consulta);
            if (resp>0) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error en UPDATE: "+ex.getMessage());
        }
        return respuesta;
    }
    
    public boolean insertarCliente(String cedula, String nombres, String apellidos, String telefono, String direccion, String email){
        String consulta = "INSERT INTO clientes(cedula, nombres, apellidos, telefono, direccion, email) VALUES ('"+cedula+"','"+nombres+"','"+apellidos+"','"+telefono+"','"+direccion+"','"+email+"') ";    
        try{
            int respuesta = manipularDB.executeUpdate(consulta);
            if (respuesta>0) {
                System.out.println("REGISTRO INSERTADO CON EXITO");
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error al insertar: "+e.getMessage());
            return false;
        }
    }
    
    public boolean insertarVendedor(String cedula, String nombres, String apellidos, String telefono, String direccion, String email){
        String consulta = "INSERT INTO vendedores(cedula, nombres, apellidos, telefono, direccion, email) VALUES ('"+cedula+"','"+nombres+"','"+apellidos+"','"+telefono+"','"+direccion+"','"+email+"') ";    
        try{
            int respuesta = manipularDB.executeUpdate(consulta);
            if (respuesta>0) {
                System.out.println("REGISTRO INSERTADO CON EXITO");
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error al insertar: "+e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarUsuario(String cedula, String tipo){
        
        String tabla = (tipo.equals("clientes")? "clientes" : "vendedores");
        try {
            String consulta = "DELETE FROM " + tabla + " WHERE cedula = '"+cedula+"' ";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if(resp_consulta > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error Delete --> " + e.getMessage());
            return false;
        }
    }
    
    public boolean registrarProducto(int id, String nombre, int precio){
        String consulta = "INSERT into productos(id, nombre, precio) values ('"+id+"','"+nombre+"','"+precio+"')";
        try {
            int respuesta = manipularDB.executeUpdate(consulta);
            if(respuesta > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean modificarProducto(int id, String nombre, int precio){
        try {
            String consulta = "UPDATE productos SET nombre = '"+nombre+"',precio = '"+precio+"' WHERE id = '"+id+"' ";
            int resp_consulta = manipularDB.executeUpdate(consulta);
            if(resp_consulta > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println("--> Error update --> " + e.getMessage());
            return false;
        }
    }
    
    public ResultSet buscarProducto(int id){
        try {
            ResultSet productos = this.manipularDB.executeQuery("SELECT * FROM productos WHERE id = '"+id+"'");
            if(productos != null){
                productos.next();
            }
            return productos;
        } catch (SQLException e) {
            System.out.print("Error en busqueda --> " + e.getMessage());
            return null;
        }
    }
    
    public boolean eliminarProducto(int id){
        try {
            String consulta = "DELETE FROM productos WHERE id = '"+id+"' ";
            int resp_consulta = this.manipularDB.executeUpdate(consulta);
            if(resp_consulta > 0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error delete --> " + e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarProductos(){
        try {
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM productos");
            registros.next();
            return registros;
        } catch (SQLException e) {
            System.out.println("Error en SELECT --> " + e.getMessage());
            return null;
        }
    }
    
}
