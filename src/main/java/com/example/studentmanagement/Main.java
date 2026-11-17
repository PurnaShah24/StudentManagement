package com.example.studentmanagement;

import com.example.studentmanagement.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            choice = readInteger(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent(scanner, students);
                    break;
                case 2:
                    viewStudents(students);
                    break;
                case 3:
                    searchStudent(scanner, students);
                    break;
                case 4:
                    updateStudent(scanner, students);
                    break;
                case 5:
                    deleteStudent(scanner, students);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 6.");
            }
        }

        scanner.close();
    }

    // Read an integer without ending the program when the input is not a number.
    private static int readInteger(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    // Keep asking until the user enters a non-empty value.
    private static String readText(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static void addStudent(Scanner scanner, ArrayList<Student> students) {
        int id = readInteger(scanner, "Student ID: ");

        if (findStudentIndex(students, id) != -1) {
            System.out.println("A student with that ID already exists.");
            return;
        }

        String name = readText(scanner, "Student name: ");
        String email = readText(scanner, "Email: ");
        String course = readText(scanner, "Course: ");
        students.add(new Student(id, name, email, course));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("There are no students to display.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    private static void searchStudent(Scanner scanner, ArrayList<Student> students) {
        int id = readInteger(scanner, "Enter student ID to search: ");
        int index = findStudentIndex(students, id);

        if (index == -1) {
            System.out.println("Student not found.");
        } else {
            System.out.println(students.get(index));
        }
    }

    private static void updateStudent(Scanner scanner, ArrayList<Student> students) {
        int id = readInteger(scanner, "Enter student ID to update: ");
        int index = findStudentIndex(students, id);

        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        Student student = students.get(index);
        student.setName(readText(scanner, "New name: "));
        student.setEmail(readText(scanner, "New email: "));
        student.setCourse(readText(scanner, "New course: "));
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent(Scanner scanner, ArrayList<Student> students) {
        int id = readInteger(scanner, "Enter student ID to delete: ");
        int index = findStudentIndex(students, id);

        if (index == -1) {
            System.out.println("Student not found.");
        } else {
            students.remove(index);
            System.out.println("Student deleted successfully.");
        }
    }

    // Return the position of a student in the list, or -1 if the ID is not found.
    private static int findStudentIndex(ArrayList<Student> students, int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}