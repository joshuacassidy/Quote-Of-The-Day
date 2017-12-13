/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoteoftheday;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Josh
 */
public class QuoteOfTheDayGUI extends javax.swing.JFrame {

    /**
     * Creates new form QuoteOfTheDayGUI
     */
    String[] quotes = new String[7];
    public QuoteOfTheDayGUI() {
        initComponents();
        File file = new File("quotes.dat");
        if (!file.exists()) {
            for(int i = 0; i < quotes.length; i++) {
                quotes[i] = JOptionPane.showInputDialog(null, "Enter the " + (i+1) + " quote.");
            }
            writeToFile();
        } else {
            try {
            
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                quotes = (String[]) ois.readObject();
            } catch(IOException | ClassNotFoundException e) {
                System.out.println(e);
        }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        setQuotesBtn = new javax.swing.JButton();
        getQuotesBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Quotes");

        setQuotesBtn.setText("Set Quote");
        setQuotesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setQuotesBtnActionPerformed(evt);
            }
        });

        getQuotesBtn.setText("Get Quote");
        getQuotesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getQuotesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(setQuotesBtn)
                .addGap(28, 28, 28)
                .addComponent(getQuotesBtn)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setQuotesBtn)
                    .addComponent(getQuotesBtn))
                .addGap(107, 107, 107))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setQuotesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setQuotesBtnActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < quotes.length; i++) {
            quotes[i] = JOptionPane.showInputDialog(null, "Enter the " + (i+1) + " quote.");
        }
        
    }//GEN-LAST:event_setQuotesBtnActionPerformed

    public void writeToFile() {
        try {
            File file = new File("quotes.dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(quotes);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    
    private void getQuotesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getQuotesBtnActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, quotes[new Random().nextInt(7)]);
    }//GEN-LAST:event_getQuotesBtnActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuoteOfTheDayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuoteOfTheDayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuoteOfTheDayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuoteOfTheDayGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuoteOfTheDayGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getQuotesBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton setQuotesBtn;
    // End of variables declaration//GEN-END:variables
}
