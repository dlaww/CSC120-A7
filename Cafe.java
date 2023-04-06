/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    private boolean hasElevator;

    /* Cafe constructor */
    public Cafe(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 50;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }
    
    /* Methods to decrease inventory everytime cup of coffee is sold */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets && this.nCreams > nCreams && nCups > 0) {
            this.nCoffeeOunces = this.nCoffeeOunces - size;
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
            this.nCreams = this.nCreams - nCreams;
            this.nCups = this.nCups - 1;
            System.out.println(size + "oz coffee with " + nSugarPackets + " sugar packets and " + nCreams + " creams has been sold.");
        }
        else {
            if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || nCups == 0) {
                restock(100, 100, 50, 50);
                System.out.println(this + " Cafe inventory has been restocked.");
                }
            }
        }
    /* Overloaded 'sellCoffee' method to sell default coffee */
    public void sellCoffee() {
        if (this.nCoffeeOunces > 12 && this.nSugarPackets > 2 && this.nCreams > 2 && nCups > 0) {
            this.nCoffeeOunces = this.nCoffeeOunces - 12;
            this.nSugarPackets = this.nSugarPackets - 2;
            this.nCreams = this.nCreams - 2;
            this.nCups = this.nCups - 1;
            System.out.println("Default coffee (12oz with 2 sugars and 2 creams) has been sold.");
        } else {
            if (this.nCoffeeOunces < 12) {
                restock(100);
                System.out.println(this + " Cafe inventory has been restocked.");
                }
            }
        }

    /* Restock method for Cafe inventory */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets ;
        this.nCreams = nCreams;
        this.nCups = nCups;    
    }
    /* Overloaded restock method to only restock coffee */
    private void restock(int nCoffeeOunces) {
        this.nCoffeeOunces = nCoffeeOunces;
    }

    /* Method to override 'showOptions()' method to show subbclass specific methods of Cafe */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + sellCoffee() \n + restock() \n");
    }

    /* Method to override 'goToFloor' method for the Cafe class */
    public void goToFloor(int floorNum) {
        if (this.hasElevator) {
          if (this.activeFloor == -1) {
              throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
          }
          if (floorNum < 1 || floorNum > this.nFloors) {
              throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
          }
          System.out.println("You are now on floor #" + floorNum + " of " + this.name);
          this.activeFloor = floorNum;
        } else {
            System.out.println("This building does not have an elevator!");
        }
    }

    /* Main Cafe method to test all written methods above */
    public static void main(String[] args) {
        Cafe campusCafe = new Cafe("Campus Cafe", "100 Elm Street", 1, false);
        campusCafe.showOptions();
        campusCafe.sellCoffee(100, 100, 50);
        campusCafe.sellCoffee(5, 10, 15);
        
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive", 1, true);
        compassCafe.showOptions();
        compassCafe.sellCoffee(40, 10, 10);
        compassCafe.sellCoffee();
        compassCafe.enter();
        compassCafe.goToFloor(2);
        
    }
    
}
