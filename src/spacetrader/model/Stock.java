/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader.model;

import java.util.Random;

/**
 *
 * @author Kevin
 */
public class Stock {
    private Planet planet;
    private int price;
    private double interest;
    private final int MAX_TO_OWN = 5;
    private String name;
    
    public Stock(Planet planet) {
        this.planet = planet;
        setPriceAndInterest();
        name = planet.getName();
    }
    
    public void setPriceAndInterest() {
        double additionalInterest = GameContext.instance().getPlayer().getInvestorLevel() * .005;
        switch(planet.getEnviornment().getKey()) {
            case 0: //default environment
                price = 200;
                interest = .025 + additionalInterest;
                break;
            case 1://mineral rich
                price = 350;
                interest = .02 + additionalInterest;
                break;
            case 2: //mineral poor
                price = 100;
                interest = -0.01 + additionalInterest;
                break;
            case 3: //desert
                price = 160;
                interest = .008 + additionalInterest;
                break;
            case 4: //lots of water
                price = 225;
                interest = 0.0225 + additionalInterest;
                break;
            case 5: //rich soil
                price = 250;
                interest = .03 + additionalInterest;
                break;
            case 6: //poor soil
                price = 150;
                interest = .005 + additionalInterest;
                break;
            case 7://rich fauna
                price = 265;
                interest = .0275 + additionalInterest;
                break;
            case 8: //lifeless
                price = 125;
                interest = -.005 + additionalInterest;
                break;
            case 9: //weird mushrooms
                price = 180;
                interest = 0 + additionalInterest;
                break;
            case 10://lots of herb
                price = 230;
                interest = .019 + additionalInterest;
                break;
            case 11: //artistic
                price = 180;
                interest = 0.001 + additionalInterest;
                break;
            case 12: //warlike
                price = 190;
                interest = -.01 + additionalInterest;
                break;
        }
    }
    
    public int getPrice() {
        return price;
    }
    
    public double getInterest() {
        return interest;
    }
    
    public String getName() {
        return name;
    }
   
    public int getMaxToOwn() {
        return MAX_TO_OWN;
    }
    
}
