package sgu.jakarta.demo.jakarta.hello;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home"})
public class HomeServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public HomeServlet() {
       super();
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

       
       // Forward to /WEB-INF/views/homeView.jsp
       // (Users can not access directly into JSP pages placed in WEB-INF)
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
       
       dispatcher.forward(request, response);
       
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }

}