/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author oskyar
 */
public class JOptionPaneMultiInput {

    public JOptionPaneMultiInput() {

    }

    public static ArrayList<Integer> showJOptionPaneMultiIpunt() {
        JTextField width = new JTextField(5);
        JTextField height = new JTextField(5);

        JPanel myPanel = new JPanel();
        width.setText("640");
        myPanel.add(new JLabel("Ancho:"));
        myPanel.add(width);
        height.setText("480");
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Alto:"));
        myPanel.add(height);
        boolean ok = false;
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Introduzca el ancho y el alto del lienzo", JOptionPane.OK_CANCEL_OPTION);
        while (result == JOptionPane.OK_OPTION && !ok) {
            try {
                //while (width.getText().equals("") || height.getText().equals("") || Integer.parseInt(width.getText()) == 0 || Integer.parseInt(height.getText()) == 0) {
                double w = Double.parseDouble(width.getText());
                double h = Double.parseDouble(height.getText());
                if (width.getText().equals("") || height.getText().equals("") || Integer.parseInt(width.getText()) == 0 || Integer.parseInt(height.getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Por favor introduzca algún número y que sea mayor que 0");
                    result = JOptionPane.showConfirmDialog(null, myPanel,
                            "Introduzca el ancho y el alto del lienzo", JOptionPane.OK_CANCEL_OPTION);
                } else {
                    ok = true;

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: Introduzca un número");
                result = JOptionPane.showConfirmDialog(null, myPanel,
                "Introduzca el ancho y el alto del lienzo", JOptionPane.OK_CANCEL_OPTION);
            }
        }
        if (result == JOptionPane.OK_OPTION) {
            ArrayList<Integer> al = new ArrayList();
            al.add(Integer.parseInt(width.getText()));
            al.add(Integer.parseInt(height.getText()));
            return al;
        }
        return null;
    }
}
