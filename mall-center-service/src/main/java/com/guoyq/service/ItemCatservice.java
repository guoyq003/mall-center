package com.guoyq.service;

import com.guoyq.pojo.TbItemCat;

import java.util.List;

public interface ItemCatService {
    List<TbItemCat> getItemCatList(Long parentId);
}
