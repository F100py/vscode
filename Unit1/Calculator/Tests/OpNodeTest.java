package Calculator.Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Calculator.OpNode;
import Calculator.OpNode.OpCode;
public class OpNodeTest {

    @Test
    public void testConstructor(){
        OpCode[] opCodes = {
        OpCode.ADDITION,
        OpCode.SUBTRACTION,
        OpCode.MULTIPLICATION,
        OpCode.DIVISION,
        OpCode.MODULO,
        OpCode.POWER
        };
        String[] maths = {"+", "-", "*", "/", "%", "^"};
        for (int i = 0; i<opCodes.length; i++){
            OpNode n = new OpNode(maths[i]);
            assertEquals(opCodes[i], n.getOpCode());
        }
        try{
            @SuppressWarnings("unused")
            OpNode s = new OpNode("asdl;kfja;lehtio");
            fail();
        } catch(Exception e){
            assertEquals("Unable to parse OpCode: asdl;kfja;lehtio", e.getMessage());
        }
    }
}
