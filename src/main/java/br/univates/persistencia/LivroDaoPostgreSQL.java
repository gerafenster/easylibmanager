package br.univates.persistencia;

import br.univates.negocio.Autor;
import br.univates.negocio.Categoria;
import br.univates.negocio.Editora;
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
    private AutorDao autorDao;
    private EditoraDao editoraDao;
    private CategoriaDao categoriaDao;
    private Autor autor;
    private Editora editora;
    private Categoria categoria;

    public LivroDaoPostgreSQL() throws DataBaseException
    {
        this.connection = new DataBaseConnectionManager(
                DataBaseConnectionManager.POSTGRESQL, "easylib_manager", "postgres", "123");
        autorDao = DaoFactory.newAutorDao();
        editoraDao = DaoFactory.newEditoraDao();
        categoriaDao = DaoFactory.newCategoriaDao();
    }

    @Override
    public void create(Livro livro) throws DataBaseException
    {
        if (livro != null)
        {
            String sql = "INSERT INTO livro (isbn, ano, titulo, is_disponivel, autor_id, editora_id, categoria_id)"
                    + " VALUES('" + livro.getIsbn() + "', " + livro.getAno() + ", '" + livro.getTitulo() + "', '"
                    + livro.isDisponivel() + "', " + livro.getAutor().getId() + ", " + livro.getEditora().getId() + ", " + livro.getCategoria().getId() + ")";

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
                    + ", autor_id = " + livro.getAutor().getId() + ", editora_id = " + livro.getEditora().getId()
                    + ", categoria_id = " + livro.getCategoria().getId() + "  WHERE id = " + livro.getId();
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
            String sql = "DELETE FROM livro WHERE id = " + livro.getId();
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
        String sql = "SELECT * FROM livro WHERE id = " + id + "";
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
                autor = autorDao.read(autorId);
                editora = editoraDao.read(editoraId);
                categoria = categoriaDao.read(categoriaId);
                livro = new Livro(id, isbn, ano, titulo, isDisponivel, autor, editora, categoria);
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
        String sql = "SELECT * FROM livro ORDER BY id";

        try
        {
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String isbn = rs.getString("isbn");
                    int ano = rs.getInt("ano");
                    String titulo = rs.getString("titulo");
                    Boolean isDisponivel = rs.getBoolean("is_disponivel");
                    int autorId = rs.getInt("autor_id");
                    int editoraId = rs.getInt("editora_id");
                    int categoriaId = rs.getInt("categoria_id");
                    autor = autorDao.read(autorId);
                    editora = editoraDao.read(editoraId);
                    categoria = categoriaDao.read(categoriaId);
                    livro = new Livro(id, isbn, ano, titulo, isDisponivel, autor, editora, categoria);
                    livros.add(livro);
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

    @Override
    public ArrayList<Livro> readFilter(Livro livro) throws DataBaseException
    {
        String sql = "SELECT * FROM livro WHERE 1=1";

        if (livro.getId() != 0)
        {
            sql += " AND id = " + livro.getId() + "";
        }
        if (livro.getIsbn() != null)
        {
            sql += " AND isbn LIKE '%" + livro.getIsbn() + "%'";
        }
        if (livro.getAno() != 0)
        {
            sql += " AND ano = " + livro.getAno() + "";
        }
        if (livro.getTitulo() != null)
        {
            sql += " AND titulo ILIKE '%" + livro.getTitulo() + "%'";
        }
        if (livro.isDisponivel() != null)
        {
            sql += " AND is_disponivel = " + livro.isDisponivel()+ "";
        }
        if (livro.getAutor() != null)
        {
            sql += " AND autor_id = " + livro.getAutor().getId() + "";
        }
        if (livro.getEditora() != null)
        {
            sql += " AND editora_id = " + livro.getEditora().getId() + "";
        }
        if (livro.getCategoria() != null)
        {
            sql += " AND categoria_id = " + livro.getCategoria().getId() + "";
        }

        ArrayList<Livro> livros = new ArrayList<>();
        Livro aux = null;
        try
        {
            ResultSet rs = connection.runQuerySQL(sql);
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    int id = rs.getInt("id");
                    String isbn = rs.getString("isbn");
                    int ano = rs.getInt("ano");
                    String titulo = rs.getString("titulo");
                    Boolean isDisponivel = rs.getBoolean("is_disponivel");
                    int autorId = rs.getInt("autor_id");
                    int editoraId = rs.getInt("editora_id");
                    int categoriaId = rs.getInt("categoria_id");
                    autor = autorDao.read(autorId);
                    editora = editoraDao.read(editoraId);
                    categoria = categoriaDao.read(categoriaId);
                    aux = new Livro(id, isbn, ano, titulo, isDisponivel, autor, editora, categoria);
                    livros.add(aux);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException(ex.getMessage());
        }
        return livros;
    }
}
