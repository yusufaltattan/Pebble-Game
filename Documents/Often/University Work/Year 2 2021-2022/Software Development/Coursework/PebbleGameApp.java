import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class PebbleGameApp {
    bag A;
    bag B;
    bag C;

    // Getters
    public bag getBagA() {
        return A;
    }

    public bag getBagB() {
        return B;
    }

    public bag getBagC() {
        return C;
    }

    // Setters
    public void setBagA(bag A) {
        this.A = A;
    }

    public void setBagB(bag B) {
        this.B = B;
    }

    public void setBagC(bag C) {
        this.C = C;
    }

    public void loadFile1() {
        bag bag_a = new bag("bag_a", 0);
        String line = "";
        int m = 0;
        // String path = "C:/Users/yusuf/Documents/Often/University Work/Year 2 2021-2022/Software Development/Coursework/example_file_1.csv";
        System.out.println("Please enter location of bag number 0 to load:");
        Scanner sc = new Scanner(System.in);
        String path = sc.next();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null) {
                String[] inputs = line.split(",");
                // System.out.println(inputs[2]);
                int[] values = new int[100];

                for (String input: inputs) {
                    values[m] = Integer.parseInt(input);
                    pebble a = new pebble(values[m]);
                    bag_a.addPebble(a);
                    m++;
                }
        }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        this.setBagA(bag_a);
        // System.out.println(bag_a.pebbles.size());
        // System.out.println(bag_a.pebbles.get(55).getWeight());

    }

    
    public void loadFile2() {
        bag bag_b = new bag("bag_b", 0);
        String line = "";
        int m = 0;
        // String path = "C:/Users/yusuf/Documents/Often/University Work/Year 2 2021-2022/Software Development/Coursework/example_file_1.csv";
        
        System.out.println("Please enter location of bag number 1 to load:");
        Scanner sc = new Scanner(System.in);
        String path = sc.next();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null) {
                String[] inputs = line.split(",");
                // System.out.println(inputs[2]);
                int[] values = new int[100];

                for (String input: inputs) {
                    values[m] = Integer.parseInt(input);
                    pebble a = new pebble(values[m]);
                    bag_b.addPebble(a);
                    m++;
                }
        }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        this.setBagB(bag_b);

    }

    public void loadFile3() {
        bag bag_c = new bag("bag_c", 0);
        String line = "";
        int m = 0;
        // String path = "C:/Users/yusuf/Documents/Often/University Work/Year 2 2021-2022/Software Development/Coursework/example_file_1.csv";
        
        System.out.println("Please enter location of bag number 2 to load:");
        Scanner sc = new Scanner(System.in);
        String path = sc.next();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null) {
                String[] inputs = line.split(",");
                // System.out.println(inputs[2]);
                int[] values = new int[100];

                for (String input: inputs) {
                    values[m] = Integer.parseInt(input);
                    pebble a = new pebble(values[m]);
                    bag_c.addPebble(a);
                    m++;
                }
        }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        this.setBagC(bag_c);
    }

    class Players extends Thread {
        String playerName;
        ArrayList<pebble> playerHand;
        Random randomNumGen = new Random();

        // Getters
        public String getPlayerName() {
            return playerName;
        }

        
        public ArrayList<pebble> getPlayerHand() {
            return playerHand;
        }

        // Setters
        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        
        public void setPlayerHand(ArrayList<pebble> playerHand) {
        this.playerHand = playerHand;
        }

        public void addToPlayerHand(pebble pebble) {
        playerHand.add(pebble);
        }

        Players(String playerName) {
            setPlayerName(playerName);
            playerHand = new ArrayList<pebble>();
        }

        public void run() {
            Players player1 = new Players("Player 1");
            int y;
            int totalWeight;
            totalWeight = 0;
            double randNum = randomNumGen.nextDouble();
            y = 0;
            for (int i = 0; i < 10; i++) {
                int index = (int)(Math.random() * A.getTotalPebbles());
                player1.addToPlayerHand(A.getPebbles().get(index));
                System.out.print("Pebble with weight " + A.getPebbles().get(index).getWeight() + "  has been picked." + "\n");
                A.getPebbles().remove(index);
            }
            // System.out.println(player1.playerHand.size());
            // System.out.println(A.getTotalPebbles());

            while (totalWeight != 100) {
                totalWeight = 0;
                for (int i = 0; i < 10; i++) {
                    totalWeight = totalWeight + player1.playerHand.get(i).getWeight(); 
                }
                System.out.println("Total weight is: " + totalWeight);

               // Process of Discarding
                int index = (int)(Math.random() * player1.playerHand.size());
                System.out.println("Pebble " + player1.playerHand.get(index).getWeight() + " has been discarded.");
                totalWeight = totalWeight - player1.playerHand.get(index).getWeight(); 
                player1.playerHand.remove(index);

                // Process of adding new pebble
                if (randNum < 0.3) {
                    int indexPebble = (int)(Math.random() * A.getTotalPebbles());
                    player1.addToPlayerHand(A.getPebbles().get(indexPebble));
                    System.out.print("Pebble with weight " + A.getPebbles().get(indexPebble).getWeight() + "  has been picked." + "\n");
                A.getPebbles().remove(indexPebble);
                } else if (randNum < 0.6) {
                    int indexPebble = (int)(Math.random() * B.getTotalPebbles());
                    player1.addToPlayerHand(B.getPebbles().get(indexPebble));
                    System.out.print("Pebble with weight " + B.getPebbles().get(indexPebble).getWeight() + "  has been picked." + "\n");
                    B.getPebbles().remove(indexPebble);
                } else {
                    int indexPebble = (int)(Math.random() * C.getTotalPebbles());
                    player1.addToPlayerHand(C.getPebbles().get(indexPebble));
                    System.out.print("Pebble with weight " + C.getPebbles().get(indexPebble).getWeight() + "  has been picked." + "\n");
                    C.getPebbles().remove(indexPebble);
                }
            }
            // else if (totalWeight == 100) {
            //     System.out.println("WINNER FOUND");
            // }
        }
    }

    public static void startPrint() {
        System.out.println("Welcome to the Pebblegame!!!" + "\n" + "You will be asked to enter the number of players." + "\n" + "and then for the location of three files in turn containing comma seperated integer values for the pebble weights." +"\n" + "The integer values must be stricly positive." +  "\n" + "The game will then be simulated, and the output written to files in this directory." + "\n");
    }
    
    public static void main(String[] args) {
        startPrint();
        PebbleGameApp game = new PebbleGameApp();

        game.loadFile1();
        // System.out.println(game.getBagA().pebbles.size());
        // System.out.println(game.getBagA().pebbles.get(55).getWeight());
        game.loadFile2();
        // // System.out.println(game.getBagB().pebbles.size());
        // // System.out.println(game.getBagB().pebbles.get(79).getWeight());
        game.loadFile3();
        // System.out.println(game.getBagB().pebbles.size());
        // System.out.println(game.getBagB().pebbles.get(30).getWeight());
        PebbleGameApp.Players mainPlayer = game.new Players("mainPlayer");
        mainPlayer.start();        

    }
}

