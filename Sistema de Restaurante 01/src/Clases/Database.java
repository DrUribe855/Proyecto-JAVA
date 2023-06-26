package Clases;

// importamos la libreria para manipulacion de base de datos 
import com.mysql.cj.protocol.Resultset;
import java.sql.*;

public class Database {

    Statement baseDate;

    public Database() {
        String hostname = "localhost";
        String puerto = "3306";
        String database_name = "restaurante";
        String database_user = "root";
        String database_password = "";
        String url = "jdbc:mysql://" + hostname + ":" + puerto + "/" + database_name;

        try {
            Connection conexion = DriverManager.getConnection(url, database_user, database_password);
            this.baseDate = conexion.createStatement();
            System.out.println("Conexion Exitosa a: " + database_name);
        } catch (SQLException e) {
            System.out.println("Error en conexion: " + e.getMessage());
            this.baseDate = null;
        }
    }

    public boolean registrarProducto(int id, String nombre, int precio) {
        String consulta = "INSERT into productos(id, nombre, precio) values ('" + id + "','" + nombre + "','" + precio + "')";
        try {
            int respuesta = baseDate.executeUpdate(consulta);
            if (respuesta > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    public boolean registrarMesas(int mesas) {
        try {
            boolean exito = true; // Variable para verificar si se insertaron correctamente todos los elementos

            // Obtener la cantidad actual de mesas en la base de datos
            // esto se encarga de contar la cantidad de filas de la base de datos parapoder hacer la eliminacion de la base de datos 
            String consultaCantidad = "SELECT COUNT(*) FROM mesas";
            ResultSet resultadoCantidad = baseDate.executeQuery(consultaCantidad);
            resultadoCantidad.next();
            int cantidadActual = resultadoCantidad.getInt(1);
            resultadoCantidad.close();

            // Eliminar las mesas que exceden la cantidad actual
            if (mesas < cantidadActual) {
                int mesasEliminar = cantidadActual - mesas;
                String consultaEliminacion = "DELETE FROM mesas WHERE id > " + mesas;
                int respuestaEliminacion = baseDate.executeUpdate(consultaEliminacion);
                if (respuestaEliminacion > 0) {
                    System.out.println("Se eliminaron " + respuestaEliminacion + " mesas de la base de datos.");
                }
            }

            // Insertar las nuevas mesas
            for (int i = cantidadActual + 1; i <= mesas; i++) {
                int indice = i;
                // Validar si el valor ya está registrado en la base de datos
                
                String consultaValidacion = "SELECT id FROM mesas WHERE id = " + indice;
                ResultSet resultado = baseDate.executeQuery(consultaValidacion);
                if (resultado.next()) {
                    System.out.println("El valor " + indice + " ya está registrado en la base de datos. No se realizará la inserción.");
                    continue; // Pasar al siguiente índice sin realizar la inserción
                }

                // Realizar la inserción en la base de datos
                String consultaInsercion = "INSERT INTO mesas (id) VALUES (" + indice + ")";
                int respuesta = baseDate.executeUpdate(consultaInsercion);

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

    // creamo el metodo para consultar el plato que desea buscar 
    public Plato consultarProducto(String nombre) {
        Plato temp_p = null;
        try {
            ResultSet consulta_p = this.baseDate.executeQuery("SELECT * FROM platos WHERE  nombre='" + nombre + "'");
            consulta_p.next();
            if (consulta_p.getRow() == 1) {
                temp_p = new Plato(consulta_p.getInt("codigo"), consulta_p.getString("nombre"), consulta_p.getInt("precio"));
            }
            return temp_p;
        } catch (SQLException e) {
            System.out.println("ERROR EN SELECT" + e.getMessage());
            return temp_p;
        }
    }

    // ahora insertamos mesa pedidos
    public boolean insertarMesaPedido(int id_mesa, String fecha, double total, String estado) {
        try {
            // Verificar si ya existe un pedido activo para la mesa
            String consultaExistencia = "SELECT COUNT(*) FROM mesapedido WHERE id_mesa = " + id_mesa + " AND estado = 'activo'";
            ResultSet resultadoExistencia = baseDate.executeQuery(consultaExistencia);
            resultadoExistencia.next();
            int cantidadPedidosActivos = resultadoExistencia.getInt(1);
            resultadoExistencia.close();

            if (cantidadPedidosActivos > 0) {
                // Actualizar el total del pedido existente
                String consultaActualizacion = "UPDATE mesapedido SET total = " + total + " WHERE id_mesa = " + id_mesa + " AND estado = 'activo'";
                int respuestaActualizacion = baseDate.executeUpdate(consultaActualizacion);
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
            int respuestaInsercion = baseDate.executeUpdate(consultaInsercion);

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

    public int obtenerIdMesaPedidoActiva(int numeroMesa) {
        int idMesaPedidoActiva = -1; // Valor predeterminado en caso de no encontrar un pedido activo

        try {
            String consulta = "SELECT id FROM mesapedido WHERE id_mesa = " + numeroMesa + " AND estado = 'activo'";
            ResultSet resultado = baseDate.executeQuery(consulta);

            if (resultado.next()) {
                idMesaPedidoActiva = resultado.getInt("id");
            }

            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del pedido activo: " + e.getMessage());
        }

        return idMesaPedidoActiva;
    }

    // INSERTAMOS EN LA BASE DE DATOS LOS ITEMS DEL PEDIDO DEPENDIENDO DE LA MESA PEDIDO 
    public boolean insertarItemPedido(int id_mesa_pedido, int id_plato, int cantidad, double subtotal) {
        String consulta = "INSERT INTO items_pedido(id_mesa_pedido,id_plato,cantidad,subtotal) VALUES ('" + id_mesa_pedido + "','" + id_plato + "','" + cantidad + "','" + subtotal + "')";
        try {
            int respuesta = baseDate.executeUpdate(consulta);
            if (respuesta > 0) {
                System.out.println("REGISTRO DE ITEM CON EXITO");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL INSERTAR:" + e.getMessage());
            return false;
        }
    }

    // metodo para actualizar el metodo pedido 
    public boolean actualizarTotalMesaPedido(int idMesaPedido, double nuevoTotal) {
        try {
            String consultaActualizacion = "UPDATE mesapedido SET total = " + nuevoTotal + " WHERE id_mesa = " + idMesaPedido;
            int respuestaActualizacion = baseDate.executeUpdate(consultaActualizacion);
            if (respuestaActualizacion > 0) {
                System.out.println("Se actualizó el total del pedido con ID " + idMesaPedido + ".");
                return true;
            } else {
                System.out.println("No se pudo actualizar el total del pedido con ID " + idMesaPedido + ".");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR EL TOTAL DEL PEDIDO: " + e.getMessage());
            return false;
        }
    }

    // obtenemos el total de mesa pedido 
    public double obtenerTotalMesaPedido(int idMesaPedido) {
        try {
            String consulta = "SELECT total FROM mesapedido WHERE id = " + idMesaPedido;
            ResultSet resultado = baseDate.executeQuery(consulta);
            resultado.next();
            if (resultado.getRow()==1) {
                double total = Double.parseDouble(resultado.getString("total"));
                System.out.println("entro acá jijo - "+total);
                resultado.close();
                return total;
            } else {
                System.out.println("No se encontró el pedido con ID " + idMesaPedido + ".");
                resultado.close();
                return 0.0;
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL OBTENER EL TOTAL DEL PEDIDO: " + e.getMessage());
            return 0.0;
        }
    }

    public ResultSet getListaItems(int idMesaPedido) {
       try {
            String consulta = "SELECT * FROM items_pedido INNER JOIN platos ON items_pedido.id_plato = platos.codigo WHERE id_mesa_pedido = " + idMesaPedido;
            ResultSet resultado = baseDate.executeQuery(consulta);
            resultado.next();
            
            if (resultado.getRow()==1) {
                return resultado;
            } 
            
            return null;
        } catch (SQLException e) {
            System.out.println("ERROR AL OBTENER LOS ITEMS DEL PEDIDO: " + e.getMessage());
            return null;
        }
    }

}
