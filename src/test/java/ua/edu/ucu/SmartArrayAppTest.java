package ua.edu.ucu;

import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import static org.junit.Assert.*;

/**
 *
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {


    @Test
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};

        Integer[] res =
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2(integers);
        Integer[] expectedRes = {2, 4, 6};
        
        assertArrayEquals(expectedRes, res);        
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
            new Student("Ivar", "Grimstad", 3.9, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Antons", "Kranga", 4.0, 2),
            new Student("Burr", "Sutter", 4.2, 2),
            new Student("Philipp", "Krenn", 4.3, 3),
            new Student("Tomasz", "Borek", 4.1, 2),
            new Student("Ittai", "Zeidman", 4.5, 1),
            new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames = 
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};

        assertArrayEquals(expectedStudentNames, studentNames);
    }

    @Test
    public void testPperationDescription(){
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (((Student) t).getYear() == 2) &&
                        (((Student) t).getGPA() >= 5);
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object first, Object second) {
                return (((Student) first).getSurname()).compareTo(
                        (((Student) second).getSurname()));
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() +
                        " " + ((Student) t).getName();
            }
        };

        SmartArray sa = new BaseArray(students);
        assertEquals(sa.operationDescription(), "BaseArray");

        sa = new DistinctDecorator(sa);
        assertEquals(sa.operationDescription(), "DistinctDecorator");
        sa = new FilterDecorator(sa, pr);
        assertEquals(sa.operationDescription(), "FilterDecorator");
        sa = new SortDecorator(sa, cmp);
        assertEquals(sa.operationDescription(), "SortDecorator");
        sa = new MapDecorator(sa, func);
        assertEquals(sa.operationDescription(), "MapDecorator");

    }

    @Test
    public void testOther(){
        SmartArrayApp app = new SmartArrayApp();
        Student stud1 = new Student("Ivar", "Grimstad", 3.9, 2);
        Student stud2 = new Student("Ivar", "Grimstad", 3.84, 2);
        Student stud3 = new Student("Ivar1", "Grimstad", 3.9, 2);
        Student stud4 = new Student("Ivar", "Grimstad1", 3.9, 2);
        Student stud5 = new Student("Ivar", "Grimstad", 3.9, 3);
        Student stud6 = new Student("Ivar", "Grimstad", 3.9, 2);
        assertEquals(stud1.toString(), "Student{name=Ivar, surname=Grimstad, GPA=3.9, year=2}");

        assertEquals(stud1, stud1);
        assertNotEquals(stud1, null);
        assertNotEquals(stud1, "null");
        assertNotEquals(stud1, stud2);
        assertNotEquals(stud1, stud3);
        assertNotEquals(stud1, stud4);
        assertNotEquals(stud1, stud5);
        assertEquals(stud1, stud6);
    }
}