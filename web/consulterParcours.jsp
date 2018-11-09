<%-- 
    Document   : consulterParcours
    Created on : 23 juil. 2018, 17:09:32
    Author     : ghost
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- DataTables -->
        <link href="css/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>

        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link href="css/_all-skins.min_1.css" rel="stylesheet" type="text/css"/>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Parcours Combattant</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect.
        -->
        <link href="css/skin-blue.min.css" rel="stylesheet" type="text/css"/>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <!-- Main Header -->
            <header class="main-header">

                <!-- Logo -->
                <a href="index2.html" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>A</b>LT</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Admin</b>LTE</span>
                </a>

                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- Messages: style can be found in dropdown.less-->

                            <!-- /.messages-menu -->

                            <!-- Control Sidebar Toggle Button -->
                            <li>
                                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="image/log.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Ghost CN</p>
                            <!-- Status -->

                        </div>
                    </div>   <br>

                    <!-- search form (Optional) -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Rechercher...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->

                    <!-- Sidebar Menu -->
                   <ul class="sidebar-menu">
                        <li class="header">Formulaires</li>
                        <!-- Optionally, you can add icons to the links
                        <li class="active"><a href="soldat?action=addSoldat"><i class="fa fa-link"></i> <span>Link</span></a></li>
                        <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li> -->
                        <li class="treeview">
                            <a href="#"><i class="fa fa-link"></i> <span>Parcours</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="parcours?action=chargerTableau">Consulter Planing</a></li>
                                <li><a href="parcours?action=note">Attribuer Note</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-link"></i> <span>Obstacle</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                 <li><a href="obstacle?action=LoadObstacle"> Consulter Obstacle</a></li>
                                <li><a href="obstacle?action=addNiveau">Consulter Niveau</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#"><i class="fa fa-link"></i> <span>Soldat</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="soldat?action=consulterSoldat">Consulter Soldat</a></li>
                                <li><a href="#">Link in level 2</a></li>
                            </ul>
                        </li>

                    </ul>
                    <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Parcours du Combattant
                    </h1>

                    <div class="pull-right">
                        <a href="Connection.php" class="btn btn-sm btn-primary">Deconnexion</a>
                        <br><br>
                    </div>

                </section>
                <br><br>

                <!-- Main content -->
                <form action="${pageContext.request.contextPath}/parcours"></form> 
                    <input type="hidden" name="action" value="chargerTableau">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Data Table With Full Features</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Numero Passage</th>
                                    <th>Date</th>
                                    <th>Obstacle</th>
                                    <th>Soldat</th>
                                  
                                    <th>Utilisateur</th>
                                  
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${passList}" var="pass">
                                    <tr>
                                        <td>${pass.numPassage}</td>
                                        <td>${pass.date}</td>
                                        <td>${pass.obstacle.nomObstacle}</td>
                                        <td>${pass.soldat.matricule}</td>
                                      
                                        <td>${pass.user.nom}</td>
                                       
                                    </tr>
                                </c:forEach>

                                </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->

                <!-- /.content-wrapper -->


                <!-- Control Sidebar -->
                <aside class="control-sidebar control-sidebar-dark">
                    <!-- Create the tabs -->
                    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                        <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
                        <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <!-- Home tab content -->
                        <div class="tab-pane active" id="control-sidebar-home-tab">
                            <h3 class="control-sidebar-heading">Recent Activity</h3>
                            <ul class="control-sidebar-menu">
                                <li>
                                    <a href="javascript:;">
                                        <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                                        <div class="menu-info">
                                            <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                            <p>Will be 23 on April 24th</p>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                            <!-- /.control-sidebar-menu -->

                            <h3 class="control-sidebar-heading">Tasks Progress</h3>
                            <ul class="control-sidebar-menu">
                                <li>
                                    <a href="javascript:;">
                                        <h4 class="control-sidebar-subheading">
                                            Custom Template Design
                                            <span class="pull-right-container">
                                                <span class="label label-danger pull-right">70%</span>
                                            </span>
                                        </h4>

                                        <div class="progress progress-xxs">
                                            <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                            <!-- /.control-sidebar-menu -->

                        </div>
                        <!-- /.tab-pane -->
                        <!-- Stats tab content -->
                        <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
                        <!-- /.tab-pane -->
                        <!-- Settings tab content -->
                        <div class="tab-pane" id="control-sidebar-settings-tab">
                            <form method="post">
                                <h3 class="control-sidebar-heading">General Settings</h3>

                                <div class="form-group">
                                    <label class="control-sidebar-subheading">
                                        Report panel usage
                                        <input type="checkbox" class="pull-right" checked>
                                    </label>

                                    <p>
                                        Some information about this general settings option
                                    </p>
                                </div>
                                <!-- /.form-group -->
                            </form>
                        </div>
                        <!-- /.tab-pane -->
                    </div>
                </aside>
                <!-- /.control-sidebar -->
                <!-- Add the sidebar's background. This div must be placed
                     immediately after the control sidebar -->
                <div class="control-sidebar-bg"></div>
            </div>
            <!-- ./wrapper -->

            <!-- REQUIRED JS SCRIPTS -->

            <!-- jQuery 2.2.3 -->

            <script src="Js/jquery-2.2.3.min.js" type="text/javascript"></script>
            <!-- Bootstrap 3.3.6 -->
            <script src="Js/bootstrap.min.js" type="text/javascript"></script>
            <!-- AdminLTE App -->
            <script src="Js/app.min.js" type="text/javascript"></script>


            <!-- DataTables -->
            <script src="Js/dataTables.bootstrap.min.js" type="text/javascript"></script>
            <script src="Js/jquery.dataTables.min.js" type="text/javascript"></script>
            <!-- SlimScroll -->
            <script src="Js/jquery.slimscroll.min.js" type="text/javascript"></script>
            <!-- FastClick -->
            <script src="Js/fastclick.js" type="text/javascript"></script>
            <!-- AdminLTE App -->
            <script src="Js/app.min.js" type="text/javascript"></script>
            <!-- AdminLTE for demo purposes -->
            <script src="Js/demo.js" type="text/javascript"></script>
            <!-- page script -->
            <script>
                $(function () {
                    $("#example1").DataTable();
                    $('#example2').DataTable({
                        "paging": true,
                        "lengthChange": false,
                        "searching": false,
                        "ordering": true,
                        "info": true,
                        "autoWidth": false
                    });
                });
            </script>

            <!-- Optionally, you can add Slimscroll and FastClick plugins.
                 Both of these plugins are recommended to enhance the
                 user experience. Slimscroll is required when using the
                 fixed layout. -->
    </body>
</html>
