/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.apresentacao;

import br.univates.easylibmanager.SistemaEasyLibManager;
import br.univates.negocio.Autor;
import br.univates.negocio.Categoria;
import br.univates.negocio.Editora;
import br.univates.negocio.Livro;
import br.univates.persistencia.AutorDao;
import br.univates.persistencia.CategoriaDao;
import br.univates.persistencia.DaoFactory;
import br.univates.persistencia.EditoraDao;
import br.univates.persistencia.LivroDao;
import br.univates.system32.db.DataBaseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author cristian
 */
public class TelaConsultaLivro extends javax.swing.JFrame
{

    /**
     * Creates new form TelaConsultaLivro
     */
    public TelaConsultaLivro()
    {
        initComponents();
        this.setLocationRelativeTo(null);

        ArrayList<Livro> livros = new ArrayList();
        try
        {
            LivroDao dao = DaoFactory.newLivroDao();
            livros = dao.readAll();
        } catch (DataBaseException ex)
        {
            System.out.println(ex.getMessage());
        }

        LivrosTableModel tm = new LivrosTableModel(livros);
        jTableLivros.setModel(tm);
        jTableLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Set 
        jTableLivros.getColumnModel().getColumn(0).setMaxWidth(40);
        jTableLivros.getColumnModel().getColumn(1).setMaxWidth(70);
        jTableLivros.getColumnModel().getColumn(3).setMinWidth(120);
        jTableLivros.getColumnModel().getColumn(3).setMaxWidth(130);

        try
        {
            CategoriaDao categoriaDao = DaoFactory.newCategoriaDao();
            ArrayList<Categoria> categorias = categoriaDao.readAll();
            for (Categoria categoria : categorias)
            {
                jComboBoxCategoria.addItem(categoria);
            }
        } catch (DataBaseException ex)
        {
            Logger.getLogger(TelaCadastroLivros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizarTabela(ArrayList<Livro> livros)
    {
        LivrosTableModel tableModel = (LivrosTableModel) jTableLivros.getModel();
        tableModel.setLivros(livros);
        jTableLivros.revalidate();
        jTableLivros.repaint();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxDisponivel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jButtonFiltrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldEditora = new javax.swing.JTextField();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldAutor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jMyNumberFieldIsbn = new br.univates.system32.components.JMyNumberField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextFieldAno = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jMyNumberFieldCodigo = new br.univates.system32.components.JMyNumberField();
        jButtonLimparFiltros = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Hack", 0, 36)); // NOI18N
        jLabel12.setText("Consulta de Livros");

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        jScrollPane1.setViewportView(jTableLivros);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Filtros");

        jLabel2.setText("Dispon??vel:");

        jComboBoxDisponivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "   ", "Sim", "N??o" }));

        jLabel3.setText("Categoria:");

        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jLabel4.setText("T??tulo:");

        jLabel5.setText("Editora:");

        jLabel6.setText("Autor(es):");

        jLabel7.setText("ex.: Autor1; Autor2; Autor3");

        jLabel8.setText("ISBN:");

        jLabel9.setText("Ano:");

        try
        {
            jFormattedTextFieldAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        jFormattedTextFieldAno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jFormattedTextFieldAnoActionPerformed(evt);
            }
        });

        jLabel10.setText("C??digo:");

        jButtonLimparFiltros.setText("Limpar filtros");
        jButtonLimparFiltros.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonLimparFiltrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldEditora, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                    .addComponent(jTextFieldTitulo)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jMyNumberFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMyNumberFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFormattedTextFieldAno)
                                    .addComponent(jComboBoxDisponivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLimparFiltros)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jMyNumberFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jMyNumberFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel2)
                        .addComponent(jComboBoxDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(jButtonLimparFiltros))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonFecharActionPerformed
    {//GEN-HEADEREND:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jFormattedTextFieldAnoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jFormattedTextFieldAnoActionPerformed
    {//GEN-HEADEREND:event_jFormattedTextFieldAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldAnoActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonFiltrarActionPerformed
    {//GEN-HEADEREND:event_jButtonFiltrarActionPerformed
        Livro livro = new Livro();

        if (!jTextFieldTitulo.getText().isEmpty())
        {
            livro.setTitulo(jTextFieldTitulo.getText());
        }
        if (!jTextFieldEditora.getText().isEmpty())
        {
            Editora editora = new Editora(jTextFieldEditora.getText());
            livro.setEditora(editora);
        }
        if (!jTextFieldAutor.getText().isEmpty())
        {
            Autor autor = new Autor(jTextFieldAutor.getText());
            livro.setAutor(autor);
        }
        if (!jMyNumberFieldCodigo.getText().isEmpty())
        {
            livro.setId(Integer.parseInt(jMyNumberFieldCodigo.getText()));
        }
        if (!jMyNumberFieldIsbn.getText().isEmpty())
        {
            livro.setIsbn((jMyNumberFieldIsbn.getText()));
        }
        if (!jFormattedTextFieldAno.getText().contains(" "))
        {
            livro.setAno(Integer.parseInt(jFormattedTextFieldAno.getText()));
        }
        if (jComboBoxDisponivel.getSelectedIndex() != 0)
        {
            if (jComboBoxDisponivel.getSelectedIndex() == 1)
            {
                livro.setDisponivel(true);
            }
            else
            {
                livro.setDisponivel(false);
            }
        }
        if (jComboBoxCategoria.getSelectedIndex() != 0)
        {
            livro.setCategoria((Categoria) jComboBoxCategoria.getSelectedItem());
        }

        ArrayList<Livro> livros = null;

        try
        {
            LivroDao livroDao = DaoFactory.newLivroDao();
            livros = livroDao.readFilter(livro);
        } catch (DataBaseException ex)
        {
            Logger.getLogger(TelaConsultaLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (livros != null)
        {
            atualizarTabela(livros);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Livro n??o encontrado!");
        }
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
    {//GEN-HEADEREND:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jButtonLimparFiltrosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonLimparFiltrosActionPerformed
    {//GEN-HEADEREND:event_jButtonLimparFiltrosActionPerformed

        jTextFieldTitulo.setText("");
        jTextFieldEditora.setText("");
        jTextFieldAutor.setText("");
        jMyNumberFieldCodigo.setText("");
        jMyNumberFieldIsbn.setText("");
        jFormattedTextFieldAno.setText("");
        jComboBoxDisponivel.setSelectedIndex(0);
        jComboBoxCategoria.setSelectedIndex(0);

        jButtonFiltrarActionPerformed(evt);
    }//GEN-LAST:event_jButtonLimparFiltrosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConsultaLivro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaConsultaLivro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaConsultaLivro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaConsultaLivro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TelaConsultaLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonLimparFiltros;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxDisponivel;
    private javax.swing.JFormattedTextField jFormattedTextFieldAno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private br.univates.system32.components.JMyNumberField jMyNumberFieldCodigo;
    private br.univates.system32.components.JMyNumberField jMyNumberFieldIsbn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldEditora;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
