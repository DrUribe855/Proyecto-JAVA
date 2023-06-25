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
    
    //Modulo platos

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
    
    public ResultSet listarMenu (){
        try{
            ResultSet registro_p = this.manipularDB.executeQuery("SELECT * FROM platos");
            registro_p.next();
            return registro_p;
        }catch(SQLException e){
            System.out.println("Error en SELECT" + e.getMessage());
            return null;
            
        }
    }
    
    //Modulo mesas
    
    public boolean registrarMesas(int mesas) {
        try {
            boolean exito = true; // Variable para verificar si se insertaron correctamente todos los elementos

            // Obtener la cantidad actual de mesas en la base de datos
            // esto se encarga de contar la cantidad de filas de la base de datos parapoder hacer la eliminacion de la base de datos 
            String consultaCantidad = "SELECT COUNT(*) FROM mesas";
            ResultSet resultadoCantidad = manipularDB.executeQuery(consultaCantidad);
            resultadoCantidad.next();
            int cantidadActual = resultadoCantidad.getInt(1);
            resultadoCantidad.close();

            // Eliminar las mesas que exceden la cantidad actual
            if (mesas < cantidadActual) {
                //int mesasEliminar = cantidadActual - mesas;
                String consultaEliminacion = "DELETE FROM mesas WHERE id > " + mesas;
                int respuestaEliminacion = manipularDB.executeUpdate(consultaEliminacion);
                if (respuestaEliminacion > 0) {
                    System.out.println("Se eliminaron " + respuestaEliminacion + " mesas de la base de datos.");
                }
            }

            // Insertar las nuevas mesas
            for (int i = cantidadActual + 1; i <= mesas; i++) {
                int indice = i;
                // Validar si el valor ya está registrado en la base de datos
                
                String consultaValidacion = "SELECT id FROM mesas WHERE id = " + indice;
                ResultSet resultado = manipularDB.executeQuery(consultaValidacion);
                if (resultado.next()) {
                    System.out.println("El valor " + indice + " ya está registrado en la base de datos. No se realizará la inserción.");
                    continue; // Pasar al siguiente índice sin realizar la inserción
                }

                // Realizar la inserción en la base de datos
                String consultaInsercion = "INSERT INTO mesas (id) VALUES (" + indice + ")";
                int respuesta = manipularDB.executeUpdate(consultaInsercion);

                if (respuesta <= 0) {
                    exito = false; // Si no se insertó correctamente, se actualiza la variable exito a false
                } else {
                    System.out.println("Índice insertado correctamente: " + indice);
                }
            }
            return exito; // Se retorna el valor final de exito
        } catch (SQLException e) {
            System.out.println("Error al insertar los elementos del arreglo: " + e.getMessage());
            return false; // En caso de excepción, se retorna false
        }
    }
    
    public int obtenerIdMesaPedidoActiva(int numeroMesa) {
        int idMesaPedidoActiva = -1; // Valor predeterminado en caso de no encontrar un pedido activo

        try {
            String consulta = "SELECT id FROM mesapedido WHERE id_mesa = " + numeroMesa + " AND estado = 'activo'";
            ResultSet resultado = manipularDB.executeQuery(consulta);

            if (resultado.next()) {
                idMesaPedidoActiva = resultado.getInt("id");
            }

            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del pedido activo: " + e.getMessage());
        }

        return idMesaPedidoActiva;
    }
    
    public boolean insertarMesaPedido(int id_mesa, String fecha, double total, String estado) {
        try {
            // Verificar si ya existe un pedido activo para la mesa
            String consultaExistencia = "SELECT COUNT(*) FROM mesapedido WHERE id_mesa = " + id_mesa + " AND estado = 'activo'";
            ResultSet resultadoExistencia = manipularDB.executeQuery(consultaExistencia);
            resultadoExistencia.next();
            int cantidadPedidosActivos = resultadoExistencia.getInt(1);
            resultadoExistencia.close();

            if (cantidadPedidosActivos > 0) {
                // Actualizar el total del pedido existente
                String consultaActualizacion = "UPDATE mesapedido SET total = " + total + " WHERE id_mesa = " + id_mesa + " AND estado = 'activo'";
                int respuestaActualizacion = manipularDB.executeUpdate(consultaActualizacion);
                if (respuestaActualizacion > 0) {
                    System.out.println("Se actualizó el total del pedido para la mesa " + id_mesa + ".");
                    return true;
                } else {
                    System.out.println("No se pudo actualizar el total del pedido para la mesa " + id_mesa + ".");
                    return false;
                }
            }

            // Insertar el nuevo pedido en la base de datos
            String consultaInsercion = "INSERT INTO mesapedido (id_mesa, fecha, total, estado) VALUES ('" + id_mesa + "', '" + fecha + "', '" + total + "', '" + estado + "')";
            int respuestaInsercion = manipularDB.executeUpdate(consultaInsercion);

            if (respuestaInsercion > 0) {
                System.out.println("REGISTRO MESA PEDIDO EXITOSO");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR: " + e.getMessage());
            return false;
        }
    }

}


