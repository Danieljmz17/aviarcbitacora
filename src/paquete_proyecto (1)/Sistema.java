
package paquete_proyecto;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.usuarios;

/**
 *
 * @author Darek
 */
public class Sistema extends javax.swing.JFrame {
    

     public static registro frmreg;
    usuarios mod ;
    
    
    
    
    
          public void cargarDatosEnTablaclientes() {
    DefaultTableModel modelo = (DefaultTableModel) jtclientes.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

    try {
        conexion objcon = new conexion();
        Connection conn = objcon.getConection();
        String sql = "SELECT id_cliente, nombre, telefono, correo FROM cliente";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[4];
            fila[0] = rs.getString("id_cliente");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getString("telefono");
            fila[3] = rs.getString("correo");
            modelo.addRow(fila);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar datos en la tabla");
        System.out.println(e);
    }}
    
    
    
    
    
      public void cargarDatosEnTablaproductores() {
    DefaultTableModel modelo = (DefaultTableModel) jtproductores.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

    try {
        conexion objcon = new conexion();
        Connection conn = objcon.getConection();
        String sql = "SELECT id_productor, nombre_productor, telefono, correo FROM productor";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[4];
            fila[0] = rs.getString("id_productor");
            fila[1] = rs.getString("nombre_productor");
            fila[2] = rs.getString("telefono");
            fila[3] = rs.getString("correo");
            modelo.addRow(fila);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar datos en la tabla");
        System.out.println(e);
    }}
    
    

    
      public void cargarDatosEnTablaventa() {
    DefaultTableModel modelo = (DefaultTableModel) jtventas.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

    try {
        conexion objcon = new conexion();
        Connection conn = objcon.getConection();
        String sql = "SELECT id_venta, nombre, telefono, exportacion, fecha, cantidad, tamaño,importe FROM venta_camion";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[8];
            fila[0] = rs.getString("id_venta");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getString("telefono");
            fila[3] = rs.getString("exportacion");
            fila[4] = rs.getString("fecha");
            fila[5] = rs.getString("cantidad");
            fila[6] = rs.getString("tamaño");
            fila[7] = rs.getString("importe");

            modelo.addRow(fila);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar datos en la tabla");
        System.out.println(e);
    }}
    
    
    
     public void cargarDatosEnTabla() {
    DefaultTableModel modelo = (DefaultTableModel) jtentradas.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

    try {
        conexion objcon = new conexion();
        Connection conn = objcon.getConection();
        String sql = "SELECT id_entrada, nombre, telefono, correo, exportacion, fecha, peso, costales FROM entrada_camion";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Object[] fila = new Object[8];
            fila[0] = rs.getString("id_entrada");
            fila[1] = rs.getString("nombre");
            fila[2] = rs.getString("telefono");
            fila[3] = rs.getString("correo");
            fila[4] = rs.getString("exportacion");
            fila[5] = rs.getString("fecha");
            fila[6] = rs.getString("peso");
            fila[7] = rs.getString("costales");

            modelo.addRow(fila);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar datos en la tabla");
        System.out.println(e);
    }
}
    
    
    public class conexion{

     public static final String URL = "jdbc:mysql://localhost:3306/aviarc";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "eduardo";

    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    }
    
    private void limpiarcajasentrada() {
       
        txtnombre.setText(null);
        txttelefono.setText(null);
        txtcorreo.setText(null);
        cbexportacion.setText(null);
        txtfolio.setText(null);
        calendariofechaentrada.setDate(null);
        txtpeso.setText(null);
        txtnumero_costales.setText(null);
    }
    
    private void limpiarcajasventa() {
       
        txtnombreventa.setText(null);
        txttelefonoventa.setText(null);
        cbexportacionventa.setText(null);
        txtfolio.setText(null);
        calendariofechaventa.setDate(null);
        txtcantidadventa.setText(null);
        txtimporteventa.setText(null);
    }
    
     private void limpiarcajasregistroproductor() {
       
        txtnombreguardarproductor.setText(null);
        txtguardatelefonoproductor.setText(null);
        txtguardarcorreoproductor.setText(null);
    }
     
          private void limpiarcajasregistrocliente() {
       
        txtnombreguardarcliente.setText(null);
        txtguardatelefonocliente.setText(null);
        txtguardarcorreocliente.setText(null);
    }
    
    
          
          
    public Sistema() {
        initComponents();
    }

   
    
          public Sistema(usuarios mod){
                initComponents();
                setLocationRelativeTo(null);
              this.mod=mod;
              lblnombresesioniniciada.setText(mod.getNombre());
              lblroliniciomostrar.setText(mod.getNombre_tipo());
              if(mod.getId_tipo()==1){
              
              }else if(mod.getId_tipo()==2){
                  btnmodificarconsultase.setVisible(false);
                  btnmodificarconsultasventa.setVisible(false);
                  btnmodificarcliente.setVisible(false);
                  btnmodificarproductores.setVisible(false);
                  btnelininarconsultae.setVisible(false);
                  btnelininarconsultaventa.setVisible(false);
                  btneliminarcliente.setVisible(false);
                  btneliminarproductores.setVisible(false);
                  btnregistrarnuevousuario.setVisible(false);
              }
          }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jDialog1 = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        lblnombresesion = new javax.swing.JPanel();
        label11 = new java.awt.Label();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblnombresesioniniciada = new javax.swing.JLabel();
        btncerrarsesion = new javax.swing.JButton();
        btnregistrarnuevousuario = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        lblroliniciomostrar = new javax.swing.JLabel();
        lblrol = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        txtfolio = new javax.swing.JTextField();
        cbexportacion = new javax.swing.JCheckBox();
        txtpeso = new javax.swing.JTextField();
        txtnumero_costales = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtidproductor = new javax.swing.JTextField();
        btnbuscarproductor = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblroluser = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtnombreventa = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        txttelefonoventa = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        txtcantidadventa = new javax.swing.JTextField();
        cbexportacionventa = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtimporteventa = new javax.swing.JTextField();
        cbxtamanoventa = new javax.swing.JComboBox<>();
        btnguardarventa = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnbuscarcliente = new javax.swing.JButton();
        label3 = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtnombreguardarproductor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtguardatelefonoproductor = new javax.swing.JTextField();
        txtguardarcorreoproductor = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        btnguardarproductor = new javax.swing.JButton();
        label6 = new java.awt.Label();
        label10 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtnombreguardarcliente = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtguardatelefonocliente = new javax.swing.JTextField();
        txtguardarcorreocliente = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        btnguardarcliente = new javax.swing.JButton();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtentradas = new javax.swing.JTable();
        btncargarentradas = new javax.swing.JButton();
        txtcampo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtfolioconsultae = new javax.swing.JTextField();
        txtnombreconsultae = new javax.swing.JTextField();
        txttelefonoconsutlae = new javax.swing.JTextField();
        txtcorreoconsutae = new javax.swing.JTextField();
        txteportacionconsutae = new javax.swing.JTextField();
        txtfechaconsultae = new javax.swing.JTextField();
        txtpesoconsultae = new javax.swing.JTextField();
        txtcostalesconsutae = new javax.swing.JTextField();
        btnmodificarconsultase = new javax.swing.JButton();
        btnelininarconsultae = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        label9 = new java.awt.Label();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtventas = new javax.swing.JTable();
        btncargarventas = new javax.swing.JButton();
        txtcampoventa = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtfolioconsultaventa = new javax.swing.JTextField();
        txtnombreconsultaventa = new javax.swing.JTextField();
        txttelefonoconsutlaventa = new javax.swing.JTextField();
        txtexportacionconsutaventa = new javax.swing.JTextField();
        txtfechaconsutaventa = new javax.swing.JTextField();
        txtcantidadconsultaventa = new javax.swing.JTextField();
        txttamañoconsultaventa = new javax.swing.JTextField();
        txtimporteconsutaventa = new javax.swing.JTextField();
        btnmodificarconsultasventa = new javax.swing.JButton();
        btnelininarconsultaventa = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        label8 = new java.awt.Label();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtproductores = new javax.swing.JTable();
        btncargarproductores = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtidconsultaproductor2 = new javax.swing.JTextField();
        txtnombreproductorconsulta2 = new javax.swing.JTextField();
        txttelefonoproductorconsulta2 = new javax.swing.JTextField();
        txtcorreoproductorconsulta2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtidproductorconsultas = new javax.swing.JTextField();
        btnmodificarproductores = new javax.swing.JButton();
        btneliminarproductores = new javax.swing.JButton();
        label7 = new java.awt.Label();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtclientes = new javax.swing.JTable();
        btncargarclientes = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtidconsultacliente = new javax.swing.JTextField();
        txtnombreclienteconsultas = new javax.swing.JTextField();
        txttelefonoclienteconsultas = new javax.swing.JTextField();
        txtcorreoclienteconsultas = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtidclienteconsultas = new javax.swing.JTextField();
        btnmodificarcliente = new javax.swing.JButton();
        btneliminarcliente = new javax.swing.JButton();
        label1 = new java.awt.Label();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lblnombresesion.setBackground(new java.awt.Color(255, 255, 255));
        lblnombresesion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 40)); // NOI18N

        label11.setAlignment(java.awt.Label.CENTER);
        label11.setBackground(new java.awt.Color(32, 45, 112));
        label11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 100, 100));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblnombresesioniniciada.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 35)); // NOI18N
        lblnombresesioniniciada.setForeground(new java.awt.Color(100, 100, 100));
        lblnombresesioniniciada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btncerrarsesion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        btncerrarsesion.setText("Cerrar sesion");
        btncerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarsesionActionPerformed(evt);
            }
        });

        btnregistrarnuevousuario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        btnregistrarnuevousuario.setText("Registrar usuario");
        btnregistrarnuevousuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarnuevousuarioActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N

        lblroliniciomostrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 15)); // NOI18N
        lblroliniciomostrar.setForeground(new java.awt.Color(100, 100, 100));
        lblroliniciomostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblroliniciomostrar.setText("rol");

        javax.swing.GroupLayout lblnombresesionLayout = new javax.swing.GroupLayout(lblnombresesion);
        lblnombresesion.setLayout(lblnombresesionLayout);
        lblnombresesionLayout.setHorizontalGroup(
            lblnombresesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblnombresesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblnombresesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblnombresesionLayout.createSequentialGroup()
                        .addGap(0, 250, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblnombresesionLayout.createSequentialGroup()
                        .addGroup(lblnombresesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(lblnombresesionLayout.createSequentialGroup()
                                .addComponent(btnregistrarnuevousuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btncerrarsesion)))
                        .addContainerGap())))
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblnombresesioniniciada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(lblnombresesionLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblroliniciomostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lblnombresesionLayout.setVerticalGroup(
            lblnombresesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblnombresesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(lblnombresesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblnombresesionLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btncerrarsesion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblnombresesionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnregistrarnuevousuario)))
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnombresesioniniciada, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblroliniciomostrar)
                .addGap(372, 372, 372)
                .addComponent(jLabel61)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", lblnombresesion);

        lblrol.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel2.setText("Nombre completo");

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel3.setText("Telefono");

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel4.setText("Correo");

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel5.setText("Exportacion");

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel6.setText("Folio");

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel7.setText("Fecha");

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel8.setText("Peso (Toneladas)");

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel9.setText("Numero de costales");

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        txtfolio.setEnabled(false);

        cbexportacion.setText("si");

        txtpeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel17.setText("ID productor");

        btnbuscarproductor.setText("Buscar");
        btnbuscarproductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarproductorActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Productor");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(32, 45, 112)));

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setBackground(new java.awt.Color(32, 45, 112));
        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Entrada");

        javax.swing.GroupLayout lblrolLayout = new javax.swing.GroupLayout(lblrol);
        lblrol.setLayout(lblrolLayout);
        lblrolLayout.setHorizontalGroup(
            lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblrolLayout.createSequentialGroup()
                .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7))
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbexportacion)))
                .addContainerGap(832, Short.MAX_VALUE))
            .addGroup(lblrolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnumero_costales)
                            .addComponent(txtpeso)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lblrolLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(244, 244, 244))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblrolLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblroluser, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                .addGap(22, 22, 22))
                            .addGroup(lblrolLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnguardar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblrolLayout.createSequentialGroup()
                                .addGap(0, 140, Short.MAX_VALUE)
                                .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(lblrolLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(lblrolLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtidproductor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addComponent(btnbuscarproductor)
                                .addGap(144, 144, 144))))
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        lblrolLayout.setVerticalGroup(
            lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblrolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtfolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtidproductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscarproductor)))
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblroluser))
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                        .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbexportacion))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtpeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(12, 12, 12)
                .addGroup(lblrolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblrolLayout.createSequentialGroup()
                        .addComponent(txtnumero_costales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblrolLayout.createSequentialGroup()
                        .addComponent(btnguardar)
                        .addGap(19, 19, 19))))
        );

        jTabbedPane1.addTab("Entrada", lblrol);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel11.setText("Nombre completo");

        jLabel12.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel12.setText("Telefono");

        jLabel13.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel13.setText("Fecha");

        jLabel14.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel14.setText("Folio:");

        jLabel15.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel15.setText("Cantidad (toneladas)");

        jLabel16.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel16.setText("Exportacion");

        jTextField2.setEnabled(false);

        txttelefonoventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoventaActionPerformed(evt);
            }
        });

        cbexportacionventa.setText("Si");

        jLabel18.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel18.setText("ID cliente:");

        jLabel19.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel19.setText("Tamaño");

        jLabel20.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cliente");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(32, 45, 112)));

        cbxtamanoventa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Taquera", "Mediana", "Jumbo" }));

        btnguardarventa.setText("Guardar");
        btnguardarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarventaActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel21.setText("Importe");

        btnbuscarcliente.setText("Buscar");
        btnbuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarclienteActionPerformed(evt);
            }
        });

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setBackground(new java.awt.Color(32, 45, 112));
        label3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Venta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(325, 853, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxtamanoventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbexportacionventa))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtimporteventa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                                .addComponent(txtnombreventa, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txttelefonoventa, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtcantidadventa, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(btnbuscarcliente)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel14)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(btnbuscarcliente))
                        .addGap(269, 269, 269))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtnombreventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefonoventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbexportacionventa))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidadventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxtamanoventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtimporteventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(btnguardarventa)
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("Venta", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel24.setText("Nombre completo");

        jLabel25.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel25.setText("Telefono");

        jLabel26.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel26.setText("ID productor");

        txtguardarcorreoproductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtguardarcorreoproductorActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel27.setText("Correo");

        jTextField5.setEnabled(false);

        btnguardarproductor.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        btnguardarproductor.setText("Guardar");
        btnguardarproductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarproductorActionPerformed(evt);
            }
        });

        label6.setAlignment(java.awt.Label.CENTER);
        label6.setBackground(new java.awt.Color(32, 45, 112));
        label6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label6.setForeground(new java.awt.Color(255, 255, 255));
        label6.setText("Registrar productor");

        label10.setAlignment(java.awt.Label.CENTER);
        label10.setBackground(new java.awt.Color(32, 45, 112));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtguardarcorreoproductor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(txtguardatelefonoproductor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtnombreguardarproductor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24))
                        .addContainerGap(116, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardarproductor)
                .addGap(398, 398, 398))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreguardarproductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(txtguardatelefonoproductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(txtguardarcorreoproductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnguardarproductor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrar productor", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel29.setText("Nombre completo");

        jLabel30.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel30.setText("Telefono");

        jLabel31.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel31.setText("ID cliente");

        txtguardarcorreocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtguardarcorreoclienteActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        jLabel32.setText("Correo");

        jTextField6.setEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        btnguardarcliente.setFont(new java.awt.Font("Lucida Fax", 0, 15)); // NOI18N
        btnguardarcliente.setText("Guardar");
        btnguardarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarclienteActionPerformed(evt);
            }
        });

        label4.setAlignment(java.awt.Label.CENTER);
        label4.setBackground(new java.awt.Color(32, 45, 112));
        label4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("Registrar cliente");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtguardarcorreocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtguardatelefonocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtnombreguardarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel31)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 109, Short.MAX_VALUE))
            .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardarcliente)
                .addGap(403, 403, 403))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreguardarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(txtguardatelefonocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(txtguardarcorreocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnguardarcliente)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        label5.setAlignment(java.awt.Label.CENTER);
        label5.setBackground(new java.awt.Color(32, 45, 112));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(781, Short.MAX_VALUE)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 318, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Registrar cliente", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jtentradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Folio", "Nombre", "Telefono", "Correo", "Exportacion", "Fecha", "Peso", "Costales"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtentradas.setFocusable(false);
        jtentradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtentradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtentradas);

        btncargarentradas.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        btncargarentradas.setText("cargar");
        btncargarentradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarentradasActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel33.setText("Folio");

        jLabel34.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel34.setText("Peso");

        jLabel35.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel35.setText("Fecha");

        jLabel36.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel36.setText("N. costales");

        jLabel37.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel37.setText("Nombre");

        jLabel38.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel38.setText("Telefono");

        jLabel39.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel39.setText("Correo");

        jLabel40.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel40.setText("Exportacion");

        txtfolioconsultae.setEnabled(false);
        txtfolioconsultae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfolioconsultaeActionPerformed(evt);
            }
        });

        txttelefonoconsutlae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoconsutlaeActionPerformed(evt);
            }
        });

        btnmodificarconsultase.setText("Modificar");
        btnmodificarconsultase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarconsultaseActionPerformed(evt);
            }
        });

        btnelininarconsultae.setText("Eliminar");
        btnelininarconsultae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelininarconsultaeActionPerformed(evt);
            }
        });

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel50.setText("ID entrada");

        label9.setAlignment(java.awt.Label.CENTER);
        label9.setBackground(new java.awt.Color(32, 45, 112));
        label9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label9.setForeground(new java.awt.Color(255, 255, 255));
        label9.setText("Entradas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtcampo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncargarentradas)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtfolioconsultae, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcostalesconsutae, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtfechaconsultae, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtpesoconsultae, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txtcorreoconsutae, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txteportacionconsutae, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(btnmodificarconsultase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnelininarconsultae))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txttelefonoconsutlae, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txtnombreconsultae, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(btncargarentradas))
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfolioconsultae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombreconsultae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttelefonoconsutlae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcorreoconsutae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txteportacionconsutae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfechaconsultae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpesoconsultae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcostalesconsutae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnelininarconsultae)
                            .addComponent(btnmodificarconsultase)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar entradas", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jtventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Folio", "Nombre", "Telefono", "Exportacion", "Fecha", "Cantidad", "Tamaño", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtventas.setShowHorizontalLines(true);
        jtventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtventasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtventas);

        btncargarventas.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        btncargarventas.setText("cargar");
        btncargarventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarventasActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel41.setText("Folio");

        jLabel42.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel42.setText("Tamaño");

        jLabel43.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel43.setText("Cantidad");

        jLabel44.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel44.setText("Importe");

        jLabel45.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel45.setText("Nombre");

        jLabel46.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel46.setText("Telefono");

        jLabel47.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel47.setText("Exportacion");

        jLabel48.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel48.setText("Fecha");

        txtfolioconsultaventa.setEnabled(false);
        txtfolioconsultaventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfolioconsultaventaActionPerformed(evt);
            }
        });

        txttelefonoconsutlaventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoconsutlaventaActionPerformed(evt);
            }
        });

        txtfechaconsutaventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaconsutaventaActionPerformed(evt);
            }
        });

        btnmodificarconsultasventa.setText("Modificar");
        btnmodificarconsultasventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarconsultasventaActionPerformed(evt);
            }
        });

        btnelininarconsultaventa.setText("Eliminar");
        btnelininarconsultaventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelininarconsultaventaActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel49.setText("ID venta");

        label8.setAlignment(java.awt.Label.CENTER);
        label8.setBackground(new java.awt.Color(32, 45, 112));
        label8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label8.setForeground(new java.awt.Color(255, 255, 255));
        label8.setText("Ventas");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcampoventa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncargarventas)
                        .addGap(309, 309, 309))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(btnmodificarconsultasventa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnelininarconsultaventa))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(txtfolioconsultaventa, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(txtnombreconsultaventa, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel43)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel47)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txttamañoconsultaventa, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addComponent(txtimporteconsutaventa, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addComponent(txtcantidadconsultaventa, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addComponent(txtfechaconsutaventa, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addComponent(txtexportacionconsutaventa, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addComponent(txttelefonoconsutlaventa)))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(label8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfolioconsultaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombreconsultaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttelefonoconsutlaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtexportacionconsutaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfechaconsutaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcantidadconsultaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttamañoconsultaventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtimporteconsutaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnelininarconsultaventa)
                            .addComponent(btnmodificarconsultasventa))
                        .addGap(113, 113, 113))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txtcampoventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncargarventas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("Consultar ventas", jPanel7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jtproductores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID productor", "Nombre", "Telefono", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtproductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtproductoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtproductores);

        btncargarproductores.setText("Cargar");
        btncargarproductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarproductoresActionPerformed(evt);
            }
        });

        jLabel51.setText("ID productor");

        jLabel52.setText("Nombre");

        jLabel53.setText("Telefono");

        jLabel54.setText("Correo");

        txtidconsultaproductor2.setEnabled(false);
        txtidconsultaproductor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidconsultaproductor2ActionPerformed(evt);
            }
        });

        txtnombreproductorconsulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreproductorconsulta2ActionPerformed(evt);
            }
        });

        txtcorreoproductorconsulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoproductorconsulta2ActionPerformed(evt);
            }
        });

        jLabel55.setText("ID productor");

        btnmodificarproductores.setText("Modificar");
        btnmodificarproductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarproductoresActionPerformed(evt);
            }
        });

        btneliminarproductores.setText("Eliminar");
        btneliminarproductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarproductoresActionPerformed(evt);
            }
        });

        label7.setAlignment(java.awt.Label.CENTER);
        label7.setBackground(new java.awt.Color(32, 45, 112));
        label7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setText("Productores");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtcorreoproductorconsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel51)
                                                .addComponent(jLabel52))
                                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtidconsultaproductor2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnombreproductorconsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttelefonoproductorconsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 25, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnmodificarproductores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btneliminarproductores)
                                .addGap(17, 17, 17))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidproductorconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncargarproductores)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtidproductorconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargarproductores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtidconsultaproductor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(txtnombreproductorconsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(txttelefonoproductorconsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(txtcorreoproductorconsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnmodificarproductores)
                            .addComponent(btneliminarproductores)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        jTabbedPane1.addTab("Consultar productores", jPanel9);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jtclientes.setBackground(new java.awt.Color(221, 222, 249));
        jtclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID productor", "Nombre", "Telefono", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtclientesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtclientes);

        btncargarclientes.setText("Cargar");
        btncargarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarclientesActionPerformed(evt);
            }
        });

        jLabel56.setText("ID cliente");

        jLabel57.setText("Nombre");

        jLabel58.setText("Telefono");

        jLabel59.setText("Correo");

        txtidconsultacliente.setEnabled(false);
        txtidconsultacliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidconsultaclienteActionPerformed(evt);
            }
        });

        txtnombreclienteconsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreclienteconsultasActionPerformed(evt);
            }
        });

        txtcorreoclienteconsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoclienteconsultasActionPerformed(evt);
            }
        });

        jLabel60.setText("ID cliente");

        btnmodificarcliente.setText("Modificar");
        btnmodificarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarclienteActionPerformed(evt);
            }
        });

        btneliminarcliente.setText("Eliminar");
        btneliminarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarclienteActionPerformed(evt);
            }
        });

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(32, 45, 112));
        label1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Clientes");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(btnmodificarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btneliminarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtidconsultacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnombreclienteconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttelefonoclienteconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcorreoclienteconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidclienteconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncargarclientes)))
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtidclienteconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargarclientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(txtidconsultacliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(txtnombreclienteconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(txttelefonoclienteconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(txtcorreoclienteconsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnmodificarcliente)
                            .addComponent(btneliminarcliente))))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar clientes", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttelefonoventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoventaActionPerformed

    private void btnguardarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarventaActionPerformed
    Connection con = null;
        try {
                PreparedStatement ps;
    ResultSet rs;
            con = conexion.getConection();
            ps = con.prepareStatement("INSERT INTO venta_camion(nombre,telefono,exportacion,fecha,cantidad,tamaño,importe) VALUES(?,?,?,?,?,?,?)");

            java.util.Date fechaVenta = calendariofechaventa.getDate();
            java.sql.Date sqlFechaVenta = new java.sql.Date(fechaVenta.getTime());
            
            ps.setString(1, txtnombreventa.getText());
            ps.setString(2, txttelefonoventa.getText());
            ps.setString(3, cbexportacionventa.isSelected() ? "Sí" : "No");
            ps.setDate(4, sqlFechaVenta); 
            ps.setDouble(5, Double.parseDouble(txtcantidadventa.getText()));
            ps.setString(6, cbxtamanoventa.getSelectedItem().toString());
            ps.setDouble(7, Double.parseDouble(txtimporteventa.getText())); 
 
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Venta registrada");
                limpiarcajasventa();
            } else {
                JOptionPane.showMessageDialog(null, "error al registrar venta");
                limpiarcajasventa();
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnguardarventaActionPerformed

    private void txtguardarcorreoproductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtguardarcorreoproductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtguardarcorreoproductorActionPerformed

    private void btnguardarproductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarproductorActionPerformed
         Connection con = null;
             PreparedStatement ps;
    ResultSet rs;
        try {
            con = conexion.getConection();
            ps = con.prepareStatement("INSERT INTO productor(nombre_productor,telefono,correo) VALUES(?,?,?)");

            
            ps.setString(1, txtnombreguardarproductor.getText());
            ps.setString(2, txtguardatelefonoproductor.getText());
            ps.setString(3, txtguardarcorreoproductor.getText());
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Productor registrado");
                limpiarcajasregistroproductor();
            } else {
                JOptionPane.showMessageDialog(null, "error al registrar productor");
                limpiarcajasregistroproductor();
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnguardarproductorActionPerformed

    private void txtguardarcorreoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtguardarcorreoclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtguardarcorreoclienteActionPerformed

    private void btnguardarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarclienteActionPerformed
Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
        try {
            con = conexion.getConection();
            ps = con.prepareStatement("INSERT INTO cliente(nombre,telefono,correo) VALUES(?,?,?)");

            
            ps.setString(1, txtnombreguardarcliente.getText());
            ps.setString(2, txtguardatelefonocliente.getText());
            ps.setString(3, txtguardarcorreocliente.getText());
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Cliente registrado");
                limpiarcajasregistrocliente();
            } else {
                JOptionPane.showMessageDialog(null, "error al registrar cliente");
                limpiarcajasregistrocliente();
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }//GEN-LAST:event_btnguardarclienteActionPerformed

    private void btnbuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarclienteActionPerformed
  Connection con = null;
      PreparedStatement ps;
    ResultSet rs;
        try {
            con = conexion.getConection();
            ps = con.prepareStatement("SELECT*FROM cliente WHERE id_cliente=?");
            ps.setString(1, txtidcliente.getText());
            rs = ps.executeQuery();

            if (rs.next()) {
                txtnombreventa.setText(rs.getString("nombre"));
                txttelefonoventa.setText(rs.getString("telefono"));
            } else {
                JOptionPane.showMessageDialog(null, "no existe un cliente con esa clave");
            }
        } catch (Exception e) {
            System.out.println(e);
        }        
    }//GEN-LAST:event_btnbuscarclienteActionPerformed

    private void btncargarentradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarentradasActionPerformed
 
        String campo = txtcampo.getText();
        String where = "";
        
        if(!"".equals(campo))
        {
            where=" WHERE id_entrada = '" +campo+"'"; 
        }
        
        try{
         DefaultTableModel modelo = new DefaultTableModel();
         jtentradas.setModel(modelo);
         PreparedStatement ps = null;
         ResultSet rs=null;
         
         conexion conn = new conexion();
         
         Connection con =  conn.getConection();
         
         String sql ="SELECT id_entrada, nombre,telefono,correo,exportacion,fecha,peso,costales FROM entrada_camion" + where;
         
       
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         
         ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
         int  cantcolumnas = rsMd.getColumnCount();
         
         modelo.addColumn("folio");
         modelo.addColumn("nombre");
         modelo.addColumn("telefono");
         modelo.addColumn("correo");
         modelo.addColumn("Exportacion");
         modelo.addColumn("fecha");
         modelo.addColumn("peso");
         modelo.addColumn("costales");
         
         int[] anchos={30,150,50,150,50,50,50,50};
         
         for(int x=0; x < cantcolumnas; x++){
             jtentradas.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
         }
         
         
         while(rs.next())
         {
          Object[] filas = new Object[cantcolumnas];
          
          for(int i=0;i<cantcolumnas;i++){
              filas[i]=rs.getObject(i+1);
          }
          modelo.addRow(filas);
         }
         
         
     }catch(Exception e){
         System.out.println(e);
     }      
    }//GEN-LAST:event_btncargarentradasActionPerformed

    private void jtentradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtentradasMouseClicked
       PreparedStatement ps = null;
       ResultSet rs = null;
       
       try{
           conexion objcon = new conexion();
           Connection conn = objcon.getConection();
           int fila = jtentradas.getSelectedRow();
           String id = jtentradas.getValueAt(fila, 0).toString();
           
           ps=conn.prepareStatement("SELECT id_entrada,nombre,telefono,correo,exportacion,fecha,peso,costales FROM entrada_camion WHERE id_entrada=?");
           ps.setString(1, id);
           rs = ps.executeQuery();
           
           while(rs.next())
           {
               txtfolioconsultae.setText(rs.getString("id_entrada"));
               txtnombreconsultae.setText(rs.getString("nombre"));
               txttelefonoconsutlae.setText(rs.getString("telefono"));
               txtcorreoconsutae.setText(rs.getString("correo"));
               txteportacionconsutae.setText(rs.getString("exportacion"));
               txtfechaconsultae.setText(rs.getString("fecha"));
               txtpesoconsultae.setText(rs.getString("peso"));
               txtcostalesconsutae.setText(rs.getString("costales"));
               
           }
       }catch(Exception e){
           System.out.println(e);
       }
    }//GEN-LAST:event_jtentradasMouseClicked

    private void txtfolioconsultaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfolioconsultaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfolioconsultaeActionPerformed

    private void txttelefonoconsutlaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoconsutlaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoconsutlaeActionPerformed

    private void btnelininarconsultaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelininarconsultaeActionPerformed
     DefaultTableModel modelo = (DefaultTableModel) jtentradas.getModel();
        PreparedStatement ps = null;
     try {
         conexion objcon = new conexion();
           Connection conn = objcon.getConection();
           int fila = jtentradas.getSelectedRow();
           String id = jtentradas.getValueAt(fila, 0).toString();
           
            ps=conn.prepareStatement("DELETE FROM entrada_camion WHERE id_entrada=?");
           ps.setString(1, id);
           ps.execute();
           
           modelo.removeRow(fila);
           JOptionPane.showMessageDialog(null, "Entrada eliminada");
           
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Error al modificar entrada");
         System.out.println(e);
     }
    }//GEN-LAST:event_btnelininarconsultaeActionPerformed

    private void btnmodificarconsultaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarconsultaseActionPerformed
       
        PreparedStatement ps = null;
        try{
             conexion objcon = new conexion();
           Connection conn = objcon.getConection();
           ps=conn.prepareStatement("UPDATE entrada_camion SET nombre=?, telefono=?, correo=?,exportacion=?, fecha=?, peso=?, costales=? WHERE id_entrada=?");
         ps.setString(1, txtnombreconsultae.getText());
         ps.setString(2,txttelefonoconsutlae.getText());
         ps.setString(3,txtcorreoconsutae.getText());
         ps.setString(4,txteportacionconsutae.getText());
         ps.setString(5,txtfechaconsultae.getText());
         ps.setString(6,txtpesoconsultae.getText());
         ps.setString(7,txtcostalesconsutae.getText());
         ps.setString(8, txtfolioconsultae.getText());
     
         ps.execute();
         
          JOptionPane.showMessageDialog(null, "entrada modificada");
         cargarDatosEnTabla();
         
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Error al modificar entrada");
            System.out.println(e);
        }
    }//GEN-LAST:event_btnmodificarconsultaseActionPerformed

    private void jtventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtventasMouseClicked
   
         PreparedStatement ps = null;
       ResultSet rs = null;
       
       try{
           conexion objcon = new conexion();
           Connection conn = objcon.getConection();
           int fila = jtventas.getSelectedRow();
           String id = jtventas.getValueAt(fila, 0).toString();
           
           ps=conn.prepareStatement("SELECT id_venta,nombre,telefono,exportacion,fecha,cantidad,tamaño,importe FROM venta_camion WHERE id_venta=?");
           ps.setString(1, id);
           rs = ps.executeQuery();
           
           while(rs.next())
           {
               txtfolioconsultaventa.setText(rs.getString("id_venta"));
               txtnombreconsultaventa.setText(rs.getString("nombre"));
               txttelefonoconsutlaventa.setText(rs.getString("telefono"));
               txtexportacionconsutaventa.setText(rs.getString("exportacion"));
               txtfechaconsutaventa.setText(rs.getString("fecha"));
               txtcantidadconsultaventa.setText(rs.getString("cantidad"));
               txttamañoconsultaventa.setText(rs.getString("tamaño"));
               txtimporteconsutaventa.setText(rs.getString("importe"));
               
           }
       }catch(Exception e){
           System.out.println(e);
       }

        
        
        
    }//GEN-LAST:event_jtventasMouseClicked

    private void btncargarventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarventasActionPerformed
       
        String campo = txtcampoventa.getText();
        String where = "";
        
        if(!"".equals(campo))
        {
            where=" WHERE id_venta = '" +campo+"'"; 
        }
        
        try{
         DefaultTableModel modelo = new DefaultTableModel();
         jtventas.setModel(modelo);
         PreparedStatement ps = null;
         ResultSet rs=null;
         
         conexion conn = new conexion();
         
         Connection con =  conn.getConection();
         
         String sql ="SELECT id_venta, nombre,telefono,exportacion,fecha,cantidad,tamaño,importe FROM venta_camion" + where;
         
       
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         
         ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
         int  cantcolumnas = rsMd.getColumnCount();
         
         modelo.addColumn("folio");
         modelo.addColumn("nombre");
         modelo.addColumn("telefono");
         modelo.addColumn("Exportacion");
         modelo.addColumn("fecha");
         modelo.addColumn("cantidad");
         modelo.addColumn("tamalo");
         modelo.addColumn("importe");
         
         int[] anchos={30,150,100,30,50,50,100,50};
         
         for(int x=0; x < cantcolumnas; x++){
             jtentradas.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
         }
         
         
         while(rs.next())
         {
          Object[] filas = new Object[cantcolumnas];
          
          for(int i=0;i<cantcolumnas;i++){
              filas[i]=rs.getObject(i+1);
          }
          modelo.addRow(filas);
         }
         
         
     }catch(Exception e){
         System.out.println(e);
     } 
        
    }//GEN-LAST:event_btncargarventasActionPerformed

    private void txtfolioconsultaventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfolioconsultaventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfolioconsultaventaActionPerformed

    private void txttelefonoconsutlaventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoconsutlaventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoconsutlaventaActionPerformed
   
    
    private void btnmodificarconsultasventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarconsultasventaActionPerformed
     
        
          PreparedStatement ps = null;
        try{
             conexion objcon = new conexion();
           Connection conn = objcon.getConection();
           ps=conn.prepareStatement("UPDATE venta_camion SET nombre=?, telefono=?,exportacion=?, fecha=?, cantidad=?, tamaño=?,importe=? WHERE id_venta=?");
         ps.setString(1, txtnombreconsultaventa.getText());
         ps.setString(2,txttelefonoconsutlaventa.getText());
         ps.setString(3,txtexportacionconsutaventa.getText());
         ps.setString(4,txtfechaconsutaventa.getText());
         ps.setString(5,txtcantidadconsultaventa.getText());
         ps.setString(6,txttamañoconsultaventa.getText());
         ps.setString(7, txtimporteconsutaventa.getText());
         ps.setString(8, txtfolioconsultaventa.getText());
         ps.execute();
         
          JOptionPane.showMessageDialog(null, "venta modificada");
         cargarDatosEnTablaventa();
         
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Error al modificar venta");
            System.out.println(e);
        }
        
        
        
    }//GEN-LAST:event_btnmodificarconsultasventaActionPerformed

    private void btnelininarconsultaventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelininarconsultaventaActionPerformed
         
        DefaultTableModel modelo = (DefaultTableModel) jtventas.getModel();
        PreparedStatement ps = null;
     try {
         conexion objcon = new conexion();
           Connection conn = objcon.getConection();
           int fila = jtventas.getSelectedRow();
           String id = jtventas.getValueAt(fila, 0).toString();
           
            ps=conn.prepareStatement("DELETE FROM venta_camion WHERE id_venta=?");
           ps.setString(1, id);
           ps.execute();
           
           modelo.removeRow(fila);
           
            JOptionPane.showMessageDialog(null, "Venta eliminada");
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Error al eliminar venta");
         System.out.println(e);
     }
        
        
    }//GEN-LAST:event_btnelininarconsultaventaActionPerformed

    private void txtfechaconsutaventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaconsutaventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaconsutaventaActionPerformed

    private void btneliminarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarclienteActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) jtclientes.getModel();
        PreparedStatement ps = null;
        try {
            conexion objcon = new conexion();
            Connection conn = objcon.getConection();
            int fila = jtclientes.getSelectedRow();
            String id = jtclientes.getValueAt(fila, 0).toString();

            ps=conn.prepareStatement("DELETE FROM cliente WHERE id_cliente=?");
            ps.setString(1, id);
            ps.execute();

            modelo.removeRow(fila);

            JOptionPane.showMessageDialog(null, "cliente eliminado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente");
            System.out.println(e);
        }

    }//GEN-LAST:event_btneliminarclienteActionPerformed

    private void btnmodificarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarclienteActionPerformed

        PreparedStatement ps = null;
        try{
            conexion objcon = new conexion();
            Connection conn = objcon.getConection();
            ps=conn.prepareStatement("UPDATE cliente SET nombre=?, telefono=?,correo=? WHERE id_cliente=? ");
            ps.setString(1, txtnombreclienteconsultas.getText());
            ps.setString(2,txttelefonoclienteconsultas.getText());
            ps.setString(3,txtcorreoclienteconsultas.getText());
            ps.setString(4,txtidconsultacliente.getText());
            ps.execute();

            JOptionPane.showMessageDialog(null, "Datos modificados");
            cargarDatosEnTablaclientes();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al modificar Datos");
            System.out.println(e);
        }

    }//GEN-LAST:event_btnmodificarclienteActionPerformed

    private void txtcorreoclienteconsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoclienteconsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoclienteconsultasActionPerformed

    private void txtnombreclienteconsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreclienteconsultasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreclienteconsultasActionPerformed

    private void txtidconsultaclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidconsultaclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidconsultaclienteActionPerformed

    private void btncargarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarclientesActionPerformed

        String campo = txtidclienteconsultas.getText();
        String where = "";

        if(!"".equals(campo))
        {
            where=" WHERE id_cliente = '" +campo+"'";
        }

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            jtclientes.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs=null;

            conexion conn = new conexion();

            Connection con =  conn.getConection();

            String sql ="SELECT id_cliente,nombre,telefono,correo FROM cliente" + where;

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int  cantcolumnas = rsMd.getColumnCount();

            modelo.addColumn("ID cliente");
            modelo.addColumn("nombre");
            modelo.addColumn("telefono");
            modelo.addColumn("correo");

            int[] anchos={30,250,150,250};

            for(int x=0; x < cantcolumnas; x++){
                jtclientes.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }

            while(rs.next())
            {
                Object[] filas = new Object[cantcolumnas];

                for(int i=0;i<cantcolumnas;i++){
                    filas[i]=rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_btncargarclientesActionPerformed

    private void jtclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtclientesMouseClicked

        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conexion objcon = new conexion();
            Connection conn = objcon.getConection();
            int fila = jtclientes.getSelectedRow();
            String id = jtclientes.getValueAt(fila, 0).toString();

            ps=conn.prepareStatement("SELECT id_cliente,nombre,telefono,correo FROM cliente WHERE id_cliente=?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            while(rs.next())
            {
                txtidconsultacliente.setText(rs.getString("id_cliente"));
                txtnombreclienteconsultas.setText(rs.getString("nombre"));
                txttelefonoclienteconsultas.setText(rs.getString("telefono"));
                txtcorreoclienteconsultas.setText(rs.getString("correo"));

            }
        }catch(Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_jtclientesMouseClicked

    private void btneliminarproductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarproductoresActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) jtproductores.getModel();
        PreparedStatement ps = null;
        try {
            conexion objcon = new conexion();
            Connection conn = objcon.getConection();
            int fila = jtproductores.getSelectedRow();
            String id = jtproductores.getValueAt(fila, 0).toString();

            ps=conn.prepareStatement("DELETE FROM productor WHERE id_productor=?");
            ps.setString(1, id);
            ps.execute();

            modelo.removeRow(fila);

            JOptionPane.showMessageDialog(null, "productor eliminado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar productor");
            System.out.println(e);
        }

    }//GEN-LAST:event_btneliminarproductoresActionPerformed

    private void btnmodificarproductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarproductoresActionPerformed

        PreparedStatement ps = null;
        try{
            conexion objcon = new conexion();
            Connection conn = objcon.getConection();
            ps=conn.prepareStatement("UPDATE productor SET nombre_productor=?, telefono=?,correo=? WHERE id_productor=? ");
            ps.setString(1, txtnombreproductorconsulta2.getText());
            ps.setString(2,txttelefonoproductorconsulta2.getText());
            ps.setString(3,txtcorreoproductorconsulta2.getText());
            ps.setString(4,txtidconsultaproductor2.getText());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Datos modificados");
            cargarDatosEnTablaproductores();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al modificar Datos");
            System.out.println(e);
        }

    }//GEN-LAST:event_btnmodificarproductoresActionPerformed

    private void txtcorreoproductorconsulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoproductorconsulta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoproductorconsulta2ActionPerformed

    private void txtnombreproductorconsulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreproductorconsulta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreproductorconsulta2ActionPerformed

    private void txtidconsultaproductor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidconsultaproductor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidconsultaproductor2ActionPerformed

    private void btncargarproductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarproductoresActionPerformed

        String campo = txtidproductorconsultas.getText();
        String where = "";

        if(!"".equals(campo))
        {
            where=" WHERE id_productor = '" +campo+"'";
        }

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            jtproductores.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs=null;

            conexion conn = new conexion();

            Connection con =  conn.getConection();

            String sql ="SELECT id_productor,nombre_productor,telefono,correo FROM productor" + where;

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int  cantcolumnas = rsMd.getColumnCount();

            modelo.addColumn("ID productor");
            modelo.addColumn("nombre");
            modelo.addColumn("telefono");
            modelo.addColumn("correo");

            int[] anchos={30,250,150,250};

            for(int x=0; x < cantcolumnas; x++){
                jtproductores.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }

            while(rs.next())
            {
                Object[] filas = new Object[cantcolumnas];

                for(int i=0;i<cantcolumnas;i++){
                    filas[i]=rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btncargarproductoresActionPerformed

    private void jtproductoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtproductoresMouseClicked

        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conexion objcon = new conexion();
            Connection conn = objcon.getConection();
            int fila = jtproductores.getSelectedRow();
            String id = jtproductores.getValueAt(fila, 0).toString();

            ps=conn.prepareStatement("SELECT id_productor,nombre_productor,telefono,correo FROM productor WHERE id_productor=?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            while(rs.next())
            {
                txtidconsultaproductor2.setText(rs.getString("id_productor"));
                txtnombreproductorconsulta2.setText(rs.getString("nombre_productor"));
                txttelefonoproductorconsulta2.setText(rs.getString("telefono"));
                txtcorreoproductorconsulta2.setText(rs.getString("correo"));

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jtproductoresMouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void btnregistrarnuevousuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarnuevousuarioActionPerformed
         if(frmreg==null){
       frmreg = new registro();
       frmreg.setVisible(true);
       
       
    }   
        
    }//GEN-LAST:event_btnregistrarnuevousuarioActionPerformed

    private void btncerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsesionActionPerformed
       
        
                // 1. Confirmar cierre de sesión (opcional)
    int confirm = JOptionPane.showConfirmDialog(this, 
        "¿Estás seguro de que deseas cerrar sesión?", 
        "Confirmar Cierre de Sesión", 
        JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        // 2. Limpiar información de la sesión
       

        // 3. Cerrar la ventana actual
        this.dispose(); // Cierra el JFrame actual

        // 4. Abrir la ventana de inicio de sesión
        login frmLogin = new login();
        frmLogin.setVisible(true);
    }
        
        
        
    }//GEN-LAST:event_btncerrarsesionActionPerformed

    private void btnbuscarproductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarproductorActionPerformed
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            con = conexion.getConection();
            ps = con.prepareStatement("SELECT*FROM productor WHERE id_productor=?");
            ps.setString(1, txtidproductor.getText());
            rs = ps.executeQuery();

            if (rs.next()) {
                txtnombre.setText(rs.getString("nombre_productor"));
                txttelefono.setText(rs.getString("telefono"));
                txtcorreo.setText(rs.getString("correo"));
            } else {
                JOptionPane.showMessageDialog(null, "no existe un productor con esa clave");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnbuscarproductorActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            con = conexion.getConection();
            ps = con.prepareStatement("INSERT INTO entrada_camion(nombre,telefono,correo,exportacion,fecha,peso,costales) VALUES(?,?,?,?,?,?,?)");

            java.util.Date fechaentrada = calendariofechaentrada.getDate();
            java.sql.Date sqlFechaentrada = new java.sql.Date(fechaentrada.getTime());

            ps.setString(1, txtnombre.getText());
            ps.setString(2, txttelefono.getText());
            ps.setString(3, txtcorreo.getText());
            ps.setString(4, cbexportacion.isSelected() ? "Sí" : "No");
            ps.setDate(5, sqlFechaentrada);
            ps.setDouble(6, Double.parseDouble(txtpeso.getText()));
            ps.setInt(7, Integer.parseInt(txtnumero_costales.getText()));

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Entrada registrada");
                limpiarcajasentrada();
            } else {
                JOptionPane.showMessageDialog(null, "error al registrar entrada");
                limpiarcajasentrada();
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtpesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesoActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscarcliente;
    private javax.swing.JButton btnbuscarproductor;
    private javax.swing.JButton btncargarclientes;
    private javax.swing.JButton btncargarentradas;
    private javax.swing.JButton btncargarproductores;
    private javax.swing.JButton btncargarventas;
    private javax.swing.JButton btncerrarsesion;
    private javax.swing.JButton btneliminarcliente;
    private javax.swing.JButton btneliminarproductores;
    private javax.swing.JButton btnelininarconsultae;
    private javax.swing.JButton btnelininarconsultaventa;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardarcliente;
    private javax.swing.JButton btnguardarproductor;
    private javax.swing.JButton btnguardarventa;
    private javax.swing.JButton btnmodificarcliente;
    private javax.swing.JButton btnmodificarconsultase;
    private javax.swing.JButton btnmodificarconsultasventa;
    private javax.swing.JButton btnmodificarproductores;
    private javax.swing.JButton btnregistrarnuevousuario;
    private javax.swing.JCheckBox cbexportacion;
    private javax.swing.JCheckBox cbexportacionventa;
    private javax.swing.JComboBox<String> cbxtamanoventa;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable jtclientes;
    private javax.swing.JTable jtentradas;
    private javax.swing.JTable jtproductores;
    private javax.swing.JTable jtventas;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JPanel lblnombresesion;
    private javax.swing.JLabel lblnombresesioniniciada;
    private javax.swing.JPanel lblrol;
    private javax.swing.JLabel lblroliniciomostrar;
    private javax.swing.JLabel lblroluser;
    private javax.swing.JTextField txtcampo;
    private javax.swing.JTextField txtcampoventa;
    private javax.swing.JTextField txtcantidadconsultaventa;
    private javax.swing.JTextField txtcantidadventa;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtcorreoclienteconsultas;
    private javax.swing.JTextField txtcorreoconsutae;
    private javax.swing.JTextField txtcorreoproductorconsulta2;
    private javax.swing.JTextField txtcostalesconsutae;
    private javax.swing.JTextField txteportacionconsutae;
    private javax.swing.JTextField txtexportacionconsutaventa;
    private javax.swing.JTextField txtfechaconsultae;
    private javax.swing.JTextField txtfechaconsutaventa;
    private javax.swing.JTextField txtfolio;
    private javax.swing.JTextField txtfolioconsultae;
    private javax.swing.JTextField txtfolioconsultaventa;
    private javax.swing.JTextField txtguardarcorreocliente;
    private javax.swing.JTextField txtguardarcorreoproductor;
    private javax.swing.JTextField txtguardatelefonocliente;
    private javax.swing.JTextField txtguardatelefonoproductor;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtidclienteconsultas;
    private javax.swing.JTextField txtidconsultacliente;
    private javax.swing.JTextField txtidconsultaproductor2;
    private javax.swing.JTextField txtidproductor;
    private javax.swing.JTextField txtidproductorconsultas;
    private javax.swing.JTextField txtimporteconsutaventa;
    private javax.swing.JTextField txtimporteventa;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombreclienteconsultas;
    private javax.swing.JTextField txtnombreconsultae;
    private javax.swing.JTextField txtnombreconsultaventa;
    private javax.swing.JTextField txtnombreguardarcliente;
    private javax.swing.JTextField txtnombreguardarproductor;
    private javax.swing.JTextField txtnombreproductorconsulta2;
    private javax.swing.JTextField txtnombreventa;
    private javax.swing.JTextField txtnumero_costales;
    private javax.swing.JTextField txtpeso;
    private javax.swing.JTextField txtpesoconsultae;
    private javax.swing.JTextField txttamañoconsultaventa;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttelefonoclienteconsultas;
    private javax.swing.JTextField txttelefonoconsutlae;
    private javax.swing.JTextField txttelefonoconsutlaventa;
    private javax.swing.JTextField txttelefonoproductorconsulta2;
    private javax.swing.JTextField txttelefonoventa;
    // End of variables declaration//GEN-END:variables
}
