import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger myLogger= LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        ArrayList<Student> studentDiary = new ArrayList<>();

        // reads data from "studentsInfo.txt" and adds it to the studentDiary ArrayList,then pops it on the console
        String workingDirectory = System.getProperty("user.dir");
        String filePath = workingDirectory + "/src/studentsInfo.txt";

        BufferedReader read = new BufferedReader(new FileReader(filePath));



        String line;
        while ((line = read.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 5) {
                String firstName = parts[0];
                String lastName = parts[1];
                String pesel = parts[2];
                String gender = parts[3];
                int age = Integer.parseInt(parts[4]);
                studentDiary.add(new Student(firstName, lastName, pesel, gender, age));
            }
        }

        myLogger.info("STUDENT DIARY\n");
        //System.out.println("STUDENT DIARY\n");
        for (int i = 0; i < studentDiary.size(); i++) {
            System.out.println(studentDiary.get(i).getFirstName() + " " + studentDiary.get(i).getLastName() + " " + studentDiary.get(i).getPesel() + " " + studentDiary.get(i).getGender());

        }

        //creates new ArrayList with validated Pesel,then pops it on the console

        ArrayList<Student> studentDiaryPeselValidated = new ArrayList<>();

        System.out.println("");
        myLogger.info("STUDENT DIARY WITH PESEL VALIDATED\n");
        //System.out.println("\nSTUDENT DIARY WITH PESEL VALIDATED\n");
        for (int i = 0; i < studentDiary.size(); i++) {
            if (PeselValidator.validatePesel(studentDiary.get(i).getPesel()) == true) {
                studentDiaryPeselValidated.add(studentDiary.get(i));
            }
        }
        for (int i = 0; i < studentDiaryPeselValidated.size(); i++) {
            System.out.println(studentDiaryPeselValidated.get(i).getFirstName() + " " + studentDiaryPeselValidated.get(i).getLastName() + " " + studentDiaryPeselValidated.get(i).getPesel() + " " + studentDiaryPeselValidated.get(i).getGender());

        }


        //deletes all females, then pops it on the console

        System.out.println("");
        myLogger.info("STUDENT DIARY BOYS ONLY + THEIR AGE\n");
        //System.out.println("\nSTUDENT DIARY BOYS ONLY + THEIR AGE\n");
        ArrayList<Student> studentDiaryBoys = new ArrayList<>();
        char female = 'F';
        for (int i = 0; i < studentDiaryPeselValidated.size(); i++) {
            char myChar = studentDiaryPeselValidated.get(i).getGender().charAt(0);
            if (myChar != female) {
                studentDiaryBoys.add(studentDiaryPeselValidated.get(i));
            }
        }
        for (int i = 0; i < studentDiaryBoys.size(); i++) {
            System.out.println(studentDiaryBoys.get(i).getFirstName() + " " + studentDiaryBoys.get(i).getLastName() + " " + studentDiaryBoys.get(i).getPesel() + " " + studentDiaryBoys.get(i).getGender()+ " " + studentDiaryBoys.get(i).getAge());

        }
        System.out.println("");
        myLogger.info("STUDENT DIARY BOYS ONLY + THEIR AGE+1\n");
        //System.out.println("\nSTUDENT DIARY BOYS AND AGE+1\n");

        for (int i = 0; i < studentDiaryBoys.size(); i++) {
            studentDiaryBoys.get(i).setAge(studentDiaryBoys.get(i).getAge() + 1);
        }
        for (int i = 0; i < studentDiaryBoys.size(); i++) {
            System.out.println(studentDiaryBoys.get(i).getFirstName() + " " + studentDiaryBoys.get(i).getLastName() + " " + studentDiaryBoys.get(i).getPesel() + " " + studentDiaryBoys.get(i).getGender()+ " " + studentDiaryBoys.get(i).getAge());

        }
        System.out.println("");
        myLogger.info("STUDENT DIARY BOYS SORTED BY FIRSTNAME\n");
        //System.out.println("\nSTUDENT DIARY BOYS SORTED BY FIRSTNAME\n");
        Collections.sort(studentDiaryBoys, new StudentComparator.FirstNameComparator());

        for (int i = 0; i < studentDiaryBoys.size(); i++) {
            System.out.println(studentDiaryBoys.get(i).getFirstName() + " " + studentDiaryBoys.get(i).getLastName() + " " + studentDiaryBoys.get(i).getPesel() + " " + studentDiaryBoys.get(i).getGender()+ " " + studentDiaryBoys.get(i).getAge());

        }

        System.out.println("");
        myLogger.info("STUDENT DIARY BOYS SORTED BY LASTNAME\n");

        //System.out.println("\nSTUDENT DIARY BOYS SORTED BY LASTNAME\n");
        Collections.sort(studentDiaryBoys, new StudentComparator.LastNameComparator());

        for (int i = 0; i < studentDiaryBoys.size(); i++) {
            System.out.println(studentDiaryBoys.get(i).getFirstName() + " " + studentDiaryBoys.get(i).getLastName() + " " + studentDiaryBoys.get(i).getPesel() + " " + studentDiaryBoys.get(i).getGender()+ " " + studentDiaryBoys.get(i).getAge());

        }

        System.out.println("");
        myLogger.info("STUDENT DIARY BOYS SORTED BY PESEL\n");
        //System.out.println("\nSTUDENT DIARY BOYS SORTED BY PESEL\n");
        Collections.sort(studentDiaryBoys, new StudentComparator.PeselComparator());

        for (int i = 0; i < studentDiaryBoys.size(); i++) {
            System.out.println(studentDiaryBoys.get(i).getFirstName() + " " + studentDiaryBoys.get(i).getLastName() + " " + studentDiaryBoys.get(i).getPesel() + " " + studentDiaryBoys.get(i).getGender()+ " " + studentDiaryBoys.get(i).getAge());

        }
    }
}

