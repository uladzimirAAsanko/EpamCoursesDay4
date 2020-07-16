package by.sanko.arrayproject.parser;

import by.sanko.arrayproject.entity.ArithmeticArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArrayDataParser {
    public ArithmeticArray parseString(String data) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(data);
        int countOfTokens = tokenizer.countTokens();
        for(int i = 0; i < countOfTokens; i++){
            try{
                int tmp = Integer.parseInt(tokenizer.nextToken());
                arrayList.add(tmp);
            }catch (NumberFormatException e){

            }
        }
        return new ArithmeticArray(arrayList);
    }
}
