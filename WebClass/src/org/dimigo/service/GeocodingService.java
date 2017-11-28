package org.dimigo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dimigo.User.User;
import org.dimigo.User.UserLL;
import org.dimigo.User.UserPlace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class GeocodingService {

    @SuppressWarnings("unchecked")
    public User parsePlace(String json, int index) throws IOException {
        Map<String, Object> map = new ObjectMapper().readValue(json, Map.class);
        Map<String, String> coordinfo = null;
        if (index == 1) {
            coordinfo =  (Map<String, String>) map.get("coordinateInfo");
        } else if (index == 2) {
            coordinfo = (Map<String, String>) map.get("coordinate");
        }
        User user = new UserLL(coordinfo.get("lat"), coordinfo.get("lon"));

        System.out.println("위도 : " + ((UserLL)user).getLat() + "\n경도 : " + ((UserLL)user).getLon());

        return user;
    }


    public String search(User user, int index) throws Exception {
        try {
            String apiURL = null;

            if (index == 1) {
                String city = ((UserPlace) user).getCity_do();
                String gu = ((UserPlace) user).getGu_gun();
                String eup = ((UserPlace) user).getEup_meon_dong();
                apiURL = "https://apis.skplanetx.com/tmap/geo/geocoding?version=1&city_do=" + city + "&gu_gun=" + gu + "&dong=" + eup; // json 결과
                //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            } else if (index == 2) {
                apiURL = "https://apis.skplanetx.com/tmap/geo/coordconvert?version=1&lat=" + ((UserLL)user).getLat() + "&lon=" + ((UserLL)user).getLon() +"&fromCoord=&toCoord=&callback="; // json 결과
            }
//            System.out.println(apiURL);

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            System.out.println(url.toString());
            con.setRequestMethod("GET");
            con.setRequestProperty("appKey", "ddf72048-6fcd-31da-be3e-c1358f06331e");

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
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
