package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CuentaCk
 */
@WebServlet("/contador")
public class CuentaCk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String COOKIE_KEY = "cuenta.ck";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaCk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Obtener el valor actual de la cookie "cuenta.ck" buscando entre las cookies recibidas
		String scuenta = null;
		Cookie[] cookies = request.getCookies();
		
		if ( cookies != null ) { // Si no hay cookies...
			for(Cookie cookie : cookies) {
				// Buscar la cookie "cuenta.ck"
				if(cookie.getName().equals(COOKIE_KEY)) {
					scuenta = cookie.getValue();
					break;
				}
			}
		}//FIN if
		
		/** Incrementar el contador para esta página. 
		 * El valor es guardado en la cookie con el nombre COOKIE_KEY = "cuenta.ck"
		 Después, asegurarse de enviársela al cliente con la respuesta (response)
		 */
		Integer objCuenta = null; // [CONTADOR]
		if(scuenta == null) //Si no se encontró "cuenta.ck"
			objCuenta = Integer.valueOf(1);
		else
			objCuenta = Integer.valueOf(scuenta) + 1;
		
		//Crear una nueva Cookie con la cuenta actualizada
		Cookie c = new Cookie(COOKIE_KEY, objCuenta.toString());
		
		//Añadir la cookie a la cabeceras de la respuesta HTTP
		response.addCookie(c);
		
		/**
		 * RESPONDER AL CLIENTE
		 */
		
		out.println("<html>");
		out.println("Has visitado esta página " + objCuenta.toString() + ((objCuenta.intValue() == 1) ? "vez." : "veces."));
		out.println("</html>");
		//Cerrar el flujo
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
