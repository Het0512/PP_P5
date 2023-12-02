package com.example.board;

import java.util.List;

public interface BoardServiceInterface {
    public int insertBoard(BoardVo vo);
    public int deleteBoard(int seq);
    public int updateBoard(BoardVo vo);
    public BoardVo getBoard(int seq);
    public List<BoardVo> getBoardList();

}
