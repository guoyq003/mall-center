package com.guoyq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guoyq.mapper.TbItemMapper;
import com.guoyq.pojo.TbItem;
import com.guoyq.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//PageHelper分页插件测试练习
public class TestPageHelper {
    @Test
    public void testPageHelper(){
        //创建一个Spring容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        TbItemMapper tbItemMapper=applicationContext.getBean(TbItemMapper.class);
        //执行查询，分页
        TbItemExample example=new TbItemExample();
        //分页处理
        PageHelper.startPage(1, 10);
        //商品列表
        List<TbItem> list=tbItemMapper.selectByExample(example);
        for (TbItem tbItem:list){
            System.out.println(tbItem.getTitle());
        }
        //分页信息
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        long total=pageInfo.getTotal();
        System.out.println("共有条数为："+total);
    }
}
