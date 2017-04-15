package com.guoyq.service.impl;

import com.guoyq.mapper.TbItemMapper;
import com.guoyq.pojo.TbItem;
import com.guoyq.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;
    @Override
    public TbItem getItemById(long itemId) {
        TbItem item=itemMapper.selectByPrimaryKey(itemId);
        return item;
    }
}
