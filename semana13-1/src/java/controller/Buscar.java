package controller;

import ejb.ProductosFacade;
import entity.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Jose
 */
public class Buscar extends HttpServlet {

    @EJB
    private ProductosFacade productosFacade;

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter sal = response.getWriter();
        int cod = Integer.parseInt(request.getParameter("txtCodigo"));
        Productos px = productosFacade.find(cod);
        
        if(px ==null){
            RequestDispatcher rd = request.getRequestDispatcher("vacio.html");
            rd.forward(request, response);
            //sal.println("Lo sentimos el producto con el nombre ingresado no existe ");
        }else{
            
            sal.println(px.getCodigo()+"  "+px.getNombre()+" "+px.getCantidad()
                    +"  "+px.getPrecio());
            
            
               
                    sal.println("<html>\n" +
"    <head>\n" +
"        <title>REGISTRO</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\">\n" +
"        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap\">\n" +
"        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/css/mdb.min.css\" rel=\"stylesheet\">\n" +
"                \n" +
"        <style>\n" +
"            #footer {\n" +
"                position:fixed;\n" +
"                left:0px;\n" +
"                bottom:0px;\n" +
"                height:150px;\n" +
"                width:100%;\n" +
"                background:#999;\n" +
"             }\n" +
"        </style>\n" +
"    </head>\n" +
"    \n" +
"    \n" +
"    \n" +
"    \n" +
"    \n" +
"    <body>\n" +
"        <nav class=\"navbar navbar-expand-lg navbar-dark indigo\">\n" +
"          <a class=\"navbar-brand\" href=\"#\">Laboratorio 13</a>\n" +
"          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarText\"\n" +
"            aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"            <span class=\"navbar-toggler-icon\"></span>\n" +
"          </button>\n" +
"          <div class=\"collapse navbar-collapse\" id=\"navbarText\">\n" +
"            <ul class=\"navbar-nav mr-auto\">\n" +
"              <li class=\"nav-item\">\n" +
"                <a class=\"nav-link\" href=\"Listar\">Listar productos</a>\n" +
"              </li>\n" +
"              <li class=\"nav-item\">\n" +
"                <a class=\"nav-link\" href=\"buscar.html\">Buscar productos</a>\n" +
"              </li>\n" +
"              <li class=\"nav-item\">\n" +
"                <a class=\"nav-link\" href=\"registro.html\">Registrar productos</a>\n" +
"              </li>\n" +
"            </ul>\n" +
"          </div>\n" +
"        </nav>         <div style=\"margin-top:1%\" class=\"container\">\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-12 py-2\">\n" +
"                    <div class=\"mb-5 flex-center\">\n" +
"                        <h3 class=\"font-weight-bold\">Listado de productos</h3>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>");
                    
   
        sal.println("<table class=\"table table-bordered\">\n" +
"  <thead class=\"thead-light text-center\">\n" +
"    <tr>\n" +
"      <th scope=\"col\">Codigo</th>\n" +
"      <th scope=\"col\">Nombre</th>\n" +
"      <th scope=\"col\">Cantidad</th>\n" +
"      <th scope=\"col\">Precio</th>\n" +
"      <th scope=\"col\">Acciones</th>\n" +
"    </tr>\n" +
"  </thead>");                  

         
           
           sal.println("<tbody class=\"thead-light text-center\">\n<tr>\n");
           sal.println("<th scope=\"row\">"+ px.getCodigo()+ "</th>\n" );
           sal.println("<td>"+ px.getNombre()+ "</td>\n");
           sal.println("<td>"+ px.getPrecio()+ "</td>\n");
           sal.println("<td>"+px.getCantidad()+ "</td>\n");
           sal.println("<td><a href='Eliminar?txtCodigo="
                   + px.getCodigo()
                   + "'>"
                   + " \n <button type=\"button\" class=\"btn btn-danger btn-sm\">Eliminar</button></a>"
                           + "<a href='ProcesoEdicion?txtCodigo="
                   + px.getCodigo()
                   + "'>"
                   + " \n <button type=\"button\" class=\"btn btn-info btn-sm\">Editar</button></a></td>\n");
           
  
        
        sal.println("</tr></tbody>\n</table>");
        
              
        sal.println("  \n" +
"        <div id=\"footer\">\n" +
"           <footer class=\"page-footer font-small cyan darken-3 \">\n" +
"            <div class=\"container\">\n" +
"              <div class=\"row\">\n" +
"                <div class=\"col-md-12 py-2\">\n" +
"                  <div class=\"mb-5 flex-center\">\n" +
"                      <h3>vilchez</h3>\n" +
"                  </div>\n" +
"                </div>\n" +
"              </div>\n" +
"            </div>\n" +
"            <div class=\"footer-copyright text-center py-3\">© 2020 Copyright:\n" +
"              <a href=\"index.html\">Inicio</a>\n" +
"            </div>\n" +
"          </footer> \n" +
"        </div> \n" +
"                \n" +
"        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" +
"        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js\"></script>\n" +
"        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js\"></script>\n" +
"        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.16.0/js/mdb.min.js\"></script>\n" +
"    </body>\n" +
"</html>");
                 
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
