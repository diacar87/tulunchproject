
package SourcePresentacionServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import SourceLogicaNegocioServidor.LogServidor;



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
     
     public HiloCliente(Socket skClienteComunicacion,Socket skClienteMensajes){
        this.skClienteComunicacion = skClienteComunicacion;
        this.skClienteMensajes = skClienteMensajes;
        clientesActivos.add(this);
        LogServidor.setEvento("Cliente Agregado: "+ this);			
     }
     
     public void run(){
         /*LogServidor.setEvento("Esperando Peticiones del Cliente :"+ this);
        try{
            entradaComunicacion = new DataInputStream(skClienteComunicacion.getInputStream());
            salida=new DataOutputStream(skClienteComunicacion.getOutputStream());
            salida2=new DataOutputStream(scli2.getOutputStream());
            this.setNameUser(entrada.readUTF());
            enviaUserActivos();
        }
    	catch (IOException e) {  e.printStackTrace();     }
    	
        int opcion=0,numUsers=0;
        String amigo="",mencli="";
                
    	while(true)
    	{
          try
          {
             opcion = entradaComunicacion.readInt();
             switch(opcion)
             {
                case 1://envio de mensage a todos
                   mencli = entradaComunicacion.readUTF();
                   serv.mostrar("mensaje recibido "+mencli);
                   enviaMsg(mencli);
                   break;
                case 2://envio de lista de activos
                   numUsers=clientesActivos.size();
                   salida.writeInt(numUsers);
                   for(int i=0;i<numUsers;i++)
                      salida.writeUTF(clientesActivos.get(i).nameUser);
                   break;
                case 3: // envia mensage a uno solo
                   amigo = entradaComunicacion.readUTF();//captura nombre de amigo
                   mencli= entradaComunicacion.readUTF();//mensage enviado
                   enviaMsg(amigo,mencli);
                   break;
             }
          }
          catch (IOException e) {System.out.println("El cliente termino la conexion");break;}
    	}
    	serv.mostrar("Se removio un usuario");
    	clientesActivos.removeElement(this);
    	try
    	{
          serv.mostrar("Se desconecto un usuario");
          scli.close();
    	}	
        catch(Exception et)
        {serv.mostrar("no se puede cerrar el socket");}  */        
     }
     


}
