package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testSomething() {
        BaseArray a = new BaseArray(new Integer[]{1,2,3,4,5});
        MapDecorator b = new MapDecorator(a,x->(Integer)x*(Integer)x);
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));
        a.setValue(0); // що це працювало додайте метод setValue(int index){array[index] = 0};
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));
    }
}