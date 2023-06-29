package Principal;

import Clases.*;
import ModuloMesas.InterfazMesas;
import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DetallePedidos extends javax.swing.JFrame {

    private int pedido_mesa;
    private JLabel etqTemporal;
    int posicion = 0;
    private double total_final = 0;
    private String estado = "activo";
    private DefaultTableModel modelo;
    private DataBase database;
    // este es el id de mesa pedido de la base de datos

    public DetallePedidos(DataBase database, int pedido_mesa) {
        this.database = database;
        this.pedido_mesa = pedido_mesa;
        initComponents();
        initAlternComponents();

        cargarDatosPrevios();
    }

    // agregamos el initalternat 
    public void initAlternComponents() {
        setLocationRelativeTo(null);
        numeroMesa.setText("MESA #" + (this.pedido_mesa + 1));
        // creamo el evento para agregarselo al input 
        this.modelo = (DefaultTableModel) this.tablaItemsPedido.getModel();
    }

    // aqui hacemos la busqueda del producto en especifico

    /// metodo para agregar total a la base de datos si es
    // metodo para validar si es un numero
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

    //esto lo comente ya que solo era para ver lo que llegaba en consola
    /*
    public void mostrarPedidos(int mesa) {
        if (this.Pedido.pedidos_mesas != null && mesa >= 0 && mesa < this.Pedido.pedidos_mesas.length) {
            System.out.println("Mesa: " + mesa);
            for (int j = 0; j < this.Pedido.pedidos_mesas[mesa].length; j++) {
                MesaP pedido = this.Pedido.pedidos_mesas[mesa][j];
                if (pedido != null) {
                    System.out.println("ID de la factura: " + pedido.getIdFactura());
                    System.out.println("Identificador del plato:" + pedido.getIdentificador());
                    System.out.println("Numero de Pedido:" + j);
                    System.out.println("Nombre del plato: " + pedido.getNombrePlato());
                    System.out.println("Cantidad de platos: " + pedido.getCantidadPlatos());
                    System.out.println("Subtotal: " + pedido.getSubtotal());
                    System.out.println("--------------------");
                }
            }
            // aqui mostramos tambien el total de la compra que valla el agregando
            //this.total.setText(Double.toString(total_final));
        } else {
            System.out.println("No hay pedidos para la mesa especificada.");
        }
    }
     */
    // metodo para cargar los datos previso si tiene de la base de datos
    private void cargarDatosPrevios() {
        int idMesaPedido = this.database.obtenerIdMesaPedidoActiva(pedido_mesa + 1);
        total_final = (idMesaPedido != -1) ? this.database.obtenerTotalMesaPedido(idMesaPedido) : 0;
        this.total.setText(String.valueOf(total_final));

        ResultSet listaItems = this.database.getListaItems(idMesaPedido);
        if (listaItems != null) {
            try {
                this.modelo.setRowCount(0);
                do {
                    Object[] nuevoItem = new Object[]{listaItems.getString("codigo"), listaItems.getString("nombre"), listaItems.getString("precio"), listaItems.getString("cantidad"), listaItems.getString("subtotal")};
                    this.modelo.addRow(nuevoItem);
                } while (listaItems.next());
            } catch (SQLException ex) {
                System.out.println("Erro al extraer los datos: " + ex.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        numeroMesa = new javax.swing.JLabel();
        ventanaPedidos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaItemsPedido = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        numeroMesa.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        numeroMesa.setForeground(new java.awt.Color(255, 255, 255));
        numeroMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sala.png"))); // NOI18N
        numeroMesa.setText("MESA #");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(numeroMesa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(numeroMesa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ventanaPedidos.setBackground(new java.awt.Color(173, 216, 230));

        jLabel5.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jLabel5.setText("TOTAL:");

        total.setEditable(false);

        tablaItemsPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Cantidad", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaItemsPedido);

        javax.swing.GroupLayout ventanaPedidosLayout = new javax.swing.GroupLayout(ventanaPedidos);
        ventanaPedidos.setLayout(ventanaPedidosLayout);
        ventanaPedidosLayout.setHorizontalGroup(
            ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPedidosLayout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ventanaPedidosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        ventanaPedidosLayout.setVerticalGroup(
            ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaPedidosLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ventanaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
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
                .addComponent(ventanaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numeroMesa;
    private javax.swing.JTable tablaItemsPedido;
    private javax.swing.JTextField total;
    private javax.swing.JPanel ventanaPedidos;
    // End of variables declaration//GEN-END:variables

}
