package by.sanko.juggedarray.comporator;

import java.util.Comparator;

public class ComparatorByMaxElem implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        int firstMax = calculateMaxElement(o1);
        int secondMax = calculateMaxElement(o2);
        return firstMax - secondMax;
    }

    private int calculateMaxElement(int[] array){
        int max = Integer.MIN_VALUE;
        for(int element: array){
            if(max < element){
                max = element;
            }
        }
        return max;
    }
}
