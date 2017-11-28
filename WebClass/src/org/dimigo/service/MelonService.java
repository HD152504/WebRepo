package org.dimigo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dimigo.User.Music;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MelonService {

    public String search() throws Exception{
        try {

            String apiURL = "http://apis.skplanetx.com/melon/charts/realtime?version=1&page=1&count=50"; // json 결과

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("appKey", "4ce8bb31-9934-376b-8a64-0b5922ad9f71");

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
            System.out.println("result:" + response.toString());

            return response.toString();

        } catch (Exception e) {
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Music> parseJson(String json) throws Exception{
        Map<String, Object> map = new ObjectMapper().readValue(json, Map.class);
        Map<String, Object> melon = (Map<String, Object>) map.get("melon");
        String rankDay = (String) melon.get("rankDay");
        Map<String, List<Map>> songsMap = (Map<String, List<Map>>) melon.get("songs");
        List<Map> list = songsMap.get("song");

        // List에서 하나씩 뽑아 올것이므로 null로 초기화 한 다음 받아온다.
        Map<String, Object> songData = null;
        Music[] music = new Music[50];


        StringBuilder sb = new StringBuilder();


        // music배열의 크기만큼 for문을 돌려 map에 넣어준다.
        for (int i = 0; i < music.length; i++) {

            songData = list.get(i);


            // 앨범 명과 곡 명 파싱
            String songName = (String) songData.get("songName");
            String albumName = (String) songData.get("albumName");

            Integer integer = (Integer) songData.get("currentRank");

            int currentRank = integer;

            Map<String, List> artistsMap = (Map<String, List>) songData.get("artists");
            List<Map> artistList = artistsMap.get("artist");


            // 가수가 한명이 아닐 수도 있으므로 list 사이즈 만큼 for문을 돌려 가수를 파싱한다.
            for (int j = 0; j < artistList.size(); j++) {

                Map<String, Object> artistMap = (artistList.get(j));
                if(j == 0) sb.append((String) artistMap.get("artistName"));
                else sb.append(", " + artistMap.get("artistName"));
            }

//            System.out.println("노래명 : " + songName + " 앨범명 : " + albumName + " 순위 : " + integer);

            // 파싱한 차트에 대한 정보를 Music 객체에 담는다.
            music[i] = new Music(sb.toString(), songName, albumName, currentRank);

            // 가수명을 넣어주는 StringBuilder 초기화
            sb.setLength(0);
        }

        // 차트 정보를 담고있는 List를 만들어서 아래의 for문에서 담는다.
        List<Music> chartlist = new ArrayList<Music>();

        for (int i = 0; i < music.length; i++) {
            System.out.println(music[i]);
            chartlist.add(i, music[i]);
        }

        System.out.println(rankDay);

        return chartlist;

    }

}
