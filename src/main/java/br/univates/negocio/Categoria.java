package br.univates.negocio;

public class Categoria
{

    int id;
    String nome;

    public Categoria(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public int getId()
    {
        return id;
    }

}
