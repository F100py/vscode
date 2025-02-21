package Calculator;

public class OpNode extends RawNode{
    public enum OpCode{
        UNKNOWN,
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        MODULO,
        POWER
    }

    private OpCode _opCode;
    
    public OpNode(String rawContent){
        super(rawContent);
        _opCode = OpCode.UNKNOWN;
        switch(rawContent){
            case "+":
                _opCode = OpCode.ADDITION;
                break;
            case "-":
                _opCode = OpCode.SUBTRACTION;
                break;
            case "*":
                _opCode = OpCode.MULTIPLICATION;
                break;
            case "/":
                _opCode = OpCode.DIVISION;
                break;
            case "%":
                _opCode = OpCode.MODULO;
                break;
            case "^":
                _opCode = OpCode.POWER;
                break;
            default:
                throw new RuntimeException("Unable to parse OpCode: " + rawContent);
        }
    }
    
    public OpCode getOpCode(){return _opCode;}
}
