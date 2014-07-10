package practicaFinal.sound;

import java.io.File;
import javax.sound.sampled.*;

/**
 * Reproductor de audio basado en la clase 'Clip' de la Java Sound API
 * @author Jesus Chamorro
 */
public class SMClipPlayer implements SMPlayer{
  
    public Clip sound;
    private LineListener lineListener = null;
    private File soundFile;
    
    /**
     *  Constructor 
     */
    public SMClipPlayer(File f){
      soundFile = f;  
    }
    
    /**
     *  Lanza el proceso de reproducción 
     */
    @Override
    public void play() {
       try {
            sound = AudioSystem.getClip(); //Provee de mezclador y línea por defecto
            sound.addLineListener(lineListener);
            sound.open(AudioSystem.getAudioInputStream(soundFile));
            sound.start();
        } 
        catch (Exception e) {
          System.err.println("SMClipPlayer: "+e);
        } 
    }
    
    /**
     *  Detiene el proceso de reproducción 
     */
    @Override
    public void stop(){
        sound.close();
    }
    
    /**
     *  Activa el manejador de eventos 
     */
    public void setLineListener(LineListener l){
        lineListener = l;
    }
    
    /**
     *  Imprime información de la línea 
     */
    public void printInfo(){
        // Información de línea
        Line.Info infoLine = sound.getLineInfo();
        System.out.println("Información de línea: "+infoLine.toString());
        // Controles
        Control c[] = sound.getControls();
        System.out.println("Controles de la línea: ");
        for(int i=0;i<c.length;i++)
            System.out.println("   ["+i+"] "+c[i].getType()+" : "+c[i]);
        System.out.println();
    }
}
