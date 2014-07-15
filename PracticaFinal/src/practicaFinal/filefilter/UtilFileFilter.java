/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.filefilter;

import java.io.File;

/**
 * Clase de Utilidad para los formatos de sonido, de ayuda para reconocer si un
 * fichero es sonido, audio ó vídeo.
 *
 * @author oskyar
 */
public class UtilFileFilter {

    //Extensiones válidas
    public static enum Extensions {

        jpg, jpeg, gif, png, wav, midi, mp3, avi
    };

    public static enum SoundExtensions {

        wav, midi, mp3
    };

    public static enum ImageExtensions {

        jpg, jpeg, gif, png
    };

    public static enum VideoExtensions {

        avi
    };

    /**
     * Devuelve la extensión de un fichero
     *
     * @param f Fichero
     * @return Extensión del fichero.
     */
    public static String getExtension(File f) {
        String name = f.getName();
        //Guardo en la última posición que encuentra el punto (el punto inclusive)
        int lastPoint = name.lastIndexOf(".");
        //Si no encuentro extensión devuelvo null
        if (lastPoint == -1) {
            return null;
        }
        //Le sumo uno para que no tenga en cuenta el punto
        lastPoint++;
        //Extraigo la extensión
        String ext = name.substring(lastPoint);
        ext = ext.toLowerCase();
        return ext;
    }

    /**
     * Método que indica si una extensión es aceptada o no.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param ext String que contiene el formato del fichero.
     * @return Devuelve <strong>true</strong> si la extensión es aceptada,
     * <strong>false</strong> en caso contrario.
     */
    public static boolean isAccepted(String ext) {
        ext = ext.toLowerCase();
        for (Extensions ext2 : Extensions.values()) {
            if (ext.equals(ext2.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que indica si una extensión es aceptada o no.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es aceptado y falso si no lo es.
     */
    public static boolean isAccepted(File f) {
        String ext = getExtension(f);
        ext = ext.toLowerCase();
        for (Extensions ext2 : Extensions.values()) {
            if (ext.equals(ext2.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el archivo pasado es un formato de vídeo soportado.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es un formato de vídeo soportado y
     * falso si no lo es.
     */
    public static boolean isVideo(File f) {
        String ext = getExtension(f);
        ext = ext.toLowerCase();
        for (VideoExtensions ext2 : VideoExtensions.values()) {
            if (ext.equals(ext2.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el archivo pasado es un formato de vídeo soportado.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param ext extensión en formato string.
     * @return devueve true si el fichero es un formato de vídeo soportado y
     * falso si no lo es.
     */
    public static boolean isVideo(String ext) {
        ext = ext.toLowerCase();
        for (VideoExtensions ext2 : VideoExtensions.values()) {
            if (ext.equals(ext2.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el archivo pasado es formato de imagen soportado.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es un formato de imagen soportada y
     * falso si no lo es.
     */
    public static boolean isImage(File f) {
        String ext = getExtension(f);
        ext = ext.toLowerCase();
        for (ImageExtensions ext2 : ImageExtensions.values()) {
            if (ext.equals(ext2.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el archivo pasado es formato de imagen soportado.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param ext extensión en formato string.
     * @return devueve true si el fichero es un formato de imagen soportada y
     * falso si no lo es.
     */
    public static boolean isImage(String ext) {
        for (ImageExtensions ext2 : ImageExtensions.values()) {
            if (ext.equals(ext2.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el archivo pasado es un formato de sonido soportado.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es un formato de sonido soportado y
     * falso si no lo es.
     */
    public static boolean isSound(File f) {
        String ext = getExtension(f);
        ext = ext.toLowerCase();
        for (SoundExtensions ext2 : SoundExtensions.values()) {
            if (ext.equals(ext2.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si el archivo pasado es un formato de sonido soportado.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param ext extensión en formato string.
     * @return devueve true si el fichero es un formato de imagen soportada y
     * falso si no lo es.
     */
    public static boolean isSound(String ext) {
        ext = ext.toLowerCase();
        for (SoundExtensions ext2 : SoundExtensions.values()) {
            if (ext.equals(ext2.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Indica si el fichero pasado es un archivo de sonido con formato MP3.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es de tipo <strong>mp3</strong> y
     * falso en caso contrario.
     */
    public static boolean isMp3File(File f) {
        String ext = getExtension(f);
        return ext.equals("mp3");
    }

    /**
     * Indica si el fichero pasado es un archivo de sonido con formato WAV.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es de tipo <strong>wav</strong> y
     * falso en caso contrario.
     */
    public static boolean isWavFile(File f) {
        String ext = getExtension(f);
        return ext.equals("wav");
    }

    /**
     * Indica si el fichero pasado es un archivo de sonido con formato MIDI.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es de tipo <strong>midi</strong> y
     * falso en caso contrario.
     */
    public static boolean isMidiFile(File f) {
        String ext = getExtension(f);
        return ext.equals("midi");
    }

    /**
     * Indica si el fichero pasado es un archivo de imagen con formato JPG.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es de tipo <strong>jpg</strong> y
     * falso en caso contrario.
     */
    public static boolean isJpgFile(File f) {
        String ext = getExtension(f);
        return ext.equals("jpg");
    }

    /**
     * Indica si el fichero pasado es un archivo de imagen con formato JPEG.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es de tipo <strong>jpeg</strong> y
     * falso en caso contrario.
     */
    public static boolean isJpegFile(File f) {
        String ext = getExtension(f);
        return ext.equals("jpeg");
    }

    /**
     * Indica si el fichero pasado es un archivo de imagen con formato PNG.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es de tipo <strong>png</strong> y
     * falso en caso contrario.
     */
    public static boolean isPngFile(File f) {
        String ext = getExtension(f);
        return ext.equals("png");
    }

    /**
     * Indica si el fichero pasado es un archivo de imagen con formato GIF.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es de tipo <strong>gif</strong> y
     * falso en caso contrario.
     */
    public static boolean isGifFile(File f) {
        String ext = getExtension(f);
        return ext.equals("gif");
    }

    /**
     * Indica si el fichero pasado es un archivo de imagen con formato AVI.
     *
     * Es un método estático por lo que no es necesario crear una instancia
     *
     * @param f fichero de tipo <code>File</code>
     * @return devueve true si el fichero es de tipo <strong>avi</strong> y
     * falso en caso contrario.
     */
    public static boolean isAviFile(File f) {
        String ext = getExtension(f);
        return ext.equals("avi");
    }

}
