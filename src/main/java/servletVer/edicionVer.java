package servletVer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Deportista;
import modelo.bean.Edicion;
import modelo.bean.Inscripcion;
import modelo.bean.Resultado;
import modelo.dao.ModeloDeportista;
import modelo.dao.ModeloEdicion;
import modelo.dao.ModeloInscripcion;
import modelo.dao.ModeloResultado;

/**
 * Servlet implementation class edicionVer
 */
@WebServlet("/edicionVer")
public class edicionVer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edicionVer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idEdicion = Integer.parseInt(request.getParameter("idEdicion"));
		ModeloEdicion modeloEdicion = new ModeloEdicion();
        ModeloInscripcion modeloInscripcion = new ModeloInscripcion();
        ModeloResultado modeloResultado = new ModeloResultado();
        
        Edicion edicion = modeloEdicion.select(idEdicion);
        ArrayList<Inscripcion> inscripciones = modeloInscripcion.selectByEdicionId(idEdicion);
        ArrayList<Resultado> resultados = modeloResultado.selectByEdicionId(idEdicion);
        
        request.setAttribute("edicion", edicion);
        request.setAttribute("inscripciones", inscripciones);
        request.setAttribute("resultados", resultados);
        
        request.getRequestDispatcher("verEdicion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
