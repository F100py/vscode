package Unit0.Mountains;

public class Mountain {
    public int height;
    private String[] records;
    public Mountain(String line) throws RuntimeException{
        records = line.split("\t");
        if (records.length != 6)
            throw new RuntimeException("Incorrect number of records - " + records.length);
        String latitude = records[3];
        parseLatitude(latitude);
        String longitude = records[4];
        parseLongitude(longitude);
        String elevation = records[5];
        parseElevation(elevation);
    }

    public String toString(){
        return records[0] + ", " + records[1] + ", " + records[2] + ", " + records[3] + ", " + records[4] + ", " + records[5];
    }

    public static void parseLatitude(String l) throws RuntimeException{
        double latitude = 0.0;
        try{
            latitude = Double.parseDouble(l);
        } catch(Exception e){
            throw new RuntimeException("unable to parse Latitude - " + l);
        }
        if (latitude<-90||latitude>90)
            throw new RuntimeException("Latitude out of range - " + latitude);
    }

    
    public static void parseLongitude(String l) throws RuntimeException{
        double longitude = 0.0;
        try{
            longitude = Double.parseDouble(l);
        } catch(Exception e){
            throw new RuntimeException("unable to parse longitude - " + l);
        }
        if (longitude<-180||longitude>180)
            throw new RuntimeException("Longitude out of range - " + longitude);
    }

    
    public void parseElevation(String l) throws RuntimeException{
        height = 0;
        try{
            if (l.contains(" "))
                height = Integer.parseInt(l.substring(0, l.indexOf(" ")));
            else {
                height = Integer.parseInt(l);
            }
        } catch(Exception e){
            throw new RuntimeException("Unable to parse elevation - " + l);
        }
        if (height<0)
            throw new RuntimeException("Elevation out of range - " + height);
        if (l.contains(" ")&&!l.substring(l.indexOf(" ")+1).equals("m")){
            throw new RuntimeException("Elevation units invalid - " + l.substring(l.indexOf(" ")+1));
        }
    }
    public static void parseElevationTest(String l) throws RuntimeException{
        int elevation = 0;
        try{
            if (l.contains(" "))
                elevation = Integer.parseInt(l.substring(0, l.indexOf(" ")));
            else {
                elevation = Integer.parseInt(l);
            }
        } catch(Exception e){
            throw new RuntimeException("Unable to parse elevation - " + l);
        }
        if (elevation<0)
            throw new RuntimeException("Elevation out of range - " + elevation);
        if (!l.contains(" ")||!l.substring(l.indexOf(" ")+1).equals("m")){
            throw new RuntimeException("Elevation units invalid - " + l.substring(l.indexOf(" ")+1));
        }
    }

}
