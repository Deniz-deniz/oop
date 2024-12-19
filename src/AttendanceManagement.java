import java.util.*;
import java.util.function.Predicate;

//generic class = AttendanceManagement
class AttendanceManagement <T extends Person> implements IAttendance<T> {
    private Map<String, Boolean> attendMap = new HashMap<>();
    private Set<T> students = new HashSet<>();

    //Öğrenci bilgilerini saklamak için Set<T> kullanılıyor.


    @Override
    public void add(T entity) {
        students.add(entity);
        attendMap.put(entity.getUserID(), false);


    }

    @Override
    public void delete(T entity) {
        students.remove(entity);
        attendMap.remove(entity.getUserID(), false);


    }

    @Override
    public void update(T entity) {
        if (students.contains(entity)) {
            students.remove(entity);
            students.add(entity);

        }
    }

    @Override
    public void updateAttendance(T entity) {
        if (attendMap.containsKey(entity.getUserID())) {
            attendMap.put(entity.getUserID(), true);
        }
    }


    @Override
    public boolean isPresent(String userID) {
        return attendMap.getOrDefault(userID, false);

    }

    //List<String> kullanılarak yoklama almayan öğrencilerin ID'leri saklanıyor.
    //lambada function
    @Override
    public List<String> getAbsentStudents() {
        List<String> absentStudents = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : attendMap.entrySet()) {
            if (!entry.getValue()) {
                absentStudents.add(entry.getKey());
            }
        }
        return absentStudents;
    }

    public void displayAttendance(Predicate<Boolean> filter, Object displayAttendance) {
        attendMap.forEach((id, present) -> {
            if (filter.test(present)) {
                System.out.println("UserID: " + id + " - Present: " + present);
            }
        });

    }
}







