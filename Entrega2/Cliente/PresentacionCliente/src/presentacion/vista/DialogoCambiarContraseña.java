package presentacion.vista;

import accesoDatos.util.Encriptacion;
import accesoDatos.vo.Empleado;
import java.awt.Color;
import javax.swing.JPasswordField;
import presentacion.util.Ventana;

public class DialogoCambiarContraseña extends javax.swing.JDialog {
    
    private JPasswordField selectedPasswordField;
    private String currentPassword = "";
    private Empleado empleado;
    private int maxLenght = 4;

    public DialogoCambiarContraseña(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Ventana.centrar(this);
        pack();
        selectedPasswordField = contraseñaActual;
        actualizarEstadoComponentes();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teclado = new javax.swing.JPanel();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        boton7 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();
        boton9 = new javax.swing.JButton();
        ContraseñaActual = new javax.swing.JLabel();
        contraseñaActual = new javax.swing.JPasswordField();
        NuevaContraseña = new javax.swing.JLabel();
        nuevaContraseña = new javax.swing.JPasswordField();
        ConfirmarContraseña = new javax.swing.JLabel();
        confirmarContraseña = new javax.swing.JPasswordField();
        separador = new javax.swing.JSeparator();
        botonCancelar = new javax.swing.JButton();
        botonCambiarContraseña = new javax.swing.JButton();
        barraEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambio de contraseña");
        setResizable(false);

        boton1.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton1.setText("1");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton2.setText("2");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton3.setText("3");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        boton4.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton4.setText("4");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        boton5.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton5.setText("5");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });

        boton6.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton6.setText("6");
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });

        boton7.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton7.setText("7");
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });

        boton8.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton8.setText("8");
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });

        boton9.setFont(new java.awt.Font("Tahoma", 0, 18));
        boton9.setText("9");
        boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tecladoLayout = new javax.swing.GroupLayout(teclado);
        teclado.setLayout(tecladoLayout);
        tecladoLayout.setHorizontalGroup(
            tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tecladoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tecladoLayout.createSequentialGroup()
                        .addComponent(boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tecladoLayout.createSequentialGroup()
                        .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tecladoLayout.createSequentialGroup()
                        .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tecladoLayout.setVerticalGroup(
            tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tecladoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ContraseñaActual.setText("Introducir contraseña actual");

        contraseñaActual.setForeground(new java.awt.Color(255, 0, 0));
        contraseñaActual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contraseñaActualMouseClicked(evt);
            }
        });

        NuevaContraseña.setText("Introducir nueva contraseña");

        nuevaContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevaContraseñaMouseClicked(evt);
            }
        });

        ConfirmarContraseña.setText("Confirmar nueva contraseña");

        confirmarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarContraseñaMouseClicked(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonCambiarContraseña.setText("Cambiar contraseña");
        botonCambiarContraseña.setEnabled(false);
        botonCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarContraseñaActionPerformed(evt);
            }
        });

        barraEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(ContraseñaActual))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonCambiarContraseña)
                        .addGap(18, 18, 18)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NuevaContraseña)
                            .addComponent(ConfirmarContraseña)
                            .addComponent(confirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevaContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(contraseñaActual, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(barraEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ContraseñaActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contraseñaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(NuevaContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(ConfirmarContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(teclado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonCambiarContraseña))
                .addGap(18, 18, 18)
                .addComponent(barraEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setEmpleado(Empleado empleado){
        currentPassword = empleado.getPassword();
        this.empleado = empleado;
    }
    
    public void resetAll(){
        contraseñaActual.setText("");
        nuevaContraseña.setText("");
        confirmarContraseña.setText("");
        botonCambiarContraseña.setEnabled(false);
        actualizarEstadoComponentes();
    }
    
    // Validacion de password
    
    private boolean contraseñaActualEsValida(){
        if(Encriptacion.md5(contraseñaActual.getText()).equals(currentPassword)){
            return true;
        }
        return false;
    }
    
    private boolean contraseñaNuevaEsValida(){
        if(!nuevaContraseña.getText().equals("") && nuevaContraseña.getText().equals(confirmarContraseña.getText())){
            return true;
        }
        return false; 
    }
    
    private void actualizarEstadoComponentes(){
 
        if(!contraseñaActualEsValida() && !contraseñaNuevaEsValida()){
            barraEstado.setText(" Ningun campo es correcto");
            botonCambiarContraseña.setEnabled(false);
            nuevaContraseña.setForeground(Color.RED); 
            confirmarContraseña.setForeground(Color.RED);
            contraseñaActual.setForeground(Color.RED);
            return;
        }
            
        if(!contraseñaNuevaEsValida()){
            barraEstado.setText(" Verifique la nueva contraseña");
            botonCambiarContraseña.setEnabled(false);
            nuevaContraseña.setForeground(Color.RED); 
            confirmarContraseña.setForeground(Color.RED);
            contraseñaActual.setForeground(Color.GREEN);
            return;
        }
        
        if(!contraseñaActualEsValida()){
            barraEstado.setText(" Verifique la contraseña actual");
            contraseñaActual.setForeground(Color.RED);
            confirmarContraseña.setForeground(Color.GREEN);
            nuevaContraseña.setForeground(Color.GREEN);        
            botonCambiarContraseña.setEnabled(false);
            return;
        }   
                        
        barraEstado.setText(" Puede cambiar la contraseña sin nigun problema");
        nuevaContraseña.setForeground(Color.GREEN); 
        confirmarContraseña.setForeground(Color.GREEN);
        contraseñaActual.setForeground(Color.GREEN);
        botonCambiarContraseña.setEnabled(true);
    }
    
    private void appendToSelectedtPasswordField(String digito){
        String temp = selectedPasswordField.getText();
        if(temp.length()< maxLenght){
            selectedPasswordField.setText(selectedPasswordField.getText() + digito);
            System.out.println(selectedPasswordField.getText());
        }
        actualizarEstadoComponentes();
    } 
    
    //Botones
    
    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        appendToSelectedtPasswordField("1");
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        appendToSelectedtPasswordField("2");
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        appendToSelectedtPasswordField("3");
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        appendToSelectedtPasswordField("4");
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        appendToSelectedtPasswordField("5");
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
        appendToSelectedtPasswordField("6");
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        appendToSelectedtPasswordField("7");
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        appendToSelectedtPasswordField("8");
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
        appendToSelectedtPasswordField("9");
    }//GEN-LAST:event_boton9ActionPerformed

    private void contraseñaActualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseñaActualMouseClicked
        selectedPasswordField = (JPasswordField) evt.getComponent();
        contraseñaActual.setText("");
        actualizarEstadoComponentes();
    }//GEN-LAST:event_contraseñaActualMouseClicked

    private void nuevaContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevaContraseñaMouseClicked
        selectedPasswordField = (JPasswordField) evt.getComponent();
        nuevaContraseña.setText("");
        confirmarContraseña.setText("");
        actualizarEstadoComponentes();
    }//GEN-LAST:event_nuevaContraseñaMouseClicked

    private void confirmarContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarContraseñaMouseClicked
        selectedPasswordField = (JPasswordField) evt.getComponent();
        confirmarContraseña.setText("");
        actualizarEstadoComponentes();
    }//GEN-LAST:event_confirmarContraseñaMouseClicked

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarContraseñaActionPerformed
        currentPassword = nuevaContraseña.getText();
        empleado.setPassword(currentPassword);
        //* DaoEmpleado.update(empleado);
        dispose();
    }//GEN-LAST:event_botonCambiarContraseñaActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoCambiarContraseña dialog = new DialogoCambiarContraseña(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConfirmarContraseña;
    private javax.swing.JLabel ContraseñaActual;
    private javax.swing.JLabel NuevaContraseña;
    private javax.swing.JLabel barraEstado;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JButton boton9;
    private javax.swing.JButton botonCambiarContraseña;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JPasswordField confirmarContraseña;
    private javax.swing.JPasswordField contraseñaActual;
    private javax.swing.JPasswordField nuevaContraseña;
    private javax.swing.JSeparator separador;
    private javax.swing.JPanel teclado;
    // End of variables declaration//GEN-END:variables
}
