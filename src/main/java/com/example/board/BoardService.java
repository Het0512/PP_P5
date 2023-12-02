package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService implements BoardServiceInterface {
    @Autowired
    BoardDAO boardDAO;

    @Override
    public int insertBoard(BoardVo vo) { return boardDAO.insertBoard(vo); }

    @Override
    public int deleteBoard(int seq) { return boardDAO.deleteBoard(seq); }

    @Override
    public int updateBoard(BoardVo vo) { return boardDAO.updateBoard(vo); }

    @Override
    public BoardVo getBoard(int seq) { return boardDAO.getBoard(seq); }

    @Override
    public List<BoardVo> getBoardList() {
        return boardDAO.getBoardList();
    }
}
