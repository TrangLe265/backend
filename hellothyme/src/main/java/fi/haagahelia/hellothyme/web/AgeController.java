package fi.haagahelia.hellothyme.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgeController {
    public AgeController(){

    }

      @RequestMapping({"/hello"})
   public String checkAge(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age, Model model) {
      model.addAttribute("name", name);
      model.addAttribute("age", age);
      return "exercise2";
   }

}
