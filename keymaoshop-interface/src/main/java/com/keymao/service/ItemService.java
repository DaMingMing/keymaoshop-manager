package com.keymao.service;

import com.keymao.common.pojo.EasyUIDataGridResult;
import com.keymao.common.utils.E3Result;
import com.keymao.pojo.TbItem;

/**
 * 商品接口
 */
public interface ItemService {
    /**
     * 根据id获取商品
     * @param id
     * @return
     */
	public TbItem getItemById(long id);

    /**
     * 获取商品列表，获取第page页，rows条内容，默认查询总数count
     * @param page  页数
     * @param rows 条数
     * @return 返回含有商品列表的包装类
     */
    public EasyUIDataGridResult getItemList(int page, int rows);

    public E3Result addItem(TbItem item, String desc) ;
}
