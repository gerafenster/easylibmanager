package br.univates.model;

public class Livro
{

    int id;
    String isbn;
    int ano;
    String titulo;
    boolean Disponivel;
    int autorId;
    int editoraId;
    int categoriaId;

    public Livro(String isbn, int ano, String titulo, boolean isDisponivel, int autorId, int editoraId, int categoriaId)
    {
        this.isbn = isbn;
        this.ano = ano;
        this.titulo = titulo;
        this.Disponivel = isDisponivel;
        this.autorId = autorId;
        this.editoraId = editoraId;
        this.categoriaId = categoriaId;
    }

    public Livro(int id, String isbn, int ano, String titulo, boolean isDisponivel, int autorId, int editoraId, int categoriaId)
    {
        this.id = id;
        this.isbn = isbn;
        this.ano = ano;
        this.titulo = titulo;
        this.Disponivel = isDisponivel;
        this.autorId = autorId;
        this.editoraId = editoraId;
        this.categoriaId = categoriaId;
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

    public boolean isDisponivel()
    {
        return Disponivel;
    }

    public int getAutorId()
    {
        return autorId;
    }

    public int getEditoraId()
    {
        return editoraId;
    }

    public int getCategoriaId()
    {
        return categoriaId;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
