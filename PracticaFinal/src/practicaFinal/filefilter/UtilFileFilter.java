/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaFinal.filefilter;

import java.io.File;

/**
 *
 * @author oskyar
 */
public class UtilFileFilter {
    //Extensiones válidas
    public static enum Extensions{
        jpg, jpeg, gif, png, wav, midi, mp3, avi
    };
    
    public static enum SoundExtensions{
        wav, midi, mp3
    };

    public static enum ImageExtensions{
        jpg, jpeg, gif, png
    };
    
    public static enum VideoExtensions{
        avi
    };
    /**
     * Devuelve la extensión de un fichero 
     * @param f Fichero
     * @return Extensión del fichero.
     */
    public static String getExtension(File f){
        String name = f.getName();
        //Guardo en la última posición que encuentra el punto (el punto inclusive)
        int lastPoint = name.lastIndexOf(".");
        //Si no encuentro extensión devuelvo null
        if(lastPoint == -1){
            return null;
        }
        //Le sumo uno para que no tenga en cuenta el punto
        lastPoint++;
        //Extraigo la extensión
        String ext = name.substring(lastPoint);
        ext = ext.toLowerCase();
        return ext;
    }
    
    public static boolean isAccepted(String ext){
        ext = ext.toLowerCase();
        for (Extensions ext2 : Extensions.values()) {
            if(ext.equals(ext2.toString())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isAccepted(File f){
        String ext = getExtension(f);
        ext = ext.toLowerCase();
        for (Extensions ext2 : Extensions.values()) {
            if(ext.equals(ext2.toString())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isVideo(File f){
        String ext = getExtension(f);
        ext = ext.toLowerCase();
        for (VideoExtensions ext2 : VideoExtensions.values()) {
            if(ext.equals(ext2.toString())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isVideo(String ext){
        ext = ext.toLowerCase();
        for (VideoExtensions ext2 : VideoExtensions.values()) {
            if(ext.equals(ext2.toString())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isImage(File f){
        String ext = getExtension(f);
        ext = ext.toLowerCase();
        for (ImageExtensions ext2 : ImageExtensions.values()) {
            if(ext.equals(ext2.toString())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isImage(String ext){
        for (ImageExtensions ext2 : ImageExtensions.values()) {
            if(ext.equals(ext2.toString())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isSound(File f){
        String ext = getExtension(f);
        ext = ext.toLowerCase();
        for (SoundExtensions ext2 : SoundExtensions.values()) {
            if(ext.equals(ext2.toString())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isSound(String ext){
        ext = ext.toLowerCase();
        for (SoundExtensions ext2 : SoundExtensions.values()) {
            if(ext.equals(ext2.toString())){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isMp3File(File f){
        String ext = getExtension(f);
        return ext.equals("mp3");
    }
    public static boolean isWavFile(File f){
        String ext = getExtension(f);
        return ext.equals("wav");
    }
    public static boolean isMidiFile(File f){
        String ext = getExtension(f);
        return ext.equals("midi");
    }
    public static boolean isJpgFile(File f){
        String ext = getExtension(f);
        return ext.equals("jpg");
    }
    public static boolean isJpegFile(File f){
        String ext = getExtension(f);
        return ext.equals("jpeg");
    }
    public static boolean isPngFile(File f){
        String ext = getExtension(f);
        return ext.equals("png");
    }
    public static boolean isGifFile(File f){
        String ext = getExtension(f);
        return ext.equals("gif");
    }
    public static boolean isAviFile(File f){
        String ext = getExtension(f);
        return ext.equals("avi");
    }
   
}
