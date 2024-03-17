Ishar Ghura - 101275072

COMP3005 - Assignment 3, Question 1

Video link: https://youtu.be/Q12TZCUX6tg

# Steps to test code:

## Database Creation

``` sql
CREATE TABLE students(
student_id SERIAL PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
enrollment_date DATE
);
```
## Initial Data Insertion
``` sql
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
```
1. Create the students table and populate it with the initial data above ^ 
2. Clone the repository or download the .zip file and unzip it
3. Open with IntelliJ
4. Setup SDK Oracle OpenJDK version 20
5. Load Maven build scripts
4. Run the program and enter a number from 1-4
   - Entering "1" runs getAllStudents()
   - Entering "2" runs addStudent()
   - Entering "3" runs updateStudentEmail()
   - Entering "4" runs deleteStudent()