package server.game.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Topic topic;
    @NonNull
    private String text;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "answers")
    private final Set<Answer> answers = new HashSet<>();
}
