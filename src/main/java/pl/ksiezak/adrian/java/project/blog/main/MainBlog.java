package pl.ksiezak.adrian.java.project.blog.main;

import pl.ksiezak.adrian.java.project.blog.repository.PostDao;

import java.util.Scanner;

public class MainBlog {

    public static void postMenu() {
        System.out.println("Choose number: ");
        System.out.println("1. Show table.");
        System.out.println("2. Create new post of blog.");
        System.out.println("3. Create new post of blog from file.");
        System.out.println("4. Read post.");
        System.out.println("5. Delete element of blog.");
        System.out.println("0. Finish.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, digit;
        PostDao postDao = new PostDao();
        postMenu();
        number = scanner.nextInt();

        switch (number) {
            case 1:
                postDao.listTryWithResources();
                break;
            case 2:
                //postDao.create();
                break;
            case 3:
                System.out.println("File name with the extension:");
                String fileName = scanner.nextLine();
                PostFromFiles.file(fileName);
                break;
            case 4:
                digit = scanner.nextInt();
                postDao.read(digit);
                break;
            case 5:
                digit = scanner.nextInt();
                postDao.delete(digit);
                break;
            case 0:
                System.out.println("Thank you for the visit.");
                break;
            default:
                System.out.println("Wrong number.");
        }
    }
}
