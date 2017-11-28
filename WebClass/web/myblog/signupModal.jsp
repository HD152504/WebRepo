<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-09
  Time: 오후 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 회원가입 모달 -->
<div class="modal" id="signUpModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form class="form-control mr-sm-2" id="signUpForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h5 class="modal-title">회원가입</h5>
                </div>
                <div class="modal-body">
                    <br><br>
                    <div class="idcon">
                        <div style="margin-bottom: 35px;">
                            <label for="signUpid">ID</label>
                            <input type="email" id="signUpid" placeholder="Email" required><br>
                        </div>

                        <div style="margin-bottom: 35px;">
                        <label for="signUppwd">Password</label>
                        <input type="password" id="signUppwd" placeholder="Password" required>
                        </div>

                        <div style="margin-bottom: 35px;">
                            <label for="signUppwdchk">Password Check</label>
                            <input type="password" id="signUppwdchk" placeholder="Password" required>
                        </div>

                        <label for="signUpname">Name</label>
                        <input type="text" id="signUpname" class="signUp" placeholder="이름을 입력하세요." required>

                    </div>
                    <br><br>

                </div>

                <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-dark">Sign Up</button>
                    <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>