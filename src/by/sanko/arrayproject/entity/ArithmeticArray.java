package by.sanko.arrayproject.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class ArithmeticArray {
    private static final int DEFAULT_SIZE = 10;

    private int[] array;

    public ArithmeticArray(int[] array) {
        this.array = array;
    }

    public ArithmeticArray() {
        array = new int[DEFAULT_SIZE];
    }

    public ArithmeticArray(int size) {
        if(size > 0){
            array = new int[size];
        }else{
            array = new int[DEFAULT_SIZE];
        }
    }

    public ArithmeticArray(ArrayList<Integer> arrayList) {
        array = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++){
            array[i] = arrayList.get(i);
        }
    }

    public ArithmeticArray(ArithmeticArray tmp){
        array = new int[tmp.array.length];
        for(int i = 0; i < array.length; i++){
            array[i] = tmp.array[i];
        }
    }

    public OptionalInt getElement(int index) {
        if(0 <= index && index <= array.length){
            return OptionalInt.of(array[index]);
        }
        return OptionalInt.empty();
    }

    public boolean setElement(int index, int element){
        if( array.length < index || index < 0){
            return false;
        }
        array[index] = element;
        return true;
    }

    public int[] getCopyOfArray() {
        int[] temp = new int[array.length];
        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }
        return temp;
    }

    public int getSizeOfArray(){
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArithmeticArray arithmeticArray = (ArithmeticArray) o;
        if(arithmeticArray.array.length != array.length){
            return false;
        }

        for(int i = 0; i < array.length; i++){
            if(array[i] != arithmeticArray.getElement(i).getAsInt()){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            result = 17 * result + i;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            stringBuilder.append(array[i]).append(" ");
        }
        return stringBuilder.toString();
    }
}
