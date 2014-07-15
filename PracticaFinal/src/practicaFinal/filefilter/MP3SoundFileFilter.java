/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.filefilter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Filtro para tener en cuento el formato MP3 de sonido.
 *
 * Ver {@link FileFilter}
 *
 * @author oskyar (Óscar Zafra)
 */
public class MP3SoundFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        return UtilFileFilter.isMp3File(f);
    }

    @Override
    public String getDescription() {
        return "MP3 files (*.mp3)";
    }

}
