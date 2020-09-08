package lang;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * @author luzc
 * @date 2020/8/31 14:51
 * @desc
 */

public class ArrayListCopy<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 8683452581122892189L;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    public ArrayListCopy(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity:" + initialCapacity);
        }
    }

    public ArrayListCopy() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayListCopy(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {

            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    public void trimToSize() {
        modCount++;
        if (size < elementData.length) {
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }

    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                ? 0
                : DEFAULT_CAPACITY;
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;

        }
        return -1;
    }

    public Object clone(){
        try{
            ArrayListCopy<?> v = (ArrayListCopy<?> ) super.clone();
            v.elementData = Arrays.copyOf(elementData,size);
            v.modCount = 0;
            return v;

        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
            throw new InternalError(e);
        }
    }

    public Object[] toArray(){
        return Arrays.copyOf(elementData,size);
    }

    public <T> T[] toArray(T[] a){
        if (a.length <size){
            return (T[]) Arrays.copyOf(elementData,size,a.getClass());
        }
        System.arraycopy(elementData,0,a,0,size);
        if(a.length>size)
            a[size] = null;
        return a;
    }

    E elementData(int index){
        return (E) elementData[index];
    }

    public E get(int index){
        rangeCheck(index);
        return elementData(index);
    }

    private void rangeCheck(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }

    }

    private String outOfBoundMsg(int index){
        return "Index:" +index + ", Size" +size;
    }

    public boolean removeAll(Collection<?> c){
        Objects.requireNonNull(c);
        return batchRemove(c,false);
    }

    //todo : 这块代码看不太懂
    private boolean batchRemove(Collection<?> c,boolean complement){
        final Object[] elementData = this.elementData;
        int r = 0,w = 0;
        boolean modified = false;
        try{
            for(;r<size;r++){
                if(c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
            }
        } finally {
            if (r != size){
                System.arraycopy(elementData,r,elementData,w,size-r);
                w += size -r ;
            }
            if(w != size){
                for (int i = w;i<size;i++){
                    elementData[i] = null;

                }
                modCount += size -w;
                size = w;
                modified =true;

            }


        }
        return modified;

    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
        int expectedModCount = modCount;
        s.defaultWriteObject();
        s.writeInt(size);
        for (int i = 0; i < size; i++) {
            s.writeObject(elementData[i]);

        }

        if(modCount != expectedModCount){
            throw new ConcurrentModificationException();
        }
    }











}
