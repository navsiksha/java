package navsiksha.writer.Repository;

import navsiksha.writer.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByUserId(Long userId, Pageable pageable);

    Page<Post> findAllByOrderByPostDateDesc(Pageable pageable);

    Post findByPostId(Long postId);
}
