package mx.com.newOrg.commons.secureHash;

import org.apache.commons.codec.digest.DigestUtils;

public final class StringHash {

    public static String md2(String obj) {

        return DigestUtils.md2Hex(obj);
    }

    public static String md5(String obj) {

        return DigestUtils.md5Hex(obj);
    }

    public static String sha1(String obj) {

        return DigestUtils.sha1Hex(obj);
    }

    public static String sha256(String obj) {

        return DigestUtils.sha256Hex(obj);
    }

    public static String sha384S(String obj) {

        return DigestUtils.sha384Hex(obj);
    }

    public static String sha512(String obj) {

        return DigestUtils.sha512Hex(obj);
    }

}
