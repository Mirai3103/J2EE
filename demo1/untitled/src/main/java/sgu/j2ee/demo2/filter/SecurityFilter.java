package sgu.j2ee.demo2.filter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "*.do")
public class SecurityFilter implements Filter {

    // URLs that don't require authentication
    private static final String[] PUBLIC_URLS = {"/Logon.do"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Get the requested URI
        String requestURI = httpRequest.getRequestURI();

        // Check if the requested URL is public
        if (isPublicURL(requestURI)) {
            // Allow access to public URLs without checking session
            chain.doFilter(request, response);
            return;
        }

        // Check if user has a valid session
        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            // No valid session, redirect to login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Logon.do");
            return;
        }

        // User has a valid session, allow access
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup if needed
    }

    /**
     * Check if the requested URL is in the list of public URLs
     */
    private boolean isPublicURL(String requestURI) {
        for (String publicURL : PUBLIC_URLS) {
            if (requestURI.endsWith(publicURL)) {
                return true;
            }
        }
        return false;
    }
}