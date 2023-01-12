package com.develop.backend.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.backend.Model.BillBoard;
import com.develop.backend.Model.JsonProcessor;
import com.develop.backend.repository.BillBoardRepository;

@Service
public class BillBoardService {
    
    @Autowired
    BillBoardRepository billBoardRepository;

    public Iterable<BillBoard> getContent(){
        return billBoardRepository.findAll();
    }

    public BillBoard findById(Integer id){
        BillBoard billBoard = billBoardRepository.findById(id).get();
        return billBoard;
    }

    public Iterable<BillBoard> createContent(BillBoard billBoard){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = df.format(new Date());
        billBoard.setPubUser("Administrator");
        billBoardRepository.save(billBoard);
        return getContent();
    }

    public BillBoard updateBillBoard(Integer id, JsonProcessor jsonProcessor){
        try{
            BillBoard resbBillBoard = findById(id);
            String topicValue = jsonProcessor.getTopicValue();
            String pubDateValue = jsonProcessor.getPubdateValue();
            String endDateValue = jsonProcessor.getEnddateValue();
            String textValue = jsonProcessor.getTextValue();
            resbBillBoard.setTopic(topicValue);
            resbBillBoard.setPubDate(pubDateValue);
            resbBillBoard.setEndDate(endDateValue);
            resbBillBoard.setContent(textValue);
            return billBoardRepository.save(resbBillBoard);
        }catch(Exception exception){
            return null;
        }
    }

    public Boolean deleteContent(Integer id){
        try{
            BillBoard rebuBillBoard = findById(id);
            billBoardRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            return false;
        }
    }
}
