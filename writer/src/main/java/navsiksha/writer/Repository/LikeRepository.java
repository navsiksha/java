package navsiksha.writer.Repository;


import navsiksha.writer.Model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository <Like, Long>{
    Like findByPostIdAndUserId(long postId, long userId);

}
