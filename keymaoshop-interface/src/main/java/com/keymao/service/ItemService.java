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

    /**
     * 新增商品
     * @param item 商品信息
     * @param desc 商品描述
     * @return
     */
    public E3Result addItem(TbItem item, String desc) ;

    /**
     * 批量删除商品
     * @param ids 商品id，以英文逗号分割
     * @return
     */
    public E3Result deleteItems(String ids) ;

    /**
     * 批量上架商品
     * @param ids 商品id，以英文逗号分割
     * @return
     */
    public E3Result reshelfItems(String ids) ;

    /**
     * 批量下架商品
     * @param ids 商品id，以英文逗号分割
     * @return
     */
    public E3Result instockItems(String ids) ;
}
