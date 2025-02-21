package Unit0.Mountains;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) throws IOException{
        Path dbPath = Paths.get("./Unit0/Mountains/Files/mountains_db.tsv");
        BufferedReader br = Files.newBufferedReader(dbPath, StandardCharsets.UTF_8);

        Path cleanPath = Paths.get("./Unit0/Mountains/Files/mountains_clean.tsv");
        BufferedWriter cbw = Files.newBufferedWriter(cleanPath, StandardCharsets.UTF_8);

        Path errPath = Paths.get("./Unit0/Mountains/Files/mountains_err.tsv");
        BufferedWriter ebw = Files.newBufferedWriter(errPath, StandardCharsets.UTF_8);

        String header = br.readLine();
        cbw.write(header + "\n");
        ebw.write(header + "\n");

        int counter = 0;
        int errcounter = 0;
        Mountain max = new Mountain("Australia\tMountain\tMountain Ash Hill\t-35.3877904524225\t149.888963699341\t0 m");
        Mountain min = new Mountain("Australia\tMountain\tMountain Ash Hill\t-35.3877904524225\t149.888963699341\t" + Integer.MAX_VALUE + " m");
        while (br.ready()){
            String line = br.readLine();
            try{
                Mountain temp = new Mountain(line);
                cbw.write(line + "\n");
                if (temp.height>max.height)
                    max = temp;
                if (temp.height<min.height)
                    min = temp;
            } catch(RuntimeException e){
                ebw.write(line + ": " + e.getMessage() + "\n");
                errcounter++;
            }
            counter++;
        }
        System.out.println("Original db length: " + Files.size(dbPath)+ " bytes");
        System.out.println("Clean db length: " + Files.size(cleanPath)+ " bytes");
        System.out.println("Number of valid lines: " + (counter - errcounter));
        System.out.println("Number of corrupted lines: " + errcounter);
        System.out.println("Shortest Mountain: " + min.toString());
        System.out.println("Tallest Mountain: " + max.toString());
        br.close();
        cbw.close();
        ebw.close();
    }

    //this should be in constructor
    public static void checkValid(String line){
        String[] records = line.split("\t");
        if (records.length != 6)
            throw new RuntimeException("Incorrect number of records - " + records.length);
        double latitude;
        try{
            latitude = Double.parseDouble(records[3]);
        } catch(Exception e){
            throw new RuntimeException("unable to parse Latitude - " + records[3]);
        }
        if (latitude<-90||latitude>90)
                throw new RuntimeException("Latitude out of range - " + latitude);            
    }
}
