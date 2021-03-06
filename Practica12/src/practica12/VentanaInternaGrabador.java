/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.swing.JFileChooser;
import sm.sound.SMSoundPlayerRecorder;

/**
 *
 * @author oskyar
 */
public class VentanaInternaGrabador extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInterna
     */
    SMSoundPlayerRecorder recorder;

    public VentanaInternaGrabador(final File f) {
        initComponents();

        recorder = new SMSoundPlayerRecorder(f);
        this.setTitle(f.getName());
        LineListener lineListener = new LineListener() {
            @Override
            public void update(LineEvent event) {
                if (event.getType() == Type.START) {
                    recorderButton.setEnabled(false);
                    stopButton.setEnabled(true);
                }
                if (event.getType() == Type.STOP) {
                    recorderButton.setEnabled(true);
                    stopButton.setEnabled(false);
                    VentanaInternaReproductor vir = new VentanaInternaReproductor(f);
                    VentanaPrincipal.getEscritorio().add(vir);
                    vir.setVisible(true);
                }

            }
        };
        ((SMSoundPlayerRecorder) recorder).setLineListener(lineListener);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recorderGroup = new javax.swing.ButtonGroup();
        recorderButton = new javax.swing.JToggleButton();
        stopButton = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(250, 120));
        getContentPane().setLayout(new java.awt.GridLayout());

        recorderGroup.add(recorderButton);
        recorderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RecordPressed_48x48.png"))); // NOI18N
        recorderButton.setMaximumSize(new java.awt.Dimension(100, 100));
        recorderButton.setPreferredSize(new java.awt.Dimension(100, 60));
        recorderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recorderButtonActionPerformed(evt);
            }
        });
        getContentPane().add(recorderButton);

        recorderGroup.add(stopButton);
        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopNormalRed_48x48.png"))); // NOI18N
        stopButton.setEnabled(false);
        stopButton.setPreferredSize(new java.awt.Dimension(100, 60));
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recorderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recorderButtonActionPerformed
        if (recorder != null) {
            recorder.record();
        }
    }//GEN-LAST:event_recorderButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        if (recorder != null) {
            recorder.stop();
        }
    }//GEN-LAST:event_stopButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton recorderButton;
    private javax.swing.ButtonGroup recorderGroup;
    private javax.swing.JToggleButton stopButton;
    // End of variables declaration//GEN-END:variables

}
