import com.nianxi.service.StudentService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jie.
 * @description: TODO
 * @date 2024/11/4
 * @version: 1.0
 */
public class Main {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = context.getBean(StudentService.class);
        studentService.queryStudent("20241127");
        context.close();
    }
}
