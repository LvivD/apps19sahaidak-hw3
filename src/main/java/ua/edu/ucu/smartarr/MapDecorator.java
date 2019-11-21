package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray smartArray, MyFunction funk) {
        super(smartArray);
        Object[] arr = this.smartArray.toArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = funk.apply(arr[i]);
        }
        this.smartArray = new BaseArray(arr);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "MapDecorator";
    }

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    }
}
