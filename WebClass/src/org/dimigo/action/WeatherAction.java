package org.dimigo.action;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.dimigo.User.User;
import org.dimigo.User.UserPlace;
import org.dimigo.User.Weather;

import org.dimigo.service.GeocodingService;
import org.dimigo.service.WeatherService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class WeatherAction implements IAction{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        JsonObject jsonObject = new JsonObject();
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();

        HttpSession session = request.getSession();


        try {
            // 1. 입력값 추출
            request.setCharacterEncoding("utf-8");
            String city = request.getParameter("inputCity");
            String gu = request.getParameter("inputGu");
            String eup = request.getParameter("inputEup");

            System.out.println("city : " + city + " gu : " + gu + " eup : " + eup);

            // Upcasting으로 user를 만들어 객체 하나로 모든 처리를 가능하게 한다.
            User user = new UserPlace(city, gu, eup);

            WeatherService weatherService = new WeatherService();
            GeocodingService geocodingService = new GeocodingService();

            // 입력받은 위치를 TMap에서 제공하는 좌표로 바꾼다.
            String json = geocodingService.search(user, 1);
            user = geocodingService.parsePlace(json, 1);
            // TMap에서 제공하는 좌표로 바꾼 위치를 공식적인 좌표로 바꾼다.
            json = geocodingService.search(user, 2);
            user = geocodingService.parsePlace(json, 2);

            // 바꾼 좌표를 넣어 날씨를 구한다.
            json = weatherService.search(user);
            Weather weather = weatherService.parseJson(json);
            // 날씨 출력
            System.out.println(weather);

//            String json = NaverMap.search(user);
//            user = NaverMap.parseJson(json);

//            json = weatherService.search(user);
//            Weather weather = weatherService.parseJson(json);
//            System.out.println(weather);
            // user가 바뀌었으므로 다시 입력받은 위치에 대한 정보를 넣어준다.
            user = new UserPlace(city, gu, eup);

            StringBuffer sb = new StringBuffer();

            // 입력받은 위치 정보를 String Builder로 append하여 attribute를 추가해준다.
            sb.append(((UserPlace)user).getCity_do() + " " + ((UserPlace)user).getGu_gun() + " " + ((UserPlace)user).getEup_meon_dong());
            request.setAttribute("weather", weather);
            request.setAttribute("place", sb.toString());
            request.setAttribute("time", weather.getTime());


            RequestDispatcher rd = request.getRequestDispatcher("/myblog/weather.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("/myblog/weathersearch.jsp");
            rd.forward(request, response);

        }
    }
}
