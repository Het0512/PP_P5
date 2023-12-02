package com.example.board;

import com.example.board.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertBoard(BoardVo vo) {
        String sql = "insert into member (name, phoneNumber, email, category) values(" + "'" + vo.getName() + "'," + "'" + vo.getPhoneNumber() + "'," + "'" + vo.getEmail() + "'," + "'" + vo.getCategory() + "')";
        return jdbcTemplate.update(sql);
    }

    public int deleteBoard(int seq) {
        String sql = "delete from member where seq = " + seq;
        System.out.println(sql);
        return jdbcTemplate.update(sql);
    }

    public int updateBoard(BoardVo vo) {
        String sql = "update member set name='" + vo.getName() + "'," + " phoneNumber='" + vo.getPhoneNumber() + "'," + " email='" + vo.getEmail() + "'," + " category='" + vo.getCategory() + "' where seq=" + vo.getSeq();
        return jdbcTemplate.update(sql);
    }

    class BoardRowMapper implements RowMapper<BoardVo>{
        @Override
        public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVo vo = new BoardVo();
            vo.setSeq(rs.getInt("seq"));
            vo.setName(rs.getString("name"));
            vo.setPhoneNumber(rs.getString("phoneNumber"));
            vo.setEmail(rs.getString("email"));
            vo.setCategory(rs.getString("category"));
            vo.setRegdate(rs.getDate("regdate"));
            return vo;
        }
    }

    public BoardVo getBoard(int seq) {
        String sql = "select * from member where seq=" + seq;
        return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
    }

    public List<BoardVo> getBoardList() {
        String sql = "select * from member order by regdate desc";
        return jdbcTemplate.query(sql, new BoardRowMapper());
    }
}
