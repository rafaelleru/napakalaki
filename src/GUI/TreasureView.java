/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Color;
import napakalaki.*;

/**
 *
 * @author archdri
 */
public class TreasureView extends javax.swing.JPanel {

    private Treasure treasureModel;

    public Treasure getTreasure() {
        return treasureModel;
    }
    private boolean selected = false;

    public boolean isSelected() {
        return selected;
    }
    
    public void setTreasure(Treasure aTreasure){
        this.treasureModel = aTreasure;
        this.nameTreasure.setText(this.treasureModel.getName());
        this.bonus.setText(Integer.toString(this.treasureModel.getBonus()));
        this.kind.setText(this.treasureModel.getType().toString());
    }
    
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBonus = new javax.swing.JTextField();
        nameTreasure = new javax.swing.JLabel();
        bonus = new javax.swing.JLabel();
        kind = new javax.swing.JLabel();
        txtNameTreasure = new javax.swing.JPanel();
        txtBonuses = new javax.swing.JPanel();
        txtKind = new javax.swing.JPanel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        nameTreasure.setBackground(new java.awt.Color(255, 0, 51));
        nameTreasure.setText("Name");

        bonus.setText("Bonus");

        kind.setText("Kind");

        javax.swing.GroupLayout txtNameTreasureLayout = new javax.swing.GroupLayout(txtNameTreasure);
        txtNameTreasure.setLayout(txtNameTreasureLayout);
        txtNameTreasureLayout.setHorizontalGroup(
            txtNameTreasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        txtNameTreasureLayout.setVerticalGroup(
            txtNameTreasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout txtBonusesLayout = new javax.swing.GroupLayout(txtBonuses);
        txtBonuses.setLayout(txtBonusesLayout);
        txtBonusesLayout.setHorizontalGroup(
            txtBonusesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        txtBonusesLayout.setVerticalGroup(
            txtBonusesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout txtKindLayout = new javax.swing.GroupLayout(txtKind);
        txtKind.setLayout(txtKindLayout);
        txtKindLayout.setHorizontalGroup(
            txtKindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        txtKindLayout.setVerticalGroup(
            txtKindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameTreasure)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNameTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bonus)
                        .addGap(7, 7, 7)
                        .addComponent(txtBonuses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTreasure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNameTreasure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bonus)
                        .addComponent(kind))
                    .addComponent(txtBonuses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if(selected){
            selected = false;
            this.setOpaque(true);
            this.setBackground(Color.RED);
        }else{
            selected = true;
            this.setOpaque(false);
            this.setBackground(Color.GREEN);
        }
        
        repaint();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bonus;
    private javax.swing.JLabel kind;
    private javax.swing.JLabel nameTreasure;
    private javax.swing.JTextField txtBonus;
    private javax.swing.JPanel txtBonuses;
    private javax.swing.JPanel txtKind;
    private javax.swing.JPanel txtNameTreasure;
    // End of variables declaration//GEN-END:variables
}
