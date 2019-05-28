package navsiksha.writer.Service;


import navsiksha.writer.Model.Like;
import navsiksha.writer.Model.Post;
import navsiksha.writer.Service.PostService;
import navsiksha.writer.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostService postService;


    @Autowired
    public LikeService(LikeRepository likeRepository, PostService postService) {
        this.likeRepository = likeRepository;
        this.postService = postService;
    }

    public Boolean likeUnlike(Like like){
        long postId = like.getPostId();
        long userId = like.getUserId();
        Like existingLike = likeRepository.findByPostIdAndUserId(postId, userId);
        Post post = postService.findByPostId(postId);
        if(existingLike == null) {
            return this.saveLike(like, post);
        }
        if( existingLike.getStatus() == 0)
                return this.saveLike(existingLike, post);
        return this.saveUnlike(existingLike, post);

    }

    public Boolean saveLike(Like like, Post post){
        like.setStatus((byte)1);
        Date timestamp = new Date();
        like.setEntryTime(timestamp);
        post.setPostLikeCounter(post.getPostLikeCounter() + 1);
        postService.save(post);
        likeRepository.saveAndFlush(like);
        return  true;
    }

    public Boolean saveUnlike(Like like, Post post) {
        post.setPostLikeCounter(post.getPostLikeCounter() - 1);
        postService.save(post);
        like.setStatus((byte) 0);
        Date timestamp = new Date();
        like.setEntryTime(timestamp);
        likeRepository.saveAndFlush(like);
        return true;
    }
}
