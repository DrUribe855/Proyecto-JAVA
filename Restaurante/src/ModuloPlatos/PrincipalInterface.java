 
package ModuloPlatos;

 
import Clases.DataBase;
import ModuloPlatos.Interfaces.MenuPlatos;
import ModuloPlatos.Interfaces.ModificarMenu;
import ModuloPlatos.Interfaces.RegistrarMenu;

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
        contentPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(13, 71, 161));

        restaurantName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        restaurantName.setForeground(new java.awt.Color(255, 255, 255));
        restaurantName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restaurantName.setText("NOMBRE RESTAURANTE");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        btnPlatos.setBackground(new java.awt.Color(21, 101, 192));
        btnPlatos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        btnMesas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(restaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(restaurantName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPlatos))
        );

        contentPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
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
                .addGap(6, 6, 6)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
    public void cargarPanelModificarMenu(){
        this.contentPrincipal.removeAll();
        this.contentPrincipal.repaint();
        
        ModificarMenu contenTemporal = new ModificarMenu(this, database);
        contenTemporal.setSize(contentPrincipal.getSize());
        contentPrincipal.add(contenTemporal);
        revalidate();
    }
    
    public void cargarPanelPlatos(){
        this.contentPrincipal.removeAll();
        this.contentPrincipal.repaint();
        
        MenuPlatos contenMenuPlatos = new MenuPlatos(this, database);
        contenMenuPlatos.setSize(this.contentPrincipal.getSize());
        contentPrincipal.add(contenMenuPlatos);
        revalidate();
    }
    
    private void btnMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesasActionPerformed
        
    }//GEN-LAST:event_btnMesasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnPlatos;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel restaurantName;
    // End of variables declaration//GEN-END:variables
}
