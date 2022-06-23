package pl.ksiezak.adrian.java.project.blog.main;

import pl.ksiezak.adrian.java.project.blog.web.model.Post;

import java.time.LocalDate;

public class BuilderPost {
    private int id;
    private int authorId;
    private String title;
    private String sentens;
    private LocalDate dateOfPublication;
    private LocalDate timeFromPublication;

    private BuilderPost(final Builder builder){
        this.authorId = authorId;
        this.id = id;
        this.title = title;
        this.sentens = sentens;
        dateOfPublication = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getSentens() {
        return sentens;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public static class Builder {
        private final int id;
        private int authorId;
        private String title;
        private String sentens;
        private LocalDate dateOfPublication;

        public Builder (final int id) {
            this.id = id;
        }

        public Builder authorId(final int authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }


        public Builder sentens(final String sentens){
            this.sentens = sentens;
            return this;
        }


        public Builder dateOfPublication(){
            this.dateOfPublication = LocalDate.now();
            return this;
        }

        public Post build(){
            return null;
        }
    }

    @Override
    public String toString() {
        return "BuilderPost{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", sentens='" + sentens + '\'' +
                ", dateOfPublication=" + dateOfPublication +
                ", timeFromPublication=" + timeFromPublication +
                '}';
    }
}
