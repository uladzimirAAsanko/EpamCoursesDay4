package by.sanko.juggedarray.validator;

public class JaggedArrayValidator {
    public boolean validate(int[][] array){
        boolean isValid = true;
        if(array == null || array.length < 2){
            isValid = false;
        }else{
            for (int[] subArray : array) {
                if (subArray == null || subArray.length <= 0) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }
}
