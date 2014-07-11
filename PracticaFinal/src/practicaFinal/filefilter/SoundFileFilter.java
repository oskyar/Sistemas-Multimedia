/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.filefilter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author oskyar
 */
public abstract class SoundFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        return UtilFileFilter.isSound(f);
    }

}
