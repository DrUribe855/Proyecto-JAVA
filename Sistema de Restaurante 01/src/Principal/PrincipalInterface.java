 
package Principal;

 
import Clases.DataBase;
import Login.Login;
import ModuloMesas.InterfazMesas;
import ModuloPlatos.ListarPlatos;
import ModuloPlatos.RegistrarMenu;
import ModuloVentas.RegistroVentas;
import javax.swing.JFrame;

import javax.swing.JPanel;

 
public class PrincipalInterface extends javax.swing.JFrame {

    private JPanel menuPlatos;
    private DataBase database;
    
    public PrincipalInterface(DataBase database) {
        this.database = database;
        initComponents();
        initAlternComponents();
    }
    
    public void initAlternComponents(){
       
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        restaurantName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPlatos = new javax.swing.JButton();
        btnMesas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        contentPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(13, 71, 161));

        restaurantName.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        restaurantName.setForeground(new java.awt.Color(255, 255, 255));
        restaurantName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restaurantName.setText("NOMBRE RESTAURANTE");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        btnPlatos.setBackground(new java.awt.Color(21, 101, 192));
        btnPlatos.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnPlatos.setForeground(new java.awt.Color(255, 255, 255));
        btnPlatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-cocina-50.png"))); // NOI18N
        btnPlatos.setText("Platos");
        btnPlatos.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 5, 1, new java.awt.Color(0, 0, 0)));
        btnPlatos.setBorderPainted(false);
        btnPlatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlatos.setFocusPainted(false);
        btnPlatos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPlatos.setIconTextGap(20);
        btnPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatosActionPerformed(evt);
            }
        });

        btnMesas.setBackground(new java.awt.Color(21, 101, 192));
        btnMesas.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnMesas.setForeground(new java.awt.Color(255, 255, 255));
        btnMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-caja-registradora-50 (1).png"))); // NOI18N
        btnMesas.setText("Mesas");
        btnMesas.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 5, 1, new java.awt.Color(0, 0, 0)));
        btnMesas.setBorderPainted(false);
        btnMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMesas.setFocusPainted(false);
        btnMesas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMesas.setIconTextGap(20);
        btnMesas.setInheritsPopupMenu(true);
        btnMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesasActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(21, 101, 192));
        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-log-out-40.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 5, 1, new java.awt.Color(0, 0, 0)));
        btnSalir.setBorderPainted(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFocusPainted(false);
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir.setIconTextGap(35);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegistro.setBackground(new java.awt.Color(21, 101, 192));
        btnRegistro.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-registro-40.png"))); // NOI18N
        btnRegistro.setText("Registro de ventas");
        btnRegistro.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 5, 1, new java.awt.Color(0, 0, 0)));
        btnRegistro.setBorderPainted(false);
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.setFocusPainted(false);
        btnRegistro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistro.setIconTextGap(30);
        btnRegistro.setMargin(new java.awt.Insets(2, 20, 3, 14));
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(restaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(restaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPlatos))
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(contentPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatosActionPerformed
        cargarPanelPlatos();
    }//GEN-LAST:event_btnPlatosActionPerformed
    public void cargarPanelRegistrarMenu(){
       this.contentPrincipal.removeAll();
       this.contentPrincipal.repaint();
       
       
       RegistrarMenu contenTemporal = new RegistrarMenu(this, database);
       contenTemporal.setSize( contentPrincipal.getSize() );
       contentPrincipal.add(contenTemporal);
       revalidate();
    }
    
    
    
    public void cargarPanelListarPlatos(){
        this.contentPrincipal.removeAll();
        this.contentPrincipal.repaint();
        
        ListarPlatos contenTemporal = new ListarPlatos(this, database);
        contenTemporal.setSize(contentPrincipal.getSize());
        contentPrincipal.add(contenTemporal);
        revalidate();
    }
    
    public void cargarPanelPlatos(){
        this.contentPrincipal.removeAll();
        this.contentPrincipal.repaint();
        
        ListarPlatos contenMenuPlatos = new ListarPlatos(this, database);
        contenMenuPlatos.setSize(this.contentPrincipal.getSize());
        contentPrincipal.add(contenMenuPlatos);
        revalidate();
    }
    
    public void cargarPanelMesas(){
        this.contentPrincipal.removeAll();
        this.contentPrincipal.repaint();
        InterfazMesas contenMesas = new InterfazMesas(this, database);
        contenMesas.setSize(this.contentPrincipal.getSize());
        contentPrincipal.add(contenMesas);
        revalidate();
        
    }
    
    private void btnMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesasActionPerformed
        cargarPanelMesas();
    }//GEN-LAST:event_btnMesasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        Login ventana = new Login();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        this.contentPrincipal.removeAll();
        this.contentPrincipal.repaint();
        RegistroVentas contenFacturas = new RegistroVentas(this, database);
        contenFacturas.setSize(this.contentPrincipal.getSize());
        contentPrincipal.add(contenFacturas);
        revalidate();
    }//GEN-LAST:event_btnRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnPlatos;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel restaurantName;
    // End of variables declaration//GEN-END:variables
}
