package servletEditar;

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
 * Servlet implementation class eventoDeportivoEditar
 */
@WebServlet("/eventoDeportivoEditar")
public class eventoDeportivoEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventoDeportivoEditar() {
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
				int id = Integer.parseInt(request.getParameter("editId"));
				String nombre = request.getParameter("editNombre");
				String descripcion = request.getParameter("editDescripcion");
				String tipoDeporte = request.getParameter("editTipoDeporte");
				int organizadorId = Integer.parseInt(request.getParameter("editOrganizador"));
				
				Organizador addOrganizador = new Organizador();
				addOrganizador.setId(organizadorId);
				
				ModeloEventoDeportivo mded= new ModeloEventoDeportivo();
				EventoDeportivo eventoDeportivo = new EventoDeportivo(id,nombre, descripcion, tipoDeporte, addOrganizador);
				
				if (mded.actualizarEventoDeportivo(eventoDeportivo)) {
					System.out.println("creado");
				}else {
					System.out.println("error");
				}
				response.sendRedirect("EventoDeportivo");
			}
	

}
