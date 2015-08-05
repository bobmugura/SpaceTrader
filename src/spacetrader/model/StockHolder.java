/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.model;

/**
 *
 * @author Kevin
 */
public class StockHolder {
    private int quantity;
    private Stock stock;
    
    public StockHolder(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void incrementQuantity(int toIncrement) {
        this.quantity += toIncrement;
    }
    
    public void decreaseQuantity(int quantityToDecrease) {
        this.quantity -= quantityToDecrease;
    }
    
    public Stock getStock() {
        return stock;
    }
    
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    public void addNewStock(Stock stockToAdd, int qtyToAdd) {
        
    }
}
