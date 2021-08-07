/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.system32.components;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mouri
 */
public class JMyBaseBoard extends javax.swing.JPanel {

    /**
     * Creates new form Footer
     */
    public JMyBaseBoard() {
        initComponents();
        Calendar c = Calendar.getInstance();
        
        int d = c.get( Calendar.DAY_OF_MONTH );
        int m = c.get( Calendar.MONTH )+1;
        int a = c.get( Calendar.YEAR );
        
        String date = (d < 10 ? "0"+d : d) + "/" + (m < 10 ? "0"+m : m) + "/" + a;
        this.lbDate.setText(date);
        this.setCustomer("<nome do proprietário do sistema>");
        this.setUser("<usuário>");
    }
    
    public void setCustomer( String text )
    {
        this.lbCustomer.setText(text);
    }
    
    public void setUser( String text )
    {
        this.tfUser.setText(text);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lbDate = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        lbCustomer = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDate.setText("jLabel1");
        add(lbDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 15, 122, -1));

        lbUser.setText("Usuário:");
        add(lbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 15, 49, -1));

        tfUser.setEditable(false);
        add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 12, 101, -1));

        lbCustomer.setText("jLabel2");
        add(lbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 15, 309, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCustomer;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbUser;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}