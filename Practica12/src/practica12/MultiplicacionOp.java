/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 *
 * @author oskyar
 */
public class MultiplicacionOp extends BinaryOp {

    public MultiplicacionOp(BufferedImage img) {
        super(img);
    }

    @Override
    public int binaryOp(int s1, int s2) {
        return s1*s2;
    }

}
