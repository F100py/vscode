package Unit4;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestHashStringSet {

    @Test
    public void basicTest(){
        HashStringSet hash = new HashStringSet("FB", "eA", "Kitten", "Cheese");
        assertTrue(hash.contains("FB"));
        assertTrue(hash.contains("eA"));
        assertTrue(hash.contains("Kitten"));
        assertTrue(hash.contains("Cheese"));
    }
}
