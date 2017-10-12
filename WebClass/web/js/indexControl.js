function mouseOn(e) {
    e.setAttribute("class", "nav-link active");
}

function mouseOut(e) {
    e.setAttribute("class", "nav-link");
}


// $(document).on('hide.bs.modal','#loginchkModal', function () {
//     console.log("닫힘");
// });

//     $(document).ready(function () {
//         $("#signInForm").submit(function (event) {
//             // submit이 자동으로 되는 기능을 막기
//             event.preventDefault();
//
//             // id, pwd를 가져오기
//             var id = $('#signInid').val();
//             var pwd = $('#signInpwd').val();
//             console.log("id : " + id + "\npwd : " + pwd);
//             console.log("실행됨");
//             // 서버로 post 전송 (ajax)
//             $.post("http://httpbin.org/post", { "id" : id, "pwd" : pwd },
//                 function(data) {
// //                        alert(data.form.id + '님 로그인되었습니다.');
//                     var loginchkModal = $('#loginchkModal');
//                     var signInModal = $('#signInModal');
//                     loginchkModal.modal();
//                     loginchkModal.find('.modal-body').text(data.form.id + '님 로그인되었습니다.');
//                     signInModal.modal('hide');
//
//                 });          // post방식으로 저 사이트에 post를 보내는데 json형식으로 입력한 값이 들어감
//
//         });
//     });


$(document).ready(function () {
    $("#signUpForm").submit(function (event) {
        // submit이 자동으로 되는 기능을 막기
        event.preventDefault();

        // id, pwd를 가져오기
        var grade = $('input[type=radio][name=grade]:checked').val();
        var cls = $('#class').val();
        var num = $('#number').val();
        var name = $('#name').val();
        var id = $('#signUpid').val();
        var pwd = $('#signUppwd').val();

        console.log("grade : " + grade + "\nclass : " + cls + "\nnum : " + num + "\nname : " + name + "\nid : " + id + "\npwd : " + pwd);

        // 서버로 post 전송 (ajax)
        $.post("http://httpbin.org/post", { "id" : id, "pwd" : pwd },
            function(data) {
                var signUpchkModal = $('#signUpchkModal');
                var signUpModal = $('#signUpModal');
                signUpchkModal.modal();
                signUpchkModal.find('.modal-body').text(data.form.id + '님 회원가입되었습니다.');
                signUpModal.modal('hide');

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
//            console.log("id : " + id + "\npwd : " + pwd);
        console.log("id : " + id);

        // 서버로 post 전송 (ajax)
        $.post("/bloglogin", { "id" : id },
            function(data) {
                // console.log(data);
                if(data.msg == 'success') {

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
                    var loginModal = $('#signInModal');
                    var myModal = $('#myModal');
                    myModal.modal();
                    myModal.find('.modal-title').text('Sign In Error');
                    myModal.find('.modal-body').text('Invalid username or password');
                    loginModal.modal('hide');
                    $("#myModal").on("hidden.bs.modal", function () {
                        // $(function () {
                        $('#signInpwd').val("");
                        // });
                        var modal = $("#signInModal");
                        modal.modal();
                        console.log("으알어란아런ㅇ");
                    });
                }
//                    var myModal = $('#myModal');
//                    myModal.modal();
//                    myModal.find('.modal-body').text(data.id + '님 로그인되었습니다.');

            });          // post방식으로 저 사이트에 post를 보내는데 json형식으로 입력한 값이 들어감

    });
});



