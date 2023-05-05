package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyLinkedListBasedSet<T>  {

    protected MyLinkedList<T> _dataHold = new MyLinkedList<T>();


    
    public int size() {
        return _dataHold.getLength();
    }


    
    public boolean isEmpty() {
        return _dataHold.isEmpty();
    }


    
    public boolean contains(Object o) {
        return _dataHold.contains((T)o);
    }



    
    public boolean add(T t) {
        if(_dataHold.contains(t))
            return false;
        else {
            _dataHold.add(t);
        }
        return true;
    }

    
    public boolean remove(Object o) {
        if(_dataHold.contains((T)o)) {
            _dataHold.remove((T)o);
            return true;
        }
        return false;
    }

    
    public void clear() {
        _dataHold.clear();
    }

    
    public String toString() {
        return _dataHold.toString();
    }
}
