package navsiksha.writer.Model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Length(min = 5, message = "*Your title must have at least 5 characters")
    @Column(name = "post_title",columnDefinition="TEXT", nullable = false)
    private String postTitle;

    @Column(name = "post_content", columnDefinition = "TEXT")
    private String postContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "post_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date postDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_parent_type", columnDefinition="ENUM('school','graduates','jobseeker','undefined')" )
    private PostParentType postParentType;

    @NotNull(message= "*UserId cann't be empty / null")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "post_like_counter")
    private Integer postLikeCounter;

    @Column(name = "post_comment_count")
    private Integer postCommentCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status", columnDefinition="ENUM('draft','pending','reviewed','published','deleted','modified')" )
    private PostStatus status;

    @Column(name = "is_blog")
    private Boolean isBlog;

    @Column(name = "prev_post_id")
    private Long prevPostId;

    @Column(name = "next_post_id")
    private Long nextPostId;

}
