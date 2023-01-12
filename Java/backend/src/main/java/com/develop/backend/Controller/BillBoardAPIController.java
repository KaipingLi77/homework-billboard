package com.develop.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.develop.backend.Model.BillBoard;
import com.develop.backend.Model.JsonProcessor;
import com.develop.backend.repository.BillBoardRepository;
import com.develop.backend.service.BillBoardService;

@Controller
public class BillBoardAPIController {
    
    @Autowired
    BillBoardService billBoardService;
    
    @Autowired
    BillBoardRepository billBoardRepository;

    @GetMapping("/pub")
    public String redirectPubAndUpdate(Model model){
        Iterable<BillBoard> billBoardList = billBoardService.getContent();
        model.addAttribute("billBoardList", billBoardList);
        BillBoard billBoard = new BillBoard();
        model.addAttribute("billBoardObject", billBoard);
        return "pubandupdate_billboard";
    }

    @GetMapping("/contents")
    public String getContent(Model model){
        Iterable<BillBoard> billBoardList = billBoardService.getContent();
        model.addAttribute("billBoardList", billBoardList);
        BillBoard billBoard = new BillBoard();
        model.addAttribute("billBoardObject", billBoard);
        return "billboardlist";
    }
    
    @GetMapping("/update/{id}")
    public String getUpdatePage(@PathVariable Integer id, Model model){
        Iterable<BillBoard> billBoardList = billBoardService.getContent();
        model.addAttribute("billBoardList", billBoardList);
        BillBoard billBoard = findById(id);
        model.addAttribute("billBoardObject", billBoard);
        return "forupdate";
    }

    private BillBoard findById(Integer id) {
        BillBoard billBoard = billBoardRepository.findById(id).get();
        return billBoard;
    }

    @GetMapping("/boardMessage/{id}")
    public String getBoardMessage(@PathVariable Integer id, Model model){
        Iterable<BillBoard> billBoardList = billBoardService.getContent();
        model.addAttribute("billBoardList", billBoardList);
        BillBoard billBoard = findById(id);
        model.addAttribute("billBoardObject", billBoard);
        return "messageBoardList";
    }

    @PostMapping("/contents")
    public String createContent(@ModelAttribute("getContent") BillBoard billBoard, Model model){
        Iterable<BillBoard> allContentList = billBoardService.createContent(billBoard);
        BillBoard emptyBillBoard = new BillBoard();
        model.addAttribute("billBoardList", allContentList);
        model.addAttribute("billBoardObject", emptyBillBoard);
        return "billboardlist";
    }

    @ResponseBody
    @PutMapping("/contents/{id}")
    public String updateBillBoard(@PathVariable Integer id, @RequestBody JsonProcessor jsonProcessor) 
    throws InterruptedException{
        billBoardService.updateBillBoard(id, jsonProcessor);
        return "billboardlist";
    }

    @ResponseBody
    @DeleteMapping("/contents/{id}")
    public String deleteContent(@PathVariable Integer id){
        billBoardService.deleteContent(id);
        return "billboardlist";
    }
}
