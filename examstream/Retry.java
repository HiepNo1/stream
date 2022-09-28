package oop.examstream;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Retry {

    public static Map<String, List<AthenaStudent>> deviceClass(List<AthenaStudent> students) {
        return students.stream()
                .collect(Collectors.groupingBy(AthenaStudent::getIdClass));
    }

    public static Map<String, List<AthenaStudent>> maxScoreClass(List<AthenaStudent> students) {
        List<AthenaStudent> studentListMaxScore = new ArrayList<>();
        students.forEach(student -> {
            List<Double> scores = student.getScore();
            int count = 0;
            for (Double score : scores) {
                if (score < 8) {
                    break;
                } else {
                    count++;
                }
            }
            if (count > 0) {
                studentListMaxScore.add(student);
            }
        });
        return deviceClass(studentListMaxScore);
    }

    public static Map<Integer, AthenaStudent> studentLearnTwoClass (List<AthenaStudent> students) {
        Map<Integer,AthenaStudent> list = new HashMap<>();
        for (int i = 0; i  < students.size()-1; i++) {
            for (int j = i + 1; j  < students.size(); j++) {
                if (students.get(i).getId() == students.get(j).getId()) {
                    list.put(students.get(i).getId(),students.get(i));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<AthenaStudent> students = new ArrayList<AthenaStudent>() {
            {
                add(new AthenaStudent(1, "Hiep", "014334545", "JB", LocalDate.of(2001, 11, 6), List.of(9d, 9d, 9d), true));
                add(new AthenaStudent(2, "Thang", null, "JB", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), false));
                add(new AthenaStudent(3, "Thuy", "014334545", "JB", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), false));
                add(new AthenaStudent(10, "Tien", "014334545", "JSB", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), false));
                add(new AthenaStudent(5, "Nam", null, "RJ", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), true));
                add(new AthenaStudent(6, "Trung", "014334545", "RJ", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), true));
                add(new AthenaStudent(7, "Hieu", null, "JSP", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), false));
                add(new AthenaStudent(1, "Hiep", "014334545", "JSP", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), true));
                add(new AthenaStudent(9, "Dai", "014334545", "AD", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), false));
                add(new AthenaStudent(10, "Tien", "014334545", "AD", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), true));
                add(new AthenaStudent(11, "Hoang", null, "RN", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), false));
                add(new AthenaStudent(12, "Ha", "014334545", "RN", LocalDate.of(2001, 11, 6), List.of(5d, 6d, 7d), true));
            }
        };

        System.out.println("Danh sach lop cho cac hoc vien theo lop");
        //Cách 1
        Map<String, List<AthenaStudent>> className1 = students.stream()
                .collect(Collectors.groupingBy(AthenaStudent::getIdClass));
        System.out.println(className1);

        //Cách 2
        Map<String, List<AthenaStudent>> className2 = students.stream()
                .collect(Collectors.groupingBy(AthenaStudent::getIdClass,
                        HashMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));
        System.out.println(className2);

        //Cách 3
        Map<String, ArrayList<AthenaStudent>> className3 = new HashMap<>();
        students.forEach(student -> {
            ArrayList<AthenaStudent> studentArrayList = className3.get(student.getIdClass());
            if (studentArrayList == null) {
                studentArrayList = new ArrayList<AthenaStudent>() {
                    {
                        add(student);
                    }
                };
            } else {
                studentArrayList.add(student);
            }
            className3.put(student.getIdClass(), studentArrayList);
        });
        System.out.println(className3);

        //hiển thị mỗi lớp có 2 học viên
        System.out.println("-----------------------------------------------");
        System.out.println(" Danh sach hoc vien moi lop gioi han 2 hoc vien");
        Map<String, List<AthenaStudent>> newClass = new HashMap<>();
        className1.forEach((idClass, studentList) -> {
            newClass.put(idClass, studentList.stream()
                    .limit(2)
                    .collect(Collectors.toList()));
        });
        System.out.println(newClass);

        System.out.println("-----------------------------------------------");
        System.out.println(" Danh sach hoc vien theo tung lop chua nop hoc phi");
        Map<String, List<AthenaStudent>> paymentClass = new HashMap<>();
        className1.forEach((idClass, studentList) -> {
            paymentClass.put(idClass, studentList.stream()
                    .filter(student -> !student.isPaymentStatus())
                    .collect(Collectors.toList()));
        });
        System.out.println(paymentClass);

        System.out.println("-----------------------------------------------");
        System.out.println("Danh sach hoc vien theo tung lop chua cap nhat so dien thoai lien he");
        Map<String, List<AthenaStudent>> phoneClass = new HashMap<>();
        className1.forEach((idClass, studentList) -> {
            phoneClass.put(idClass, studentList.stream()
                    .filter(student -> student.getPhone() == null || student.getPhone().equals(""))
                    .collect(Collectors.toList()));
        });
        System.out.println(phoneClass);

        System.out.println("-----------------------------------------------");
        System.out.println("Danh sach hoc vien theo tung lop co thanh tich xuat sac (quy uoc diem thi cac lan > 8)");
        System.out.println(maxScoreClass(students));

        System.out.println("-----------------------------------------------");
        System.out.println("Danh sach hoc vien theo hoc 2 khoa o Athena tro len");
        System.out.println(studentLearnTwoClass(students));
    }
}
