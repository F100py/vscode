package Calculator;
public class NumNode extends RawNode{
    private double _num;

    public NumNode(String rawContent){
        super(rawContent);
        _num = Double.parseDouble(rawContent);
    }

    public double getNum(){return _num;}
}
