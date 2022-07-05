package pl.ksiezak.adrian.java.project.blog.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.ksiezak.adrian.java.project.blog.web.model.Author;
import pl.ksiezak.adrian.java.project.blog.web.model.builder.AuthorBuilder;

import static org.junit.jupiter.api.Assertions.assertAll;

class AuthorDaoIntegrationTest {
    private AuthorDao authorDao = new AuthorDao();
//    int lastId = DatabaseUniqueIdGenerator.generateId() - 1;
    @Test
    void create() {
        //given
//        authorDao.create(new Author(""));
//        authorDao.create();
        Author author = new AuthorBuilder().setFirstName("Agata").setLastName("Kowalska").setNickName("aga").createAuthor();
        //when
        Author createdAuthor = authorDao.create(author);
        //then
        assertAll(
                () -> Assertions.assertNotNull(createdAuthor,"createdAuthor is null."),
                () -> Assertions.assertNotNull(createdAuthor.getId(),"createdAuthor id is null.")
        );
    }


    @Test
    void read() {
        //given

        //when
        Author createdAuthor = authorDao.create(new Author("Adam", "Kowal", "adamooo"));
        Author readAuthor = authorDao.read(createdAuthor.getId());
        //then
        Assertions.assertNotNull(readAuthor, "readAuthor is null");
    }

    @Test
    void update() {
        //given
        String lastname = "Kowal";
        //when
        Author createdAuthor = authorDao.create(new Author("Adam", "Kowalski", "adamooo"));
        Author updatedAuthor = authorDao.update(createdAuthor.getId(),lastname);
        //then
        assertAll(
                () -> Assertions.assertNotNull(updatedAuthor,"updateAuthor is null."),
                () -> Assertions.assertEquals(updatedAuthor.getLastName(),lastname,"Lastname isn't chanded")
        );
    }

}