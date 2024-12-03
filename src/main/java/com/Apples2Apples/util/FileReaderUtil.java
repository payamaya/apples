
//package com.Apples2Apples.util;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//
//public class FileReaderUtil {
//    public List<String> readFile(String filePath){
//        try {
//            return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
//        }catch (IOException e){
//            throw new RuntimeException("Failed to read file" + filePath,e);
//        }
//    }
//}

package com.Apples2Apples.util;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public static List<String> readFile(String filePath) {
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file" + filePath,e);
        }
        return content;
    }
}
