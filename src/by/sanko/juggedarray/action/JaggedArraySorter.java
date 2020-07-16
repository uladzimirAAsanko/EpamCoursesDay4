package by.sanko.juggedarray.action;

import by.sanko.juggedarray.exception.JaggedArrayException;
import by.sanko.juggedarray.validator.JaggedArrayValidator;

import java.util.Comparator;

public class JaggedArraySorter {
    public int[][] bubbleSort(int[][] array, Comparator<int[]> typeOfSorting, boolean isMaxElementFirst) throws JaggedArrayException {
        JaggedArrayValidator validator = new JaggedArrayValidator();
        if(!validator.validate(array)){
            throw new JaggedArrayException();
        }

        boolean isSorted = false;
        while(!isSorted){
            isSorted  = true;
            for(int i = 0; i < array.length - 1; i++){
                if(typeOfSorting.compare(array[i], array[i + 1]) >= 0 ^ isMaxElementFirst){
                    isSorted = false;
                    int[] tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        return array;
    }
}
