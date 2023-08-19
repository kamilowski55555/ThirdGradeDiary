//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReadStudentsFromFile {
//    public static List<Student> readStudentsFromFile(String filename) throws IOException {
//        ArrayList<Student> studentDiary = new ArrayList<>();;
//
//        BufferedReader read = new BufferedReader(new FileReader(filename));
//        String line;
//        while ((line = read.readLine()) != null) {
//            String[] parts = line.split(" ");
//            if (parts.length == 5) {
//                String firstName = parts[0];
//                String lastName = parts[1];
//                String pesel = parts[2];
//                String gender = parts[3];
//                int age = Integer.parseInt(parts[4]);
//                studentDiary.add(new Student(firstName, lastName, pesel, gender, age));
//            }
//        }
//        read.close();
//
//        return studentDiary;
//    }
//}
