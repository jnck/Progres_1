package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.UmumDao;
import java.util.List;
import Bean.Umum;

public final class listUmum_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Daftar Pasien</title>\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("        <link href=\"bootstrap/css/bootstrap-responsive.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("        <link href=\"assets/styles.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("        <link href=\"assets/DT_bootstrap.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("        <script src=\"vendors/modernizr-2.6.2-respond-1.1.0.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("    ");

    UmumDao umumDao = new UmumDao();
    List <Umum> listUmum = umumDao.retrieveUmum();                
    
      out.write("\n");
      out.write("        <div class=\"navbar navbar-fixed-top\">\n");
      out.write("            <div class=\"navbar-inner\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\"> <span class=\"icon-bar\"></span>\n");
      out.write("                     <span class=\"icon-bar\"></span>\n");
      out.write("                     <span class=\"icon-bar\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"brand\" href=\"#\">Admin Panel</a>\n");
      out.write("                    <div class=\"nav-collapse collapse\">\n");
      out.write("                        <ul class=\"nav pull-right\">\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" role=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"> <i class=\"icon-user\"></i>DR A <i class=\"caret\"></i>\n");
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">Profile</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"divider\"></li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"login.html\">Logout</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"nav\">\n");
      out.write("                            <li class=\"active\">\n");
      out.write("                                <a href=\"#\">Dashboard</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-toggle\">Settings <b class=\"caret\"></b>\n");
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\" id=\"menu1\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">Tools <i class=\"icon-arrow-right\"></i>\n");
      out.write("\n");
      out.write("                                        </a>\n");
      out.write("                                        <ul class=\"dropdown-menu sub-menu\">\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"#\">Reports</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"#\">Logs</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"#\">Errors</a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">SEO Settings</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">Other Link</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"divider\"></li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">Other Link</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">Other Link</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" role=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Content <i class=\"caret\"></i>\n");
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">Blog</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">News</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">Custom Pages</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">Calendar</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"divider\"></li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">FAQ</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"#\" role=\"button\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Users <i class=\"caret\"></i>\n");
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">User List</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">Search</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a tabindex=\"-1\" href=\"#\">Permissions</a>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <!--/.nav-collapse -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("                <div class=\"span3\" id=\"sidebar\">\n");
      out.write("                    <ul class=\"nav nav-list bs-docs-sidenav nav-collapse collapse\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"index.jsp\"><i class=\"icon-chevron-right\"></i>Beranda</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"pasien.jsp\"><i class=\"icon-chevron-right\"></i>Registrasi</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"umum.jsp\"><i class=\"icon-chevron-right\"></i>Umum</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"icon-chevron-right\"></i>Poli Penyakit Dalam</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"icon-chevron-right\"></i>Poli Jantung</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"#\"><i class=\"icon-chevron-right\"></i>Poli Gigi</a>\n");
      out.write("                        </li>\n");
      out.write("                         <li class=\"active\">\n");
      out.write("                            <a href=\"listPasien.jsp\"><i class=\"icon-chevron-right\"></i>Daftar Pasien</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <!--/span-->\n");
      out.write("                <div class=\"span9\" id=\"content\">\n");
      out.write("\n");
      out.write("                    <div class=\"row-fluid\">\n");
      out.write("                        <!-- block -->\n");
      out.write("                        <div class=\"block\">\n");
      out.write("                            <div class=\"navbar navbar-inner block-header\">\n");
      out.write("                                <div class=\"muted pull-left\">Hover Table</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"block-content collapse in\">\n");
      out.write("                                <div class=\"span12\">\n");
      out.write("                                    <table class=\"table table-hover\">\n");
      out.write("                                      <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                          <th>ID</th>\n");
      out.write("                                          <th>Nama</th>\n");
      out.write("                                          <th>Tinggi Badan</th>\n");
      out.write("                                          <th>Berat Badan</th>\n");
      out.write("                                          <th>Tekanan Darah</th>\n");
      out.write("                                          <th>Pernafasan</th>\n");
      out.write("                                          <th>Keadaan Umum</th>\n");
      out.write("                                          <th>Status Gizi</th>\n");
      out.write("                                          <th>Kesadaran</th>\n");
      out.write("                                          <th>Nadi</th>\n");
      out.write("                                          <th>Anamnesa</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                      </thead>\n");
      out.write("                                      <tbody>\n");
      out.write("                                          <tr>\n");
      out.write("                                        ");

                                            for (Umum umum : listUmum) {
                                            
      out.write("\n");
      out.write("                                            <td>");
      out.print(umum.getId_mr() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getNama_pasien() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getTinggi_badan() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getBerat_badan() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getTekanan_darah() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getPernafasan() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getKeadaan_umum() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getStatus_gizi() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getKesadaran() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getNadi() );
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(umum.getAnamnesa() );
      out.write("</td>\n");
      out.write("                                          </tr>\n");
      out.write("                                          ");

                                           }
                                          
      out.write("\n");
      out.write("                                      </tbody>\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /block -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--/.fluid-container-->\n");
      out.write("\n");
      out.write("        <script src=\"vendors/jquery-1.9.1.js\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"vendors/datatables/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <script src=\"assets/scripts.js\"></script>\n");
      out.write("        <script src=\"assets/DT_bootstrap.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        $(function() {\n");
      out.write("            \n");
      out.write("        });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
