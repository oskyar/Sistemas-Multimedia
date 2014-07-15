/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal;

import Utils.JOptionPaneMultiInput;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import practicaFinal.VentanasInternas.VentanaInternaCamara;
import practicaFinal.VentanasInternas.VentanaInternaGrabador;
import practicaFinal.VentanasInternas.VentanaInternaImagen;
import practicaFinal.VentanasInternas.VentanaInternaJMFPlayer;
import practicaFinal.VentanasInternas.VentanaInternaReproductor;
import practicaFinal.filefilter.AVIVideoFileFilter;
import practicaFinal.filefilter.GIFImageFileFilter;
import practicaFinal.filefilter.JPEGImageFileFilter;
import practicaFinal.filefilter.JPGImageFileFilter;
import practicaFinal.filefilter.MIDISoundFileFilter;
import practicaFinal.filefilter.MP3SoundFileFilter;
import practicaFinal.filefilter.PNGImageFileFilter;
import practicaFinal.filefilter.UtilFileFilter;
import practicaFinal.filefilter.WAVSoundFileFilter;
import practicaFinal.filtros.MultiplicacionOp;
import practicaFinal.filtros.RestaOp;
import practicaFinal.filtros.SobelOp;
import practicaFinal.filtros.UmbralizacionOp;
import practicaFinal.shapes.IOShape;
import sm.image.KernelProducer;
import sm.image.ThresholdOp;

/**
 * Interfaz de la aplicación Paint 2.0 Professional - by Óscar Zafra.
 * 
 * También tiene la mayoría de la funcionalidad del programa.
 * 
 * @author oskyar (Óscar Zafra).
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Guardo la última ventana interna creada
    private VentanaInternaImagen vi;
    private int numVentanas;
    private int thresholdingType;
    private Color thresholdingColor;
    public final static int SHOW_TOOLBAR_IMAGE = 0;
    public final static int SHOW_TOOLBAR_SOUND = 1;
    public final static int SHOW_TOOLBAR_JMF = 2;
    public final static int SHOW_TOOLBAR_CAMERA = 3;

    private static VentanaPrincipal instance = new VentanaPrincipal();

    private VentanaPrincipal() {
        initComponents();
        this.setTitle("PAINT 2.0 Professional - Óscar Zafra");
        numVentanas = 0;
        botonLapiz.setSelected(true);
        barraColor.setVisible(true);
        barraImagen.setVisible(true);
        Lienzo.setStrokeColor(Color.BLACK);
        Lienzo.setStrokeType(Lienzo.STROKE_CONTINUOUS);
        Lienzo.setStrokeWidth(1.0f);
        Lienzo.setFillColor(Color.BLACK);
        Lienzo.setGradientColor(Color.WHITE);
        Lienzo.setFillType(Lienzo.TYPE_FILL_NONE);
        Lienzo.setForma(Lienzo.PUNTO);
        strokeColor.setBackground(Color.BLACK);
        gradientColor.setBackground(null);
        labelTextGradientColor.setVisible(false);
        gradientColor.setVisible(false);
        labelTextFillColor.setVisible(false);
        fillColor.setVisible(false);
        Lienzo.setFillColor(fillColor.getBackground());
        Lienzo.setGradientColor(gradientColor.getBackground());
        comboBoxUmbralizacionActionPerformed(null);
        //Un evento creado por mi para saber si se está presionando la tecla Control
        figureList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.showToolsBarsOrNot(VentanaPrincipal.SHOW_TOOLBAR_SOUND);
        //escritorio.dispatchEvent(new MouseEvent(escritorio,MouseEvent.MOUSE_RELEASED, 0, MouseEvent.NOBUTTON, 0, 0, 0, false));
        //Evento para tener en cuenta cuando se pusa la tecla CONTROL del teclado.
        //Usada para seleccionar o deseleccionar shapes del lienzo.
        keyboardEvent();
    }

    /**
     * Devuelve una instancia de Ventana Principal para poder tener acceso a sus
     * componentes de la interfaz.
     *
     * Es lo denominado un Singleton.
     *
     * @return devuelve la única instancia de VentanaPrincipal.
     */
    public static VentanaPrincipal getInstance() {
        return instance;
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
        grupoPaletas = new javax.swing.ButtonGroup();
        coloresUmbralizacion = new javax.swing.ButtonGroup();
        paletaOpciones = new javax.swing.JPanel();
        botonesArchivo = new javax.swing.JToolBar();
        iconNew = new javax.swing.JButton();
        iconOpen = new javax.swing.JButton();
        iconSave = new javax.swing.JButton();
        botonesFiguras = new javax.swing.JToolBar();
        botonLapiz = new javax.swing.JToggleButton();
        botonLinea = new javax.swing.JToggleButton();
        botonRectangulo = new javax.swing.JToggleButton();
        botonRectanguloRedondeado = new javax.swing.JToggleButton();
        botonOvalo = new javax.swing.JToggleButton();
        botonCurvaControl = new javax.swing.JToggleButton();
        botonCurvaCubicaSegmentada = new javax.swing.JToggleButton();
        botonesMultimedia = new javax.swing.JToolBar();
        iconWebcam = new javax.swing.JButton();
        iconTakeScreenshot = new javax.swing.JButton();
        iconSoundRecorder = new javax.swing.JButton();
        cuerpo = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        panelDerechoImagen = new javax.swing.JPanel();
        contenedorFiguras = new javax.swing.JPanel();
        figureList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        cloneShape = new javax.swing.JButton();
        removeShape = new javax.swing.JButton();
        reloadShapes = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        pie = new javax.swing.JPanel();
        paneles = new javax.swing.JPanel();
        barraImagen = new javax.swing.JToolBar();
        contenedorBrillo = new javax.swing.JPanel();
        sliderBrillo = new javax.swing.JSlider();
        contenedorEfecto = new javax.swing.JPanel();
        comboBoxEffectsList = new javax.swing.JComboBox();
        contenedorContraste = new javax.swing.JPanel();
        botonContraste = new javax.swing.JButton();
        botonIluminar = new javax.swing.JButton();
        botonOscurecer = new javax.swing.JButton();
        contenedorRotacion = new javax.swing.JPanel();
        sliderRotacion = new javax.swing.JSlider();
        botonRotacion90 = new javax.swing.JButton();
        botonRotacion180 = new javax.swing.JButton();
        botonRotacion270 = new javax.swing.JButton();
        contenedorEscala = new javax.swing.JPanel();
        botonAumentar = new javax.swing.JButton();
        botonDisminuir = new javax.swing.JButton();
        contenedorUmbralizacion = new javax.swing.JPanel();
        sliderUmbralizacion = new javax.swing.JSlider();
        comboBoxUmbralizacion = new javax.swing.JComboBox();
        buttonThresholdingRed = new javax.swing.JButton();
        buttonThresholdingBlue = new javax.swing.JButton();
        buttonThresholdingGreen = new javax.swing.JButton();
        buttonThresholdingColorPalette = new javax.swing.JButton();
        barraColor = new javax.swing.JToolBar();
        contenedorColores = new javax.swing.JPanel();
        panelColores = new javax.swing.JPanel();
        botonColorRojo = new javax.swing.JButton();
        botonColorNegro = new javax.swing.JButton();
        botonColorAzul = new javax.swing.JButton();
        botonColorBlanco = new javax.swing.JButton();
        botonColorVerde = new javax.swing.JButton();
        botonColorAmarillo = new javax.swing.JButton();
        contenedorRelleno = new javax.swing.JPanel();
        comboBoxFillList = new javax.swing.JComboBox();
        labelTextFillColor = new javax.swing.JLabel();
        gradientColor = new javax.swing.JButton();
        fillColor = new javax.swing.JButton();
        labelTextGradientColor = new javax.swing.JLabel();
        contenedorBorde = new javax.swing.JPanel();
        comboBoxStrokeList = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        grosor = new javax.swing.JSpinner();
        labelTextBorderColor = new javax.swing.JLabel();
        strokeColor = new javax.swing.JButton();
        contenedorEstiloBorde = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxStyleStrokeJoinList = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboBoxStyleStrokeCapList = new javax.swing.JComboBox();
        panelLabelFigura = new javax.swing.JPanel();
        labelFigura = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        menuVer = new javax.swing.JMenu();
        verBarraEstado = new javax.swing.JCheckBoxMenuItem();
        showToolBarColor = new javax.swing.JCheckBoxMenuItem();
        showToolBarImage = new javax.swing.JCheckBoxMenuItem();
        showToolBarMultimedia = new javax.swing.JCheckBoxMenuItem();
        menuImagen = new javax.swing.JMenu();
        menuRescaleOp = new javax.swing.JMenuItem();
        menuConvolveOp = new javax.swing.JMenuItem();
        umbralizacion = new javax.swing.JMenuItem();
        restar = new javax.swing.JMenuItem();
        multiplicar = new javax.swing.JMenuItem();
        sobelMenu = new javax.swing.JMenuItem();
        negative = new javax.swing.JMenuItem();
        menuChangeGrey = new javax.swing.JMenuItem();
        menuCloneImage = new javax.swing.JMenuItem();
        menuArtFilter = new javax.swing.JMenuItem();
        menuMultimedia = new javax.swing.JMenu();
        menuSoundRecorder = new javax.swing.JMenuItem();
        menuTakeScreenshot = new javax.swing.JMenuItem();
        menuWebcam = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        paletaOpciones.setLayout(new javax.swing.BoxLayout(paletaOpciones, javax.swing.BoxLayout.LINE_AXIS));

        botonesArchivo.setFloatable(false);
        botonesArchivo.setRollover(true);
        botonesArchivo.setMaximumSize(new java.awt.Dimension(130, 40));
        botonesArchivo.setPreferredSize(new java.awt.Dimension(110, 40));

        iconNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NuevoBoceto.GIF"))); // NOI18N
        iconNew.setToolTipText("Archivo nuevo");
        iconNew.setFocusable(false);
        iconNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconNew.setPreferredSize(new java.awt.Dimension(36, 36));
        iconNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        iconNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconNewActionPerformed(evt);
            }
        });
        botonesArchivo.add(iconNew);

        iconOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AbrirMedio.png"))); // NOI18N
        iconOpen.setToolTipText("Abrir archivo multimedia");
        iconOpen.setFocusable(false);
        iconOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconOpen.setMinimumSize(new java.awt.Dimension(24, 24));
        iconOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        iconOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconOpenActionPerformed(evt);
            }
        });
        botonesArchivo.add(iconOpen);

        iconSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.gif"))); // NOI18N
        iconSave.setToolTipText("Guardar");
        iconSave.setFocusable(false);
        iconSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconSave.setMinimumSize(new java.awt.Dimension(24, 24));
        iconSave.setPreferredSize(new java.awt.Dimension(36, 36));
        iconSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        iconSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconSaveActionPerformed(evt);
            }
        });
        botonesArchivo.add(iconSave);

        paletaOpciones.add(botonesArchivo);

        botonesFiguras.setMaximumSize(new java.awt.Dimension(265, 40));
        botonesFiguras.setMinimumSize(new java.awt.Dimension(220, 40));

        BotonesMenu.add(botonLapiz);
        botonLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Lapiz.gif"))); // NOI18N
        botonLapiz.setToolTipText("Punto");
        botonLapiz.setFocusable(false);
        botonLapiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLapiz.setMaximumSize(new java.awt.Dimension(36, 36));
        botonLapiz.setPreferredSize(new java.awt.Dimension(36, 36));
        botonLapiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonLapiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonLapizMouseClicked(evt);
            }
        });
        botonesFiguras.add(botonLapiz);

        BotonesMenu.add(botonLinea);
        botonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Linea.gif"))); // NOI18N
        botonLinea.setToolTipText("Línea");
        botonLinea.setFocusable(false);
        botonLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLinea.setMaximumSize(new java.awt.Dimension(36, 36));
        botonLinea.setPreferredSize(new java.awt.Dimension(36, 36));
        botonLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonLinea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonLineaMouseClicked(evt);
            }
        });
        botonesFiguras.add(botonLinea);

        BotonesMenu.add(botonRectangulo);
        botonRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Rectangulo.gif"))); // NOI18N
        botonRectangulo.setToolTipText("Rectángulo");
        botonRectangulo.setFocusable(false);
        botonRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRectangulo.setMaximumSize(new java.awt.Dimension(36, 36));
        botonRectangulo.setPreferredSize(new java.awt.Dimension(36, 36));
        botonRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonRectangulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRectanguloMouseClicked(evt);
            }
        });
        botonesFiguras.add(botonRectangulo);

        BotonesMenu.add(botonRectanguloRedondeado);
        botonRectanguloRedondeado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RectanguloRedondeado.gif"))); // NOI18N
        botonRectanguloRedondeado.setToolTipText("Rectángulo con esquinas redondeadas");
        botonRectanguloRedondeado.setFocusable(false);
        botonRectanguloRedondeado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRectanguloRedondeado.setMaximumSize(new java.awt.Dimension(36, 36));
        botonRectanguloRedondeado.setPreferredSize(new java.awt.Dimension(36, 36));
        botonRectanguloRedondeado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonRectanguloRedondeado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRectanguloRedondeadoMouseClicked(evt);
            }
        });
        botonesFiguras.add(botonRectanguloRedondeado);

        BotonesMenu.add(botonOvalo);
        botonOvalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ovalo.gif"))); // NOI18N
        botonOvalo.setFocusable(false);
        botonOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonOvalo.setMaximumSize(new java.awt.Dimension(36, 36));
        botonOvalo.setPreferredSize(new java.awt.Dimension(36, 36));
        botonOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonOvalo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonOvaloMouseClicked(evt);
            }
        });
        botonesFiguras.add(botonOvalo);

        BotonesMenu.add(botonCurvaControl);
        botonCurvaControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Curva1control.gif"))); // NOI18N
        botonCurvaControl.setToolTipText("Curva con un punto de control");
        botonCurvaControl.setFocusable(false);
        botonCurvaControl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCurvaControl.setMaximumSize(new java.awt.Dimension(36, 36));
        botonCurvaControl.setPreferredSize(new java.awt.Dimension(36, 36));
        botonCurvaControl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCurvaControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCurvaControlMouseClicked(evt);
            }
        });
        botonesFiguras.add(botonCurvaControl);

        BotonesMenu.add(botonCurvaCubicaSegmentada);
        botonCurvaCubicaSegmentada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Curva2control.gif"))); // NOI18N
        botonCurvaCubicaSegmentada.setToolTipText("Curva con dos puntos de control");
        botonCurvaCubicaSegmentada.setFocusable(false);
        botonCurvaCubicaSegmentada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCurvaCubicaSegmentada.setMaximumSize(new java.awt.Dimension(36, 36));
        botonCurvaCubicaSegmentada.setPreferredSize(new java.awt.Dimension(36, 36));
        botonCurvaCubicaSegmentada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCurvaCubicaSegmentada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCurvaCubicaSegmentadaMouseClicked(evt);
            }
        });
        botonesFiguras.add(botonCurvaCubicaSegmentada);

        paletaOpciones.add(botonesFiguras);

        botonesMultimedia.setRollover(true);
        botonesMultimedia.setMaximumSize(new java.awt.Dimension(120, 40));
        botonesMultimedia.setMinimumSize(new java.awt.Dimension(100, 38));

        iconWebcam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Camara.png"))); // NOI18N
        iconWebcam.setToolTipText("Webcam");
        iconWebcam.setFocusable(false);
        iconWebcam.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconWebcam.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        iconWebcam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconWebcamActionPerformed(evt);
            }
        });
        botonesMultimedia.add(iconWebcam);

        iconTakeScreenshot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Capturar.png"))); // NOI18N
        iconTakeScreenshot.setToolTipText("Captura");
        iconTakeScreenshot.setFocusable(false);
        iconTakeScreenshot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconTakeScreenshot.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        iconTakeScreenshot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconTakeScreenshotActionPerformed(evt);
            }
        });
        botonesMultimedia.add(iconTakeScreenshot);

        iconSoundRecorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/microfono2.gif"))); // NOI18N
        iconSoundRecorder.setToolTipText("Grabar Sonido");
        iconSoundRecorder.setFocusable(false);
        iconSoundRecorder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconSoundRecorder.setPreferredSize(new java.awt.Dimension(36, 36));
        iconSoundRecorder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        iconSoundRecorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconSoundRecorderActionPerformed(evt);
            }
        });
        botonesMultimedia.add(iconSoundRecorder);

        paletaOpciones.add(botonesMultimedia);

        getContentPane().add(paletaOpciones, java.awt.BorderLayout.PAGE_START);

        cuerpo.setPreferredSize(new java.awt.Dimension(772, 400));
        cuerpo.setLayout(new java.awt.BorderLayout());

        escritorio.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                escritorioComponentShown(evt);
            }
        });
        cuerpo.add(escritorio, java.awt.BorderLayout.CENTER);

        panelDerechoImagen.setLayout(new java.awt.GridBagLayout());

        contenedorFiguras.setBorder(javax.swing.BorderFactory.createTitledBorder("Figuras"));
        contenedorFiguras.setToolTipText("Figuras dibujadas");
        contenedorFiguras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contenedorFiguras.setDoubleBuffered(false);
        contenedorFiguras.setMaximumSize(new java.awt.Dimension(400, 300));
        contenedorFiguras.setMinimumSize(new java.awt.Dimension(300, 200));
        contenedorFiguras.setName(""); // NOI18N
        contenedorFiguras.setPreferredSize(new java.awt.Dimension(150, 235));
        contenedorFiguras.setLayout(new java.awt.BorderLayout());

        figureList.setDoubleBuffered(true);
        figureList.setMaximumSize(new java.awt.Dimension(100, 600));
        figureList.setMinimumSize(new java.awt.Dimension(100, 50));
        figureList.setVisibleRowCount(15);
        figureList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                figureListMouseClicked(evt);
            }
        });
        contenedorFiguras.add(figureList, java.awt.BorderLayout.CENTER);
        figureList.getAccessibleContext().setAccessibleName("");

        cloneShape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/copy.png"))); // NOI18N
        cloneShape.setToolTipText("Clonar figuras");
        cloneShape.setContentAreaFilled(false);
        cloneShape.setEnabled(false);
        cloneShape.setMaximumSize(new java.awt.Dimension(34, 34));
        cloneShape.setMinimumSize(new java.awt.Dimension(34, 34));
        cloneShape.setPreferredSize(new java.awt.Dimension(34, 34));
        cloneShape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cloneShapeMouseClicked(evt);
            }
        });
        jPanel2.add(cloneShape);

        removeShape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoborrar2.png"))); // NOI18N
        removeShape.setContentAreaFilled(false);
        removeShape.setEnabled(false);
        removeShape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeShapeMouseClicked(evt);
            }
        });
        jPanel2.add(removeShape);

        contenedorFiguras.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 13;
        panelDerechoImagen.add(contenedorFiguras, gridBagConstraints);

        reloadShapes.setText("Recargar");
        reloadShapes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadShapesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        panelDerechoImagen.add(reloadShapes, gridBagConstraints);

        cuerpo.add(panelDerechoImagen, java.awt.BorderLayout.LINE_END);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        cuerpo.add(jToolBar1, java.awt.BorderLayout.LINE_START);

        getContentPane().add(cuerpo, java.awt.BorderLayout.CENTER);

        pie.setLayout(new java.awt.BorderLayout());

        paneles.setLayout(new javax.swing.BoxLayout(paneles, javax.swing.BoxLayout.Y_AXIS));

        barraImagen.setRollover(true);

        contenedorBrillo.setBorder(javax.swing.BorderFactory.createTitledBorder("Brillo"));
        contenedorBrillo.setToolTipText("Brillo de la imagen");
        contenedorBrillo.setMaximumSize(new java.awt.Dimension(200, 90));
        contenedorBrillo.setMinimumSize(new java.awt.Dimension(95, 90));
        contenedorBrillo.setPreferredSize(new java.awt.Dimension(150, 90));
        contenedorBrillo.setLayout(new java.awt.GridBagLayout());

        sliderBrillo.setMaximum(200);
        sliderBrillo.setMinimum(-200);
        sliderBrillo.setPaintLabels(true);
        sliderBrillo.setToolTipText("Desplazador para el brillo");
        sliderBrillo.setValue(0);
        sliderBrillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBrilloStateChanged(evt);
            }
        });
        sliderBrillo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sliderBrilloFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 200;
        gridBagConstraints.gridy = 50;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        contenedorBrillo.add(sliderBrillo, gridBagConstraints);

        barraImagen.add(contenedorBrillo);

        contenedorEfecto.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));
        contenedorEfecto.setToolTipText("Filtros de imagen");
        contenedorEfecto.setMaximumSize(new java.awt.Dimension(400, 90));
        contenedorEfecto.setMinimumSize(new java.awt.Dimension(95, 90));
        contenedorEfecto.setPreferredSize(new java.awt.Dimension(200, 90));
        contenedorEfecto.setLayout(new java.awt.GridBagLayout());

        comboBoxEffectsList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Emborronamiento media", "Emborronamiento binomial", "Enfoque", "Relieve", "Dectector de fronteras laplaciano", "Negativo" }));
        comboBoxEffectsList.setToolTipText("Lista de filtros de imagen");
        comboBoxEffectsList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxEffectsList.setMaximumSize(new java.awt.Dimension(170, 50));
        comboBoxEffectsList.setMinimumSize(new java.awt.Dimension(170, 30));
        comboBoxEffectsList.setPreferredSize(null);
        comboBoxEffectsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEffectsListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        contenedorEfecto.add(comboBoxEffectsList, gridBagConstraints);

        barraImagen.add(contenedorEfecto);

        contenedorContraste.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraste"));
        contenedorContraste.setToolTipText("Contrastes");
        contenedorContraste.setMaximumSize(new java.awt.Dimension(200, 90));
        contenedorContraste.setPreferredSize(new java.awt.Dimension(150, 90));
        contenedorContraste.setLayout(new java.awt.GridBagLayout());

        botonContraste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/contraste.png"))); // NOI18N
        botonContraste.setToolTipText("Contraste");
        botonContraste.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonContraste.setDisabledIcon(null);
        botonContraste.setMaximumSize(new java.awt.Dimension(50, 35));
        botonContraste.setMinimumSize(new java.awt.Dimension(50, 35));
        botonContraste.setPreferredSize(new java.awt.Dimension(50, 35));
        botonContraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1.0;
        contenedorContraste.add(botonContraste, gridBagConstraints);

        botonIluminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iluminar.png"))); // NOI18N
        botonIluminar.setToolTipText("Iluminar imagen");
        botonIluminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonIluminar.setDisabledIcon(null);
        botonIluminar.setMaximumSize(new java.awt.Dimension(50, 35));
        botonIluminar.setMinimumSize(new java.awt.Dimension(50, 35));
        botonIluminar.setPreferredSize(new java.awt.Dimension(50, 35));
        botonIluminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIluminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1.0;
        contenedorContraste.add(botonIluminar, gridBagConstraints);

        botonOscurecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/oscurecer.png"))); // NOI18N
        botonOscurecer.setToolTipText("Oscurecer imagen");
        botonOscurecer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonOscurecer.setDisabledIcon(null);
        botonOscurecer.setMaximumSize(new java.awt.Dimension(50, 35));
        botonOscurecer.setMinimumSize(new java.awt.Dimension(50, 35));
        botonOscurecer.setPreferredSize(new java.awt.Dimension(50, 35));
        botonOscurecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOscurecerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1.0;
        contenedorContraste.add(botonOscurecer, gridBagConstraints);

        barraImagen.add(contenedorContraste);

        contenedorRotacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Rotación"));
        contenedorRotacion.setToolTipText("Rotación de la imagen");
        contenedorRotacion.setMaximumSize(new java.awt.Dimension(450, 90));
        contenedorRotacion.setMinimumSize(new java.awt.Dimension(175, 91));
        contenedorRotacion.setPreferredSize(new java.awt.Dimension(300, 90));
        contenedorRotacion.setLayout(new java.awt.GridBagLayout());

        sliderRotacion.setMajorTickSpacing(180);
        sliderRotacion.setMaximum(360);
        sliderRotacion.setMinorTickSpacing(90);
        sliderRotacion.setPaintLabels(true);
        sliderRotacion.setPaintTicks(true);
        sliderRotacion.setToolTipText("Desplazador para la rotación");
        sliderRotacion.setValue(0);
        sliderRotacion.setMaximumSize(new java.awt.Dimension(250, 65));
        sliderRotacion.setMinimumSize(new java.awt.Dimension(250, 65));
        sliderRotacion.setPreferredSize(new java.awt.Dimension(250, 65));
        sliderRotacion.setValueIsAdjusting(true);
        sliderRotacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderRotacionStateChanged(evt);
            }
        });
        sliderRotacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sliderRotacionFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        contenedorRotacion.add(sliderRotacion, gridBagConstraints);

        botonRotacion90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion90.png"))); // NOI18N
        botonRotacion90.setToolTipText("Rotar 90º a la derecha");
        botonRotacion90.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRotacion90.setMaximumSize(new java.awt.Dimension(50, 35));
        botonRotacion90.setMinimumSize(new java.awt.Dimension(50, 35));
        botonRotacion90.setPreferredSize(new java.awt.Dimension(50, 35));
        botonRotacion90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRotacion90ActionPerformed(evt);
            }
        });
        contenedorRotacion.add(botonRotacion90, new java.awt.GridBagConstraints());

        botonRotacion180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion180.png"))); // NOI18N
        botonRotacion180.setToolTipText("Rotar 180º");
        botonRotacion180.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRotacion180.setMaximumSize(new java.awt.Dimension(50, 35));
        botonRotacion180.setMinimumSize(new java.awt.Dimension(50, 35));
        botonRotacion180.setPreferredSize(new java.awt.Dimension(50, 35));
        botonRotacion180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRotacion180ActionPerformed(evt);
            }
        });
        contenedorRotacion.add(botonRotacion180, new java.awt.GridBagConstraints());

        botonRotacion270.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion270.png"))); // NOI18N
        botonRotacion270.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRotacion270.setMaximumSize(new java.awt.Dimension(50, 35));
        botonRotacion270.setMinimumSize(new java.awt.Dimension(50, 35));
        botonRotacion270.setPreferredSize(new java.awt.Dimension(50, 35));
        botonRotacion270.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRotacion270ActionPerformed(evt);
            }
        });
        contenedorRotacion.add(botonRotacion270, new java.awt.GridBagConstraints());

        barraImagen.add(contenedorRotacion);

        contenedorEscala.setBorder(javax.swing.BorderFactory.createTitledBorder("Zoom"));
        contenedorEscala.setToolTipText("Zoom imagen");
        contenedorEscala.setMaximumSize(new java.awt.Dimension(200, 90));
        contenedorEscala.setPreferredSize(new java.awt.Dimension(112, 90));
        contenedorEscala.setLayout(new java.awt.GridBagLayout());

        botonAumentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/aumentar.png"))); // NOI18N
        botonAumentar.setToolTipText("Aumentar Zoom");
        botonAumentar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAumentar.setMaximumSize(new java.awt.Dimension(50, 35));
        botonAumentar.setMinimumSize(new java.awt.Dimension(50, 35));
        botonAumentar.setPreferredSize(new java.awt.Dimension(50, 35));
        botonAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAumentarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1.0;
        contenedorEscala.add(botonAumentar, gridBagConstraints);

        botonDisminuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/disminuir.png"))); // NOI18N
        botonDisminuir.setToolTipText("Disminuir Zoom");
        botonDisminuir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonDisminuir.setMaximumSize(new java.awt.Dimension(50, 35));
        botonDisminuir.setMinimumSize(new java.awt.Dimension(50, 35));
        botonDisminuir.setPreferredSize(new java.awt.Dimension(50, 35));
        botonDisminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDisminuirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1.0;
        contenedorEscala.add(botonDisminuir, gridBagConstraints);

        barraImagen.add(contenedorEscala);

        contenedorUmbralizacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Umbralización"));
        contenedorUmbralizacion.setToolTipText("Umbralización");
        contenedorUmbralizacion.setMaximumSize(new java.awt.Dimension(450, 90));
        contenedorUmbralizacion.setMinimumSize(new java.awt.Dimension(175, 91));
        contenedorUmbralizacion.setPreferredSize(new java.awt.Dimension(300, 90));
        java.awt.GridBagLayout contenedorUmbralizacionLayout = new java.awt.GridBagLayout();
        contenedorUmbralizacionLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        contenedorUmbralizacionLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        contenedorUmbralizacion.setLayout(contenedorUmbralizacionLayout);

        sliderUmbralizacion.setMajorTickSpacing(128);
        sliderUmbralizacion.setMaximum(256);
        sliderUmbralizacion.setMinorTickSpacing(64);
        sliderUmbralizacion.setPaintLabels(true);
        sliderUmbralizacion.setPaintTicks(true);
        sliderUmbralizacion.setToolTipText("Slider umbralización");
        sliderUmbralizacion.setValue(128);
        sliderUmbralizacion.setMaximumSize(new java.awt.Dimension(250, 65));
        sliderUmbralizacion.setMinimumSize(new java.awt.Dimension(250, 65));
        sliderUmbralizacion.setPreferredSize(new java.awt.Dimension(250, 65));
        sliderUmbralizacion.setValueIsAdjusting(true);
        sliderUmbralizacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderUmbralizacionStateChanged(evt);
            }
        });
        sliderUmbralizacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sliderUmbralizacionFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        contenedorUmbralizacion.add(sliderUmbralizacion, gridBagConstraints);

        comboBoxUmbralizacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gris", "Color" }));
        comboBoxUmbralizacion.setToolTipText("Tipo de umbralización");
        comboBoxUmbralizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxUmbralizacion.setMinimumSize(new java.awt.Dimension(100, 27));
        comboBoxUmbralizacion.setPreferredSize(new java.awt.Dimension(100, 27));
        comboBoxUmbralizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUmbralizacionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        contenedorUmbralizacion.add(comboBoxUmbralizacion, gridBagConstraints);

        buttonThresholdingRed.setBackground(java.awt.Color.red);
        coloresUmbralizacion.add(buttonThresholdingRed);
        buttonThresholdingRed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonThresholdingRed.setMaximumSize(new java.awt.Dimension(50, 35));
        buttonThresholdingRed.setMinimumSize(new java.awt.Dimension(20, 20));
        buttonThresholdingRed.setPreferredSize(new java.awt.Dimension(20, 20));
        buttonThresholdingRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThresholdingRedActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        contenedorUmbralizacion.add(buttonThresholdingRed, gridBagConstraints);

        buttonThresholdingBlue.setBackground(java.awt.Color.blue);
        coloresUmbralizacion.add(buttonThresholdingBlue);
        buttonThresholdingBlue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonThresholdingBlue.setMaximumSize(new java.awt.Dimension(50, 35));
        buttonThresholdingBlue.setMinimumSize(new java.awt.Dimension(20, 20));
        buttonThresholdingBlue.setPreferredSize(new java.awt.Dimension(20, 20));
        buttonThresholdingBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThresholdingBlueActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        contenedorUmbralizacion.add(buttonThresholdingBlue, gridBagConstraints);

        buttonThresholdingGreen.setBackground(java.awt.Color.green);
        coloresUmbralizacion.add(buttonThresholdingGreen);
        buttonThresholdingGreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonThresholdingGreen.setMaximumSize(new java.awt.Dimension(50, 35));
        buttonThresholdingGreen.setMinimumSize(new java.awt.Dimension(20, 20));
        buttonThresholdingGreen.setPreferredSize(new java.awt.Dimension(20, 20));
        buttonThresholdingGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThresholdingGreenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        contenedorUmbralizacion.add(buttonThresholdingGreen, gridBagConstraints);

        buttonThresholdingColorPalette.setBackground(new java.awt.Color(254, 254, 254));
        buttonThresholdingColorPalette.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/gradiente.png"))); // NOI18N
        buttonThresholdingColorPalette.setToolTipText("Paleta de colores");
        buttonThresholdingColorPalette.setBorder(null);
        coloresUmbralizacion.add(buttonThresholdingColorPalette);
        buttonThresholdingColorPalette.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonThresholdingColorPalette.setMaximumSize(new java.awt.Dimension(50, 35));
        buttonThresholdingColorPalette.setMinimumSize(new java.awt.Dimension(30, 30));
        buttonThresholdingColorPalette.setPreferredSize(new java.awt.Dimension(35, 35));
        buttonThresholdingColorPalette.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonThresholdingColorPaletteMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        contenedorUmbralizacion.add(buttonThresholdingColorPalette, gridBagConstraints);

        barraImagen.add(contenedorUmbralizacion);

        paneles.add(barraImagen);

        barraColor.setRollover(true);

        contenedorColores.setMaximumSize(new java.awt.Dimension(125, 90));
        contenedorColores.setMinimumSize(new java.awt.Dimension(125, 90));
        contenedorColores.setPreferredSize(new java.awt.Dimension(125, 90));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(0, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        contenedorColores.setLayout(flowLayout1);

        panelColores.setBorder(javax.swing.BorderFactory.createTitledBorder("Color"));
        panelColores.setToolTipText("Color con borde y relleno");
        panelColores.setMaximumSize(new java.awt.Dimension(89, 90));
        panelColores.setMinimumSize(new java.awt.Dimension(89, 90));
        panelColores.setPreferredSize(new java.awt.Dimension(125, 90));
        panelColores.setLayout(new java.awt.GridBagLayout());

        botonColorRojo.setBackground(new java.awt.Color(255, 0, 0));
        botonColorRojo.setToolTipText("Color rojo");
        botonColorRojo.setBorder(null);
        GrupoColores.add(botonColorRojo);
        botonColorRojo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        botonColorNegro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        botonColorAzul.setToolTipText("Color azul");
        botonColorAzul.setBorder(null);
        GrupoColores.add(botonColorAzul);
        botonColorAzul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonColorAzul.setMaximumSize(new java.awt.Dimension(15, 15));
        botonColorAzul.setMinimumSize(new java.awt.Dimension(15, 15));
        botonColorAzul.setPreferredSize(new java.awt.Dimension(15, 15));
        botonColorAzul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonColorAzulMouseClicked(evt);
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
        botonColorBlanco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        botonColorVerde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        botonColorAmarillo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        barraColor.add(contenedorColores);

        contenedorRelleno.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Relleno y color"));
        contenedorRelleno.setToolTipText("Tipo de Relleno y Color");
        contenedorRelleno.setMaximumSize(new java.awt.Dimension(180, 90));
        contenedorRelleno.setMinimumSize(new java.awt.Dimension(180, 55));
        contenedorRelleno.setPreferredSize(new java.awt.Dimension(175, 90));
        java.awt.GridBagLayout contenedorRellenoLayout = new java.awt.GridBagLayout();
        contenedorRellenoLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        contenedorRellenoLayout.rowHeights = new int[] {0, 5, 0};
        contenedorRelleno.setLayout(contenedorRellenoLayout);

        comboBoxFillList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin relleno", "Liso", "Degradado" }));
        comboBoxFillList.setToolTipText("Tipo de Relleno");
        comboBoxFillList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxFillList.setMaximumSize(new java.awt.Dimension(200, 30));
        comboBoxFillList.setMinimumSize(new java.awt.Dimension(115, 22));
        comboBoxFillList.setPreferredSize(new java.awt.Dimension(155, 22));
        comboBoxFillList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFillListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        contenedorRelleno.add(comboBoxFillList, gridBagConstraints);

        labelTextFillColor.setText("Color");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        contenedorRelleno.add(labelTextFillColor, gridBagConstraints);

        gradientColor.setBackground(java.awt.Color.white);
        gradientColor.setToolTipText("Color del relleno");
        gradientColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gradientColor.setFocusable(false);
        gradientColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gradientColor.setMaximumSize(new java.awt.Dimension(20, 20));
        gradientColor.setMinimumSize(new java.awt.Dimension(30, 20));
        gradientColor.setPreferredSize(new java.awt.Dimension(25, 25));
        gradientColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gradientColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradientColorMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 25.0;
        gridBagConstraints.weighty = 25.0;
        contenedorRelleno.add(gradientColor, gridBagConstraints);

        fillColor.setBackground(java.awt.Color.black);
        fillColor.setToolTipText("Color del relleno");
        fillColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fillColor.setFocusable(false);
        fillColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fillColor.setMaximumSize(new java.awt.Dimension(30, 20));
        fillColor.setMinimumSize(new java.awt.Dimension(30, 20));
        fillColor.setPreferredSize(new java.awt.Dimension(25, 25));
        fillColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fillColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fillColorMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 25.0;
        gridBagConstraints.weighty = 25.0;
        contenedorRelleno.add(fillColor, gridBagConstraints);

        labelTextGradientColor.setText("Color2");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        contenedorRelleno.add(labelTextGradientColor, gridBagConstraints);

        barraColor.add(contenedorRelleno);

        contenedorBorde.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Borde y color"));
        contenedorBorde.setToolTipText("");
        contenedorBorde.setMaximumSize(new java.awt.Dimension(200, 90));
        contenedorBorde.setPreferredSize(new java.awt.Dimension(190, 90));
        java.awt.GridBagLayout contenedorRelleno1Layout = new java.awt.GridBagLayout();
        contenedorRelleno1Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        contenedorRelleno1Layout.rowHeights = new int[] {0, 5, 0};
        contenedorBorde.setLayout(contenedorRelleno1Layout);

        comboBoxStrokeList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Línea continua", "Línea discontinua" }));
        comboBoxStrokeList.setToolTipText("Tipo de Relleno");
        comboBoxStrokeList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxStrokeList.setMaximumSize(new java.awt.Dimension(200, 30));
        comboBoxStrokeList.setMinimumSize(new java.awt.Dimension(115, 22));
        comboBoxStrokeList.setPreferredSize(new java.awt.Dimension(155, 22));
        comboBoxStrokeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxStrokeListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        contenedorBorde.add(comboBoxStrokeList, gridBagConstraints);

        jLabel1.setText("Grosor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        contenedorBorde.add(jLabel1, gridBagConstraints);

        grosor.setToolTipText("Grosor");
        grosor.setMaximumSize(new java.awt.Dimension(50, 28));
        grosor.setMinimumSize(new java.awt.Dimension(50, 28));
        grosor.setPreferredSize(new java.awt.Dimension(50, 28));
        grosor.setValue(1);
        grosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                grosorStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        contenedorBorde.add(grosor, gridBagConstraints);

        labelTextBorderColor.setText("Color");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        contenedorBorde.add(labelTextBorderColor, gridBagConstraints);

        strokeColor.setToolTipText("Color del borde");
        strokeColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        strokeColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        strokeColor.setMaximumSize(new java.awt.Dimension(60, 20));
        strokeColor.setMinimumSize(new java.awt.Dimension(60, 20));
        strokeColor.setPreferredSize(new java.awt.Dimension(25, 25));
        strokeColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                strokeColorMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        contenedorBorde.add(strokeColor, gridBagConstraints);

        barraColor.add(contenedorBorde);

        contenedorEstiloBorde.setBorder(javax.swing.BorderFactory.createTitledBorder("Estilos Borde"));
        contenedorEstiloBorde.setToolTipText("Estilos para el borde");
        contenedorEstiloBorde.setMaximumSize(new java.awt.Dimension(200, 90));
        contenedorEstiloBorde.setPreferredSize(new java.awt.Dimension(202, 90));
        java.awt.GridBagLayout contenedorEstiloBordeLayout = new java.awt.GridBagLayout();
        contenedorEstiloBordeLayout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        contenedorEstiloBordeLayout.rowHeights = new int[] {0, 5, 0};
        contenedorEstiloBorde.setLayout(contenedorEstiloBordeLayout);

        jLabel3.setText("Inicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        contenedorEstiloBorde.add(jLabel3, gridBagConstraints);

        comboBoxStyleStrokeJoinList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bevel", "Miter", "Round" }));
        comboBoxStyleStrokeJoinList.setToolTipText("Tipo de Línea");
        comboBoxStyleStrokeJoinList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxStyleStrokeJoinList.setMaximumSize(new java.awt.Dimension(200, 30));
        comboBoxStyleStrokeJoinList.setMinimumSize(new java.awt.Dimension(115, 22));
        comboBoxStyleStrokeJoinList.setPreferredSize(new java.awt.Dimension(155, 22));
        comboBoxStyleStrokeJoinList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxStyleStrokeJoinListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        contenedorEstiloBorde.add(comboBoxStyleStrokeJoinList, gridBagConstraints);

        jLabel4.setText("Final");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        contenedorEstiloBorde.add(jLabel4, gridBagConstraints);

        comboBoxStyleStrokeCapList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Button", "Round", "Square" }));
        comboBoxStyleStrokeCapList.setToolTipText("Tipo de Final de línea");
        comboBoxStyleStrokeCapList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxStyleStrokeCapList.setMaximumSize(new java.awt.Dimension(200, 30));
        comboBoxStyleStrokeCapList.setMinimumSize(new java.awt.Dimension(115, 22));
        comboBoxStyleStrokeCapList.setPreferredSize(new java.awt.Dimension(155, 22));
        comboBoxStyleStrokeCapList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxStyleStrokeCapListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 11;
        contenedorEstiloBorde.add(comboBoxStyleStrokeCapList, gridBagConstraints);

        barraColor.add(contenedorEstiloBorde);

        paneles.add(barraColor);

        pie.add(paneles, java.awt.BorderLayout.LINE_START);

        panelLabelFigura.setBorder(javax.swing.BorderFactory.createBevelBorder(1));
        panelLabelFigura.setLayout(new javax.swing.BoxLayout(panelLabelFigura, javax.swing.BoxLayout.LINE_AXIS));

        labelFigura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelFigura.setText("labelFigura");
        panelLabelFigura.add(labelFigura);

        pie.add(panelLabelFigura, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pie, java.awt.BorderLayout.PAGE_END);

        menuArchivo.setText("Archivo");

        nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NuevoBoceto.GIF"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(nuevo);

        abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AbrirMedio.png"))); // NOI18N
        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        menuArchivo.add(abrir);

        guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.gif"))); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        menuArchivo.add(guardar);

        menu.add(menuArchivo);

        menuVer.setText("Ver");

        verBarraEstado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        verBarraEstado.setSelected(true);
        verBarraEstado.setText("Barra de estado");
        verBarraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraEstadoActionPerformed(evt);
            }
        });
        menuVer.add(verBarraEstado);

        showToolBarColor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        showToolBarColor.setSelected(true);
        showToolBarColor.setText("Herramientas de colores");
        showToolBarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showToolBarColorActionPerformed(evt);
            }
        });
        menuVer.add(showToolBarColor);

        showToolBarImage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        showToolBarImage.setSelected(true);
        showToolBarImage.setText("Herramientas de imagen");
        showToolBarImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showToolBarImageActionPerformed(evt);
            }
        });
        menuVer.add(showToolBarImage);

        showToolBarMultimedia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        showToolBarMultimedia.setSelected(true);
        showToolBarMultimedia.setText("Herramientas multimedia");
        showToolBarMultimedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showToolBarMultimediaActionPerformed(evt);
            }
        });
        menuVer.add(showToolBarMultimedia);

        menu.add(menuVer);

        menuImagen.setText("Imagen");

        menuRescaleOp.setText("RescaleOp");
        menuRescaleOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRescaleOpActionPerformed(evt);
            }
        });
        menuImagen.add(menuRescaleOp);

        menuConvolveOp.setText("ConvolveOp");
        menuConvolveOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConvolveOpActionPerformed(evt);
            }
        });
        menuImagen.add(menuConvolveOp);

        umbralizacion.setText("Umbralización");
        umbralizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralizacionActionPerformed(evt);
            }
        });
        menuImagen.add(umbralizacion);

        restar.setText("Restar");
        restar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restarActionPerformed(evt);
            }
        });
        menuImagen.add(restar);

        multiplicar.setText("Multiplicación");
        multiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplicarActionPerformed(evt);
            }
        });
        menuImagen.add(multiplicar);

        sobelMenu.setText("Sobel");
        sobelMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobelMenuActionPerformed(evt);
            }
        });
        menuImagen.add(sobelMenu);

        negative.setText("Negativo");
        negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativeActionPerformed(evt);
            }
        });
        menuImagen.add(negative);

        menuChangeGrey.setText("Pasar a GRIS");
        menuChangeGrey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChangeGreyActionPerformed(evt);
            }
        });
        menuImagen.add(menuChangeGrey);

        menuCloneImage.setText("Duplicar Imagen");
        menuCloneImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCloneImageActionPerformed(evt);
            }
        });
        menuImagen.add(menuCloneImage);

        menuArtFilter.setText("Filtro Artístico");
        menuArtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArtFilterActionPerformed(evt);
            }
        });
        menuImagen.add(menuArtFilter);

        menu.add(menuImagen);

        menuMultimedia.setText("Multimedia");

        menuSoundRecorder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSoundRecorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/microfono2.gif"))); // NOI18N
        menuSoundRecorder.setText("Grabar sonido");
        menuSoundRecorder.setPreferredSize(new java.awt.Dimension(14, 24));
        menuSoundRecorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSoundRecorderActionPerformed(evt);
            }
        });
        menuMultimedia.add(menuSoundRecorder);

        menuTakeScreenshot.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuTakeScreenshot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Capturar.png"))); // NOI18N
        menuTakeScreenshot.setText("Tomar Captura");
        menuTakeScreenshot.setToolTipText("Capturar en Vídeos ó Webcam");
        menuTakeScreenshot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTakeScreenshotActionPerformed(evt);
            }
        });
        menuMultimedia.add(menuTakeScreenshot);

        menuWebcam.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        menuWebcam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Camara.png"))); // NOI18N
        menuWebcam.setText("Webcam");
        menuWebcam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuWebcamActionPerformed(evt);
            }
        });
        menuMultimedia.add(menuWebcam);

        menu.add(menuMultimedia);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Devuelve una instancia del escritorio, (se usaba antes de tener el método
     * <code>getInstance()</code>.
     *
     * Es un método estático por lo que no era necesario crear objeto.
     *
     * @return devuelve un escritorio de tipo JDesktopPane.
     */
    public static JDesktopPane getEscritorio() {
        return escritorio;
    }

    private void botonLineaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLineaMouseClicked
        labelFigura.setText("Línea");
        botonLinea.setSelected(true);
        Lienzo.setForma(Lienzo.LINEA);
    }//GEN-LAST:event_botonLineaMouseClicked

    private void botonRectanguloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRectanguloMouseClicked

        labelFigura.setText("Rectángulo");
        botonRectangulo.setSelected(true);
        Lienzo.setForma(Lienzo.RECTANGULO);


    }//GEN-LAST:event_botonRectanguloMouseClicked

    private void botonOvaloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonOvaloMouseClicked
        labelFigura.setText("Óvalo");
        botonOvalo.setSelected(true);
        Lienzo.setForma(Lienzo.ELIPSE);
    }//GEN-LAST:event_botonOvaloMouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        ArrayList<Integer> options = JOptionPaneMultiInput.showJOptionPaneMultiIpunt();
        if (options != null) {
            vi = newWindows(options.get(0), options.get(1));
        }

    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        if (escritorio.getSelectedFrame() instanceof VentanaInternaImagen) {
            dlg.addChoosableFileFilter(new GIFImageFileFilter());
            dlg.addChoosableFileFilter(new JPEGImageFileFilter());
            dlg.addChoosableFileFilter(new JPGImageFileFilter());
            dlg.addChoosableFileFilter(new PNGImageFileFilter());
            if (resp == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = dlg.getSelectedFile();
                    VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
                    BufferedImage img = vi.getLienzo().getImageOriginal();
                    if (img == null) {
                        img = new BufferedImage(vi.getLienzo().getWidth(), vi.getLienzo().getHeight(), BufferedImage.TYPE_INT_RGB);
                        //Le añado filtro negativo para que slaga el fondo blanco en la imagen.
                        LookupTable ltp = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_NEGATIVE);
                        LookupOp lop = new LookupOp(ltp, null);
                        img = lop.filter(img, null);

                    }
                    img = vi.getLienzo().volcado(img);

                    ImageIO.write(img, UtilFileFilter.getExtension(f), f);
                    //Código
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void botonColorNegroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorNegroMouseClicked
        setColorButtons(Color.black);
    }//GEN-LAST:event_botonColorNegroMouseClicked

    private void botonColorRojoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorRojoMouseClicked
        setColorButtons(Color.red);
    }//GEN-LAST:event_botonColorRojoMouseClicked

    private void botonColorAzulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorAzulMouseClicked
        setColorButtons(Color.blue);
    }//GEN-LAST:event_botonColorAzulMouseClicked

    private void botonColorBlancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorBlancoMouseClicked
        setColorButtons(Color.white);
    }//GEN-LAST:event_botonColorBlancoMouseClicked

    private void botonColorAmarilloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorAmarilloMouseClicked
        setColorButtons(Color.yellow);
    }//GEN-LAST:event_botonColorAmarilloMouseClicked

    private void botonColorVerdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonColorVerdeMouseClicked
        setColorButtons(Color.green);
    }//GEN-LAST:event_botonColorVerdeMouseClicked

    private void setColorButtons(Color color) {
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        Lienzo.setFillColor(color);
        Lienzo.setStrokeColor(color);
        fillColor.setBackground(color);
        gradientColor.setBackground(color);
        strokeColor.setBackground(color);
        if (vi != null) {
            for (Integer i : vi.getLienzo().getvShapeSelected()) {
                //En este chorizo lo que hago es, coger todas las figuras seleccionadas y moverlas a la vez proporcionalmente.
                vi.getLienzo().changeColorProperty(Lienzo.COLOR_FILL, color, color);
                vi.getLienzo().changeColorProperty(Lienzo.COLOR_GRADIENT, color, color);
                vi.getLienzo().changeColorProperty(Lienzo.COLOR_STROKE, color, color);
            }
        }
        repaint();
    }

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        JFileChooser dlg = new JFileChooser();
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new JPGImageFileFilter());
        dlg.addChoosableFileFilter(new JPEGImageFileFilter());
        dlg.addChoosableFileFilter(new AVIVideoFileFilter());
        dlg.addChoosableFileFilter(new GIFImageFileFilter());
        dlg.addChoosableFileFilter(new PNGImageFileFilter());
        dlg.addChoosableFileFilter(new WAVSoundFileFilter());
        dlg.addChoosableFileFilter(new MP3SoundFileFilter());
        dlg.addChoosableFileFilter(new MIDISoundFileFilter());

        int resp = dlg.showOpenDialog(this);
        File f = null;
        if (resp == JFileChooser.APPROVE_OPTION) {
            try {
                f = dlg.getSelectedFile();
                if (UtilFileFilter.isImage(f)) {
                    BufferedImage img = ImageIO.read(f);
                    VentanaInternaImagen.showImage(img, f.getName());
                    vi = (VentanaInternaImagen) escritorio.getSelectedFrame();
                    if (vi != null) {
                        vi.getLienzo().addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                eventoEscritorioShapes(vi);
                                repaint();
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {
                                eventoEscritorioShapes(vi);
                                repaint();
                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {
                                eventoEscritorioShapes(vi);
                                repaint();
                            }
                        });
                        eventoEscritorioShapes(vi);
                    }
                } else if (UtilFileFilter.isSound(f) || UtilFileFilter.isVideo(f)) {
                    VentanaInternaJMFPlayer.showJMFPlayer(f, f.getName());
                }
            } catch (Exception ex) {
                System.err.println("Error al leer el archivo " + f.getName());
            }
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void verBarraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraEstadoActionPerformed
        if (!verBarraEstado.isSelected()) {
            panelLabelFigura.setVisible(false);
        } else {
            panelLabelFigura.setVisible(true);
        }
    }//GEN-LAST:event_verBarraEstadoActionPerformed

    private void botonLapizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLapizMouseClicked
        labelFigura.setText("Lápiz");
        botonLapiz.setSelected(true);
        Lienzo.setForma(Lienzo.PUNTO);
    }//GEN-LAST:event_botonLapizMouseClicked

    private void grosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_grosorStateChanged
        float value = Float.parseFloat(((JSpinner) evt.getSource()).getValue().toString());
        if (value < 0) {
            Lienzo.setStrokeWidth(0);
        } else {
            Lienzo.setStrokeWidth(Float.parseFloat(grosor.getValue().toString()));
        }
        VentanaInternaImagen vii = (VentanaInternaImagen) selectInternalWindows();
        if (vii != null) {
            vii.getLienzo().changeWidthStrokeProperty(Float.parseFloat(grosor.getValue().toString()));
        }

    }//GEN-LAST:event_grosorStateChanged

    private void menuRescaleOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRescaleOpActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageOriginal();
            if (imgSource != null) {
                try {
                    RescaleOp rop = new RescaleOp(1.0F, 100.0F, null);
                    BufferedImage imgdest = rop.filter(convertImageType(imgSource, BufferedImage.TYPE_INT_RGB), null);
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_menuRescaleOpActionPerformed

    BufferedImage convertImageType(BufferedImage img, int type) {
        if (img == null) {
            return null;
        }
        BufferedImage imgOut = new BufferedImage(img.getWidth(),
                img.getHeight(), type);
        Graphics2D g2d = imgOut.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        return imgOut;
    }


    private void menuConvolveOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConvolveOpActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageOriginal();
            if (imgSource != null) {
                try {
                    ConvolveOp cop = new ConvolveOp(KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3));
                    BufferedImage imgdest = cop.filter(imgSource, null);
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_menuConvolveOpActionPerformed

    private void sliderBrilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBrilloStateChanged
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            if (vi.getLienzo().getImageOriginal() != null) {
                try {
                    RescaleOp rop = new RescaleOp(1.0F, (float) sliderBrillo.getValue(), null);
                    BufferedImage imgdest = rop.filter(convertImageType(vi.getLienzo().getImageOriginal(), BufferedImage.TYPE_INT_RGB), null);
                    vi.getLienzo().setImageActual(imgdest);
                    vi.getLienzo().repaint();
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_sliderBrilloStateChanged

    private void sliderBrilloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sliderBrilloFocusLost
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            vi.getLienzo().setImageOriginal(vi.getLienzo().getImageActual());
        }
        sliderBrillo.setValue(0);
    }//GEN-LAST:event_sliderBrilloFocusLost

    private void comboBoxEffectsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEffectsListActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();

        switch (comboBoxEffectsList.getSelectedIndex()) {

            case KernelProducer.TYPE_MEDIA_3x3:
                if (vi != null) {
                    BufferedImage imgSource = vi.getLienzo().getImageOriginal();
                    if (imgSource != null) {
                        try {
                            ConvolveOp cop = new ConvolveOp(KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3));
                            BufferedImage imgdest = cop.filter(imgSource, null);
                            vi.getLienzo().setImageActual(imgdest);
                            vi.getLienzo().repaint();
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getLocalizedMessage());
                        }
                    }
                }
                break;

            case KernelProducer.TYPE_BINOMIAL_3x3:
                if (vi != null) {
                    BufferedImage imgSource = vi.getLienzo().getImageOriginal();
                    if (imgSource != null) {
                        try {
                            ConvolveOp cop = new ConvolveOp(KernelProducer.createKernel(KernelProducer.TYPE_BINOMIAL_3x3));
                            BufferedImage imgdest = cop.filter(imgSource, null);
                            vi.getLienzo().setImageActual(imgdest);
                            vi.getLienzo().repaint();
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getLocalizedMessage());
                        }
                    }
                }
                break;

            case KernelProducer.TYPE_ENFOQUE_3x3:
                if (vi != null) {
                    BufferedImage imgSource = vi.getLienzo().getImageOriginal();
                    if (imgSource != null) {
                        try {
                            ConvolveOp cop = new ConvolveOp(KernelProducer.createKernel(KernelProducer.TYPE_ENFOQUE_3x3));
                            BufferedImage imgdest = cop.filter(imgSource, null);
                            vi.getLienzo().setImageActual(imgdest);
                            vi.getLienzo().repaint();
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getLocalizedMessage());
                        }
                    }
                }

                break;

            case KernelProducer.TYPE_RELIEVE_3x3:
                if (vi != null) {
                    BufferedImage imgSource = vi.getLienzo().getImageOriginal();
                    if (imgSource != null) {
                        try {
                            ConvolveOp cop = new ConvolveOp(KernelProducer.createKernel(KernelProducer.TYPE_RELIEVE_3x3));
                            BufferedImage imgdest = cop.filter(imgSource, null);
                            vi.getLienzo().setImageActual(imgdest);
                            vi.getLienzo().repaint();
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getLocalizedMessage());
                        }
                    }
                }
                break;

            case KernelProducer.TYPE_LAPLACIANA_3x3:
                if (vi != null) {
                    BufferedImage imgSource = vi.getLienzo().getImageOriginal();
                    if (imgSource != null) {
                        try {
                            ConvolveOp cop = new ConvolveOp(KernelProducer.createKernel(KernelProducer.TYPE_LAPLACIANA_3x3));
                            BufferedImage imgdest = cop.filter(imgSource, null);
                            vi.getLienzo().setImageActual(imgdest);
                            vi.getLienzo().repaint();
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getLocalizedMessage());
                        }
                    }
                }
                break;

        }
    }//GEN-LAST:event_comboBoxEffectsListActionPerformed

    private void botonContrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasteActionPerformed

        try {
            VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
            if (vi != null) {
                BufferedImage imgActual = convertImageType(vi.getLienzo().getImageActual(), BufferedImage.TYPE_INT_RGB);
                LookupTable ltp = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_SFUNCION);
                LookupOp lop = new LookupOp(ltp, null);
                BufferedImage imgdest = lop.filter(imgActual, null);

                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el contraste");
        }
    }//GEN-LAST:event_botonContrasteActionPerformed

    private void botonIluminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIluminarActionPerformed
        try {
            VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
            if (vi != null) {
                BufferedImage imgActual = convertImageType(vi.getLienzo().getImageActual(), BufferedImage.TYPE_INT_RGB);
                LookupTable ltp = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_LOGARITHM);
                LookupOp lop = new LookupOp(ltp, null);
                BufferedImage imgdest = lop.filter(imgActual, null);

                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        } catch (Exception e) {
            System.err.println("Error al iluminar");
        }
    }//GEN-LAST:event_botonIluminarActionPerformed

    private void botonOscurecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOscurecerActionPerformed
        try {
            VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
            if (vi != null) {
                BufferedImage imgActual = convertImageType(vi.getLienzo().getImageActual(), BufferedImage.TYPE_INT_RGB);
                LookupTable ltp = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_POWER);
                LookupOp lop = new LookupOp(ltp, null);
                BufferedImage imgdest = lop.filter(imgActual, null);
                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        } catch (Exception e) {
            System.err.println("Error al oscurecer");
        }
    }//GEN-LAST:event_botonOscurecerActionPerformed

    private void sliderRotacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderRotacionStateChanged
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageOriginal();
            if (imgSource != null) {
                double r = Math.toRadians(sliderRotacion.getValue());
                Point p = new Point(imgSource.getWidth() / 2, imgSource.getHeight() / 2);
                AffineTransform at = AffineTransform.getRotateInstance(r, p.x, p.y);
                AffineTransformOp atop;
                atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage imgdest = atop.filter(imgSource, null);
                if (imgdest != null) {
                    vi.getLienzo().setImageActual(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_sliderRotacionStateChanged

    private void botonRotacion90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRotacion90ActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageActual();
            if (imgSource != null) {
                double r = Math.toRadians(90);
                Point p = new Point(imgSource.getWidth() / 2, imgSource.getHeight() / 2);
                AffineTransform at = AffineTransform.getRotateInstance(r, p.x, p.y);
                AffineTransformOp atop;
                atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage imgdest = atop.filter(imgSource, null);
                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_botonRotacion90ActionPerformed

    private void botonRotacion180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRotacion180ActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageActual();
            if (imgSource != null) {
                double r = Math.toRadians(180);
                Point p = new Point(imgSource.getWidth() / 2, imgSource.getHeight() / 2);
                AffineTransform at = AffineTransform.getRotateInstance(r, p.x, p.y);
                AffineTransformOp atop;
                atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage imgdest = atop.filter(imgSource, null);
                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_botonRotacion180ActionPerformed

    private void botonRotacion270ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRotacion270ActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageActual();
            if (imgSource != null) {
                double r = Math.toRadians(270);
                Point p = new Point(imgSource.getWidth() / 2, imgSource.getHeight() / 2);
                AffineTransform at = AffineTransform.getRotateInstance(r, p.x, p.y);
                AffineTransformOp atop;
                atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage imgdest = atop.filter(imgSource, null);
                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_botonRotacion270ActionPerformed

    private void botonAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAumentarActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageActual();
            if (imgSource != null) {
                AffineTransform at = AffineTransform.getScaleInstance(1.25, 1.25);
                AffineTransformOp atop;
                atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage imgdest = atop.filter(imgSource, null);
                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_botonAumentarActionPerformed

    private void botonDisminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDisminuirActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageActual();
            if (imgSource != null) {
                AffineTransform at = AffineTransform.getScaleInstance(0.75, 0.75);
                AffineTransformOp atop;
                atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage imgdest = atop.filter(imgSource, null);
                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_botonDisminuirActionPerformed

    private void sliderRotacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sliderRotacionFocusLost
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            vi.getLienzo().setImageOriginal(vi.getLienzo().getImageActual());
        }
        sliderRotacion.setValue(0);
    }//GEN-LAST:event_sliderRotacionFocusLost

    private void umbralizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umbralizacionActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageActual();
            if (imgSource != null) {
                UmbralizacionOp umbralizacion = new UmbralizacionOp(120);
                BufferedImage imgdest = umbralizacion.filter(imgSource, null);

                if (imgdest != null) {
                    vi.getLienzo().setImageActual(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_umbralizacionActionPerformed

    private void restarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restarActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgRight = vi.getLienzo().getImageActual();
            if (imgRight != null) {
                VentanaInternaImagen viNext = (VentanaInternaImagen) escritorio.selectFrame(true);
                if (viNext != null) {
                    BufferedImage imgLeft = viNext.getLienzo().getImageActual();
                    RestaOp op = new RestaOp(imgLeft);
                    BufferedImage imgdest = op.filter(imgRight, null);
                    if (imgdest != null) {
                        vi.getLienzo().setImageActual(imgdest);
                        vi.getLienzo().repaint();
                    }
                }
            }
        }
    }//GEN-LAST:event_restarActionPerformed

    private void multiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplicarActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgRight = vi.getLienzo().getImageActual();
            if (imgRight != null) {
                VentanaInternaImagen viNext = (VentanaInternaImagen) escritorio.selectFrame(true);
                if (viNext != null) {
                    BufferedImage imgLeft = viNext.getLienzo().getImageActual();
                    MultiplicacionOp op = new MultiplicacionOp(imgLeft);
                    BufferedImage imgdest = op.filter(imgRight, null);
                    if (imgdest != null) {
                        vi.getLienzo().setImageActual(imgdest);
                        vi.getLienzo().repaint();
                    }
                }
            }
        }
    }//GEN-LAST:event_multiplicarActionPerformed

    private void sobelMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobelMenuActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImageActual();
            if (imgSource != null) {
                SobelOp sobel = new SobelOp();
                BufferedImage imgdest = sobel.filter(imgSource, null);

                if (imgdest != null) {
                    vi.getLienzo().setImageActual(imgdest);
                    activateFilterColorImage(false);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_sobelMenuActionPerformed

    private void botonCurvaControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCurvaControlMouseClicked
        labelFigura.setText("Curva con punto de control");
        botonCurvaControl.setSelected(true);
        Lienzo.setForma(Lienzo.CURVACONTROL);
    }//GEN-LAST:event_botonCurvaControlMouseClicked

    private void botonCurvaCubicaSegmentadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCurvaCubicaSegmentadaMouseClicked
        // TODO add your handling code here:
        labelFigura.setText("Curva cúbica segmentada");
        botonCurvaCubicaSegmentada.setSelected(true);
        Lienzo.setForma(Lienzo.CURVACUBICACONTROL);
    }//GEN-LAST:event_botonCurvaCubicaSegmentadaMouseClicked

    private void botonRectanguloRedondeadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRectanguloRedondeadoMouseClicked

        labelFigura.setText("Rectángulo con esquinas redondeadas");
        botonRectanguloRedondeado.setSelected(true);
        Lienzo.setForma(Lienzo.RECTANGULOREDONDEADO);
    }//GEN-LAST:event_botonRectanguloRedondeadoMouseClicked

    private void gradientColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradientColorMouseClicked
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (evt.getClickCount() % 2 == 0 || gradientColor.getBackground() == null) {
            Color newColor = JColorChooser.showDialog(
                    VentanaPrincipal.this,
                    "Escoge 2º color para el GRADIENTE",
                    gradientColor.getBackground());
            if (newColor != null) {
                gradientColor.setBackground(newColor);
                Lienzo.setGradientColor(gradientColor.getBackground());
            }
        } else if (evt.getClickCount() % 2 == 1) {
            Lienzo.setGradientColor(gradientColor.getBackground());
        }
        if (vi != null) {
            vi.getLienzo().changeColorProperty(Lienzo.COLOR_GRADIENT, fillColor.getBackground(), gradientColor.getBackground());
        }
    }//GEN-LAST:event_gradientColorMouseClicked

    private void comboBoxFillListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFillListActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        switch (comboBoxFillList.getSelectedIndex()) {
            case Lienzo.TYPE_FILL_NONE:
                Lienzo.setFillType(Lienzo.TYPE_FILL_NONE);
                Lienzo.setFillColor(null);
                if (vi != null) {
                    vi.getLienzo().changeFillProperty(Lienzo.TYPE_FILL_NONE, null, null);
                }
                labelTextFillColor.setVisible(false);
                fillColor.setVisible(false);
                labelTextGradientColor.setVisible(false);
                gradientColor.setVisible(false);
                break;
            case Lienzo.TYPE_FILL_SOLID:
                Lienzo.setFillType(Lienzo.TYPE_FILL_SOLID);
                Lienzo.setFillColor(fillColor.getBackground());
                if (vi != null) {
                    vi.getLienzo().changeFillProperty(Lienzo.TYPE_FILL_SOLID, fillColor.getBackground(), null);
                }
                labelTextFillColor.setVisible(true);
                fillColor.setVisible(true);
                labelTextGradientColor.setVisible(false);
                gradientColor.setVisible(false);
                break;
            case Lienzo.TYPE_FILL_GRADIENT:
                Lienzo.setFillType(Lienzo.TYPE_FILL_GRADIENT);
                Lienzo.setFillColor(fillColor.getBackground());
                Lienzo.setGradientColor(gradientColor.getBackground());
                if (vi != null) {
                    vi.getLienzo().changeFillProperty(Lienzo.TYPE_FILL_GRADIENT, fillColor.getBackground(), gradientColor.getBackground());
                }
                labelTextFillColor.setVisible(true);
                fillColor.setVisible(true);
                labelTextGradientColor.setVisible(true);
                gradientColor.setVisible(true);
                break;
        }
        this.repaint();
    }//GEN-LAST:event_comboBoxFillListActionPerformed

    private void comboBoxStrokeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStrokeListActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        switch (comboBoxStrokeList.getSelectedIndex()) {
            case Lienzo.STROKE_CONTINUOUS: //Línea continua
                Lienzo.setStrokeType(Lienzo.STROKE_CONTINUOUS);
                Lienzo.setStrokeColor(strokeColor.getBackground());
                Lienzo.setStrokeWidth(Float.parseFloat(grosor.getValue().toString()));
                if (vi != null) {
                    vi.getLienzo().changeStrokeTypeProperty(Lienzo.STROKE_CONTINUOUS);
                }
                break;
            case Lienzo.STROKE_DISCONTINUOUS://Línea DIScontinua
                Lienzo.setStrokeType(Lienzo.STROKE_DISCONTINUOUS);
                Lienzo.setStrokeColor(strokeColor.getBackground());
                Lienzo.setStrokeWidth(Float.parseFloat(grosor.getValue().toString()));
                if (vi != null) {
                    vi.getLienzo().changeStrokeTypeProperty(Lienzo.STROKE_DISCONTINUOUS);
                }
                break;
        }
    }//GEN-LAST:event_comboBoxStrokeListActionPerformed

    private void strokeColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_strokeColorMouseClicked
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (evt.getClickCount() % 2 == 0 || strokeColor.getBackground() == null) {
            Color newColor = JColorChooser.showDialog(
                    VentanaPrincipal.this,
                    "Escoge un color para el TRAZO",
                    strokeColor.getBackground());
            if (newColor != null) {
                strokeColor.setBackground(newColor);
                Lienzo.setStrokeColor(strokeColor.getBackground());
            }
        } else if (evt.getClickCount() % 2 == 1) {
            Lienzo.setStrokeColor(strokeColor.getBackground());
        }
        if (vi != null) {
            vi.getLienzo().changeColorProperty(Lienzo.COLOR_STROKE, strokeColor.getBackground(), null);
        }
    }//GEN-LAST:event_strokeColorMouseClicked

    private void fillColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fillColorMouseClicked
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (evt.getClickCount() % 2 == 0 || fillColor.getBackground() == null) {
            Color newColor = JColorChooser.showDialog(
                    VentanaPrincipal.this,
                    "Escoge un color de RELLENO",
                    fillColor.getBackground());
            if (newColor != null) {
                fillColor.setBackground(newColor);
                Lienzo.setFillColor(fillColor.getBackground());
            }
        } else if (evt.getClickCount() % 2 == 1) {
            Lienzo.setFillColor(fillColor.getBackground());
        }
        if (vi != null) {
            vi.getLienzo().changeColorProperty(Lienzo.COLOR_FILL, fillColor.getBackground(), null);
        }
    }//GEN-LAST:event_fillColorMouseClicked

    private void comboBoxStyleStrokeJoinListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStyleStrokeJoinListActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        switch (comboBoxStyleStrokeJoinList.getSelectedIndex()) {
            case Lienzo.STYLE_STROKE_JOIN_BEVEL:
                Lienzo.setStrokeStyleJoinType(Lienzo.STYLE_STROKE_JOIN_BEVEL);

                if (vi != null) {
                    vi.getLienzo().changeStrokeStyleJoinProperty(Lienzo.STYLE_STROKE_JOIN_BEVEL);
                }
                break;
            case Lienzo.STYLE_STROKE_JOIN_MITER:
                Lienzo.setStrokeStyleJoinType(Lienzo.STYLE_STROKE_JOIN_MITER);
                if (vi != null) {
                    vi.getLienzo().changeStrokeStyleJoinProperty(Lienzo.STYLE_STROKE_JOIN_MITER);
                }
                break;
            case Lienzo.STYLE_STROKE_JOIN_ROUND:
                Lienzo.setStrokeStyleJoinType(Lienzo.STYLE_STROKE_JOIN_ROUND);
                if (vi != null) {
                    vi.getLienzo().changeStrokeStyleJoinProperty(Lienzo.STYLE_STROKE_JOIN_ROUND);
                }
                break;
        }
    }//GEN-LAST:event_comboBoxStyleStrokeJoinListActionPerformed

    private void reloadShapesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadShapesActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            Vector<String> listData = new Vector();
            int i = 0;
            for (IOShape s : vi.getLienzo().getvShape()) {
                listData.add(s.getName() + " " + ++i);
            }
            figureList.setListData(listData);
            if (!vi.getLienzo().getvShapeSelected().isEmpty()) {
                int selectedIndices[] = new int[vi.getLienzo().getvShapeSelected().size()];
                i = 0;
                for (Integer index : vi.getLienzo().getvShapeSelected()) {
                    selectedIndices[i++] = index;
                }
                figureList.setSelectedIndices(selectedIndices);
            }
        } else {
            figureList.setListData(new Vector());
        }
    }//GEN-LAST:event_reloadShapesActionPerformed

    private void figureListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_figureListMouseClicked

        VentanaInternaImagen vi = (VentanaInternaImagen) escritorio.getSelectedFrame();
        if (vi != null) {
            int selectedShapes[] = figureList.getSelectedIndices();
            vi.getLienzo().getvShapeSelected().clear();
            vi.getLienzo().getvShape();
            for (int index : selectedShapes) {
                vi.getLienzo().getvShapeSelected().add(index);
                vi.getLienzo().getVdXY().add(new Point2D.Double());
                repaint();
            }
            //System.err.println(vi.getLienzo().getvShape().get(vi.getLienzo().getvShapeSelected().get(0)).);

            removeShape.setEnabled(true);
            cloneShape.setEnabled(true);

        }
    }//GEN-LAST:event_figureListMouseClicked

    private void removeShapeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeShapeMouseClicked
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            int selectedIndices[] = figureList.getSelectedIndices();
            if (selectedIndices.length > 0) {
                //Lo recorro al revés para no tener problemas al eliminar del array, ya que si eliminas una posición
                //intermedia, se cambian los índices de los demás elementos.
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    vi.getLienzo().getvShape().remove(selectedIndices[i]);
                }

                vi.getLienzo().getvShapeSelected().clear();
                Vector<String> listData = new Vector();
                int i = 0;
                for (IOShape s : vi.getLienzo().getvShape()) {
                    listData.add(s.getName() + " " + ++i);
                }
                figureList.setListData(listData);
                removeShape.setEnabled(false);
                cloneShape.setEnabled(false);
                repaint();
            }
        }
    }//GEN-LAST:event_removeShapeMouseClicked

    private void cloneShapeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cloneShapeMouseClicked
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            int selectedIndices[] = figureList.getSelectedIndices();
            if (selectedIndices.length > 0) {
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    vi.getLienzo().getvShape().add(vi.getLienzo().getvShape().get(selectedIndices[i]).clone());
                }
                Vector<String> listData = new Vector();
                int i = 0;
                for (IOShape sh : vi.getLienzo().getvShape()) {
                    listData.add(sh.getName() + " " + ++i);
                }
                figureList.setListData(listData);
                repaint();
            }
        }
    }//GEN-LAST:event_cloneShapeMouseClicked

    private void comboBoxStyleStrokeCapListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStyleStrokeCapListActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        switch (comboBoxStyleStrokeCapList.getSelectedIndex()) {
            case Lienzo.STYLE_STROKE_CAP_BUTT:
                Lienzo.setStrokeStyleCapType(Lienzo.STYLE_STROKE_CAP_BUTT);

                if (vi != null) {
                    vi.getLienzo().changeStrokeStyleCapProperty(Lienzo.STYLE_STROKE_CAP_BUTT);
                }
                break;
            case Lienzo.STYLE_STROKE_CAP_ROUND:
                Lienzo.setStrokeStyleCapType(Lienzo.STYLE_STROKE_CAP_ROUND);
                if (vi != null) {
                    vi.getLienzo().changeStrokeStyleCapProperty(Lienzo.STYLE_STROKE_CAP_ROUND);
                }
                break;
            case Lienzo.STYLE_STROKE_CAP_SQUARE:
                Lienzo.setStrokeStyleCapType(Lienzo.STYLE_STROKE_CAP_SQUARE);
                if (vi != null) {
                    vi.getLienzo().changeStrokeStyleCapProperty(Lienzo.STYLE_STROKE_CAP_SQUARE);
                }
                break;
        }
    }//GEN-LAST:event_comboBoxStyleStrokeCapListActionPerformed

    private void iconTakeScreenshotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconTakeScreenshotActionPerformed
        menuTakeScreenshotActionPerformed(null);
    }//GEN-LAST:event_iconTakeScreenshotActionPerformed

    private void iconWebcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconWebcamActionPerformed
        VentanaInternaCamara.showWebcam();
    }//GEN-LAST:event_iconWebcamActionPerformed

    private void menuSoundRecorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSoundRecorderActionPerformed
        VentanaInternaGrabador.showSoundRecorder();
    }//GEN-LAST:event_menuSoundRecorderActionPerformed

    private void menuWebcamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuWebcamActionPerformed
        VentanaInternaCamara.showWebcam();
    }//GEN-LAST:event_menuWebcamActionPerformed

    private void menuTakeScreenshotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTakeScreenshotActionPerformed

        BufferedImage img = null;
        if (escritorio.getSelectedFrame() instanceof VentanaInternaCamara) {
            VentanaInternaCamara viC = (VentanaInternaCamara) escritorio.getSelectedFrame();
            img = viC.getFrame();
        } else if (escritorio.getSelectedFrame() instanceof VentanaInternaJMFPlayer) {
            VentanaInternaJMFPlayer viJmf = (VentanaInternaJMFPlayer) escritorio.getSelectedFrame();
            img = viJmf.getFrame();
        }
        if (img != null) {
            JFileChooser dlg = new JFileChooser();
            dlg.addChoosableFileFilter(new GIFImageFileFilter());
            dlg.addChoosableFileFilter(new JPEGImageFileFilter());
            dlg.addChoosableFileFilter(new JPGImageFileFilter());
            dlg.addChoosableFileFilter(new PNGImageFileFilter());
            int resp = dlg.showSaveDialog(this);
            if (resp == JFileChooser.APPROVE_OPTION) {
                File f = dlg.getSelectedFile();
                VentanaInternaImagen.showImage(img, f.getName());
            }
        }

    }//GEN-LAST:event_menuTakeScreenshotActionPerformed

    private void iconSoundRecorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconSoundRecorderActionPerformed
        VentanaInternaGrabador.showSoundRecorder();
    }//GEN-LAST:event_iconSoundRecorderActionPerformed

    private void showToolBarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showToolBarColorActionPerformed
        if (!showToolBarColor.isSelected()) {
            barraColor.setVisible(false);
        } else {
            barraColor.setVisible(true);
        }
    }//GEN-LAST:event_showToolBarColorActionPerformed

    private void showToolBarImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showToolBarImageActionPerformed
        if (!showToolBarImage.isSelected()) {
            barraImagen.setVisible(false);
        } else {
            barraImagen.setVisible(true);
        }
    }//GEN-LAST:event_showToolBarImageActionPerformed

    private void showToolBarMultimediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showToolBarMultimediaActionPerformed
        if (!showToolBarMultimedia.isSelected()) {
            botonesMultimedia.setVisible(false);
        } else {
            botonesMultimedia.setVisible(true);
        }
    }//GEN-LAST:event_showToolBarMultimediaActionPerformed

    private void iconNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconNewActionPerformed
        nuevoActionPerformed(null);
    }//GEN-LAST:event_iconNewActionPerformed

    private void iconOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconOpenActionPerformed
        abrirActionPerformed(null);
    }//GEN-LAST:event_iconOpenActionPerformed

    private void iconSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconSaveActionPerformed
        guardarActionPerformed(null);
    }//GEN-LAST:event_iconSaveActionPerformed

    private void escritorioComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_escritorioComponentShown
    }//GEN-LAST:event_escritorioComponentShown

    private void sliderUmbralizacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderUmbralizacionStateChanged

        VentanaInternaImagen vii = (VentanaInternaImagen) selectInternalWindows();
        if (vii != null) {
            BufferedImage imgSource = vii.getLienzo().getImageOriginal();
            if (imgSource != null) {
                ThresholdOp umbralizacionBarra;
                //System.err.println("valor: "+sliderUmbralizacion.getValue());
                if (thresholdingType == ThresholdOp.TYPE_COLOR) {
                    umbralizacionBarra = new ThresholdOp(thresholdingColor, sliderUmbralizacion.getValue());
                } else { // thresholdingType == ThresholdOp.TYPE_GREY_LEVEL
                    thresholdingType = ThresholdOp.TYPE_GREY_LEVEL;
                    umbralizacionBarra = new ThresholdOp(sliderUmbralizacion.getValue());
                }
                umbralizacionBarra.setType(thresholdingType);
                //umbralizacionBarra.setThreshold(sliderUmbralizacion.getValue());
                BufferedImage imgdest = umbralizacionBarra.filter(imgSource, null);

                if (imgdest != null) {
                    vii.getLienzo().setImageActual(imgdest);
                    vii.getLienzo().repaint();
                }
            }
        }

    }//GEN-LAST:event_sliderUmbralizacionStateChanged

    private void sliderUmbralizacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sliderUmbralizacionFocusLost
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            vi.getLienzo().setImageOriginal(vi.getLienzo().getImageActual());
        }
    }//GEN-LAST:event_sliderUmbralizacionFocusLost

    private void buttonThresholdingRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThresholdingRedActionPerformed
        ((JButton) evt.getSource()).setSelected(true);
        thresholdingColor = buttonThresholdingRed.getBackground();
    }//GEN-LAST:event_buttonThresholdingRedActionPerformed

    private void buttonThresholdingBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThresholdingBlueActionPerformed
        ((JButton) evt.getSource()).setSelected(true);
        thresholdingColor = buttonThresholdingBlue.getBackground();
    }//GEN-LAST:event_buttonThresholdingBlueActionPerformed

    private void buttonThresholdingGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThresholdingGreenActionPerformed
        ((JButton) evt.getSource()).setSelected(true);
        thresholdingColor = buttonThresholdingGreen.getBackground();
    }//GEN-LAST:event_buttonThresholdingGreenActionPerformed

    private void comboBoxUmbralizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUmbralizacionActionPerformed

        switch (comboBoxUmbralizacion.getSelectedIndex()) {
            case 0: //Gris
                buttonThresholdingRed.setVisible(false);
                buttonThresholdingGreen.setVisible(false);
                buttonThresholdingBlue.setVisible(false);
                buttonThresholdingColorPalette.setVisible(false);
                thresholdingType = ThresholdOp.TYPE_GREY_LEVEL;
                break;
            case 1:  //Color
                buttonThresholdingRed.setVisible(true);
                buttonThresholdingGreen.setVisible(true);
                buttonThresholdingBlue.setVisible(true);
                buttonThresholdingColorPalette.setVisible(true);
                thresholdingType = ThresholdOp.TYPE_COLOR;
                if (thresholdingColor == null) {
                    thresholdingColor = Color.RED;
                    buttonThresholdingRed.setSelected(true);
                }
                break;
        }


    }//GEN-LAST:event_comboBoxUmbralizacionActionPerformed

    private void buttonThresholdingColorPaletteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonThresholdingColorPaletteMouseClicked
        if (evt.getClickCount() % 2 == 0 || buttonThresholdingColorPalette.getIcon() != null) {
            Color newColor = JColorChooser.showDialog(
                    VentanaPrincipal.this,
                    "Escoge el color para la Umbralización",
                    gradientColor.getBackground());
            if (newColor != null) {
                thresholdingColor = newColor;
                buttonThresholdingColorPalette.setIcon(null);
                buttonThresholdingColorPalette.setBackground(newColor);
            }
        } else if (evt.getClickCount() % 2 == 1) {
            thresholdingColor = buttonThresholdingColorPalette.getBackground();
        }
        ((JButton) evt.getSource()).setSelected(true);

    }//GEN-LAST:event_buttonThresholdingColorPaletteMouseClicked

    private void negativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativeActionPerformed
        try {
            VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
            if (vi != null) {
                BufferedImage imgActual = convertImageType(vi.getLienzo().getImageActual(), BufferedImage.TYPE_INT_RGB);
                LookupTable ltp = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_NEGATIVE);
                LookupOp lop = new LookupOp(ltp, null);
                BufferedImage imgdest = lop.filter(imgActual, null);

                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el contraste");
        }
    }//GEN-LAST:event_negativeActionPerformed

    private void menuChangeGreyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChangeGreyActionPerformed
        try {
            VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
            if (vi != null) {
                ICC_Profile ip;
                ip = ICC_Profile.getInstance(ColorSpace.CS_GRAY);
                ColorSpace cs = new ICC_ColorSpace(ip);
                ColorConvertOp ccop = new ColorConvertOp(cs, null);
                BufferedImage imgdest = ccop.filter(vi.getLienzo().getImageOriginal(), null);

                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    vi.getLienzo().repaint();
                    activateFilterColorImage(false);
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el contraste");
        }


    }//GEN-LAST:event_menuChangeGreyActionPerformed

    private void menuCloneImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCloneImageActionPerformed
        try {
            VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
            if (vi != null) {
                VentanaInternaImagen.showImage(vi.getLienzo().getImageOriginal(), vi.getTitle() + " Duplicada");
            }
        } catch (Exception e) {
            System.err.println("Error en el contraste");
        }
    }//GEN-LAST:event_menuCloneImageActionPerformed

    private void menuArtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArtFilterActionPerformed
        VentanaInternaImagen vi = (VentanaInternaImagen) selectInternalWindows();
        if (vi != null) {
            //Filtro Sobel
            BufferedImage imgSource = vi.getLienzo().getImageActual();
            if (imgSource != null) {
                SobelOp sobel = new SobelOp();
                BufferedImage imgdest = sobel.filter(imgSource, null);

                //Filtro Negativo
                imgdest = convertImageType(imgdest, BufferedImage.TYPE_INT_RGB);
                LookupTable ltp = LookupTableProducer.createLookupTable(LookupTableProducer.TYPE_NEGATIVE);
                LookupOp lop = new LookupOp(ltp, null);
                imgdest = lop.filter(imgdest, null);

                //Paso a Gris
                ICC_Profile ip;
                ip = ICC_Profile.getInstance(ColorSpace.CS_GRAY);
                ColorSpace cs = new ICC_ColorSpace(ip);
                ColorConvertOp ccop = new ColorConvertOp(cs, null);
                imgdest = ccop.filter(imgdest, null);

                //Guardo la imagen
                if (imgdest != null) {
                    vi.getLienzo().setImageOriginal(imgdest);
                    activateFilterColorImage(false);
                    vi.getLienzo().repaint();
                }
            }
        }
    }//GEN-LAST:event_menuArtFilterActionPerformed

    /**
     * Devuleve un objeto de VentanaInterna.
     *
     * ver {@link VentanaInternaImagen}
     *
     * @return Devuelve un atributo de la clase de tipo VentanaInternaImagen.
     */
    public VentanaInternaImagen getVentanaInterna() {
        return vi;
    }

    /**
     * Modifica la ventana interna de actual.
     *
     * @param vi Ventana interna que pasará a ser la actual.
     */
    public void setVentanaInterna(VentanaInternaImagen vi) {
        this.vi = vi;
    }

    /**
     * Genera una lista de figuras dibujadas y añade cada figura como items al
     * panel derecho de la interfaz.
     *
     * @param vi Se usarán las figuras dibujadas en la VentanaInterna pasada por
     * parámetro.
     */
    public void eventoEscritorioShapes(VentanaInternaImagen vi) {
        if (vi != null) {
            Vector<String> listData = new Vector();
            int i = 0;
            for (IOShape s : vi.getLienzo().getvShape()) {
                listData.add(s.getName() + " " + ++i);
            }
            figureList.setListData(listData);
            if (!vi.getLienzo().getvShapeSelected().isEmpty()) {
                int selectedIndices[] = new int[vi.getLienzo().getvShapeSelected().size()];
                i = 0;
                for (Integer index : vi.getLienzo().getvShapeSelected()) {
                    selectedIndices[i++] = index;
                }
                figureList.setSelectedIndices(selectedIndices);
            }
        }
    }

    /**
     * Evento que tiene en cuenta cuando presionas alguna tecla. Está desde que
     * se crea la instancia de Ventana principal en funcionamiento.
     *
     * El único funcionamiento por ahora es que al pulsar la tecla ESC se
     * deseleccionan las figuras seleccionadas en una VentanaInterna.
     */
    public final void keyboardEvent() {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    if (e.getKeyCode() == e.VK_ESCAPE) {
                        if (vi != null) {
                            vi.getLienzo().getvShapeSelected().clear();
                            repaint();
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    public final VentanaInternaImagen newWindows() {

        final VentanaInternaImagen vi = new VentanaInternaImagen();
        escritorio.add(vi);
        vi.setTitle("Lienzo " + ++numVentanas);
        vi.setVisible(true);
        setVentanaInterna(vi);
        vi.getLienzo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventoEscritorioShapes(vi);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                eventoEscritorioShapes(vi);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                eventoEscritorioShapes(vi);
                repaint();
            }
        });
        eventoEscritorioShapes(vi);
        return vi;
    }

    /**
     * Crea una nueva ventana que tiene en cuenta el ancho y el alto a la hora
     * de mostrarla en el escritorio.
     *
     * No se tienen en cuenta las barras de desplazamiento en el ancho y alto.
     *
     * Este método crea un MouseListener al Lienzo para tener en cuenta cuando
     * se dibuja una figura y pintarla en el panel derecho.
     *
     * @param width Ancho de la ventana.
     * @param height Alto de la ventana.
     * @return Devuelve una nueva VentanaInternaImagen.
     */
    public final VentanaInternaImagen newWindows(int width, int height) {
        final VentanaInternaImagen vi = new VentanaInternaImagen();
        escritorio.add(vi);
        vi.setSize(width, height);
        vi.setTitle("Lienzo " + ++numVentanas);
        vi.setVisible(true);
        setVentanaInterna(vi);
        vi.getLienzo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eventoEscritorioShapes(vi);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                eventoEscritorioShapes(vi);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                eventoEscritorioShapes(vi);
                repaint();
            }
        });
        eventoEscritorioShapes(vi);
        return vi;
    }

    /**
     * Método que devuelve la última ventana seleccionada.
     *
     * Devuelve <strong>null</strong> en caso de no seleccionar ninguna.
     *
     * @return Una ventana de tipo JInternalFrame ó null.
     */
    public javax.swing.JInternalFrame selectInternalWindows() {
        if (escritorio.getSelectedFrame() instanceof VentanaInternaImagen) {
            VentanaInternaImagen vi = (VentanaInternaImagen) escritorio.getSelectedFrame();
            eventoEscritorioShapes(vi);
            showToolsBarsOrNot(SHOW_TOOLBAR_IMAGE);
            repaint();
            return vi;
        } else if (escritorio.getSelectedFrame() instanceof VentanaInternaReproductor) {
            showToolsBarsOrNot(SHOW_TOOLBAR_SOUND);
            repaint();
            return (VentanaInternaReproductor) escritorio.getSelectedFrame();
        } else if (escritorio.getSelectedFrame() instanceof VentanaInternaGrabador) {
            showToolsBarsOrNot(SHOW_TOOLBAR_SOUND);
            repaint();
            return (VentanaInternaGrabador) escritorio.getSelectedFrame();
        } else if (escritorio.getSelectedFrame() instanceof VentanaInternaJMFPlayer) {
            showToolsBarsOrNot(SHOW_TOOLBAR_JMF);
            repaint();
            return (VentanaInternaJMFPlayer) escritorio.getSelectedFrame();
        } else if (escritorio.getSelectedFrame() instanceof VentanaInternaCamara) {
            showToolsBarsOrNot(SHOW_TOOLBAR_CAMERA);
            repaint();
            return (VentanaInternaCamara) escritorio.getSelectedFrame();
        } else {
            return null;
        }
    }

    /**
     * Muestra ú oculta dependiendo del valor medido las barras de tareas que no
     * corresponden con el entero <strong>media</strong>.
     *
     * Constantes:
     * <ul>
     * <li> SHOW_TOOLBAR_IMAGE = 0</li>
     * <li> SHOW_TOOLBAR_SOUND = 1</li>
     * <li> SHOW_TOOLBAR_JMF = 2</li>
     * <li> SHOW_TOOLBAR_CAMERA = 3</li>
     * </ul>
     *
     * @param media Constante que indica el tipo de medio actual seleccionado.
     */
    public void showToolsBarsOrNot(int media) {
        boolean image = false;
        boolean buttonSave = false;
        boolean buttonTakeScreenshot = false;

        switch (media) {
            case SHOW_TOOLBAR_IMAGE:
                image = true;
                buttonSave = true;
                buttonTakeScreenshot = false;
                break;
            case SHOW_TOOLBAR_CAMERA:
                image = false;
                buttonSave = false;
                buttonTakeScreenshot = true;
                break;
            case SHOW_TOOLBAR_JMF:
                image = false;
                buttonSave = false;
                buttonTakeScreenshot = true;
                break;
            case SHOW_TOOLBAR_SOUND:
                image = false;
                buttonSave = false;
                buttonTakeScreenshot = false;
                break;
        }
        //Image
        menuImagen.setEnabled(image);
        botonesFiguras.setVisible(image);
        barraColor.setVisible(image);
        barraImagen.setVisible(image);
        panelDerechoImagen.setVisible(image);
        showToolBarColor.setEnabled(image);
        showToolBarImage.setEnabled(image);
        //buttonSave
        iconSave.setEnabled(buttonSave);
        guardar.setEnabled(buttonSave);
        //Button screenshot
        iconTakeScreenshot.setEnabled(buttonTakeScreenshot);
        menuTakeScreenshot.setEnabled(buttonTakeScreenshot);

    }

    /**
     * Devuelve una variable de tipo JMenuItem de la interfaz para poder
     * modificar los valores del componente.
     *
     * Esta es una opción de: Imagen (Menú) / Sobel.
     *
     * @return Devuelve el componente sobelMenu.
     */
    public JMenuItem getSobelMenu() {
        return sobelMenu;
    }

    /**
     * Devuelve una variable de tipo JComboBox de la interfaz para poder
     * modificar los valores del componente.
     *
     * Esta es una opción del panel: Imagen (Barra herramientas) /
     * comboBoxUmbralizacion
     *
     * @return Devuelve el componente comboBoxUmbralizacion.
     */
    public JComboBox getComboBoxUmbralizacion() {
        return comboBoxUmbralizacion;
    }

    /**
     * Devuelve el componente del menú de imagen, Filtro artístico.
     *
     * @return un componente de la interfaz del Menú de tipo JMenuItem.
     */
    public JMenuItem getMenuArtFilter() {
        return menuArtFilter;
    }

    /**
     * Activa/Desactiva los filtros de imagen de COLOR dependiendo del parámetro
     * booleano pasado.
     *
     * @param b Habilitará si la booleana es true, y deshabilitará los filtros
     * si es false.
     */
    public void activateFilterColorImage(boolean b) {
        sobelMenu.setEnabled(b);
        comboBoxUmbralizacion.setEnabled(b);
        sliderUmbralizacion.setEnabled(b);
        menuArtFilter.setEnabled(b);

        repaint();
    }

    /**
     * Devuelve un JList, que viene a ser los elementos que hay en el panel de
     * las formas (en la derecha).
     *
     * Sirve sobretodo para saber qué elementos hay y des/seleccionarlos.
     *
     * @return Devuelve un componente de tipo JList
     */
    public JList getFigureList() {
        return figureList;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BotonesMenu;
    private javax.swing.ButtonGroup GrupoColores;
    private javax.swing.JMenuItem abrir;
    private javax.swing.JToolBar barraColor;
    private javax.swing.JToolBar barraImagen;
    private javax.swing.JButton botonAumentar;
    private javax.swing.JButton botonColorAmarillo;
    private javax.swing.JButton botonColorAzul;
    private javax.swing.JButton botonColorBlanco;
    private javax.swing.JButton botonColorNegro;
    private javax.swing.JButton botonColorRojo;
    private javax.swing.JButton botonColorVerde;
    private javax.swing.JButton botonContraste;
    private javax.swing.JToggleButton botonCurvaControl;
    private javax.swing.JToggleButton botonCurvaCubicaSegmentada;
    private javax.swing.JButton botonDisminuir;
    private javax.swing.JButton botonIluminar;
    private javax.swing.JToggleButton botonLapiz;
    private javax.swing.JToggleButton botonLinea;
    private javax.swing.JButton botonOscurecer;
    private javax.swing.JToggleButton botonOvalo;
    private javax.swing.JToggleButton botonRectangulo;
    private javax.swing.JToggleButton botonRectanguloRedondeado;
    private javax.swing.JButton botonRotacion180;
    private javax.swing.JButton botonRotacion270;
    private javax.swing.JButton botonRotacion90;
    private javax.swing.JToolBar botonesArchivo;
    private javax.swing.JToolBar botonesFiguras;
    private javax.swing.JToolBar botonesMultimedia;
    private javax.swing.JButton buttonThresholdingBlue;
    private javax.swing.JButton buttonThresholdingColorPalette;
    private javax.swing.JButton buttonThresholdingGreen;
    private javax.swing.JButton buttonThresholdingRed;
    private javax.swing.JButton cloneShape;
    private javax.swing.ButtonGroup coloresUmbralizacion;
    private javax.swing.JComboBox comboBoxEffectsList;
    private javax.swing.JComboBox comboBoxFillList;
    private javax.swing.JComboBox comboBoxStrokeList;
    private javax.swing.JComboBox comboBoxStyleStrokeCapList;
    private javax.swing.JComboBox comboBoxStyleStrokeJoinList;
    private javax.swing.JComboBox comboBoxUmbralizacion;
    private javax.swing.JPanel contenedorBorde;
    private javax.swing.JPanel contenedorBrillo;
    private javax.swing.JPanel contenedorColores;
    private javax.swing.JPanel contenedorContraste;
    private javax.swing.JPanel contenedorEfecto;
    private javax.swing.JPanel contenedorEscala;
    private javax.swing.JPanel contenedorEstiloBorde;
    private javax.swing.JPanel contenedorFiguras;
    private javax.swing.JPanel contenedorRelleno;
    private javax.swing.JPanel contenedorRotacion;
    private javax.swing.JPanel contenedorUmbralizacion;
    private javax.swing.JPanel cuerpo;
    private static javax.swing.JDesktopPane escritorio;
    private javax.swing.JList figureList;
    private javax.swing.JButton fillColor;
    private javax.swing.JButton gradientColor;
    private javax.swing.JSpinner grosor;
    private javax.swing.ButtonGroup grupoPaletas;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JButton iconNew;
    private javax.swing.JButton iconOpen;
    private javax.swing.JButton iconSave;
    private javax.swing.JButton iconSoundRecorder;
    private javax.swing.JButton iconTakeScreenshot;
    private javax.swing.JButton iconWebcam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelFigura;
    private javax.swing.JLabel labelTextBorderColor;
    private javax.swing.JLabel labelTextFillColor;
    private javax.swing.JLabel labelTextGradientColor;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuArtFilter;
    private javax.swing.JMenuItem menuChangeGrey;
    private javax.swing.JMenuItem menuCloneImage;
    private javax.swing.JMenuItem menuConvolveOp;
    private javax.swing.JMenu menuImagen;
    private javax.swing.JMenu menuMultimedia;
    private javax.swing.JMenuItem menuRescaleOp;
    private javax.swing.JMenuItem menuSoundRecorder;
    private javax.swing.JMenuItem menuTakeScreenshot;
    private javax.swing.JMenu menuVer;
    private javax.swing.JMenuItem menuWebcam;
    private javax.swing.JMenuItem multiplicar;
    private javax.swing.JMenuItem negative;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JPanel paletaOpciones;
    private javax.swing.JPanel panelColores;
    private javax.swing.JPanel panelDerechoImagen;
    private javax.swing.JPanel panelLabelFigura;
    private javax.swing.JPanel paneles;
    private javax.swing.JPanel pie;
    private javax.swing.JButton reloadShapes;
    private javax.swing.JButton removeShape;
    private javax.swing.JMenuItem restar;
    private javax.swing.JCheckBoxMenuItem showToolBarColor;
    private javax.swing.JCheckBoxMenuItem showToolBarImage;
    private javax.swing.JCheckBoxMenuItem showToolBarMultimedia;
    private javax.swing.JSlider sliderBrillo;
    private javax.swing.JSlider sliderRotacion;
    private javax.swing.JSlider sliderUmbralizacion;
    private javax.swing.JMenuItem sobelMenu;
    private javax.swing.JButton strokeColor;
    private javax.swing.JMenuItem umbralizacion;
    private javax.swing.JCheckBoxMenuItem verBarraEstado;
    // End of variables declaration//GEN-END:variables
}
