package gomdoliro.boardservice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tbl_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Builder
    public Board(String title, String content) {
        this.content = content;
        this.title = title;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
