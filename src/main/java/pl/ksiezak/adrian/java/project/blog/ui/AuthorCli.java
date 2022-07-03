package pl.ksiezak.adrian.java.project.blog.ui;

import pl.ksiezak.adrian.java.project.blog.repository.DatabaseUniqueIdGenerator;
import pl.ksiezak.adrian.java.project.blog.web.AuthorController;
import pl.ksiezak.adrian.java.project.blog.web.model.Author;
import pl.ksiezak.adrian.java.project.blog.web.model.builder.AuthorBuilder;

import java.util.Scanner;

public class AuthorCli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Nick: ");
        String nick = scanner.nextLine();

        Author author = new AuthorBuilder().setId(DatabaseUniqueIdGenerator.generateId()).setFirstName(firstName).setLastName(lastName).setNickName(nick).createAuthor();
        AuthorController authorController = new AuthorController();
        authorController.create(author);

    }
}