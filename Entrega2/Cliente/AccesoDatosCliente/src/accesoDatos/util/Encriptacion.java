package accesoDatos.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Encriptacion {
    
    public static String md5(String message){
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theTextToDigestAsBytes = message.getBytes("8859_1");
            md.update(theTextToDigestAsBytes);
            byte[] digest = md.digest();
            for (byte b : digest) {
                md5 += Integer.toHexString(b & 0xff);
            }
            return md5;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Encriptacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encriptacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return md5;
    }
}
