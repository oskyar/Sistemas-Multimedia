package practicaFinal.filefilter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author oskyar
 */
public class MIDISoundFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        return UtilFileFilter.isMidiFile(f);
    }

    @Override
    public String getDescription() {
        return "MIDI files (*.midi)";
    }
}
