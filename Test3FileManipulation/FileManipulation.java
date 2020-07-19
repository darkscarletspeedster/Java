package Test3FileManipulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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


        // reading excel files
        File excFile = new File("testExcelFile.csv");
        try (
            BufferedReader bufferedReader = new BufferedReader(new FileReader(excFile))
        ){
            ArrayList<String> headers = new ArrayList<>();
            HashMap<String, Integer> headerSpaces = new HashMap<>();
            ArrayList<ExcelData> datas = new ArrayList<>();
            String line = bufferedReader.readLine();
            headers.addAll(Arrays.asList(line.split(",")));

            while ((line = bufferedReader.readLine()) != null) {
                String arr[] = line.split(",");
                datas.add(new ExcelData(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3].charAt(0)));
            }
            for (String header : headers) {
                System.out.print(header + "     ");
                headerSpaces.put(header, header.length() + 5);
            }
            System.out.println("");
            for (ExcelData data : datas) {
                System.out.println(data.getSerialNum() + addSpaces(String.valueOf(data.getSerialNum()).length(), headerSpaces.get(headers.get(0))) +
                data.getName() + addSpaces(data.getName().length(), headerSpaces.get(headers.get(1))) + 
                data.getAge() + addSpaces(String.valueOf(data.getAge()).length(), headerSpaces.get(headers.get(2))) + 
                data.getGender());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String addSpaces(int i, int j) {
        if (j <= i) {
            return " ";
        }
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < j - i; k++) {
            builder.append(" ");
        }
        return builder.toString();
    }
}

class ExcelData {
    private int serialNum;
    private String name;
    private int age;
    private GenderType gender;

    public ExcelData (int serialNum, String name, int age, char gender) {
        this.serialNum = serialNum;
        this.name = name;
        this.age = age;
        this.gender = (gender == 'M') ? GenderType.MALE : (gender == 'F') ? GenderType.FEMALE : GenderType.OTHER;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return (gender == GenderType.MALE) ? 'M' : (gender == GenderType.FEMALE) ? 'F' : 'O';
    }

    public int getSerialNum () {
        return serialNum;
    }

    private enum GenderType {
        MALE,
        FEMALE,
        OTHER;
    }
}

class CloseExample implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Will close the variable");
    }
}