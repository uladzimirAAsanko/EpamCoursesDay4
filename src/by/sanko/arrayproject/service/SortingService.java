package by.sanko.arrayproject.service;

import by.sanko.arrayproject.entity.ArithmeticArray;
import by.sanko.arrayproject.exception.ProjectException;
import by.sanko.arrayproject.validator.ValidatorOfArithmeticArray;

public class SortingService {
    public ArithmeticArray bubbleSorting(ArithmeticArray array) throws ProjectException {
        checkArrayForPositiveSize(array);
        ArithmeticArray sortedArray = new ArithmeticArray(array);
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < sortedArray.getSizeOfArray()-1; i++){
                if(sortedArray.getElement(i).getAsInt() > sortedArray.getElement(i+1).getAsInt()){
                    isSorted = false;
                    swap(sortedArray, i, i+1);
                }
            }
        }
        return sortedArray;
    }

    public ArithmeticArray shuttleSort(ArithmeticArray array) throws ProjectException {
        checkArrayForPositiveSize(array);
        ArithmeticArray sortedArray = new ArithmeticArray(array);
        for(int i = 1; i < sortedArray.getSizeOfArray(); i++){
            if(sortedArray.getElement(i).getAsInt() < sortedArray.getElement(i-1).getAsInt()){
                swap(sortedArray, i, i-1);
                for(int j = i -1; j -1 >= 0; j--){
                    if(sortedArray.getElement(j).getAsInt() < sortedArray.getElement(j-1).getAsInt()){
                        swap(sortedArray, j, j-1);
                    }else {
                        break;
                    }
                }
            }
        }

        return sortedArray;
    }

    public ArithmeticArray selectionSort(ArithmeticArray array) throws ProjectException {
        checkArrayForPositiveSize(array);
        ArithmeticArray sortedArray = new ArithmeticArray(array);
        for(int i = 0; i < sortedArray.getSizeOfArray(); i++){
            int minInPart = i;
            for(int j = i; j < sortedArray.getSizeOfArray(); j++){
                if(sortedArray.getElement(j).getAsInt() < sortedArray.getElement(minInPart).getAsInt()){
                    minInPart = j;
                }
            }
            swap(sortedArray, i, minInPart);
        }
        return sortedArray;
    }

    private void swap(ArithmeticArray array, int indexFrom, int indexTo){
        int tmp = array.getElement(indexFrom).getAsInt();
        array.setElement(indexFrom, array.getElement(indexTo).getAsInt());
        array.setElement(indexTo, tmp);

    }

    private void checkArrayForPositiveSize(ArithmeticArray array) throws ProjectException {
        ValidatorOfArithmeticArray validator = new ValidatorOfArithmeticArray();
        if(!validator.isSizePositive(array)){
            throw new ProjectException();
        }
    }
}
