package br.ufpr.tads.dac.ds.controller;

import br.ufpr.tads.dac.ds.filter.Role;
import br.ufpr.tads.dac.ds.model.Admin;
import br.ufpr.tads.dac.ds.model.Authenticable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.criterion.Example;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login", "/logout"})
public class LoginController extends Controller {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (String.format("%s/%s", request.getContextPath(), getBasePath()).equals(request.getRequestURI())) {
            doLogin(request, response);
        } else {
            doLogout(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (String.format("%s/login", request.getContextPath()).equals(request.getRequestURI())) {
            request.getRequestDispatcher(viewPath(String.format("%s/form.jsp", getBasePath()))).forward(request, response);
        } else {
            doLogout(request, response);
        }
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Map<String, String> messages = new HashMap<>();

        if (username == null || username.isEmpty()) {
            messages.put("username", "Informe o usuário");
        }

        if (password == null || password.isEmpty()) {
            messages.put("password", "Informe a senha");
        }

        if (messages.isEmpty()) {
            // Admin
            Admin admin = Admin.getInstance();
            if (admin.getUsername().equals(username)) {
                if (admin.getPassword().equals(password)) {
                    request.getSession().setAttribute(Role.class.getName(), Role.ADMIN);
                    request.getSession().setAttribute(Authenticable.class.getName(), admin);
                    response.sendRedirect(request.getContextPath());
                    return;
                }
            }
            messages.put("login", "Dados inválidos. Tente novamente");
        }

        request.setAttribute("messages", messages);
        request.getRequestDispatcher(viewPath(String.format("%s/form.jsp", getBasePath()))).forward(request, response);
    }

    protected void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath());
    }

    @Override
    public String getServletInfo() {
        return "Login";
    }

    @Override
    protected String getBasePath() {
        return "login";
    }

}
