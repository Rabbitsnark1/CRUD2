package org.example;

import org.example.connecting.Connecting;
import org.example.users.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        User users = new User(1L, "'Polyakov'", 19);
        Connecting connecting = new Connecting();
        User crud = new User();

        connecting.connect();
        System.out.printf("Выберите операцию: \n 1) создать, 2) Запись, 3) Вывести, 4) Изменить, 5) Удалить");
        Integer input = scanner.nextInt();

        if (input == 1) {
            crud.mapping(users, connecting);
        }
        if (input == 2) {
            crud.insert(users, connecting);
        }
        if (input == 3) {
            crud.select(users, connecting);
        }
        if (input == 4) {
            crud.update(users, connecting);
        }
        if (input == 5) {
            crud.delete(users, connecting);
        }
    }
}
//
//    private Object obj;
//
//    Main()
//    {
//
//        class Arr {
//        };
//
//        obj = new Arr();
//    }

//    {
//        Main t = new Main();
//
//        Class myClass = t.obj.getClass();
//
//        String userName = "tool";
//
//        try {
//
//            System.out.println(
//                    userName + " Field  "
//                            + myClass.getField(userName));
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }
//