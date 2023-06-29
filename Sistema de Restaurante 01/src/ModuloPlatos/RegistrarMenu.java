
package ModuloPlatos;

import Clases.DataBase;
import Login.Login;
import Principal.PrincipalInterface;


public class RegistrarMenu extends javax.swing.JPanel {

    private DataBase database;
    private PrincipalInterface principal;
     
    public RegistrarMenu(PrincipalInterface principal, DataBase database) {
        this.database = database;
        this.principal = principal;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fadeEffect1 = new LIB.FadeEffect();
        jPanel1 = new javax.swing.JPanel();
        campoPrecio = new LIB.FSTexFieldMD();
        campoCodigo = new LIB.FSTexFieldMD();
        campoNombre = new LIB.FSTexFieldMD();
        btnRegistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        campoPrecio.setBackground(new java.awt.Color(255, 255, 255));
        campoPrecio.setForeground(new java.awt.Color(0, 0, 0));
        campoPrecio.setToolTipText("");
        campoPrecio.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        campoPrecio.setPlaceholder("Precio");

        campoCodigo.setBackground(new java.awt.Color(255, 255, 255));
        campoCodigo.setForeground(new java.awt.Color(0, 0, 0));
        campoCodigo.setToolTipText("");
        campoCodigo.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        campoCodigo.setPlaceholder("Código");

        campoNombre.setBackground(new java.awt.Color(255, 255, 255));
        campoNombre.setForeground(new java.awt.Color(0, 0, 0));
        campoNombre.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        campoNombre.setPlaceholder("Nombre");

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REGISTRAR PLATO");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String codigo = campoCodigo.getText();
        String nombre = campoNombre.getText();
        String precio = campoPrecio.getText();
        if(!codigo.equals("") && !nombre.equals("") && !precio.equals("")){
            boolean respuesta = this.database.registrarPlato(codigo, nombre, Double.parseDouble(precio), "Activo");
            if(respuesta){
                this.principal.setVisible(true);
                System.out.println("Producto registrado con éxito");
                this.principal.cargarPanelPlatos();
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.principal.cargarPanelListarPlatos();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private LIB.FSTexFieldMD campoCodigo;
    private LIB.FSTexFieldMD campoNombre;
    private LIB.FSTexFieldMD campoPrecio;
    private LIB.FadeEffect fadeEffect1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
}
