package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.bean.Deportista;
import modelo.dao.ModeloDeportista;

@WebServlet("/deportistaVer")
public class DeportistaVer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeportistaVer() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID del deportista desde el parámetro de la solicitud
        int idDeportista = Integer.parseInt(request.getParameter("idDeportista"));
        
        // Crear instancia del modelo y obtener los detalles del deportista
        ModeloDeportista modeloDeportista = new ModeloDeportista();
        Deportista deportista = modeloDeportista.select(idDeportista);
        
        // Establecer el atributo del deportista en la solicitud
        request.setAttribute("deportista", deportista);
        
        // Redirigir a la página JSP para mostrar los detalles
        request.getRequestDispatcher("verDeportista.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
