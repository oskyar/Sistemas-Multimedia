/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.filefilter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Filtro para tener en cuento el formato GIF de imagen.
 *
 * Ver {@link FileFilter}
 *
 * @author oskyar (Óscar Zafra)
 */
public class GIFImageFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        return UtilFileFilter.isGifFile(f);
    }

    @Override
    public String getDescription() {
        return "GIF files (*.gif)";
    }

}
