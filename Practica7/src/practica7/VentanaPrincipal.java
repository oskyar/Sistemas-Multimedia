/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica7;

import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Óscar
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        VentanaInterna vi = new VentanaInterna(); 
        escritorio.add(vi); 
        vi.setVisible(true); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        BotonesMenu = new javax.swing.ButtonGroup();
        GrupoColores = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        BotonesFiguras = new javax.swing.JToolBar();
        botonLapiz = new javax.swing.JToggleButton();
        botonLinea = new javax.swing.JToggleButton();
        botonRectangulo = new javax.swing.JToggleButton();
        botonOvalo = new javax.swing.JToggleButton();
        cuerpo = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        pie = new javax.swing.JPanel();
        panelAtributos = new javax.swing.JPanel();
        contenedorColores = new javax.swing.JPanel();
        panelColores = new javax.swing.JPanel();
        botonColorRojo = new javax.swing.JButton();
        botonColorNegro = new javax.swing.JButton();
        botonColorAzul = new javax.swing.JButton();
        botonColorBlanco = new javax.swing.JButton();
        botonColorVerde = new javax.swing.JButton();
        botonColorAmarillo = new javax.swing.JButton();
        contenedorGrosor = new javax.swing.JPanel();
        panelGrosor = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        contenedorEditarRelleno = new javax.swing.JPanel();
        panelRelleno = new javax.swing.JPanel();
        checkboxRelleno = new javax.swing.JCheckBox();
        checkboxEditar = new javax.swing.JCheckBox();
        panelLabelFigura = new javax.swing.JPanel();
        labelFigura = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        Nuevo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        edicion = new javax.swing.JMenu();
        verBarraEstado = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        BotonesFiguras.setRollover(true);

        BotonesMenu.add(botonLapiz);
        botonLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Lapiz.gif"))); // NOI18N
        botonLapiz.setFocusable(false);
        botonLapiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLapiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonLapiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonLapizMouseClicked(evt);
            }
        });
        BotonesFiguras.add(botonLapiz);

        BotonesMenu.add(botonLinea);
        botonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Linea.gif"))); // NOI18N
        botonLinea.setFocusable(false);
        botonLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonLinea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonLineaMouseClicked(evt);
            }
        });
        BotonesFiguras.add(botonLinea);

        BotonesMenu.add(botonRectangulo);
        botonRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Rectangulo.gif"))); // NOI18N
        botonRectangulo.setFocusable(false);
        botonRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonRectangulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRectanguloMouseClicked(evt);
            }
        });
        BotonesFiguras.add(botonRectangulo);

        BotonesMenu.add(botonOvalo);
        botonOvalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ovalo.gif"))); // NOI18N
        botonOvalo.setFocusable(false);
        botonOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonOvalo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonOvaloMouseClicked(evt);
            }
        });
        BotonesFiguras.add(botonOvalo);

        jPanel2.add(BotonesFiguras);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        cuerpo.setPreferredSize(new java.awt.Dimension(772, 400));
        cuerpo.setLayout(new java.awt.BorderLayout());
        cuerpo.add(escritorio, java.awt.BorderLayout.CENTER);

        getContentPane().add(cuerpo, java.awt.BorderLayout.CENTER);

        pie.setLayout(new java.awt.BorderLayout());

        panelAtributos.setPreferredSize(new java.awt.Dimension(831, 100));
        panelAtributos.setLayout(new javax.swing.BoxLayout(panelAtributos, javax.swing.BoxLayout.LINE_AXIS));

        contenedorColores.setMaximumSize(new java.awt.Dimension(125, 90));
        contenedorColores.setMinimumSize(new java.awt.Dimension(125, 90));
        contenedorColores.setPreferredSize(new java.awt.Dimension(125, 90));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        contenedorColores.setLayout(flowLayout1);

        panelColores.setBorder(javax.swing.BorderFactory.createTitledBorder("Color"));
        panelColores.setMaximumSize(new java.awt.Dimension(89, 90));
        panelColores.setMinimumSize(new java.awt.Dimension(89, 90));
        panelColores.setPreferredSize(new java.awt.Dimension(125, 90));
        panelColores.setLayout(new java.awt.GridBagLayout());

        botonColorRojo.setBackground(new java.awt.Color(255, 0, 0));
        botonColorRojo.setBorder(null);
        GrupoColores.add(botonColorRojo);
        botonColorRojo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonColorRojo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonColorRojo.setMaximumSize(new java.awt.Dimension(15, 15));
        botonColorRojo.setMinimumSize(new java.awt.Dimension(15, 15));
        botonColorRojo.setPreferredSize(new java.awt.Dimension(15, 15));
        botonColorRojo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorRojoMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        panelColores.add(botonColorRojo, gridBagConstraints);

        botonColorNegro.setBackground(new java.awt.Color(0, 0, 0));
        botonColorNegro.setBorder(null);
        GrupoColores.add(botonColorNegro);
        botonColorNegro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonColorNegro.setMaximumSize(new java.awt.Dimension(15, 15));
        botonColorNegro.setMinimumSize(new java.awt.Dimension(15, 15));
        botonColorNegro.setPreferredSize(new java.awt.Dimension(15, 15));
        botonColorNegro.setSelected(true);
        botonColorNegro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorNegroMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        panelColores.add(botonColorNegro, gridBagConstraints);

        botonColorAzul.setBackground(new java.awt.Color(0, 0, 255));
        botonColorAzul.setBorder(null);
        GrupoColores.add(botonColorAzul);
        botonColorAzul.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonColorAzul.setMaximumSize(new java.awt.Dimension(15, 15));
        botonColorAzul.setMinimumSize(new java.awt.Dimension(15, 15));
        botonColorAzul.setPreferredSize(new java.awt.Dimension(15, 15));
        botonColorAzul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorAzulMouseClicked(evt);
            }
        });
        botonColorAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorAzulActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 15);
        panelColores.add(botonColorAzul, gridBagConstraints);

        botonColorBlanco.setBackground(new java.awt.Color(255, 255, 255));
        botonColorBlanco.setBorder(null);
        GrupoColores.add(botonColorBlanco);
        botonColorBlanco.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonColorBlanco.setMaximumSize(new java.awt.Dimension(15, 15));
        botonColorBlanco.setMinimumSize(new java.awt.Dimension(15, 15));
        botonColorBlanco.setPreferredSize(new java.awt.Dimension(15, 15));
        botonColorBlanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorBlancoMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 15, 0);
        panelColores.add(botonColorBlanco, gridBagConstraints);

        botonColorVerde.setBackground(new java.awt.Color(0, 255, 0));
        botonColorVerde.setBorder(null);
        GrupoColores.add(botonColorVerde);
        botonColorVerde.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonColorVerde.setMaximumSize(new java.awt.Dimension(15, 15));
        botonColorVerde.setMinimumSize(new java.awt.Dimension(15, 15));
        botonColorVerde.setPreferredSize(new java.awt.Dimension(15, 15));
        botonColorVerde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorVerdeMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 15);
        panelColores.add(botonColorVerde, gridBagConstraints);

        botonColorAmarillo.setBackground(new java.awt.Color(255, 255, 0));
        botonColorAmarillo.setBorder(null);
        GrupoColores.add(botonColorAmarillo);
        botonColorAmarillo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonColorAmarillo.setMaximumSize(new java.awt.Dimension(15, 15));
        botonColorAmarillo.setMinimumSize(new java.awt.Dimension(15, 15));
        botonColorAmarillo.setPreferredSize(new java.awt.Dimension(15, 15));
        botonColorAmarillo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorAmarilloMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 0);
        panelColores.add(botonColorAmarillo, gridBagConstraints);

        contenedorColores.add(panelColores);

        panelAtributos.add(contenedorColores);

        contenedorGrosor.setBorder(javax.swing.BorderFactory.createTitledBorder("Grosor"));
        contenedorGrosor.setMaximumSize(new java.awt.Dimension(90, 90));
        contenedorGrosor.setMinimumSize(new java.awt.Dimension(90, 90));
        contenedorGrosor.setPreferredSize(new java.awt.Dimension(90, 90));
        contenedorGrosor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        panelGrosor.setMaximumSize(new java.awt.Dimension(70, 50));
        panelGrosor.setMinimumSize(new java.awt.Dimension(60, 50));
        panelGrosor.setPreferredSize(new java.awt.Dimension(60, 50));

        jSpinner1.setMaximumSize(new java.awt.Dimension(50, 28));
        jSpinner1.setMinimumSize(new java.awt.Dimension(50, 28));
        jSpinner1.setPreferredSize(new java.awt.Dimension(50, 28));

        javax.swing.GroupLayout panelGrosorLayout = new javax.swing.GroupLayout(panelGrosor);
        panelGrosor.setLayout(panelGrosorLayout);
        panelGrosorLayout.setHorizontalGroup(
            panelGrosorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(panelGrosorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelGrosorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelGrosorLayout.setVerticalGroup(
            panelGrosorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(panelGrosorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelGrosorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        contenedorGrosor.add(panelGrosor);

        panelAtributos.add(contenedorGrosor);

        contenedorEditarRelleno.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));
        contenedorEditarRelleno.setMaximumSize(new java.awt.Dimension(100, 90));
        contenedorEditarRelleno.setMinimumSize(new java.awt.Dimension(95, 90));
        contenedorEditarRelleno.setPreferredSize(new java.awt.Dimension(95, 90));
        contenedorEditarRelleno.setLayout(new java.awt.GridLayout(0, 1));

        panelRelleno.setBorder(null);
        panelRelleno.setToolTipText("");
        panelRelleno.setMaximumSize(new java.awt.Dimension(90, 80));
        panelRelleno.setMinimumSize(new java.awt.Dimension(90, 80));
        panelRelleno.setPreferredSize(new java.awt.Dimension(90, 80));
        panelRelleno.setLayout(new java.awt.GridLayout(2, 1));

        checkboxRelleno.setText("Relleno");
        checkboxRelleno.setActionCommand("");
        checkboxRelleno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        checkboxRelleno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkboxRellenoMouseClicked(evt);
            }
        });
        panelRelleno.add(checkboxRelleno);

        checkboxEditar.setText("Editar");
        checkboxEditar.setActionCommand("");
        checkboxEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        checkboxEditar.setMaximumSize(new java.awt.Dimension(69, 10));
        checkboxEditar.setMinimumSize(new java.awt.Dimension(69, 10));
        checkboxEditar.setPreferredSize(new java.awt.Dimension(69, 10));
        panelRelleno.add(checkboxEditar);

        contenedorEditarRelleno.add(panelRelleno);

        panelAtributos.add(contenedorEditarRelleno);

        pie.add(panelAtributos, java.awt.BorderLayout.CENTER);

        panelLabelFigura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelLabelFigura.setLayout(new javax.swing.BoxLayout(panelLabelFigura, javax.swing.BoxLayout.LINE_AXIS));

        labelFigura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFigura.setText("labelFigura");
        panelLabelFigura.add(labelFigura);

        pie.add(panelLabelFigura, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pie, java.awt.BorderLayout.PAGE_END);

        archivo.setText("Archivo");

        Nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        archivo.add(Nuevo);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        archivo.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        archivo.add(jMenuItem2);

        menu.add(archivo);

        edicion.setText("Edición");

        verBarraEstado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        verBarraEstado.setSelected(true);
        verBarraEstado.setText("Ver barra estado");
        verBarraEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verBarraEstadoMouseClicked(evt);
            }
        });
        verBarraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraEstadoActionPerformed(evt);
            }
        });
        verBarraEstado.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                verBarraEstadoMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        edicion.add(verBarraEstado);

        menu.add(edicion);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLineaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLineaMouseClicked
        labelFigura.setText("Línea");
        botonLinea.setSelected(true);
  //      lienzo.setForma(Lienzo.LINEA);
    }//GEN-LAST:event_botonLineaMouseClicked

    private void botonRectanguloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRectanguloMouseClicked
        labelFigura.setText("Rectángulo");
        botonRectangulo.setSelected(true);
  //      lienzo.setForma(Lienzo.RECTANGULO);
    }//GEN-LAST:event_botonRectanguloMouseClicked

    private void botonOvaloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonOvaloMouseClicked
        labelFigura.setText("Ovalo");
        botonOvalo.setSelected(true);
   //     lienzo.setForma(Lienzo.ELIPSE);
    }//GEN-LAST:event_botonOvaloMouseClicked

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        VentanaInterna vi = new VentanaInterna(); 
        escritorio.add(vi); 
        vi.setVisible(true); 
    }//GEN-LAST:event_NuevoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    JFileChooser dlg = new JFileChooser(); 
        int resp = dlg.showSaveDialog(this); 
        if( resp == JFileChooser.APPROVE_OPTION) { 
         File f = dlg.getSelectedFile(); 
         //Código 
        } 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void botonColorNegroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorNegroMouseClicked
    //    lienzo.setColor(Color.black);
    }//GEN-LAST:event_botonColorNegroMouseClicked

    private void botonColorRojoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorRojoMouseClicked
    //     lienzo.setColor(Color.red);
    }//GEN-LAST:event_botonColorRojoMouseClicked

    private void botonColorAzulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorAzulMouseClicked
    //    lienzo.setColor(Color.blue);
    }//GEN-LAST:event_botonColorAzulMouseClicked

    private void botonColorBlancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorBlancoMouseClicked
    //    lienzo.setColor(Color.white);
    }//GEN-LAST:event_botonColorBlancoMouseClicked

    private void botonColorAmarilloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorAmarilloMouseClicked
    //    lienzo.setColor(Color.yellow);
    }//GEN-LAST:event_botonColorAmarilloMouseClicked

    private void botonColorVerdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorVerdeMouseClicked
    //    lienzo.setColor(Color.green);
    }//GEN-LAST:event_botonColorVerdeMouseClicked

    private void verBarraEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verBarraEstadoMouseClicked

    }//GEN-LAST:event_verBarraEstadoMouseClicked

    private void verBarraEstadoMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_verBarraEstadoMenuKeyPressed
      /*  if(verBarraEstado.isSelected()){
            pie.setVisible(false);
            pie.setEnabled(false);
            verBarraEstado.setSelected(false);
            System.out.println("SELECT");
        }else{
            pie.setVisible(true);
            pie.setEnabled(true);
            verBarraEstado.setSelected(true);
            System.out.println("NO SELECT");
        }
        lienzo.repaint();
        */
    }//GEN-LAST:event_verBarraEstadoMenuKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    JFileChooser dlg = new JFileChooser(); 
        int resp = dlg.showOpenDialog(this); 
        if( resp == JFileChooser.APPROVE_OPTION) { 
         File f = dlg.getSelectedFile(); 
         //Código 
        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void verBarraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraEstadoActionPerformed
    
        if(!verBarraEstado.isSelected()){
            panelLabelFigura.setVisible(false);        
        }else{
            panelLabelFigura.setVisible(true);
        }
    }//GEN-LAST:event_verBarraEstadoActionPerformed

    private void botonColorAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorAzulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonColorAzulActionPerformed

    private void botonLapizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLapizMouseClicked
        labelFigura.setText("Lápiz");
        botonLapiz.setSelected(true);
    //    lienzo.setForma(Lienzo.PUNTO);
    }//GEN-LAST:event_botonLapizMouseClicked

    private void checkboxRellenoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkboxRellenoMouseClicked
        /*    if(lienzo.isRelleno()){
            lienzo.setRelleno(false);
        }else{
            lienzo.setRelleno(true);
        }
        */
    }//GEN-LAST:event_checkboxRellenoMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar BotonesFiguras;
    private javax.swing.ButtonGroup BotonesMenu;
    private javax.swing.ButtonGroup GrupoColores;
    private javax.swing.JMenuItem Nuevo;
    private javax.swing.JMenu archivo;
    private javax.swing.JButton botonColorAmarillo;
    private javax.swing.JButton botonColorAzul;
    private javax.swing.JButton botonColorBlanco;
    private javax.swing.JButton botonColorNegro;
    private javax.swing.JButton botonColorRojo;
    private javax.swing.JButton botonColorVerde;
    private javax.swing.JToggleButton botonLapiz;
    private javax.swing.JToggleButton botonLinea;
    private javax.swing.JToggleButton botonOvalo;
    private javax.swing.JToggleButton botonRectangulo;
    private javax.swing.JCheckBox checkboxEditar;
    private javax.swing.JCheckBox checkboxRelleno;
    private javax.swing.JPanel contenedorColores;
    private javax.swing.JPanel contenedorEditarRelleno;
    private javax.swing.JPanel contenedorGrosor;
    private javax.swing.JPanel cuerpo;
    private javax.swing.JMenu edicion;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel labelFigura;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPanel panelAtributos;
    private javax.swing.JPanel panelColores;
    private javax.swing.JPanel panelGrosor;
    private javax.swing.JPanel panelLabelFigura;
    private javax.swing.JPanel panelRelleno;
    private javax.swing.JPanel pie;
    private javax.swing.JCheckBoxMenuItem verBarraEstado;
    // End of variables declaration//GEN-END:variables
}
