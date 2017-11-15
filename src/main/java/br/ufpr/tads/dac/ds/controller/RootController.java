package br.ufpr.tads.dac.ds.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "RootController", urlPatterns = {"/", ""})
public class RootController extends Controller {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(viewPath(String.format("%s/index.jsp", getBasePath())))
                .forward(request, response);
    }

    @Override
    protected String getBasePath() {
        return "index";
    }

}
