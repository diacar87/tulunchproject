package presentacion.vista;

//import accesoDatos.dao.DaoEmpleado;
//import accesoDatos.dao.DaoProducto;
import accesoDatos.util.Log;
import accesoDatos.vo.Empleado;
import accesoDatos.vo.Pedido;
import accesoDatos.vo.Producto;
import java.awt.Dimension;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import presentacion.util.Ventana;
import javax.swing.table.DefaultTableModel;

public class VistaMesero extends javax.swing.JFrame {
    
    private DialogoCambiarContraseña cambiarContraseña = null;
    // Panel Menu
    private List<JButton> botones = new ArrayList<JButton>();
    private List<JLabel> labels = new ArrayList<JLabel>();
    private List<Producto> menu = new ArrayList<Producto>();
    // Panel Pedidos
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private Empleado empleado = null;
    private int mesaActual = 0;
    
    public VistaMesero(Empleado empleado) {
            initComponents();
            Ventana.pantallaCompleta(this);
            this.empleado = empleado;
            cargarImagenes(panelBebidas);
            Log.setEvento("Cliente","INFO","Se Ejecuta Interfaz de Mesero.");
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        tituloMenu = new javax.swing.JLabel();
        tabProductos = new javax.swing.JTabbedPane();
        scrollSopas = new javax.swing.JScrollPane();
        panelSopas = new javax.swing.JPanel();
        scrollPlatosFuertes = new javax.swing.JScrollPane();
        panelPlatosFuertes = new javax.swing.JPanel();
        scrollEnsaladas = new javax.swing.JScrollPane();
        PanelEnsaladas = new javax.swing.JPanel();
        scrollAcompañamientos = new javax.swing.JScrollPane();
        panelAcompañamientos = new javax.swing.JPanel();
        scrollPostres = new javax.swing.JScrollPane();
        panelPostres = new javax.swing.JPanel();
        scrollBebidas = new javax.swing.JScrollPane();
        panelBebidas = new javax.swing.JPanel();
        sliderTamañoImagen = new javax.swing.JSlider();
        panelEstado = new javax.swing.JPanel();
        barraEstado = new javax.swing.JLabel();
        botonCambiarPassword = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelPedidos = new javax.swing.JPanel();
        tabMesas = new javax.swing.JTabbedPane();
        scrollItems = new javax.swing.JScrollPane();
        tablaItems = new javax.swing.JTable();
        botonEnviaraCocina = new javax.swing.JButton();
        tituloMesas = new javax.swing.JLabel();
        botonBorrarPedido = new javax.swing.JButton();
        botonQuitarItem = new javax.swing.JButton();
        scrollComentario = new javax.swing.JScrollPane();
        areaComentario = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tu Lunch Restaurant Manager - Mesero");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        panelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tituloMenu.setFont(new java.awt.Font("Tahoma", 0, 18));
        tituloMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloMenu.setText("MENU DEL DIA");
        tituloMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabProductos.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabProductos.setFont(new java.awt.Font("Tahoma", 0, 14));
        tabProductos.setInheritsPopupMenu(true);
        tabProductos.setName("Postre"); // NOI18N
        tabProductos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabProductosStateChanged(evt);
            }
        });

        scrollSopas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSopas.setName("Sopa"); // NOI18N

        panelSopas.setName("Sopa"); // NOI18N

        javax.swing.GroupLayout panelSopasLayout = new javax.swing.GroupLayout(panelSopas);
        panelSopas.setLayout(panelSopasLayout);
        panelSopasLayout.setHorizontalGroup(
            panelSopasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        panelSopasLayout.setVerticalGroup(
            panelSopasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        scrollSopas.setViewportView(panelSopas);

        tabProductos.addTab("     Sopas     ", scrollSopas);

        scrollPlatosFuertes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPlatosFuertes.setName("Plato Fuerte"); // NOI18N

        panelPlatosFuertes.setName("Plato Fuerte"); // NOI18N

        javax.swing.GroupLayout panelPlatosFuertesLayout = new javax.swing.GroupLayout(panelPlatosFuertes);
        panelPlatosFuertes.setLayout(panelPlatosFuertesLayout);
        panelPlatosFuertesLayout.setHorizontalGroup(
            panelPlatosFuertesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        panelPlatosFuertesLayout.setVerticalGroup(
            panelPlatosFuertesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        scrollPlatosFuertes.setViewportView(panelPlatosFuertes);

        tabProductos.addTab("      Platos     ", scrollPlatosFuertes);

        scrollEnsaladas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollEnsaladas.setName("Ensalada"); // NOI18N

        PanelEnsaladas.setName("Ensalada"); // NOI18N

        javax.swing.GroupLayout PanelEnsaladasLayout = new javax.swing.GroupLayout(PanelEnsaladas);
        PanelEnsaladas.setLayout(PanelEnsaladasLayout);
        PanelEnsaladasLayout.setHorizontalGroup(
            PanelEnsaladasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        PanelEnsaladasLayout.setVerticalGroup(
            PanelEnsaladasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        scrollEnsaladas.setViewportView(PanelEnsaladas);

        tabProductos.addTab("  Ensaladas  ", scrollEnsaladas);

        scrollAcompañamientos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAcompañamientos.setName("Acompañamiento"); // NOI18N

        panelAcompañamientos.setName("Acompañamiento"); // NOI18N

        javax.swing.GroupLayout panelAcompañamientosLayout = new javax.swing.GroupLayout(panelAcompañamientos);
        panelAcompañamientos.setLayout(panelAcompañamientosLayout);
        panelAcompañamientosLayout.setHorizontalGroup(
            panelAcompañamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        panelAcompañamientosLayout.setVerticalGroup(
            panelAcompañamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        scrollAcompañamientos.setViewportView(panelAcompañamientos);

        tabProductos.addTab(" Acompañamientos ", scrollAcompañamientos);

        scrollPostres.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPostres.setName("Postre"); // NOI18N

        panelPostres.setName("Postre"); // NOI18N

        javax.swing.GroupLayout panelPostresLayout = new javax.swing.GroupLayout(panelPostres);
        panelPostres.setLayout(panelPostresLayout);
        panelPostresLayout.setHorizontalGroup(
            panelPostresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        panelPostresLayout.setVerticalGroup(
            panelPostresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        scrollPostres.setViewportView(panelPostres);

        tabProductos.addTab("    Postres    ", scrollPostres);

        scrollBebidas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBebidas.setName("Bebida"); // NOI18N

        panelBebidas.setAutoscrolls(true);
        panelBebidas.setName("Bebida"); // NOI18N

        javax.swing.GroupLayout panelBebidasLayout = new javax.swing.GroupLayout(panelBebidas);
        panelBebidas.setLayout(panelBebidasLayout);
        panelBebidasLayout.setHorizontalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        panelBebidasLayout.setVerticalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        scrollBebidas.setViewportView(panelBebidas);

        tabProductos.addTab("Bebidas", scrollBebidas);

        tabProductos.setSelectedComponent(scrollBebidas);

        sliderTamañoImagen.setMaximum(200);
        sliderTamañoImagen.setMinimum(60);
        sliderTamañoImagen.setValue(130);
        sliderTamañoImagen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderTamañoImagenStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(tituloMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sliderTamañoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloMenu)
                .addGap(18, 18, 18)
                .addComponent(tabProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(sliderTamañoImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        barraEstado.setText("Barra de estado");

        botonCambiarPassword.setText("Cambiar mi contraseña");
        botonCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarPasswordActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        javax.swing.GroupLayout panelEstadoLayout = new javax.swing.GroupLayout(panelEstado);
        panelEstado.setLayout(panelEstadoLayout);
        panelEstadoLayout.setHorizontalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEstadoLayout.createSequentialGroup()
                .addComponent(barraEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCambiarPassword)
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addGap(52, 52, 52)
                .addComponent(jButton2)
                .addGap(53, 53, 53))
        );
        panelEstadoLayout.setVerticalGroup(
            panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(barraEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addComponent(botonCambiarPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        panelPedidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabMesas.setFont(new java.awt.Font("Tahoma", 0, 14));

        tablaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollItems.setViewportView(tablaItems);

        tabMesas.addTab("tab1", scrollItems);

        botonEnviaraCocina.setFont(new java.awt.Font("Tahoma", 0, 14));
        botonEnviaraCocina.setText("Enviar a Cocina");

        tituloMesas.setFont(new java.awt.Font("Tahoma", 0, 18));
        tituloMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloMesas.setText("MESAS A CARGO");

        botonBorrarPedido.setFont(new java.awt.Font("Tahoma", 0, 14));
        botonBorrarPedido.setText("Borrar Pedido");
        botonBorrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarPedidoActionPerformed(evt);
            }
        });

        botonQuitarItem.setFont(new java.awt.Font("Tahoma", 0, 14));
        botonQuitarItem.setText("Quitar Item");

        areaComentario.setColumns(20);
        areaComentario.setRows(5);
        scrollComentario.setViewportView(areaComentario);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPedidosLayout = new javax.swing.GroupLayout(panelPedidos);
        panelPedidos.setLayout(panelPedidosLayout);
        panelPedidosLayout.setHorizontalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollComentario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(botonQuitarItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(tabMesas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(tituloMesas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPedidosLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(botonBorrarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEnviaraCocina)))
                .addContainerGap())
        );
        panelPedidosLayout.setVerticalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloMesas)
                .addGap(18, 18, 18)
                .addComponent(tabMesas, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonQuitarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonBorrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonEnviaraCocina, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-979)/2, (screenSize.height-768)/2, 979, 768);
    }// </editor-fold>//GEN-END:initComponents

    public void cargarImagenes(JPanel panel){
        pack();
        int anchoDelPadre = (int) panel.getParent().getWidth();
        panel.setPreferredSize(new Dimension(anchoDelPadre, 10));
        botones.removeAll(botones);
        panel.removeAll();
        
        int espacioEntreBotones = 20;
        int tamañoDeBoton = sliderTamañoImagen.getValue();
        int margenIcono = tamañoDeBoton/5;
        int tamañoDeIcono = tamañoDeBoton - margenIcono;
        
        int localizacion = espacioEntreBotones + tamañoDeBoton;
        int filas = 0;
        int columnas = 0;
        
        String tipo = panel.getName();
        // * menu = DaoProducto.readAll();

        for(int i=0; i<menu.size(); i++){
            final int j=i;
            if (menu.get(i).getTipo().equals(tipo) && menu.get(i).getEstaEnMenu()){
                
                JButton botonProducto = new JButton();
                JLabel labelProducto = new JLabel();
                
                // Propiedades del boton
                botonProducto.setSize(tamañoDeBoton,tamañoDeBoton);
                botonProducto.setLocation(localizacion*columnas+espacioEntreBotones, localizacion*filas+espacioEntreBotones);
                botonProducto.setToolTipText(menu.get(i).getNombre());
                botonProducto.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        adicionarProducto(menu.get(j).getId());
                }
                });
                
                // Propiedades del label
                labelProducto.setSize(tamañoDeBoton, 15);
                labelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labelProducto.setText(menu.get(i).getNombre());   
                labelProducto.setLocation(localizacion*columnas+espacioEntreBotones, localizacion*filas+localizacion);
                
                // Imagen del boton
                ImageIcon imagenOriginal = menu.get(i).getFoto();
                if (imagenOriginal.getIconHeight()>imagenOriginal.getIconWidth())
                    botonProducto.setIcon(new ImageIcon(imagenOriginal.getImage().getScaledInstance(-1, tamañoDeIcono, Image.SCALE_DEFAULT))); 
                else
                    botonProducto.setIcon(new ImageIcon(imagenOriginal.getImage().getScaledInstance(tamañoDeIcono, -1, Image.SCALE_DEFAULT))); 
                
                // Ubicacion del proximo boton
                if( (columnas+2)*(localizacion)+espacioEntreBotones >= panel.getWidth() ){
                    filas++;
                    columnas = 0;
                }    
                else{
                    columnas++;
                }

                // Adicion del boton
                botones.add(botonProducto);
                labels.add(labelProducto);
                panel.add(botones.get(botones.size()-1));
                panel.add(labels.get(labels.size()-1));
                
                // Ampliacion del panel contenedor si es necesario
                if( botones.get(botones.size()-1).getLocation().getY()+tamañoDeBoton > panel.getParent().getHeight()){
                    pack();
                    panel.setPreferredSize(new Dimension( anchoDelPadre, panel.getHeight() + tamañoDeBoton));
                }  
            }
        }
        // Refresco del panel
        panel.updateUI();
    }
    
    private DefaultTableModel modeloTabla(){
        DefaultTableModel modelo = new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        );
        return modelo;
    }
   
    private void adicionarProducto(int id) {
        // * Producto productoSeleccionado = DaoProducto.read(id);
        // * System.out.println("Has seleccionado el producto:" + productoSeleccionado.getNombre());
        // * tablaItems.setModel(modeloTabla());
    }
    
    private void botonCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPasswordActionPerformed
        // * empleado = DaoEmpleado.read(1);
        if (cambiarContraseña == null){
            cambiarContraseña = new DialogoCambiarContraseña(this,true);
        }
        cambiarContraseña.resetAll();
        cambiarContraseña.setEmpleado(empleado);
        cambiarContraseña.pack();
        cambiarContraseña.setVisible(true);
        
        System.out.println("Password: "+empleado.getPassword());
    }//GEN-LAST:event_botonCambiarPasswordActionPerformed

    private void sliderTamañoImagenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderTamañoImagenStateChanged
        tabProductosStateChanged(evt);
}//GEN-LAST:event_sliderTamañoImagenStateChanged

    private void tabProductosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabProductosStateChanged
        JScrollPane scrollActual = (JScrollPane)tabProductos.getSelectedComponent();
        JPanel panelActual = (JPanel) scrollActual.getViewport().getComponent(0);
        cargarImagenes(panelActual);
}//GEN-LAST:event_tabProductosStateChanged

    private void botonBorrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarPedidoActionPerformed
        tabMesas.remove(tabMesas.getSelectedComponent());
    }//GEN-LAST:event_botonBorrarPedidoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int mesa = jComboBox1.getSelectedIndex() + 1;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formato.format(new Date());
        pedidos.add(new Pedido(mesa,empleado,fecha));
        
        JTable tabla = new JTable(modeloTabla());
        tabla.setName(""+mesa);
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabla);
        tabMesas.add(""+mesa,scroll);
        
        JScrollPane panel = (JScrollPane)tabMesas.getSelectedComponent();
        JTable tabla2 = (JTable)panel.getViewport().getView();
        System.out.println(tabla2.getName());
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }
    
    public static void main(final Empleado empleado) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMesero(empleado).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEnsaladas;
    private javax.swing.JTextArea areaComentario;
    private javax.swing.JLabel barraEstado;
    private javax.swing.JButton botonBorrarPedido;
    private javax.swing.JButton botonCambiarPassword;
    private javax.swing.JButton botonEnviaraCocina;
    private javax.swing.JButton botonQuitarItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel panelAcompañamientos;
    private javax.swing.JPanel panelBebidas;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JPanel panelPlatosFuertes;
    private javax.swing.JPanel panelPostres;
    private javax.swing.JPanel panelSopas;
    private javax.swing.JScrollPane scrollAcompañamientos;
    private javax.swing.JScrollPane scrollBebidas;
    private javax.swing.JScrollPane scrollComentario;
    private javax.swing.JScrollPane scrollEnsaladas;
    private javax.swing.JScrollPane scrollItems;
    private javax.swing.JScrollPane scrollPlatosFuertes;
    private javax.swing.JScrollPane scrollPostres;
    private javax.swing.JScrollPane scrollSopas;
    private javax.swing.JSlider sliderTamañoImagen;
    private javax.swing.JTabbedPane tabMesas;
    private javax.swing.JTabbedPane tabProductos;
    private javax.swing.JTable tablaItems;
    private javax.swing.JLabel tituloMenu;
    private javax.swing.JLabel tituloMesas;
    // End of variables declaration//GEN-END:variables
    
}
