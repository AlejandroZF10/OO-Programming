import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Tablas extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {

    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    String name = req.getParameter("name");
    out.println("<HTML>");
    out.println("<HEAD><TITLE>Tablas de multiplicar, " + name + "</TITLE></HEAD>");
    out.println("<BODY>");
    for(int i=1; i<= 10; i++){
          for(int j=1; j<= 10; j++){
                out.println(i + " X " + j + " = " + i*j +"<br>");
          }
    }
        out.println("Servido, <h1>"+"</h1>");
    
    out.println("<img src= \"http://localhost:5050/obtenimagen?nombre=manchas&tabla=PerroImg\"></img>");
    out.println("</BODY></HTML>");
  }

  public String getServletInfo() {
    return "Quieres obtener las tablas de multiplicar" + 
           "saying hello";
  }
}
