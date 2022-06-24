package pl.ksiezak.adrian.java.project.blog.main;

import pl.ksiezak.adrian.java.project.blog.web.model.Post;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PostFromFiles {
    public static void file(String fileName){
        File file1 = new File("plik.txt");

        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(fileName));

        } catch (IOException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(lines.get(0));
        int authorId = Integer.parseInt(lines.get(1));
        String title = lines.get(1);
        lines.remove(0);
        lines.remove(0);
        lines.remove(0);
        Post builderPost = new BuilderPost.Builder(id)
                .authorId(authorId)
                .title(title)
                .sentens(lines.toString())
                .dateOfPublication()
                .build();
    }
}
