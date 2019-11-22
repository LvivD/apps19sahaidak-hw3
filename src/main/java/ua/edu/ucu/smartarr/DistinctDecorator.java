package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator  {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    private Object[] arrWithoutRepeats(Object[] arr) {
        Object[] newArr = new Object[arr.length];
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean ifRepeats = false;
            for (int j = 0; j < i; j++) {
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

    @Override
    public Object[] toArray() {
        return arrWithoutRepeats(this.smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
