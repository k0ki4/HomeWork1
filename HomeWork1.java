import java.util.Objects;
import java.util.function.Function;

    public class HomeWork1 {
        public static class Student {
            private String name;
            private int grade;

            public Student(String name, int grade) {
                this.name = name;
                this.grade = grade;
            }

            public String getName() {
                return name;
            }

            public int getGrade() {
                return grade;
            }
            String announce() { return name + " учится в " + grade + "классе";}
        }

        public static class Teacher {

            public Teacher(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public Student[] getStudents() {
                return students;
            }


            private String name;
            private Student[] students = new Student[30];


            void addStudent(Student student) {
                for (int i = 0; i < this.students.length; i++) {
                    if(students[i] == null) {
                        students[i] = student;
                        break;
                    }
                }
            }
            String[] rollCall() {
                int f = 0;
                for (int i = 0; i < this.students.length; i++) {
                    if (students[i] == null) {
                        f = i;
                        break;
                    }
                }
                String[] result = new String[f];
                for (int i = 0; i < f; i++) {
                    if (students[i] != null) {
                        result[i] = students[i].announce();
                    }
                }
                return result;
            }
        }

        public static void main(String[] args) {

            var student = new Student(STUDENT_NAME, STUDENT_GRADE);
            print("Student: Студент создался", true);
            print("Student: Геттер имени", Objects.equals(student.getName(), STUDENT_NAME));
            print("Student: Геттер класса", Objects.equals(student.getGrade(), STUDENT_GRADE));
            print("Student: announce содержит имя", student.announce().contains(STUDENT_NAME));
            print("Student: announce содержит класс", student.announce().contains(STUDENT_GRADE.toString()));

            var teacher = new Teacher(TEACHER_NAME);
            print("Teacher: Уичтель создался", true);
            print("Teacher: Геттер имени", teacher.getName() == TEACHER_NAME);
            print("Teacher: Геттер студентов", teacher.getStudents() != null);
            print("Teacher: Массив учеников должен быть размером 30", teacher.getStudents().length == 30);

            teacher.addStudent(student);
            print("Teacher: Студент сохранился в массив", teacher.getStudents()[0] == student);
            String[] calls = teacher.rollCall();
            print("Teacher: Массив rollCall состоит из одиного элемента", calls.length == 1);
            print("Teacher: В строке содержится имя студента", calls[0].contains(STUDENT_NAME));
        }


        private static void print(String condition, Boolean act) {
            Function<String, String> yellow = str -> "\u001B[33m" + str + "\u001B[0m";
            System.out.print( "TEST CASE " + yellow.apply(constLen(condition, 55)));
            if (act) System.out.print("✅"); else System.out.print("❌");
            System.out.println();
        }

        private static String constLen(String str, int len) {
            StringBuilder sb = new StringBuilder(str);
            while (len-- - str.length() > 0) sb.append(" ");
            return sb.toString();
        }

        private final static String STUDENT_NAME = "NameStudent";
        private final static String TEACHER_NAME = "NameStudent";
        private final static Integer STUDENT_GRADE = 1;
    }
