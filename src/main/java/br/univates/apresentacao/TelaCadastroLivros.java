package br.univates.apresentacao;

import br.univates.easylibmanager.SistemaEasyLibManager;
import br.univates.persistencia.AutorDao;
import br.univates.persistencia.CategoriaDao;
import br.univates.persistencia.DaoFactory;
import br.univates.persistencia.EditoraDao;
import br.univates.persistencia.LivroDao;
import br.univates.negocio.Autor;
import br.univates.negocio.Categoria;
import br.univates.negocio.Editora;
import br.univates.negocio.Livro;
import br.univates.persistencia.Validacao2;
import br.univates.system32.components.JMyNumberField;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaCadastroLivros extends javax.swing.JFrame
{

    private boolean novo;
    private Livro livro;

    public TelaCadastroLivros()
    {
        initComponents();
        this.setLocationRelativeTo(null);

        novo = true;

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

        ListSelectionModel selectionModel = jTableLivros.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                int row = jTableLivros.getSelectedRow();

                if (row >= 0)
                {
                    LivrosTableModel tableModel = (LivrosTableModel) jTableLivros.getModel();
                    livro = tableModel.getLivros().get(jTableLivros.getSelectedRow());
                    jTextFieldTitulo.setText(livro.getTitulo());
                    jTextFieldAutor.setText(livro.getAutor().getNomeCompleto());
                    jTextFieldEditora.setText(livro.getEditora().getNome());
                    jFormattedTextFieldAno.setText(String.valueOf(livro.getAno()));
                    jMyNumberFieldIsbn.setText(livro.getIsbn());
                    jComboBoxCategoria.setSelectedIndex(livro.getCategoria().getId() - 1);
                    novo = false;
                }
            }
        });

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
        //Set 
        jTableLivros.getColumnModel().getColumn(0).setMaxWidth(40);
        jTableLivros.getColumnModel().getColumn(1).setMaxWidth(70);
        jTableLivros.getColumnModel().getColumn(3).setMinWidth(120);
        jTableLivros.getColumnModel().getColumn(3).setMaxWidth(130);
    }

    public void atualizarTabela()
    {
        ArrayList<Livro> livros = new ArrayList();
        try
        {
            LivroDao dao = DaoFactory.newLivroDao();
            livros = dao.readAll();
        } catch (DataBaseException ex)
        {
            System.out.println(ex.getMessage());
        }

        LivrosTableModel tableModel = (LivrosTableModel) jTableLivros.getModel();

        tableModel.setLivros(livros);
        jTableLivros.revalidate();
        jTableLivros.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        Fechar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldAno = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Excluir = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jMyNumberFieldIsbn = new br.univates.system32.components.JMyNumberField();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldEditora = new javax.swing.JTextField();
        jTextFieldAutor = new javax.swing.JTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane1.setViewportView(jTableLivros);

        Fechar.setText("Fechar");
        Fechar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                FecharActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Hack", 0, 36)); // NOI18N
        jLabel7.setText("Cadastro de Livros");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("*");

        jLabel11.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("*");

        jLabel12.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("*");

        jLabel13.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("*");

        jLabel1.setText("ISBN");

        jLabel2.setText("Ano:");

        try
        {
            jFormattedTextFieldAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        jLabel3.setText("T??tulo:");

        jLabel4.setText("Editora:");

        jLabel5.setText("ex.: Autor1; Autor2; Autor3");

        jLabel6.setText("Categoria");

        jLabel8.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("*");

        jLabel9.setFont(new java.awt.Font("Hack", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("*");

        jLabel14.setText("Autor(es):");

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ExcluirActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSalvarActionPerformed(evt);
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
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAutor)
                            .addComponent(jTextFieldEditora)
                            .addComponent(jTextFieldTitulo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMyNumberFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonSalvar)
                                .addGap(26, 26, 26)
                                .addComponent(jButtonNovo)
                                .addGap(32, 32, 32)
                                .addComponent(Excluir)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jMyNumberFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(Excluir)
                    .addComponent(jButtonNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Fechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Fechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSalvarActionPerformed
    {//GEN-HEADEREND:event_jButtonSalvarActionPerformed
        String isbn = jMyNumberFieldIsbn.getText();
        int ano = Integer.parseInt(jFormattedTextFieldAno.getText());
        String titulo = jTextFieldTitulo.getText();
        boolean disponivel = true;
        int categoriaId = jComboBoxCategoria.getSelectedIndex() + 1;
        String nomeCompletoAutor = jTextFieldAutor.getText();
        String nomeEditora = jTextFieldEditora.getText();
        Autor autor = null;
        Editora editora = null;
        Categoria categoria = null;

        if (jTextFieldTitulo.getText().equals("") || jTextFieldEditora.getText().equals("")
                || jTextFieldAutor.getText().equals("") || jFormattedTextFieldAno.getText().equals("")
                || jMyNumberFieldIsbn.getText().equals("") || jComboBoxCategoria.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigat??rios!");
        }
        else if (!Validacao2.validarIsbn(isbn) && !Validacao2.validarAno(ano))
        {
            JOptionPane.showMessageDialog(null, "ISBN e ano inv??lidos.");
        }
        else if (!Validacao2.validarIsbn(isbn))
        {
            JOptionPane.showMessageDialog(null, "ISBN inv??lido.");
        }
        else if (!Validacao2.validarAno(ano))
        {
            JOptionPane.showMessageDialog(null, "Ano inv??lido.");
        }
        else
        {
            try
            {
                //Verificar se autor j?? existe. Se n??o existe, inserir no BD.
                AutorDao autorDao = DaoFactory.newAutorDao();
                if (autorDao.readName(nomeCompletoAutor) != null)
                {
                    autor = autorDao.readName(nomeCompletoAutor);
                }
                else
                {
                    autor = new Autor(nomeCompletoAutor);
                    autorDao.create(autor);
                    autor = autorDao.readName(nomeCompletoAutor);
                }
                //Verificar se editora j?? existe. Se n??o existe, inserir no BD.
                EditoraDao editoraDao = DaoFactory.newEditoraDao();
                if (editoraDao.readName(nomeEditora) != null)
                {
                    editora = editoraDao.readName(nomeEditora);
                }
                else
                {
                    editora = new Editora(nomeEditora);
                    editoraDao.create(editora);
                    editora = editoraDao.readName(nomeEditora);
                }
                //Pegar categoria do BD
                CategoriaDao categoriaDao = DaoFactory.newCategoriaDao();
                categoria = categoriaDao.read(categoriaId);
                if (novo)
                {
                    //Inserir o livro no BD.
                    LivroDao livroDao = DaoFactory.newLivroDao();
                    Livro livro = new Livro(isbn, ano, titulo, disponivel, autor, editora, categoria);
                    livroDao.create(livro);
                    JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                }
                else
                {
                    //Editar o livro no BD
                    LivroDao livroDao = DaoFactory.newLivroDao();
                    Livro livro = new Livro(this.livro.getId(), isbn, ano, titulo, disponivel, autor, editora, categoria);
                    livroDao.edit(livro);
                    JOptionPane.showMessageDialog(null, "Livro editado com sucesso!");
                }
            } catch (DuplicateKeyException ex)
            {
                System.out.println("Chave duplicada");

            } catch (DataBaseException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        atualizarTabela();
    }//GEN-LAST:event_jButtonSalvarActionPerformed


    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ExcluirActionPerformed
    {//GEN-HEADEREND:event_ExcluirActionPerformed
        try
        {
            LivroDao livroDao = DaoFactory.newLivroDao();
            livroDao.delete(livro);
        } catch (DataBaseException ex)
        {
//            System.out.println(ex.getMessage());
            String[] options = new String[]
            {
                "Sim", "Cancelar"
            };
            int response = JOptionPane.showOptionDialog(null, "Este livro consta no registro"
                    + " de empr??stimos e por isso n??o pode ser exclu??do do banco de dados."
                    + "\n\nGostaria de torn??-lo indispon??vel?", "Aviso",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[1]);
            if (response == 0)
            {
                try {
                    livro.setDisponivel(false);
                    LivroDao livroDao = DaoFactory.newLivroDao();
                    livroDao.edit(livro);
                } catch (DataBaseException ex1) {
                    Logger.getLogger(TelaCadastroLivros.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        atualizarTabela();
    }//GEN-LAST:event_ExcluirActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonNovoActionPerformed
    {//GEN-HEADEREND:event_jButtonNovoActionPerformed
        novo = true;
        jTextFieldTitulo.setText("");
        jTextFieldAutor.setText("");
        jTextFieldEditora.setText("");
        jFormattedTextFieldAno.setText("");
        jMyNumberFieldIsbn.setText("");
        jComboBoxCategoria.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void FecharActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FecharActionPerformed
    {//GEN-HEADEREND:event_FecharActionPerformed
        dispose();
    }//GEN-LAST:event_FecharActionPerformed

    public JComboBox<Categoria> getjComboBoxCategoria()
    {
        return jComboBoxCategoria;
    }

    public JFormattedTextField getjFormattedTextFieldAno()
    {
        return jFormattedTextFieldAno;
    }

    public JMyNumberField getjMyNumberFieldIsbn()
    {
        return jMyNumberFieldIsbn;
    }

    public JTextField getjTextFieldAutor()
    {
        return jTextFieldAutor;
    }

    public JTextField getjTextFieldEditora()
    {
        return jTextFieldEditora;
    }

    public JTextField getjTextFieldTitulo()
    {
        return jTextFieldTitulo;
    }

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
            java.util.logging.Logger.getLogger(TelaCadastroLivros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TelaCadastroLivros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TelaCadastroLivros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TelaCadastroLivros.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new TelaCadastroLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Excluir;
    private javax.swing.JButton Fechar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldAno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private br.univates.system32.components.JMyNumberField jMyNumberFieldIsbn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldEditora;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
