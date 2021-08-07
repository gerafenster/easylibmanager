package br.univates.system32;

public class Reservatorio
{
    private int capacidadeMaxima;
    private double nivelAtual;
    private double totalConsumido;

    public Reservatorio( int capacidadeMax )
    {
        this.capacidadeMaxima = capacidadeMax;
        this.nivelAtual = 0;
        this.totalConsumido = 0;
    }
    
    public Reservatorio( int capacidadeMax, double nivelAtual )
    {
        this.capacidadeMaxima = capacidadeMax;
        this.nivelAtual = nivelAtual;
        this.totalConsumido = 0;
    }
    
    public int getCapacidadeMaxima()
    {
        return capacidadeMaxima;
    }

    public double getNivelAtual()
    {
        return nivelAtual;
    }

    public double getTotalConsumido()
    {
        return totalConsumido;
    }
    
    public void encher()
    {
        nivelAtual = capacidadeMaxima;
    }
    
    public boolean encher( double quant )
    {
        boolean ok = false;
        if (nivelAtual+quant <= capacidadeMaxima)
        {
            nivelAtual += quant;
            ok = true;
        }
        return ok;
    }
    
    public boolean consumir( double quant )
    {
        boolean ok = false;
        if (nivelAtual >= quant)
        {
            nivelAtual -= quant;
            totalConsumido += quant;
            ok = true;
        }
        return ok;
    }
    
    public void reinicializarConsumo()
    {
        totalConsumido = 0;
    }
}
