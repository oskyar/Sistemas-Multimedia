/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.filtros;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImageSampleIterator;

/**
 * Técnica de Segmentación basada en pixel.
 *
 * Usa las propiedades del pixel para agruparlos sin considerar una conectividad
 * especial
 *
 * ver {@link BufferedImageOpAdapter}
 *
 * @author oskyar
 */
public class UmbralizacionOp extends BufferedImageOpAdapter {

    private int umbral;

    /**
     * Crea e inicializa el objeto con un umbral, que será el tenido en cuenta
     * para la conectividad entre píxeles.
     *
     * @param umbral Umbral de tipo entero 
     */
    public UmbralizacionOp(int umbral) {
        this.umbral = umbral;
    }

    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();

        for (BufferedImageSampleIterator it = new BufferedImageSampleIterator(src); it.hasNext();) {
            BufferedImageSampleIterator.SampleData sample = it.next();
            if (sample.value > this.umbral) {
                sample.value = 255;
            } else {
                sample.value = 0;
            }
            destRaster.setSample(sample.col, sample.row, sample.band, sample.value);
        }
        return dest;
    }

}
