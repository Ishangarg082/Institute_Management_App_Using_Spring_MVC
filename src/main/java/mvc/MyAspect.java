package mvc;

import java.util.ArrayList;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Autowired
    private HibernateTemplate template;
    fileio io = new fileio();
    ArrayList<ArrayList<?>> arr = io.input();

 

    public User getUser(String userId) {
        return this.template.get(User.class, userId);
    }

    @Before("execution(* com.tut.aop.StudentDao.*(.., String)) && args(userId, ..)")
    public void auth(String userId) {
        if (arr == null || arr.isEmpty()) {
            throw new RuntimeException("Invalid credentials file");
        }

        User user = getUser((String)arr.get(0).get(0));
        System.out.println(user);
        boolean isAuthenticated = user != null && 
                                  user.getUser_id().equals((String)arr.get(0).get(0)) &&
                                  user.getPass().equals((String)arr.get(0).get(1));

        System.out.println(isAuthenticated);

        if (!isAuthenticated) {
            System.out.println("Not authorized");
            throw new RuntimeException("Authentication failed");
        } else {
            System.out.println("Auth Success");
        }
    }
}
