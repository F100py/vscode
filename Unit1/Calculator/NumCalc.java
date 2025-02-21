package Calculator;

import Calculator.OpNode.OpCode;

public class NumCalc {
    public static final OpCode[][] ORDER = {
        {OpCode.POWER}, 
        {OpCode.DIVISION, OpCode.MULTIPLICATION, OpCode.MODULO},
        {OpCode.ADDITION, OpCode.SUBTRACTION}
    };
    RawNode _head;
    RawNode _trace;
    RawNode _tail;
    String _exp;

    public NumCalc(String exp){
        _exp = exp;
        evaluate();
    }

    public void createNumOpList(String rawList){
        String[] potato = rawList.split(" ");
        try{
            _head = new RawNode(potato[0]);
            Double.parseDouble(potato[0]);
        }catch(RuntimeException e){
            throw new RuntimeException("Unrecognized token: " + potato[0]);
        }
        _tail = _head;
        for (int i = 1; i<potato.length; i++){
            try{
                NumNode n = new NumNode(potato[i]);
                Double.parseDouble(n.getRawContent());
                n._prev = _tail;
                _tail._next = n;
                _tail = _tail._next;

                if (_tail._prev instanceof NumNode)
                    throw new RuntimeException("Wrong operands for the operator " + n._rawContent);
            }
            catch(RuntimeException e){
                if (e.getMessage().contains("Wrong operands for the operator"))
                        throw new RuntimeException(e.getMessage());
                try{
                OpNode o = new OpNode(potato[i]);
                if (o.getOpCode() == OpCode.UNKNOWN)
                    throw new RuntimeException();
                o._prev = _tail;
                _tail._next = o;
                _tail = _tail._next;

                if (_tail._prev instanceof OpNode)
                    throw new RuntimeException("Wrong operands for the operator " + o._prev._rawContent);
                }
                catch(RuntimeException er){
                    if (er.getMessage().contains("Wrong operands for the operator"))
                        throw new RuntimeException(er.getMessage());
                    throw new RuntimeException("Unrecognized token: " + potato[i]);
                }
            }
        }
    }

    public String evaluate(){
        createNumOpList(_exp);
        String ans = "";
        RawNode temp = new RawNode();
        _tail = _head;
        printTrace(_head);
        for (int i = 0; i < ORDER.length; i++){
            temp = _head;
            while (temp._next!=null){
                temp = temp._next;
                try{
                    OpNode temp2 = (OpNode)(temp);
                    if (contains(ORDER[i], temp2.getOpCode())){
                        double ask = Double.parseDouble(calculate(temp)._rawContent);
                        temp._rawContent = ask + "";
                        try{
                            temp._prev._prev._next = temp;
                        }catch(RuntimeException e){}
                        temp._prev = temp._prev._prev;
                        try{
                            temp._next._next._prev = temp;
                        }catch(RuntimeException e){}
                        temp._next = temp._next._next;
                        printTrace(temp);          
                    }
                } catch(RuntimeException e){
                    if (e.getMessage().contains("divide by zero"))
                        throw new RuntimeException(e.getMessage());
                    if (e.getMessage().contains("Wrong operands"))
                        throw new RuntimeException(e.getMessage());
                }
            }
        }
        ans = temp.getRawContent();
        _exp = ans;
        return ans;
    }

    public static boolean contains(OpCode[] a, OpCode b){
        for(OpCode x: a){
            if (b==x)
                return true;
        }
        return false;
    }

    public void printTrace(RawNode temp){
        while (temp._prev!=null){
            temp = temp._prev;
        }
        while (temp!=null){
            System.out.print(temp.getRawContent());
            temp = temp._next;
        }
        System.out.println();
    }

    public NumNode calculate(RawNode op){
        double ans = 0.0;
        // // if ((op._next instanceof OpNode) || (op._prev instanceof OpNode)){
        // //     throw new RuntimeException("Wrong operands for the operator " + op._rawContent);
        // }
        switch(op.getRawContent()){
            case "+":
                ans = Double.parseDouble(op._prev.getRawContent()) + Double.parseDouble(op._next.getRawContent());
                break;
            case "-":
                ans = Double.parseDouble(op._prev.getRawContent()) - Double.parseDouble(op._next.getRawContent());
                break;
            case "*":
                ans = Double.parseDouble(op._prev.getRawContent()) * Double.parseDouble(op._next.getRawContent());
                break;
            case "/":
                if (Double.parseDouble(op._next.getRawContent())==0.0)
                    throw new RuntimeException("Rethink your life choices, because you just tried to divide by zero.");
                ans = Double.parseDouble(op._prev.getRawContent()) / Double.parseDouble(op._next.getRawContent());
                break;
            case "%":
                ans = Double.parseDouble(op._prev.getRawContent()) % Double.parseDouble(op._next.getRawContent());
                break;
            case "^":
                ans = Math.pow(Double.parseDouble(op._prev.getRawContent()), Double.parseDouble(op._next.getRawContent()));
                break;
            default:
                throw new RuntimeException("Unable to parse OpCode: " + op.getRawContent());
        }
        return new NumNode("" + ans);
    }
}