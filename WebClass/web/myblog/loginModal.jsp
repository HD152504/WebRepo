<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-09
  Time: 오후 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 로그인 모달 -->
<div class="modal" id="signInModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form class="form-control mr-sm-2" id="signInForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4>Please Sign in</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="signInid" class="loginlabel">ID</label><br>
                        <input type="email" class="myinputD" id="signInid" placeholder="Enter Email" required>
                    </div>
                    <div class="form-group">
                        <label for="signInpwd" class="loginlabel">Password</label><br>
                        <input type="password" class="myinputD" id="signInpwd" placeholder="Password" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-dark">Sign in</button>
                    <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>
