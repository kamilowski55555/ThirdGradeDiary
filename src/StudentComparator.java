//import lombok.AllArgsConstructor;
//import lombok.Data;
//import java.util.Comparator;
//
//public class StudentComparator {
//    @Data
//    @AllArgsConstructor
//    public static class FirstNameComparator implements Comparator<Student> {
//        @Override
//        public int compare(Student s1, Student s2) {
//            return s1.getFirstName().compareTo(s2.getFirstName());
//        }
//    }
//
//    @Data
//    @AllArgsConstructor
//    public static class LastNameComparator implements Comparator<Student> {
//        @Override
//        public int compare(Student s1, Student s2) {
//            return s1.getLastName().compareTo(s2.getLastName());
//        }
//    }
//
//    @Data
//    @AllArgsConstructor
//    public static class PeselComparator implements Comparator<Student> {
//        @Override
//        public int compare(Student s1, Student s2) {
//            return s1.getPesel().compareTo(s2.getPesel());
//        }
//    }
//}
//


import java.util.Comparator;

public class StudentComparator {
    public static class FirstNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getFirstName().compareTo(s2.getFirstName());
        }
    }
    public static class LastNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getLastName().compareTo(s2.getLastName());
        }
    }
    public static class PeselComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getPesel().compareTo(s2.getPesel());
        }
    }

}
