<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>SignUp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="/css/signin.css">
</head>
<body>
<div class="container">

  <%

//    String id = (request.getParameter("id") == null) ? "" : request.getParameter("id");
//    String pwd = (request.getParameter("pwd") == null) ? "" : request.getParameter("pwd");
//    String name = (request.getParameter("name") == null) ? "" : request.getParameter("name");
//    String nickname = (request.getParameter("nickname") == null) ? "" : request.getParameter("nickname");

  %>

  <form id="signupForm" class="form-signin" action="" method="post">
    <h2 class="form-signin-heading">Please sign up</h2>
    
    <label for="inputEmail" class="sr-only">Email address</label>
    <%--<input type="email" name="id" value="<%=id%>" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>--%>
    <input type="email" name="id" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>

    <label for="inputPassword" class="sr-only">Password</label>
    <%--<input type="password" name="pwd" value="<%=pwd%>" id="inputPassword" class="form-control" placeholder="Password" required>--%>
    <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required>

	<label for="inputName" class="sr-only">Name</label>
    <%--<input type="text" name="name" value="<%=name%>" id="inputName" class="form-control" placeholder="Name" required>--%>
    <input type="text" name="name" id="inputName" class="form-control" placeholder="Name" required>

	<label for="inputNickName" class="sr-only">Nick Name</label>
    <%--<input type="text" name="nickname" value="<%=nickname%>" id="inputNickName" class="form-control" placeholder="Nickname" required>--%>
    <input type="text" name="nickname" id="inputNickName" class="form-control" placeholder="Nickname" required>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
  </form>
</div>

<%@ include file="modal.jsp" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $("#signupForm").submit(function () {
            // submit이 자동으로 되는 기능을 막기
            event.preventDefault();

            // id, pwd를 가져오기
            var id = $("#inputEmail").val();
            var pwd = $("#inputPassword").val();
            var name = $("#inputName").val();
            var nickname = $("#inputNickName").val();
            console.log("id : " + id + "\npwd : " + pwd + "\nname : " + name + "\nnickname : " + nickname);

            // 서버로 post 전송 (ajax)
            $.post("/SignUpServlet", { "id" : id, "pwd" : pwd , "nickname" : nickname, "name" : name},
                function(data) {
                    console.log(data);
                    if(data.msg == 'success') {
                        location.href = "jsp/login.jsp"
                    } else if (data.msg == 'error') {
                        <%-- 회원 가입이 실패한 경우 처리 추가 --%>
                        var myModal = $('#myModal');
                        myModal.find('.modal-title').text('Sign Up Error');
                        myModal.find('.modal-body').text('회원 가입 시 오류가 발생하였습니다.');
                        myModal.modal();
                    }
//                    var myModal = $('#myModal');
//                    myModal.modal();
//                    myModal.find('.modal-body').text(data.id + '님 로그인되었습니다.');

                });          // post방식으로 저 사이트에 post를 보내는데 json형식으로 입력한 값이 들어감

        });
    });
</script>

</body>
</html>