package pl.ksiezak.adrian.java.project.blog.service;

import pl.ksiezak.adrian.java.project.blog.repository.PostDao;
import pl.ksiezak.adrian.java.project.blog.web.model.Post;

public class PostService {
    private PostDao postDao;

    public void create(Post post){
        System.out.println("create(" + post + ")");
        postDao.create(post);
    }

    public void read(int id){
        System.out.println("read(" + id + ")");
        postDao.read(id);
    }

    public void update(int id, String nick){
        System.out.println("update(" + id + nick + ")");
        postDao.update(id, nick);
    }

    public void delete(int id){
        System.out.println("delete(" + id + ")");
        postDao.delete(id);
    }
}
