package navsiksha.writer.Service;


import navsiksha.writer.Model.Post;
import navsiksha.writer.Model.PostStatus;
import navsiksha.writer.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post){
        if(post.getStatus() == PostStatus.draft)
            post.setStatus(PostStatus.draft);
        else
            post.setStatus(PostStatus.pending);

        return postRepository.saveAndFlush(post);
    }

    public Post update(Post post, Long postId){
        post.setPostId(postId);
        return postRepository.saveAndFlush(post);
    }

    public Post findByPostId(Long postId){
        return postRepository.findByPostId(postId);
    }
}
