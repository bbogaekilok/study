package com.hecto.hectobackend.controller;

import com.hecto.hectobackend.domain.PageInfo;
import com.hecto.hectobackend.dto.BoardDTO;
import com.hecto.hectobackend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글을 등록한다.
    @PostMapping("/save")
    public ResponseEntity<BoardDTO> save(@RequestBody BoardDTO boardDTO) {
        BoardDTO savedBoard = boardService.save(boardDTO);
        return new ResponseEntity<>(savedBoard, HttpStatus.CREATED);
    }

    // 게시글을 모두 조회한다.
    @GetMapping
    public PageInfo<BoardDTO> findAll(@RequestParam(defaultValue = "1") int pageIndex,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        return boardService.findAll(pageIndex, pageSize);
    }

//    @GetMapping
//    public ResponseEntity<List<BoardDTO>> findAll(@RequestParam(defaultValue = "1") int pageIndex,
//                                                    @RequestParam(defaultValue = "10") int pageSize) {
//        List<BoardDTO> boardList = boardService.findAll(pageIndex, pageSize);
//        return ResponseEntity.ok(boardList);
//    }

    // 해당 Id 게시글을 조회한다.
    @GetMapping("{id}")
    public ResponseEntity<BoardDTO> getEmployeeById(@PathVariable("id") Long boardId){
        BoardDTO boardDTO = boardService.getBoardById(boardId);
        return ResponseEntity.ok(boardDTO);
    }

    // 해당 Id 게시글을 수정한다.
    @PutMapping("{id}")
    public ResponseEntity<BoardDTO> updateEmployee(@PathVariable("id") Long boardId,
                                                   @RequestBody BoardDTO updatedBoard){
        BoardDTO boardDTO = boardService.updateBoard(boardId, updatedBoard);
        return ResponseEntity.ok(boardDTO);
    }

    // URL로 수정하기
    @PutMapping("{id}/{boardTitle}/{boardContents}")
    public ResponseEntity<BoardDTO> updateEmployee(@PathVariable("id") Long boardId,
                                                   @PathVariable("boardTitle") String boardTitle,
                                                   @PathVariable("boardContents") String boardContents){
        BoardDTO updatedBoard = new BoardDTO();
        updatedBoard.setBoardTitle(boardTitle);
        updatedBoard.setBoardContents(boardContents);

        BoardDTO boardDTO = boardService.updateBoard(boardId, updatedBoard);
        return ResponseEntity.ok(boardDTO);
    }

    // 해당 Id 게시글을 삭제한다.
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long boardId){
        boardService.deleteById(boardId);
        return ResponseEntity.ok("delete success!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> urlDeleteById(@PathVariable("id") Long boardId){
        boardService.deleteById(boardId);
        return ResponseEntity.ok("delete success!");
    }


}
