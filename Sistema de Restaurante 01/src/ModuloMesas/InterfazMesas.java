 
package ModuloMesas;

import Principal.Pedidos;
import Clases.DataBase;
import Clases.MesaP;
import Principal.PrincipalInterface;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

 
public class InterfazMesas extends javax.swing.JPanel {
    private PrincipalInterface principal;
    public DataBase database;
    private int cant_mesas = 12;
    private JLabel estado[];
    private JButton mesas[];
    public MesaP pedidos_mesas[][];
     
    public InterfazMesas(PrincipalInterface principal, DataBase database) {
        this.principal = principal;
        this.database = database;
        initComponents();
        initAlternComponents();
        this.pedidos_mesas = new MesaP[cant_mesas][100];
        database.registrarMesas(cant_mesas);
        
    }
    
    public void initAlternComponents(){
        JpanelMesas.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        JpanelMesas.setLayout(new GridLayout(0, 4, 10, 10)); // 5 columnas con margen de 10 píxeles
        JpanelMesas.setBackground(Color.WHITE);

        agregarMesas();
    }
    
    public void agregarMesas(){
        //Creamos un evento para que genere otra ventana en la cual saldrá la orden. 
        mesas = new JButton[cant_mesas];
        estado = new JLabel[cant_mesas];
        for (int i = 0; i < cant_mesas; i++) {
            mesas[i] = new JButton("Mesa#" + (i + 1));
            mesas[i].setFont(new Font("Georgia", Font.BOLD, 25));
            Color verdeOscuro = new Color(46, 139, 87);
            mesas[i].setBackground(verdeOscuro);
            mesas[i].setForeground(Color.WHITE);
            // color rgb para cuando la mesa esta ocupada 255, 99, 71
            // Cargar la imagen y establecerla como el ícono del botón
            mesas[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mesa.png")));
            mesas[i].setHorizontalTextPosition(SwingConstants.CENTER);
            mesas[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            // Desactivar el enfoque del botón.
            mesas[i].setFocusPainted(false);
            // Cambiar el cursor al pasar el ratón sobre el botón.
            mesas[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            // Agregamos el evento a todos los botones. 
            int numeroDeMesa = i;
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
    
    public void abrirVentanaPedido(int numeroMesa){
        int idMesaPedidoActiva = this.database.obtenerIdMesaPedidoActiva(numeroMesa+1);
        if (idMesaPedidoActiva != -1) {
            // Hay un pedido activo para la mesa, mostrar los datos
            System.out.println("Entro aqui en la primera condicion"+numeroMesa);
            //setVisible(false);

            Pedidos ventana = new Pedidos(this, numeroMesa);
            ventana.setVisible(true);
        } else {
            // No hay un pedido activo para la mesa, crear uno nuevo
            // Aquí puedes agregar el código para crear un nuevo pedido
            // Puedes utilizar el número de mesa (numeroMesa) para inicializar el nuevo pedido
            System.out.println("Entro aqui en la segunda condicion");
            // Abrir la ventana de pedidos con el nuevo pedido
            //setVisible(false);

            Pedidos ventana = new Pedidos(this, numeroMesa);
            ventana.setVisible(true);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JpanelMesas = new javax.swing.JPanel();

        javax.swing.GroupLayout JpanelMesasLayout = new javax.swing.GroupLayout(JpanelMesas);
        JpanelMesas.setLayout(JpanelMesasLayout);
        JpanelMesasLayout.setHorizontalGroup(
            JpanelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        JpanelMesasLayout.setVerticalGroup(
            JpanelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(JpanelMesas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelMesas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
