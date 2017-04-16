package com.guoyq.service.impl;

import com.guoyq.mapper.TbItemCatMapper;
import com.guoyq.pojo.TbItemCat;
import com.guoyq.pojo.TbItemCatExample;
import com.guoyq.service.ItemCatService;
import com.guoyq.pojo.TbItemCatExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCatserviceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public List<TbItemCat> getItemCatList(Long parentId) {
        TbItemCatExample example=new TbItemCatExample();
        //设置查询条件
        Criteria criteria=example.createCriteria();
        //根据parentId查询子节点
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> itemCatList=itemCatMapper.selectByExample(example);
        return itemCatList;
    }
}
