package navsiksha.writer.Controller;


import navsiksha.writer.Model.Like;
import navsiksha.writer.Service.LikeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@RestController
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like")
    public Response likePost(@RequestBody  @Valid Like like){
        return Response.ok(likeService.likeUnlike(like)).build();
    }

}
