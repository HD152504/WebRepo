package org.dimigo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dimigo.vo.BookVO;
import org.dimigo.vo.MovieVO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NaverServcie {


    @SuppressWarnings("unchecked")
    public List<MovieVO> parseJson(String json, int choice) throws Exception{
        Map<String, Object> map = new ObjectMapper().readValue(json, Map.class);
        List<Map<String, String>> list = (List<Map<String, String>>)map.get("items");

        List<MovieVO> result = new ArrayList<>();



        for (Map<String, String> var : list) {

            if (choice == 1) result.add(new MovieVO(var.get("title").replaceAll("\\<.*?>", ""), var.get("pubDate"), var.get("director").substring(0, var.get("director").length() - 1), var.get("link")));
//            else if (choice == 2) result.add(new BookVO(var.get("title").replaceAll("\\<.*?>", ""), var.get("link"), var.get("image"), var.get("author"), var.get("discount")));

        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public List<BookVO> parseJson(String json) throws Exception{
        Map<String, Object> map = new ObjectMapper().readValue(json, Map.class);
        List<Map<String, String>> list = (List<Map<String, String>>)map.get("items");

        List<BookVO> result = new ArrayList<>();



        for (Map<String, String> var : list) {

            result.add(new BookVO(var.get("title").replaceAll("\\<.*?>", ""), var.get("link"), var.get("image"), var.get("author"), var.get("discount")));

        }

        return result;
    }

    public String search(String query, int choice) throws Exception{
        String clientId = "D0sJMqbCo2EsY1hBE24K";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "pXuBf_2BAZ";//애플리케이션 클라이언트 시크릿값";
        String apiURL = null;
        try {

            String text = URLEncoder.encode(query, "UTF-8");

            // 블로그 : blog / 뉴스 : news / 책 : book / 영화 : movie
            if (choice == 1) apiURL = "https://openapi.naver.com/v1/search/movie?query="+ text + "&display=30"; // json 결과
            else if (choice == 2) apiURL = "https://openapi.naver.com/v1/search/book?query="+ text + "&display=30"; // json 결과

            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());

            return response.toString();

        } catch (Exception e) {
            throw e;
        }

    }
}
