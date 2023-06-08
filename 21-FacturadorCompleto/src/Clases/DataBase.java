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
    // falta por terminar no se que buscar en la fatura para relacionarlo en  la tabla pivote
     public Persona buscarFactura(String cedula_cliente){
        Persona temp = null;
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM vendedores WHERE cedula='"+cedula_cliente+"' ");
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
     
    public boolean insertarFactura(int cedula_cliente, int cedula_vendedor,String fecha,int total){
        String consulta= "INSERT INTO facturas(cedula_cliente,cedula_vendedor,fecha,total) VALUES ('"+cedula_cliente +"','"+cedula_vendedor+"','"+fecha +"','"+total+"') ";
        try{
           int respuesta=manipularDB.executeUpdate(consulta);
           if(respuesta>0){
               System.out.println("REGISTRO DE FACTURA CON EXITO");
               return true;
           }else{
               return false;
           }
        }catch(SQLException e){
            System.out.println("ERROR AL INSERTAR:"+ e.getMessage());
            return false;
        }
    }
    
    public boolean insertarItemFactura(String idFactura, String idProducto, String cantidad, String subtotal){
        String consulta= "INSERT INTO items_factura(id_factura,id_producto,cantidad,subtotal) VALUES ('"+idFactura +"','"+idProducto+"','"+cantidad +"','"+subtotal+"')";
        try{
           int respuesta=manipularDB.executeUpdate(consulta);
           if(respuesta>0){
               System.out.println("REGISTRO DE ITEM CON EXITO");
               return true;
           }else{
               return false;
           }
        }catch(SQLException e){
            System.out.println("ERROR AL INSERTAR:"+ e.getMessage());
            return false;
        }
    }
    
    public String getIdFactura(int cedula_cliente, int cedula_vendedor,String fecha,int total){
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM facturas WHERE cedula_cliente='"+cedula_cliente+"' AND cedula_vendedor='"+cedula_vendedor+"' AND fecha='"+fecha+"' AND total='"+total+"' ");
            registros.next();
            if (registros.getRow()==1) {
                return registros.getString("id");
            }
            return null;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return null;
        }
    }
    
    // registrar producto xd
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
    
    public Producto consultarProducto(String id){
        Producto temp_p=null;
        try{
            ResultSet registro_p=this.manipularDB.executeQuery("SELECT * FROM productos WHERE  id='"+id+"'");
            registro_p.next();
            if(registro_p.getRow()==1){
                temp_p=new Producto(registro_p.getInt("id"),registro_p.getString("nombre"),registro_p.getInt("precio") );
            }
            return temp_p;
        }catch(SQLException e){
            System.out.println("ERROR EN SELECT"+e.getMessage());
            return temp_p;
        }
    }
    public ListaFacturas[] listaFacturas(){
        ListaFacturas [] facturas  = new ListaFacturas [100];
        try{
            ResultSet registros = this.manipularDB.executeQuery("SELECT * FROM facturas");
            registros.next();
            if (registros.getRow()==1) {
                int indice = 0;
                do{
                    ListaFacturas  temp = new ListaFacturas( registros.getInt("cedula_cliente"),registros.getInt("cedula_vendedor"), registros.getInt("id"), registros.getString("fecha"), registros.getInt("total") );
                    facturas[indice] = temp;
                    indice++;
                }while(registros.next());
            }
            return facturas;
        }catch(SQLException e){
            System.out.println("Error en SELECT: "+e.getMessage());
            return facturas;
        }
    }
    
}
