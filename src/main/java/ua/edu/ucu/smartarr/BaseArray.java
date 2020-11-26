package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] data;
    private final int size;

    public BaseArray(Object[] data) {
        this.size = data.length;
        this.data = new Object[size];
        System.arraycopy(data, 0, this.data, 0, size);
    }


    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }

    @Override
    public int size() {
        return size;
    }
}
