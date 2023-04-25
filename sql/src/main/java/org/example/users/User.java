package org.example.users;


import org.example.connecting.Connecting;
import org.example.tool.Column;
import org.example.tool.Table;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;

@Table(name = "user")
public class User extends Connecting {
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "age")
    private Integer age;

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    void setAge(Integer age) {
        this.age = age;
    }

    public User() {

    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id + '\'' +
                ", firstname=" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public void mapping(Object entity, Connecting processing) throws IllegalAccessException, SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Statement state = processing.connect();
        Class<? extends  Object> clazz = entity.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();

        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    String id = i.getName();
                    stringBuilder.append(id).append(" int primary key not null, ");
                    break;
                case "String":
                    String username = i.getName();
                    stringBuilder.append(username).append(" varchar(255) not null, ");
                    break;
                case "Integer":
                    String age = i.getName();
                    stringBuilder.append(age).append(" integer not null, ");
                    break;
            }
        }
        String createTable = "Create table " + tableName + " (" + stringBuilder.toString().substring(0, stringBuilder.length() - 2) + ")";
        System.out.printf(createTable);
        state.executeUpdate(createTable);
    }

    public void create(Object entity, Connecting processing) throws IllegalAccessException, SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Statement state = processing.connect();
        Class<? extends Object> clazz = entity.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();
        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    Long id = (Long) i.get(entity);
                    stringBuilder.append(id).append(", ");
                    break;
                case "String":
                    String username = (String) i.get(entity);
                    stringBuilder.append(username).append(", ");
                    break;
                case "Integer":
                    Integer age = (Integer) i.get(entity);
                    stringBuilder.append(age).append(", ");
                    break;
            }
        }
        String columm = "insert into "+ tableName + stringBuilder.toString().substring(0, stringBuilder.length() - 2) + ")";
        System.out.printf(columm);
        state.executeUpdate(columm);
    }


    public void select(Object entity, Connecting processing) throws IllegalAccessException, SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Statement state = processing.connect();
        Class<? extends  Object> clazz = entity.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();

        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    String id = i.getName();
                    stringBuilder.append(id).append(", ");
                    break;
                case "String":
                    String username = i.getName();
                    stringBuilder.append(username).append(", ");
                    break;
                case "Integer":
                    String age = i.getName();
                    stringBuilder.append(age).append(", ");
                    break;
            }
        }
        String insert = "select " + stringBuilder.toString().substring(0, stringBuilder.length() -2) + " FROM " + tableName;
        System.out.printf(insert);
        state.execute(insert);
    }
    public void delete(Object entity, Connecting processing) throws SQLException, ClassNotFoundException {
        Class<? extends Object> clazz = entity.getClass();
        Statement state = processing.connect();

        String tableName = clazz.getAnnotation(Table.class).name();
        String deleteTable = " delete " + " From " + tableName;
        System.out.printf(deleteTable);
        state.executeUpdate(deleteTable);
    }
    public void insert(Object entity, Connecting processing) throws IllegalAccessException, SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Statement state = processing.connect();
        Class<? extends  Object> clazz = entity.getClass();
                String tableName = clazz.getAnnotation(Table.class).name();

                for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    Long id = (Long) i.get(entity);
                    stringBuilder.append(id).append(", ");
                    break;
                case "String":
                    String username = (String) i.get(entity);
                    stringBuilder.append(username).append(", ");
                    break;
                case "Integer":
                    Integer age = (Integer) i.get(entity);
                    stringBuilder.append(age).append(", ");
                    break;
            }
        }
        String insertTable = "Insert into " + tableName + " values(" + stringBuilder.toString().substring(0, stringBuilder.length() - 2) + ")";
        System.out.printf(insertTable);
        state.executeUpdate(insertTable);
    }
    public void update(Object entity, Connecting processing) throws IllegalAccessException, SQLException, ClassNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Statement state = processing.connect();
        Class<? extends  Object> clazz = entity.getClass();
        String tableName = clazz.getAnnotation(Table.class).name();

        for (Field i : clazz.getDeclaredFields()) {
            i.setAccessible(true);
            switch (i.getType().getSimpleName()) {
                case "Long":
                    String setId = i.getName();
                    Long id = (Long) i.get(entity);
                    stringBuilder.append(setId).append("=").append(id + ", ");
                    break;
                case "String":
                    String setUsername = i.getName();
                    String username = (String) i.get(entity);
                    stringBuilder.append(setUsername).append("=").append(username + ", ");
                    break;
                case "Integer":
                    String setAge = i.getName();
                    Integer age = (Integer) i.get(entity);
                    stringBuilder.append(setAge).append("=").append(age + ", ");
                    break;
            }
        }
        String updateTable = "update " + tableName + " set " + stringBuilder.toString().substring(0, stringBuilder.length() - 2);
        System.out.printf(updateTable);
        state.executeUpdate(updateTable);
    }



}