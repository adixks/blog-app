package pl.ksiezak.adrian.java.project.blog.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.ksiezak.adrian.java.project.blog.repository.entity.AuthorEntity;
import pl.ksiezak.adrian.java.project.blog.web.model.Author;
import pl.ksiezak.adrian.java.project.blog.web.model.builder.AuthorBuilder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AuthorMapperTest {
private AuthorMapper authorMapper= new AuthorMapper();
    @Test
    void authorEntityFromAuthorNotNull() {
        //Given
        Author author = new AuthorBuilder().setId(1).setFirstName("Adrian").setLastName("Ksiezak").setNickName("adixks").createAuthor();

        //When
        AuthorEntity authorEntity = authorMapper.from(author);

        //Then
        Assertions.assertNotNull(authorEntity, "authorEntity is null");
    }

    @Test
    void authorEntityCorrectWithAuthorEntity1() {
        //Given
        Author author = new AuthorBuilder().setId(1).setFirstName("Adrian").setLastName("Ksiezak").setNickName("adixks").createAuthor();

//        AuthorEntity authorEntity1 = new AuthorEntity();
//        //authorEntity1.setId(1);
//        authorEntity1.setFirstName("Adrian");
//        authorEntity1.setLastName("Ksiezak");
//        authorEntity1.setNickName("adixks");
//
//        System.out.println("authorEntity1: " + authorEntity1.toString());

        //When
        AuthorEntity authorEntity = authorMapper.from(author);

        //Then
        assertAll(
                () -> assertNotNull(authorEntity, "authorEntity is null"),
//                () -> Assertions.assertEquals(author,authorEntity, "authorEntity is not equals")
                () -> Assertions.assertEquals(author.getFirstName(),authorEntity.getFirstName(),"First name is not equal.")
        );
    }
}