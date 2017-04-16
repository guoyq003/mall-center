package com.guoyq.service;

import com.guoyq.pojo.EUDataGridResult;
import com.guoyq.pojo.TbItem;
import org.springframework.stereotype.Service;


public interface ItemService {
    TbItem getItemById(long itemId);
    EUDataGridResult getItemList(Integer page,Integer rows);
}
