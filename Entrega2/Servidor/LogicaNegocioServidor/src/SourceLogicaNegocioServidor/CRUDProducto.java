/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SourceLogicaNegocioServidor;

import java.util.List;
import dao.*;
import vo.*;

/**
 *
 * @author Diana
 */
public class CRUDProducto {
    
    public static List<Producto> readAll()
    {        
            List<Producto> productos;
            productos=DaoProducto.readAll();
            return productos;        
    }

}
