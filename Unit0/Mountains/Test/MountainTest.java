package Unit0.Mountains.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Unit0.Mountains.Mountain;

public class MountainTest {
    String valid = "Hong Kong SAR	Mountain	Castle Peak	22.383	113.95\t583 m";

    @Test
    public void testConstructor(){
        try{@SuppressWarnings("unused")
        Mountain m = new Mountain(valid);}
        catch(RuntimeException e){
            fail();
        }
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> new Mountain("asfdf"), "Expected constructor to throw, but it didn't");
        assertTrue(thrown.getMessage().contains("Incorrect number of records"));
    }

    @Test
    public void testParseLatitude(){
        try{
            Mountain.parseLatitude("qq");
            fail();
        } catch(RuntimeException e){
            if (!e.getMessage().contains("unable to parse")){
                fail();
            }
        }
        try{
            Mountain.parseLatitude("5000");
            fail();
        } catch(RuntimeException e){
            if (!e.getMessage().contains("out of range")){
                fail();
            }
        }
    }

    @Test
    public void testParseLongitude(){
        try{
            Mountain.parseLongitude("qq");
            fail();
        } catch(RuntimeException e){
            if (!e.getMessage().contains("unable to parse")){
                fail();
            }
        }
        try{
            Mountain.parseLongitude("5000");
            fail();
        } catch(RuntimeException e){
            if (!e.getMessage().contains("out of range")){
                fail();
            }
        }
    }

    @Test
    public void testParseElevation(){
        try{
            Mountain.parseElevationTest("asdfasdf");
            fail();
        } catch(RuntimeException e){
            if (!e.getMessage().contains("Unable to parse")){
                fail();
            }
        }
        try{
            Mountain.parseElevationTest("-5 m");
            fail();
        } catch(RuntimeException e){
            if (!e.getMessage().contains("out of range")){
                fail();
            }
        }
        try {Mountain.parseElevationTest("155 f");
        fail();}
        catch(RuntimeException e){
            if (!e.getMessage().contains("units invalid")){
                fail();
            }
        }
    }
}
