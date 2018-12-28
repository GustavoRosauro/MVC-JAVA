/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.pdfDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "PDFController", urlPatterns = {"/PDFController"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class PDFController extends HttpServlet {
pdfDAO dao = new pdfDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PDFController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PDFController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String action = request.getParameter("accion");
        InputStream arquivo = null;
        byte[] arquivoByte = null;
                if(action.equalsIgnoreCase("Dowload")){
                    int id = Integer.parseInt(request.getParameter("id"));
            try {
               arquivo =  dao.MostraPDF(id);
               arquivoByte = toByteArrayUsingJava(arquivo);
               

            } catch (Exception ex) {
                Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                response.setContentType("application/pdf");
		response.setContentLength(arquivoByte.length);
		ServletOutputStream ouputStream = response.getOutputStream();
		ouputStream.write(arquivoByte, 0, arquivoByte.length);
		ouputStream.flush();
		ouputStream.close();
    }
public static byte[] toByteArrayUsingJava(InputStream is) throws IOException{ 
    ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
    int reads = is.read(); while(reads != -1){ 
        baos.write(reads); reads = is.read(); 
    } return baos.toByteArray();
}
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) { 
            int id = Integer.parseInt(request.getParameter("txtId"));
            inputStream = filePart.getInputStream();
             try {
                 dao.InserirPDF(id, inputStream);
             } catch (Exception ex) {
                 Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        RequestDispatcher vista = request.getRequestDispatcher("vistas/Listar.jsp");
        vista.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
