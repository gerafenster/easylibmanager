/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.system32.reports;

import java.util.HashMap;

/**
 *
 * @author mouri
 */
public interface Report
{
    public HashMap getParameters();
    public String getPath();
}
