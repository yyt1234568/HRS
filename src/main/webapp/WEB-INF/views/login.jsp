<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <meta charset="UTF-8"/>
    <title>登陆</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3"/>
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class"/>
    <meta name="author" content="Codrops"/>
    <link rel="shortcut icon" href="/static/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="/static/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/style3.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/animate-custom.css"/>
    <script src="/static/js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="/static/js/fm.validator.js" type="text/javascript"></script>
    <script>
        $(function () {
            Validator.language = 'en';
        });
    </script>
</head>
<body>
<div class="container">

    <section>
        <div id="container_demo">
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form action="/user/login" autocomplete="on" method="post">
                        <h1>Log in</h1>
                        <p>
                            <label for="username" class="uname" data-icon="u"> 用户名 </label>
                            <input id="username" name="username" required="required" type="text"
                                   placeholder="输入你的用户名"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> 密码 </label>
                            <input id="password" name="password" required="required" type="password"
                                   placeholder="eg. X8df!90EO"/>
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping"/>
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <p class="login button">
                            <input type="submit" value="Login"/>
                        </p>
                        <p class="change_link">
                            还未注册
                            <a href="#toregister" class="to_register">加入我们</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form" >
                    <form action="/user/regist" autocomplete="on" class="validator" method="post">
                        <h1> Sign up </h1>
                        <p>
                            <label for="usernamesignup" class="uname" data-icon="u">用户名</label>
                            <input id="usernamesignup" name="username" required="required" type="text"
                                   placeholder="mysuperusername690"/>
                        </p>
                        <%--<p>
                            <label for="emailsignup" class="youmail" data-icon="e"> 邮箱</label>
                            <input id="emailsignup" name="emailsignup" required="required" type="email"
                                   placeholder="mysupermail@mail.com"/>
                        </p>--%>
                        <p>
                            <label for="passwordsignup" class="youpasswd" data-icon="p">请输入密码 </label>
                            <input id="passwordsignup" name="password" required="required" type="password"
                                   placeholder="eg. X8df!90EO" data-match="passwordsignup_confirm" data-required/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">请再次输入密码 </label>
                            <input id="passwordsignup_confirm" name="password
                            _confirm" required="required"
                                   type="password" placeholder="eg. X8df!90EO"/>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="Sign up"/>
                        </p>
                        <p class="change_link">
                            注册完毕
                            <a href="#tologin" class="to_register"> 登录 </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>
</body>
</html>
