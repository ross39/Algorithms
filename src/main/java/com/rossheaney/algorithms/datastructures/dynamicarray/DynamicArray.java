/*
* Generic Dynamic Array class
* @author Ross Heaney
*
*/
package main.java.com.rossheaney.algorithms.datastructures.dynamicarray;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private T[] array;
    private int length;
    private int capacity;

    public DynamicArray() {
        this.capacity = 15;
    }

    public DynamicArray(int capacity) {
        //We need a sanity check here to make sure the capacity is greater than 0
        if(capacity < 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity]; // TODO: need to check typecast
    }


    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
