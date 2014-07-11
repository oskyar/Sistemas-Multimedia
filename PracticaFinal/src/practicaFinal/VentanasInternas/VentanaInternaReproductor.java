/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.VentanasInternas;

import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import practicaFinal.VentanaPrincipal;
import practicaFinal.sound.SMClipPlayer;
import practicaFinal.sound.SMPlayer;

/**
 *
 * @author oskyar
 */
public class VentanaInternaReproductor extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInterna
     */
    SMClipPlayer player;

    public VentanaInternaReproductor(File f) {
        initComponents();
        if (f != null) {
            player = new SMClipPlayer(f);
            this.setTitle(f.getName());
            LineListener lineListener = new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == Type.START) {
                        play.setEnabled(false);
                        stop.setEnabled(true);
                    }
                    if (event.getType() == Type.STOP) {
                        play.setEnabled(true);
                        play.setSelected(false);
                        stop.setEnabled(false);
                    }
                }
            };
            ((SMClipPlayer) player).setLineListener(lineListener);
            this.pack();
        }
    }

    public static void showJMFPlayer(File f, String name) {
        VentanaInternaReproductor vi = new VentanaInternaReproductor(f);
        VentanaPrincipal.getEscritorio().add(vi);
        vi.setVisible(true);
        vi.setTitle(f.getName());
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reproductor = new javax.swing.ButtonGroup();
        play = new javax.swing.JToggleButton();
        stop = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(250, 120));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        reproductor.add(play);
        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/PlayPressed_48x48.png"))); // NOI18N
        play.setMaximumSize(new java.awt.Dimension(100, 100));
        play.setOpaque(true);
        play.setPreferredSize(new java.awt.Dimension(100, 60));
        play.setRequestFocusEnabled(false);
        play.setRolloverEnabled(false);
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play);

        reproductor.add(stop);
        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopNormalRed_48x48.png"))); // NOI18N
        stop.setEnabled(false);
        stop.setPreferredSize(new java.awt.Dimension(100, 60));
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        getContentPane().add(stop);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        if (player != null) {
            player.play();
        }
    }//GEN-LAST:event_playActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        if (player != null) {
            player.stop();
        }
    }//GEN-LAST:event_stopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton play;
    private javax.swing.ButtonGroup reproductor;
    private javax.swing.JToggleButton stop;
    // End of variables declaration//GEN-END:variables

}
