package com.guoyq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guoyq.mapper.TbItemMapper;
import com.guoyq.pojo.EUDataGridResult;
import com.guoyq.pojo.TbItem;
import com.guoyq.pojo.TbItemExample;
import com.guoyq.service.ItemService;
import com.guoyq.utils.IDUtils;
import com.guoyq.utils.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {
        TbItem item=itemMapper.selectByPrimaryKey(itemId);
        return item;
    }

    @Override
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        //查询商品列表
        TbItemExample example=new TbItemExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbItem> tbItemList=itemMapper.selectByExample(example);
        //创建返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(tbItemList);
        //取记录总数
        PageInfo<TbItem> pageInfo=new PageInfo<>(tbItemList);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult createItem(TbItem tbItem) {
        //item补全
        //生成商品ID
        Long itemId= IDUtils.genItemId();
        tbItem.setId(itemId);
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        itemMapper.insert(tbItem);
        return TaotaoResult.ok();
    }


}
