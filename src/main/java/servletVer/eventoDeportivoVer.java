package servletVer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.bean.Edicion;
import modelo.bean.EventoDeportivo;
import modelo.dao.ModeloEdicion;
import modelo.dao.ModeloEventoDeportivo;

@WebServlet("/eventoDeportivoVer")
public class eventoDeportivoVer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public eventoDeportivoVer() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEventoDeportivo = Integer.parseInt(request.getParameter("idEventoDeportivo"));
        
        ModeloEventoDeportivo modeloEventoDeportivo = new ModeloEventoDeportivo();
        ModeloEdicion modeloEdicion = new ModeloEdicion();
        
        EventoDeportivo eventoDeportivo = modeloEventoDeportivo.select(idEventoDeportivo);
        ArrayList<Edicion> ediciones = modeloEdicion.selectByEventoDeportivoId(idEventoDeportivo);
        
        request.setAttribute("eventoDeportivo", eventoDeportivo);
        request.setAttribute("ediciones", ediciones);
        
        request.getRequestDispatcher("verEventoDeportivo.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
