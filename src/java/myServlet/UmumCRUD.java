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
import DAO.UmumDao;
import Bean.Umum;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Farewell
 */
public class UmumCRUD extends HttpServlet {
    
    private static final String Home = "/index.jsp";
    private static final String InsertUmum = "/umum.jsp";
    private static final String EditUmum = "/editUmum.jsp";
    private static final String ListUmum = "/listUmum.jsp";
    private final UmumDao umumDao;
    
    public UmumCRUD (){
        super();
        umumDao = new UmumDao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        String redirectURL="";
        String id_mr = request.getParameter("id_mr");
        System.out.println("ID Umum"+id_mr);
        String act=request.getParameter("action");
        
        if(id_mr != null && act.equalsIgnoreCase("insert")){
            int id = Integer.parseInt(id_mr);
            Umum umum = new Umum();
            umum.setId_mr(id);
            umum.setNama_pasien(request.getParameter("nama_pasien"));
            umum.setTinggi_badan(request.getParameter("tinggi_badan"));
            umum.setBerat_badan(request.getParameter("berat_badan"));
            umum.setTekanan_darah(request.getParameter("tekanan_darah"));
            umum.setPernafasan(request.getParameter("pernafasan"));
            umum.setKeadaan_umum(request.getParameter("keadaan_umum"));
            umum.setStatus_gizi(request.getParameter("status_gizi"));            
            umum.setKesadaran(request.getParameter("kesadaran"));            
            umum.setNadi(request.getParameter("nadi"));
            umum.setAnamnesa(request.getParameter("anamnesa"));
            umumDao.addUmum(umum);
            redirectURL = Home;
            request.setAttribute("umums", umumDao.retrieveUmum());
            System.out.println("Record Added Successfully");
            
        } else if(act.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(id_mr);
            umumDao.deleteUmumById(id);
            redirectURL = ListUmum;
            request.setAttribute("umums", umumDao.retrieveUmum());
            System.out.println("Record Deleted Successfully");

        } else if(act.equalsIgnoreCase("retrieve")){
           redirectURL = ListUmum;
           request.setAttribute("umums", umumDao.retrieveUmum());
        }else if (act.equalsIgnoreCase("editform")){         
                redirectURL = EditUmum;
        } else if(act.equalsIgnoreCase("update")){
            
            System.out.println("Im Here"+id_mr+request.getParameter("nama_pasien"));
            int id = Integer.parseInt(id_mr);
            Umum umum = new Umum();
            umum.setId_mr(id);
            umum.setNama_pasien(request.getParameter("nama_pasien"));
            umum.setTinggi_badan(request.getParameter("tinggi_badan"));
            umum.setBerat_badan(request.getParameter("berat_badan"));
            umum.setTekanan_darah(request.getParameter("tekanan_darah"));
            umum.setPernafasan(request.getParameter("pernafasan"));
            umum.setKeadaan_umum(request.getParameter("keadaan_umum")); 
            umum.setStatus_gizi(request.getParameter("status_gizi"));            
            umum.setKesadaran(request.getParameter("kesadaran"));            
            umum.setNadi(request.getParameter("nadi"));      
            umum.setAnamnesa(request.getParameter("anamnesa"));
            umumDao.editUmum(umum);
            request.setAttribute("umum", umum);
            redirectURL = ListUmum;
            System.out.println("Record updated Successfully");

        } else {
            redirectURL= InsertUmum;
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
            Logger.getLogger(UmumCRUD.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UmumCRUD.class.getName()).log(Level.SEVERE, null, ex);
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