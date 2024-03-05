package com.hecto.hectobackend.service;

import com.hecto.hectobackend.domain.PageInfo;
import com.hecto.hectobackend.dto.BoardDTO;
import com.hecto.hectobackend.exception.ResourceNotFoundException;
import com.hecto.hectobackend.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDTO save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
        return boardDTO;
    }

    public PageInfo<BoardDTO> findAll(int pageIndex, int pageSize) {
        int totalCount = boardRepository.getTotalCount();
        HashMap<String, Integer> pageIdx = new HashMap<String, Integer>();
        pageIdx.put("limit", (pageIndex - 1) * pageSize);
        pageIdx.put("offset", pageSize);

        List<BoardDTO> boardList = boardRepository.findAll(pageIdx);
        return new PageInfo<>(pageIndex, pageSize, totalCount, boardList);
    }

//    public List<BoardDTO> findAll() {
//
//        int totalCount = boardRepository.getTotalCount();
//        List<BoardDTO> boardList = boardRepository.findAll();
//
//        return  boardList.stream()
//                .map(m -> new BoardDTO(m.getId(), m.getBoardTitle(), m.getBoardWriter(), m.getBoardContents(), m.getCreatedAt()))
//                .collect(Collectors.toList());
//    }

    public BoardDTO getBoardById(Long boardId) {
        BoardDTO boardDTO = new BoardDTO();

        //        BoardDTO boardDTO = new BoardDTO();
        try{
            boardDTO = boardRepository.findById(boardId);
        }catch (NullPointerException e){
            e.getMessage();
        }


        /*if(boardDTO.getBoardTitle().isEmpty()){
            throw new ResourceNotFoundException("존재하지 않는 게시글입니다.");
        }*/
        /*if(boardDTO == null){
            throw new ResourceNotFoundException("존재하지 않는 게시글입니다.");
        }*/
        return boardDTO;
    }

    public BoardDTO updateBoard(Long boardId, BoardDTO updatedBoard) {

        BoardDTO boardDTO = boardRepository.findById(boardId);

       /* .orElseThrow(
                () -> new ResourceNotFoundException("존재하지 않는 게시글입니다.")
        );*/

        boardDTO.setBoardTitle(updatedBoard.getBoardTitle());
        boardDTO.setBoardWriter(updatedBoard.getBoardWriter());
        boardDTO.setBoardContents(updatedBoard.getBoardContents());

        boardRepository.update(boardDTO);

        return boardDTO;
    }

    public void deleteById(Long boardId) {
        BoardDTO boardDTO = boardRepository.findById(boardId);

        /*.orElseThrow(
                () -> new ResourceNotFoundException("존재하지 않는 게시글입니다.")
        );*/

        boardRepository.deleteById(boardId);
    }

}
