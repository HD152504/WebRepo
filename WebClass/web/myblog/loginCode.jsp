<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-11-26
  Time: 오후 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"/>
<script>
    $(document).ready(function () {
        $("#signInForm").submit(function () {
            // submit이 자동으로 되는 기능을 막기
            event.preventDefault();

            // id, pwd를 가져오기
            var id = $("#signInid").val();
            var pwd = $("#signInpwd").val();
            console.log("id : " + id + " pwd : " + pwd);

            // 서버로 post 전송 (ajax)
            $.post("/login.do", { "id" : id , "pwd" : pwd },
                function(data) {

                    if(data.msg == 'success') {
                        console.log(data.name);
                        var loginchkModal = $('#loginchkModal');
                        var signInModal = $('#signInModal');
                        loginchkModal.modal();
                        loginchkModal.find('.modal-body').text(data.name + '님 로그인되었습니다.');
                        signInModal.modal('hide');

                        $("#loginchkModal").on("hidden.bs.modal", function () {
                            // console.log(offset + " : " + ctxPath);
                            // location.href = ctxPath + '/index.jsp';
                            location.href = '${contextPath}/myblog/index.jsp';
                        });

                    } else if (data.msg == 'error') {
                        // <%-- 회원 가입이 실패한 경우 처리 추가 --%>
                        console.log(data.msg);
                        var loginModal = $('#signInModal');
                        var myModal = $('#myModal');
                        myModal.modal();
                        myModal.find('.modal-title').text('Sign In Error');
                        myModal.find('.modal-body').text(data.error);
                        loginModal.modal('hide');
                        $("#myModal").on("hidden.bs.modal", function () {
                            $('#signInpwd').val("");

                            var modal = $("#signInModal");
                            modal.modal();
                        });
                    }

                });          // post방식으로 저 사이트에 post를 보내는데 json형식으로 입력한 값이 들어감

        });
    });
</script>

