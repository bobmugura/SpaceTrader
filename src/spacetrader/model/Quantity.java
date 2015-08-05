/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader.model;

import java.io.Serializable;

/**
 *
 * @author Keun Lee
 */
public class Quantity implements Serializable
{
    private static final int MAX_RESOURCE = 50;
    private int maxCargo; //when maxCargo is zero, that means this class instance is being used in Planet, instead of Ship.
    private int water, fur, food, ore, game, firearm, medicine, machine, narcotic, robot;    
    
    /**
     * Quantity constructor
     * @param shipMaxCargo the maximum cargo space of the ship
     * @param array an array for resources
     */
    public Quantity(int shipMaxCargo, int[] array)
    {
        this(array);
        maxCargo = shipMaxCargo;
    }
    
    /**
     * Quantity constructor for planets
     * @param array an array for resources
     */
    public Quantity(int[] array)
    {
        setAll(array);
        maxCargo = 0;
    }
    
    /**
     * Quantity constructor for planets using set resource values
     * @param water the initial amount of water
     * @param fur the initial number of furs
     * @param food the initial amount of food
     * @param ore the initial amount of ore
     * @param game the initial amount of game
     * @param firearm the initial number of firearms
     * @param medicine the initial number of medicines
     * @param machine the initial number of machines
     * @param narcotic the initial number of narcotics
     * @param robot the initial number of robots
     */
    public Quantity(int water, int fur, int food, int ore, int game, int firearm, int medicine, int machine, int narcotic, int robot)
    {
        int[] array = {water, fur, food, ore, game, firearm, medicine, machine, narcotic, robot};
        setAll(array);
        maxCargo = 0;
    }
    
    /**
     * Quantity constructor for ships using set resource values
     * @param shipMaxCargo the maximum cargo space
     * @param water the initial amount of water
     * @param fur the initial number of furs
     * @param food the initial amount of food
     * @param ore the initial amount of ore
     * @param game the initial amount of game
     * @param firearm the initial number of firearms
     * @param medicine the initial number of medicines
     * @param machine the initial number of machines
     * @param narcotic the initial number of narcotics
     * @param robot the initial number of robots
     */
    public Quantity(int shipMaxCargo, int water, int fur, int food, int ore, int game, int firearm, int medicine, int machine, int narcotic, int robot)
    {
        this(water, fur, food, ore, game, firearm, medicine, machine, narcotic, robot);
        maxCargo = shipMaxCargo;        
    }
    
    public boolean possessIllegal() {
        boolean result;
        if (firearm > 0 || narcotic > 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    public final void loseAllCargo() {
        water = 0;
        fur = 0;
        food = 0;
        ore = 0;
        game = 0;
        firearm = 0;
        medicine = 0;
        machine = 0;
        narcotic = 0;
        robot = 0;
    }
    /**
     * Getter for the max cargo
     * @return the max cargo
     */
    public int getMaxCargo()
    {
        return maxCargo;
    }
    
    /**
     * Setter for the max cargo
     * @param size the new amount of cargo space
     */
    public void setMaxCargo(int size)
    {
        maxCargo = size;
    }
    
    /**
     * Getter for all resources
     * @return an array of resources
     */
    public int[] getAll()
    {
        int[] array = {water, fur, food, ore, game, firearm, medicine, machine, narcotic, robot};
        return array;
    }
    
    /**
     * Getter for water
     * @return the amount of water
     */
    public int getWater()
    {return water;}
    
    /**
     * Getter for fur
     * @return the number of furs
     */
    public int getFur()
    {return fur;}
    
    /**
     * Getter for food
     * @return the amount of food
     */
    public int getFood()
    {return food;}
    
    /**
     * Getter for ore
     * @return the amount of ore
     */
    public int getOre()
    {return ore;}
    
    /**
     * Getter for game
     * @return the amount of game
     */
    public int getGame()
    {return game;}
    
    /**
     * Getter for firearms
     * @return the number of firearms
     */
    public int getFirearm()
    {return firearm;}
    
    /**
     * Getter for medicine
     * @return the number of medicines
     */
    public int getMedicine()
    {return medicine;}
    
    /**
     * Getter for machines
     * @return the number of machines
     */
    public int getMachine()
    {return machine;}
    
    /**
     * Getter for narcotics
     * @return the number of narcotics
     */
    public int getNarcotic()
    {return narcotic;}
    
    /**
     * Getter for robots
     * @return the number of robots
     */
    public int getRobot()
    {return robot;}
    
    /**
     * Getter for resources using a key
     * @param key a marker to determine which resource to get
     * @return the amount of the chosen resource
     */
    public int getWithKey(int key)
    {
        switch(key)
        {
            case 0:
                return water;
            case 1:
                return fur;
            case 2:
                return food;
            case 3:
                return ore;
            case 4:
                return game;
            case 5:
                return firearm;
            case 6:
                return medicine;
            case 7:
                return machine;
            case 8:
                return narcotic;
            case 9:
                return robot;
            default:
                return -1;                
        }
    }
  
    /**
     * Determine if an array can be used as an array of resources
     * @param array the inputted array
     * @return true if the array can (and is) used, false otherwise
     */
    public boolean setAll(int[] array)
    {
        if(array.length == 10)
        {
            water = array[0];
            fur = array[1];
            food = array[2];
            ore = array[3];
            game = array[4];
            firearm = array[5];
            medicine = array[6];
            machine = array[7];
            narcotic = array[8];
            robot = array[9];
            return true;
        }
        else
            return false;
    }
    
    /**
     * Get the remaining cargo space
     * @return the cargo space left
     */
    public int getCargoLeft()
    {
        if(maxCargo == 0)
            return -1;
        else
            return maxCargo - countAll();
    }
    
    /**
     * Calculate the sum of all resource amounts
     * @return the total amount of resources
     */
    public int countAll()
    {
        return water + fur + food + ore + game + firearm + medicine + machine + narcotic + robot;
    }
    
    /**
     * Determine if there is space to add a resource
     * @param resource the resource
     * @param num the amount of the resource
     * @return true if there is space available, false otherwise
     */
    private boolean spaceAvailable(int resource, int num)
    {
        if(maxCargo == 0)
            return resource + num <= MAX_RESOURCE;
        else
            return countAll() + num <= maxCargo;
    }
    
    /**
     * Setter for resources based on a key
     * @param key a marker to determine the resource to choose
     * @param value the value to set the chosen resource
     * @return true if the value has been set to a resource, false otherwise
     */
    public boolean setWithKey(int key, int value)
    {
        switch(key)
        {
            case 0:
                return setWater(value);
            case 1:
                return setFur(value);
            case 2:
                return setFood(value);
            case 3:
                return setOre(value);
            case 4:
                return setGame(value);
            case 5:
                return setFirearm(value);
            case 6:
                return setMedicine(value);
            case 7:
                return setMachine(value);
            case 8:
                return setNarcotic(value);
            case 9:
                return setRobot(value);
            default:
                System.out.println("Wrong key number detected in Quantity.setWithKey");   
                return false;
        }
    }
    
    /**
     * Setter for water
     * @param num the amount to set
     * @return true if the amount has been set, false otherwise
     */
    public boolean setWater(int num)
    {
        if(spaceAvailable(water, num))
        {
            water = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for fur
     * @param num the number to set
     * @return true if the number has been set, false otherwise
     */
    public boolean setFur(int num)
    {
        if(spaceAvailable(fur, num))
        {
            fur = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for food
     * @param num the amount to set
     * @return true if the amount has been set, false otherwise
     */
    public boolean setFood(int num)
    {
        if(spaceAvailable(food, num))
        {
            food = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for ore
     * @param num the amount to set
     * @return true if the amount has been set, false otherwise
     */
    public boolean setOre(int num)
    {
        if(spaceAvailable(ore, num))
        {
            ore = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for game
     * @param num the amount to set
     * @return true if the amount has been set, false otherwise 
     */
    public boolean setGame(int num)
    {
        if(spaceAvailable(game, num))
        {
            game = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for firearms
     * @param num the number to set
     * @return true if the number has been set, false otherwise 
     */
    public boolean setFirearm(int num)
    {
        if(spaceAvailable(firearm, num))
        {
            firearm = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for medicine
     * @param num the number to set
     * @return true if the number has been set, false otherwise 
     */
    public boolean setMedicine(int num)
    {
        if(spaceAvailable(medicine, num))
        {
            medicine = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for machines
     * @param num the number to set
     * @return true if the number has been set, false otherwise
     */
    public boolean setMachine(int num)
    {
        if(spaceAvailable(machine, num))
        {
            machine = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for narcotics
     * @param num the number to set
     * @return true if the number has been set, false otherwise
     */
    public boolean setNarcotic(int num)
    {
        if(spaceAvailable(narcotic, num))
        {
            narcotic = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Setter for robots
     * @param num the number to set
     * @return true if the number has been set, false otherwise 
     */
    public boolean setRobot(int num)
    {
        if(spaceAvailable(robot, num))
        {
            robot = num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add an amount of a resource selected by a key
     * @param key a marker to determine a resource
     * @param value an amount to add
     * @return true if the value has been added to a chosen resource,
     * false otherwise
     */
    public boolean addWithKey(int key, int value)
    {
        switch(key)
        {
            case 0:
                return addWater(value);
            case 1:
                return addFur(value);
            case 2:
                return addFood(value);
            case 3:
                return addOre(value);
            case 4:
                return addGame(value);
            case 5:
                return addFirearm(value);
            case 6:
                return addMedicine(value);
            case 7:
                return addMachine(value);
            case 8:
                return addNarcotic(value);
            case 9:
                return addRobot(value);
            default:
                System.out.println("Wrong key number detected in Quantity.addWithKey");
                return false;
        }
    }
    
    /**
     * Add 1 water
     * @return true if added, false otherwise
     */
    public boolean addWater()
    {
        return addWater(1);
    }
    
    /**
     * Add an amount of water
     * @param num the amount to add
     * @return true if added, false otherwise
     */
    public boolean addWater(int num)
    {
        if(spaceAvailable(water, num))
        {
            water += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 fur
     * @return true if added, false otherwise
     */
    public boolean addFur()
    {
        return addFur(1);
    }
    
    /**
     * Add a number of furs
     * @param num the number to add
     * @return true if added, false otherwise
     */
    public boolean addFur(int num)
    {
        if(spaceAvailable(fur, num))
        {
            fur += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 food
     * @return true if added, false otherwise
     */
    public boolean addFood()
    {
        return addFood(1);
    }
    
    /**
     * Add an amount of food
     * @param num the amount to add
     * @return true if added, false otherwise
     */
    public boolean addFood(int num)
    {
        if(spaceAvailable(food, num))
        {
            food += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 ore
     * @return true if added, false otherwise
     */
    public boolean addOre()
    {
        return addOre(1);
    }
    
    /**
     * Add an amount of ore
     * @param num the amount to add
     * @return true if added, false otherwise
     */
    public boolean addOre(int num)
    {
        if(spaceAvailable(ore, num))
        {
            ore += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 game
     * @return true if added, false otherwise
     */
    public boolean addGame()
    {
        return addGame(1);
    }
    
    /**
     * Add an amount of game
     * @param num the amount to add
     * @return true if added, false otherwise
     */
    public boolean addGame(int num)
    {
        if(spaceAvailable(game, num))
        {
            game += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 firearm
     * @return true if added, false otherwise
     */
    public boolean addFirearm()
    {
        return addFirearm(1);
    }
    
    /**
     * Add a number of firearms
     * @param num the number to add
     * @return true if added, false otherwise
     */
    public boolean addFirearm(int num)
    {
        if(spaceAvailable(firearm, num))
        {
            firearm += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 medicine
     * @return true if added, false otherwise
     */
    public boolean addMedicine()
    {
        return addMedicine(1);
    }
    
    /**
     * Add a number of medicines
     * @param num the number to add
     * @return true if added, false otherwise
     */
    public boolean addMedicine(int num)
    {
        if(spaceAvailable(medicine, num))
        {
            medicine += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 machine
     * @return true if added, false otherwise
     */
    public boolean addMachine()
    {
        return addMachine(1);
    }
    
    /**
     * Add a number of machines
     * @param num the number to add
     * @return true if added, false otherwise
     */
    public boolean addMachine(int num)
    {
        if(spaceAvailable(machine, num))
        {
            machine += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 narcotic
     * @return true if added, false otherwise
     */
    public boolean addNarcotic()
    {
        return addNarcotic(1);
    }
    
    /**
     * Add a number of narcotics
     * @param num the number to add
     * @return true if added, false otherwise
     */
    public boolean addNarcotic(int num)
    {
        if(spaceAvailable(narcotic, num))
        {
            narcotic += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Add 1 robot
     * @return true if added, false otherwise
     */
    public boolean addRobot()
    {
        return addRobot(1);
    }
    
    /**
     * Add a number of robots
     * @param num the number to add
     * @return true if added, false otherwise
     */
    public boolean addRobot(int num)
    {
        if(spaceAvailable(robot, num))
        {
            robot += num;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Remove an amount of a resource based on a key
     * @param key a marker to determine a resource
     * @param value the value to remove
     * @return true if the value has been removed by the chosen resource
     * false otherwise
     */
    public boolean subtractWithKey(int key, int value)
    {
        return addWithKey(key, -value);
    }
    
    /**
     * Remove 1 water
     * @return true if removed, false otherwise
     */
    public boolean subtractWater()
    {
        return addWater(-1);
    }
    
    /**
     * Remove an amount of water
     * @param num the amount to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractWater(int num)
    {
        return addWater(-num);
    }
    
    /**
     * Remove 1 fur
     * @return true if removed, false otherwise
     */
    public boolean subtractFur()
    {
        return addFur(-1);
    }
    
    /**
     * Remove a number of furs
     * @param num the number to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractFur(int num)
    {
        return addFur(-num);
    }
    
    /**
     * Remove 1 food
     * @return true if removed, false otherwise
     */
    public boolean subtractFood()
    {
        return addFood(-1);
    }
    
    /**
     * Remove an amount of food
     * @param num the amount to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractFood(int num)
    {
        return addFood(-num);
    }
    
    /**
     * Remove 1 ore
     * @return true if removed, false otherwise
     */
    public boolean subtractOre()
    {
        return addOre(-1);
    }
    
    /**
     * Remove an amount of ore
     * @param num the amount to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractOre(int num)
    {
        return addOre(-num);
    }
    
    /**
     * Remove 1 game
     * @return true if removed, false otherwise
     */
    public boolean subtractGame()
    {
        return addGame(-1);
    }
    
    /**
     * Remove an amount of game
     * @param num the amount to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractGame(int num)
    {
        return addGame(-num);
    }
    
    /**
     * Remove 1 firearm
     * @return true if removed, false otherwise
     */
    public boolean subtractFirearm()
    {
        return addFirearm(-1);
    }
    
    /**
     * Remove a number of firearms
     * @param num the number to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractFirearm(int num)
    {
        return addFirearm(-num);
    }
    
    /**
     * Remove 1 medicine
     * @return true if removed, false otherwise
     */
    public boolean subtractMedicine()
    {
        return addMedicine(-1);
    }
    
    /**
     * Remove a number of medicines
     * @param num the number to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractMedicine(int num)
    {
        return addMedicine(-num);
    }
    
    /**
     * Remove 1 machines
     * @return true if removed, false otherwise 
     */
    public boolean subtractMachine()
    {
        return addMachine(-1);
    }
    
    /**
     * Remove a number of machines
     * @param num the number to remove
     * @return true if removed, false otherwise 
     */
    public boolean subtractMachine(int num)
    {
        return addMachine(-num);
    }
    
    /**
     * Remove 1 narcotic
     * @return true if removed, false otherwise
     */
    public boolean subtractNarcotic()
    {
        return addNarcotic(-1);
    }
    
    /**
     * Remove a number of narcotics
     * @param num the number to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractNarcotic(int num)
    {
        return addNarcotic(-num);
    }
    
    /**
     * Remove 1 robot
     * @return true if removed, false otherwise
     */
    public boolean subtractRobot()
    {
        return addRobot(-1);
    }
    
    /**
     * Remove a number of robots
     * @param num the number to remove
     * @return true if removed, false otherwise
     */
    public boolean subtractRobot(int num)
    {
        return addRobot(-num);
    }
    public void addMaxCargo(final int add) {
        maxCargo += add;
    }
    public void reduceMaxCargo(final int reduce) {
        maxCargo -= reduce;
    }
}
