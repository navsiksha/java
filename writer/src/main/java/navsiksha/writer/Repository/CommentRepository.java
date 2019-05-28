package navsiksha.writer.Repository;

import navsiksha.writer.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
 public Comment findCommentByCommentId(Long commentId);
}
