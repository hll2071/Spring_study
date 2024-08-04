package gomdoliro.boardservice.service;

import gomdoliro.boardservice.controller.dto.SaveBoardRequest;
import gomdoliro.boardservice.controller.dto.SaveBoardResponse;
import gomdoliro.boardservice.controller.dto.UpdateBoardRequest;
import gomdoliro.boardservice.domain.Board;
import gomdoliro.boardservice.domain.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public SaveBoardResponse save(SaveBoardRequest request) {
        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        Board save = boardRepository.save(board);

        return new SaveBoardResponse(save);
    }

    public List<SaveBoardResponse> findAll() {
        return boardRepository.findAll().stream()
                .map(SaveBoardResponse::new)
                .toList();
    }

    public SaveBoardResponse findOne(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        return new SaveBoardResponse(board);
    }

    @Transactional
    public SaveBoardResponse update(UpdateBoardRequest request) {
        Board board = boardRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        board.update(request.getTitle(), request.getContent());
        return new SaveBoardResponse(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
