package org.example;

import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Connection connection;
    static Statement statement;

    // main function that connects to the database using url, user, and password
    // creates an interactive user interface that allows the user to decide which function to run
    // includes basic error checking functionality
    public static void main(String[] args) {
        try{
            String url = "jdbc:postgresql://localhost:5432/A3Q1";
            String user = "postgres";
            String password = "postgres";
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            if(connection!=null){
                System.out.println("Connected to database!");
                Scanner num = new Scanner(System.in);
                System.out.println("Please input a number to run a function, \n1. getAllStudents()\n2. addStudent()\n3. updateStudentEmail()\n4. deleteStudent()\n or enter 0 to quit!\n");
                int input = num.nextInt();
                switch (input){
                    case 1:
                        getAllStudents();
                        break;
                    case 2:
                        Scanner case2 = new Scanner(System.in);
                        System.out.println("Enter first name: ");
                        String first = case2.nextLine();
                        System.out.println("Enter last name: ");
                        String last = case2.nextLine();
                        System.out.println("Enter email: ");
                        String email = case2.nextLine();
                        System.out.println("Enter date: ");
                        String date = case2.nextLine();
                        addStudent(first, last, email, date);
                        break;
                    case 3:
                        Scanner case3 = new Scanner(System.in);
                        System.out.println("Enter student's id: ");
                        int id = case3.nextInt();
                        case3.nextLine();
                        System.out.println("Enter new email: ");
                        String newEmail = case3.nextLine();
                        updateStudentEmail(id, newEmail);
                        break;
                    case 4:
                        Scanner case4 = new Scanner(System.in);
                        System.out.println("Enter student's id: ");
                        int idDel = case4.nextInt();
                        deleteStudent(idDel);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Please enter a number between 1-4!");
                }
            }
            else{
                System.out.println("Failed to connect to database");
            }
        } catch (Exception e){}
    }
    // Retrieves and displays all records from the students table
    public static void getAllStudents(){
        try{
            statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String enrollment_date = resultSet.getString("enrollment_date");
                System.out.printf("%-10d %-10s %-10s %-30s %-10s\n", id, firstName, lastName, email, enrollment_date);
            }
        }
        catch (Exception e){}
    }
    // Inserts a new student record into the students table
    public static void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        try {
            statement = connection.createStatement();
            String sql = String.format("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('%s', '%s', '%s', '%s')", first_name, last_name, email, enrollment_date);
            statement.executeUpdate(sql);
            System.out.println("Added student to database!");
        } catch (Exception e) {}
    }
    // Updates the email address for a student with the specified student_id
    public static void updateStudentEmail(int student_id, String new_email){
        try{
            statement = connection.createStatement();
            String sql = String.format("UPDATE students SET email = '%s' WHERE student_id = %d;", new_email, student_id);
            statement.executeUpdate(sql);
            System.out.println("Updated student's email!");
        }
        catch(Exception e){}
    }
    // Deletes the record of the student with the specified student_id
    public static void deleteStudent(int student_id) {
        try{
            statement = connection.createStatement();
            String sql = String.format("DELETE FROM students WHERE student_id = %d;", student_id);
            statement.executeUpdate(sql);
            System.out.println("Deleted student!");
        }
        catch(Exception e){}
    }
}