package br.univates.easylibmanager;

import br.univates.apresentacao.TelaLogin;
import br.univates.apresentacao.TelaMenuPrincipal;
import br.univates.authenticator.Authenticator;
import br.univates.authenticator.GenericUser;
import br.univates.system32.app.Application;
import br.univates.system32.app.ApplicationProcess;
import br.univates.system32.app.FatalSystemException;
import java.util.ArrayList;

public class SistemaEasyLibManager extends Application
{

    private static SistemaEasyLibManager sys = new SistemaEasyLibManager();

    public static SistemaEasyLibManager getInstance()
    {
        return sys;
    }

    private SistemaEasyLibManager()
    {
        super("EasyLib Manager", "easylib_manager");
    }

    @Override
    public void defineFirstExecutionProcesses()
    {
        this.addFirstExecutionProcess(new ApplicationProcess("Criando o esquema do banco de dados...")
        {
            @Override
            public void run() throws FatalSystemException
            {
                createDataBaseSchemaGenerationProcess("/br/univates/resources/script/easylibmanager_postgres.sql");
            }
        });
    }

    @Override
    public void defineInitialProcesses()
    {
        this.addInitialProcess(new ApplicationProcess("Abrindo a tela do sistema...")
        {
            @Override
            public void run()
            {
                TelaLogin t = new TelaLogin();
                t.setVisible(true);
            }
        });

    }

@Override
public void defineFinalProcesses()
    {

    }
}
