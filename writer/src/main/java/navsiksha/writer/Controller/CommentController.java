package navsiksha.writer.Controller;

import navsiksha.writer.Model.Comment;
import navsiksha.writer.Model.Post;
import navsiksha.writer.Service.CommentService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public Response save(@RequestBody @Valid Comment comment, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.status(javax.ws.rs.core.Response.Status.BAD_REQUEST).build() ;
        } else {
            return Response.ok(commentService.save(comment)).build();
        }
    }

    @PutMapping("/comment/{id}")
    public Response update(@RequestBody @Valid Comment comment, @PathVariable("id") Long commentId, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return Response.status(Response.Status.BAD_REQUEST).build() ;
        } else {
            return Response.ok(commentService.update(comment, commentId)).build();
        }
    }

    @DeleteMapping("/comment/{id}")
    public Response delete(@RequestBody @PathVariable("id") Long commentId){
            Comment comment = commentService.getByCommentId(commentId);
            commentService.delete(comment);
            return Response.ok("Comment Deleted Successfully .").build();

    }
}
