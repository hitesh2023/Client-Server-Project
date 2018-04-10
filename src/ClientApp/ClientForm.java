
package ClientApp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClientForm extends javax.swing.JFrame {

    Socket socket;
    ObjectInputStream oin;
    ObjectOutputStream out;
    
    public ClientForm() {
        initComponents();
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recieveTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        sendClientButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        sendTextArea = new javax.swing.JTextArea();
        startClientButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLIENT");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Recieved Message");

        recieveTextArea.setColumns(20);
        recieveTextArea.setRows(5);
        jScrollPane1.setViewportView(recieveTextArea);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("   Send Message");

        sendClientButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        sendClientButton.setText("Send");
        sendClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendClientButtonActionPerformed(evt);
            }
        });

        sendTextArea.setColumns(20);
        sendTextArea.setRows(5);
        jScrollPane2.setViewportView(sendTextArea);

        startClientButton.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        startClientButton.setText("Start Client");
        startClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startClientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                        .addComponent(sendClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                    .addComponent(startClientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sendClientButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendClientButtonActionPerformed
                try {
                    out.writeObject(sendTextArea.getText().toString());
                    
                } catch(Exception e) {
                    e.printStackTrace();
                }
    }//GEN-LAST:event_sendClientButtonActionPerformed

    private void startClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startClientButtonActionPerformed
                 try {
                     socket = new Socket(Settings.ip_address , Settings.port);
                     JOptionPane.showMessageDialog(this, "Connected to Server");
                     openReader();
                     
                     
                 } catch(Exception e) {
                     e.printStackTrace();
                 }
    }//GEN-LAST:event_startClientButtonActionPerformed

    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea recieveTextArea;
    public javax.swing.JButton sendClientButton;
    private javax.swing.JTextArea sendTextArea;
    public javax.swing.JButton startClientButton;
    // End of variables declaration//GEN-END:variables

    private void openReader() {
        try {
         oin = new ObjectInputStream(socket.getInputStream());
         out = new ObjectOutputStream(socket.getOutputStream());
         
         MsgRecThread mess = new MsgRecThread(this , out , oin);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public class MsgRecThread extends Thread {

        ClientForm cf; 
        ObjectOutputStream out ;
        ObjectInputStream  oin;
        public MsgRecThread(ClientForm cf , ObjectOutputStream out , ObjectInputStream  oin) {
            this.cf = cf;
            this.out = out;
            this.oin = oin;
            
            start();
        }
        
        public void run() {
          while(true) {
            try {
                cf.recieveTextArea.append(oin.readObject().toString() + "\n");
            } catch(Exception e) {
                e.printStackTrace();
            }
          }
        }
        
    }
}
