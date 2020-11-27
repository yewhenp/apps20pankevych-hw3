package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    private SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public String operationDescription() {
        String[] arr = this.getClass().getName().split("\\.");
        return arr[arr.length - 1];
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    public SmartArray getSmartArray() {
        return smartArray;
    }
}
