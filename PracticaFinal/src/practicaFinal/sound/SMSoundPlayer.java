package practicaFinal.sound;

import java.io.File;
import javax.sound.sampled.*;

/**
 * Reproductor de audio basado en la clase 'SourceDataLine' de la Java Sound API
 *
 * @author Jesus Chamorro
 */
public class SMSoundPlayer implements SMPlayer {

    // Constante para reproductor
    private static final int EXTERNAL_BUFFER_SIZE = 128000;
    // Variables
    private DataLine line;
    private LineListener lineListener = null;
    private File soundFile;

    /**
     *
     * @param f File
     */
    public SMSoundPlayer(File f) {
        soundFile = f;
    }

    /**
     * Lanza el proceso de reproducción creando una hebra
     */
    @Override
    public void play() {
        // Creamos la hebra sobrecargando el método run()
        Thread thread = new Thread() {
            public void run() {
                startPlay();
            }
        };
        thread.start(); // Lanzamos la hebra
    }

    /**
     * Detiene el proceso de reproducción
     */
    @Override
    public void stop() {
        if (line != null) {
            line.stop();
            line.close();
        }
        /* La hebra se cierra automáticamente: al cerrar la línea, el método 
         *  run() finaliza (al finalizar las llamadas 'write') y, con ello,
         *  la hebra */
    }

    /**
     * Lleva a cabo la reproducción del fichero 'soundFile' usando los valores
     * por defecto (veánse constantes).
     *
     * IMPORTANTE: Este método no devuelve el control hasta que acaba la
     * reproducción (mientras haya datos que leer mediante las llamadas a
     * 'read'). Por este motivo, se aconseja llamarlo dentro de una hebra .
     */
    private void startPlay() {
        // Creamos el stream de entrada a partir del fichero
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            System.err.println("SMSoundPlayer: " + e);
        }
        // Obtenemnos el formato de audio (que usaremos para crear una línea acorde al fichero)  
        AudioFormat audioFormat = audioInputStream.getFormat();
        // Creamos la línea 
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine sourceDataLine = null;
        try {
            line = sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
            line.addLineListener(lineListener);
            sourceDataLine.open(audioFormat);
        } catch (Exception e) {
            System.err.println("SMSoundPlayer: " + e);
        }
        // Activamos la línea
        sourceDataLine.start();
        // La línea está preparada para escribir datos sobre ella. Para ello, en un bucle, leeremos datos
        // del AudioInputStream a un buffer y de éste lo pasaremos a la línea         
        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    sourceDataLine.write(abData, 0, nBytesRead);
                }
            } catch (Exception e) {
                System.err.println("SMSoundPlayer: " + e);
            }
        }
        // La reproducción ha acabado, cerramos la línea
        sourceDataLine.drain();
        sourceDataLine.close();
    }

    /**
     * Activa el manejador de eventos
     *
     * @param l LineListener
     */
    public void setLineListener(LineListener l) {
        lineListener = l;
    }

}
