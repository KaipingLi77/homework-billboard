package com.develop.backend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class BillBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String topic;

    @Column
    String pubDate;
    
    @Column
    String endDate;

    @Column
    String pubUser;

    @Column
    String content;

}
