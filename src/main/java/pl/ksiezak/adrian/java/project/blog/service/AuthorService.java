package pl.ksiezak.adrian.java.project.blog.service;

import pl.ksiezak.adrian.java.project.blog.web.model.Author;
import pl.ksiezak.adrian.java.project.blog.repository.AuthorDao;

public class AuthorService {
    private AuthorDao authorDao = new AuthorDao();

    public Author create(Author author){
        System.out.println("create(" + author + ")");
        Author authorFromAuthorDao = authorDao.create(author);
        return authorFromAuthorDao;
    }

    public Author read(int id){
        System.out.println("read(" + id + ")");
        Author readAuthor = authorDao.read(id);
        return readAuthor;
    }

    public Author update(int id, String nick){
        System.out.println("update(" + id + nick + ")");
        Author updateAuthor = authorDao.update(id, nick);
        return updateAuthor;
    }

    public void delete(int id){
        System.out.println("delete(" + id + ")");
        authorDao.delete(id);
    }
}