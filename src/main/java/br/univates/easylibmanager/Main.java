package br.univates.easylibmanager;

public class Main
{

    public static void main(String[] args)
    {
        EasyLibManagerSystem x = EasyLibManagerSystem.getInstance();

        x.qualquer();

        EasyLibManagerSystem.getInstance().qualquer();
    }

}
