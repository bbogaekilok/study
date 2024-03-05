package com.hecto.hectobackend.repository;

import com.hecto.hectobackend.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public void save(BoardDTO boardDTO) {
        sql.insert("Board.save", boardDTO);
    }

    public List<BoardDTO> findAll(HashMap pageIdx) {
        return sql.selectList("Board.findAll", pageIdx);
    }

    public BoardDTO findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }

    public void deleteById(Long id) {
        sql.delete("Board.delete", id);
    }

    public int getTotalCount() {
        return sql.selectOne("Board.getTotalCnt");
    }
}
