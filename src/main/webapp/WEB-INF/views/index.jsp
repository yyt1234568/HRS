<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
<h1 class="header-w3ls">注册页面</h1>
<div class="content-w3ls">
    <div class="form-w3ls">
        <form action="#" method="post">
            <div class="content-wthree1">
                <div class="grid-agileits1">
                    <div class="form-control">
                        <label class="header">姓名 <span>*</span></label>
                        <input type="text" id="name" name="name" placeholder="Name" title="Please enter your Full Name"
                               required="">
                    </div>

                    <div class="form-control">
                        <label class="header">邮箱 <span>*</span></label>
                        <input type="email" id="email" name="email" placeholder="Mail@example.com"
                               title="Please enter a Valid Email Address" required="">
                    </div>
                    <div class="form-control">
                        <label class="header">Phone <span>*</span></label>
                        <input type="text" id="name" name="phone" placeholder="Phone" title="Please enter your Phone No"
                               required="">
                    </div>
                </div>
                <div class="form-control">
                    <div class="main-row">
                        <label class="header">Country <span>*</span></label>
                        <select name="country">
                            <option value="none" selected="" disabled="">Select country</option>

                            <option value="Philippines">Philippines</option>
                            <option value="Portugal">Portugal</option>
                            <option value="South Africa">South Africa</option>
                            <option value="Spain">Spain</option>
                            <option value="Switzerland">Switzerland</option>
                        </select>
                        <i></i>

                    </div>
                </div>
                <div class="form-control">
                    <div class="main-row">
                        <label class="header">What position are you applying for? <span>*</span></label>
                        <select name="country">
                            <option value="none" selected="" disabled="">Job-1</option>

                            <option value="Job-2">Job-2</option>
                            <option value="Job-3">Job-3</option>
                            <option value="Job-4">Job-4</option>
                            <option value="Job-5">Job-5</option>
                            <option value="Job-6">Job-6</option>
                        </select>
                        <i></i>

                    </div>
                </div>
            </div>
            <div class="content-wthree2">
                <div class="grid-w3layouts1">
                    <div class="w3-agile1">
                        <label class="rating">What is your current employment status?<span>*</span></label>
                        <ul>
                            <li>
                                <input type="radio" id="a-option" name="selector1">
                                <label for="a-option">Employed </label>
                                <div class="check"></div>
                            </li>
                            <li>
                                <input type="radio" id="b-option" name="selector1">
                                <label for="b-option">Unemployed</label>
                                <div class="check">
                                    <div class="inside"></div>
                                </div>
                            </li>
                            <li>
                                <input type="radio" id="c-option" name="selector1">
                                <label for="c-option">Self-Employed</label>
                                <div class="check">
                                    <div class="inside"></div>
                                </div>
                            </li>
                            <li>
                                <input type="radio" id="d-option" name="selector1">
                                <label for="d-option">Student</label>
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
                    <label class="rating">Upload your resume</label>
                    <label class="input append-small-btn">
                        <div class="upload-btn">
                            Upload
                            <input type="file" name="file1"
                                   onchange="document.getElementById('file1_input').value = this.value;">
                        </div>
                    </label>
                    <div class="wthreesubmitaits">
                        <input type="submit" name="submit" value="Send">
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
