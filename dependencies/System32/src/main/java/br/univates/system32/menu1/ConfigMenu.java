package br.univates.system32.menu1;

public interface ConfigMenu
{
    public int getNumItens();
    public char getAtalho(int i);
    public String getDesc(int i);
    public void executar(int op);
    public String getTitulo();
    public char getAtalhoSair();
    public String getDescrSair();
    public boolean isRepetir();
}
