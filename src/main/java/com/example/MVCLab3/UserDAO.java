package com.example.MVCLab3;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAO {
    public static final UserDAO instance = new UserDAO();
    public static final String FILE_PATH = "C:/Users/Konstantin/IdeaProjects/Lab3_MVC/src/main/java/UserInfo.txt";
    Gson gson = new Gson();

    public static UserDAO GetInstance(){
        return instance;
    }

    public void addUser(String jsonString) throws IOException {
        User newUser = gson.fromJson(jsonString,User.class);
        try(FileWriter fw = new FileWriter(FILE_PATH,true)){
            fw.write(newUser.toString());
        }
    }

    public String GetJsonString() throws IOException {
        List<String> lists = new ArrayList<>();
        Scanner sc = new Scanner(new File(FILE_PATH));
        List<User> users = new ArrayList<>();

        while (sc.hasNext()){
            lists.add(sc.nextLine());
        }

        for (String list : lists) {
            String[] elements = list.split(" ");
            users.add(new User(
                    elements[0],
                    elements[1],
                    elements[2],
                    elements[3],
                    elements[4])
            );
        }

        return gson.toJson(users);
    }
}
