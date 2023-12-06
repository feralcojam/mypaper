package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Home extends javax.swing.JFrame {
    
    CardLayout cl;
    Color true_blue = new Color(45,104,196);
    Color true_light_blue = new Color(65,144,206);
    Color celestial = new Color(73,151,208);
    Color aero = new Color(0,185,232);
    Color lapis = new Color(5,92,157);
    Color gray = new Color(224,224,224);
    
    public Home() {
        initComponents();
        search_bar_tf.setOpaque(false);
        nombre_tf.setOpaque(false);
        id_proveedor_tf.setOpaque(false);
        cantidad_tf.setOpaque(false);
        precio_tf.setOpaque(false);
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
        cart_table.setFont(new Font("SansSerif",Font.PLAIN,18));
        cart_table.setForeground(gray);
        cart_table.setBackground(lapis);
        TableColumnModel tcm = cart_table.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(490);
        tcm.getColumn(0).setMaxWidth(490);
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
        inventory_table.setFont(new Font("SansSerif",Font.PLAIN,18));
        inventory_table.setForeground(gray);
        inventory_table.setBackground(lapis);
        TableColumnModel tcm2 = inventory_table.getColumnModel();
        tcm2.getColumn(0).setPreferredWidth(490);
        tcm2.getColumn(0).setMaxWidth(490);
        tcm2.getColumn(0).setMinWidth(490);
        tcm2.getColumn(1).setPreferredWidth(60);
        tcm2.getColumn(1).setMaxWidth(490);
        tcm2.getColumn(2).setPreferredWidth(100);
        tcm2.getColumn(2).setMaxWidth(490);
        tcm2.getColumn(3).setPreferredWidth(100);
        tcm2.getColumn(3).setMaxWidth(1080);
        // termino config tabla inventario
        cl = (CardLayout) card_panel.getLayout();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        left_panel = new javax.swing.JPanel();
        logo_image = new javax.swing.JLabel();
        start_button = new javax.swing.JLabel();
        pos_button = new javax.swing.JLabel();
        user_button = new javax.swing.JLabel();
        inventory_button = new javax.swing.JLabel();
        back_button = new javax.swing.JLabel();
        card_panel = new javax.swing.JPanel();
        home_card = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        inventory_table = new javax.swing.JTable();
        nombre_tf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        id_proveedor_tf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cantidad_tf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        precio_tf = new javax.swing.JTextField();
        user_card = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        start_button.setBackground(new java.awt.Color(45, 104, 196));
        start_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        start_button.setForeground(new java.awt.Color(204, 204, 204));
        start_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        start_button.setText("Inicio");
        start_button.setOpaque(true);
        start_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                start_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                start_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                start_buttonMouseExited(evt);
            }
        });

        pos_button.setBackground(new java.awt.Color(45, 104, 196));
        pos_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pos_button.setForeground(new java.awt.Color(204, 204, 204));
        pos_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos_button.setText("P.O.S.");
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
            .addComponent(start_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(50, 50, 50)
                .addComponent(start_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pos_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inventory_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(user_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(465, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(left_panel);

        card_panel.setLayout(new java.awt.CardLayout());

        home_card.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 92, 157));
        jLabel1.setText("Dashboard");

        javax.swing.GroupLayout home_cardLayout = new javax.swing.GroupLayout(home_card);
        home_card.setLayout(home_cardLayout);
        home_cardLayout.setHorizontalGroup(
            home_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(1128, Short.MAX_VALUE))
        );
        home_cardLayout.setVerticalGroup(
            home_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(723, Short.MAX_VALUE))
        );

        card_panel.add(home_card, "card1");

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

        title_label3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title_label3.setForeground(new java.awt.Color(5, 92, 157));
        title_label3.setText("Carrito");

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

        javax.swing.GroupLayout pos_cardLayout = new javax.swing.GroupLayout(pos_card);
        pos_card.setLayout(pos_cardLayout);
        pos_cardLayout.setHorizontalGroup(
            pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pos_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pos_cardLayout.createSequentialGroup()
                        .addComponent(title_label)
                        .addGap(225, 225, 225)
                        .addComponent(title_label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(title_label1))
                    .addGroup(pos_cardLayout.createSequentialGroup()
                        .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title_label3)
                            .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pos_cardLayout.createSequentialGroup()
                                .addComponent(search_bar_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pos_cardLayout.createSequentialGroup()
                        .addGroup(pos_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pos_cardLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(qty_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qty_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(590, 590, 590)))
                .addGap(16, 16, 16))
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
                .addGap(32, 32, 32)
                .addComponent(title_label3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
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

        boton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_len.png"))); // NOI18N
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

        boton_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_len.png"))); // NOI18N
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

        boton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_len.png"))); // NOI18N
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

        javax.swing.GroupLayout inventory_cardLayout = new javax.swing.GroupLayout(inventory_card);
        inventory_card.setLayout(inventory_cardLayout);
        inventory_cardLayout.setHorizontalGroup(
            inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventory_cardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventory_cardLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addGap(193, 193, 193))
                    .addGroup(inventory_cardLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventory_cardLayout.createSequentialGroup()
                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inventory_cardLayout.createSequentialGroup()
                                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inventory_cardLayout.createSequentialGroup()
                                        .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(nombre_tf, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(1, 1, 1)))
                                .addGap(50, 50, 50)
                                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(id_proveedor_tf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cantidad_tf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(precio_tf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                            .addGroup(inventory_cardLayout.createSequentialGroup()
                                .addComponent(combob_buscar, 0, 350, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(285, 285, 285)
                                .addComponent(boton_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(boton_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(boton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(225, 225, 225))))
        );
        inventory_cardLayout.setVerticalGroup(
            inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventory_cardLayout.createSequentialGroup()
                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inventory_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combob_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_actualizar)
                    .addComponent(boton_guardar)
                    .addComponent(boton_eliminar)
                    .addComponent(boton_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(100, Short.MAX_VALUE))
        );

        card_panel.add(inventory_card, "card3");

        user_card.setBackground(new java.awt.Color(204, 102, 0));

        javax.swing.GroupLayout user_cardLayout = new javax.swing.GroupLayout(user_card);
        user_card.setLayout(user_cardLayout);
        user_cardLayout.setHorizontalGroup(
            user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1272, Short.MAX_VALUE)
        );
        user_cardLayout.setVerticalGroup(
            user_cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
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

    private void start_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_buttonMouseClicked
        cl.show(card_panel, "card1");
    }//GEN-LAST:event_start_buttonMouseClicked

    private void start_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_buttonMouseEntered
        start_button.setBackground(true_light_blue);
        start_button.setForeground(Color.white);
    }//GEN-LAST:event_start_buttonMouseEntered

    private void start_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_buttonMouseExited
        start_button.setBackground(true_blue);
        start_button.setForeground(gray);
    }//GEN-LAST:event_start_buttonMouseExited

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
    }//GEN-LAST:event_boton_buscarMouseClicked

    private void boton_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_buscarMouseEntered

    }//GEN-LAST:event_boton_buscarMouseEntered

    private void boton_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_buscarMouseExited

    }//GEN-LAST:event_boton_buscarMouseExited

    private void boton_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizarMouseClicked
        // funcion boton actualizar
    }//GEN-LAST:event_boton_actualizarMouseClicked

    private void boton_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizarMouseEntered

    }//GEN-LAST:event_boton_actualizarMouseEntered

    private void boton_actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_actualizarMouseExited

    }//GEN-LAST:event_boton_actualizarMouseExited

    private void boton_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardarMouseClicked
        // funcion boton guardar
    }//GEN-LAST:event_boton_guardarMouseClicked

    private void boton_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardarMouseEntered

    }//GEN-LAST:event_boton_guardarMouseEntered

    private void boton_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_guardarMouseExited

    }//GEN-LAST:event_boton_guardarMouseExited

    private void boton_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminarMouseClicked
        // funcion boton eliminar
    }//GEN-LAST:event_boton_eliminarMouseClicked

    private void boton_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminarMouseEntered

    }//GEN-LAST:event_boton_eliminarMouseEntered

    private void boton_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton_eliminarMouseExited

    }//GEN-LAST:event_boton_eliminarMouseExited
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_button;
    private javax.swing.JLabel boton_actualizar;
    private javax.swing.JLabel boton_buscar;
    private javax.swing.JLabel boton_eliminar;
    private javax.swing.JLabel boton_guardar;
    private javax.swing.JTextField cantidad_tf;
    private javax.swing.JPanel card_panel;
    private javax.swing.JTable cart_table;
    private javax.swing.JComboBox<String> combob_buscar;
    private javax.swing.JPanel home_card;
    private javax.swing.JTextField id_proveedor_tf;
    private javax.swing.JLabel inventory_button;
    private javax.swing.JPanel inventory_card;
    private javax.swing.JTable inventory_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel left_panel;
    private javax.swing.JLabel logo_image;
    private javax.swing.JTextField nombre_tf;
    private javax.swing.JLabel pos_button;
    private javax.swing.JPanel pos_card;
    private javax.swing.JTextField precio_tf;
    private javax.swing.JLabel qty_add;
    private javax.swing.JTextField qty_bar;
    private javax.swing.JTextField search_bar_tf;
    private javax.swing.JLabel search_button;
    private javax.swing.JSeparator separator1;
    private javax.swing.JLabel start_button;
    private javax.swing.JLabel title_label;
    private javax.swing.JLabel title_label1;
    private javax.swing.JLabel title_label2;
    private javax.swing.JLabel title_label3;
    private javax.swing.JLabel user_button;
    private javax.swing.JPanel user_card;
    // End of variables declaration//GEN-END:variables
}
