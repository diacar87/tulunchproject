
package SourcePresentacionServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import SourceLogicaNegocioServidor.LogServidor;
import vo.*;
import dao.*;


/**
 *
 * @author acactown
 */
public class HiloCliente implements Runnable{

    Socket skClienteComunicacion = null;
    Socket skClienteMensajes = null;
    ObjectInputStream entradaComunicacion = null;
    ObjectOutputStream salidaComunicacion = null;
    ObjectOutputStream salidaMensajes = null;
    public static Vector<HiloCliente> clientesActivos = new Vector();	
    String nameUser;
     
     public HiloCliente(Socket skClienteComunicacion,Socket skClienteMensajes){
        this.skClienteComunicacion = skClienteComunicacion;
        this.skClienteMensajes = skClienteMensajes;
        nameUser="";
        clientesActivos.add(this);
        LogServidor.setEvento("Cliente Agregado: "+ this);			
     }
     
     public String getNameUser()
     {
       return nameUser;
     }
     
     public void setNameUser(String name)
     {
       nameUser=name;
     }
     
     public void run(){
         
     }
     


}
