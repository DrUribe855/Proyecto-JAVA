package Principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Clases.*;

public class Sala extends javax.swing.JFrame {

    private int cant_mesas = 12;
    private JLabel estado[];
    private JButton mesas[];
    public Plato platos[];
    public MesaP pedidos_mesas[][];

    public Sala() {
        // mostramos la opcion de minizar la ventan y el logo de a ventana 
        this.platos = new Plato[10];
        initComponents();
        initAlterntComponents();
        this.pedidos_mesas = new MesaP[cant_mesas][100];

        // agregamos platos para probrar el pedido de cada mesa
        platos[0] = new Plato("Hamburguesa", 25000.0);
        platos[1] = new Plato("Pizza", 22000.0);
        platos[2] = new Plato("Ensalada", 18000.0);
        platos[3] = new Plato("Sushi", 35000.0);
        platos[4] = new Plato("Pasta", 28000.0);
        platos[5] = new Plato("Tacos", 19000.0);
        platos[6] = new Plato("Arroz con pollo", 20000.0);
        platos[7] = new Plato("Ceviche", 24000.0);
        platos[8] = new Plato("Sopa de lentejas", 15000.0);
        platos[9] = new Plato("Empanadas", 12000.0);

    }

    public void initAlterntComponents() {
        // Agregar propiedades al panel
        JpanelMesas.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("img/portada.png")));
        JpanelMesas.setLayout(new GridLayout(0, 4, 10, 10)); // 5 columnas con margen de 10 píxeles
        JpanelMesas.setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        agregarMesas();
    }

    // aqui abrimos la ventana del pediodo del cliente 
    public void abrirVentanaPedido(int i) {
        setVisible(false);

        Pedidos ventana = new Pedidos(this, i);
        ventana.setVisible(true);

    }

    public void agregarMesas() {

        //creamos un evento para que lo mande a otra ventana para que pueda pedir su orden 
        mesas = new JButton[cant_mesas];
        estado = new JLabel[cant_mesas];
        for (int i = 0; i < cant_mesas; i++) {
            mesas[i] = new JButton("Mesa#" + (i + 1));
            mesas[i].setFont(new Font("Georgia", Font.BOLD, 25));
            Color verdeOscuro = new Color(46, 139, 87);
            mesas[i].setBackground(verdeOscuro);
            mesas[i].setForeground(Color.WHITE);
            // color rgb para cuando la mes esta ocupada 255, 99, 71
            // Cargar la imagen y establecerla como el ícono del botón
            mesas[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/mesa.png")));
            //ImageIcon icono = new ImageIcon("/img/mesa.png");
            //mesas[i].setIcon(icono);

            mesas[i].setHorizontalTextPosition(SwingConstants.CENTER);
            mesas[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            // Desactivar el enfoque del botón
            mesas[i].setFocusPainted(false);
            // Cambiar el cursor al pasar el ratón sobre el botón
            mesas[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            // agregamo el evento a todos lo botones 
            int numeroDeMesa = (i + 1);
            ActionListener abrirPedido = new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    abrirVentanaPedido(numeroDeMesa);
                }
            };
            mesas[i].addActionListener(abrirPedido);

            JpanelMesas.add(mesas[i]);

        }

        revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JpanelMesas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        btn_platos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jLabel38.setFont(new java.awt.Font("Zilla Slab", 3, 48)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/titulo.png"))); // NOI18N
        jLabel38.setText("Restaurante la Delicia");
        jLabel38.setFocusable(false);
        jLabel38.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JpanelMesasLayout = new javax.swing.GroupLayout(JpanelMesas);
        JpanelMesas.setLayout(JpanelMesasLayout);
        JpanelMesasLayout.setHorizontalGroup(
            JpanelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
        );
        JpanelMesasLayout.setVerticalGroup(
            JpanelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(JpanelMesas);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuarios.png"))); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        btn_salir.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salir_1.png"))); // NOI18N
        btn_salir.setText(" Salir");
        btn_salir.setFocusPainted(false);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_platos.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btn_platos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/platos.png"))); // NOI18N
        btn_platos.setText(" Platos");
        btn_platos.setFocusPainted(false);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sala.png"))); // NOI18N
        jLabel3.setText("     Sala");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_platos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btn_platos)
                .addGap(37, 37, 37)
                .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // aqui cerramos la ventana si el lo desea
        //EXIT_ON_CLOSE
        dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    // agregamos un ciclo para añadir las mesas a el jpanel
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sala().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelMesas;
    private javax.swing.JButton btn_platos;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
