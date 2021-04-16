package br.univates.view;

import br.univates.dao.AutorDao;
import br.univates.dao.CategoriaDao;
import br.univates.dao.DaoFactory;
import br.univates.dao.EditoraDao;
import br.univates.dao.LivroDao;
import br.univates.dao.Validacao;
import br.univates.model.Autor;
import br.univates.model.Editora;
import br.univates.model.Livro;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.DuplicateKeyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateLivroView extends javax.swing.JFrame
{

    public CreateLivroView()
    {
        try
        {
            initComponents();
            CategoriaDao categoriaDao = DaoFactory.newCategoriaDao();
            for (int i = 0; i < categoriaDao.readAll().size(); i++)
            {
                jComboBoxCategoria.addItem(categoriaDao.readAll().get(i).getNome());
            }
        } catch (DataBaseException ex)
        {
            Logger.getLogger(CreateLivroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldAno = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEditora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldAutor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jButtonSalvar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldIsbn = new javax.swing.JFormattedTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ISBN");

        jLabel2.setText("Ano");

        try
        {
            jFormattedTextFieldAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }

        jLabel3.setText("Título");

        jLabel4.setText("Editora");

        jLabel5.setText("Autor(es)");

        jLabel6.setText("Categoria");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel7.setText("Autor1; Autor2; Autor3");

        jFormattedTextFieldIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#############"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEditora, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAutor, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSalvar)
                        .addGap(61, 61, 61))
                    .addComponent(jFormattedTextFieldIsbn)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSalvarActionPerformed
    {//GEN-HEADEREND:event_jButtonSalvarActionPerformed
//        boolean isIsbnValid = Validacao.validarIsbn(jFormattedTextFieldIsbn.getText());
//        boolean isAnoValid = Validacao.validarAno(Integer.parseInt(jFormattedTextFieldAno.getText()));

        String isbn = jFormattedTextFieldIsbn.getText();
        int ano = Integer.parseInt(jFormattedTextFieldAno.getText());
        String titulo = jTextFieldTitulo.getText();
        boolean disponivel = true;
        int categoriaId = jComboBoxCategoria.getSelectedIndex() + 1;
        String nomeCompletoAutor = jTextFieldAutor.getText();
        String nomeEditora = jTextFieldEditora.getText();
        Autor autor;
        Editora editora;
        
        try
        {
            //Verificar se autor já existe. Se não existe, inserir no BD.
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
//            //Verificar se editora já existe. Se não existe, inserir no BD.
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
//            //Por último, inserir o livro no BD.
            LivroDao livroDao = DaoFactory.newLivroDao();
            Livro livro = new Livro(isbn, ano, titulo, disponivel, autor.getId(), editora.getId(), categoriaId);
            livroDao.create(livro);
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
            dispose();

        } catch (DuplicateKeyException ex)
        {
            System.out.println("Chave duplicada");

        } catch (DataBaseException ex)
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    public JComboBox<String> getjComboBoxCategoria()
    {
        return jComboBoxCategoria;
    }

    public JFormattedTextField getjFormattedTextFieldAno()
    {
        return jFormattedTextFieldAno;
    }

    public JFormattedTextField getjFormattedTextFieldIsbn()
    {
        return jFormattedTextFieldIsbn;
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
            java.util.logging.Logger.getLogger(CreateLivroView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CreateLivroView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CreateLivroView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CreateLivroView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CreateLivroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldAno;
    private javax.swing.JFormattedTextField jFormattedTextFieldIsbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldEditora;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
