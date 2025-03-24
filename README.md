# Wayzata High School Advanced Placement Computer Science A Term 3 Project

## Overview
 - It is a very *very* basic form of skyward

### What the Program *Will* Do:

#### Student Registration & Scheduling:
- Users can add new students by providing a unique ID, name, and grade level.
- The system ensures that each student has a distinct ID to prevent duplication.
- Students can be enrolled in multiple classes, with a maximum of 8 per student to prevent schedule overload.

#### Attendance Tracking:
- The program will track each student's daily attendance.
- Attendance statuses: Present, Absent, Tardy.
- Users (teachers) will input attendance using a numerical system (e.g., 1 = Present, 2 = Absent, 3 = Tardy).

#### Grade Management:
- Teachers can assign grades to students for individual assignments.
- The system will calculate an average grade for each class and display each student's overall performance in the class.
- Grades will be stored as percentages.

#### Reporting & Display:
- A report will show all students, their classes, attendance history, and their grades.
- The system will generate class rosters and grade distributions.

### What the Program Won’t Do:
- It will not handle text input for attendance and grading (only numerical values).
- It will not allow for multiple schools; it is limited to one school.
- It will not include a graphical user interface (GUI); it will be console-based.
- It will not support online access or remote updates (local execution only).

## Types of Input:
- **Student Registration:** Name (String), ID (Integer), Grade Level (Integer).
- **Class Enrollment:** Class Name (String), Teacher Name (String), Student List (Array of IDs), etc. (more details in the design section).
- **Attendance:** 1 for Present, 2 for Absent, 3 for Tardy.
- **Grades:** Assignment name (String), Score (Integer 0-100).

## Error Checking & Handling:
- If a user enters an invalid student ID, an error message will display, prompting the user to re-enter or exit.
- If attendance is entered incorrectly (not 1, 2, or 3), an error message will be shown.
- If a grade is entered outside of 0-100, an error message will prompt re-entry.
- Duplicate student IDs will not be allowed.
- If a student tries to enroll in more than 8 classes, an error message will be shown.
