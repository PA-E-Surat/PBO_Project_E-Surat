package gui;

import database.Database;
import java.awt.Color;


/**
 *
 * @author Footdua
 */
public class MahasiswaForm extends javax.swing.JFrame {
    final Database database;
    private Object mahasiswaInterface;
 
    public MahasiswaForm() {
        initComponents();
        database = new Database();
        passTextField.setEchoChar((char) 0);
        passTextField.setText("Password");
        popError.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new javax.swing.JPanel();
        unmulIcon = new javax.swing.JLabel();
        popError = new javax.swing.JTextArea();
        frameName = new javax.swing.JTextField();
        warningText = new javax.swing.JTextField();
        signButton = new javax.swing.JButton();
        passTextField = new javax.swing.JPasswordField();
        nimTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background1.setBackground(new java.awt.Color(204, 204, 204));
        background1.setMinimumSize(new java.awt.Dimension(300, 300));
        background1.setName(""); // NOI18N
        background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unmulIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unmulIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Unmul-Icon.png"))); // NOI18N
        background1.add(unmulIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 390, 140));

        popError.setEditable(false);
        popError.setBackground(new java.awt.Color(221, 75, 57));
        popError.setColumns(20);
        popError.setRows(5);
        popError.setText("nim tidak boleh kosong\npassword tidak boleh kosong");
        popError.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        popError.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        background1.add(popError, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 330, 40));

        frameName.setEditable(false);
        frameName.setBackground(new java.awt.Color(255, 255, 255));
        frameName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        frameName.setForeground(new java.awt.Color(0, 0, 51));
        frameName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        frameName.setText("E-Surat Fakultas Teknik UNMUL");
        frameName.setBorder(null);
        background1.add(frameName, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 220, 390, -1));

        warningText.setEditable(false);
        warningText.setBackground(new java.awt.Color(255, 153, 0));
        warningText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        warningText.setForeground(new java.awt.Color(255, 255, 255));
        warningText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        warningText.setText("Silahkan gunakan  akun portal SIA anda untuk \nlogin");
        warningText.setBorder(null);
        warningText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warningTextActionPerformed(evt);
            }
        });
        background1.add(warningText, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 330, 50));

        signButton.setBackground(new java.awt.Color(51, 153, 255));
        signButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        signButton.setForeground(new java.awt.Color(255, 255, 255));
        signButton.setText("Sign In");
        signButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        signButton.setRequestFocusEnabled(false);
        signButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signButtonActionPerformed(evt);
            }
        });
        background1.add(signButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 330, 40));

        passTextField.setBackground(new java.awt.Color(255, 255, 255));
        passTextField.setText("Password");
        passTextField.setActionCommand("<Not Set>");
        passTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        passTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passTextFieldFocusLost(evt);
            }
        });
        passTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTextFieldActionPerformed(evt);
            }
        });
        background1.add(passTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 330, 40));

        nimTextField.setBackground(new java.awt.Color(255, 255, 255));
        nimTextField.setForeground(new java.awt.Color(204, 204, 204));
        nimTextField.setText("Nim");
        nimTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        nimTextField.setName("nim"); // NOI18N
        nimTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nimTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nimTextFieldFocusLost(evt);
            }
        });
        nimTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimTextFieldActionPerformed(evt);
            }
        });
        background1.add(nimTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 330, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        background1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 390, 500));

        getContentPane().add(background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void warningTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warningTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warningTextActionPerformed

    private void nimTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nimTextFieldActionPerformed

    private void nimTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nimTextFieldFocusGained
        // TODO add your handling code here:
        if (nimTextField.getText().equals("Nim")) {
        nimTextField.setText("");
        nimTextField.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_nimTextFieldFocusGained

    private void nimTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nimTextFieldFocusLost
        // TODO add your handling code here:
        if (nimTextField.getText().isEmpty()) {
        nimTextField.setText("Nim");
        nimTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_nimTextFieldFocusLost

    private void passTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTextFieldActionPerformed

    private void passTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passTextFieldFocusGained
        // TODO add your handling code here:
        if (new String(passTextField.getPassword()).equals("Password")) {
        passTextField.setText("");
        passTextField.setEchoChar('*');
        nimTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_passTextFieldFocusGained

    private void passTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passTextFieldFocusLost
        // TODO add your handling code here:
        if (new String(passTextField.getPassword()).isEmpty()) {
        passTextField.setText("Password");
        passTextField.setEchoChar((char) 0);
        nimTextField.setForeground(Color.GRAY);
        
        }
    }//GEN-LAST:event_passTextFieldFocusLost

    private void signButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signButtonActionPerformed
        // TODO add your handling code here:
        String nim = nimTextField.getText();
        String password = new String(passTextField.getPassword());

        if (nim.equals("Nim") || password.isEmpty()) {
            popError.setText("• Nim tidak boleh kosong\n• Password tidak boleh kosong");
            popError.setVisible(true);
        } else {
            if (database.checkLogin(nim, password)) {
                MahasiswaInterface mahasiswaInterface = new MahasiswaInterface(nim);
                mahasiswaInterface.setVisible(true);
                popError.setVisible(false);
                this.dispose();
            } else {
                popError.setText("• Login gagal, silahkan cek kembali nim dan password");
                popError.setVisible(true);
            }
        }
    }//GEN-LAST:event_signButtonActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MahasiswaForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background1;
    private javax.swing.JTextField frameName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nimTextField;
    private javax.swing.JPasswordField passTextField;
    private javax.swing.JTextArea popError;
    private javax.swing.JButton signButton;
    private javax.swing.JLabel unmulIcon;
    private javax.swing.JTextField warningText;
    // End of variables declaration//GEN-END:variables
}
