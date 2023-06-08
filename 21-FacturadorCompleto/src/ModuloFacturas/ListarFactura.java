package ModuloFacturas;

import Principal.Menu;
import Clases.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ListarFactura extends javax.swing.JFrame {

    Menu ventanaMenu;
    private JLabel etqTemporal;
    private JButton boton;
    private int posicion;

    public ListarFactura(Menu ventanaMenu) {
        this.ventanaMenu = ventanaMenu;

        initComponents();
        initAlternComponents();

    }

    public void initAlternComponents() {
        setLocationRelativeTo(null);
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_almacenes.png")));
        imprimirProductos();
        listaFactura.setLayout(new BoxLayout(listaFactura, BoxLayout.Y_AXIS));
        listaFactura.setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaFactura = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_atras = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("LISTA DE FACTURAS");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Listado Facturas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        listaFactura.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout listaFacturaLayout = new javax.swing.GroupLayout(listaFactura);
        listaFactura.setLayout(listaFacturaLayout);
        listaFacturaLayout.setHorizontalGroup(
            listaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        listaFacturaLayout.setVerticalGroup(
            listaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listaFactura);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("LISTADO DE FACTURAS");

        btn_atras.setBackground(new java.awt.Color(51, 51, 255));
        btn_atras.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btn_atras.setText("VOLVER");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btn_atras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(btn_atras)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.ventanaMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_atrasActionPerformed

    public void abrirVentana(int i) {
        setVisible(false);
        Detalles ventana = new Detalles(this, i,this.ventanaMenu);
        ventana.setVisible(true);
        this.setVisible(false);
    }

    public void imprimirProductos() {
        ListaFacturas facturas[] = (this.ventanaMenu.database.listaFacturas());
        if (facturas != null) {
            for (int i = 0; i < facturas.length; i++) {
                if (facturas[i] != null) {
                    etqTemporal = new JLabel(facturas[i].getCedula_cliente() + " - " + facturas[i].getCedula_vendedor() + " " + facturas[i].getTotal());
                    etqTemporal.setFont(new Font("Arial", Font.PLAIN, 12));
                    etqTemporal.setBorder(new EmptyBorder(2, 10, 2, 10));
                    listaFactura.add(etqTemporal);
                    //agreamos el boton de detalles para mostrarle todo
                    boton = new JButton("Ver detalle");
                    listaFactura.add(boton);

                    int lugar = i;
                    ActionListener verDetalle = new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            
                            abrirVentana(lugar);
                        }
                    };
                    if (facturas[i] != null) {
                        boton.addActionListener(verDetalle);

                    }

                    JPopupMenu.Separator separador = new JPopupMenu.Separator();
                    listaFactura.add(separador);
                } else {
                    break;
                }
            }
            revalidate();
        }
    }

    public void setLocal(int posicion) {
        this.posicion = posicion;
    }

    public int getLocal() {
        return posicion;
    }
    /*
    for (int i = 0; i < this.facturas.length; i++) {
            if (this.facturas[i] != null) {
                JPopupMenu.Separator separador = new JPopupMenu.Separator();
                listaFactura.add(separador);
                boton = new JButton("Ver detalle");
                listaFactura.add(boton);
               
                int lugar=i;
                ActionListener verDetalle = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        abrirVentana(lugar);
                    }
                };
                if (this.facturas[i] != null) {
                    boton.addActionListener(verDetalle);

                }
                etqTemporal = new JLabel(i + " " + this.facturas[i].getNombre_cliente() + " - " + this.facturas[i].getNombre_vendedor() + " " + this.facturas[i].getNombre_p() + " " + this.facturas[i].getTotal());
                etqTemporal.setFont(new Font("Arial", Font.PLAIN, 12));
                etqTemporal.setBorder(new EmptyBorder(2, 10, 2, 10));
                listaFactura.add(etqTemporal);

            }
        }
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listaFactura;
    // End of variables declaration//GEN-END:variables
}
