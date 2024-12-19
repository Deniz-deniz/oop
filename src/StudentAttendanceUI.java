import javax.swing.*;
import java.awt.*;
import java.util.List;


public class StudentAttendanceUI {
    private JFrame frame;
    private AttendanceManagement<Student> attendanceManagement;

    public StudentAttendanceUI() {
        attendanceManagement = new AttendanceManagement<>();
        initializeUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentAttendanceUI::new);
    }

    private void initializeUI() {
        frame = new JFrame("Student Attendance Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(540, 350);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 5));

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);

        JButton addStudentButton = new JButton("1. Add Student");
        JButton markAttendanceButton = new JButton("2. Mark Attendance");
        JButton showAbsentButton = new JButton("3. Show Absent Students");
        JButton DeleteButton = new JButton("4. Delete Student");
        JButton updateButton = new JButton("5. Info Student");
        JButton exitButton = new JButton("6. Exit");

        addStudentButton.addActionListener(e -> addStudent(displayArea));
        markAttendanceButton.addActionListener(e -> markAttendance(displayArea));
        showAbsentButton.addActionListener(e -> showAbsentStudents(displayArea));
        DeleteButton.addActionListener(e -> deleteStudents(displayArea));
        updateButton.addActionListener(e -> displayAttendance(displayArea));
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(addStudentButton);
        panel.add(markAttendanceButton);
        panel.add(showAbsentButton);
        panel.add(DeleteButton);
        panel.add(updateButton);
        panel.add(exitButton);

        frame.add(panel, BorderLayout.WEST);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addStudent(JTextArea displayArea) {
        String firstName = JOptionPane.showInputDialog(frame, "Enter Student First Name:");
        String lastName = JOptionPane.showInputDialog(frame, "Enter Student Last Name:");
        String userID = JOptionPane.showInputDialog(frame, "Enter Student ID:");

        if (firstName != null && lastName != null && userID != null && !firstName.isEmpty() && !userID.isEmpty()) {
            Student student = new Student(firstName, lastName, userID);
            attendanceManagement.add(student);
            displayArea.append("Added Student: " + firstName + " " + lastName + " (" + userID + ")\n");
        }
    }

    private void deleteStudents(JTextArea displayArea) {
        String userID = JOptionPane.showInputDialog(frame, "Enter Student ID to Delete:");
        if (userID != null && !userID.isEmpty()) {
            Student studentToDelete = new Student("", "", userID);
            if (attendanceManagement.getAbsentStudents().contains(userID) || attendanceManagement.isPresent(userID)) {
                attendanceManagement.delete(studentToDelete);
                displayArea.append("Deleted Student with ID: " + userID + "\n");
            } else {
                displayArea.append("Student not found: " + userID + "\n");
            }
        } else {
            displayArea.append("Invalid input. Please enter a valid Student ID.\n");
        }
    }

    private void displayAttendance(JTextArea displayArea) {
        List<String> displayAttendance = attendanceManagement.getAbsentStudents();
        if (((java.util.List<?>) displayAttendance).isEmpty()) {
            displayArea.append("No absent students.\n");
        } else {
            displayArea.append("Absent Students:\n");
            for (String id : displayAttendance) {
                displayArea.append("ID: " + id + "\n");
            }
        }
    }


        private void markAttendance (JTextArea displayArea){
            String userID = JOptionPane.showInputDialog(frame, "Enter Student ID to Mark Attendance:");
            if (userID != null && !userID.isEmpty()) {
                if (attendanceManagement.isPresent(userID) || attendanceManagement.getAbsentStudents().contains(userID)) {
                    attendanceManagement.updateAttendance(new Student("", "", userID));
                    displayArea.append("Marked Attendance for ID: " + userID + "\n");
                } else {
                    displayArea.append("Student not found: " + userID + "\n");
                }
            }
        }

        private void showAbsentStudents (JTextArea displayArea){
            List<String> absentStudents = attendanceManagement.getAbsentStudents();
            if (((java.util.List<?>) absentStudents).isEmpty()) {
                displayArea.append("No absent students.\n");
            } else {
                displayArea.append("Absent Students:\n");
                for (String id : absentStudents) {
                    displayArea.append("ID: " + id + "\n");
                }
            }
        }
    }
