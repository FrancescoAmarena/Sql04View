package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/newdb";
        String username="developer";
        String password="passwordhere";
        Connection connection=null;


        try {
            connection= DriverManager.getConnection(url,username,password);
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE OR REPLACE VIEW italian_students AS "+"SELECT last_name,first_name "+"FROM students "+"WHERE country='Italy'");
            stmt.execute("CREATE OR REPLACE VIEW german_students AS "+"SELECT last_name,first_name "+"FROM students "+"WHERE country='Germany'");
            String query="SELECT * from italian_students";
            List<Student> italianStudent=new ArrayList<>();
            ResultSet rs= stmt.executeQuery(query);
            while (rs.next()){
                italianStudent.add(new Student(rs.getString("first_name"), rs.getString("last_name") ));
            }
            rs.close();
            for (Student it : italianStudent){
                System.out.println("Italian Students: "+it.getName()+" "+it.getSurname());
            }
            String query2="SELECT * from german_students";
            List<Student> germanStudent=new ArrayList<>();
            ResultSet rs2= stmt.executeQuery(query2);
            while (rs2.next()){
                germanStudent.add(new Student(rs2.getString("first_name"), rs2.getString("last_name") ));
            }
            rs2.close();
            for (Student ge : germanStudent){
                System.out.println("German Students: "+ge.getName()+" "+ge.getSurname());
            }







        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}