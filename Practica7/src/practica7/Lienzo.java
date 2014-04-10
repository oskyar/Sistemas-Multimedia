/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Óscar
 */
public class Lienzo extends javax.swing.JPanel {
    private Color color;
    private int forma;
    final static int PUNTO=0;
    final static int LINEA=1;
    final static int RECTANGULO=2;
    final static int ELIPSE=3;
    final static int NUEVO=4;
    private Point pClic,pIni, pFin;
    boolean relleno;
    
    /**
     * Creates new form NewJPanel
     */
    public Lienzo() {
        initComponents();
        relleno=false;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(color);
        switch(forma){
            case PUNTO:
                if(pClic!=null) g.fillOval(pClic.x,pClic.y,10,10);
                break;
            case LINEA:
                if(pIni!=null && pFin!=null){
                    g.drawLine(pIni.x,pIni.y,pFin.x,pFin.y);
                }
                break;
            case RECTANGULO:
                if(pIni!=null && pFin!=null) {
                    int ancho= Math.abs(pIni.x - pFin.x);
                    int alto= Math.abs(pIni.y - pFin.y);
                    int minX = Math.min(pIni.x, pFin.x);
                    int minY = Math.min(pIni.y, pFin.y);
                    if(!isRelleno()){    
                        g.drawRect(minX,minY,ancho,alto);
                    }else{
                        g.fillRect(minX,minY,ancho,alto);
                    } 
                }
                break;
            case ELIPSE:
                if(pIni!=null && pFin!=null) {
                    int ancho= Math.abs(pIni.x - pFin.x);
                    int alto= Math.abs(pIni.y - pFin.y);
                    int minX = Math.min(pIni.x, pFin.x);
                    int minY = Math.min(pIni.y, pFin.y);
                    if(!isRelleno()){
                        g.drawOval(minX,minY,ancho,alto);
                    }else{
                        g.fillOval(minX,minY,ancho,alto);
                    } 
                }
                break;
            case NUEVO:
                break;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        pClic =evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        pIni =pFin= evt.getPoint();
        pClic = null;
        this.repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        //pFin = evt.getPoint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        pFin = evt.getPoint();
        pClic = null;
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    public void setColor(Color color){
        this.color = color;
    }
        
     public Color getColor(){
        return color;
    }
     
    public int getForma() {
        return forma;
    }

    public void setForma(int forma) {
        this.forma = forma;
    }

    public Point getpClic() {
        return pClic;
    }

    public void setpClic(Point pClic) {
        this.pClic = pClic;
    }

    public Point getpIni() {
        return pIni;
    }

    public void setpIni(Point pIni) {
        this.pIni = pIni;
    }

    public Point getpFin() {
        return pFin;
    }

    public void setpFin(Point pFin) {
        this.pFin = pFin;
    }

    public boolean isRelleno() {
        return relleno;
    }
    
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
