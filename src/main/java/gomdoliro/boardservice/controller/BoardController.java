package gomdoliro.boardservice.controller;

import gomdoliro.boardservice.controller.dto.SaveBoardRequest;
import gomdoliro.boardservice.controller.dto.SaveBoardResponse;
import gomdoliro.boardservice.controller.dto.UpdateBoardRequest;
import gomdoliro.boardservice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public SaveBoardResponse save(@RequestBody SaveBoardRequest request) {
        return boardService.save(request);
    }

    @GetMapping("/board-all")
    public List<SaveBoardResponse> getAll() {
        return boardService.findAll();
    }

    @GetMapping("/board/{id}")
    public SaveBoardResponse findOne(@PathVariable Long id) {
        return boardService.findOne(id);
    }

    @PutMapping("/board")
    public SaveBoardResponse update(@RequestBody UpdateBoardRequest request) {
        return boardService.update(request);
    }

    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }
}
