package lesson.step06;

public class EncapsulationDemo {
    static class Student {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name must not be blank.");
            }
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age must be 0 or greater.");
            }
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("KyungHo");
        student.setAge(20);
        System.out.println(student.getName() + " / " + student.getAge());

        try {
            student.setAge(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Age after rejected input: " + student.getAge());
    }
}
