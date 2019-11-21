package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseArrayTest {

    private BaseArray baseArrayExample;

    @Before
    public void setUp() {
        Object[] arr = new Integer[]{1,2,3};
        baseArrayExample = new BaseArray(arr);
    }

    @Test
    public void testToArray() {
        Object[] arr = baseArrayExample.toArray();
        assertArrayEquals(new Integer[]{1,2,3}, arr);
    }

    @Test
    public void testOperationDescription() {
        String str = baseArrayExample.operationDescription();
        assertEquals("BaseArray", str);
    }

    @Test
    public void testSize() {
        int size = baseArrayExample.size();
        assertEquals(3,size);
    }
}