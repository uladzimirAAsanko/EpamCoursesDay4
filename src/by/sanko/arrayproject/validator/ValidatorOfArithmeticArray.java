package by.sanko.arrayproject.validator;

import by.sanko.arrayproject.entity.ArithmeticArray;

public class ValidatorOfArithmeticArray {

    public boolean isSizePositive(ArithmeticArray array){
        return array.getSizeOfArray() > 0;
    }

    public boolean validateForBinarySearch(ArithmeticArray array){
        if(array.getSizeOfArray() < 2){
            return false;
        }
        for(int i =0; i < array.getSizeOfArray()-1; i++){
            if(array.getElement(i).getAsInt() > array.getElement(i+1).getAsInt()){
                return false;
            }
        }
        return true;
    }
}
