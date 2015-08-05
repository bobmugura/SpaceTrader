/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

/**
 *
 * @author Jasper
 */
public class Banking {
    private int currentLoan;
    private double interest;
    private Player myPlayer;
    
    public Banking() {
        myPlayer = GameContext.instance().getPlayer();
        this.currentLoan = GameContext.instance().getPlayer().getCurrentLoan();
        interest = 0.01; //standard interest rate 1% before investor lv
        
    }
    public int getCurrentLoan() {
        return myPlayer.getCurrentLoan();
    }
    public double getInterestRate(Player p) {
       return(p.getInvestorLevel() * 0.001 + interest);
    }
    public int getInterest(Player p) {
        return(int)(currentLoan * getInterestRate(p));
    }
    public void getLoan(Player p, int loan) {
        p.setCredit(p.getCredit() + loan);
        myPlayer.setCurrentLoan(myPlayer.getCurrentLoan() + loan);
    }
    public void payLoan(Player p, int loan) {
        p.setCredit(p.getCredit() - loan);
        myPlayer.setCurrentLoan(myPlayer.getCurrentLoan() - loan);
    }
}
