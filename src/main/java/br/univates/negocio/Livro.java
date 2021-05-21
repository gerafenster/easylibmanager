package br.univates.negocio;

public class Livro
{

    int id;
    String isbn;
    int ano;
    String titulo;
    Boolean Disponivel;
    Autor autor;
    Editora editora;
    Categoria categoria;

    public Livro()
    {
    }

    public Livro(int id, String isbn, int ano, String titulo, Boolean Disponivel, Autor autor, Editora editora, Categoria categoria)
    {
        this.id = id;
        this.isbn = isbn;
        this.ano = ano;
        this.titulo = titulo;
        this.Disponivel = Disponivel;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
    }

    public Livro(String isbn, int ano, String titulo, Boolean Disponivel, Autor autor, Editora editora, Categoria categoria)
    {
        this.isbn = isbn;
        this.ano = ano;
        this.titulo = titulo;
        this.Disponivel = Disponivel;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
    }

    public int getId()
    {
        return id;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public int getAno()
    {
        return ano;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public Boolean isDisponivel()
    {
        return Disponivel;
    }

    public String isDisponivelString()
    {
        if (Disponivel)
        {
            return "Sim";
        }
        else
        {
            return "Não";
        }
    }

    public Autor getAutor()
    {
        return autor;
    }

    public Editora getEditora()
    {
        return editora;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Categoria getCategoria()
    {
        return categoria;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public void setAno(int ano)
    {
        this.ano = ano;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public void setDisponivel(boolean Disponivel)
    {
        this.Disponivel = Disponivel;
    }

    public void setAutor(Autor autor)
    {
        this.autor = autor;
    }

    public void setEditora(Editora editora)
    {
        this.editora = editora;
    }

    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria;
    }

}
