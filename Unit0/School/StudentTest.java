package Unit0.School;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    private Student a;
    @Before
    public void setup(){
        a = new Student(6969,"FreddyFazbear", 11);
    }

    @Test
    public void testStudentid(){assertEquals(6969, a.getid());}
    @Test
    public void testStudentName(){assertEquals("FreddyFazbear", a.getName());}
    @Test
    public void testStudentGrade(){assertEquals(11, a.getGrade());}

    @Test
    public void testIdIsValid(){
        if (a.getid()>0&&a.getName().length()>0&&a.getGrade()>=9&&
                a.getGrade()<=12&&a.getName()!=null)
            assertEquals(true, a.isValid());
        else 
            assertEquals(false, a.isValid());
    }

    @Test
    public void testMultid(){
        a.multid(4);
        assertEquals(6969*4, a.getid());
    }

    @Test
    public void testToString(){
        assertEquals("id: 6969, Name: FreddyFazbear, grade: 11", a.toString());
    }
}
