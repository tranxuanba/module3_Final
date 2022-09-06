package dao;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    void insertStudent(Student student) throws SQLException;
    Student selectStudent(int id);
    List<Student> selectAllStudent();
    boolean deleteStudent(int id) throws SQLException;
    boolean updateStudent(Student student) throws SQLException;
}
