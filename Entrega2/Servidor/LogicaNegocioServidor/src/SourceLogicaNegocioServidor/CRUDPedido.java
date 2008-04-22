/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SourceLogicaNegocioServidor;
import dao.*;
import java.util.List;
import vo.*;
/**
 *
 * @author Diana
 */
public class CRUDPedido {
    public static List<Pedido> readAll()
    {        
            List<Pedido> pedidos;
            pedidos=DaoPedido.readAll();
            return pedidos;        
    }

}
