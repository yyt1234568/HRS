<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简历</title>
    <link href="/static/css/style.css" rel='stylesheet' type='text/css' media="all"/>
    <link rel="stylesheet" href="/static/css/j-forms.css">

    <!-- /css files -->
    <script type="text/javascript" src="/static/js/jquery-2.1.4.min.js"></script>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>


</head>
<body>
<h1 class="header-w3ls">简历页面</h1>
<div class="content-w3ls">
    <div class="form-w3ls">
        <form action="/user/add" method="post">
            <div class="content-wthree1">
                <div class="grid-agileits1">
                    <div class="form-control">
                        <label class="header">姓名 <span>*</span></label>
                        <input type="text" id="name" name="name" placeholder="Name" title="Please enter your Full Name"
                               required="" value="${resume.name}">
                    </div>

                    <div class="form-control">
                        <label class="header">邮箱 <span>*</span></label>
                        <input type="email" id="email" name="email" placeholder="Mail@example.com"
                               title="Please enter a Valid Email Address" required="" value="${resume.email}">
                    </div>
                    <div class="form-control">
                        <label class="header">手机 <span>*</span></label>
                        <input type="text" id="name" name="phone" placeholder="Phone" title="Please enter your Phone No"
                               required="" value="${resume.phone}">
                    </div>
                </div>
                <div class="form-control">
                    <div class="main-row">
                        <label class="header">性别 <span>*</span></label>
                        <select name="sex">
                            
                            <c:if test="${resume.sex eq '男'}">
                                <option value="男" selected>男</option>
                            </c:if>
                            <c:if test="${resume.sex ne '男'}">
                                <option value="男">男</option>
                            </c:if>
                            <c:if test="${resume.sex eq '女'}">
                                <option value="女" selected>女</option>
                            </c:if>
                            <c:if test="${resume.sex ne '女'}">
                                <option value="女">女</option>
                            </c:if>


                        </select>
                        <i></i>

                    </div>
                </div>
                <div class="form-control">
                    <div class="main-row">
                        <label class="header">选择职位 <span>*</span></label>
                        <select name="job_id" value="${resume.job_id}">
                            <c:forEach items="${sessionScope.jobs}" var="job">
                                <c:if test="${resume.job_id==job.id}">
                                    <option value="${job.id}" selected >${job.name}</option>
                                </c:if>
                                <c:if test="${resume.job_id!=job.id}">
                                    <option value="${job.id}">${job.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        <i></i>

                    </div>
                </div>
            </div>
            <div class="content-wthree2">
                <div class="grid-w3layouts1">
                    <div class="w3-agile1">
                        <label class="rating">您当前职业为?<span>*</span></label>
                        <ul>
                            <li>
                                <c:if test="${resume.current_job eq '工作中'}">
                                    <input type="radio" id="a-option" name="current_job" value="工作中" checked>
                                </c:if>
                                <c:if test="${resume.current_job ne '工作中'}">
                                    <input type="radio" id="a-option" name="current_job" value="工作中" >
                                </c:if>

                                <label for="a-option">工作中 </label>
                                <div class="check"></div>
                            </li>
                            <li>
                                <c:if test="${resume.current_job eq '尚未工作'}">
                                    <input type="radio" id="b-option" name="current_job" value="尚未工作" checked>
                                </c:if>
                                <c:if test="${resume.current_job ne '尚未工作'}">
                                    <input type="radio" id="b-option" name="current_job" value="尚未工作">
                                </c:if>

                                <label for="b-option">尚未工作</label>
                                <div class="check">
                                    <div class="inside"></div>
                                </div>
                            </li>
                            <li>
                                <c:if test="${resume.current_job eq '自由'}">
                                    <input type="radio" id="b-option" name="current_job" value="自由"checked>
                                </c:if>
                                <c:if test="${resume.current_job ne '自由'}">
                                    <input type="radio" id="c-option" name="current_job" value="自由">
                                </c:if>
                                <label for="c-option">自由</label>
                                <div class="check">
                                    <div class="inside"></div>
                                </div>
                            </li>
                            <li>
                                <c:if test="${resume.current_job eq '学生'}">
                                    <input type="radio" id="d-option" name="current_job" value="学生"checked>
                                </c:if>
                                <c:if test="${resume.current_job ne '学生'}">
                                    <input type="radio" id="d-option" name="current_job" value="学生">
                                </c:if>
                                <label for="d-option">学生</label>
                                <div class="check"></div>
                            </li>
                            <div class="clear"></div>
                        </ul>
                    </div>

                </div>

                <div class="clear"></div>
            </div>

            <div class="w3ls-btn">
                <div class="contact-forms">
                    <label class="rating">上传你的简历</label>
                    <label class="input append-small-btn">
                        <div class="upload-btn">
                            上传
                            <input type="file" name="resumepage"
                                   onchange="document.getElementById('file1_input').value = this.value;"
                            value="${resume.resumepage}">
                        </div>
                    </label>
                    <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                    <div class="wthreesubmitaits">
                        <input type="submit" name="submit" value="提交">
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>
</div>

</div>


</body>
</html>
