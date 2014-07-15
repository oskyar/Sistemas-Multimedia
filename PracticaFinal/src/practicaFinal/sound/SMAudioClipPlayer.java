package practicaFinal.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Reproductor de audio basado en la clase AudioClip
 * @author Jesus Chamorro
 */
public class SMAudioClipPlayer implements SMPlayer{
    
    private AudioClip audio;
    private URL url;
    
/**
 * 
 * @param f File
 */
    public SMAudioClipPlayer(File f){
        try {
            url = new URL("file:"+f.getAbsolutePath());
        } catch (MalformedURLException ex) {
            url=null;
        }
    }
       
    /**
     *  Lanza el proceso de reproducción 
     */
    @Override
    public void play() {
        try{    
            audio = Applet.newAudioClip(url);
            audio.play();
        } catch (Exception e) {
            System.err.println("SMAudioClipPlayer: "+e);
        }   
    } 
    
    /**
     *  Detiene el proceso de reproducción 
     */
    @Override
    public void stop(){
        audio.stop();
    }
    
}
