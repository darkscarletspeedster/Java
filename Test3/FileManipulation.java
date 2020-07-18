package Test3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileManipulation {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            File file = new File("myFile.txt");
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close all open resources
            sc.close();
        }

        // using file reader and buffered reader along with try with resource syntax 
        // which automatically closes all the resources
        System.out.println("Using Buffered Reader");
        File file = new File("C:\\Users\\Anuj Agrawal\\Desktop\\testfile.txt");
        try (
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String line = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            while (line != null) {
                stringBuilder.append(line + "\n");
                line = bufferedReader.readLine();
            }
            System.out.println(stringBuilder.toString());
            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } // no finally block required as all resources are closed automatically

        // autoclosable example
        try (
            CloseExample closeExample = new CloseExample();
        ) {

        } catch (Exception e) {
            // autoclosable method close() throws normal Exception
            e.printStackTrace();
        }
    }
}

class CloseExample implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Will close the variable");
    }

}