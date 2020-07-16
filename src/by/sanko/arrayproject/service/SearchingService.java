package by.sanko.arrayproject.service;

import by.sanko.arrayproject.entity.ArithmeticArray;
import by.sanko.arrayproject.exception.ProjectException;
import by.sanko.arrayproject.validator.ValidatorOfArithmeticArray;

import java.util.ArrayList;
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

    public ArithmeticArray findPrimeNumbers(ArithmeticArray array) throws ProjectException {
        checkArrayForPositiveSize(array);
        ArrayList<Integer> primeNumbers = new ArrayList();
        for(int i = 0; i < array.getSizeOfArray(); i++){
            if(isItPrimeNumber(array.getElement(i).getAsInt())){
                primeNumbers.add(array.getElement(i).getAsInt());
            }
        }
        ArithmeticArray arithmeticArray = new ArithmeticArray(primeNumbers);
        return arithmeticArray;
    }

    public ArithmeticArray findFibonacciNumbers(ArithmeticArray array) throws ProjectException {
        checkArrayForPositiveSize(array);
        ArrayList<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence = calculateAllFibonacciNumbers(findMaxElement(array));
        ArrayList<Integer> fibonacciNumbersInArray = new ArrayList<>();
        for(int i = 0; i < array.getSizeOfArray(); i++){
            if(fibonacciSequence.contains(array.getElement(i).getAsInt())){
                fibonacciNumbersInArray.add(array.getElement(i).getAsInt());
            }
        }
        ArithmeticArray arithmeticArray = new ArithmeticArray(fibonacciNumbersInArray);
        return arithmeticArray;
    }

    public ArithmeticArray calculateAllDifferentNumerals() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int hundreds = 1; hundreds < 10; hundreds++){
            for(int dozens = 0; dozens < 10; dozens++){
                for(int units = 0; units < 10; units++){
                    if(hundreds != dozens && dozens != units && hundreds != units){
                        int temp = hundreds * 100 + dozens * 10 + units;
                        numbers.add(temp);
                    }
                }
            }
        }
        ArithmeticArray arithmeticArray = new ArithmeticArray(numbers);
        return arithmeticArray;
    }

    private ArrayList<Integer> calculateAllFibonacciNumbers(int border) {
        ArrayList<Integer> fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0);
        fibonacciSequence.add(1);
        int currIter = 1;
        int iter = 3;
        while(currIter <= border){
            fibonacciSequence.add(currIter);
            currIter = fibonacciSequence.get(iter - 2) + fibonacciSequence.get(iter - 1);
            iter++;
        }
        return fibonacciSequence;
    }

    private boolean isItPrimeNumber(int number) {
        int root = (int) Math.sqrt(number);
        if(number < 2){
            return false;
        }
        for(int i = 2; i <= root; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    private void checkArrayForPositiveSize(ArithmeticArray array) throws ProjectException {
        ValidatorOfArithmeticArray validator = new ValidatorOfArithmeticArray();
        if(!validator.isSizePositive(array)){
            throw new ProjectException();
        }
    }

}
