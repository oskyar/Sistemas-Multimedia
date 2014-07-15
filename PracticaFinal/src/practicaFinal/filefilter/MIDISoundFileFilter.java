package practicaFinal.filefilter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Filtro para tener en cuento el formato MIDI de sonido.
 *
 * Ver {@link FileFilter}
 *
 * @author oskyar (Óscar Zafra)
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
