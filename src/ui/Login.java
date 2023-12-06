package ui;

import connections.Connect;
import connections.LogToBD;
import connections.LoginData;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicButtonUI;

public class Login extends javax.swing.JFrame {
    
    LogToBD ltbd = new LogToBD();
    LoginData lgd = new LoginData();
    
    public Login() {
        initComponents();
        user_tf.setOpaque(false);
        user_pf.setOpaque(false);
        login_button.setUI(new BasicButtonUI());
    }
    
    public void login() {
        String user = user_tf.getText();
        String pass = String.valueOf(user_pf.getPassword());
        if(!"".equals(user) || !"".equals(pass)) {
            Connect bd = new Connect ();
            boolean bandera_usuario = bd.Inicio_Sesion(user, pass);
            if (bandera_usuario == true){
                JOptionPane.showMessageDialog(rootPane, "Usuario encontrado");
                Home home = new Home ();
                home.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Credenciales incorrectas");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ingresa todos los datos");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        action_bar = new javax.swing.JPanel();
        exit_button = new javax.swing.JLabel();
        logo_image = new javax.swing.JLabel();
        username_label = new javax.swing.JLabel();
        user_tf = new javax.swing.JTextField();
        separator1 = new javax.swing.JSeparator();
        password_label = new javax.swing.JLabel();
        user_pf = new javax.swing.JPasswordField();
        separator2 = new javax.swing.JSeparator();
        login_button = new javax.swing.JButton();
        login_design = new javax.swing.JLabel();
        login_bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 360));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        action_bar.setBackground(new java.awt.Color(45, 104, 196));
        action_bar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit_button.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exit_button.setForeground(new java.awt.Color(255, 255, 255));
        exit_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_button.setText("X");
        exit_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_buttonMouseExited(evt);
            }
        });
        action_bar.add(exit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 30));

        getContentPane().add(action_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        logo_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo.png"))); // NOI18N
        getContentPane().add(logo_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 100, 100));

        username_label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        username_label.setForeground(new java.awt.Color(73, 151, 208));
        username_label.setText("Nombre de Usuario");
        getContentPane().add(username_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 180, -1, -1));

        user_tf.setBackground(new java.awt.Color(255, 255, 255));
        user_tf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_tf.setForeground(new java.awt.Color(0, 185, 232));
        user_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user_tf.setBorder(null);
        getContentPane().add(user_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 210, 180, -1));

        separator1.setBackground(new java.awt.Color(0, 185, 232));
        getContentPane().add(separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 230, 180, 1));

        password_label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        password_label.setForeground(new java.awt.Color(73, 151, 208));
        password_label.setText("Contraseña");
        getContentPane().add(password_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 250, -1, -1));

        user_pf.setBackground(new java.awt.Color(255, 255, 255));
        user_pf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_pf.setForeground(new java.awt.Color(0, 185, 232));
        user_pf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        user_pf.setBorder(null);
        getContentPane().add(user_pf, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 280, 180, -1));

        separator2.setBackground(new java.awt.Color(0, 185, 232));
        getContentPane().add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 300, 180, 1));

        login_button.setBackground(new java.awt.Color(5, 92, 137));
        login_button.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        login_button.setForeground(new java.awt.Color(255, 255, 255));
        login_button.setText("Login");
        login_button.setBorder(null);
        login_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_buttonMouseExited(evt);
            }
        });
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(login_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 330, 110, 30));

        login_design.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_design.png"))); // NOI18N
        getContentPane().add(login_design, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, -1));

        login_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_bg.png"))); // NOI18N
        getContentPane().add(login_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_buttonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exit_buttonMouseClicked

    private void exit_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_buttonMouseEntered
        exit_button.setForeground(Color.red);
    }//GEN-LAST:event_exit_buttonMouseEntered

    private void exit_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_buttonMouseExited
        exit_button.setForeground(Color.white);
    }//GEN-LAST:event_exit_buttonMouseExited

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed
        login();
    }//GEN-LAST:event_login_buttonActionPerformed

    private void login_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_buttonMouseEntered
        login_button.setBackground(new Color(45,104,196));
    }//GEN-LAST:event_login_buttonMouseEntered

    private void login_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_buttonMouseExited
        login_button.setBackground(new Color(5,92,157));
    }//GEN-LAST:event_login_buttonMouseExited

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel action_bar;
    private javax.swing.JLabel exit_button;
    private javax.swing.JLabel login_bg;
    private javax.swing.JButton login_button;
    private javax.swing.JLabel login_design;
    private javax.swing.JLabel logo_image;
    private javax.swing.JLabel password_label;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JPasswordField user_pf;
    private javax.swing.JTextField user_tf;
    private javax.swing.JLabel username_label;
    // End of variables declaration//GEN-END:variables
}
