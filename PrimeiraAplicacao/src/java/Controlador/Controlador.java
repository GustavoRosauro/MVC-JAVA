/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.PessoasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
String listar = "vistas/Listar.jsp";
String Adicionar = "vistas/Add.jsp";
String Editar = "vistas/Atualizar.jsp";
PessoasDAO dao = new PessoasDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String acesso="";
       String action = request.getParameter("accion");
       if(action.equalsIgnoreCase("listar")){
       acesso = listar;
       }
       else if(action.equalsIgnoreCase("add")){
           acesso = Adicionar;
       }
       else if(action.equalsIgnoreCase("Adicionar")){
         String nome = request.getParameter("txtNome");
         dao.InserirPessoa(nome);
         acesso=listar;
       }
       else if(action.equalsIgnoreCase("remover")){
        int id = Integer.parseInt(request.getParameter("id"));
        dao.DeletarPessoa(id);
        acesso = listar;
       }
       else if(action.equalsIgnoreCase("atualiza")){
        request.setAttribute("id",request.getParameter("id"));   
        acesso = Editar;
       }
       else if(action.equalsIgnoreCase("editar")){
          int id = Integer.parseInt(request.getParameter("txtId"));
          String Nome = request.getParameter("txtNome");
          dao.AtualizaPessoa(id, Nome);
          acesso = listar;
       }
       RequestDispatcher vista = request.getRequestDispatcher(acesso);
       vista.forward(request, response);
    }
}
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
