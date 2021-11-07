// Simple class to create bag objects
import java.util.ArrayList;

public class bag extends pebble {
    ArrayList<pebble> pebbles;
    String bagName;
    int totalPebbles;
    
    // Getter
    public String getBagName() {
        return bagName;
    }

    public ArrayList<pebble> getPebbles() {
        return pebbles;
    }

    public int getTotalPebbles() {
        return pebbles.size();
    }

    // Setter
    public void setBagName(String bagName) {
        this.bagName = bagName;
    }
    
    public void addPebble(pebble pebble) {
        pebbles.add(pebble);
    }

    // Constructor 

    bag(String bagName, int weight) {
        super(weight);
        setBagName(bagName);
        pebbles = new ArrayList<pebble>(); 
    }

    public static void main(String[] args) {
        bag A = new bag("What", 0);
        pebble a = new pebble(0);
        pebble b = new pebble(1);
        A.addPebble(a);
        A.addPebble(b);
        System.out.println(A.getBagName());
        System.out.println(A.pebbles.size());
        System.out.println(A.pebbles.get(1).getWeight());
        }
}
