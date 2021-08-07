package br.univates.system32.tools;


import br.univates.system32.menu1.Menu;
import br.univates.system32.menu1.ConfigMenu;

public class TelaMenuPadrao
{
    private ConfigMenu configMenu;

    public TelaMenuPadrao(ConfigMenu configMenu)
    {
        this.configMenu = configMenu;
    }
    
    public void exibir()
    {
        Menu m = new Menu( configMenu );
        m.gerar();
    }
    
    public void fechar()
    {
        System.exit(0);
    }
}
