package presentacion.vista.filechooser;

import presentacion.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.JOptionPane;

public class MyFileChooser extends javax.swing.JFrame {
    
    private JFileChooser fc;
    
    public File getFile(File path, Frame window){
        
        if (fc == null) {
            fc = new JFileChooser();                        // Crea el MyFileChooser
            fc.addChoosableFileFilter(new ImageFilter());   // Añade el filtro
            fc.setAcceptAllFileFilterUsed(false);           // Deshabilita todos los filtros
            fc.setFileView(new ImageFileView());            // Agrega iconos
            fc.setAccessory(new ImagePreview(fc));          // Preview de las imagenes
            fc.setCurrentDirectory(path);                   // Establece el directorio de inicio del MyFileChooser
        }

        int returnVal = fc.showDialog(window, "Abrir");       // Lanza el MyFileChooser
        
        // Accion Aceptar
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            
            if (file != null){
                if (file.exists()){
                    return file;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Asegurese de que el archivo \n"+ file.getPath() +" existe.", "Archivo no encontrado", JOptionPane.WARNING_MESSAGE);
                    getFile(new File(file.getParentFile().getPath()), window);
                } 
            }
        }
        
        // Accion Cancelar
        return null;
    }
}
