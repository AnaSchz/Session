/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidaSesionesServlet extends HttpServlet {
   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

      response.setContentType("text/html");
      HttpSession sesion = request.getSession();
      String titulo = null;

      //Pedimos el atributo, y verificamos si existe
      String claveSesion = (String) sesion.getAttribute("claveSesion");
      
        //Mostramos los  valores en el cliente
      PrintWriter out = response.getWriter();
      out.println("¿Continua la Sesion y es valida?: ");

      if(claveSesion.equals("AnaSan")){
          
         //Si es correcta se redirecciona a un home
        titulo = "llave correcta continua la sesion";
        out.println(titulo);
        response.sendRedirect("home.html");
        
      }
      else
      {
          
          //Si es incorrecta se redirecciona a una página de error
        titulo = "llave incorrecta inicie nuevamente sesion";
            out.println(titulo);
            out.println("<br>");
            out.println("ID de la sesi&oacute;n JSESSIONID: " + sesion.getId());
            response.sendRedirect("error.html");
      }
  
    }

}
