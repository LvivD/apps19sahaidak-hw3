package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyPredicate;

import static org.junit.Assert.*;

public class FilterDecoratorTest {

    private SmartArray smartArrayInteger;

    MyPredicate pr = new MyPredicate() {
        @Override
        public boolean test(Object t) {
            return ((Integer) t) >= 2 && ((Integer) t) <= 4;
        }
    };


    @Before
    public void setUp() {
        Object[] arr = new Integer[]{1,2,3,4,2,3,1,10,5,-1};
        smartArrayInteger = new BaseArray(arr);
        smartArrayInteger = new FilterDecorator(smartArrayInteger, pr);
    }

    @Test
    public void testToArray() {
        Object[] arr = smartArrayInteger.toArray();
        assertArrayEquals(new Integer[]{2,3,4,2,3}, arr);
    }

    @Test
    public void testOperationDescription() {
        String str = smartArrayInteger.operationDescription();
        assertEquals("FilterDecorator", str);
    }

    @Test
    public void testSize() {
        int size = smartArrayInteger.size();
        assertEquals(5,size);
    }
}