package Unit0.Mountains.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import Unit0.Mountains.Program;

public class ProgramTest {

    @Test
    public void testCheckValid(){
        String valid = "Hong Kong SAR	Mountain	Castle Peak	22.383	113.95	583 m";
        Program.checkValid(valid);

        //fail

        String invalid = "Hong Kong SAR\tmen\tMountain\tCastle Peak\t22.383\t113.95\t583 m";
        try{Program.checkValid(invalid);
            fail();
        } catch(RuntimeException e){
            assertEquals("Incorrect number of records - 7", e.getMessage());
        }
    }

}
