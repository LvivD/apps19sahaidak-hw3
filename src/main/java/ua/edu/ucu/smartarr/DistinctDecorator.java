package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator  {

    private Object[] arrWithoutRepeats(Object[] arr) {
        Object[] newArr = new Object[arr.length];
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean ifRepeats = false;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    ifRepeats = true;
                    break;
                }
            }
            if (!ifRepeats) {
                newArr[n] = arr[i];
                n++;
            }
        }
        return Arrays.copyOf(newArr, n);
    }

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.smartArray = new BaseArray(arrWithoutRepeats(this.smartArray.toArray()));
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator";
    }

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    }
}
