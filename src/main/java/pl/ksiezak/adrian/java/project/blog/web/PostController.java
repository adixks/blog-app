package pl.ksiezak.adrian.java.project.blog.web;

import pl.ksiezak.adrian.java.project.blog.service.PostService;
import pl.ksiezak.adrian.java.project.blog.web.model.Post;

public class PostController {
    private PostService postService;

    public void create(Post post){
        System.out.println("create(" + post + ")");
        postService.create(post);
    }

    public void read(int id){
        System.out.println("read(" + id + ")");
        postService.read(id);
    }

    public void update(int id, String nick){
        System.out.println("update(" + id + nick + ")");
        postService.update(id,nick);
    }

    public void delete(int id){
        System.out.println("delete(" + id + ")");
        postService.delete(id);
    }
}

