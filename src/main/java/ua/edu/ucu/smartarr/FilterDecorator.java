package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    private Object[] filter(Object[] arr, MyPredicate pr) {
        Object[] newArr = new Object[arr.length];
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pr.test(arr[i])) {
                newArr[n] = arr[i];
                n++;
            }
        }
        return Arrays.copyOf(newArr, n);
    }

    @Override
    public Object[] toArray() {
        return filter(this.smartArray.toArray(), this.predicate);
    }

    @Override
    public String operationDescription() {
        return "FilterDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
