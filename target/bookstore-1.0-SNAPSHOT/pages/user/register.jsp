<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign up Page</title>

    <%-- base, css, jquery --%>
    <%@include file="/pages/common/head.jsp"%>

    <script type="text/javascript">
        // After page loaded
        $(function () {
            $("#sub_btn").click(function () {
                // Requirements:
                // username: consist of alphabet/number/underline, with length 5 ~ 12
                var usernameText = $("#username").val();
                var usernamePatt = /^\w{5,12}$/
                if (!usernamePatt.test(usernameText)) {
                    $(".errorMsg").text("Invalid Username!");
                    return false;
                }

                // password: consist of alphabet/number/underline, with length 5 ~ 12
                var passwordText = $("#password").val();
                var passwordPatt = /^\w{5,12}$/
                if (!passwordPatt.test(passwordText)) {
                    $(".errorMsg").text("Invalid Password!");
                    return false;
                }

                // confirm password: same as password
                var repwdText = $("#repwd").val();
                if (repwdText != passwordText) {
                    $(".errorMsg").text("Different Password Value!");
                    return false;
                }

                // email: xxxxx@xxx.com
                var emailText = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(emailText)) {
                    $(".errorMsg").text("Invalid Email Address!");
                    return false;
                }

                // verification
                var codeText = $("#code").val();
                codeText = $.trim(codeText);
                if (codeText == null || codeText == "") {
                    $(".errorMsg").text("Invalid Code!");
                    return false;
                }

                $(".errorMsg").text("");

            });

            $("#code_img").click(function () {
                this.src = "${bathPath}Kaptcha.jpg?d=" + new Date();
            });

        });
    </script>
    <style type="text/css">
        .login_form{
            height:420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">New Customer</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>Create New Account</h1>
                    <span class="errorMsg">
<%--                        <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>Username:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input class="itxt" type="text" placeholder="enter your username"
                               autocomplete="off" tabindex="1" name="username" id="username"
                               value="${ requestScope.username }"/>
                        <br />
                        <br />
                        <label>Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input class="itxt" type="password" placeholder="enter password"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br />
                        <br />
                        <label>Repeat Password:</label>
                        <input class="itxt" type="password" placeholder="confirm password"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd" />
                        <br />
                        <br />
                        <label>Email Address:&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input class="itxt" type="text" placeholder="enter your email"
                               autocomplete="off" tabindex="1" name="email" id="email"
                               value="${ requestScope.email }"/>
                        <br />
                        <br />
                        <label>Verification:</label>
                        <input class="itxt" type="text" style="width: 120px;" name="code" id="code"/>
                        <img id="code_img" alt="" src="Kaptcha.jpg" style="float: right; margin-right: 40px; width: 100px; height: 28px">
                        <br />
                        <br />
                        <input type="submit" value="register" id="sub_btn" />

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>