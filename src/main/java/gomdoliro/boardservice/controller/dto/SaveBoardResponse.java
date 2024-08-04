package gomdoliro.boardservice.controller.dto;

import gomdoliro.boardservice.domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveBoardResponse {

    private Long id;

    private String title;

    private String content;

    public SaveBoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
