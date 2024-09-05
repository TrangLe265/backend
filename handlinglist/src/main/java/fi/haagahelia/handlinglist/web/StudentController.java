
package fi.haagahelia.handlinglist.web;

import fi.haagahelia.handlinglist.domain.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
   public StudentController() {
   }

   @RequestMapping({"/hello"})
   public String showStudent(Model model) {
      System.out.println("All the students are here!");
      Student student1 = new Student("Henry", "Golding");
      Student student2 = new Student("Sabrina", "Carpenter");
      Student student3 = new Student("Britney", "Spears");
      List<Student> students = new ArrayList();
      students.add(student1);
      students.add(student2);
      students.add(student3);
      model.addAttribute("students", students);
      return "student";
   }
}
