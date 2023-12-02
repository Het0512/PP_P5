package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
    @RequestMapping(value = "/list")
    public String boardlist(Model model) {
        model.addAttribute("list", boardService.getBoardList());
        return "list";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost() {
        return "addpostform";
    }

    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOk(BoardVo vo) {
        if(boardService.insertBoard(vo) == 0) {
            System.out.println("데이터 추가 실패 ");
        }
        else {
            System.out.println("데이터 추가 성공 ");
        }
        return "redirect:list";
    }
    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        BoardVo boardVo = boardService.getBoard(id);
        model.addAttribute("u", boardVo);
        return "editform";
    }
    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVo vo) {
        if(boardService.updateBoard(vo) == 0) {
            System.out.println("데이터 수정 실패 ");
        }
        else {
            System.out.println("데이터 수정 성공 ");
        }
        return "redirect:list";
    }
    @RequestMapping(value = "/deletok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id) {
        System.out.println(id);
        if(boardService.deleteBoard(id) == 0) {
            System.out.println("데이터 삭제 실패 ");
        }
        else {
            System.out.println("데이터 삭제 성공 ");
        }
        return "redirect:../list";
    }
}
