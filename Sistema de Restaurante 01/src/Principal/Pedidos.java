package Principal;

import Clases.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Pedidos extends javax.swing.JFrame {

    private Sala Pedido;
    private int pedido_mesa;
    private JLabel etqTemporal;
    int posicion = 0;
    private double total_final=0;

    public Pedidos(Sala Pedido, int pedido_mesa) {
        this.Pedido = Pedido;
        this.pedido_mesa = pedido_mesa;
        initComponents();
        initAlternComponents();
    }

    // agregamos el initalternat 
    public void initAlternComponents() {
        setLocationRelativeTo(null);
        numeroMesa.setText("MESA #" + this.pedido_mesa);
        // le damos un color bonito a el scrool para que se vea 
        pedidos.setLayout(new BoxLayout(pedidos, BoxLayout.Y_AXIS));
        pedidos.setBackground(Color.WHITE);
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

    }

    // aqui hacemos la busqueda del producto en especifico
    public void buscarPlato() {
        String platos = plato.getText().trim(); // Eliminar los espacios en blanco al principio y al final

        for (int i = 0; i < this.Pedido.platos.length; i++) {
            String plato = this.Pedido.platos[i].getNombre().trim(); // Eliminar los espacios en blanco al principio y al final del nombre del plato

            if (plato != null && plato.equalsIgnoreCase(platos)) {
                //System.out.println("El plato existe");
                habilitarInput(this.cantPlatos);
                this.tpPlato.setText(platos);
                return; // Terminar el bucle si se encuentra el plato
            } else {
                deshabilitarInput(this.cantPlatos);
            }
        }

        //System.out.println("El plato buscado no existe");
    }

    
    // TOCA CORREGIR QUE SI INGRESA UNA LETRA NO LO DEJE PARA QUE NO  NOS DE ERROR Y NOS DAÑE EL CODIGO QUE TENEMOS 
    public void agregarPlato() {
        String plato = this.tpPlato.getText();
        String cantidad = this.cantPlatos.getText();

        if (!cantidad.isEmpty()) {
            int cantidadT = Integer.parseInt(cantidad);
            for (int i = 0; i < this.Pedido.platos.length; i++) {
                if (this.Pedido.platos[i].getNombre().equalsIgnoreCase(plato) && this.Pedido.platos[i] != null) {
                    double precio = this.Pedido.platos[i].getPrecio();

                    if (cantidadT <= 0) {
                        System.out.println("NO SE PUEDE AGREGAR PEDIDOS PORQUE LA CANTIDAD ES IGUAL A CERO");
                    } else {
                        double subtotal = cantidadT * precio;
                        //aqui empesamos a sumar el total de los pediodos que valla haciendo
                        total_final+=subtotal;
                        etqTemporal = new JLabel("PLATO: " + this.Pedido.platos[i].getNombre() + " | CANTIDAD-PLATOS: " + cantidad + " | SUBTOTAL: " + subtotal);
                        // creamo una instancia de la clase p para guadarlo en la matrix
                        MesaP temporal_p = new MesaP(this.pedido_mesa, this.Pedido.platos[i].getNombre(), cantidadT, subtotal);
                        // mostramos esto en detalles de pedidos
                        this.Pedido.pedidos_mesas[this.pedido_mesa][posicion] = temporal_p;

                        JPopupMenu.Separator separador = new JPopupMenu.Separator();
                        pedidos.add(separador);
                        pedidos.add(etqTemporal);
                        revalidate();
                        break;
                    }
                }
            }
            posicion++;
        } else {
            System.out.println("LA CANTIDAD DE PLATOS NO PUEDE ESTAR VACÍA");
        }
        mostrarPedidos(this.pedido_mesa);
    }

    public void mostrarPedidos(int mesa) {
        if (this.Pedido.pedidos_mesas != null && mesa >= 0 && mesa < this.Pedido.pedidos_mesas.length) {
            System.out.println("Mesa: " + mesa);
            for (int j = 0; j < this.Pedido.pedidos_mesas[mesa].length; j++) {
                MesaP pedido = this.Pedido.pedidos_mesas[mesa][j];
                if (pedido != null) {
                    System.out.println("ID de la factura: " + pedido.getIdFactura());
                    System.out.println("Numero de Pedido:" + j);
                    System.out.println("Nombre del plato: " + pedido.getNombrePlato());
                    System.out.println("Cantidad de platos: " + pedido.getCantidadPlatos());
                    System.out.println("Subtotal: " + pedido.getSubtotal());
                    System.out.println("--------------------");
                }
            }
            // aqui mostramos tambien el total de la compra que valla el agregando
            this.total.setText(Double.toString(total_final));
        } else {
            System.out.println("No hay pedidos para la mesa especificada.");
        }
    }

    //creamo el metodo para habilitar y desablitar los inputs
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
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidos = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        numeroMesa.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        numeroMesa.setForeground(new java.awt.Color(255, 255, 255));
        numeroMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sala.png"))); // NOI18N
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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        ventanaPedidos.setBackground(new java.awt.Color(173, 216, 230));

        btn_volver.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_volver.setText("CANCELAR P");
        btn_volver.setFocusPainted(false);

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabel1.setText("PLATO:");

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabel2.setText("CARTA:");

        javax.swing.GroupLayout pedidosLayout = new javax.swing.GroupLayout(pedidos);
        pedidos.setLayout(pedidosLayout);
        pedidosLayout.setHorizontalGroup(
            pedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );
        pedidosLayout.setVerticalGroup(
            pedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pedidos);

        jButton1.setBackground(new java.awt.Color(204, 51, 0));
        jButton1.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AGREGAR");
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
        btn_volver1.setFocusPainted(false);

        btn_volver2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        btn_volver2.setText("VOLVER");
        btn_volver2.setFocusPainted(false);
        btn_volver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel5.setText("TOTAL:");

        total.setEditable(false);

        javax.swing.GroupLayout ventanaPedidosLayout = new javax.swing.GroupLayout(ventanaPedidos);
        ventanaPedidos.setLayout(ventanaPedidosLayout);
        ventanaPedidosLayout.setHorizontalGroup(
            ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPedidosLayout.createSequentialGroup()
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPedidosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(ventanaPedidosLayout.createSequentialGroup()
                        .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(jLabel4))
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
                                    .addComponent(btn_volver1))))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
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
        setVisible(false);
        //setVisible(false);
    }//GEN-LAST:event_btn_volver2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // aqui va el codigo de agregar el producto a el scrrol y hacer que la mesa esta ocupado e el caso que tenga algo ya pedido 
        agregarPlato();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numeroMesa;
    private javax.swing.JPanel pedidos;
    private javax.swing.JTextField plato;
    private javax.swing.JTextField total;
    private javax.swing.JTextField tpPlato;
    private javax.swing.JPanel ventanaPedidos;
    // End of variables declaration//GEN-END:variables
}
