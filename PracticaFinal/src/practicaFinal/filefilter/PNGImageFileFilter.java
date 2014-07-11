/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaFinal.filefilter;

/**
 *
 * @author oskyar
 */
public class PNGImageFileFilter extends ImageFileFilter{

    @Override
    public String getDescription() {
        return "PNG files (*.png)"; 
    }
    
}
