package br.univates.easylibmanager;

import br.univates.system32.db.DataBaseConnectionManager;

public class EasyLibManagerSystem
{

    private DataBaseConnectionManager connection;
    //private User logedUser;

    private static EasyLibManagerSystem agenda = new EasyLibManagerSystem();

    public static EasyLibManagerSystem getInstance()
    {
        return agenda;
    }

    // iniciar primeira vez
    // iniciar sempre
    // finalizar
    private EasyLibManagerSystem()
    {
        this.connection = null;
        //this.logedUser = null;
    }

    public void qualquer()
    {
        System.out.println("Teste método");
    }

}
