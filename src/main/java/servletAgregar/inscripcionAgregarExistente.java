package servletAgregar;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Deportista;
import modelo.bean.Edicion;
import modelo.bean.Inscripcion;
import modelo.dao.ModeloDeportista;
import modelo.dao.ModeloInscripcion;

/**
 * Servlet implementation class inscripcionAgregarExistente
 */
@WebServlet("/inscripcionAgregarExistente")
public class inscripcionAgregarExistente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscripcionAgregarExistente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("addDNI");
		int idEdicion = Integer.parseInt(request.getParameter("edicionId"));
		
		ModeloDeportista mdd = new ModeloDeportista();
		ModeloInscripcion mi= new ModeloInscripcion();
		
		Deportista deportista = new Deportista();
		deportista.setDni(dni);
		deportista = mdd.selectDNI(dni);
		if(deportista.getNombre()!=null) {
			System.out.println("selected");
			int dorsal = mi.getMaxDorsalForEdicion(idEdicion)+1;
			
			Date fecha= new Date();
			Edicion edicion = new Edicion();
			edicion.setId(idEdicion);
			
			
			
			
			
			Inscripcion nuevaInscripcion = new Inscripcion(dorsal, fecha, deportista, edicion);
			mi.crearInscripcion(nuevaInscripcion);
			
			
			
			System.out.println("Creado");
			
			
			response.sendRedirect("PanelDeInicio2?msg=inscrito");
			
			
		}else {
			System.out.println("error");
			response.sendRedirect("PanelDeInicio3msg=errorDeSeleccion");
		}
	}

}
