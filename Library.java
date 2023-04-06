import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    /* Library constructor */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

    /* Method to update Hashtable everytime we add/remove a title */
    public void addTitle(String title) {
      collection.put(title, true);
      System.out.println(title + " has been added to the collection.");
    }
    /* Overloaded 'addTitle' method to include the author name */
    public void addTitle(String title, String author) {
      collection.put(title, true);
      collection.put(author, true);
      System.out.println(title + " by " + author + " has been added to the collection");
    }

    /* Method to removeTitle from Library collection */
    public String removeTitle(String title) {
      if (collection.contains(title)) {
        collection.remove(title, true);
      }
      else {
        System.out.println("This book is not available.");
      }
      System.out.println(title + " has been removed from the collection.");
      return title;
    } 
    /* Overloaded removeTitle method to include author name */
    public String removeTitle(String title, String author) {
      if (collection.contains(title + author)) {
        collection.remove(title, true);
      }
      else {
        System.out.println("This book is not available.");
      }
      System.out.println(title + " by " + author + " has been removed from the collection.");
      return title;
    }

    /* Methods to modify the value of the given key (the title) in the Library collection
     * Either checks out or returns the requested book
      */
    public void checkOut(String title) {
      if (collection.containsKey(title) && this.isAvailable(title)) {
        collection.replace(title, false);
        System.out.println(title + " has been sucessfully checked out.");
      } else {
        System.out.println(title + " is not available for checkout.");
      }
    }

    public void returnBook(String title) {
      collection.replace(title, true);
      System.out.println(title + " has been returned.");
    }

    /* Methods to modify the value of the given key (the title AND author) in the Library collection
     * Either checks out or returns the requested book with associated author
      */
    public void checkOut(String title, String author) {
      if (collection.containsKey(title) && collection.containsKey(author) && this.isAvailable(title)) {
        collection.replace(title, false);
        collection.replace(author, false);
        System.out.println(title + " by " + author + " has been sucessfully checked out.");
      } else {
        System.out.println(title + " by " + author + " is not available for checkout.");
      }
    }
    
    public void returnBook(String title, String author) {
      collection.replace(title, true);
      collection.replace(author, true);
      System.out.println(title + " by " + author + " has been returned.");
    }

    /* Methods to support browsing the collection 
     * Checks if Library collection contains the requested title and whether or not it's
     * available to be checked out
    */
    public boolean containsTitle(String title) {
      if (collection.contains(title)) {
        System.out.println(title + " is in our collection.");
        return true;
      } else {
        System.out.println(title + " is not in our collection.");
        return false;
      }
    }

    public boolean isAvailable(String title) {
      if (this.collection.get(title)) {
        System.out.println(title + " is available to be checked out.");
        return true;
      } else {
        System.out.println(title + " is not available to be checked out.");
        return false;
      }
    }

    /* Method to print out the entire Library collection */
    public void printCollection() {
      if (this.collection.isEmpty()) {
        System.out.println("No books to show.");
      } else {
        for (String title:this.collection.keySet()) {
          System.out.println(title);
          if (this.collection.get(title)) {
            System.out.println("Available");
          } else {
            System.out.println("Checked out");
          }
        }
      }
    }

    /* Method to override 'showOptions()' method to show subbclass specific methods of Library */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection() \n");
    }

    /* Method to override 'goToFloor' method for the Library class */
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

    /* Main method to test all written methods above*/
    public static void main(String[] args) {
      Library Neilson = new Library("Neilson", "7 Neilson Drive", 4, true);
      System.out.println(Neilson);
      Neilson.showOptions();
      Neilson.addTitle("The Lorax");
      Neilson.addTitle("The Hunger Games");
      Neilson.addTitle("all about love");
      Neilson.removeTitle("The Lorax");
      Neilson.containsTitle("The Lorax");
      Neilson.checkOut("The Hunger Games");
      Neilson.isAvailable("The Hunger Games");
      Neilson.checkOut("The Hunger Games");
      Neilson.printCollection();
      Neilson.enter();
      Neilson.goToFloor(4);
      Neilson.goDown();
    }
}