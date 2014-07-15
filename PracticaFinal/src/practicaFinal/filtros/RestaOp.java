/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.filtros;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 * Esta operación de procesamiento es útil para visualizar diferencias entre
 * imágenes, es obligatorio que las dos imágenes tengan el mismo tamaño, tanto
 * de ancho como de alto.
 *
 * Ver {@link BinaryOp}
 *
 * @author oskyar (Óscar Zafra)
 */
public class RestaOp extends BinaryOp {

    /**
     * Constructor al que se le pasa una imagen para comparar.
     *
     * @param img Imagen con la que comparar
     */
    public RestaOp(BufferedImage img) {
        super(img);
    }

    @Override
    public int binaryOp(int s1, int s2) {
        return Math.abs(s1 - s2);
    }

}
