package Problem2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Student[] school1 = generateSchool(100);
        Student[] school2 = generateSchool(100);

        Student[] studentInBothSchool = Arrays.stream(school1).filter(student1 -> {
            return student1 != null && Arrays.stream(school2).anyMatch(student2 -> student2 != null && student2.equals(student1));
        }).toArray(Student[]::new);

        System.out.println("There is " + studentInBothSchool.length + " students in both school");
        Arrays.stream(studentInBothSchool).forEach(student -> {
            System.out.println(student.toString());
        });
    }

    /**
     * Generate a list of random unique students (random name and age)
     * 
     * @param numberOfStudents the number of student to generate in the array
     * @return an array of students generated randomly
     */
    private static Student[] generateSchool(int numberOfStudents) {
        if (numberOfStudents <= 0) {
            return new Student[0];
        }

        Student[] students = new Student[numberOfStudents];
        for(int i = 0; i < numberOfStudents; i++) {
            Student newStudent = null;

            // Generate a random student until it's unique in the list
            do {
                Student randomStudent = new Student(randomName(), randomAge());
                if (!Arrays.stream(students).anyMatch(student -> student != null && student.equals(randomStudent))) {
                    newStudent = randomStudent;
                }
            } while (newStudent == null); 
            
            students[i] = newStudent;
        }

        return students;
    }

    /**
     * Return a random name from a list pre-filled
     * 
     * @return a name choose randomly
     */
    private static String randomName() {
        // List of top names
        String[] names = {
            "James",
            "Robert",
            "John",
            "Michael",
            "William",
            "David",
            "Richard",
            "Joseph",
            "Thomas",
            "Charles",
            "Mary",
            "Patricia",
            "Jennifer",
            "Linda",
            "Elizabeth",
            "Barbara",
            "Susan",
            "Jessica",
            "Sarah",
            "Karen"
        };

        return names[(int)(Math.random() * names.length)];
    }

    /**
     * Generate a random age between 18 and 25
     * 
     * @return a random age
     */
    private static int randomAge() {
        int ageMax = 25;
        int ageMin = 18;
        int range =  ageMax - ageMin + 1;
        return (int)(Math.random() * range + ageMin);
    }
}
