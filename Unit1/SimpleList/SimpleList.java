package SimpleList;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@SuppressWarnings({"rawtypes", "unused"})
public class SimpleList implements List {
    
    /**
     * SimpleNode definition of a single-linked list of Objects 
     */
    private class SimpleNode {
        private Object _data;
        private SimpleNode _next;
        
        private SimpleNode(Object data) {
            this(data,  null);
        }
        
        private SimpleNode(Object data, SimpleNode next) {
            _data = data;
            _next = next;
        }
    }
    
    int size;
    SimpleNode _head;
    SimpleNode _tail;
    public SimpleList() {
        size = 0;
        _head = null;
        _tail = null;
    }

    /**
     * Appends the specified element to the end of this list (optional operation).
     * @param element - element to be appended to this list.
     * @return true
     */
    @Override
    public boolean add(Object element) {
        if (size==0){
            _head = new SimpleNode(element);
            size++;
            return true;
        }
        SimpleNode temp = _head;
        while (temp._next!=null){
            temp = temp._next;
        }
        temp._next = new SimpleNode(element);
        size++;
        return true;
    }
    
    /**
     * Inserts the specified element at the specified position in this list.
     * @param index - index at which the specified element is to be insered.
     * @param element - element to be inserted.
     */
    @Override
    public void add(int index, Object element) {
        if (size==0){
            _head = new SimpleNode(element);
        }else if (index == 0){
            SimpleNode temp = new SimpleNode(element);
            temp._next = _head;
            _head = temp;
        }else{
            SimpleNode temp = _head;
            for (int i = 0; i<index-1; i++){
                temp = temp._next;
            }
            SimpleNode n = new SimpleNode(element);
            n._next = temp._next;
            temp._next = n;
        }
        size++;
    }

    public void quickPrint(){
        System.out.println("" + _head._data);
        System.out.println("" + _head._next._data);
        System.out.println("" + _head._next._next._data);
    }

    /**
     * Removes all of the elements from this list (optional operation).
     */
    @Override
    public void clear() {
        _head = new SimpleNode(null);
        _tail = new SimpleNode(null);
    }
    
    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return.
     * @return the element at the specified position in this list.
     */
    @Override
    public Object get(int index) {
        SimpleNode temp = this._head;
        for (int i = 0; i<index; i++){
            temp = temp._next;
        }
        return temp._data;
    }
    
    /**
     * Removes the element at the specified position in this list.
     * @param index - the index of the element to be removed.
     * @return the element previously at the specified position.
     */
    @Override
    public Object remove(int index) {
        if (index==0){
            Object o = _head._data;
            _head = _head._next;
            size--;
            return o;
        }
        SimpleNode temp = _head;
        for (int i = 0; i<index-1; i++){
            temp = temp._next;
        }
        Object o = temp._next._data;
        temp._next = temp._next._next;
        size--;
        return o;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index - index of the element to replace.
     * @param element - element to be stored at the specified position.
     * @return the element previously at the specified position.
     */
    @Override
    public Object set(int index, Object element) {
        if (size==0)
            _head = new SimpleNode(element);
        SimpleNode temp = _head;
        for (int i = 0; i<index; i++){
            temp = temp._next;
        }
        Object o = temp._data;
        temp._data = element;
        size++;
        return o;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size==0)
            return true;
        return false;
    }

    // #region: Overrides not supported by the SimpleList
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    // #endregion: Overrides not supported by the SimpleList
}
