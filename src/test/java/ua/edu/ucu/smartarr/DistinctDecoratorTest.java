package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctDecoratorTest {
    
    private SmartArray smartArrayInteger;
    
    @Before
    public void setUp() {
        Object[] arr = new Integer[]{1,2,3,4,2,3,1};
        smartArrayInteger = new BaseArray(arr);
        smartArrayInteger = new DistinctDecorator(smartArrayInteger);
    }

    @Test
    public void testToArray() {
        Object[] arr = smartArrayInteger.toArray();
        assertArrayEquals(new Integer[]{1,2,3,4}, arr);
    }

    @Test
    public void testOperationDescription() {
        String str = smartArrayInteger.operationDescription();
        assertEquals("DistinctDecorator", str);
    }

    @Test
    public void testSize() {
        int size = smartArrayInteger.size();
        assertEquals(4,size);
    }
}