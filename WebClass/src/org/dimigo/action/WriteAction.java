package org.dimigo.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.dimigo.service.BulletinService;
import org.dimigo.vo.BulletinVO;

public class WriteAction implements IAction {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        JsonObject obj = new JsonObject();
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        long time = System.currentTimeMillis();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        String date = dateFormat.format(new Date(time));


        try{
            request.setCharacterEncoding("utf-8");
            String title = request.getParameter("title");
            System.out.println(title);
            String author = session.getAttribute("username").toString();
//            String author = "default";
            System.out.println(author);
            String text = request.getParameter("text");

            System.out.println( title + author + date + text);

            BulletinVO vo = new BulletinVO(title,author,date,text);
            BulletinService boardService = new BulletinService();
            boardService.write(vo, author);

            RequestDispatcher rd = request.getRequestDispatcher("/list.do");
            rd.forward(request, response);

        }  catch (Exception e){
            request.setAttribute("error", e.getMessage());
            e.printStackTrace();
        }
    }
}