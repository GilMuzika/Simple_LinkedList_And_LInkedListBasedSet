package org.example;

import java.util.Iterator;

public class MyLinkedList<T> {

    private Node<T> _head;
    private Node<T> _tail;
    private int _length = 0;

    public void add(T data){
        Node<T> tempNode = new Node<>(data);
        if(this._head == null) {
            this._head = tempNode;
        } else{
            Node<T> lastNode = _head;
            while(lastNode.get_next() != null) { //find the last node
                lastNode = lastNode.get_next();
            }
            tempNode.set_prev(lastNode);
            lastNode.set_next(tempNode);
            _tail = tempNode;
        }
        _length++;
    }

    public void addAtPosition(int position, T data) {
        if(position > _length) //The bount is not the length - 1 but just the length. Of course the zero based index is taken into consideration, but adding the new member is increases the length by 1
            throw new IndexOutOfBoundsException(String.format("The position %s is out of bounds of the current list which max possible position is %s", position, _length));

        Node<T> lastNode = _head;
        if(position == 0) {
            _head = new Node<>(data);
            _head.set_next(lastNode);
        } else {
            Node<T> previuos = new Node<>((T) new Object());
            while(position - 1 >= 0) {
                previuos = lastNode;
                lastNode = lastNode.get_next();
                position--;
            }
            Node<T> newNode = new Node<T>(data);
            newNode.set_prev(previuos);
            previuos.set_next(newNode);
            if(lastNode != null) {
                previuos.get_next().set_next(lastNode); //Analoguos to node.next.next
                lastNode.set_prev(newNode);
                _tail = lastNode;
            } else {
                _tail = previuos.get_next();
            }
        }
        _length++;
    }

    public void remove(T dataKey) {
        Node<T> tempNode = _head;
        Node<T> previous = new Node<>((T) new Object());
        if(tempNode.get_data() != dataKey) {
           while(tempNode.get_data() != dataKey) {
               previous = tempNode;
               tempNode = tempNode.get_next();
           }
        }
        if(tempNode == _head) {
            _head = _head.get_next();
            _head.set_prev(null);
        } else {
            tempNode = tempNode.get_next();
            tempNode.set_prev(previous);
            previous.set_next(tempNode);
            _tail = tempNode;
        }
        _length--;
    }

    public void removeAtPosition(int position){
        if(position > _length - 1)
            throw new IndexOutOfBoundsException(String.format("The position %s is out of bounds of the current list which max possible position is %s", position, _length - 1));

        if(position == 0) {
            _head = _head.get_next();
            _head.set_prev(null);
        } else {
            Node<T> tempNode = _head;
            int count = 0;
            while(count != position - 1){
                tempNode = tempNode.get_next();
                count++;
            }
            Node<T> newNode = tempNode.get_next().get_next();
            if(newNode != null){
                newNode.set_prev(tempNode);
                _tail = newNode;
            } else {
                _tail = tempNode;
            }
            tempNode.set_next(newNode);
        }
        _length--;
    }

    public void clear() {
        _head = null;
        _tail = null;
        _length = 0;
    }

    public boolean isEmpty() {
        return _head == null && _length == 0;
    }

    public int getLength() {
        return _length;
    }

    public T getFirst() {
        return _head.get_data();
    }
    public T getLast() {
        return _tail.get_data();
    }



    private Node<T> getHeadNode() {
        return _head;
    }

    public boolean contains(T data) {
        Node<T> current = this._head;
            while (current != null) {
                T val = current.get_data();
                if (data.equals(val))
                    return true;

                current = current.get_next();
            }

        return false;
    }

    @Override
    public String toString() {
        if(_head == null)
            return "[ the list is empty ]";

        Node<T> tempNode = _head;
        StringBuilder sb = new StringBuilder("[ ");
        while(tempNode.get_next() != null) {
            sb.append(tempNode.get_data() + ", ");
            tempNode = tempNode.get_next();
        }
        sb.append(tempNode.get_data() + " ]");
        return sb.toString();
    }





}
