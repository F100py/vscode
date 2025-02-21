package Stackthings;

import java.util.LinkedList;

public class IntQueue {
    LinkedList<Integer> _list;

    public IntQueue(LinkedList<Integer> list){
        _list = list;
    }

    public void add(int item){
        _list.addLast(item);
    }
    public int remove(){
        return _list.removeFirst();
    }
    public int peek(){
        return _list.getFirst();
    }
}
