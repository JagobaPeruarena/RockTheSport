package servletEditar;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Ciudad;
import modelo.bean.Edicion;
import modelo.bean.EventoDeportivo;
import modelo.dao.ModeloEdicion;

/**
 * Servlet implementation class edicionEditar
 */
@WebServlet("/edicionEditar")
public class edicionEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edicionEditar() {
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
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd");
		int id = Integer.parseInt(request.getParameter("editId"));
		int cuposDisponibles = Integer.parseInt(request.getParameter("editCuposDisponibles"));
		Date fecha = new Date();
		try {
			 fecha = smp.parse(request.getParameter("editFecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		int idCiudad = Integer.parseInt(request.getParameter("editCiudad"));
		int idEventoDeportivo = Integer.parseInt(request.getParameter("editEventoDeportivo"));
		Ciudad ciudad = new Ciudad();
		ciudad.setId(idCiudad);
		EventoDeportivo eventoDeportivo = new EventoDeportivo();
		eventoDeportivo.setId(idEventoDeportivo);
		
		Edicion edicion = new Edicion(id,fecha, cuposDisponibles, eventoDeportivo, ciudad);
		ModeloEdicion mde = new ModeloEdicion();
		
		if (mde.actualizarEdicion(edicion)) {
			System.out.println("editado");
			response.sendRedirect("edicion?msg=editado");
		}else {
			System.out.println("error");
			response.sendRedirect("edicion?msg=error");
		}
		
	}

}
