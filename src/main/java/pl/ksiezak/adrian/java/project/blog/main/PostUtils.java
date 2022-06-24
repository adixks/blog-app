package pl.ksiezak.adrian.java.project.blog.main;

import pl.ksiezak.adrian.java.project.blog.web.model.Post;

import java.time.LocalDate;

public class PostUtils {
    public static Post timeFromPublication(Post post) {
        System.out.println("timeFromPublication(" + post + ")");

//        System.out.println("Post -> title: " + title);
//        System.out.println("contents: " + sentens);
//        System.out.println("author: " + author);

//        LocalDate currentDate = LocalDate.now();
//        Duration between = Duration.between(currentDate.atStartOfDay(), post.getDateofpublication().atStartOfDay());
//        Timer when = () -> System.out.println(between.toHours());
//        clock.currentTime(when);
//        post.setTimeFromPublication(LocalDate.from(between));

        LocalDate dateofpublication = post.getDateOfPublication();
        LocalDate timeFromPublication = LocalDate.now().minusDays(dateofpublication.getDayOfYear());
        post.setTimeFromPublication(timeFromPublication);

        System.out.println("timeFromPublication(...) = " + post);
        return post;
    }
}
