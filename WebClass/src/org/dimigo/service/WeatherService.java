package org.dimigo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dimigo.User.User;
import org.dimigo.User.UserLL;
import org.dimigo.User.Weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class WeatherService {
    @SuppressWarnings("unchecked")
    public Weather parseJson(String json) throws Exception{
        // 내 코드
        Map<String, Object> map = new ObjectMapper().readValue(json, Map.class);
        Map<String, List<Map>> hour = (Map<String, List<Map>>)map.get("weather");
        List<Map> list = hour.get("hourly");
        Map<String, Object> inner = list.get(0);
        Map<String, String> grid = (Map<String, String>) inner.get("grid");
        Map<String, String> sky = (Map<String, String>) inner.get("sky");
        Map<String, String> temperature = (Map<String, String>) inner.get("temperature");

//        System.out.printf("%s도 %s %s\n", grid.get("city"),
//                grid.get("county"),
//                grid.get("village"));
//        System.out.printf("현재온도 : %s, 최대온도 : %s, 최저온도 : %s\n",  temperature.get("tc"),
//                temperature.get("tmax"),
//                temperature.get("tmin"));


        Weather weather1 = new Weather(temperature.get("tc"), temperature.get("tmax"), temperature.get("tmin"), (String)inner.get("humidity"), sky.get("code"), (String)sky.get("name"), (String)inner.get("timeRelease"));

        return weather1;

    }


    public String search(User user) throws Exception{
        try {


            String apiURL = "http://apis.skplanetx.com/weather/current/hourly?lon=" + ((UserLL)user).getLon() + "&village=&county=&lat=" + ((UserLL)user).getLat() + "&city=&version=1"; // json 결과
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("appKey", "1e05e131-9c13-3010-af00-df70f196004e");

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
