class MyList<T extends Object> {

    private Object[] arr;
    private int length = 0;

    public MyList() {
        arr = new Object[10];
    }

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }
        arr = new Object[capacity];
    }

    public int size() {
        return length;
    }

    public int getCapacity() {
        return arr.length;
    }

    public void add(T data) {
        if (!(data instanceof Object)) {
            throw new ClassCastException("Type mismatch!");
        }

        if (arr.length == length) {
            Object[] tmp = new Object[length * 2];
            System.arraycopy(arr, 0, tmp, 0, length);
            arr = tmp;
        }

        arr[length++] = data;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        assertIndexInBounds(index);
        return (T) arr[index];
    }

    public void remove(int index) {
        assertIndexInBounds(index);

        Object[] tmp = new Object[arr.length];
        System.arraycopy(arr, 0, tmp, 0, index);
        System.arraycopy(arr, index + 1, tmp, index, arr.length - index - 1);
        
        length -= 1;
        arr = tmp;
    }

    public void set(int index, T data) {
        assertIndexInBounds(index);
        arr[index] = data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < length; i++) {
            stringBuilder.append(arr[i].toString());
            if (i != length - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) arr;
    }

    public void clear() {
        length = 0;
    }

    @SuppressWarnings("unchecked")
    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish > length || start > finish) {
            throw new IllegalArgumentException();
        }

        MyList<T> myList = new MyList<>(finish - start);
        for (int i = start; i < finish; i++) {
            myList.add((T) arr[i]);
        }

        return myList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    private void assertIndexInBounds(int index) {
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}