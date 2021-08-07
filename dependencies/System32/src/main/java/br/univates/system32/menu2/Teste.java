package br.univates.system32.menu2;

public class Teste
{

    public static void main(String[] args)
    {
        Menu m = new Menu();
        m.addItem(new ItemMenu('i',"Impressão de NF",new Procedimento() {
            @Override
            public void executar()
            {
                System.out.println("dslkfjasdklfjas");
            }
        }));
        
        m.addItem(new ItemMenu('t',"Totalizar mês corrente",new Procedimento() {
            @Override
            public void executar()
            {
                System.out.println("ljlksdjflkçadfjskldasfjlçafkdsj");
            }
        }));
        
        m.gerar();
        
        
    }


}
