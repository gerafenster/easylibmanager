package br.univates.negocio;

public class Usuario
{

    int id;
    String nome;
    String sobrenome;
    String login;
    String senha;
    String cpf;
    
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(int id, String nome, String sobrenome, String login, String cpf)
    {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.cpf = cpf;
    }

    public Usuario(String nome, String sobrenome, String login, String senha, String cpf)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getSobrenome()
    {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    
}
