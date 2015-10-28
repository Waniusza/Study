
import com.gut.waniusza.semestr_5.progWspol.colloquium_2.Teacher;
import java.util.ArrayList;
import java.util.List;

public class University {

    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<Teacher>() {
            {
                add(new Teacher());
                add(new Teacher());
                add(new Teacher());
                add(new Teacher());
                add(new Teacher());
            }
        };

        teachers.forEach(Teacher::start);
        teachers.forEach((teacher) -> {
            try {
                teacher.join();
            } catch (InterruptedException ex) {
            }
        });

        int sum = Teacher.getCounter();
        System.out.println("total number of students:" + sum);
    }
}
