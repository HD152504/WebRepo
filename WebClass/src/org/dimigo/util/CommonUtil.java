package org.dimigo.util;

public class CommonUtil {
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public static void main(String[] args) {
        String uri = "/login.do";
        System.out.println("uri : " + uri);


    }

}
