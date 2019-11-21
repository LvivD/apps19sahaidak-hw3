package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] arr;

    public BaseArray(Object[] lst) {
        this.arr = lst;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return arr.length;
    }
}
