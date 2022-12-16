package service;

import enums.Gender;
import model.Book;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService{
    private List<User>database=new ArrayList<>();
    @Override
    public String createUser(List<User> users) {
        database.addAll(users);
        return "Successfully created";
    }



    @Override
    public List<User> findAllUsers() {
        return database;
    }

    @Override
    public User findUserById(Long id) {
        System.out.println("By id");

        for (User a:database) {
            if(a.getId().equals(id)){
                return a;
            }

        }
      return null;
    }

    @Override
    public String removeUserByName(String name) {
        database.stream().peek(x->x.getName().equals(name));
        return "Succesfully";
    }

    @Override
    public void updateUser(Long id) {

    }

    @Override
    public void groupUsersByGender() {
        List<User> boys = database.stream().filter(x -> x.getGender().equals(Gender.MALE)).toList();
        System.out.println("~~~~~~~~~~Boys~~~~~~~~~~~~~\n"+boys);
        List<User> girls = database.stream().filter(x -> x.getGender().equals(Gender.FEMALE)).toList();
        System.out.println("~~~~~~~~~~Boys~~~~~~~~~~~~~\n"+girls);
    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Name :");
        for (User a:database) {
            if(a.getName().equals(name)){
                for (Book b:books) {
                    if(b.getName().equals(scanner.nextLine())){
                        a.getBooks().add(b);
                    }
                }
            }

        }
        return "Succesfully";
    }
}
