package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate pr;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.pr = pr;
    }

    @Override
    public Object[] toArray() {
        Object[] base = smartArray.toArray();
        Object[] result = new Object[smartArray.size()];
        int j = 0;

        for (int i = 0; i < smartArray.size(); i++){
            if (pr.test(base[i])){
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
