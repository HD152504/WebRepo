package org.dimigo.action;

import org.dimigo.service.NaverServcie;
import org.dimigo.vo.BookVO;
import org.dimigo.vo.MovieVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class NaverAction implements IAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer integer = Integer.parseInt(request.getParameter("choice"));
        int choice = integer;

        try {
            String search = request.getParameter("search");


            System.out.println("키워드 : " + search + "\n선택 : " + choice);

            NaverServcie naver = new NaverServcie();
            if (choice == 1) {
                String json = naver.search(search, choice);
                List<MovieVO> list = naver.parseJson(json, choice);
                System.out.println(list.get(0).title);
                request.setAttribute("movie", list);
            } else if (choice == 2) {
                String json = naver.search(search, choice);
                List<BookVO> list = naver.parseJson(json);
                System.out.println(list.get(0).title);
                request.setAttribute("book", list);
            }


            if (choice == 1) {
                RequestDispatcher rd = request.getRequestDispatcher("myblog/movie.jsp");
                rd.forward(request, response);
            } else if(choice == 2) {
                RequestDispatcher rd = request.getRequestDispatcher("myblog/book.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "에러가 발생했습니다.");
            if (choice == 1) {

                RequestDispatcher rd = request.getRequestDispatcher("myblog/moviesearch.jsp");
                rd.forward(request, response);
            } else if(choice == 2) {
                RequestDispatcher rd = request.getRequestDispatcher("myblog/booksearch.jsp");
                rd.forward(request, response);
            }

        }
    }
}
