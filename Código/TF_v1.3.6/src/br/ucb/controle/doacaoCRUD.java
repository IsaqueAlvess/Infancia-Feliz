package br.ucb.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.modelo.Creche;
import br.ucb.modelo.Doacao;
import br.ucb.modelo.Doador;
import br.ucb.modelo.dao.CrecheDAO;
import br.ucb.modelo.dao.DoacaoDAO;
import br.ucb.modelo.dao.DoadorDAO;


@WebServlet("/doacaoCRUD")
public class doacaoCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao"), destino=null;
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession(true);
		Doacao doacao;
		List<Creche> creches;
		List<Doacao> doacoes;
		Doador doador;
		Creche creche;
		
		long id;
		
		try {
		DoacaoDAO doacaoDAO = new DoacaoDAO();
		DoadorDAO doadorDAO = new DoadorDAO();
		CrecheDAO crecheDAO = new CrecheDAO();
		
		if(acao.equals("comparacao")) {
		doacao = new Doacao();
		
		doacao.setTipoDoacao(request.getParameter("tipoDoacao"));
			
		creches = doacaoDAO.listar(doacao);
		session.setAttribute("creches",creches);
		destino="comparaCreche.jsp";	
		
		
		}else if(acao.equals("cadastrar")) {
			
		doacao = new Doacao();
		doador = new Doador();
		creche = new Creche();
		
		
		doacao.setTipoDoacao(request.getParameter("tipoDoacao"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		doacao.setDataDoacao(sdf.parse(request.getParameter("data_agendamento")));
		
		doacao.setCreche(crecheDAO.consultar(Long.parseLong(request.getParameter("id_Creche"))));
		doacao.setDoador(doadorDAO.consultar(Long.parseLong(request.getParameter("id_Doador"))));
			
			if(doacaoDAO.cadastrar(doacao)==0) {
				request.setAttribute("erro","Erro no cadastro. Não cadastrado!");
				destino="comparaCreche.jsp";
				System.out.println("Erro Crud");
			}else{
				request.setAttribute("sucesso","Doação cadastrada com sucesso!");
				destino="perfilDoador.jsp";  
				System.out.println("Sucesso Crud");
			}	
		}else if(acao.equals("listarDoacoes_Doador")) {
			
			id=Long.parseLong(request.getParameter("id"));
			
			doacoes = doacaoDAO.listar(id);
			
			if(doacoes==null) {
				request.setAttribute("erro","Não há doações agendadas!");
				destino="perfilDoador.jsp";
			}else {
				request.setAttribute("doacoes",doacoes);
				destino="doacoesAgendadas_doador.jsp";
			}
		
		}else if(acao.equals("listarDoacoesFeitas_Doador")) {
			id=Long.parseLong(request.getParameter("id"));
			
			doacoes = doacaoDAO.listarDoacoesFeitas_Doador(id);
			
			if(doacoes==null) {
				request.setAttribute("erro","Não há doações agendadas!");
				destino="perfilDoador.jsp";
			}else {
				request.setAttribute("doacoes",doacoes);
				destino="doacoesFeitas.jsp";
			}	
			
		}else if(acao.equals("excluir")) {
			id = Long.parseLong(request.getParameter("id"));
			
			if(doacaoDAO.excluir(id)==0) {
				request.setAttribute("erro","Erro na exclusão.Não excluído!");
				destino="doacoesAgendadas_doador.jsp";			
			}
			else {
				request.setAttribute("sucesso", "Excluído com sucesso!");			
				destino="perfilDoador.jsp";
			}
			
		}else if(acao.equals("listarDoacoes_Creche")) { 	//Doações Creche
			
			id=Long.parseLong(request.getParameter("id"));
			
			doacoes = doacaoDAO.listarDoacoesAgendadas_Creche(id); //edit
			
			if(doacoes==null) {
				request.setAttribute("erro","Não há doações agendadas!");
				destino="perfilCreche.jsp";
			}else {
				request.setAttribute("doacoes",doacoes);
				destino="doacoesAgendadas_creche.jsp";
			}
		
		}else if(acao.equals("listarDoacoesRecebidas")) {
			id=Long.parseLong(request.getParameter("id"));
			
			doacoes = doacaoDAO.listarDoacoesRecebidas(id);	//edit
			
			if(doacoes==null) {
				request.setAttribute("erro","Não há doações agendadas!");
				destino="perfilCreche.jsp";
			}else {
				request.setAttribute("doacoes",doacoes);
				destino="doacoesRecebidas.jsp";
			}	
			
		}
		
			
		}catch (SQLException e) {
			request.setAttribute("erro", "Erro de banco de dados");
			destino = "index.jsp"; 
		} catch (ParseException e) {
			request.setAttribute("erro", "Erro de conversão da data");
			destino = "perfilCreche_doador.jsp";
		} catch (NullPointerException e) {
			request.setAttribute("erro", "Erro!");
			destino = "doacoesAgendadas_doador.jsp";
		} 
		
		dispatcher = request.getRequestDispatcher(destino);
		dispatcher.forward(request, response);
	}

}
