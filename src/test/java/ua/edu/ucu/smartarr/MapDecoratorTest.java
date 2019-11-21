package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyFunction;

import static org.junit.Assert.*;

public class MapDecoratorTest {

    private SmartArray smartArrayInteger;

    MyFunction func = new MyFunction() {
        @Override
        public Object apply(Object t) {
            return ((Integer) t)*((Integer) t);
        }
    };


    @Before
    public void setUp() {
        Object[] arr = new Integer[]{1,2,3,-1};
        smartArrayInteger = new BaseArray(arr);
        smartArrayInteger = new MapDecorator(smartArrayInteger, func);
    }

    @Test
    public void testToArray() {
        Object[] arr = smartArrayInteger.toArray();
        assertArrayEquals(new Integer[]{1,4,9,1}, arr);
    }

    @Test
    public void testOperationDescription() {
        String str = smartArrayInteger.operationDescription();
        assertEquals("MapDecorator", str);
    }

    @Test
    public void testSize() {
        int size = smartArrayInteger.size();
        assertEquals(4,size);
    }
}