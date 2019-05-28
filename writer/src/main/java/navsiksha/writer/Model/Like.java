package navsiksha.writer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;

    @NotNull(message= "*UserId cann't be empty / null")
    @Column(name = "user_id")
    private Long userId;

    @NotNull(message= "*PostId cann't be empty / null")
    @Column(name = "post_id")
    private Long postId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entry_time", nullable = false)
    @CreationTimestamp
    private Date entryTime;

    @Column(name = "status")
    private Byte status;

}
