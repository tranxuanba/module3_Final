package dao;

import model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    private String jdbcURL="jdbc:mysql://localhost:3306/caseFinal";
    private String jdbcMotorName="root";
    private String jdbcMotorPassword="Thoitran2107";
    private static final String INSERT_STUDENT_SQL="insert into (id, name, birthDay, address, phone, email, classRoom) values (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_STUDENT_BY_ID="select id, name, birthDay, address, phone, email, classRoom from students where id = ?";
    private static final String SELECT_ALL_STUDENT="select * from students";
    private static final String DELETE_STUDENT_SQL="delete from students where id= ?";
    private static final String UPDATE_STUDENT_SQL="update student set name = ?, birthDay = ?, address = ?, phone = ?, email = ?, classRoom = ? where id = ?";

    public StudentDAO() {
    }
    protected Connection getConnection(){
        Connection connection =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcMotorName, jdbcMotorPassword);
            System.out.println("ok");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return connection;
    }
//    public static void main(String[] args) {
//        StudentDAO studentDAO = new StudentDAO();
//        studentDAO.getConnection();
//    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_STUDENT_SQL);
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)){
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getBirthDay());
            preparedStatement.setString(4, student.getAdddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setString(6, student.getEmail());
            preparedStatement.setString(7, student.getClassRoom());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("loi roi");
        }
    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String birthDay = resultSet.getString("birthDay");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String classRoom = resultSet.getString("classRoom");

                student = new Student(id, name, birthDay, address, phone, email, classRoom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthDay = resultSet.getString("birthDay");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String classRoom = resultSet.getString("classRoom");

                students.add(new Student(id, name, birthDay, address, phone, email, classRoom));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL);
        preparedStatement.setInt(1, id);
        rowDeleted = preparedStatement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL);
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, String.valueOf(student.getBirthDay()));
        preparedStatement.setString(4, student.getAdddress());
        preparedStatement.setString(5, student.getPhone());
        preparedStatement.setString(6, student.getEmail());
        preparedStatement.setString(7, student.getClassRoom());

        rowUpdated = preparedStatement.executeUpdate()>0;
        return  rowUpdated;
    }
}
