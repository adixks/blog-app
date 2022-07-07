package pl.ksiezak.adrian.java.project.blog.web;

import pl.ksiezak.adrian.java.project.blog.service.AuthorService;
import pl.ksiezak.adrian.java.project.blog.web.model.Author;

import java.util.logging.Logger;

public class AuthorController {
    private static final Logger LOGGER = Logger.getLogger(AuthorController.class.getName());

    private AuthorService authorService = new AuthorService();

    public void create(Author author){
        LOGGER.info("create(" + author + ")");
        authorService.create(author);
    }

    public void read(int id){
        LOGGER.info("read(" + id + ")");
        authorService.read(id); // wykorzystanie wzorca delegata
    }

    public void update(int id, String nick){
        LOGGER.info("update(" + id + nick + ")");
        authorService.update(id,nick);
    }

    public void delete(int id){
        LOGGER.info("delete(" + id + ")");
        authorService.delete(id);
    }
}
