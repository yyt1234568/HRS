<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>


    <meta charset="UTF-8"/>
    <title>管理员</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="/static/plugins/datatables/dataTables.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/adminlte.min.css">
</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <jsp:include page="/manageraside.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>员工信息</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/manager">主页</a></li>
                            <li class="breadcrumb-item active">员工信息</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-12">


                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">员工详情</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <div class="form-group">
                            <table  class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>部门</th>
                                    <th>职位</th>
                                    <th>姓名</th>
                                    <th>地址</th>
                                    <th>手机</th>
                                    <th>邮箱</th>
                                    <th>性别</th>
                                    <th>生日</th>
                                    <th>自评</th>
                                    <th>薪水</th>
                                    <th colspan="2">操作</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.employees}" var="employee">
                                    <tr>
                                        <td>${employee.id}</td>
                                        <td>${employee.dept.name}</td>
                                        <td>${employee.job.name}</td>
                                        <td>${employee.name}</td>
                                        <td>${employee.address}</td>
                                        <td>${employee.phone}</td>
                                        <td>${employee.email}</td>
                                        <td>${employee.sex==1?"男":"女"}</td>
                                        <td><fmt:formatDate value="${employee.birthday==null?'暂无信息':employee.birthday}" pattern="yyyy-MM-dd" ></fmt:formatDate></td>
                                        <td>${employee.remark==null?"暂无信息":employee.remark}</td>
                                        <td>${employee.salary}</td>
                                        <td><a href="/admin/updateemployee?id=${employee.id}">修改</a></td>
                                        <td><a href="/admin/deleteemployee?id=${employee.id}">删除</a></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>

                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Version</b> 3.0.0-alpha
        </div>
        <strong>Copyright &copy; 2014-2018 <a href="#">AdminLTE.io</a>.</strong> All rights
        reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="/static/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="/static/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/static/plugins/datatables/dataTables.bootstrap4.min.js"></script>
<!-- SlimScroll -->
<script src="/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/static/dist/js/demo.js"></script>





</body>

</html>
