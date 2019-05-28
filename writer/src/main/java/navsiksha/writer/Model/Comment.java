package navsiksha.writer.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @NotNull(message= "*UserId cann't be empty / null")
    @Column(name = "user_id")
    private Long userId;

    @NotNull(message= "*PostId cann't be empty / null")
    @Column(name = "post_id")
    private Long postId;

    @NotNull(message= "*Comment Text cann't be empty / null")
    @Column(name = "comment_text", columnDefinition="TEXT", nullable = false)
    private String commentText;

    @Column(name = "parent_comment_id")
    private Integer parentCommentId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "comment_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date commentDate;

    @Column(name = "status")
    private Integer status;
}
