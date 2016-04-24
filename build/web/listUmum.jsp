<%-- 
    Document   : listPasien
    Created on : Feb 8, 2016, 2:59:52 PM
    Author     : Farewell
--%>
<%@page import="DAO.UmumDao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Bean.Umum"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Daftar Pasien</title>
        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="assets/styles.css" rel="stylesheet" media="screen">
        <link href="assets/DT_bootstrap.css" rel="stylesheet" media="screen">
        <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    
    <body>
    <%
    UmumDao umumDao = new UmumDao();
    List <Umum> listUmum = umumDao.retrieveUmum();                
    %>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Admin Panel</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i>DR A <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">Profile</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="login.html">Logout</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav">
                            <li class="active">
                                <a href="#">Dashboard</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle">Settings <b class="caret"></b>

                                </a>
                                <ul class="dropdown-menu" id="menu1">
                                    <li>
                                        <a href="#">Tools <i class="icon-arrow-right"></i>

                                        </a>
                                        <ul class="dropdown-menu sub-menu">
                                            <li>
                                                <a href="#">Reports</a>
                                            </li>
                                            <li>
                                                <a href="#">Logs</a>
                                            </li>
                                            <li>
                                                <a href="#">Errors</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">SEO Settings</a>
                                    </li>
                                    <li>
                                        <a href="#">Other Link</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="#">Other Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Other Link</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Content <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">Blog</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">News</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Custom Pages</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Calendar</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="#">FAQ</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Users <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="#">User List</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Search</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="#">Permissions</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        <li>
                            <a href="index.jsp"><i class="icon-chevron-right"></i>Beranda</a>
                        </li>
                        <li>
                            <a href="pasien.jsp"><i class="icon-chevron-right"></i>Registrasi</a>
                        </li>
                        <li>
                            <a href="umum.jsp"><i class="icon-chevron-right"></i>Umum</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i>Poli Penyakit Dalam</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i>Poli Jantung</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon-chevron-right"></i>Poli Gigi</a>
                        </li>
                         <li class="active">
                            <a href="listPasien.jsp"><i class="icon-chevron-right"></i>Daftar Pasien</a>
                        </li>
                    </ul>
                </div>
                <!--/span-->
                <div class="span9" id="content">

                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Hover Table</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    <table class="table table-hover">
                                      <thead>
                                        <tr>
                                          <th>ID</th>
                                          <th>Nama</th>
                                          <th>Tinggi Badan</th>
                                          <th>Berat Badan</th>
                                          <th>Tekanan Darah</th>
                                          <th>Pernafasan</th>
                                          <th>Keadaan Umum</th>
                                          <th>Status Gizi</th>
                                          <th>Kesadaran</th>
                                          <th>Nadi</th>
                                          <th>Anamnesa</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                          <tr>
                                        <%
                                            for (Umum umum : listUmum) {
                                            %>
                                            <td><%=umum.getId_mr() %></td>
                                            <td><%=umum.getNama_pasien() %></td>
                                            <td><%=umum.getTinggi_badan() %></td>
                                            <td><%=umum.getBerat_badan() %></td>
                                            <td><%=umum.getTekanan_darah() %></td>
                                            <td><%=umum.getPernafasan() %></td>
                                            <td><%=umum.getKeadaan_umum() %></td>
                                            <td><%=umum.getStatus_gizi() %></td>
                                            <td><%=umum.getKesadaran() %></td>
                                            <td><%=umum.getNadi() %></td>
                                            <td><%=umum.getAnamnesa() %></td>
                                          </tr>
                                          <%
                                           }
                                          %>
                                      </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                </div>
            </div>
        </div>
        <!--/.fluid-container-->

        <script src="vendors/jquery-1.9.1.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="vendors/datatables/js/jquery.dataTables.min.js"></script>
        <script src="assets/scripts.js"></script>
        <script src="assets/DT_bootstrap.js"></script>
        <script>
        $(function() {
            
        });
        </script>
    </body>

</html>