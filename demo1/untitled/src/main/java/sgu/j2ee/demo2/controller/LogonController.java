package sgu.j2ee.demo2.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogonController {

    @GetMapping("/Logon.do")
    public ModelAndView showLogonPage() {
        return new ModelAndView("logon");
    }

    @PostMapping("/Logon.do")
    public String processLogon(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Perform actual authentication logic here
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            // Create a new session
            HttpSession session = request.getSession(true);

            // Store user information in session
            session.setAttribute("user", username);

            // Redirect to the main page after login
            return "redirect:/Search.do";
        } else {
            // Authentication failed, return to login page with error
            return "redirect:/Logon.do?error=true";
        }
    }

    @GetMapping("/Logout.do")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/Logon.do";
    }

    private boolean authenticate(String username, String password) {
        // Implement your authentication logic
        // This is just a simple example
        return username != null && password != null &&
                !username.isEmpty() && !password.isEmpty();
    }
}
