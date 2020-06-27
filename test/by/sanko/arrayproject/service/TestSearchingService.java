package by.sanko.arrayproject.service;

import by.sanko.arrayproject.entity.ArithmeticArray;
import by.sanko.arrayproject.exception.ProjectException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.OptionalInt;

import static org.testng.Assert.assertEquals;

public class TestSearchingService {
    private SearchingService searchingService;
    private ArithmeticArray array;

    @BeforeTest
    public void setUp() {
        searchingService = new SearchingService();
        array = new ArithmeticArray(new int[]{1,2,3,4,5,6});
    }

    @Test
    public void testBinarySearchPositive() {
        int actual = 0;
        try {
            actual = searchingService.findElement(2,array).getAsInt();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void testBinarySearchPositiveOne() {
        int actual = 0;
        try {
            actual = searchingService.findElement(1,array).getAsInt();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testBinarySearchPositiveTwo() {
        int actual = 0;
        try {
            actual = searchingService.findElement(6,array).getAsInt();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    public void testBinarySearchPositiveThree() {
        int actual = 0;
        try {
            actual = searchingService.findElement(4,array).getAsInt();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void testBinarySearchPositiveFour() {
        int actual = 0;
        try {
            actual = searchingService.findElement(3,array).getAsInt();
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void testBinarySearchNegative() {
        OptionalInt actual = OptionalInt.empty();
        try {
            actual = searchingService.findElement(-1,array);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testFindMinimalElement(){
        int actual = 0;
        try {
            actual = searchingService.findMinimalElement(array);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testFindMaxElement(){
        int actual = 0;
        try {
            actual = searchingService.findMaxElement(array);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        int expected = 6;
        assertEquals(actual, expected);
    }
}
