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

import br.ucb.modelo.*;
import br.ucb.modelo.dao.CrecheDAO;



@WebServlet("/crecheCRUD")
public class crecheCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao"), destino=null;
		String acao2= request.getParameter("acao2");
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession(true);
		
		Creche creche;
		
		long id;
		try {
		CrecheDAO crecheDAO = new CrecheDAO(); // <---
	
		if(acao.equals("cadastrar")) {	//cadastro creche
			creche = new Creche();
			
			creche.setCnpj(request.getParameter("cnpj"));
			creche.setNomeCreche(request.getParameter("nomeCreche"));
			creche.setNomeResponsavel(request.getParameter("nomeResponsavel"));
			creche.setEmail(request.getParameter("email"));
			creche.setTelefone(request.getParameter("telefone"));
			creche.setEndereco(request.getParameter("endereco"));
			creche.setNecessidadePrincipal(request.getParameter("necessidadePrincipal"));
			creche.setSenha(request.getParameter("senha"));
			
			if (crecheDAO.cadastrarCreche(creche) == 0) {
				request.setAttribute("erro", "Erro no cadastro. Tente novamente!");
				destino="cadastroInstituicao.jsp";
			}
				else {
					request.setAttribute("mensagem", "Cadastro concluído com sucesso!");
					destino="index.jsp";
			}
		
		}
		
		else if(acao.equals("consultar")) {
			creche = new Creche();
			id = Long.parseLong(request.getParameter("id"));
			creche =  crecheDAO.consultar(id);
			request.setAttribute("creche", creche);
			destino = "cadastrarDoacao.jsp";
			
			if(acao2.equals("consultar2"))
				destino = "perfilCreche_doador.jsp";
		}
		else if(acao.equals("editar")) {//editar
		creche = new Creche();
		
		creche.setCnpj(request.getParameter("cnpj"));
		creche.setNomeCreche(request.getParameter("nomeCreche"));
		creche.setNomeResponsavel(request.getParameter("nomeResponsavel"));
		creche.setEmail(request.getParameter("email"));
		creche.setTelefone(request.getParameter("telefone"));
		creche.setEndereco(request.getParameter("endereco"));
		creche.setNecessidadePrincipal(request.getParameter("necessidadePrincipal"));
		creche.setSenha(request.getParameter("senha"));
		id = Long.parseLong(request.getParameter("id"));
		
		creche.setId(id);
		
				if(crecheDAO.editar(creche)== 0) {
					request.setAttribute("erro", "Erro na alteração. Não alterado!");
					destino="editarCreche.jsp";
				}else{
					request.setAttribute("sucesso", "Alterado com sucesso!");	
					destino="perfilCreche.jsp";
				}
		
		
		}else if(acao.equals("loginCreche"))  {
			creche = new Creche();
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			creche = crecheDAO.logarCreche(email, senha);
		
			if (creche == null) {
				request.setAttribute("erro", "Usuário/Senha inválido. Tente novamente!");
				destino="loginDoador.jsp";
			}else {
				session.setAttribute("creche", creche); //session
				destino="perfilCreche.jsp";
			}
		
		}else if(acao.equals("excluir")) {
			id = Long.parseLong(request.getParameter("id"));
			if(crecheDAO.excluir(id)==0){
				request.setAttribute("erro","Erro na exclusão, não foi possível excluír!");
				destino = "perfilCreche.jsp";
			}else
				request.setAttribute("sucesso","Excluído com sucesso!");
				destino = "index.jsp";
				
		}
		
		
		} catch (SQLException e) {
			request.setAttribute("erro", "Erro de banco de dados");
			destino = "index.jsp"; 
		} 
		dispatcher = request.getRequestDispatcher(destino);
		dispatcher.forward(request, response);
		
	}

}
