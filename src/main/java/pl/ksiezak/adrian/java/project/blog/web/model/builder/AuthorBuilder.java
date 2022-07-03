package pl.ksiezak.adrian.java.project.blog.web.model.builder;

import pl.ksiezak.adrian.java.project.blog.web.model.Author;

public class AuthorBuilder {
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;

    public AuthorBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public AuthorBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AuthorBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AuthorBuilder setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Author createAuthor() {
        return new Author(firstName, lastName, nickName);
    }
}