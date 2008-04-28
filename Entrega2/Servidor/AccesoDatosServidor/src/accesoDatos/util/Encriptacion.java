package accesoDatos.util;

import java.security.MessageDigest;

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
            Log.setEvento("Cliente", "INFO", "Se pudo encriptar el password");
            return md5;
        } catch (Exception ex) {
            Log.setEvento("Cliente", "WARNING", "No se pudo encriptar el password");
        }
        return md5;
    }
}
