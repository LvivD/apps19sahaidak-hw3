package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student std;

    @Before
    public void setUp() throws Exception {
        std = new Student("Name", "Surname", 100500, 15);
    }

    @Test
    public void testGetGPA() {
        double gpa = std.getGPA();
        assertEquals(100500, gpa, 0.0001);
    }

    @Test
    public void testGetYear() {
        int year = std.getYear();
        assertEquals(15, year);
    }

    @Test
    public void testGetName() {
        String name = std.getName();
        assertEquals("Name", name);
    }

    @Test
    public void testGetSurname() {
        String surname = std.getSurname();
        assertEquals("Surname", surname);
    }

    @Test
    public void testToString() {
        String str = std.toString();
        assertEquals(
                "Student{name=Name, surname=Surname, GPA=100500.0, year=15}",
                str);
    }

    @Test
    public void testEquals() {
        Student otherEquals = new Student("Name", "Surname",
                100500, 15);
        Student otherNotEquals = new Student("OtherName", "OtherSurname",
                100, 1);
        assertTrue(std.equals(otherEquals));
        assertFalse(std.equals(otherNotEquals));
    }

    @Test
    public void testEqualsNull() {
        assertFalse(std.equals(null));
    }

    @Test
    public void testEqualsOtherType() {
        assertFalse(std.equals(12));
    }

    @Test
    public void testHashCode() {
        assertEquals(-185819127, std.hashCode());
    }
}