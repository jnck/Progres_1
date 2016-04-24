/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.PasienDao;
import Bean.Pasien;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Farewell
 */
public class PasienCRUD extends HttpServlet {

    private static final String InsertPasien = "/pasien.jsp";
    private static final String EditPasien = "/editPasien.jsp";
    private static final String ListPasien = "/listPasien.jsp";
    
    private final PasienDao pasienDao;
    public PasienCRUD (){
        super();
        pasienDao = new PasienDao();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        String redirectURL="";
        String id_mr = request.getParameter("id_mr");
        System.out.println("ID Pasien"+id_mr);
        String act=request.getParameter("action");
        
        if(id_mr != null && act.equalsIgnoreCase("insert")){
            int id = Integer.parseInt(id_mr);
            Pasien pasien = new Pasien();
            pasien.setId_mr(id);
            pasien.setNama_pasien(request.getParameter("nama_pasien"));
            pasien.setJenis_kelamin(request.getParameter("jenis_kelamin"));
            pasien.setTtl(request.getParameter("ttl"));
            pasien.setStatus_perkawinan(request.getParameter("status_perkawinan"));
            pasien.setAlamat_pasien(request.getParameter("alamat_pasien"));
            pasien.setTelepon(request.getParameter("telepon"));
            
            pasienDao.addPasien(pasien);
            redirectURL = InsertPasien;
            request.setAttribute("pasiens", pasienDao.retrievePasien());
            System.out.println("Record Added Successfully");
            
        } else if(act.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(id_mr);
            pasienDao.deletePasienById(id);
            redirectURL = ListPasien;
            request.setAttribute("pasiens", pasienDao.retrievePasien());
            System.out.println("Record Deleted Successfully");

            
        } else if(act.equalsIgnoreCase("retrieve")){
           redirectURL = ListPasien;
           request.setAttribute("pasiens", pasienDao.retrievePasien());
        }else if (act.equalsIgnoreCase("editform")){         
                redirectURL = EditPasien;
        } else if(act.equalsIgnoreCase("update")){
            
            System.out.println("Im Here"+id_mr+request.getParameter("nama_pasien"));
            int id = Integer.parseInt(id_mr);
            Pasien pasien = new Pasien();
            pasien.setId_mr(id);
            pasien.setNama_pasien(request.getParameter("nama_pasien"));
            pasien.setJenis_kelamin(request.getParameter("jenis_kelamin"));
            pasien.setTtl(request.getParameter("ttl"));
            pasien.setStatus_perkawinan(request.getParameter("status_perkawinan"));
            pasien.setAlamat_pasien(request.getParameter("alamat_pasien"));
            pasien.setTelepon(request.getParameter("telepon"));            
            pasienDao.editPasien(pasien);
            request.setAttribute("pasien", pasien);
            redirectURL = ListPasien;
            System.out.println("Record updated Successfully");

        } else {
            redirectURL= InsertPasien;
        }
        
        
        RequestDispatcher rd = request.getRequestDispatcher(redirectURL);
        rd.forward(request, response);

        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PasienCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PasienCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
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