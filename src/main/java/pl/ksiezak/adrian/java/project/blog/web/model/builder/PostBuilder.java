package pl.ksiezak.adrian.java.project.blog.web.model.builder;

import pl.ksiezak.adrian.java.project.blog.web.model.Post;

public class PostBuilder {
    private int id;
    private int authorId;
    private String title;
    private String sentence;

    public PostBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PostBuilder setAuthorId(int authorId) {
        this.authorId = authorId;
        return this;
    }

    public PostBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder setSentence(String sentence) {
        this.sentence = sentence;
        return this;
    }

    public Post createPost() {
        return new Post(id, authorId, title, sentence);
    }
}