package mvc;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private StudentDao StudentDao;

	@Autowired
	private CourseEnrolledDao ced;

	@Autowired
	private CourseDao cd;

	@Autowired
	private AttendanceDao atdao;

	@Autowired
	private MarksDao markdao;

	@Autowired
	private FeeDao feedao;

	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	@RequestMapping("/admin")
	public String admin(Model m) {
		return "admin";
	}

	@RequestMapping(value = "/adminconsole", method = RequestMethod.POST)
	public String adminconsole(@RequestParam("userid") String userId, @RequestParam("pass") String password, Model m) {
		String viewName = "admin";
		User user = userDao.get(userId);
		List<User> users = userDao.getusers();

		if (user != null && user.getPass().equals(password) && user.getRole().equals("admin")) {
			m.addAttribute("users", users);
			viewName = "adminconsole";
		} else {
			m.addAttribute("errormessage", "Wrong Credentials");
		}

		return viewName;
	}

	@RequestMapping("/stafflogin")
	public String stafflogin(HttpServletRequest request, Model model) {
		return "stafflogin";
	}

	@RequestMapping(value = "/staffconsole", method = RequestMethod.POST)
	public String staffconsole(@RequestParam("userid") String userId, @RequestParam("pass") String password, Model m) {
		String viewName = "";

		User user = userDao.get(userId);

		if (user != null && user.getPass().equals(password)) {
			m.addAttribute("user", user);
			viewName = "staffconsole";
		} else {
			viewName = "stafflogin";
			m.addAttribute("errormessage", "Wrong Credentials");
		}

		return viewName;

	}

	@RequestMapping("/studentlogin")
	public String studentlogin(HttpServletRequest request, Model model) {
		return "studentlogin";
	}

	@RequestMapping(value = "/studentconsole", method = RequestMethod.POST)
	public String studentconsole(@RequestParam("rollnumber") String rollnumber, @RequestParam("pass") String password,
			Model m) {
		String viewName = "";

		Student student = StudentDao.get(rollnumber);
		if (student != null && student.getPass().equals(password)) {
			List<CourseEnrolled> enrolledCourses = ced.getCoursesByRollNumber(rollnumber);
			List<StudentConsoleData> scd = new ArrayList<>();

			List<Attendance> attendanceList = atdao.getbyroll(rollnumber);
			List<Marks> marks = markdao.getmarksByRollNumber(rollnumber);
			Fee fees = feedao.getbyroll(rollnumber);

			for (CourseEnrolled enrolled : enrolledCourses) {
				Course course = cd.get(enrolled.getCourseid());
				if (course != null) {
					Hibernate.initialize(course.getName());

					StudentConsoleData data = new StudentConsoleData();
					data.setCourseid(course.getCourseid());
					data.setCoursename(course.getName());

					int totalClasses = 0;
					int totalPresent = 0;

					for (Attendance attendance : attendanceList) {
						if (attendance.getCourseid().equals(course.getCourseid())) {
							totalClasses++;
							if (attendance.isPresent()) {
								totalPresent++;
							}
						}
					}

					data.setTotalclasses(totalClasses);
					data.setTotalpresent(totalPresent);

					for (Marks markiterator : marks) {
						if (markiterator.getCourseid().equals(course.getCourseid())) {
							data.setMarks(markiterator.getMarks());
						}
					}
					scd.add(data);
				}

			}

			if (fees.getPaid().equals("no")) {
				m.addAttribute("feemessage", "Kindly Pay your fees at fee counter to avoid penalties");
			}else {
				m.addAttribute("feemessage", "Sit back and relax.");
			}
			m.addAttribute("fee", fees);
			m.addAttribute("student", student);
			m.addAttribute("courseData", scd);
			viewName = "studentconsole";
		} else {
			viewName = "studentlogin";
			m.addAttribute("errormessage", "Wrong Credentials");
		}

		return viewName;
	}
	
	@RequestMapping("/courses")
	public String courses(HttpServletRequest request, Model model) {
		List<Course> course = cd.getall();
		model.addAttribute("courses", course);
		return "courses";
	}
	
	@RequestMapping("/students")
	public String students(HttpServletRequest request, Model model) {
		List<Course> course = cd.getall();
		model.addAttribute("courses", course);
		return "students";
	}
	
	@RequestMapping("/marks")
	public String marks(HttpServletRequest request, Model model) {
		List<Course> course = cd.getall();
		model.addAttribute("courses", course);
		return "marks";
	}
	
	@RequestMapping("/fees")
	public String fees(HttpServletRequest request, Model model) {
		List<Fee> fee = feedao.getall();
		List<FeeData> fees = new ArrayList<>();
		for(Fee data:fee) {
			FeeData feedata = new FeeData();
			feedata.setFees(data.getFees());
			feedata.setPaid(data.getPaid());
			feedata.setRollnumber(data.getRollnumber());
			feedata.setname(StudentDao.get(data.getRollnumber()).getName());
			feedata.setBranch(StudentDao.get(data.getRollnumber()).getBranch());
			fees.add(feedata);
		}
		model.addAttribute("fees", fees);
		return "fees";
	}
	
	@RequestMapping("/attendance")
	public String attendance(HttpServletRequest request, Model model) {
		return "attendance";
	}
	@RequestMapping("/searchbyroll")
	public String searchbyroll(HttpServletRequest request, Model model,@RequestParam("rollnumber") String rollnumber) {
		List<Attendance> att = atdao.getbyroll(rollnumber);
		model.addAttribute("attendance", att);
		return "attendance";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request	) {
		request.getSession().invalidate();
		return "logout";
	}
}
