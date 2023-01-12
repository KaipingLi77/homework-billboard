package com.develop.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.develop.backend.Model.BillBoard;

public interface BillBoardRepository extends CrudRepository<BillBoard, Integer> {
    
}
