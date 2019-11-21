package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    public SortDecorator(SmartArray smartArray, MyComparator com) {
        super(smartArray);
        Object[] arr = this.smartArray.toArray();
        Arrays.sort(arr, com);
        this.smartArray = new BaseArray(arr);
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "SortDecorator";
    }

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    }
}
