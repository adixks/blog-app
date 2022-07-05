package pl.ksiezak.adrian.java.project.blog.web;

import pl.ksiezak.adrian.java.project.blog.web.model.Author;
import pl.ksiezak.adrian.java.project.blog.service.AuthorService;

public class AuthorController {
    private AuthorService authorService = new AuthorService();

    //public void create(String firstName, String lastName, String nick){
    public void create(Author author){
        System.out.println("AuthorControler create(" + author + ")");
        authorService.create(author);
    }

    public void read(int id){
        System.out.println("read(" + id + ")");
        authorService.read(id); // wykorzystanie wzorca delegata
    }

    public void update(int id, String nick){
        System.out.println("update(" + id + nick + ")");
        authorService.update(id,nick);
    }

    public void delete(int id){
        System.out.println("delete(" + id + ")");
        authorService.delete(id);
    }
}
