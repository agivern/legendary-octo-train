package Problem2;

public class Student {

    int age;
    String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }
    
    /**
     * Two students are equals if they have the same age and the same name
     * 
     * @param objectToCompare object to compare with the student
     * @return true if the object is equal, otherwise false
     */
    @Override
    public boolean equals(Object  objectToCompare) {
        if (this == objectToCompare) { 
            return true;
        }

        if (objectToCompare == null || this.getClass() != objectToCompare.getClass()) {
            return false; 
        }

        Student studentToCompare = (Student) objectToCompare;
        return this.age == studentToCompare.age && this.name.equals(studentToCompare.name);
    }

    public String toString() { 
        return this.name + " " + this.age;
    }
}
