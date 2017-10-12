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
                    <div class="btn-group" data-toggle="buttons">
                        <label class="btn btn-outline-dark active">
                            <input type="radio" name="grade" id="1" value="1학년" checked>1학년
                        </label>
                        <label class="btn btn-outline-dark">
                            <input type="radio" name="grade" id="2" value="2학년">2학년
                        </label>
                        <label class="btn btn-outline-dark">
                            <input type="radio" name="grade" id="3" value="3학년">3학년
                        </label>
                    </div>
                    <select id="class" class="custom-select">
                        <option value="1" selected>1반</option>
                        <option value="2">2반</option>
                        <option value="3">3반</option>
                        <option value="4">4반</option>
                        <option value="5">5반</option>
                        <option value="6">6반</option>
                    </select>
                    <br><br>
                    <input type="text" id="number" class="signUp" placeholder="번호를 입력하세요." required>
                    <input type="text" id="name" class="signUp" placeholder="이름을 입력하세요." required>
                    <br><br>
                    <div class="idcon">
                        <div style="margin-bottom: 10px;">
                            <label for="signUpid">Id</label>
                            <input type="text" id="signUpid" placeholder="Id" required><br>
                        </div>
                        <label for="signUppwd">Password</label>
                        <input type="password" id="signUppwd" placeholder="Password" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-dark">Sign Up</button>
                    <button type="button" class="btn btn-outline-dark" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>