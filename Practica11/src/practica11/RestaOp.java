/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica11;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 *
 * @author oskyar
 */
public class RestaOp extends BinaryOp{

    public RestaOp(BufferedImage img) {
        super(img);
    }

    @Override
    public int binaryOp(int s1, int s2) {
        return Math.abs(s1-s2);
    }
    
}
