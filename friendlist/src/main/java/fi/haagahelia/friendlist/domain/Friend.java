// Source code is decompiled from a .class file using FernFlower decompiler.
package fi.haagahelia.friendlist.domain;

import jakarta.validation.constraints.NotBlank;

public class Friend {
   private @NotBlank String firstName;
   private @NotBlank String lastName;

   public Friend() {
   }

   public Friend(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
}
