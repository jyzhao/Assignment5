/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import Business.MasterOrderCatalog;
import Business.Order;
import Business.OrderItem;
import Business.Product;
import Business.Supplier;
import Business.SupplierDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaojiyuan
 */
public class BrowseProductJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BrowseProductJPanel
     */
    private JPanel userProcessContainer;
    private SupplierDirectory supplierDirectory;
    private MasterOrderCatalog masterOrderCatalog;
    private Order order;

    public BrowseProductJPanel(JPanel userProcessContainer, SupplierDirectory supplierDirectory, MasterOrderCatalog masterOrderCatalog) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.supplierDirectory = supplierDirectory;
        this.masterOrderCatalog = masterOrderCatalog;

        populateSupplierComboBox();
        populateProductDetailTable();
    }

    public void populateSupplierComboBox() {
        supplierJComboBox.removeAllItems();
        for (Supplier supplier : supplierDirectory.getSupplierDict()) {
            supplierJComboBox.addItem(supplier);
        }
    }

    public void populateProductDetailTable() {
        DefaultTableModel model = (DefaultTableModel) productDetailJTable.getModel();
        model.setRowCount(0);

        Supplier supplier = (Supplier) supplierJComboBox.getSelectedItem();

        if (supplier == null) {
            //JOptionPane.showMessageDialog(null, "Supplier == null !!!");
            return;
        }

        for (Product product : supplier.getProductCatalog().getProductCatalog()) {
            Object[] row = new Object[4];
            row[0] = product;
            row[1] = product.getModelNumber();
            row[2] = product.getPrice();
            row[3] = product.getAvailability();

            model.addRow(row);
        }
    }

    public void populateSearchedProduct(String keyword) {

        if (keyword == null || keyword.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid keyword !!!");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) productDetailJTable.getModel();
        model.setRowCount(0);

        for (Supplier supplier : supplierDirectory.getSupplierDict()) {
            for (Product product : supplier.getProductCatalog().getProductCatalog()) {

                if (product.getProdName().equals(keyword)) {
                    Object[] row = new Object[4];
                    row[0] = product;
                    row[1] = product.getModelNumber();
                    row[2] = product.getPrice();
                    row[3] = product.getAvailability();

                    model.addRow(row);
                }

            }
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

        jLabel1 = new javax.swing.JLabel();
        supplierJComboBox = new javax.swing.JComboBox();
        searchByProductNameJTextField = new javax.swing.JTextField();
        searchByProductNameJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productDetailJTable = new javax.swing.JTable();
        viewProductDetailJButton = new javax.swing.JButton();
        addToCartJButton = new javax.swing.JButton();
        quantityJSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        viewOrderItemDetailJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        modifyQuantityJTextField = new javax.swing.JTextField();
        removeItemJButton = new javax.swing.JButton();
        checkoutJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Supplier");

        supplierJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplierJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierJComboBoxActionPerformed(evt);
            }
        });

        searchByProductNameJButton.setText("Search By Product Name");
        searchByProductNameJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByProductNameJButtonActionPerformed(evt);
            }
        });

        productDetailJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Product ID", "Product Price", "Product Availability"
            }
        ));
        jScrollPane1.setViewportView(productDetailJTable);

        viewProductDetailJButton.setText("View Product Detail");
        viewProductDetailJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductDetailJButtonActionPerformed(evt);
            }
        });

        addToCartJButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        addToCartJButton.setText("Add to cart");
        addToCartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartJButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantity");

        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Price", "Quantity", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderJTable);

        viewOrderItemDetailJButton.setText("View Order Item Detail");
        viewOrderItemDetailJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderItemDetailJButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Modify Quantity");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        removeItemJButton.setText("Remove Item");
        removeItemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemJButtonActionPerformed(evt);
            }
        });

        checkoutJButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        checkoutJButton.setText("Checkout");
        checkoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(supplierJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(208, 208, 208)
                                .addComponent(searchByProductNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchByProductNameJButton)))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(backJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkoutJButton)
                .addGap(325, 325, 325))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(viewProductDetailJButton)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(addToCartJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(viewOrderItemDetailJButton)
                        .addGap(18, 18, 18)
                        .addComponent(modifyQuantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(removeItemJButton)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchByProductNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchByProductNameJButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewProductDetailJButton)
                    .addComponent(addToCartJButton)
                    .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrderItemDetailJButton)
                    .addComponent(jButton1)
                    .addComponent(modifyQuantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeItemJButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutJButton)
                    .addComponent(backJButton))
                .addGap(0, 40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewProductDetailJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductDetailJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = productDetailJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row !!!");
            return;
        }

        Product product = (Product) productDetailJTable.getValueAt(selectedRow, 0);

        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(userProcessContainer, product);
        userProcessContainer.add("ViewProductDetailJPanel", vpdjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewProductDetailJButtonActionPerformed

    private void viewOrderItemDetailJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderItemDetailJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        
        OrderItem oi = (OrderItem) orderJTable.getValueAt(selectedRow, 0);
        
        ViewOrderItemDetailJPanel voidjp = new ViewOrderItemDetailJPanel(userProcessContainer,oi);
        userProcessContainer.add("ViewProductDetailJPanel", voidjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewOrderItemDetailJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        
        for (OrderItem oi : order.getOrderItemList()) {
            oi.getProduct().setAvailability(oi.getQuantity() + oi.getProduct().getAvailability());
        }
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void supplierJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierJComboBoxActionPerformed
        // TODO add your handling code here:
        populateProductDetailTable();
    }//GEN-LAST:event_supplierJComboBoxActionPerformed

    private void searchByProductNameJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByProductNameJButtonActionPerformed
        // TODO add your handling code here:
        String keyword = searchByProductNameJTextField.getText();
        populateSearchedProduct(keyword);
    }//GEN-LAST:event_searchByProductNameJButtonActionPerformed

    private void addToCartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = productDetailJTable.getSelectedRow();
        boolean flag = true;

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row !!!");
            return;
        }
        Product product = (Product) productDetailJTable.getValueAt(selectedRow, 0);
        int quantity = (Integer) (quantityJSpinner.getValue());

        if (order == null) {
            order = new Order();

        } else {
            ArrayList<OrderItem> oi = order.getOrderItemList();
            for (OrderItem orderItem : oi) {
                if (orderItem.getProduct().equals(product)) {
                    int oldQuantity = orderItem.getQuantity();
                    int newQuantity = oldQuantity + quantity;
                    orderItem.setQuantity(newQuantity);
                    flag = false;
                }

            }
        }
        
        if (flag) {
            OrderItem oi = order.addOrderItem(product, quantity);
            
        }

        if (quantity == 0 || quantity > product.getAvailability()) {
            JOptionPane.showMessageDialog(null, "Somthing wrong with quantity !!!");
            return;
        }
        
        product.setAvailability(product.getAvailability() - quantity);
        
        
        JOptionPane.showMessageDialog(null,product.getProdName() + " " + "Quantity " + quantity + " is added to cart !!!");
        populateProductDetailTable();
        populateOrderTable(order);
    }//GEN-LAST:event_addToCartJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row !!!");
            return;
        }
        
        OrderItem oi = (OrderItem)orderJTable.getValueAt(selectedRow, 0);
        
        int modifyQuantity = Integer.parseInt(modifyQuantityJTextField.getText());
        
        if (modifyQuantity > (oi.getQuantity() + oi.getProduct().getAvailability())) {
            JOptionPane.showMessageDialog(null, "Wrong quantity !!!");
            return;
        }
        
        if (modifyQuantity <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid quantity !!!");
            return;
        }
        
        int oldQuantity = oi.getQuantity();
        int oldAvailability = oi.getProduct().getAvailability();
        oi.getProduct().setAvailability(oldQuantity + oldAvailability - modifyQuantity);
        oi.setQuantity(modifyQuantity);
        
        
        populateProductDetailTable();
        populateOrderTable(order);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void removeItemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderJTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        
        OrderItem oi = (OrderItem) orderJTable.getValueAt(selectedRow, 0);
        
        order.deleteOrderItem(oi);
        
        int newAvailability = oi.getQuantity() + oi.getProduct().getAvailability();
        
        oi.getProduct().setAvailability(newAvailability);
        
        populateProductDetailTable();
        populateOrderTable(order);
    }//GEN-LAST:event_removeItemJButtonActionPerformed

    private void checkoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutJButtonActionPerformed
        // TODO add your handling code here:
        Order addedOrder = masterOrderCatalog.addOrder(order);
        if (addedOrder != null) {
            order = new Order();
            JOptionPane.showMessageDialog(null, "Your order has been checked out !!!");
        }
        else {
            return;
        }
        
        populateOrderTable(order);
        populateProductDetailTable();
    }//GEN-LAST:event_checkoutJButtonActionPerformed

    private void populateOrderTable(Order order){
        DefaultTableModel model = (DefaultTableModel) orderJTable.getModel();
        model.setRowCount(0);
        for (OrderItem oi : order.getOrderItemList()) {
            Object[] obj = new Object[4];
            obj[0] = oi;
            obj[1] = oi.getProduct().getPrice();
            obj[2] = oi.getQuantity();
            obj[3] = oi.getQuantity() * oi.getProduct().getPrice();
            
            model.addRow(obj);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton checkoutJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField modifyQuantityJTextField;
    private javax.swing.JTable orderJTable;
    private javax.swing.JTable productDetailJTable;
    private javax.swing.JSpinner quantityJSpinner;
    private javax.swing.JButton removeItemJButton;
    private javax.swing.JButton searchByProductNameJButton;
    private javax.swing.JTextField searchByProductNameJTextField;
    private javax.swing.JComboBox supplierJComboBox;
    private javax.swing.JButton viewOrderItemDetailJButton;
    private javax.swing.JButton viewProductDetailJButton;
    // End of variables declaration//GEN-END:variables
}
