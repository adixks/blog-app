package pl.ksiezak.adrian.java.project.blog.service;

import pl.ksiezak.adrian.java.project.blog.repository.AuthorDao;
import pl.ksiezak.adrian.java.project.blog.web.model.Author;

import java.util.logging.Logger;

public class AuthorService {
    private static final Logger LOGGER = Logger.getLogger(AuthorService.class.getName());

    private AuthorDao authorDao = new AuthorDao();

    public Author create(Author author){
        LOGGER.info("create(" + author + ")");
        Author authorFromAuthorDao = authorDao.create(author);
        return authorFromAuthorDao;
    }

    public Author read(int id){
        LOGGER.info("read(" + id + ")");
        Author readAuthor = authorDao.read(id);
        return readAuthor;
    }

    public Author update(int id, String nick){
        LOGGER.info("update(" + id + ", " + nick + ")");
        Author updateAuthor = authorDao.update(id, nick);
        return updateAuthor;
    }

    public void delete(int id){
        LOGGER.info("delete(" + id + ")");
        authorDao.delete(id);
    }
}