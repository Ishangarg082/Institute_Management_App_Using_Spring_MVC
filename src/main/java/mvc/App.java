/*
 * package mvc;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.context.ApplicationContext; import
 * org.springframework.context.support.ClassPathXmlApplicationContext;
 * 
 * public class App { StringBuffer sb = new StringBuffer(); fileio io = new
 * fileio();
 * 
 * public void process() { ApplicationContext context = new
 * ClassPathXmlApplicationContext("config.xml"); StudentDao dao =
 * context.getBean("studentDao", StudentDao.class); ArrayList<ArrayList<?>> arr
 * = io.input(); sb.append("\n"); sb.append("Starting"); sb.append("\n"); for
 * (int i = 1; i < arr.size(); i++) { Student student = new Student(); String ch
 * = (String) arr.get(i).get(0); if (ch.equals("1")) { student.setAge((String)
 * arr.get(i).get(2)); student.setRoll_number((String) arr.get(i).get(1));
 * student.setBranch((String) arr.get(i).get(3)); student.setName((String)
 * arr.get(i).get(4));
 * 
 * dao.insert(student); } else if (ch.equals("2")) { student.setAge((String)
 * arr.get(i).get(2)); student.setRoll_number((String) arr.get(i).get(1));
 * student.setBranch((String) arr.get(i).get(3)); student.setName((String)
 * arr.get(i).get(4));
 * 
 * dao.update(student); sb.append("\n"); sb.append("new data" + dao.get((String)
 * arr.get(i).get(1))); sb.append("\n"); } else if (ch.equals("3")) {
 * sb.append("\n"); sb.append("deleted" + dao.get((String) arr.get(i).get(1)));
 * sb.append("\n"); dao.delete((String) arr.get(i).get(1));
 * 
 * } else if (ch.equals("4")) { Student student1 = dao.get((String)
 * arr.get(i).get(1)); sb.append("\n"); sb.append(student1); sb.append("\n");
 * System.out.println(student1);
 * 
 * } else if (ch.equals("5")) { List<Student> list = dao.getall();
 * sb.append("\n"); for (Student st : list) { sb.append(st);
 * System.out.println(st); } sb.append("\n");
 * 
 * } else { System.out.println("Wrong Input"); } }
 * 
 * io.result(sb); } }
 */