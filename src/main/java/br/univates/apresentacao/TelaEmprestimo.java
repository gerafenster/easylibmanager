/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.apresentacao;

import br.univates.negocio.Cliente;
import br.univates.negocio.Emprestimo;
import br.univates.negocio.Livro;
import br.univates.persistencia.ClienteDao;
import br.univates.persistencia.ClienteFiltro;
import br.univates.persistencia.DaoFactory;
import br.univates.persistencia.EmprestimoDao;
import br.univates.persistencia.LivroDao;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class TelaEmprestimo extends javax.swing.JFrame
{

    /**
     * Creates new form TelaEmprestimo
     */
    public TelaEmprestimo()
    {
        initComponents();
        this.setLocationRelativeTo(null);
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

        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMyNumberFieldCodigo = new br.univates.system32.components.JMyNumberField();
        Título = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldAutor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAno = new javax.swing.JTextField();
        jTextFieldIsbn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCategoria = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMyCpfField = new br.univates.system32.components.JMyCpfField();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Hack", 0, 36)); // NOI18N
        jLabel12.setText("Registro de Empréstimo");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Livro");

        jLabel5.setText("ISBN:");

        jLabel6.setText("Código:");

        jMyNumberFieldCodigo.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                jMyNumberFieldCodigoFocusLost(evt);
            }
        });

        Título.setText("Título:");

        jLabel7.setText("Autor(es):");

        jLabel13.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("*");

        jTextFieldTitulo.setEditable(false);

        jTextFieldAutor.setEditable(false);

        jLabel8.setText("Ano:");

        jTextFieldAno.setEditable(false);

        jTextFieldIsbn.setEditable(false);

        jLabel9.setText("Categoria");

        jTextFieldCategoria.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTitulo)
                            .addComponent(jTextFieldAutor)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMyNumberFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Título)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jMyNumberFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Título)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel2.setText("CPF:");

        jLabel3.setText("Nome Completo:");

        jLabel11.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("*");

        jMyCpfField.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                jMyCpfFieldFocusLost(evt);
            }
        });

        jTextFieldNome.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jMyCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextFieldNome))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jMyCpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonRegistrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonRegistrarActionPerformed
    {//GEN-HEADEREND:event_jButtonRegistrarActionPerformed
        LocalDate dataEmprestimo = LocalDate.now();
        Cliente cliente = null;
        Livro livro = null;

        if (jMyCpfField.getText().contains(" ") || jMyNumberFieldCodigo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
        }
        else
        {
            try
            {
                ClienteFiltro filtroCpf = new ClienteFiltro(jMyCpfField.getText());
                ClienteDao clienteDao = DaoFactory.newClienteDao();
                cliente = clienteDao.read(filtroCpf).get(0);
                LivroDao livroDao = DaoFactory.newLivroDao();
                livro = livroDao.read(jMyNumberFieldCodigo.getInteger());
                livro.setDisponivel(false);
                livroDao.edit(livro);
            } catch (DataBaseException ex)
            {
                Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (cliente == null && livro == null)
            {
                JOptionPane.showMessageDialog(null, "Cliente e livro não registrados no sistema!");
            }
            else if (cliente == null)
            {
                JOptionPane.showMessageDialog(null, "Cliente não registrado no sistema!");
            }
            else if (livro == null)
            {
                JOptionPane.showMessageDialog(null, "Livro não registrado no sistema!");
            }

            if (cliente != null && livro != null)
            {
                Emprestimo emprestimo = new Emprestimo(dataEmprestimo, null, cliente, livro);

                try
                {
                    EmprestimoDao emprestimoDao = DaoFactory.newEmprestimoDao();
                    emprestimoDao.create(emprestimo);
                } catch (DataBaseException ex)
                {
                    Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DuplicateKeyException ex)
                {
                    Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Empréstimo registrado com sucesso!");
                jMyNumberFieldCodigo.setText("");
                jTextFieldIsbn.setText("");
                jTextFieldAno.setText("");
                jTextFieldCategoria.setText("");
                jTextFieldTitulo.setText("");
                jTextFieldAutor.setText("");
            }
        }

    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jMyCpfFieldFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jMyCpfFieldFocusLost
    {//GEN-HEADEREND:event_jMyCpfFieldFocusLost
        ClienteFiltro filtroCpf = new ClienteFiltro(jMyCpfField.getText());
        try
        {
            ClienteDao clienteDao = DaoFactory.newClienteDao();
            if (!clienteDao.read(filtroCpf).isEmpty())
            {
                Cliente cliente = clienteDao.read(filtroCpf).get(0);
                jTextFieldNome.setText(cliente.getNome());
            }
            else
            {
                jTextFieldNome.setText("");
            }

        } catch (DataBaseException ex)
        {
            Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jMyCpfFieldFocusLost

    private void jMyNumberFieldCodigoFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_jMyNumberFieldCodigoFocusLost
    {//GEN-HEADEREND:event_jMyNumberFieldCodigoFocusLost
        if (!jMyNumberFieldCodigo.getText().isEmpty())
        {
            try
            {

                LivroDao livroDao = DaoFactory.newLivroDao();
                if (livroDao.read(Integer.parseInt(jMyNumberFieldCodigo.getText())) != null)
                {
                    Livro livro = livroDao.read(Integer.parseInt(jMyNumberFieldCodigo.getText()));
                    jTextFieldIsbn.setText(livro.getIsbn());
                    jTextFieldAno.setText(String.valueOf(livro.getAno()));
                    jTextFieldCategoria.setText(livro.getCategoria().getNome());
                    jTextFieldTitulo.setText(livro.getTitulo());
                    jTextFieldAutor.setText(livro.getAutor().getNomeCompleto());
                }
                else
                {
                    jTextFieldIsbn.setText("");
                    jTextFieldAno.setText("");
                    jTextFieldCategoria.setText("");
                    jTextFieldTitulo.setText("");
                    jTextFieldAutor.setText("");
                }
            } catch (DataBaseException ex)
            {
                Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            jTextFieldIsbn.setText("");
            jTextFieldAno.setText("");
            jTextFieldCategoria.setText("");
            jTextFieldTitulo.setText("");
            jTextFieldAutor.setText("");
        }

    }//GEN-LAST:event_jMyNumberFieldCodigoFocusLost

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonFecharActionPerformed
    {//GEN-HEADEREND:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TelaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Título;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private br.univates.system32.components.JMyCpfField jMyCpfField;
    private br.univates.system32.components.JMyNumberField jMyNumberFieldCodigo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldIsbn;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
