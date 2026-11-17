package lesson.step05;

public class RelationshipDemo {
    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Classroom {
        // 필드에 학생 참조를 보관: 연관 관계
        private Student student;

        public Classroom(Student student) {
            this.student = student;
        }

        public Student getStudent() {
            return student;
        }
    }

    static class AttendancePrinter {
        // 매개변수로 전달받아 사용: 의존 관계
        public void print(Student student) {
            System.out.println("Attendance: " + student.getName());
        }
    }

    public static void main(String[] args) {
        Student student = new Student("KyungHo");
        Classroom classroom = new Classroom(student);
        AttendancePrinter printer = new AttendancePrinter();
        System.out.println("Classroom: " + classroom.getStudent().getName());
        printer.print(student);
    }
}
