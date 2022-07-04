package pl.ksiezak.adrian.java.project.blog.web.model;


import java.time.LocalDate;

public class Post {
    private int id;
    private int author;
    private String title;
    private String sentence;
    private LocalDate dateOfPublication;
    private LocalDate timeFromPublication;
//    Clock clock = new Clock();

    public Post(int id, int authorId, String title, String sentence) {
        this.author = authorId;
        this.id = id;
        this.title = title;
        this.sentence = sentence;
        dateOfPublication = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public LocalDate getTimeFromPublication() {
        return timeFromPublication;
    }

    public void setTimeFromPublication(LocalDate timeFromPublication) {
        this.timeFromPublication = timeFromPublication;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", authorId=" + author +
                ", title='" + title + '\'' +
                ", sentens='" + sentence + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                ", timeFromPublication=" + timeFromPublication +
//                ", clock=" + clock +
                '}';
    }
}
