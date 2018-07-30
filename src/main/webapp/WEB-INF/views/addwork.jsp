<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
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
                        <h1>发布招聘信息</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/manager">主页</a></li>
                            <li class="breadcrumb-item active">招聘信息</li>
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
                            <h3 class="card-title">招聘信息</h3>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <form role="form" action="/admin/addrecruit">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="exampleInput">岗位</label>
                                        <input type="text" class="form-control" name="title" id="exampleInput" value="${requestScope.recruit.title}">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInput1">薪水</label>
                                        <input type="text" class="form-control" name="salary" id="exampleInput1" value="${requestScope.recruit.salary}">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInput2" id="exampleInput2">部门</label>
                                        <select name="dept_id" onchange="serviceTypeChange(this.options[this.selectedIndex].value);">
                                            <option value="-1" selected>--请选择--</option>
                                            <c:forEach items="${requestScope.depts}" var="dept">

                                                <option value="${dept.id}">${dept.name}</option>
                                            </c:forEach>
                                        </select>
                                        <label for="job">职位</label>
                                        <select name="job_id" id="job">
                                            <option value="" selected>--请选择--</option>
                                        </select>


                                    </div>


                                    <div class="form-group">
                                        <label for="exampleInput4">需求</label>
                                        <input type="text"  class="form-control" name="demand" id="exampleInput4" value="${requestScope.recruit.demand}">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">数量</label>
                                        <input type="text" class="form-control" name="count" id="exampleInputPassword1" value="${requestScope.recruit.count}">
                                    </div>



                                </div>
                                <!-- /.card-body -->

                                <div class="card-footer">

                                    <button type="submit" class="btn btn-primary">发布职位</button>
                                </div>
                            </form>
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
<script src="/static/laydate/laydate.js"></script> <!-- 改成你的路径 -->
<script>
/*    var myDate = new Date();
    //执行一个laydate实例
    laydate.render({
        elem: '#view_time' //指定元素
        ,type: 'datetime'
    });*/


    laydate.render({//渲染开始时间选择
        elem: '#view_time',//通过id绑定html中插入的start
        type: 'datetime',

    });

function serviceTypeChange(value){
    $("#exampleInput3").empty();
    $.ajax({
        type : "post",
        url : "/admin/getJob?dept_id="+value,
        contentType:"application/json;charset=UTF-8",
        dataType:"json",
        success : function(data) {
            if (data=='') {

                $("#job").append("<option" + ">" +"--请选择--"+ "</option>");
            }else{
                $.each(data, function (i, item) {
                    $("#job").append("<option value=" + item.id + ">" + item.name + "</option>");
                });

            }
        }
    });
}










</script>
<!-- page script -->




</body>

</html>
