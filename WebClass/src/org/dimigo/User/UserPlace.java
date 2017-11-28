package org.dimigo.User;

public class UserPlace extends User{
    private String city_do;
    private String gu_gun;
    private String eup_meon_dong;

    public UserPlace(String city_do, String gu_gun, String eup_meon_dong) {
        this.city_do = city_do;
        this.gu_gun = gu_gun;
        this.eup_meon_dong = eup_meon_dong;
    }

    public String getCity_do() {
        return city_do;
    }

    public void setCity_do(String city_do) {
        this.city_do = city_do;
    }

    public String getGu_gun() {
        return gu_gun;
    }

    public void setGu_gun(String gu_gun) {
        this.gu_gun = gu_gun;
    }

    public String getEup_meon_dong() {
        return eup_meon_dong;
    }

    public void setEup_meon_dong(String eup_meon_dong) {
        this.eup_meon_dong = eup_meon_dong;
    }
}
