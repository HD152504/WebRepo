
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));

function mouseOn(e) {
    e.setAttribute("class", "nav-link active");
}

function mouseOut(e) {
    e.setAttribute("class", "nav-link");
}


$(document).ready(function () {
    $("#signUpForm").submit(function (event) {
        // submit이 자동으로 되는 기능을 막기
        event.preventDefault();

        // id, pwd를 가져오기
        var name = $('#signUpname').val();
        var id = $('#signUpid').val();
        var pwd = $('#signUppwd').val();
        var pwdchk = $('#signUppwdchk').val();

        if (pwd != pwdchk) {
            var Modal = $('#myModal');
            var signUpModal = $('#signUpModal');
            Modal.modal();
            Modal.find('.modal-body').text("비밀번호가 다릅니다!");
            signUpModal.modal('hide');

            $("#myModal").on("hidden.bs.modal", function () {
                $('#signUpid').val("");
                $('#signUppwd').val("");
                $('#signUppwdchk').val("");
                $('#signUpname').val("");

                signUpModal.modal();
                return;
            });


        }

        console.log("id : " + id + "\npwd : " + pwd + "\nname : " + name);

        // 서버로 post 전송 (ajax)
        $.post("/signup.do", { "id" : id, "pwd" : pwd, "name" : name},
            function(data) {
                var signUpchkModal = $('#signUpchkModal');
                var signUpModal = $('#signUpModal');
                var myModal = $('#myModal');

                if (data.msg == "success") {
                    signUpchkModal.modal();
                    signUpchkModal.find('.modal-body').text(data.name + '님 회원가입되었습니다.');
                    signUpModal.modal('hide');

                    $("#signupchkmodal").on("hidden.bs.modal", function () {
                        $('#signUpid').val("");
                        $('#signUppwd').val("");
                        $('#signUppwdchk').val("");
                        $('#signUpname').val("");

                        var modal = $("#signinmodal");
                        modal.modal();
                    });

                } else if (data.msg == "error") {

                    myModal.modal();
                    myModal.find('.modal-title').text('Sign Up Error');
                    myModal.find('.modal-body').text(data.msg);
                    loginModal.modal('hide');
                    $("#myModal").on("hidden.bs.modal", function () {
                        $('#signUpid').val("");
                        $('#signUppwd').val("");
                        $('#signUppwdchk').val("");
                        $('#signUpname').val("");

                        var modal = $("#signUpModal");
                        modal.modal();
                    });
                }

            });          // post방식으로 저 사이트에 post를 보내는데 json형식으로 입력한 값이 들어감

    });
});

function click() {
    // alert("Welcome Info!");
}

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
                // console.log(data);
                if(data.msg == 'success') {
                    console.log(data.name);
                    var loginchkModal = $('#loginchkModal');
                    var signInModal = $('#signInModal');
                    loginchkModal.modal();
                    loginchkModal.find('.modal-body').text(data.name + '님 로그인되었습니다.');
                    signInModal.modal('hide');

                    $("#loginchkModal").on("hidden.bs.modal", function () {
                        location.reload();
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



