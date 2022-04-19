package server.game.models;

import lombok.*;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String text;
    @Column(name = "right_answer")
    @NonNull
    private boolean rightAnswer;
    @ManyToOne()
    @JoinColumn(name = "answer_id", nullable = false)
    private Question question;
}
