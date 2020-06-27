package by.sanko.arrayproject.service;

import by.sanko.arrayproject.entity.ArithmeticArray;
import by.sanko.arrayproject.exception.ProjectException;
import by.sanko.arrayproject.validator.ValidatorOfArithmeticArray;

import java.util.OptionalInt;

public class SearchingService {


    public OptionalInt findElement(int elementToFind, ArithmeticArray array) throws ProjectException {
        ValidatorOfArithmeticArray validator = new ValidatorOfArithmeticArray();
        if(!validator.validateForBinarySearch(array)){
            throw new ProjectException();
        }
        int rightBoarderElement = array.getSizeOfArray();
        int leftBoarderElement = 0;
        int middleElement ;
        while(leftBoarderElement <= rightBoarderElement){
            middleElement = (rightBoarderElement + leftBoarderElement) / 2;
            if( elementToFind > array.getElement(middleElement).getAsInt() ){
                leftBoarderElement = middleElement+1;
            }else{
                if(elementToFind < array.getElement(middleElement).getAsInt()){
                    rightBoarderElement = middleElement-1;
                }else{
                    return array.getElement(middleElement);
                }
            }
        }
        return OptionalInt.empty();
    }

    public int findMinimalElement(ArithmeticArray array) throws ProjectException {
        checkArrayForPositiveSize(array);
        int minimal = Integer.MAX_VALUE;
        for(int i = 0; i < array.getSizeOfArray(); i++){
            if(minimal > array.getElement(i).getAsInt()){
                minimal = array.getElement(i).getAsInt();
            }
        }
        return minimal;
    }

    public int findMaxElement(ArithmeticArray array) throws ProjectException {
        checkArrayForPositiveSize(array);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.getSizeOfArray(); i++){
            if(max < array.getElement(i).getAsInt()){
                max = array.getElement(i).getAsInt();
            }
        }
        return max;
    }

    private void checkArrayForPositiveSize(ArithmeticArray array) throws ProjectException {
        ValidatorOfArithmeticArray validator = new ValidatorOfArithmeticArray();
        if(!validator.isSizePositive(array)){
            throw new ProjectException();
        }
    }

    pri
}
