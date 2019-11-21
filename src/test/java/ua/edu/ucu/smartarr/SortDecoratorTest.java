package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;

import static org.junit.Assert.*;

public class SortDecoratorTest {

    private SmartArray smartArrayInteger;

    MyComparator cmp = new MyComparator() {
        @Override
        public int compare(Object num1, Object num2) {
            return ((Integer) num1)%10 - ((Integer) num2)%10;
        }
    };


    @Before
    public void setUp() {
        Object[] arr = new Integer[]{1,2,3,-1,12,1234121};
        smartArrayInteger = new BaseArray(arr);
        smartArrayInteger = new SortDecorator(smartArrayInteger, cmp);
    }

    @Test
    public void testToArray() {
        Object[] arr = smartArrayInteger.toArray();
        assertArrayEquals(new Integer[]{-1,1,1234121,2,12,3}, arr);
    }

    @Test
    public void testOperationDescription() {
        String str = smartArrayInteger.operationDescription();
        assertEquals("SortDecorator", str);
    }

    @Test
    public void testSize() {
        int size = smartArrayInteger.size();
        assertEquals(6,size);
    }
}