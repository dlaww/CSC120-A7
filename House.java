import java.util.ArrayList;
/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /* House constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /* Method to update the array list everytime someone moves in */
    public void moveIn(String name) {
      residents.add(name);
    }
    /* Overloaded moveIn method to include floor of residence */
    public void moveIn(String name, int roomNumber) {
      residents.add(name);
    }

    /* Method to update the array list everytime someone moves out */
    public void moveOut(String name) {
      residents.remove(name);
    }

    /* Method to check if someone is a resident of a house */
    public boolean isResident(String person) {
      if (residents.contains(person)) {
        System.out.println(person + " is a resident of this house.");
        return true;
      } else {
        return false;
      }
    }
    /* Overloaded 'isResident' method to include the room number of resident
     * Private so that public cannot access room number information
     */
    private boolean isResident(String person, int roomNumber) {
      if (residents.contains(person)) {
        System.out.println(person + " is a resident of this house, living in room " + roomNumber + ".");
        return true;
      } else {
        System.out.println(person + " is not a resident of this house.");
        return false;
      }
    }

  /* Method to print full description of the requested House 
   * Includes information about number of residents and whether there is a dining room or elevator
  */
  public String toString() {
    String description = super.toString();
    description += ". This house currently has " + this.residents.size() + " residents.";
    description += " This house " ;
    if (this.hasDiningRoom) {
      description += "has a dining room.";
    } else {
      description += "does not have a dining room";
    }
    return description;
  }

  /* Method to override 'showOptions()' method to show subbclass specific methods of House */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + moveIn() \n + moveOut() \n + isResident \n");
  }  

  /* Method to override 'goToFloor' method for the House class */
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
        System.out.println("This building does not have  an elevator!");
    }
  }

  /* Main method for House to test all above */
  public static void main(String[] args) {
    House ziskind = new House("Ziskind", "1 Henshaw Ave Northampton MA", 3, true, true);
    ziskind.showOptions();
    ziskind.enter();
    ziskind.goToFloor(2);
    System.out.println(ziskind);

    House capen = new House("Capen", "26 Prospect Street Northampton MA", 3, false, false);
    capen.showOptions();
    capen.moveIn("dakota");
    capen.isResident("dakota");
    capen.isResident("dakota", 318);
    capen.isResident("skarlet", 212);
    capen.enter();
    capen.goToFloor(3);
    System.out.println(capen);
  }

}