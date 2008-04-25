package accesoDatos.util;


import java.io.*;

/**
 * Esta clase se encarga del manejo de archivos
 * @methods copiar
 */
public class Archivo {
    
    /**
     * Copia un archivo de un directorio a otro, util para copiar imagenes
     * @param archivo original
     * @param archivo copia
     * @return <tt>true</tt> si la copia del archivo fue exitosa
     */
    public static boolean copiar(File origen, File destino){
        
        try{
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(origen));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destino));
            byte[] buf = new byte[ 1024 ];
            int numRead;
            
            while ((numRead=bis.read(buf, 0, buf.length )) >= 0 ){
                bos.write( buf, 0, numRead );
            }

            bos.close();
            bis.close();
            return true;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}