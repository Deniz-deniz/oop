import java.util.List;

public interface IAttendance<T> {
    void add(T entity);
    void delete(T entity);
    void update(T entity);
    void updateAttendance(T entity);
    boolean isPresent(String studentId);
    List<String> getAbsentStudents();


}
