package org.dimigo.action;

import org.dimigo.service.BulletinService;
import org.dimigo.service.UserService;
import org.dimigo.vo.BulletinVO;
import org.dimigo.vo.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ListAction implements IAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1. ArrayList 생성
        // 2. UserVO 객체를 담기
        // 3.request에 ArrayList를 set하고, list.jsp로 포워딩

//        UserService userService = new UserService();
//
//        List<UserVO> list = userService.searchUserList();
//
//        request.setAttribute("list", list);
//
//        RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
//        rd.forward(request, response);


            HttpSession session = request.getSession();

            if (session.getAttribute("user") == null) {

                request.setAttribute("error", "로그인을 해주세요");
//                response.sendRedirect("myblog/index.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("/myblog/index.jsp");
                rd.forward(request, response);
            } else {
                //    RequestDispatcher rd = request.getRequestDispatcher("jsp/board.jsp");
                //  rd.forward(request, response);

                try {
                    // 비지니스 로직 처리를 위한 Service 호출
                    BulletinService service = new BulletinService();
                    List<BulletinVO> result = service.searchDiaryList();
                    System.out.println("실행1");
                    request.setAttribute("list", result);

                    RequestDispatcher rd = request.getRequestDispatcher("/myblog/bulletin.jsp");
                    rd.forward(request, response);

                } catch(Exception e) {
                    System.out.println("실행");
                    request.setAttribute("msg", "error");
                    request.setAttribute("error", e.getMessage());
                    e.printStackTrace();


                }

            }
    }

}



