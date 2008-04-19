package seguridad;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encriptacion {
    
    public static String md5(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String md5 = "";
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] theTextToDigestAsBytes = message.getBytes("8859_1");
        md.update(theTextToDigestAsBytes);
        byte[] digest = md.digest();
        for (byte b : digest) {
            md5 += Integer.toHexString(b & 0xff);
        }
        return md5;
    }
}
