package br.univates.easylibmanager;

public class Main
{

    public static void main(String[] args)
    {
        SistemaEasyLibManager sys = SistemaEasyLibManager.getInstance();
//        sys.setSplashPath("/br/univates/negocio/foto.png");
        sys.start();
    }

}
