package com.glxt.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Description
 * @Author: luo
 * @Date 2022年12月29日 15:46:20
 */
public class MD5Utils {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassToFormPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
//        System.out.println(str);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String saltDB) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }
}