package lesson.step07;

public class ConstructorDemo {
    static class Student {
        private String name;
        private int age;

        public Student() {
            this("Unknown", 0);
        }

        public Student(String name) {
            this(name, 0);
        }

        public Student(String name, int age) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name must not be blank.");
            }
            if (age < 0) {
                throw new IllegalArgumentException("Age must be 0 or greater.");
            }
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Student first = new Student();
        Student second = new Student("KyungHo");
        Student third = new Student("KyungHo", 20);
        System.out.println(first.getName() + " / " + first.getAge());
        System.out.println(second.getName() + " / " + second.getAge());
        System.out.println(third.getName() + " / " + third.getAge());
    }
}
