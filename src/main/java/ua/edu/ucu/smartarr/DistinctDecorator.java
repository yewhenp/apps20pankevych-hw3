package ua.edu.ucu.smartarr;

import java.util.HashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] base = getSmartArray().toArray();
        Object[] result = new Object[getSmartArray().size()];
        int j = 0;
        HashSet<Object> uniqueSet = new HashSet<Object>();

        for (int i = 0; i < getSmartArray().size(); i++) {
            if (!uniqueSet.contains(base[i])) {
                uniqueSet.add(base[i]);
                result[j] = base[i];
                j++;
            }
        }
        Object[] resultShrink = new Object[j];
        System.arraycopy(result, 0, resultShrink, 0, j);
        return resultShrink;
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
