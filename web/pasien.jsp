<%-- 
    Document   : pasien
    Created on : Feb 8, 2016, 1:45:10 PM
    Author     : Farewell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrasi Pasien</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="assets/styles.css" rel="stylesheet" media="screen">
        <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
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
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> DR A <i class="caret"></i>

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
                        <li class="active">
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
                         <li>
                            <a href="listPasien.jsp"><i class="icon-chevron-right"></i>Daftar Pasien</a>
                        </li>
                    </ul>
                </div>
                <!--/span-->
                <div class="span9" id="content">
                      <!-- morris stacked chart -->
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Registrasi Pasien</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                     <form class="form-horizontal" method="POST" action='PasienCRUD' name="frmAddUser">
                                      <input type="hidden" name="action" value="insert" />
                                         <fieldset>
                                        <legend>Data Pasien</legend>
                                        <div class="control-group">
                                          <label class="control-label">ID Pasien</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" id="focusedInput" type="text" name="id_mr">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label">Nama</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" id="focusedInput" type="text" name="nama_pasien">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="selectError">Jenis Kelamin</label>
                                          <div class="controls">
                                            <select id="selectError" name="jenis_kelamin">
                                              <option value="Pria">Pria</option>
                                              <option value="Wanita">Wanita</option>
                                            </select>
                                          </div>
                                        </div>
					<div class="control-group">
                                          <label class="control-label">TTL</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" id="focusedInput" type="text" name="ttl">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label">Status</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" id="focusedInput" type="text" name="status_perkawinan">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label">Alamat</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" id="focusedInput" type="text" name="alamat_pasien">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label">Telepon</label>
                                          <div class="controls">
                                            <input class="input-xlarge focused" id="focusedInput" type="text" name="telepon">
                                          </div>
                                        </div>
                                        <div class="form-actions">
                                          <button type="submit" class="btn btn-primary">Simpan</button>
                                          <button type="reset" class="btn">Batal</button>
                                        </div>
                                      </fieldset>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                </div>
            </div>
        </div>
        <!--/.fluid-container-->
        <link href="vendors/datepicker.css" rel="stylesheet" media="screen">
        <link href="vendors/uniform.default.css" rel="stylesheet" media="screen">
        <link href="vendors/chosen.min.css" rel="stylesheet" media="screen">
        <script src="vendors/jquery-1.9.1.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="vendors/jquery.uniform.min.js"></script>
        <script src="vendors/chosen.jquery.min.js"></script>
        <script src="vendors/bootstrap-datepicker.js"></script>
		<script src="assets/scripts.js"></script>
        <script>
        $(function(){
            $(".datepicker").datepicker();
            $(".uniform_on").uniform();
            $(".chzn-select").chosen();
        });
        </script>
    </body>
</html>
