package br.univates.system32.menu2;

public class ItemMenu
{
    private char atalho;
    private String descr;
    private Procedimento procedimento;

    public ItemMenu(char atalho, String descr, Procedimento procedimento)
    {
        this.atalho = atalho;
        this.descr = descr;
        this.procedimento = procedimento;
    }

    public ItemMenu(char atalho, String descr)
    {
        this.atalho = atalho;
        this.descr = descr;
        this.procedimento = null;
    }

    public char getAtalho()
    {
        return atalho;
    }

    public void setAtalho(char atalho)
    {
        if (atalho != ' ')
        {
            this.atalho = atalho;
        }
    }

    public String getDescr()
    {
        return descr;
    }

    public void setDescr(String descr)
    {
        if (!descr.isEmpty())
        {
            this.descr = descr;
        }
    }

    public Procedimento getProcedimento()
    {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento)
    {
        if (procedimento != null)
        {
            this.procedimento = procedimento;
        }
    }
    
    public void executar()
    {
        this.procedimento.executar();
    }
    
}
