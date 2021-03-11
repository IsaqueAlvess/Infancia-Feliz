package br.ucb.controle;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.modelo.Doacao;
import br.ucb.modelo.Doador;
import br.ucb.modelo.dao.DoacaoDAO;
import br.ucb.modelo.dao.DoadorDAO;

@WebServlet("/doadorCRUD")
public class doadorCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao"), destino=null;
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession(true);
		
		Doador doador;
		Doacao doacao;
		
		long id;
		try {
		DoadorDAO doadorDAO = new DoadorDAO(); // <---
		DoacaoDAO doacaoDAO = new DoacaoDAO();
		
		if(acao.equals("cadastrar")){	//cadastrar
		doador = new Doador();
		doador.setNome(request.getParameter("nomeDoador"));
		doador.setTelefone(request.getParameter("telefoneDoador"));
		doador.setEmail(request.getParameter("email"));
		doador.setSenha(request.getParameter("senha"));
			if (doadorDAO.cadastrar(doador) == 0) {
				request.setAttribute("erro", "Erro no cadastro. Tente novamente!");
				destino="cadastroDoador.jsp";
			}else {
				request.setAttribute("mensagem", "Cadastro concluído com sucesso!");
				destino="index.jsp";
			}			

		}else if(acao.equals("editar")){ //editar 
		doador = new Doador();
		doador.setNome(request.getParameter("nomeDoador"));
		doador.setTelefone(request.getParameter("telefoneDoador"));
		doador.setEmail(request.getParameter("email"));
		doador.setSenha(request.getParameter("senha"));
		id = Long.parseLong(request.getParameter("id"));
		
		doador.setId(id);
			
				if(doadorDAO.editar(doador)==0) {
					request.setAttribute("erro", "Erro na alteração. Não alterado!");
					destino="editarDoador.jsp";
				}else{
					request.setAttribute("sucesso", "Alterado com sucesso!");	
					destino="perfilDoador.jsp";
				}
		
			
		}else if(acao.equals("loginDoador")) {
			doador = new Doador();
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			doador = doadorDAO.logarDoador(email, senha);
		
			if (doador == null) {
				request.setAttribute("erro", "Usuário/Senha inválido. Tente novamente!");
				destino="loginDoador.jsp";
			}else {
				session.setAttribute("doador", doador); //session
				destino="perfilDoador.jsp";
			}
		
		}else if(acao.equals("excluir")) {
			id = Long.parseLong(request.getParameter("id"));
			if(doadorDAO.excluir(id)==0) {
				request.setAttribute("erro","Erro na exclusão, não foi possível excluír!");
				destino = "perfilDoador.jsp";
			}else
				request.setAttribute("sucesso","Excluído com sucesso!");
				destino = "index.jsp";
		
		}		
		
		}catch (SQLException e) {
			request.setAttribute("erro", "Erro de banco de dados");
			destino = "index.jsp"; 
		} 
		dispatcher = request.getRequestDispatcher(destino);
		dispatcher.forward(request, response);
	}
}
