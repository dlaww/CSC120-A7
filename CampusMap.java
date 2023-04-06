import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Tyler House", "99 Green Street Northampton, MA 01063", 4, true, false));
        myMap.addBuilding(new Building("Lyman Conservatory", "16 College Lane Northampton, MA 01063", 1));
        myMap.addBuilding(new Building("Campus School of Smith College", "33 Prospect Street Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Mwangli Cultural Center and Davis Center", "12 Prospect Street Northampton, MA 01063", 3));
        myMap.addBuilding(new House("Capen House", "26 Prospect Street Northampton, MA 01063", 3, false, false));
        myMap.addBuilding(new House("Lamont House", "17 Prospect Street Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Talbot House", "25 Prospect Street Northampton, MA 01063", 4, false, false));
        myMap.addBuilding(new House("NoGi (Northrop Gillet) House", "49 Elm Street Northampton, MA 01063", 5, true, true));
        myMap.addBuilding(new Building("Campus Center", "100 Elm Street Northampton, MA 01063", 3));
        myMap.addBuilding(new Cafe("Julia Child Campus Center Cafe", "100 Elm Street Northampton, MA 01063", 1, false));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true));
        System.out.println(myMap);
    }
    
}
