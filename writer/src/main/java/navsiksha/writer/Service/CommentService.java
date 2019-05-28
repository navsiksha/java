package navsiksha.writer.Service;


import navsiksha.writer.Model.Comment;
import navsiksha.writer.Model.Post;
import navsiksha.writer.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment){
        return (commentRepository.saveAndFlush(comment));
    }

    public Comment update(Comment comment, Long commentId){
        comment.setCommentId(commentId);
        return (commentRepository.saveAndFlush(comment));
    }

    public void delete(Comment comment){
        comment.setStatus(0);
        commentRepository.saveAndFlush(comment);
    }

    public Comment getByCommentId(Long commentId){
        return commentRepository.findCommentByCommentId(commentId);
    }
}
