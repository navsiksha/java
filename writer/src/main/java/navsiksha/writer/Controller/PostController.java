package navsiksha.writer.Controller;


import navsiksha.writer.Model.Post;
import navsiksha.writer.Model.PostStatus;
import navsiksha.writer.Service.PostService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/helloo")
    public String hello(){

        return "hello Shikshak";
    }

    @PostMapping("/post")
    public Response savePost(@RequestBody  @Valid Post post, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.status(Response.Status.BAD_REQUEST).build() ;
        } else {
            return Response.ok(postService.save(post)).build();
        }
    }

    @PutMapping("/post/{id}")
    public Response updatePost(@RequestBody  @Valid Post post, @PathVariable("id") Long postId, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.status(Response.Status.BAD_REQUEST).build() ;
        } else {
            return Response.ok(postService.update(post,postId)).build();
        }
    }
}
