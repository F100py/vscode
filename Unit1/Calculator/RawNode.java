package Calculator;

public class RawNode {
    String _rawContent;
    RawNode _prev;
    RawNode _next;

    public RawNode(String rawContent){_rawContent = rawContent;}
    public RawNode(){}

    public String getRawContent(){return _rawContent;}
    public RawNode getNext(){return _next;}
    public RawNode getPrev(){return _prev;}

    public RawNode addNext(RawNode next){
        RawNode temp = _next;
        _next = next;
        return temp;
    }
    public RawNode addTail(RawNode tail){
        RawNode temp = _prev;
        _prev = tail;
        return temp;
    }
}
