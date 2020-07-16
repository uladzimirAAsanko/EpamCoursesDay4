package by.sanko.arrayproject.reader;

import by.sanko.arrayproject.exception.ProjectException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArrayDataReader {
    private static final String DEFAULT_PATH = "input/arrayData.txt";

    public String readFileData(String filename) {
        Path path = Paths.get(DEFAULT_PATH);
        if (filename != null) {
            if (Files.exists(Paths.get(filename))) {
                path = Paths.get(filename);
            }
        }

        String answer = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String tmp = bufferedReader.readLine();
            while(tmp != null){
                answer += tmp + " ";
                tmp = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return answer;
    }

    public String readConsoleData() throws ProjectException {
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter array capacity:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int arrayCapacity = Integer.parseInt(reader.readLine());
            if (arrayCapacity >= 0) {
                System.out.println("Fill array");

                for (int i = 0; i < arrayCapacity; i++) {
                    sb.append(reader.readLine());
                    if (i < arrayCapacity - 1) {
                        sb.append(" ");
                    }
                }

                sb.append("]");
            }
        } catch (IOException e) {
            throw new ProjectException("Error while read data from console");
        }

        return sb.toString();
    }
}
