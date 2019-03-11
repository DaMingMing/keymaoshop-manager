package com.keymao.service;

import com.keymao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * 商品分类接口
 */
public interface ItemCatService {
    /**
     * 根据父类id获取tree节点
     * @param parentId
     * @return
     */
    List<EasyUITreeNode> getCatList(long parentId);
}
