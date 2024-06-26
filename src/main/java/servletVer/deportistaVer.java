package servletVer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.bean.Deportista;
import modelo.bean.Inscripcion;
import modelo.bean.Resultado;
import modelo.dao.ModeloDeportista;
import modelo.dao.ModeloInscripcion;
import modelo.dao.ModeloResultado;

@WebServlet("/deportistaVer")
public class deportistaVer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public deportistaVer() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDeportista = Integer.parseInt(request.getParameter("idDeportista"));
        
        ModeloDeportista modeloDeportista = new ModeloDeportista();
        ModeloInscripcion modeloInscripcion = new ModeloInscripcion();
        ModeloResultado modeloResultado = new ModeloResultado();
        
        Deportista deportista = modeloDeportista.select(idDeportista);
        ArrayList<Inscripcion> inscripciones = modeloInscripcion.selectByDeportistaId(idDeportista);
        ArrayList<Resultado> resultados = modeloResultado.selectByDeportistaId(idDeportista);
        
        request.setAttribute("deportista", deportista);
        request.setAttribute("inscripciones", inscripciones);
        request.setAttribute("resultados", resultados);
        
        request.getRequestDispatcher("verDeportista.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
