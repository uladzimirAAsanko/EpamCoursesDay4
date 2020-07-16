package by.sanko.juggedarray.comporator;

import java.util.Comparator;

public class ComparatorBySumInLine implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        int firstSum = calculateTheSum(o1);
        int secondSum = calculateTheSum(o2);
        return firstSum - secondSum;
    }

    private int calculateTheSum(int[] array){
        int sum = 0;
        for(int element: array){
            sum += element;
        }
        return sum;
    }
}
