package Login;

import Clases.DataBase;
import Principal.*;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;

import javax.swing.BorderFactory;

public class Login extends javax.swing.JFrame {

    public DataBase database;

    public Login() {

        this.database = new DataBase();
        initComponents();
        initAlternComponent();
    }

    public void initAlternComponent() {
        setLocationRelativeTo(null);
        Login.this.setBackground(new Color(0, 0, 0, 0));

    }

    public void iniciarSesion() {
        String user = this.campoUsuario.getText();
        String password = String.valueOf(this.campoContrasenia.getPassword());
        if (!user.equals("") && !password.equals("")) {
            try {
                ResultSet usuario = this.database.log(user, password);
                if (usuario != null && usuario.getRow() == 1) {
                    if (user.equals(usuario.getString("usuario")) && password.equals(usuario.getString("password"))) {
                        dispose();
                        PrincipalInterface window = new PrincipalInterface(database);
                        window.setVisible(true);
                        Alert alerta = new Alert(usuario.getString("usuario"), "BIENVENIDO", "success");
                    }
                } else {
                    Alert alerta = new Alert("INCORRECTOS", "USUARIO O CONTRASEÑA INCORRECTA", "error");
                }
            } catch (SQLException e) {
                System.out.println("Error en inicio de sesion: " + e.getMessage());
            }
        } else {
            Alert alerta = new Alert("INICIO", "LOS CAMPOS ESTAN VACIOS ", "error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRound1 = new LIB.JPanelRound();
        jLabel1 = new javax.swing.JLabel();
        campoContrasenia = new LIB.FSPasswordFieldMD();
        campoUsuario = new LIB.FSTexFieldMD();
        jButton1 = new javax.swing.JButton();
        jPanelRound2 = new LIB.JPanelRound();
        jEImagePanel3 = new LIB.JEImagePanel();
        jEImagePanel1 = new LIB.JEImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRound1.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INICIAR SESIÓN");

        campoContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        campoContrasenia.setForeground(new java.awt.Color(0, 0, 0));
        campoContrasenia.setToolTipText("");
        campoContrasenia.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        campoContrasenia.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        campoContrasenia.setPlaceholder("   Contraseña");

        campoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        campoUsuario.setForeground(new java.awt.Color(0, 0, 0));
        campoUsuario.setToolTipText("");
        campoUsuario.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        campoUsuario.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        campoUsuario.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        campoUsuario.setPlaceholder("   Usuario");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("INGRESAR");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRound1Layout = new javax.swing.GroupLayout(jPanelRound1);
        jPanelRound1.setLayout(jPanelRound1Layout);
        jPanelRound1Layout.setHorizontalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addGroup(jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(campoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRound1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanelRound1Layout.setVerticalGroup(
            jPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRound1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(campoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jPanelRound2.setBackground(new java.awt.Color(255, 0, 0));

        jEImagePanel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mcdonalds-logo.jpg"))); // NOI18N

        jEImagePanel1.setBackground(new java.awt.Color(255, 0, 0));
        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
        jEImagePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEImagePanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jEImagePanel1Layout = new javax.swing.GroupLayout(jEImagePanel1);
        jEImagePanel1.setLayout(jEImagePanel1Layout);
        jEImagePanel1Layout.setHorizontalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jEImagePanel1Layout.setVerticalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jEImagePanel3Layout = new javax.swing.GroupLayout(jEImagePanel3);
        jEImagePanel3.setLayout(jEImagePanel3Layout);
        jEImagePanel3Layout.setHorizontalGroup(
            jEImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEImagePanel3Layout.createSequentialGroup()
                .addContainerGap(501, Short.MAX_VALUE)
                .addComponent(jEImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jEImagePanel3Layout.setVerticalGroup(
            jEImagePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEImagePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jEImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelRound2Layout = new javax.swing.GroupLayout(jPanelRound2);
        jPanelRound2.setLayout(jPanelRound2Layout);
        jPanelRound2Layout.setHorizontalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jEImagePanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelRound2Layout.setVerticalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jEImagePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jPanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Shape roundedShape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        setShape(roundedShape);
    }//GEN-LAST:event_formWindowOpened

    private void jEImagePanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEImagePanel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jEImagePanel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIB.FSPasswordFieldMD campoContrasenia;
    private LIB.FSTexFieldMD campoUsuario;
    private javax.swing.JButton jButton1;
    private LIB.JEImagePanel jEImagePanel1;
    private LIB.JEImagePanel jEImagePanel3;
    private javax.swing.JLabel jLabel1;
    private LIB.JPanelRound jPanelRound1;
    private LIB.JPanelRound jPanelRound2;
    // End of variables declaration//GEN-END:variables
}
