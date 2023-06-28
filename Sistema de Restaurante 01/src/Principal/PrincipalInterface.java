 
package Principal;

 
import Clases.DataBase;
import Login.Login;
import ModuloMesas.InterfazMesas;
import ModuloPlatos.ListarPlatos;
import ModuloPlatos.RegistrarMenu;
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
        btnPlatos1 = new javax.swing.JButton();
        contentPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        btnPlatos.setIconTextGap(25);
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
        btnMesas.setIconTextGap(25);
        btnMesas.setInheritsPopupMenu(true);
        btnMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesasActionPerformed(evt);
            }
        });

        btnPlatos1.setBackground(new java.awt.Color(21, 101, 192));
        btnPlatos1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnPlatos1.setForeground(new java.awt.Color(255, 255, 255));
        btnPlatos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-log-out-40.png"))); // NOI18N
        btnPlatos1.setText("Salir");
        btnPlatos1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 10, 5, 1, new java.awt.Color(0, 0, 0)));
        btnPlatos1.setBorderPainted(false);
        btnPlatos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlatos1.setFocusPainted(false);
        btnPlatos1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPlatos1.setIconTextGap(35);
        btnPlatos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatos1ActionPerformed(evt);
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
            .addComponent(btnPlatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(btnPlatos1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPlatos)))
        );

        background.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

        contentPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        background.add(contentPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 0, 750, -1));

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

    private void btnPlatos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatos1ActionPerformed
        dispose();
        Login ventana = new Login();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnPlatos1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnPlatos;
    private javax.swing.JButton btnPlatos1;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel restaurantName;
    // End of variables declaration//GEN-END:variables
}
