package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private final MyFunction mf;

    public MapDecorator(SmartArray smartArray, MyFunction mf) {
        super(smartArray);
        this.mf = mf;
    }

    @Override
    public Object[] toArray() {
        Object[] base = getSmartArray().toArray();
        for (int i = 0; i < getSmartArray().size(); i++) {
            base[i] = mf.apply(base[i]);
        }
        return base;
    }
}
