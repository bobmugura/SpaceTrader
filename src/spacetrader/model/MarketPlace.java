/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import spacetrader.enums.Merchandise;

/**
 * Market place class
 * @author naveen
 */
public class MarketPlace implements Serializable{
    private int techNum;
    private ArrayList buyPrices;
    private ArrayList sellPrices;
    
    public MarketPlace(int techNum, double[] priceMultiplier) {
        this.techNum = techNum;
        fillMarket(priceMultiplier);
    }
    /**
     * Gets list of item's buying and selling prices
     * @return item's list
     */
    
    /**
     * Determines Item's buying and selling prices for the market place
     */
    public void fillMarket(double[] priceMultiplier) {
        buyPrices = new ArrayList<>();
        sellPrices = new ArrayList<>();
        int index = 0;
       for(Merchandise item: Merchandise.values())
       {
           if(item.getMtlp() <= techNum)
           {
               buyPrices.add(getBuyPrice(item, priceMultiplier[index]));
               sellPrices.add(getSellPrice(item, priceMultiplier[index]));
           }
           else
           {
               buyPrices.add(0);
               sellPrices.add(0);
           }
           index++;
       }
    }
    /**
     * Gets a list of buying prices for items
     * @return list of item's buying prices
     */
    public ArrayList getBuyPrices() {
        return buyPrices;
    }
    /**
     * Gets a list of selling prices for items
     * @return list of item's selling prices
     */
    public ArrayList getSellPrices() {
        return sellPrices;
    }
    /**
     * Calculates buying price for the item
     * @param item to be bought
     * @return item's buying price
     */
    private int getBuyPrice(Merchandise item, double multiplier)
    {
        return (int)((item.getBasePrice() + (item.getIpl() * (techNum - item.getMtlp())) + new Random().nextInt(item.getVar())) * multiplier);
    }
    /**
     * Calculates selling price for the item
     * @param item to be sold
     * @return item's buying price
     */
    private int getSellPrice(Merchandise item, double multiplier) {
        return (int)((item.getBasePrice() + (item.getIpl() * (techNum - item.getMtlp())) - new Random().nextInt(item.getVar())) * multiplier);
    }
    
    /**
     * To be implemented further
     * @param item
     * @return 
     */
    
//    
//    public void buy(Item i,int qty) {
//        
//    }
//    
//    public void sell(Item i,int qty) {
//        
//        
//    }
//    
//    public void reStock() {
//        
//    }
}
