package br.ufpr.tads.dac.ds.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        String contextPath = ((HttpServletRequest) request).getContextPath();
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String loginURI = String.format("%s/login", contextPath);

        boolean loggedIn = session != null && session.getAttribute(Role.class.getSimpleName()) != null;
        boolean loginRequest = requestURI.equals(loginURI);
        boolean staticRequest = requestURI.startsWith(String.format("%s/static/", contextPath));
        boolean publicRequest = requestURI.startsWith(String.format("%s/public/", contextPath));
        boolean wsRequest = requestURI.startsWith(String.format("%s/webresources/ws/", contextPath));
        
        if (loggedIn || loginRequest || staticRequest || publicRequest || wsRequest) {
            chain.doFilter(request, response);
            return;
        }

        ((HttpServletResponse) response).sendRedirect(loginURI);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
