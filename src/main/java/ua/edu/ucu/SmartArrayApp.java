package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new DistinctDecorator(sa);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);

        MyPredicate ifGPAGreaterThanFourAndSecondYear = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                final int GRADE = 4;
                final int YEAR = 4;
                if (t instanceof Student) {
                    return (((Student) t).getGPA()) >= GRADE
                            && ((Student) t).getYear() == YEAR;
                }
                throw new RuntimeException();
            }
        };

        MyComparator compareSurnames = new MyComparator() {
            @Override
            public int compare(Object objOne, Object objTwo) {
                if (objOne instanceof Student && objTwo instanceof Student) {
                    return ((Student) objOne).getSurname().compareTo(
                            ((Student) objTwo).getSurname());
                }
                throw new RuntimeException();
            }
        };

        MyFunction getSurnameName = new MyFunction() {
            @Override
            public Object apply(Object t) {
                if (t instanceof Student) {
                    return ((Student) t).getSurname() + " " +  ((Student) t).getName();
                }
                throw new RuntimeException();
            }
        };


        SmartArray studentsRes = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(
                                new DistinctDecorator(
                                        new BaseArray(students)),
                                ifGPAGreaterThanFourAndSecondYear),
                        compareSurnames),
                getSurnameName);

        Object[] result = studentsRes.toArray();

        return Arrays.copyOf(result, result.length, String[].class);
    }
}
