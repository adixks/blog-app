package pl.ksiezak.adrian.java.project.blog.service.mapper;

import org.modelmapper.ModelMapper;
import pl.ksiezak.adrian.java.project.blog.repository.entity.AuthorEntity;
import pl.ksiezak.adrian.java.project.blog.web.model.Author;

public class AuthorMapper {

    private ModelMapper mapper = new ModelMapper();

    public AuthorEntity from(Author author){
        System.out.println("from (" + author + ")");
//        AuthorEntity authorEntity = new AuthorEntity();
//        authorEntity.setId(author.getId());
//        authorEntity.setFirstName(author.getFirstName());
//        authorEntity.setLastName(author.getLastName());
//        authorEntity.setNickName(author.getNickName());
        AuthorEntity authorEntity = mapper.map(author, AuthorEntity.class);
        System.out.println("from (...) = " + authorEntity);
        return authorEntity;
    }
    public Author from(AuthorEntity authorEntity){
        System.out.println("from (" + authorEntity + ")");
        Author author = mapper.map(authorEntity, Author.class);
        System.out.println("from (...) = " + authorEntity);
        return author;
    }
}