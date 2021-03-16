import java.util.*;

public class ArrayFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

    private T [] list;
    private int numberOfElements;

    public ArrayFrontBackCappedList(int capacity) {
        this.list = (T[]) new Object[capacity];
        this.numberOfElements = 0;
    }

    @Override
    public boolean addFront(T newEntry) {
        if (isFull()) {
            return false;
        } else {
            for (int i = (numberOfElements - 1); i >= 0; i--) {
                list[i + 1] = list[i];
            }
            list[0] = newEntry;
            numberOfElements++;
            return true;
        }
    }

    @Override
    public boolean addBack(T newEntry) {
        if (isFull()) {
            return false;
        } else {
            list[numberOfElements] = newEntry;
            numberOfElements++;
            return true;
        }
    }

    public T removeFront() {
        T removeItem = null;
        if (!isEmpty()) {
            removeItem = list[0];
            numberOfElements--;
            for (int i = 0; i < numberOfElements; i++) {
                list[i] = list[i + 1];
            }
        }
        return removeItem;
    }

    public T removeBack() {
        T removeItem = null;
        if (!isEmpty()) {
            removeItem = list[numberOfElements - 1];
            list[numberOfElements - 1] = null;
            numberOfElements--;
        }
        return removeItem;
    }


    @Override
    public String toString() {
        String arrayString = "";
        if (!isEmpty()) {
            for (int i = 0; i < numberOfElements; i++) {
                arrayString += list[i] + " ";
            }
        }
        return "size= " + this.size() + "; " +
                "capacity= " + this.list.length + ";  " +
                "[" + arrayString + "]";
    }

    @Override
    public void clear() {
        for (int i = 0; i <= list.length - 1; i++) {
            list[i] = null;
        }
        numberOfElements = 0;
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition >= 0 && givenPosition < numberOfElements) {
            return list[givenPosition];
        } else {
            return null;
        }
    }

    @Override
    public int indexOf(T anEntry) {
        int index = 0;
        while (index < numberOfElements) {
            if (anEntry.equals(list[index])) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T anEntry) {
        int lastIndex = numberOfElements - 1;
        while (lastIndex >= 0) {
            if (list[lastIndex].equals(anEntry)) {
                return lastIndex;
            } else {
                lastIndex--;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T anEntry) {
        return (this.indexOf(anEntry) != -1);
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public boolean isFull() {
        return !isEmpty() && list.length == numberOfElements;
    }

    @Override
    public int size() {
        return this.numberOfElements;
    }
}
