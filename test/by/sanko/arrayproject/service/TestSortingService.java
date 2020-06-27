package by.sanko.arrayproject.service;

import by.sanko.arrayproject.entity.ArithmeticArray;
import by.sanko.arrayproject.exception.ProjectException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSortingService {
    private SortingService sortingService;
    private ArithmeticArray array;

    @BeforeTest
    public void setUp() {
        sortingService = new SortingService();
        array = new ArithmeticArray(new int[]{6, 2, 1,4,3,5});
    }

    @Test
    public void testBubbleSortingPositive() {
        ArithmeticArray actual = new ArithmeticArray();
        ArithmeticArray expected = new ArithmeticArray(new int[]{1,2,3,4,5,6});
        try {
            actual = sortingService.bubbleSorting(array);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }

    @Test
    public void testShuttleSortPositive() {
        ArithmeticArray actual = new ArithmeticArray();
        ArithmeticArray expected = new ArithmeticArray(new int[]{1,2,3,4,5,6});
        try {
            actual = sortingService.shuttleSort(array);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }

    @Test
    public void testSelectionSortPositive() {
        ArithmeticArray actual = new ArithmeticArray();
        ArithmeticArray expected = new ArithmeticArray(new int[]{1,2,3,4,5,6});
        try {
            actual = sortingService.selectionSort(array);
        } catch (ProjectException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }
}
