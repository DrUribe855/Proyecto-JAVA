 
package Principal;

import Clases.*;
import ModuloMesas.InterfazMesas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class Pedidos extends javax.swing.JFrame {
    
    private InterfazMesas pedido;
    private int pedido_mesa;
    private JLabel etqTemporal;
    int posicion = 0;
    private double total_final = 0;
    private String estado = "activo";
   
    public Pedidos(InterfazMesas pedido, int pedido_mesa) {
        this.pedido = pedido;
        this.pedido_mesa = pedido_mesa;
        initComponents();
        initAlternComponents();
    }
    
    public void initAlternComponents(){
        setLocationRelativeTo(null);
        numeroMesa.setText("MESA #" + (this.pedido_mesa + 1));
        // le damos un color bonito a el scrool para que se vea 
        pedidos.setLayout(new BoxLayout(pedidos, BoxLayout.Y_AXIS));
        pedidos.setBackground(Color.WHITE);
        // creamo el evento para agregarselo al input 
        KeyListener eventoKeyBuscarProducto = new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                String texto = campoCodigo.getText();
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
        this.campoCodigo.addKeyListener(eventoKeyBuscarProducto);

    }
    
    public void buscarPlato() {
        String codigo = campoCodigo.getText().trim();
        // Eliminar los espacios en blanco al principio y al final
        try {
            ResultSet platos_t = (this.pedido.database.buscarMenu(codigo));

        if (platos_t != null) {
            //System.out.println("El plato existe");
            habilitarInput(this.cantPlatos);
            this.tpPlato.setText(platos_t.getString("nombre"));
            return; // Terminar el bucle si se encuentra el plato
        } else {
            deshabilitarInput(this.cantPlatos);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
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
        campoCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cantPlatos = new javax.swing.JTextField();
        tpPlato = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_volver1 = new javax.swing.JButton();
        btn_volver2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        numeroMesa.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        numeroMesa.setForeground(new java.awt.Color(255, 255, 255));
        numeroMesa.setText("MESA #");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(numeroMesa)
                .addContainerGap(256, Short.MAX_VALUE))
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
        jLabel2.setText("CÓDIGO");

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
                                .addGap(0, 370, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(jLabel4))
                                .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                    .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPedidosLayout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                            .addGap(31, 31, 31)
                                            .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1))
                                            .addGap(18, 18, 18)))
                                    .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                            .addComponent(cantPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButton1))
                                        .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(campoCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                            .addComponent(tpPlato, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGroup(ventanaPedidosLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(btn_volver2)
                                    .addGap(35, 35, 35)
                                    .addComponent(btn_volver)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_volver1))))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ventanaPedidosLayout.setVerticalGroup(
            ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPedidosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(ventanaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // aqui va el codigo de agregar el producto a el scrrol y hacer que la mesa esta ocupado e el caso que tenga algo ya pedido
        //agregarPlato();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver2ActionPerformed
        // AQUI VA EL CODIGO DE DEVOLVER A LA PAGINA ANTERIOR
        //Pedido.setVisible(true);
        dispose();
        //setVisible(false);
    }//GEN-LAST:event_btn_volver2ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton btn_volver1;
    private javax.swing.JButton btn_volver2;
    private javax.swing.JTextField campoCodigo;
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
    private javax.swing.JTextField total;
    private javax.swing.JTextField tpPlato;
    private javax.swing.JPanel ventanaPedidos;
    // End of variables declaration//GEN-END:variables
}
