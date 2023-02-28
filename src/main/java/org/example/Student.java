package org.example;

public class Student {
   String name;
   String surname;

   public Student(String name,String surname) {
      this.name=name;
      this.surname = surname;
   }

   public String getSurname() {
      return surname;
   }

   public String getName() {
      return name;
   }
}
