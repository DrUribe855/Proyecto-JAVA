 
package ModuloPlatos;

import Clases.ButtonEditor;
import Clases.ButtonRenderer;
import Clases.DataBase;
import Clases.Plato;
import Principal.PrincipalInterface;
import java.awt.Color;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JCheckBox;
 
import javax.swing.table.DefaultTableModel;

 
public class ListarPlatos extends javax.swing.JPanel {
    
    private PrincipalInterface principal;
    private DataBase database;
    private DefaultTableModel modelo;
    private Plato[] listaPlatos;
     
    public ListarPlatos(PrincipalInterface principal, DataBase database) {
        this.principal = principal;
        this.database = database;
        initComponents();
        
        this.modelo = (DefaultTableModel) tablaPlatos.getModel();
        tablaPlatos.getColumn("Opcion").setCellRenderer(new ButtonRenderer());
        tablaPlatos.getColumn("Opcion").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        imprimirPlatos();
    }
    
    public void imprimirPlatos(){
        this.listaPlatos = this.database.getListaPlatos();
        
        this.modelo.setRowCount(0);
        for (int i=0; i<this.listaPlatos.length; i++) {
            if (this.listaPlatos[i]!=null) {
                Plato temporal = this.listaPlatos[i];
                JButton button = new JButton("Cambiar");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        abrirVentanaInfoPlato( temporal );
                    }
                });

                Object[] plato = new Object[]{ this.listaPlatos[i].getCodigo(), this.listaPlatos[i].getNombre(), this.listaPlatos[i].getPrecio(), this.listaPlatos[i].getEstado(), button};
                this.modelo.addRow(plato);
            }
        }
        
        revalidate();
    }

    public void abrirVentanaInfoPlato(Plato plato){
        System.out.println("Se dio click al plato: "+plato.getNombre());
        
        ModificarPlatos ventana = new ModificarPlatos(principal, database, plato.getCodigo());
        
        ventana.setTitle("Modificar");
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    
    private void btnRegistroProductoMouseEntered(java.awt.event.MouseEvent evt) {
        this.btnRegistroProducto.setBackground(new Color(21,101,192)); 
    }
    
    private void btnRegistroProductoMouseExited(java.awt.event.MouseEvent evt) {
        btnRegistroProducto.setBackground(new Color(13,71,161)); 
    }
    
    
    
     
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPlatos = new javax.swing.JTable();
        btnRegistroProducto = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTADO DE PLATOS");

        tablaPlatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Precio", "Estado", "Opcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPlatos);

        btnRegistroProducto.setBackground(new java.awt.Color(13, 71, 161));
        btnRegistroProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistroProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroProducto.setText("Registrar plato");
        btnRegistroProducto.setFocusable(false);
        btnRegistroProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addGap(255, 255, 255)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(592, 592, 592)
                .addComponent(btnRegistroProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnRegistroProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroProductoActionPerformed
        this.principal.cargarPanelRegistrarMenu();
        
        this.btnRegistroProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistroProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistroProductoMouseExited(evt);
            }
        });
    }//GEN-LAST:event_btnRegistroProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistroProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaPlatos;
    // End of variables declaration//GEN-END:variables
}
