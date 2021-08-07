package br.univates.system32.app;

import br.univates.authenticator.GenericUser;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;
import br.univates.system32.reports.ReportManager;
import br.univates.system32.splash.Splash;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mouriac
 */
public abstract class Application
{
    public final static int START_WITHOUT_DEFAULT_PROCESSES = 0;
    public final static int START_WITH_DEFAULT_PROCESSES = 1;
    
    private String dataBaseUserName;
    private String dataBasePassword;
    private String dataBaseName;
    private int dataBaseSystem;
    
    private boolean firstExecution;
    private String applicationName;

    private GenericUser loggedUser;
    private String splashPath;
    
//    String applicationVersion;
//    int UI;
    
    private DataBaseConnectionManager dataBaseManager;
    private ReportManager reportManager;
    private ArrayList<ApplicationProcess> firstExecutionProcess; // processos de inicialização
    private ArrayList<ApplicationProcess> initialProcess; // processos de inicialização
    private ArrayList<ApplicationProcess> finalProcess; // processos de finalização do sistema

    public Application()
    {
        this( "Falta definir a nome da aplicação","semnome" );
    }
    
    public Application( String applicationName, String dataBaseName )
    {
        this.firstExecutionProcess = new ArrayList();
        this.initialProcess = new ArrayList();
        this.finalProcess = new ArrayList();
        
        this.dataBaseSystem = -1;
        this.dataBasePassword = null;
        this.dataBaseUserName = null;
        
        this.dataBaseName = dataBaseName;
        this.applicationName = applicationName;
        this.firstExecution = !existsPropertiesFile();
        
        this.dataBaseManager = null;
        this.reportManager = null;
    }
    
    public void addFirstExecutionProcess(ApplicationProcess process)
    {
        firstExecutionProcess.add(process);
    }
    
    public void addInitialProcess(ApplicationProcess process)
    {
        initialProcess.add(process);
    }
    
    public void addFinalProcess(ApplicationProcess process)
    {
        finalProcess.add(process);
    }
    
    public DataBaseConnectionManager getDataBaseManager()
    {
        return dataBaseManager;
    }
    
    public String getDataBaseUserName()
    {
        return dataBaseUserName;
    }

    public String getDataBasePassword()
    {
        return dataBasePassword;
    }

    public String getDataBaseName()
    {
        return dataBaseName;
    }

    public int getDataBaseSystem()
    {
        return dataBaseSystem;
    }

    public String getApplicationName()
    {
        return applicationName;
    }

    public String getSplashPath()
    {
        return splashPath;
    }

    public GenericUser getLoggedUser()
    {
        return loggedUser;
    }

    public ReportManager getReportManager()
    {
        return reportManager;
    }
    
    public void setDataBaseName(String dataBaseName)
    {
        if (!dataBaseName.isEmpty())
        {
            this.dataBaseName = dataBaseName;
        }
    }

    public void setApplicationName(String applicationName)
    {
        if (!applicationName.isEmpty())
        {
            this.applicationName = applicationName;
        }
    }

    public void setLoggedUser(GenericUser loggedUser)
    {
        this.loggedUser = loggedUser;
    }

    public void setSplashPath(String splashPath)
    {
        this.splashPath = splashPath;
    }

    public boolean isFirstExecution()
    {
        return this.firstExecution;
    }
    
    public boolean existsPropertiesFile()
    {
        return new File("system.ini").exists();
    }
    
    protected void defineDefaultFirstExecutionProcesses()
    {
        this.addFirstExecutionProcess( new ApplicationProcess("Criando o arquivo de propriedades...") 
        {
            @Override
            public void run() throws FatalSystemException
            {
                createPropertiesFileGenerationProcess();
            }
        });
    }
    
    protected void defineDefaultInitialProcesses()
    {
        this.addInitialProcess( new ApplicationProcess("Carregando as propriedades do sistema...") {
            @Override
            public void run() throws FatalSystemException
            {
                createPropertiesLoadingProcess();
            }
        });
               
        this.addInitialProcess( new ApplicationProcess("Testando a conexão com o banco de dados...") {
            @Override
            public void run() throws FatalSystemException
            {
                createDataBaseConnectionTestProcess();
            }
        });
        
        this.addInitialProcess( new ApplicationProcess("Inicializando gerenciador de relatórios...") {
            @Override
            public void run() throws FatalSystemException
            {
                try
                {
                    dataBaseManager.connectDataBase();
                    reportManager = new ReportManager( dataBaseManager.getConnection() );
                } 
                catch (DataBaseException ex)
                {
                    throw new FatalSystemException("Falha ao criar gerenciador de relatórios");
                }
            }
        });
    }
    
    public abstract void defineFirstExecutionProcesses();
    
    public abstract void defineInitialProcesses();
    
    public abstract void defineFinalProcesses();
    
    
    public void runFirstExecutionProcesses()
    {
        for (ApplicationProcess process: firstExecutionProcess)
        {
            System.out.println(process.getDescription());
            try
            {
                process.run();
            } 
            catch (FatalSystemException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.exit(0);
            }
        }
    }
    
    public void runInitalProcesses()
    {    
        Splash splash = null;
        
        if (this.getSplashPath() != null && !this.getSplashPath().isBlank() )
        {
            splash = new Splash( this.getSplashPath() );
            splash.setSteps( initialProcess.size() );
            splash.showSplash();
        }

        for (ApplicationProcess process: initialProcess)
        {
            System.out.println( process.getDescription() );
            
            if (splash != null)
            {
                splash.next( process.getDescription() );
                if (!process.isSplash())
                {
                    splash.dispose();
                }
            }
            
            try
            {
                process.run();
            } 
            catch (FatalSystemException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.exit(0);
            }
        }
        
        if (splash != null)
        {
            splash.dispose();
        }           

    }
    
    public void runFinalProcesses()
    {
        for (ApplicationProcess process: finalProcess)
        {
            System.out.println(process.getDescription());
            try
            {
                process.run();
            } 
            catch (FatalSystemException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.exit(0);
            }
        }
    }
    
    public void start( int defaultProcesses )
    {
        if (this.isFirstExecution())
        {
            if (defaultProcesses == Application.START_WITH_DEFAULT_PROCESSES)
            {
                defineDefaultFirstExecutionProcesses();
            }
            this.defineFirstExecutionProcesses();
            this.runFirstExecutionProcesses();
        }
        
        if (defaultProcesses == Application.START_WITH_DEFAULT_PROCESSES)
        {
            defineDefaultInitialProcesses();
        }
        defineInitialProcesses();
        runInitalProcesses();
    }
    
    public void start()
    {
        start( Application.START_WITH_DEFAULT_PROCESSES );
    }
    
    protected void createPropertiesFileGenerationProcess() throws FatalSystemException
    {
        PropertiesForm pf = new PropertiesForm();
        pf.setTitle( (applicationName == null ? "Propriedades do sistema" : applicationName )  );
        pf.setVisible(true);

        if ( !pf.isConfirm() )
        {
            throw new FatalSystemException("Operação cancelada pelo usuário");
        }

        dataBaseUserName = pf.getUserName();
        dataBasePassword = pf.getPassword();
        dataBaseSystem = pf.getDBMS();

        try
        {
            Properties p = new Properties();
            p.setProperty("dataBaseUserName", dataBaseUserName);
            p.setProperty("dataBasePassword", dataBasePassword);
            p.setProperty("dataBaseName", dataBaseName);
            p.setProperty("dataBaseSystem", dataBaseSystem + "");

            FileOutputStream file = new FileOutputStream("system.ini");
            p.store( file, "Propriedades do Sistema");
            file.close();
        } 
        catch (IOException ex)
        {
            throw new FatalSystemException("Erro ao criar o arquivo de propriedades");
        }
    }
    
    protected void createDataBaseSchemaGenerationProcess( String path ) throws FatalSystemException
    {
        try
        {
            if (dataBaseSystem == -1 || dataBaseUserName == null || dataBasePassword == null)
            {
                throw new FatalSystemException("As propriedades do sistema não foram definidas");
            }
            
            /*
            * Quando a conexão for com SQLite é necessário ter um arquivo já criado do banco de dados
            * Esse arquivo, claro, pode ser vazio. Mas será o banco onde a conexão será feita.
            */
            
            if (dataBaseName.isBlank())
            {
                throw new FatalSystemException("O nome do banco de dados não foi definido");
            }
            
            if (dataBaseSystem != DataBaseConnectionManager.SQLITE)
            {
                dataBaseManager = new DataBaseConnectionManager(dataBaseSystem, "", dataBaseUserName, dataBasePassword);
                dataBaseManager.connectDataBase();
                dataBaseManager.runSQL("create database "+this.dataBaseName+";");
                dataBaseManager.closeConnection();
            }
            
            dataBaseManager = new DataBaseConnectionManager(dataBaseSystem, dataBaseName, dataBaseUserName, dataBasePassword);
            dataBaseManager.connectDataBase();
            dataBaseManager.setScriptPath( path );
            dataBaseManager.runScritpSQL();
            dataBaseManager.closeConnection();
        } 
        catch (DataBaseException ex)
        {
            throw new FatalSystemException( ex.getMessage() );
        }

    }
    

    protected void createPropertiesLoadingProcess() throws FatalSystemException
    {
        try
        {                   
            Properties p = new Properties();
            FileInputStream file = new FileInputStream("system.ini");
            p.load(file);
            file.close();

            dataBaseUserName = p.getProperty("dataBaseUserName");
            dataBasePassword = p.getProperty("dataBasePassword");
            dataBaseName = p.getProperty("dataBaseName");
            dataBaseSystem = Integer.parseInt(p.getProperty("dataBaseSystem"));

        } 
        catch (IOException ex)
        {
            throw new FatalSystemException("Ocorreu uma falha ao carregar o arquivo de propriedades");
        }
    }

    protected void createDataBaseConnectionTestProcess() throws FatalSystemException
    {
        try
        {
            if (dataBaseSystem == -1 || dataBaseName == null || dataBaseUserName == null || dataBasePassword == null)
            {
                throw new FatalSystemException("As propriedades do sistema não foram definidas");
            }
            dataBaseManager = new DataBaseConnectionManager(dataBaseSystem, dataBaseName, dataBaseUserName, dataBasePassword);
            dataBaseManager.connectionTest();
        } 
        catch (DataBaseException ex)
        {
            throw new FatalSystemException("A conexão com o banco de dados falhou");
        }
    }



    

    

}
