
package SourceLogicaNegocioServidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import vo.*;
import dao.*;


/**
 *
 * @author acactown
 */
public class HiloCliente implements Runnable{

    Socket skClienteComunicacion=null;
    Socket skClienteMensajes=null;
    ObjectInputStream entradaComunicacion=null;
    ObjectOutputStream salidaComunicacion=null;
    ObjectOutputStream salidaMensajes=null;
    public static Vector<HiloCliente> clientesActivos = new Vector();	
    String nameUser;
    Servidor servidor;
     
     public HiloCliente(Socket skClienteComunicacion,Socket skClienteMensajes,Servidor servidor){
        this.skClienteComunicacion = skClienteComunicacion;
        this.skClienteMensajes = skClienteMensajes;
        this.servidor = servidor;
        nameUser="";
        clientesActivos.add(this);
        LogServidor.setEvento("Cliente Agregado: "+this);			
     }
     
     public String getNameUser()
     {
       return nameUser;
     }
     
     public void setNameUser(String name)
     {
       nameUser=name;
     }
     
     public void run()
     {
    	serv.mostrar(".::Esperando Mensajes :");
    	
    	try
    	{
          entradaComunicacion=new DataInputStream(skClienteComunicacion.getInputStream());
          salidaComunicacion=new DataOutputStream(skClienteComunicacion.getOutputStream());
          salidaMensajes=new DataOutputStream(skClienteMensajes.getOutputStream());
          this.setNameUser(entradaComunicacion.readUTF());
          enviaUserActivos();
    	}
    	catch (IOException e) {  e.printStackTrace();     }
    	
        int opcion=0,numUsers=0;
        String amigo="",mencli="";
                
    	while(true)
    	{
          try
          {
             opcion=entradaComunicacion.readInt();
             switch(opcion)
             {
                case 1://envio de mensage a todos
                   mencli=entradaComunicacion.readUTF();
                   serv.mostrar("mensaje recibido "+mencli);
                   enviaMsg(mencli);
                   break;
                case 2://envio de lista de activos
                   numUsers=clientesActivos.size();
                   salidaComunicacion.writeInt(numUsers);
                   for(int i=0;i<numUsers;i++)
                      salidaComunicacion.writeUTF(clientesActivos.get(i).nameUser);
                   break;
                case 3: // envia mensage a uno solo
                   amigo=entradaComunicacion.readUTF();//captura nombre de amigo
                   mencli=entradaComunicacion.readUTF();//mensage enviado
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
          skClienteComunicacion.close();
    	}	
        catch(Exception et)
        {serv.mostrar("no se puede cerrar el socket");}   
     }
     
     public void enviaMsg(String mencli2)
     {
        threadServidor user=null;
        for(int i=0;i<clientesActivos.size();i++)
        {
           serv.mostrar("MENSAJE DEVUELTO:"+mencli2);
           try
            {
              user=clientesActivos.get(i);
              user.salida2.writeInt(1);//opcion de mensage 
              user.salida2.writeUTF(""+this.getNameUser()+" >"+ mencli2);              
            }catch (IOException e) {e.printStackTrace();}
        }
     }
     public void enviaUserActivos()
     {
        threadServidor user=null;
        for(int i=0;i<clientesActivos.size();i++)
        {           
           try
            {
              user=clientesActivos.get(i);
              if(user==this)continue;//ya se lo envie
              user.salida2.writeInt(2);//opcion de agregar 
              user.salida2.writeUTF(this.getNameUser());	
            }catch (IOException e) {e.printStackTrace();}
        }
     }

   private void enviaMsg(String amigo, String mencli) 
   {
      threadServidor user=null;
        for(int i=0;i<clientesActivos.size();i++)
        {           
           try
            {
              user=clientesActivos.get(i);
              if(user.nameUser.equals(amigo))
              {
                 user.salida2.writeInt(3);//opcion de mensage amigo   
                 user.salida2.writeUTF(this.getNameUser());
                 user.salida2.writeUTF(""+this.getNameUser()+">"+mencli);
              }
            }catch (IOException e) {e.printStackTrace();}
        }
   }

}
