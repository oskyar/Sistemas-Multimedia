/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;
import sm.image.KernelProducer;

/**
 *
 * @author oskyar
 */
public class SobelOp extends BufferedImageOpAdapter {

    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {

        if (src != null) {
            if (dest == null) {
                dest = createCompatibleDestImage(src, null);
            }

            Kernel kx = KernelProducer.createKernel(KernelProducer.TYPE_SOBELX_3x3);
            Kernel ky = KernelProducer.createKernel(KernelProducer.TYPE_SOBELY_3x3);
            ConvolveOp conX = new ConvolveOp(kx);
            ConvolveOp conY = new ConvolveOp(ky);
            //Gradientes
            BufferedImage gX = conX.filter(src, null);
            BufferedImage gY = conY.filter(src, null);

            BufferedImagePixelIterator itX = new BufferedImagePixelIterator(gX);
            BufferedImagePixelIterator itY = new BufferedImagePixelIterator(gY);

            int sumaX, sumaY, magnitud;
            int max = 0, min = Integer.MAX_VALUE;

            //Creamos matriz del mismo tamaño que la imagen
            int matrix[][] = new int[gX.getWidth()][gX.getHeight()];

            //Calculamos la magnitud y el máximo y mínimo de la imagen.
            for (; itX.hasNext();) {
                BufferedImagePixelIterator.PixelData pixelX = itX.next();
                BufferedImagePixelIterator.PixelData pixelY = itY.next();

                sumaX = pixelX.sample[0] + pixelX.sample[1] + pixelX.sample[2];
                sumaY = pixelY.sample[0] + pixelY.sample[1] + pixelY.sample[2];

                magnitud = (int) Math.hypot(sumaX, sumaY);
                //Busco el máximo
                if (magnitud > max) {
                    max = magnitud;
                }

                matrix[pixelX.col][pixelX.row] = magnitud;
            }
            //Reescalamos
            if (max != 0) {
                for (itX = new BufferedImagePixelIterator(gX); itX.hasNext();) {
                    BufferedImagePixelIterator.PixelData pixelX = itX.next();

                    float m = matrix[pixelX.col][pixelX.row];
                    magnitud = (int) ((m / max) * 255);

                    Color c = new Color(magnitud, magnitud, magnitud);
                    dest.setRGB(pixelX.col, pixelX.row, c.getRGB());
                }
            } else {
                System.err.println("Imagen en negro");
            }
            return dest;
        }
        return null;
    }
}
