// Source code is decompiled from a .class file using FernFlower decompiler.
package fi.haagahelia.friendlist.web;

import fi.haagahelia.friendlist.domain.Friend;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddShowController {
   List<Friend> friendList = new ArrayList<>();

   public AddShowController() {
   }

   @GetMapping({"/combined"})
   public String showFriend(Model model) {
      model.addAttribute("friends", this.friendList);
      model.addAttribute("friend", new Friend());
      return "combined";
   }

   @PostMapping({"/combined"})
   public String addFriend(@Valid Friend friend, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("friends", this.friendList);
         return "/combined";
      } else {
         this.friendList.add(friend);
         return "redirect:/combined";
      }
   }
}
