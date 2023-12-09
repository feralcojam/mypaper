package ui;

import connections.Connect;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Home extends javax.swing.JFrame {

    CardLayout cl;
    Color true_blue = new Color(45, 104, 196);
    Color true_light_blue = new Color(65, 144, 206);
    Color celestial = new Color(73, 151, 208);
    Color aero = new Color(0, 185, 232);
    Color lapis = new Color(5, 92, 157);
    Color gray = new Color(224, 224, 224);

    public Home() {
        initComponents();
        search_bar_tf.setOpaque(false);
        nombre_tf.setOpaque(false);
        id_proveedor_tf.setOpaque(false);
        cantidad_tf.setOpaque(false);
        precio_tf.setOpaque(false);
        rellenar_combobox();
        rellenar_combobox_inventario();
        ///////////////////
        /////////////////////////
        // objetos para personalizar tabla
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        dtcr.setBackground(aero);
        dtcr.setForeground(Color.white);
        // termin objetos para personalizar tabla
        // config tabla pos
        jScrollPane1.getViewport().setBackground(celestial);
        cart_table.setFillsViewportHeight(true);
        cart_table.setUI(new BasicTableUI());
        cart_table.getTableHeader().getColumnModel().getColumn(0).
                setHeaderRenderer(dtcr);
        cart_table.getTableHeader().getColumnModel().getColumn(1).
                setHeaderRenderer(dtcr);
        cart_table.getTableHeader().getColumnModel().getColumn(2).
                setHeaderRenderer(dtcr);
        cart_table.setRowHeight(25);
        cart_table.setFont(new Font("SansSerif", Font.PLAIN, 18));
        cart_table.setForeground(gray);
        cart_table.setBackground(lapis);
        TableColumnModel tcm = cart_table.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(490);
        tcm.getColumn(0).setMaxWidth(1080);
        tcm.getColumn(0).setMinWidth(490);
        tcm.getColumn(1).setPreferredWidth(60);
        tcm.getColumn(1).setMaxWidth(60);
        tcm.getColumn(2).setPreferredWidth(100);
        tcm.getColumn(2).setMaxWidth(100);
        // termino config tabla pos
        // config tabla inventario
        jScrollPane2.getViewport().setBackground(celestial);
        inventory_table.setFillsViewportHeight(true);
        inventory_table.setUI(new BasicTableUI());
        inventory_table.getTableHeader().getColumnModel().getColumn(0).
                setHeaderRenderer(dtcr);
        inventory_table.getTableHeader().getColumnModel().getColumn(1).
                setHeaderRenderer(dtcr);
        inventory_table.getTableHeader().getColumnModel().getColumn(2).
                setHeaderRenderer(dtcr);
        inventory_table.getTableHeader().getColumnModel().getColumn(3).
                setHeaderRenderer(dtcr);
        inventory_table.setRowHeight(25);
        inventory_table.setFont(new Font("SansSerif", Font.PLAIN, 18));
        inventory_table.setForeground(gray);
        inventory_table.setBackground(lapis);
        TableColumnModel tcm2 = inventory_table.getColumnModel();
        tcm2.getColumn(0).setPreferredWidth(300);
        tcm2.getColumn(0).setMaxWidth(1080);
        tcm2.getColumn(0).setMinWidth(300);
        tcm2.getColumn(1).setPreferredWidth(200);
        tcm2.getColumn(1).setMaxWidth(200);
        tcm2.getColumn(2).setPreferredWidth(150);
        tcm2.getColumn(2).setMaxWidth(150);
        tcm2.getColumn(3).setPreferredWidth(150);
        tcm2.getColumn(3).setMaxWidth(150);
        // termino config tabla inventario
        // config tabla usuarios
        jScrollPane3.getViewport().setBackground(celestial);
        user_table.setFillsViewportHeight(true);
        user_table.setUI(new BasicTableUI());
        user_table.getTableHeader().getColumnModel().getColumn(0).
                setHeaderRenderer(dtcr);
        user_table.getTableHeader().getColumnModel().getColumn(1).
                setHeaderRenderer(dtcr);
        user_table.getTableHeader().getColumnModel().getColumn(2).
                setHeaderRenderer(dtcr);
        user_table.getTableHeader().getColumnModel().getColumn(3).
                setHeaderRenderer(dtcr);
        user_table.setRowHeight(25);
        user_table.setFont(new Font("SansSerif", Font.PLAIN, 18));
        user_table.setForeground(gray);
        user_table.setBackground(lapis);
        TableColumnModel tcm3 = user_table.getColumnModel();
        tcm3.getColumn(0).setPreferredWidth(60);
        tcm3.getColumn(0).setMaxWidth(60);
        tcm3.getColumn(0).setMinWidth(60);
        tcm3.getColumn(1).setPreferredWidth(200);
        tcm3.getColumn(1).setMaxWidth(1000);
        tcm3.getColumn(2).setPreferredWidth(200);
        tcm3.getColumn(2).setMaxWidth(1000);
        tcm3.getColumn(3).setPreferredWidth(60);
        tcm3.getColumn(3).setMaxWidth(60);
        // termino config tabla usuarios
        cl = (CardLayout) card_panel.getLayout();

        ajustar_modelo_general();
        ajustar_modelo_general_inventario();

        user_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = user_table.getSelectedRow();
                    if (selectedRow != -1) {
                        jLabel7.setIcon(null);
                        Object value1 = user_table.getValueAt(selectedRow, 0);
                        Object value2 = user_table.getValueAt(selectedRow, 1);
                        nombre_tf1.setText(value1.toString());
                        contraseña_tf2.setText(value2.toString());
                    }
                }
            }
        });
        
        inventory_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = inventory_table.getSelectedRow();
                    if (selectedRow != -1) {
                        jLabel7.setIcon(null);
                        Object value1 = inventory_table.getValueAt(selectedRow, 0);
                        Object value2 = inventory_table.getValueAt(selectedRow, 1);
                        Object value3 = inventory_table.getValueAt(selectedRow, 2);
                        Object value4 = inventory_table.getValueAt(selectedRow, 3);
                        nombre_tf.setText(value1.toString());
                        id_proveedor_tf.setText(value2.toString());
                        cantidad_tf.setText(value3.toString());
                        precio_tf.setText(value4.toString());
                    }
                }
            }
        });
    }

    public void rellenar_combobox() {
        Connect bd = new Connect();
        Vector<String> Nombres = new Vector<String>();
        Nombres = bd.Nombre_usuarios();
        for (String elemento : Nombres) {
            combob_buscar1.addItem(elemento);
        }
    }

    public void rellenar_combobox_inventario() {
        Connect bd = new Connect();
        Vector<String> Nombres = new Vector<String>();
        Nombres = bd.Nombre_producto();
        for (String elemento : Nombres) {
            combob_buscar.addItem(elemento);
        }
    }
    
    public void ajustar_modelo(String nombre) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        modelo.addColumn("Nombre");
        modelo.addColumn("Contraseña");
        Connect bd = new Connect();
        modelo = bd.Info_usuario(nombre, modelo);
        user_table.setModel(modelo);
    }
    
    public void ajustar_modelo_inventario(String nombre) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        modelo.addColumn("Nombre");
        modelo.addColumn("ID_PROVEEDOR");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        Connect bd = new Connect();
        modelo = bd.Info_inventario(nombre, modelo);
        inventory_table.setModel(modelo);
    }

    public void ajustar_modelo_general() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        modelo.addColumn("Nombre");
        modelo.addColumn("Contraseña");
        Connect bd = new Connect();
        modelo = bd.Info_todos_usuarios(modelo);
        user_table.setModel(modelo);
    }

    public void ajustar_modelo_general_inventario() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnCount(0);
        modelo.setNumRows(0);
        modelo.addColumn("Nombre");
        modelo.addColumn("ID_PROVEEDOR");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO");
        Connect bd = new Connect();
        modelo = bd.Info_todos_inventario(modelo);
        inventory_table.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        left_panel = new javax.swing.JPanel();
        logo_image = new javax.swing.JLabel();
        pos_button = new javax.swing.JLabel();
        user_button = new javax.swing.JLabel();
        inventory_button = new javax.swing.JLabel();
        back_button = new javax.swing.JLabel();
        card_panel = new javax.swing.JPanel();
        pos_card = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        search_bar_tf = new javax.swing.JTextField();
        search_button = new javax.swing.JLabel();
        qty_bar = new javax.swing.JTextField();
        qty_add = new javax.swing.JLabel();
        title_label1 = new javax.swing.JLabel();
        title_label2 = new javax.swing.JLabel();
        title_label3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cart_table = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        total_label = new javax.swing.JLabel();
        pago_label = new javax.swing.JLabel();
        cambio_label = new javax.swing.JLabel();
        separator3 = new javax.swing.JSeparator();
        title_label4 = new javax.swing.JLabel();
        inventory_card = new javax.swing.JPanel();
        combob_buscar = new javax.swing.JComboBox<>();
        boton_buscar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boton_actualizar = new javax.swing.JLabel();
        boton_guardar = new javax.swing.JLabel();
        boton_eliminar = new javax.swing.JLabel();
        separator2 = new javax.swing.JSeparator();
        nombre_tf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        id_proveedor_tf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cantidad_tf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        precio_tf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        inventory_table = new javax.swing.JTable();
        user_card = new javax.swing.JPanel();
        combob_buscar1 = new javax.swing.JComboBox<>();
        boton_buscar_usuario = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        boton_actualizar_usuario = new javax.swing.JLabel();
        boton_guardar_usuario = new javax.swing.JLabel();
        boton_eliminar_usuario = new javax.swing.JLabel();
        nombre_tf1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        contraseña_tf2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        separator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1360, 768));

        jSplitPane1.setDividerSize(0);

        left_panel.setBackground(new java.awt.Color(45, 104, 196));

        logo_image.setBackground(new java.awt.Color(45, 104, 196));
        logo_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo64.png"))); // NOI18N
        logo_image.setOpaque(true);
        logo_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logo_imageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logo_imageMouseExited(evt);
            }
        });

        pos_button.setBackground(new java.awt.Color(45, 104, 196));
        pos_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pos_button.setForeground(new java.awt.Color(204, 204, 204));
        pos_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos_button.setText("P.O.S.");
        pos_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pos_button.setOpaque(true);
        pos_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pos_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pos_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pos_buttonMouseExited(evt);
            }
        });

        user_button.setBackground(new java.awt.Color(45, 104, 196));
        user_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        user_button.setForeground(new java.awt.Color(204, 204, 204));
        user_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user_button.setText("Usuarios");
        user_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user_button.setOpaque(true);
        user_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                user_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                user_buttonMouseExited(evt);
            }
        });

        inventory_button.setBackground(new java.awt.Color(45, 104, 196));
        inventory_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inventory_button.setForeground(new java.awt.Color(204, 204, 204));
        inventory_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventory_button.setText("Inventario");
        inventory_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventory_button.setOpaque(true);
        inventory_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventory_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventory_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventory_buttonMouseExited(evt);
            }
        });

        back_button.setBackground(new java.awt.Color(45, 104, 196));
        back_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back_button.setForeground(new java.awt.Color(204, 204, 204));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setText("Volver");
        back_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_button.setOpaque(true);
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back_buttonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout left_panelLayout = new javax.swing.GroupLayout(left_panel);
        left_panel.setLayout(left_panelLayout);
        left_panelLayout.setHorizontalGroup(
            left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(logo_image, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addComponent(pos_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(user_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inventory_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(back_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        left_panelLayout.setVerticalGroup(
            left_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(left_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logo_image, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(pos_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inventory_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(user_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(left_panel);

        card_panel.setLayout(new java.awt.CardLayout());

        pos_card.setBackground(new java.awt.Color(255, 255, 255));

        title_label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title_label.setForeground(new java.awt.Color(5, 92, 157));
        title_label.setText("MyPaper - Punto de Venta");

        separator1.setBackground(new java.awt.Color(5, 92, 157));

        search_bar_tf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        search_bar_tf.setForeground(new java.awt.Color(51, 51, 51));
        search_bar_tf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        search_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_len.png"))); // NOI18N
        search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search_buttonMouseExited(evt);
            }
        });

        qty_bar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        qty_bar.setForeground(new java.awt.Color(51, 51, 51));
        qty_bar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty_bar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        qty_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/qty.png"))); // NOI18N
        qty_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qty_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                qty_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                qty_addMouseExited(evt);
            }
        });

        title_label1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title_label1.setForeground(new java.awt.Color(5, 92, 157));
        title_label1.setText("Cliente: MyPaper");

        title_label2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title_label2.setForeground(new java.awt.Color(5, 92, 157));
        title_label2.setText("Le atiende: Vendedor");

        title_label3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        title_label3.setForeground(new java.awt.Color(5, 92, 157));
        title_label3.setText("Cobro");

        cart_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Qty", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cart_table.setOpaque(false);
        jScrollPane1.setViewportView(cart_table);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(5, 92, 157));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(5, 92, 157));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Pago");

        jLabel14.setBackground(new java.awt.Color(45, 61, 130));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Cambio");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));
        jLabel14.setOpaque(true);

        total_label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        total_label.setForeground(new java.awt.Color(5, 92, 157));
        total_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_label.setText("$ 00.00");

        pago_label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        pago_label.setForeground(new java.awt.Color(5, 92, 157));
        pago_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pago_label.setText("$ 00.00");

        cambio_label.setBackground(new java.awt.Color(45, 61, 130));
        cambio_label.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cambio_label.setForeground(new java.awt.Color(255, 255, 255));
        cambio_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cambio_label.setText("$ 00.00");
        cambio_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));
        cambio_label.setOpaque(true);

        separator3.setBackground(new java.awt.Color(5, 92, 157));

        title_label4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title_label4.setForeground(new java.awt.Color(5, 92, 157));
        title_label4.setText("Carrito");

        javax.swing.GroupLayout pos_cardLayout = new javax.swing.GroupLayout(pos_card);
        pos_card.setLayout(pos_cardLayout);
        pos_cardLayout.setHorizontalGroup(
            pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pos_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pos_cardLayout.createSequentialGroup()
                        .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pos_cardLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(qty_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qty_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pos_cardLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(separator3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pos_cardLayout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(cambio_label, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pos_cardLayout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(pago_label, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pos_cardLayout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(total_label, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pos_cardLayout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(title_label3)))
                        .addGap(96, 96, 96))
                    .addGroup(pos_cardLayout.createSequentialGroup()
                        .addComponent(search_bar_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pos_cardLayout.createSequentialGroup()
                        .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(separator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pos_cardLayout.createSequentialGroup()
                                .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addGap(225, 225, 225)
                                .addComponent(title_label2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                .addGap(218, 218, 218)
                                .addComponent(title_label1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
                        .addGap(45, 45, 45))))
            .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pos_cardLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(title_label4)
                    .addContainerGap(1181, Short.MAX_VALUE)))
        );
        pos_cardLayout.setVerticalGroup(
            pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pos_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title_label)
                    .addComponent(title_label1)
                    .addComponent(title_label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_bar_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button)
                    .addComponent(qty_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qty_add))
                .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pos_cardLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pos_cardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(title_label3)
                        .addGap(18, 18, 18)
                        .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(total_label))
                        .addGap(18, 18, 18)
                        .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(pago_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(separator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cambio_label))))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pos_cardLayout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(title_label4)
                    .addContainerGap(590, Short.MAX_VALUE)))
        );

        card_panel.add(pos_card, "card2");

        inventory_card.setBackground(new java.awt.Color(255, 255, 255));

        combob_buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        boton_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_len.png"))); // NOI18N
        boton_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_buscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_buscarMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 92, 157));
        jLabel3.setText("Inventario");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 92, 157));
        jLabel4.setText("Guardar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 92, 157));
        jLabel6.setText("Actualizar");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 92, 157));
        jLabel5.setText("Eliminar");

        boton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        boton_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_actualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_actualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_actualizarMouseExited(evt);
            }
        });

        boton_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        boton_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_guardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_guardarMouseExited(evt);
            }
        });

        boton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        boton_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_eliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_eliminarMouseExited(evt);
            }
        });

        separator2.setBackground(new java.awt.Color(5, 92, 157));

        nombre_tf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nombre_tf.setForeground(new java.awt.Color(51, 51, 51));
        nombre_tf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(5, 92, 157));
        jLabel7.setText("Datos de producto");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(5, 92, 157));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombre");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(5, 92, 157));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ID_Proveedor");

        id_proveedor_tf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        id_proveedor_tf.setForeground(new java.awt.Color(51, 51, 51));
        id_proveedor_tf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(5, 92, 157));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cantidad");

        cantidad_tf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cantidad_tf.setForeground(new java.awt.Color(51, 51, 51));
        cantidad_tf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(5, 92, 157));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Precio");

        precio_tf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        precio_tf.setForeground(new java.awt.Color(51, 51, 51));
        precio_tf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        inventory_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "ID_Proveedor", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inventory_table.setOpaque(false);
        inventory_table.setShowGrid(false);
        jScrollPane2.setViewportView(inventory_table);

        javax.swing.GroupLayout inventory_cardLayout = new javax.swing.GroupLayout(inventory_card);
        inventory_card.setLayout(inventory_cardLayout);
        inventory_cardLayout.setHorizontalGroup(
            inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventory_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventory_cardLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventory_cardLayout.createSequentialGroup()
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inventory_cardLayout.createSequentialGroup()
                                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nombre_tf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1)))
                        .addGap(50, 50, 50)
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(id_proveedor_tf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cantidad_tf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(precio_tf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventory_cardLayout.createSequentialGroup()
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(separator2)
                            .addGroup(inventory_cardLayout.createSequentialGroup()
                                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(inventory_cardLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                        .addGap(989, 989, 989))
                                    .addGroup(inventory_cardLayout.createSequentialGroup()
                                        .addComponent(combob_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boton_buscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(inventory_cardLayout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventory_cardLayout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(boton_guardar)
                                                .addGap(117, 117, 117)
                                                .addComponent(boton_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)))
                                        .addGap(56, 56, 56)))
                                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventory_cardLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(boton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)))))
                        .addGap(45, 45, 45))))
        );
        inventory_cardLayout.setVerticalGroup(
            inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventory_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventory_cardLayout.createSequentialGroup()
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_actualizar)
                            .addComponent(boton_guardar)))
                    .addGroup(inventory_cardLayout.createSequentialGroup()
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combob_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_buscar)
                            .addComponent(boton_eliminar))))
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(inventory_cardLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombre_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(inventory_cardLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(id_proveedor_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(inventory_cardLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cantidad_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(inventory_cardLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(precio_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        card_panel.add(inventory_card, "card3");

        user_card.setBackground(new java.awt.Color(255, 255, 255));

        combob_buscar1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combob_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combob_buscar1ActionPerformed(evt);
            }
        });

        boton_buscar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_len.png"))); // NOI18N
        boton_buscar_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_buscar_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_buscar_usuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_buscar_usuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_buscar_usuarioMouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(5, 92, 157));
        jLabel15.setText("Administrar usuarios");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(5, 92, 157));
        jLabel17.setText("Guardar");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(5, 92, 157));
        jLabel18.setText("Actualizar");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(5, 92, 157));
        jLabel19.setText("Eliminar");

        boton_actualizar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        boton_actualizar_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_actualizar_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_actualizar_usuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_actualizar_usuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_actualizar_usuarioMouseExited(evt);
            }
        });

        boton_guardar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        boton_guardar_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_guardar_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_guardar_usuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_guardar_usuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_guardar_usuarioMouseExited(evt);
            }
        });

        boton_eliminar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        boton_eliminar_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_eliminar_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boton_eliminar_usuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton_eliminar_usuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton_eliminar_usuarioMouseExited(evt);
            }
        });

        nombre_tf1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nombre_tf1.setForeground(new java.awt.Color(51, 51, 51));
        nombre_tf1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(5, 92, 157));
        jLabel20.setText("Datos de usuario");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(5, 92, 157));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Nombre de usuario");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(5, 92, 157));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Contraseña");

        contraseña_tf2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        contraseña_tf2.setForeground(new java.awt.Color(51, 51, 51));
        contraseña_tf2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Contraseña", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user_table.setOpaque(false);
        user_table.setShowGrid(false);
        jScrollPane3.setViewportView(user_table);

        separator4.setBackground(new java.awt.Color(5, 92, 157));

        javax.swing.GroupLayout user_cardLayout = new javax.swing.GroupLayout(user_card);
        user_card.setLayout(user_cardLayout);
        user_cardLayout.setHorizontalGroup(
            user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(user_cardLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_cardLayout.createSequentialGroup()
                        .addGroup(user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, user_cardLayout.createSequentialGroup()
                                .addGroup(user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nombre_tf1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1)))
                        .addGap(50, 50, 50)
                        .addGroup(user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(contraseña_tf2)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_cardLayout.createSequentialGroup()
                        .addComponent(combob_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_buscar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_guardar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(boton_actualizar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(boton_eliminar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_cardLayout.createSequentialGroup()
                        .addGroup(user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(separator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(user_cardLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(572, 572, 572)
                                .addComponent(jLabel17)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel18)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel19)))
                        .addGap(42, 42, 42))))
        );
        user_cardLayout.setVerticalGroup(
            user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combob_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_actualizar_usuario)
                    .addComponent(boton_guardar_usuario)
                    .addComponent(boton_eliminar_usuario)
                    .addComponent(boton_buscar_usuario))
                .addGap(24, 24, 24)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(user_cardLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre_tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(user_cardLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contraseña_tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        card_panel.add(user_card, "card4");

        jSplitPane1.setRightComponent(card_panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pos_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pos_buttonMouseClicked
        cl.show(card_panel, "card2");
    }//GEN-LAST:event_pos_buttonMouseClicked

    private void pos_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pos_buttonMouseEntered
        pos_button.setBackground(true_light_blue);
        pos_button.setForeground(Color.white);
    }//GEN-LAST:event_pos_buttonMouseEntered

    private void pos_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pos_buttonMouseExited
        pos_button.setBackground(true_blue);
        pos_button.setForeground(gray);
    }//GEN-LAST:event_pos_buttonMouseExited

    private void user_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_buttonMouseClicked
        cl.show(card_panel, "card4");
    }//GEN-LAST:event_user_buttonMouseClicked

    private void user_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_buttonMouseEntered
        user_button.setBackground(true_light_blue);
        user_button.setForeground(Color.white);
    }//GEN-LAST:event_user_buttonMouseEntered

    private void user_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_buttonMouseExited
        user_button.setBackground(true_blue);
        user_button.setForeground(gray);
    }//GEN-LAST:event_user_buttonMouseExited

    private void inventory_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_buttonMouseClicked
        cl.show(card_panel, "card3");
    }//GEN-LAST:event_inventory_buttonMouseClicked

    private void inventory_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_buttonMouseEntered
        inventory_button.setBackground(true_light_blue);
        inventory_button.setForeground(Color.white);
    }//GEN-LAST:event_inventory_buttonMouseEntered

    private void inventory_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventory_buttonMouseExited
        inventory_button.setBackground(true_blue);
        inventory_button.setForeground(gray);
    }//GEN-LAST:event_inventory_buttonMouseExited

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        Login l = new Login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_buttonMouseClicked

    private void back_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseEntered
        back_button.setBackground(true_light_blue);
        back_button.setForeground(Color.white);
    }//GEN-LAST:event_back_buttonMouseEntered

    private void back_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseExited
        back_button.setBackground(true_blue);
        back_button.setForeground(gray);
    }//GEN-LAST:event_back_buttonMouseExited

    private void logo_imageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_imageMouseEntered
        ImageIcon logo_change = new ImageIcon(
                getClass().getResource("/icons/logo64_blink.png"));
        logo_image.setIcon(logo_change);
    }//GEN-LAST:event_logo_imageMouseEntered

    private void logo_imageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logo_imageMouseExited
        ImageIcon logo_png = new ImageIcon(
                getClass().getResource("/icons/logo64.png"));
        logo_image.setIcon(logo_png);
    }//GEN-LAST:event_logo_imageMouseExited

    private void search_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseClicked
        search_bar_tf.setText("");
    }//GEN-LAST:event_search_buttonMouseClicked

    private void search_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/search_len_res.png"));
        search_button.setIcon(lens_change);
    }//GEN-LAST:event_search_buttonMouseEntered

    private void search_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/search_len.png"));
        search_button.setIcon(lens_png);
    }//GEN-LAST:event_search_buttonMouseExited

    private void qty_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qty_addMouseClicked
        qty_bar.setText("");
    }//GEN-LAST:event_qty_addMouseClicked

    private void qty_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qty_addMouseEntered
        ImageIcon qty_change = new ImageIcon(
                getClass().getResource("/icons/qty_res.png"));
        qty_add.setIcon(qty_change);
    }//GEN-LAST:event_qty_addMouseEntered

    private void qty_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qty_addMouseExited
        ImageIcon qty_png = new ImageIcon(
                getClass().getResource("/icons/qty.png"));
        qty_add.setIcon(qty_png);
    }//GEN-LAST:event_qty_addMouseExited

    private void boton_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_buscarMouseClicked
        // funcion boton buscar
        try {
            String nombre = combob_buscar.getSelectedItem().toString();
            ajustar_modelo_inventario(nombre);
        } catch (Exception e) {
            System.out.println("error ");
        }
        
    }//GEN-LAST:event_boton_buscarMouseClicked

    private void boton_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_buscarMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/search_len_res.png"));
        boton_buscar.setIcon(lens_change);
    }//GEN-LAST:event_boton_buscarMouseEntered

    private void boton_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_buscarMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/search_len.png"));
        boton_buscar.setIcon(lens_png);
    }//GEN-LAST:event_boton_buscarMouseExited

    private void boton_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizarMouseClicked
        // funcion boton actualizar
        try {
            Connect bd = new Connect();
            String nombre = nombre_tf.getText();
            int id_proveedor = Integer.parseInt(id_proveedor_tf.getText());
            int cantidad = Integer.parseInt(cantidad_tf.getText());
            double precio = Double.parseDouble(precio_tf.getText());
            if (nombre.equals("") || id_proveedor <=0 || id_proveedor <=0 || cantidad <= 0 || precio <= 0) {
                JOptionPane.showMessageDialog(rootPane, "No dejes datos en blanco");
            } else {
                boolean bandera_atualizar = bd.Actualizar_Producto(nombre, id_proveedor, cantidad, precio);
                if (bandera_atualizar) {
                    JOptionPane.showMessageDialog(rootPane, "Producto actualizado correctamente");
                    nombre_tf1.setText("");
                    id_proveedor_tf.setText("");
                    cantidad_tf.setText("");
                    precio_tf.setText("");
                    ajustar_modelo_general_inventario();
                    combob_buscar.removeAllItems();
                    rellenar_combobox_inventario();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se puede actualizar un producto intentelo de nuevo");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_boton_actualizarMouseClicked

    private void boton_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizarMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/update_res.png"));
        boton_actualizar.setIcon(lens_change);
    }//GEN-LAST:event_boton_actualizarMouseEntered

    private void boton_actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizarMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/update.png"));
        boton_actualizar.setIcon(lens_png);
    }//GEN-LAST:event_boton_actualizarMouseExited

    private void boton_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardarMouseClicked
        // funcion boton guardar
        try {
            Connect bd = new Connect();
            String nombre = nombre_tf.getText();
            int id_proveedor = Integer.parseInt(id_proveedor_tf.getText());
            int cantidad = Integer.parseInt(cantidad_tf.getText());
            double precio = Double.parseDouble(precio_tf.getText());
            if (nombre.equals("") || id_proveedor <=0 || id_proveedor <=0 || cantidad <= 0 || precio <= 0) {
                JOptionPane.showMessageDialog(rootPane, "No dejes datos en blanco");
            } else {
                boolean bandera_insertar = bd.Ingresar_Producto(nombre, id_proveedor, cantidad, precio);
                if (bandera_insertar) {
                    JOptionPane.showMessageDialog(rootPane, "Producto ingresado correctamente");
                    nombre_tf.setText("");
                    id_proveedor_tf.setText("");
                    cantidad_tf.setText("");
                    precio_tf.setText("");
                    ajustar_modelo_general_inventario();
                    combob_buscar.removeAllItems();
                    rellenar_combobox_inventario();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pueda ingresar un producto intentelo de nuevo");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tipo de datos incorrectos en los apartados");
        }
    }//GEN-LAST:event_boton_guardarMouseClicked

    private void boton_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardarMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/save_res.png"));
        boton_guardar.setIcon(lens_change);
    }//GEN-LAST:event_boton_guardarMouseEntered

    private void boton_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardarMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/save.png"));
        boton_guardar.setIcon(lens_png);
    }//GEN-LAST:event_boton_guardarMouseExited

    private void boton_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminarMouseClicked
        // funcion boton eliminar
        try {
            Connect bd = new Connect();
            String nombre = nombre_tf.getText();
            int id_proveedor = Integer.parseInt(id_proveedor_tf.getText());
            int cantidad = Integer.parseInt(cantidad_tf.getText());
            double precio = Double.parseDouble(precio_tf.getText());
            if (nombre.equals("") || id_proveedor <=0 || id_proveedor <=0 || cantidad <= 0 || precio <= 0) {
                JOptionPane.showMessageDialog(rootPane, "No dejes datos en blanco");
            } else {
                boolean bandera_eliminar = bd.Eliminar_Producto(nombre);
                if (bandera_eliminar) {
                    JOptionPane.showMessageDialog(rootPane, "Usuario borrado correctamente");
                    nombre_tf.setText("");
                    id_proveedor_tf.setText("");
                    cantidad_tf.setText("");
                    precio_tf.setText("");
                    ajustar_modelo_general_inventario();
                    combob_buscar.removeAllItems();
                    rellenar_combobox_inventario();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar un producto intentelo de nuevo");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_boton_eliminarMouseClicked

    private void boton_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminarMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/delete_res.png"));
        boton_eliminar.setIcon(lens_change);
    }//GEN-LAST:event_boton_eliminarMouseEntered

    private void boton_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminarMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/delete.png"));
        boton_eliminar.setIcon(lens_png);
    }//GEN-LAST:event_boton_eliminarMouseExited

    private void boton_buscar_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_buscar_usuarioMouseClicked
        //Buscar usuario
        try {
            String nombre = combob_buscar1.getSelectedItem().toString();
            ajustar_modelo(nombre);
        } catch (Exception e) {
            System.out.println("error ");
        }
    }//GEN-LAST:event_boton_buscar_usuarioMouseClicked

    private void boton_buscar_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_buscar_usuarioMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/search_len_res.png"));
        boton_buscar_usuario.setIcon(lens_change);
    }//GEN-LAST:event_boton_buscar_usuarioMouseEntered

    private void boton_buscar_usuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_buscar_usuarioMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/search_len.png"));
        boton_buscar_usuario.setIcon(lens_png);
    }//GEN-LAST:event_boton_buscar_usuarioMouseExited

    private void boton_actualizar_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizar_usuarioMouseClicked
        // hacer un UPDATE USUARIO
        try {
            Connect bd = new Connect();
            String nombre = nombre_tf1.getText();
            String contraseña = contraseña_tf2.getText();
            if (nombre.equals("") || contraseña.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "No dejes datos en blanco");
            } else {
                int id = bd.Buscar_id(nombre);
                boolean bandera_atualizar = bd.Actualizar_Usuario(nombre, contraseña, id);
                if (bandera_atualizar) {
                    JOptionPane.showMessageDialog(rootPane, "Usuario actualizado correctamente");
                    nombre_tf1.setText("");
                    contraseña_tf2.setText("");
                    ajustar_modelo_general();
                    combob_buscar1.removeAllItems();
                    rellenar_combobox();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se puede actualizar un usuario intentelo de nuevo");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_boton_actualizar_usuarioMouseClicked

    private void boton_actualizar_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizar_usuarioMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/update_res.png"));
        boton_actualizar_usuario.setIcon(lens_change);
    }//GEN-LAST:event_boton_actualizar_usuarioMouseEntered

    private void boton_actualizar_usuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizar_usuarioMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/update.png"));
        boton_actualizar_usuario.setIcon(lens_png);
    }//GEN-LAST:event_boton_actualizar_usuarioMouseExited

    private void boton_guardar_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardar_usuarioMouseClicked
        // hacer un INSERT INTO USUARIO
        try {
            Connect bd = new Connect();
            String nombre = nombre_tf1.getText();
            String contraseña = contraseña_tf2.getText();
            if (nombre.equals("") || contraseña.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "No dejes datos en blanco");
            } else {
                boolean bandera_insertar = bd.Ingresar_Usuario(nombre, contraseña);
                if (bandera_insertar) {
                    JOptionPane.showMessageDialog(rootPane, "Usuario ingresado correctamente");
                    nombre_tf1.setText("");
                    contraseña_tf2.setText("");
                    ajustar_modelo_general();
                    combob_buscar1.removeAllItems();
                    rellenar_combobox();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pueda ingresar un usuario intentelo de nuevo");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_boton_guardar_usuarioMouseClicked

    private void boton_guardar_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardar_usuarioMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/save_res.png"));
        boton_guardar_usuario.setIcon(lens_change);
    }//GEN-LAST:event_boton_guardar_usuarioMouseEntered

    private void boton_guardar_usuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardar_usuarioMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/save.png"));
        boton_guardar_usuario.setIcon(lens_png);
    }//GEN-LAST:event_boton_guardar_usuarioMouseExited

    private void boton_eliminar_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminar_usuarioMouseClicked
        // hacer un DELETE FROM USUARIO
        try {
            Connect bd = new Connect();
            String nombre = nombre_tf1.getText();
            String contraseña = contraseña_tf2.getText();
            if (nombre.equals("") || contraseña.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "No dejes datos en blanco");
            } else {
                int id = bd.Buscar_id(nombre);
                boolean bandera_eliminar = bd.Eliminar_Usuario(id);
                if (bandera_eliminar) {
                    JOptionPane.showMessageDialog(rootPane, "Usuario borrado correctamente");
                    nombre_tf1.setText("");
                    contraseña_tf2.setText("");
                    ajustar_modelo_general();
                    combob_buscar1.removeAllItems();
                    rellenar_combobox();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar un usuario intentelo de nuevo");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_boton_eliminar_usuarioMouseClicked

    private void boton_eliminar_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminar_usuarioMouseEntered
        ImageIcon lens_change = new ImageIcon(
                getClass().getResource("/icons/delete_res.png"));
        boton_eliminar_usuario.setIcon(lens_change);
    }//GEN-LAST:event_boton_eliminar_usuarioMouseEntered

    private void boton_eliminar_usuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminar_usuarioMouseExited
        ImageIcon lens_png = new ImageIcon(
                getClass().getResource("/icons/delete.png"));
        boton_eliminar_usuario.setIcon(lens_png);
    }//GEN-LAST:event_boton_eliminar_usuarioMouseExited

    private void combob_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combob_buscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combob_buscar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_button;
    private javax.swing.JLabel boton_actualizar;
    private javax.swing.JLabel boton_actualizar_usuario;
    private javax.swing.JLabel boton_buscar;
    private javax.swing.JLabel boton_buscar_usuario;
    private javax.swing.JLabel boton_eliminar;
    private javax.swing.JLabel boton_eliminar_usuario;
    private javax.swing.JLabel boton_guardar;
    private javax.swing.JLabel boton_guardar_usuario;
    private javax.swing.JLabel cambio_label;
    private javax.swing.JTextField cantidad_tf;
    private javax.swing.JPanel card_panel;
    private javax.swing.JTable cart_table;
    private javax.swing.JComboBox<String> combob_buscar;
    private javax.swing.JComboBox<String> combob_buscar1;
    private javax.swing.JTextField contraseña_tf2;
    private javax.swing.JTextField id_proveedor_tf;
    private javax.swing.JLabel inventory_button;
    private javax.swing.JPanel inventory_card;
    private javax.swing.JTable inventory_table;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel left_panel;
    private javax.swing.JLabel logo_image;
    private javax.swing.JTextField nombre_tf;
    private javax.swing.JTextField nombre_tf1;
    private javax.swing.JLabel pago_label;
    private javax.swing.JLabel pos_button;
    private javax.swing.JPanel pos_card;
    private javax.swing.JTextField precio_tf;
    private javax.swing.JLabel qty_add;
    private javax.swing.JTextField qty_bar;
    private javax.swing.JTextField search_bar_tf;
    private javax.swing.JLabel search_button;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSeparator separator3;
    private javax.swing.JSeparator separator4;
    private javax.swing.JLabel title_label;
    private javax.swing.JLabel title_label1;
    private javax.swing.JLabel title_label2;
    private javax.swing.JLabel title_label3;
    private javax.swing.JLabel title_label4;
    private javax.swing.JLabel total_label;
    private javax.swing.JLabel user_button;
    private javax.swing.JPanel user_card;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
