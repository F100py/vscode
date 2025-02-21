package Unit4.HashCompete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {
    public static final String _bookFile = "Unit4\\HashCompete\\pride_and_prejudice.txt";
    static double lowest;
    static int first;
    static int second;
    public static void main(String[] args) throws IOException {
        System.out.println("Hello to the Hashing competition!");
        
        // read the book word by word and add each word to a HashWordSet
        
        
        
        first = 0;
        second = 0;
        lowest = 500.0;

        IntStream.range(0, 257).parallel().forEach(i ->{
            File file = new File(_bookFile);
            try{
                Scanner reader = new Scanner(file, "UTF-8");
                HashWordSet hash = new HashWordSet();
                while(reader.hasNext()) {
                    hash.add(reader.next(), i);
                }
                double tempfactor = hash.getEfficiencyFactor();
                // System.out.println("hashnum, efficiency factor: " +i +", "+(int)(tempfactor));
                if (tempfactor<lowest){
                    lowest = hash.getEfficiencyFactor();
                    first = i;
                }
                reader.close();
            }catch(FileNotFoundException f){
                System.out.println("not skibidi");
            }
            
        });

        System.out.println("The First for the best ef is: "+first +", "+lowest);
        
        // print the hash object
        
        System.out.println("Goodbye!");
//         System.out.println("Hello to the Hashing competition!");
// // read the book word by word and add each word to a HashWordSet
//         HashWordSet hash = new HashWordSet();
//         File file = new File(_bookFile);
//         Scanner reader = new Scanner(file, "UTF-8");
//         while (reader.hasNext()) {
//             hash.add(reader.next());
//         }
//         reader.close();
//         // print the hash object
//         System.out.println(hash);
//         System.out.println("Goodbye!");
    }
}
