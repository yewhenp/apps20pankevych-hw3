package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public String operationDescription() {
        return "Used " + getClass().getName();
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
