package br.univates.negocio;

public class Cliente
{

    int id;
    String nome;
    String sobrenome;
    String cpf;
    String email;
    String telefone;
    String celular;

    public Cliente(String nome, String sobrenome, String cpf, String email, String telefone, String celular)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public Cliente(int id, String nome, String sobrenome, String cpf, String email, String telefone, String celular)
    {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public String getSobrenome()
    {
        return sobrenome;
    }

    public String getCpf()
    {
        return cpf;
    }

    public String getEmail()
    {
        return email;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
