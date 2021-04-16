package br.univates.persistencia;

import br.univates.negocio.Livro;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.db.Filter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDaoPostgreSQL implements LivroDao
{

    private DataBaseConnectionManager connection;

    public LivroDaoPostgreSQL() throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(
                DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");

    }

    @Override
    public void create(Livro livro) throws DataBaseException
    {
        if (livro != null)
        {
            String sql = "INSERT INTO livro (isbn, ano, titulo, is_disponivel, autor_id, editora_id, categoria_id)"
                    + " VALUES('" + livro.getIsbn() + "', " + livro.getAno() + ", '" + livro.getTitulo() + "', '"
                    + livro.isDisponivel() + "', " + livro.getAutorId() + ", " + livro.getEditoraId() + ", " + livro.getCategoriaId() + ")";

            System.out.println(livro.getIsbn());
            System.out.println(livro.getAno());
            System.out.println(livro.getTitulo());
            System.out.println(livro.isDisponivel());
            System.out.println(livro.getAutorId());
            System.out.println(livro.getEditoraId());
            System.out.println(livro.getCategoriaId());

            connection.runSQL(sql);

        }
        else
        {
            throw new DataBaseException("Livro Nulo");
        }
    }

    @Override
    public void edit(Livro livro) throws DataBaseException
    {
        if (livro != null)
        {
            String sql = "UPDATE livro SET isbn = '" + livro.getIsbn() + "', ano = " + livro.getAno()
                    + ", titulo = '" + livro.getTitulo() + "', is_disponivel = " + livro.isDisponivel()
                    + ", autor_id = " + livro.getAutorId() + ", editora_id = " + livro.getEditoraId()
                    + ", categoria_id = " + livro.getCategoriaId() + "  WHERE id = " + livro.getId();
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Livro nulo");
        }
    }

    @Override
    public void delete(Livro livro) throws DataBaseException
    {
        if (livro != null)
        {
            String sql = "DELETE FROM cliente WHERE id = " + livro.getId();
            connection.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Id nula");
        }
    }

    @Override
    public Livro read(int id) throws DataBaseException
    {
        String sql = "SELECT * FROM autor WHERE id = " + id + "";
        Livro livro = null;

        try
        {
            ResultSet rs = connection.runQuerySQL(sql);

            if (rs.isBeforeFirst())
            {
                rs.next();
                String isbn = rs.getString("isbn");
                int ano = rs.getInt("ano");
                String titulo = rs.getString("titulo");
                Boolean isDisponivel = rs.getBoolean("is_disponivel");
                int autorId = rs.getInt("autor_id");
                int editoraId = rs.getInt("editora_id");
                int categoriaId = rs.getInt("categoria_id");
                livro = new Livro(id, isbn, ano, titulo, isDisponivel, autorId, editoraId, categoriaId);
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return livro;
    }

    @Override
    public ArrayList<Livro> readAll() throws DataBaseException
    {
        ArrayList<Livro> livros = new ArrayList<>();
        Livro livro = null;

        try
        {
            String sql = "SELECT * FROM livro";
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    rs.next();
                    int id = rs.getInt("id");
                    String isbn = rs.getString("isbn");
                    int ano = rs.getInt("ano");
                    String titulo = rs.getString("titulo");
                    Boolean isDisponivel = rs.getBoolean("is_disponivel");
                    int autorId = rs.getInt("autor_id");
                    int editoraId = rs.getInt("editora_id");
                    int categoriaId = rs.getInt("categoria_id");
                    livro = new Livro(id, isbn, ano, titulo, isDisponivel, autorId, editoraId, categoriaId);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return livros;
    }

    @Override
    public Livro readName(String name) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Livro> read(Filter filter) throws DataBaseException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
