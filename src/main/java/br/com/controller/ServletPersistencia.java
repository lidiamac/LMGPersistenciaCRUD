package br.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.UserDAO;
import br.com.model.User;

/**
 * Servlet implementation class ServletProjetoFinal
 */
@WebServlet("/ServletPersistencia")
public class ServletPersistencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static UserDAO userdao = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersistencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcao = request.getParameter("opcao");
		String id = request.getParameter("id");
		
		if(id != null){
			if(opcao.equals("0")) {
				//id = ;
				userdao.removerUsuario(Integer.parseInt(id));
			} else if (opcao.equals("1")) {
				User user = userdao.buscarUsuario(Integer.parseInt(id));
				request.setAttribute("nome", user.getNome());
				request.setAttribute("email", user.getEmail());
				request.setAttribute("pais", user.getPais());
				
				request.getRequestDispatcher("/adicionar.jsp").forward(request, response);
			}
			request.setAttribute("usuario", userdao.mostrarUsuarios());
		}
		
		request.getRequestDispatcher("/").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if((request.getParameter("nome") != null) && (request.getParameter("email") != null) && (request.getParameter("pais") != null)){
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String pais = request.getParameter("pais");
			User user = new User(nome, email, pais);

			if(id != null && !id.isEmpty()) {
				userdao.alterarUsuario(user);
			} else {
				userdao.adicionarUsuario(user);
			}
			
			request.setAttribute("usuario", userdao.mostrarUsuarios());
		}
		request.getRequestDispatcher("/").forward(request, response);
	}

}