/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.dac.ds.controller;

import br.ufpr.tads.dac.ds.facede.CrudFacede;
import br.ufpr.tads.dac.ds.facede.EntregaFacede;
import br.ufpr.tads.dac.ds.model.Entrega;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "EntregaController", urlPatterns = {"/entrega/*"})
public class EntregaController extends CrudController<Entrega> {

    private static final Logger logger = LoggerFactory.getLogger(FuncionarioController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected Entrega getModel() {
        return new Entrega();
    }

    @Override
    protected CrudFacede<Entrega> getFacede() {
        return new EntregaFacede();
    }

    @Override
    protected String getBasePath() {
        return "entrega";
    }
}
