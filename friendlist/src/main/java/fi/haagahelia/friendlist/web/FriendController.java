
package fi.haagahelia.friendlist.web;

import fi.haagahelia.friendlist.domain.Friend;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FriendController {
   List<Friend> myFriends = new ArrayList<>();

   public FriendController() {
      System.out.println("These are my friends");
      Friend friend1 = new Friend("Lewis", "Hamilton");
      Friend friend2 = new Friend("Alex", "Albon");
      Friend friend3 = new Friend("Kimi", "Raikkonen");
      this.myFriends.add(friend1);
      this.myFriends.add(friend2);
      this.myFriends.add(friend3);
   }

   @RequestMapping({"/hello"})
   public String showFriends(Model model) {
      model.addAttribute("myFriends", this.myFriends);
      return "friends";
   }

   @RequestMapping(
      value = {"/add"},
      method = {RequestMethod.GET}
   )
   public String showForm(Model model) {
      model.addAttribute("friend", new Friend());
      return "addFriend";
   }

   @RequestMapping(
      value = {"/add"},
      method = {RequestMethod.POST}
   )
   public String addFriend(@Valid Friend Friend, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         return "addFriend";
      } else {
         this.myFriends.add(Friend);
         return "redirect:/hello";
      }
   }
}
