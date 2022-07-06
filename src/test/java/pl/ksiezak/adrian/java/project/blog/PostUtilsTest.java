package pl.ksiezak.adrian.java.project.blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.ksiezak.adrian.java.project.blog.main.PostUtils;
import pl.ksiezak.adrian.java.project.blog.web.model.Post;
import pl.ksiezak.adrian.java.project.blog.web.model.builder.PostBuilder;

import java.time.LocalDate;

class PostUtilsTest {

    @Test
    void timeFromPublicationNotNull() {
        //Given
        Post post = new PostBuilder().setId(1).setAuthorId(2).setTitle("xxxxx").setSentence("jdhfkdabfkabfkhsdb").createPost();

        //When
        Post postWithTimeFromPublication = PostUtils.timeFromPublication(post);

        //Then
        Assertions.assertNotNull(postWithTimeFromPublication, "postWithTimeFromPublication is null");
    }

    @Test
    void timeFromPublicationCorrectTimeFromPublication() {
        //Given
        Post post = new PostBuilder().setId(1).setAuthorId(2).setTitle("xxxxx").setSentence("jdhfkdabfkabfkhsdb").createPost();
        LocalDate timeFromPublication = LocalDate.now().minusDays(post.getDateOfPublication().getDayOfYear());
        System.out.println("Time from publication: " + timeFromPublication);

        //When
        Post postWithTimeFromPublication = PostUtils.timeFromPublication(post);

        //Then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(postWithTimeFromPublication.getTimeFromPublication(), "postWithTimeFromPublication is null"),
                () -> Assertions.assertEquals(timeFromPublication, postWithTimeFromPublication.getTimeFromPublication(), "timeFromPublication is not equals")
        );
    }
}