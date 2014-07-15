/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.filtros;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 * Filtro de procesamiento en el que se utiliza con una imagen en Binario
 * (máscara con píxeles en blanco y negro).
 *
 * Los píxeles en blanco se mantienen y los negros se ocultan.
 *
 * Ver {@link BinaryOp}
 *
 * @author oskyar
 */
public class MultiplicacionOp extends BinaryOp {

    /**
     * Constructor al que se le pasa la imagen que se utiliza como máscara.
     *
     * @param img imagen que actúa como máscara.
     */
    public MultiplicacionOp(BufferedImage img) {
        super(img);
    }

    @Override
    public int binaryOp(int s1, int s2) {
        return s1 * s2;
    }

}
