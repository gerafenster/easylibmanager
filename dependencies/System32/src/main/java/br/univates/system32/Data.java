package br.univates.system32;

public class Data
{
    private int dia;
    private int mes;
    private int ano;

    public Data(int d, int m, int a)
    {
        dia = d;
        mes = m;
        ano = a;
    }

    public int obterDia() 
    {
        return dia;
    }

    public int obterMes()
    {
        return mes;
    }

    public int obterAno()
    {
        return ano;
    }
    
    public String obterDataFormatada()
    {
        return dia+"/"+mes+"/"+ano;
    }
    
    public void definirDia( int d )
    {
        if (d >=1 && d <=31)
        {
            dia = d;
        }
    }
    
    public void definirMes( int m )
    {
        if (m >=1 && m <= 12)
        {
            mes = m;
        }
    }
    
    public void definirAno( int a )
    {
        if (a > 1582)
        {
            ano = a;
        }
    }
    
    
    
    
    
}
