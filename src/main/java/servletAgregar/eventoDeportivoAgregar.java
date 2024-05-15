package servletAgregar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.EventoDeportivo;
import modelo.bean.Organizador;
import modelo.dao.ModeloEventoDeportivo;

/**
 * Servlet implementation class eventoDeportivoAgregar
 */
@WebServlet("/eventoDeportivoAgregar")
public class eventoDeportivoAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventoDeportivoAgregar() {
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
		// TODO Auto-generated method stub
		String nombre = request.getParameter("addNombre");
		String descripcion = request.getParameter("addDescripcion");
		String tipoDeporte = request.getParameter("addTipoDeporte");
		int organizadorId = Integer.parseInt(request.getParameter("addOrganizador"));
		
		Organizador addOrganizador = new Organizador();
		addOrganizador.setId(organizadorId);
		
		ModeloEventoDeportivo mded= new ModeloEventoDeportivo();
		EventoDeportivo eventoDeportivo = new EventoDeportivo(nombre, descripcion, tipoDeporte, addOrganizador);
		
		if (mded.crearEventoDeportivo(eventoDeportivo)) {
			System.out.println("creado");
			response.sendRedirect("EventoDeportivo?msg=agregado");
		}else {
			System.out.println("error");
			response.sendRedirect("EventoDeportivo?msg=error");
		}
		
	}

}
