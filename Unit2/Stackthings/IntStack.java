package Stackthings;

import java.util.LinkedList;


public class IntStack {
    LinkedList<Integer> _list;

    public IntStack(LinkedList<Integer> list){
        _list = list;
    }

    public boolean empty(){
        if(_list.size()==0)
            return true;
        return false;
    }
    public int peek(){
        return _list.getLast();
    }  
    public int pop(){
        return _list.removeLast();
    }
    public void push(int item){
        _list.addLast(item);
    }
    public int search(int item){
        return _list.indexOf(item);
    }

}
