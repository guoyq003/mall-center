package com.guoyq.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.guoyq.pojo.EUDataGridResult;
import com.guoyq.pojo.TbItem;
import com.guoyq.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    //商品tab页
    @Autowired
    private ItemService itemService;
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem item=itemService.getItemById(itemId);
        return item;
    }
    //查询商品列表
    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows){
        EUDataGridResult result=itemService.getItemList(page,rows);
        return result;
    }
}
