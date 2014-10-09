/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author zhaojiyuan
 */
public class Order {
    private ArrayList<OrderItem> orderItemList;
    private static int count = 0;
    private int orderNumber;

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }    
    
    
    public OrderItem addOrderItem(Product p, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(p);
        orderItem.setQuantity(quantity);
        orderItemList.add(orderItem);
        
        return orderItem;
    }
    
    public void deleteOrderItem (OrderItem oi) {
        orderItemList.remove(oi);
    }
    
    public Order() {
        count++;
        orderNumber = count;
        orderItemList = new ArrayList<OrderItem>();
    }
}
