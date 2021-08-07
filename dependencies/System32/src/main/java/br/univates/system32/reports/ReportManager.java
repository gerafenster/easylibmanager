/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.system32.reports;

import br.univates.system32.db.DataBaseException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author mouri
 */
public class ReportManager
{
    private Connection dbConnection;

    public ReportManager(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
    }

    public ReportManager()
    {
        this.dbConnection = null;
    }
    
    public void setDataBaseConnection(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
    }
    
    public void createReport( Report report )
    {
        try
        {
            // Compilar o relatório do formato XML gerando um objeto JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream( report.getPath() ));

            // Gera o relatório efetivamente
            JasperPrint print = JasperFillManager.fillReport(jasperReport, report.getParameters(), dbConnection );

            // Exibir o relatório
            JasperViewer.viewReport(print,false);
        } 
        catch (JRException ex)
        {
            
        }
    }
    
    
}
