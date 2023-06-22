
package Login;

import ModuloPlatos.PrincipalInterface;
import java.awt.Color;

public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
        initAlternComponent();
    }
    
    public void initAlternComponent(){
        setLocationRelativeTo(null);
        Login.this.setBackground(new Color (0,0,0,0));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRound1 = new LIB.JPanelRound();
        jEImagePanel1 = new LIB.JEImagePanel();
        jEImagePanel2 = new LIB.JEImagePanel();
        jLabel1 = new javax.swing.JLabel();
        fSPasswordFieldMD1 = new LIB.FSPasswordFieldMD();
        fSTexFieldMD1 = new LIB.FSTexFieldMD();
        jPanelRound2 = new LIB.JPanelRound();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);

        jEImagePanel1.setBackground(new java.awt.Color(234, 0, 1));
        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mcdonalds-logo.jpg"))); // NOI18N
        jEImagePanel1.setPreferredSize(new java.awt.Dimension(490, 37));

        jEImagePanel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
        jEImagePanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEImagePanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jEImagePanel2Layout = new javax.swing.GroupLayout(jEImagePanel2);
        jEImagePanel2.setLayout(jEImagePanel2Layout);
        jEImagePanel2Layout.setHorizontalGroup(
            jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jEImagePanel2Layout.setVerticalGroup(
            jEImagePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jEImagePanel1Layout = new javax.swing.GroupLayout(jEImagePanel1);
        jEImagePanel1.setLayout(jEImagePanel1Layout);
        jEImagePanel1Layout.setHorizontalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEImagePanel1Layout.createSequentialGroup()
                .addContainerGap(457, Short.MAX_VALUE)
                .addComponent(jEImagePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jEImagePanel1Layout.setVerticalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEImagePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jEImagePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INICIAR SESIÓN");

        fSPasswordFieldMD1.setBackground(new java.awt.Color(255, 255, 255));
        fSPasswordFieldMD1.setForeground(new java.awt.Color(0, 0, 0));
        fSPasswordFieldMD1.setToolTipText("");
        fSPasswordFieldMD1.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        fSPasswordFieldMD1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        fSPasswordFieldMD1.setPlaceholder("   Contraseña");

        fSTexFieldMD1.setBackground(new java.awt.Color(255, 255, 255));
        fSTexFieldMD1.setForeground(new java.awt.Color(0, 0, 0));
        fSTexFieldMD1.setToolTipText("");
        fSTexFieldMD1.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        fSTexFieldMD1.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        fSTexFieldMD1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        fSTexFieldMD1.setPlaceholder("   Usuario");

        jPanelRound2.setBackground(new java.awt.Color(255, 0, 0));
        jPanelRound2.setArch(30);
        jPanelRound2.setArcw(30);
        jPanelRound2.setOpaque(true);
        jPanelRound2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                loginButton(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INGRESAR");

        javax.swing.GroupLayout jPanelRound2Layout = new javax.swing.GroupLayout(jPanelRound2);
        jPanelRound2.setLayout(jPanelRound2Layout);
        jPanelRound2Layout.setHorizontalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanelRound2Layout.setVerticalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelRound1Layout = new javax.swing.GroupLayout(jPanelRound1);
        jPanelRound1.setLayout(jPanelRound1Layout);
        jPanelRound1Layout.setHorizontalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRound1Layout.createSequentialGroup()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fSPasswordFieldMD1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(fSTexFieldMD1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jPanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jEImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelRound1Layout.setVerticalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(fSTexFieldMD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(fSPasswordFieldMD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addComponent(jEImagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEImagePanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEImagePanel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jEImagePanel2MouseClicked

    private void loginButton(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_loginButton
        setVisible(false);
        PrincipalInterface window = new PrincipalInterface();
        window.setVisible(true);
    }//GEN-LAST:event_loginButton

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIB.FSPasswordFieldMD fSPasswordFieldMD1;
    private LIB.FSTexFieldMD fSTexFieldMD1;
    private LIB.JEImagePanel jEImagePanel1;
    private LIB.JEImagePanel jEImagePanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private LIB.JPanelRound jPanelRound1;
    private LIB.JPanelRound jPanelRound2;
    // End of variables declaration//GEN-END:variables
}
