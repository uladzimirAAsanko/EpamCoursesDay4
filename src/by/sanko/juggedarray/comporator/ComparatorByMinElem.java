package by.sanko.juggedarray.comporator;

import java.util.Comparator;

public class ComparatorByMinElem implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        int firstMin = calculateMinElement(o1);
        int secondMin = calculateMinElement(o2);
        return firstMin - secondMin;
    }

    private int calculateMinElement(int[] array){
        int min = Integer.MAX_VALUE;
        for(int element: array){
            if(min > element){
                min = element;
            }
        }
        return min;
    }
}
