/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.dac.ds.controller;

import br.ufpr.tads.dac.ds.facede.CrudFacede;
import br.ufpr.tads.dac.ds.facede.EntregaFacede;
import br.ufpr.tads.dac.ds.model.Authenticable;
import br.ufpr.tads.dac.ds.model.Entrega;
import br.ufpr.tads.dac.ds.model.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
    protected void processNotCrudRequest(HttpServletRequest request, HttpServletResponse response, NotCrudActionException actionException) {
        try {
            String action = actionException.getAction();
            String[] pathParts = actionException.getPathParts();
            Integer id = Integer.parseInt(pathParts[2]);
            
            Funcionario funcionario = null;
            EntregaFacede facede = new EntregaFacede();

            try {
                funcionario = (Funcionario) request.getSession().getAttribute(Authenticable.class.getSimpleName());
            } catch (Exception ignored) { }
            
            switch (action) {
                case "confirm-delivery":
                    request.setAttribute("model", facede.confirmarEntrega(id, funcionario, new Date()));
                    request.setAttribute("message", "Entrega confirmada com sucesso!");
                    break;
                case "confirm-frustration":
                    request.setAttribute("model", facede.confirmarFrustracao(id, new Date()));
                    request.setAttribute("message", "Entrega frustrada! Digite uma justificativa.");
                    break;
                case "cancel-delivery":
                    request.setAttribute("model", facede.cancelarEntrega(id, funcionario, new Date()));
                    request.setAttribute("message", "Entrega cancelada com sucesso!");
                    break;
            }
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            getLogger().debug("", ex);
        }
    }

    @Override
    protected void beforeCreate(HttpServletRequest request, HttpServletResponse response, Entrega model) {
        model.setDataHoraCadastro(new Date());
        String entregue = request.getParameter("entregue");
        if (entregue.equals("1")) {
            model.setEntregue((byte) 0x1);
            model.setDataHoraEntrega(new Date());
        } else {
            model.setEntregue((byte) 0x0);
        }
        String entregaFrustrada = request.getParameter("entregaFrustrada");
        if(entregaFrustrada.equals("1")) {
            model.setEntregaFrustrada((byte) 0x1);
            model.setDataHoraFrustracaoEntrega(new Date());
        } else {
            model.setEntregaFrustrada((byte) 0x0);
        }
        String cancelado = request.getParameter("cancelado");
        if(cancelado.equals("1")) {
            model.setCancelado((byte) 0x1);
            model.setDataHoraCancelamento(new Date());
        } else {
            model.setCancelado((byte) 0x0);
        }
    }
    
    @Override
    protected void beforeUpdate(HttpServletRequest request, HttpServletResponse response, Entrega model) {
        model.setDataHoraCadastro(new Date());
        String entregue = request.getParameter("entregue");
        if (entregue.equals("1")) {
            model.setEntregue((byte) 0x1);
            model.setDataHoraEntrega(new Date());
        } else {
            model.setEntregue((byte) 0x0);
        }
        String entregaFrustrada = request.getParameter("entregaFrustrada");
        if(entregaFrustrada.equals("1")) {
            model.setEntregaFrustrada((byte) 0x1);
            model.setDataHoraFrustracaoEntrega(new Date());
        } else {
            model.setEntregaFrustrada((byte) 0x0);
        }
        String cancelado = request.getParameter("cancelado");
        if(cancelado.equals("1")) {
            model.setCancelado((byte) 0x1);
            model.setDataHoraCancelamento(new Date());
        } else {
            model.setCancelado((byte) 0x0);
        }
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
