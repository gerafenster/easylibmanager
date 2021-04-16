package br.univates.negocio;

public class Emprestimo
{
    
    int id;
    String dataEmprestimo;
    String dataDevolução;
    int funcionarioId;
    int usuarioId;
    int livroId;

    public Emprestimo(String dataEmprestimo, int funcionarioId, int usuarioId, int livroId)
    {
        this.dataEmprestimo = dataEmprestimo;
        this.funcionarioId = funcionarioId;
        this.usuarioId = usuarioId;
        this.livroId = livroId;
    }
}
