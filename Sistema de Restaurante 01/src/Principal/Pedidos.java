package Principal;

import Clases.*;
import ModuloMesas.InterfazMesas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Pedidos extends javax.swing.JFrame {

    private InterfazMesas Pedido;
    private int pedido_mesa;
    private JLabel etqTemporal;
    int posicion = 0;
    private double total_final = 0;
    private String estado = "activo";
    private DefaultTableModel modelo;
    // este es el id de mesa pedido de la base de datos

    public Pedidos(InterfazMesas Pedido, int pedido_mesa) {
        this.Pedido = Pedido;
        this.pedido_mesa = pedido_mesa;
        initComponents();
        initAlternComponents();

        cargarDatosPrevios();
    }

    // agregamos el initalternat 
    public void initAlternComponents() {
        setLocationRelativeTo(null);
        numeroMesa.setText("MESA #" + (this.pedido_mesa + 1));
        // creamo el evento para agregarselo al input 
        KeyListener eventoKeyBuscarProducto = new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                String texto = plato.getText();
                if (texto.equalsIgnoreCase("")) {
                    tpPlato.setText("");
                    cantPlatos.setText("");
                }

                if (e.getKeyCode() == 10) {
                    buscarPlato();
                } else if (e.getKeyCode() == 8) {
                    tpPlato.setText("");
                    cantPlatos.setText("");
                    deshabilitarInput(cantPlatos);
                    deshabilitarInput(tpPlato);
                } else if (e.getKeyCode() != 16) {
                    tpPlato.setText("");
                    cantPlatos.setText("");
                    deshabilitarInput(tpPlato);
                    deshabilitarInput(cantPlatos);
                    buscarPlato();
                }
            }

            public void keyTyped(KeyEvent e) {
            }
        };
        this.plato.addKeyListener(eventoKeyBuscarProducto);
        this.modelo = (DefaultTableModel) this.tablaItemsPedido.getModel();
    }

    // aqui hacemos la busqueda del producto en especifico
    public void buscarPlato() {
        String platos = plato.getText().trim();
// Eliminar los espacios en blanco al principio y al final
        Plato platos_t = (this.Pedido.database.consultarProducto(platos));

        if (platos_t != null) {
            //System.out.println("El plato existe");
            habilitarInput(this.cantPlatos);
            this.tpPlato.setText(platos_t.getNombre());
            this.cantPlatos.requestFocus();
            return; // Terminar el bucle si se encuentra el plato
        } else {
            deshabilitarInput(this.cantPlatos);
        }

    }

    public void agregarPlato() {
        String plato = this.tpPlato.getText();
        String cantidad = this.cantPlatos.getText();

        Plato platos = this.Pedido.database.consultarProducto(plato);

        if (!plato.equals("") && !cantidad.isEmpty() && platos != null) {
            // AQUI AGREGAMOS LA MESA PEDIDO DE DICHA MESA
            // creamos la fecha 

            Date fechaHoraActual = new Date();
            // Crear un formato para la fecha y la hora
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Formatear la fecha y la hora actual utilizando el formato
            String fechaHoraFormateada = formato.format(fechaHoraActual);
            // Guardar la fecha y la hora formateada en una variable de tipo String
            String fechaHoraString = fechaHoraFormateada;

            // agregamos el estado 
            this.Pedido.database.insertarMesaPedido((pedido_mesa + 1), fechaHoraString, total_final, this.estado);

            // CREAMOS EL PLATO 
            if (validarNumero(cantidad) == true) {
                int cantidadT = Integer.parseInt(cantidad);
                double precio = platos.getPrecio();
                double subtotal;
                if (cantidadT <= 0) {
                    System.out.println("NO SE PUEDE AGREGAR PEDIDOS PORQUE LA CANTIDAD ES IGUAL A CERO");
                    return; // Agregar esta línea para finalizar la ejecución del método
                } else {
                    // Obtener el total actual del pedido activo
                    int idMesaPedido = this.Pedido.database.obtenerIdMesaPedidoActiva(pedido_mesa + 1);
                    System.out.println("ID DE MESA PEDIDO: " + idMesaPedido);
                    if (idMesaPedido != -1) {
                        // Hay un pedido activo para la mesa, obtener el total actual
                        double totalActual = this.Pedido.database.obtenerTotalMesaPedido(idMesaPedido);
                        subtotal = cantidadT * precio;
                        double nuevoTotal = totalActual + subtotal;
                        System.out.println("Nuevo Total:" + nuevoTotal);
                        System.out.println("el subtotal es:" + subtotal);
                        // Actualizar el total en la base de datos
                        boolean actualizacionExitosa = this.Pedido.database.actualizarTotalMesaPedido(pedido_mesa + 1, nuevoTotal);

                        if (actualizacionExitosa) {
                            System.out.println("Se actualizó el total del pedido para la mesa porq" + (pedido_mesa + 1) + ".");
                        } else {
                            System.out.println("No se pudo actualizar el total del pedido para la mesa " + (pedido_mesa + 1) + ".");
                        }

                        total_final = nuevoTotal;
                    } else {
                        // No hay un pedido activo para la mesa, crear uno nuevo

                        subtotal = cantidadT * precio;
                        total_final += subtotal; // Actualizar el total con el subtotal del nuevo plato
                    }

                    etqTemporal = new JLabel("PLATO: " + platos.getNombre() + " | CANTIDAD-PLATOS: " + cantidad + " | SUBTOTAL: " + subtotal);
                    // creamo una instancia de la clase p para guadarlo en la matrix
                    MesaP temporal_p = new MesaP(this.pedido_mesa, platos.getNombre(), cantidadT, subtotal, Integer.parseInt(platos.getCodigo()));
                    // mostramos esto en detalles de pedidos
                    this.Pedido.pedidos_mesas[this.pedido_mesa][posicion] = temporal_p;

                    // aqui guadarmos los items del pedidos dependiendo si el pedido esta activo 
                    if (idMesaPedido != -1) {
                        this.Pedido.database.insertarItemPedido(idMesaPedido, Integer.parseInt(platos.getCodigo()), cantidadT, subtotal);
                    }
                    this.total.setText(Double.toString(total_final));

                    Object[] nuevoItem = new Object[]{Integer.parseInt(platos.getCodigo()), platos.getNombre(), platos.getPrecio(), cantidad, subtotal};
                    this.modelo.addRow(nuevoItem);
                    revalidate();
                }
                posicion++;

            } else {
                System.out.println("El VALOR INGRESADO NO ES UN NÚMERO");
                return; // Agregar esta línea para finalizar la ejecución del método
            }
        } else {
            System.out.println("LA CANTIDAD DE PLATOS NO PUEDE ESTAR VACÍA");
            return; // Agregar esta línea para finalizar la ejecución del método
        }

        //lo comente ya que no lo 
        //mostrarPedidos(this.pedido_mesa);
        // esto es para actulizar el color de la mesa a libre
        Pedido.verificarEstadoMesa(pedido_mesa + 1);
    }

    /// metodo para agregar total a la base de datos si es
    // metodo para validar si es un numero
    public boolean validarNumero(String texto) {
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            int codigo = (int) texto.charAt(i);
            if ((codigo < 48 || codigo > 57) && codigo != 44 && codigo != 45 && codigo != 46) {
                return false;
            }
            if (codigo == 44 || codigo == 46) {
                contador++;
            }
        }
        return (contador <= 1);
    }

    //esto lo comente ya que solo era para ver lo que llegaba en consola
    /*
    public void mostrarPedidos(int mesa) {
        if (this.Pedido.pedidos_mesas != null && mesa >= 0 && mesa < this.Pedido.pedidos_mesas.length) {
            System.out.println("Mesa: " + mesa);
            for (int j = 0; j < this.Pedido.pedidos_mesas[mesa].length; j++) {
                MesaP pedido = this.Pedido.pedidos_mesas[mesa][j];
                if (pedido != null) {
                    System.out.println("ID de la factura: " + pedido.getIdFactura());
                    System.out.println("Identificador del plato:" + pedido.getIdentificador());
                    System.out.println("Numero de Pedido:" + j);
                    System.out.println("Nombre del plato: " + pedido.getNombrePlato());
                    System.out.println("Cantidad de platos: " + pedido.getCantidadPlatos());
                    System.out.println("Subtotal: " + pedido.getSubtotal());
                    System.out.println("--------------------");
                }
            }
            // aqui mostramos tambien el total de la compra que valla el agregando
            //this.total.setText(Double.toString(total_final));
        } else {
            System.out.println("No hay pedidos para la mesa especificada.");
        }
    }
     */
    // metodo para cargar los datos previso si tiene de la base de datos
    private void cargarDatosPrevios() {
        int idMesaPedido = this.Pedido.database.obtenerIdMesaPedidoActiva(pedido_mesa + 1);
        total_final = (idMesaPedido != -1) ? this.Pedido.database.obtenerTotalMesaPedido(idMesaPedido) : 0;
        this.total.setText(String.valueOf(total_final));

        ResultSet listaItems = this.Pedido.database.getListaItems(idMesaPedido);
        if (listaItems != null) {
            try {
                this.modelo.setRowCount(0);
                do {
                    Object[] nuevoItem = new Object[]{listaItems.getString("codigo"), listaItems.getString("nombre"), listaItems.getString("precio"), listaItems.getString("cantidad"), listaItems.getString("subtotal")};
                    this.modelo.addRow(nuevoItem);
                } while (listaItems.next());
            } catch (SQLException ex) {
                System.out.println("Erro al extraer los datos: " + ex.getMessage());
            }
        }
    }

    public void cancelarPedido() {
        // cambiamos el estado de la mesa pedido a cancelado en el caso que cancele la factura 
        this.estado = "cancelado";
        int idMesaPedido = this.Pedido.database.obtenerIdMesaPedidoActiva(pedido_mesa + 1);
        if (idMesaPedido != -1) {
            // ahora cambiamos el estado de la mesa en el caso que se encuentre activa 

            // llamamos el metodo para cambiar el estado de la mesa 
            boolean uptadeEstadoExitoso = this.Pedido.database.actulizarEstadoPedido(idMesaPedido, estado);
            if (uptadeEstadoExitoso) {
                System.out.println("SE A CANCELADO EL PEDIDO CON EXITO");
                this.Pedido.verificarEstadoMesa(pedido_mesa + 1);
            } else {
                System.out.println("ERROR AL CANCELAR EL PEDIDO DE LA MESA" + idMesaPedido);
            }
        }
    }

    // metodo para confirmar el pago de la factura
    public void confimarFactura() {
        // cabiamos el estado de la factura pagada
        this.estado = "pagado";
        int idMesaPedido = this.Pedido.database.obtenerIdMesaPedidoActiva(pedido_mesa + 1);
        // fecha para guadar en la base de datos con la hora de confirmacion del pago 
        Date fechaHoraActual = new Date();
        // Crear un formato para la fecha y la hora
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Formatear la fecha y la hora actual utilizando el formato
        String fechaHoraFormateada = formato.format(fechaHoraActual);
        // Guardar la fecha y la hora formateada en una variable de tipo String
        String fecha = fechaHoraFormateada;
        if (idMesaPedido != -1) {
            // ahora cambiamos el estado de la mesa en el caso que se encuentre activa 

            // llamamos el metodo para cambiar el estado de la mesa 
            boolean uptadeEstadoExitoso = this.Pedido.database.actulizarEstadoPedido(idMesaPedido, estado);
            if (uptadeEstadoExitoso) {
                boolean exitoso = this.Pedido.database.insertarFacturaMesaPedido(fecha, idMesaPedido);
                if (exitoso) {
                    System.out.println("PAGO EXITOSO");
                } else {
                    System.out.println("SE A PAGADO LA FACTURA CON EXITO");

                }
                this.Pedido.verificarEstadoMesa(pedido_mesa + 1);
            } else {
                System.out.println("ERROR EL LA FACTURA NO SE PUDO ACTULIZAR EL ESTADO :" + idMesaPedido);
            }
        }

    }

    //creamos el metodo para habilitar y desablitar los inputs
    public void deshabilitarInput(JTextField input) {
        input.setEditable(false);
        input.setEnabled(false);
        input.setDisabledTextColor(Color.black);
    }

    public void habilitarInput(JTextField input) {
        input.setText("");
        input.setEditable(true);
        input.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        numeroMesa = new javax.swing.JLabel();
        ventanaPedidos = new javax.swing.JPanel();
        btn_volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        plato = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cantPlatos = new javax.swing.JTextField();
        tpPlato = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_volver1 = new javax.swing.JButton();
        btn_volver2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaItemsPedido = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        numeroMesa.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        numeroMesa.setForeground(new java.awt.Color(255, 255, 255));
        numeroMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sala.png"))); // NOI18N
        numeroMesa.setText("MESA #");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(numeroMesa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(numeroMesa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ventanaPedidos.setBackground(new java.awt.Color(173, 216, 230));

        btn_volver.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_volver.setText("CANCELAR P");
        btn_volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_volver.setFocusPainted(false);
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabel1.setText("PLATO:");

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabel2.setText("CARTA:");

        jButton1.setBackground(new java.awt.Color(51, 204, 255));
        jButton1.setFont(new java.awt.Font("NSimSun", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("AGREGAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cantPlatos.setEnabled(false);

        tpPlato.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabel3.setText("CANTIDAD:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel4.setText("PEDIDOS:");

        btn_volver1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_volver1.setText("FACTURAR");
        btn_volver1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_volver1.setFocusPainted(false);
        btn_volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver1ActionPerformed(evt);
            }
        });

        btn_volver2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_volver2.setText("VOLVER");
        btn_volver2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_volver2.setFocusPainted(false);
        btn_volver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel5.setText("TOTAL:");

        total.setEditable(false);

        tablaItemsPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Cantidad", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaItemsPedido);

        javax.swing.GroupLayout ventanaPedidosLayout = new javax.swing.GroupLayout(ventanaPedidos);
        ventanaPedidos.setLayout(ventanaPedidosLayout);
        ventanaPedidosLayout.setHorizontalGroup(
            ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPedidosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ventanaPedidosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ventanaPedidosLayout.createSequentialGroup()
                            .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                    .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                            .addGap(31, 31, 31)
                                            .addComponent(jLabel1))
                                        .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                            .addGap(43, 43, 43)
                                            .addComponent(jLabel2)))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPedidosLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                    .addComponent(cantPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1))
                                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(plato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(tpPlato, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGroup(ventanaPedidosLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(btn_volver2)
                            .addGap(35, 35, 35)
                            .addComponent(btn_volver)
                            .addGap(18, 18, 18)
                            .addComponent(btn_volver1))
                        .addGroup(ventanaPedidosLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel4))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        ventanaPedidosLayout.setVerticalGroup(
            ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPedidosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(plato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tpPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver2)
                    .addComponent(btn_volver)
                    .addComponent(btn_volver1))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ventanaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventanaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver2ActionPerformed
        // AQUI VA EL CODIGO DE DEVOLVER A LA PAGINA ANTERIOR 
        Pedido.setVisible(true);
        dispose();
        //setVisible(false);
    }//GEN-LAST:event_btn_volver2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // aqui va el codigo de agregar el producto a el scrrol y hacer que la mesa esta ocupado e el caso que tenga algo ya pedido 
        agregarPlato();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // aqui va el codigo para cancelar el pedido en el caso que el usuario no desee pedir nada al final
        int idMesaPedido = this.Pedido.database.obtenerIdMesaPedidoActiva(pedido_mesa + 1);
        if(idMesaPedido!=-1){
            cancelarPedido();
            Pedido.setVisible(true);
            dispose();
        }else{
            Alert alerta = new Alert("ERROR", "NO HAY PEDIDOS POR CANCELAR", "error");
        }
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver1ActionPerformed
        // aqui va el metodo par confirmal el pago de la compra
        confimarFactura();
        Pedido.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_volver1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton btn_volver1;
    private javax.swing.JButton btn_volver2;
    private javax.swing.JTextField cantPlatos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numeroMesa;
    private javax.swing.JTextField plato;
    private javax.swing.JTable tablaItemsPedido;
    private javax.swing.JTextField total;
    private javax.swing.JTextField tpPlato;
    private javax.swing.JPanel ventanaPedidos;
    // End of variables declaration//GEN-END:variables

}
