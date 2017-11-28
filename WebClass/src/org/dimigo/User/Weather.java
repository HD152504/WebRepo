package org.dimigo.User;

public class Weather {
    private String curTemp;
    private String maxTemp;
    private String minTemp;
    private String humidity;
    private String skyCode;
    private String skyCodeName;
    private String time;


    public Weather() {}

    public Weather(String curTemp, String maxTemp, String minTemp, String humidity, String skyCode, String skyCodeName, String time) {
        this.curTemp = curTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humidity = humidity;
        this.skyCode = skyCode;
        this.skyCodeName = skyCodeName;
        this.time = time;
    }

    public String getCurTemp() {
        return curTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getSkyCode() {
        return skyCode;
    }

    public String getTime() {
        return time;
    }


    @Override
    public String toString() {

        return  "curTemp='" + curTemp + '\'' +
                ", maxTemp='" + maxTemp + '\'' +
                ", minTemp='" + minTemp + '\'' +
                ", humidity='" + humidity + '\'' +
                ", skyCode='" + skyCode + '\'' +
                ", skyCodeName='" + skyCodeName + '\'' +
                ", time='" + time + '\'';
    }

    public String getSkyCodeName() {
        return skyCodeName;
    }
}
