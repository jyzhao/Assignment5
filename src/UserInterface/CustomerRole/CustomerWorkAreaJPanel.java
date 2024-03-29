/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import Business.MasterOrderCatalog;
import Business.SupplierDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author zhaojiyuan
 */
public class CustomerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private SupplierDirectory supplierDirectory;
    private MasterOrderCatalog masterOrderCatalog;
    
    public CustomerWorkAreaJPanel(JPanel userProcessContainer, SupplierDirectory supplierDirectory,MasterOrderCatalog masterOrderCatalog) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.supplierDirectory = supplierDirectory;
        this.masterOrderCatalog = masterOrderCatalog;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseProductCatalogJButton = new javax.swing.JButton();

        browseProductCatalogJButton.setText("Browse Product Catalog");
        browseProductCatalogJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseProductCatalogJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(browseProductCatalogJButton)
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(browseProductCatalogJButton)
                .addContainerGap(276, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseProductCatalogJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseProductCatalogJButtonActionPerformed
        // TODO add your handling code here:
        BrowseProductJPanel bpjp = new BrowseProductJPanel(userProcessContainer,supplierDirectory,masterOrderCatalog);
        userProcessContainer.add("BrowseProductJPanel",bpjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_browseProductCatalogJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseProductCatalogJButton;
    // End of variables declaration//GEN-END:variables
}
