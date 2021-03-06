import Entities.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        int count = 0;
        try (BufferedReader bir = new BufferedReader(new FileReader("C:/Users/duy.nguyen4_onemount/Downloads/Data1.csv"))) {
            String line = bir.readLine();
            while (line != null) {

                List<String> result = getStudentInfor(line);

                System.out.println(result);
                System.out.println(result.get(0));
                System.out.println(result.get(6));


                students.add(new Student(result.get(0).trim(), result.get(1), result.get(2), Double.parseDouble(result.get(3)), Double.parseDouble(result.get(4)), Double.parseDouble(result.get(5)), Double.parseDouble(result.get(6))));


                line = bir.readLine();

            }
            System.out.println("SHOW ALL");
            System.out.println("----------------------------------------");
            students.forEach(student -> {
                System.out.println("Nam: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("Email: " + student.getEmail());
                System.out.println("App: " + student.getApp());
                System.out.println("Bonus: " + student.getBonus());
                System.out.println("LT: " + student.getLt());
                System.out.println("Report: " + student.getReport());
                System.out.println("----------------------------------------");
            });
            System.out.println("\n\n\n");

            System.out.println("SHOW ALL");
            System.out.println("----------------------------------------");

            students.sort(Comparator.comparingDouble((Student s) -> s.getLt()));
            List<Student> top = new ArrayList<>();
            int to = Math.min(0, students.size() - 10);
            for (int i = students.size() - 1; i > to; i--) {
                top.add(students.get(i));
            }

            top.forEach(student -> {
                System.out.println("Nam: " + student.getName());
                System.out.println("ID: " + student.getId());

                System.out.println("LT: " + student.getLt());
                System.out.println("Report: " + student.getReport());
                System.out.println("----------------------------------------");
            });

            System.out.println("\n\n\n");


            students.sort(Comparator.comparingDouble((Student s) -> s.tongket()));
            List<Student> topTk = new ArrayList<>();
            int tog = Math.min(10, students.size());
            for (int i = 0; i < tog; i++) {
                topTk.add(students.get(i));
            }


            topTk.forEach(student -> {
                System.out.println("Nam: " + student.getName());
                System.out.println("ID: " + student.getId());

                System.out.println("LT: " + student.getLt());
                System.out.println("Report: " + student.getReport());
                System.out.println("Tong Ket: " + student.tongket());
                System.out.println("----------------------------------------");
            });

            students.forEach(student -> {
                System.out.println("Nam: " + student.getName());
                System.out.println("ID: " + student.getId());

                System.out.println("LT: " + student.getLt());
                System.out.println("Report: " + student.getReport());
                System.out.println("Tong Ket: " + student.tongket());
                System.out.println("----------------------------------------");
            });

            // CREATE CSV
            createCSV(students);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void createCSV(List<Student> students) {
        char CSV_SEPARATOR = ',';
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/duy.nguyen4_onemount/Downloads/my_file.csv"))) {
            students.forEach(student -> {
                try {
                    writer.append(student.getName()).append(CSV_SEPARATOR)
                            .append(student.getId()).append(CSV_SEPARATOR)
                            .append(student.getEmail()).append(CSV_SEPARATOR)
                            .append(String.format("%f", student.getBonus())).append(CSV_SEPARATOR)
                            .append(String.format("%f", student.getReport())).append(CSV_SEPARATOR)
                            .append(String.format("%f", student.getLt())).append(CSV_SEPARATOR)
                            .append(String.format("%f", student.getApp())).append(CSV_SEPARATOR)
                            .append(String.format("%f", student.tongket())).append(System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List getStudentInfor(String line) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '\"') {
                if (str.length() > 0 && stack.size() % 2 == 0)
                    str.append(ch);
                stack.push(ch);
            } else if (ch == ',' && stack.size() % 2 == 0) {
                result.add(str.toString());
                stack.clear();
                str = new StringBuilder();
            } else if (ch == ',' && stack.size() % 2 != 0) {
                str.append(ch);
            } else {
                str.append(ch);
            }
        }
        result.add(str.toString());
        return result;

    }
//Câu 2
// 1. Cho biết chuỗi regular-expression để capture được các địa chỉ gmail và
// outlook
//2. Xây dựng hàm liệt kê thông tin các sinh viên có email là gmail
//3. Chuyển thông tin các sinh viên có email là outlook (II.2) vào tập
//tin outlook.bin, sử dụng kỹ thuật Serialization.
//4. Xây dựng hàm đọc thông tin các sinh viên ở II.3 lên màn hình console

    String regex1 = "^[a-z0-9](\\.?[a-z0-9]){5,}@(gmail|outlook)\\.com$\n";

}
