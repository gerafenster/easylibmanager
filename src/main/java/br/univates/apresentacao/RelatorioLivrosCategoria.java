package br.univates.apresentacao;

import br.univates.negocio.Categoria;
import br.univates.system32.reports.Report;
import java.util.HashMap;

public class RelatorioLivrosCategoria implements Report
{
    private Categoria categoria;

    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria;
    }
    
    @Override
    public HashMap getParameters()
    {
        HashMap map = new HashMap();
        map.put("idCategoria", categoria.getId());
        
        return map;
    }

    @Override
    public String getPath()
    {
        return "/br/univates/resources/reports/RelatorioLivrosCategoria.jrxml";
    }
    
}
