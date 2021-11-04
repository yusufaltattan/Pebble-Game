import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PebbleGameApp {

    public static void loadFile() {
        String line = "";
        // String path = "C:/Users/yusuf/Documents/Often/University Work/Year 2 2021-2022/Software Development/Coursework/example_file_1.csv";
        
        Scanner sc = new Scanner(System.in);
        String path = sc.next();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(values[2]);
            }
            
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        loadFile();
        }
}

