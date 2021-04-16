package br.univates.negocio;

public class Autor
{

    int id;
    String nomeCompleto;

    public Autor(String nomeCompleto)
    {
        this.nomeCompleto = nomeCompleto;
    }

    public Autor(int id, String nomeCompleto)
    {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
    }

    public int getId()
    {
        return id;
    }

    public String getNomeCompleto()
    {
        return nomeCompleto;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
