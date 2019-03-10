package com.keymao.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keymao.common.pojo.EasyUIDataGridResult;
import com.keymao.common.utils.E3Result;
import com.keymao.common.utils.IDUtils;
import com.keymao.mapper.TbContentCategoryMapper;
import com.keymao.mapper.TbItemDescMapper;
import com.keymao.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keymao.mapper.TbItemMapper;
import com.keymao.pojo.TbItem;
import com.keymao.pojo.TbItemExample;
import com.keymao.pojo.TbItemExample.Criteria;
import com.keymao.service.ItemService;


/**
 * 商品管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;

	@Override
	public TbItem getItemById(long id) {
		//根据主键查询
		//TbItem item = itemMapper.selectByPrimaryKey(id);
		
		//条件查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andIdEqualTo(id);
		//执行查询
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
		//return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);

		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal((int) pageInfo.getTotal());
		result.setRows(list);
		System.out.println("商品list=" + list.size());
		return result;
	}

	@Override
	public E3Result addItem(TbItem item, String desc) {
        // 1、生成商品id
        long itemId = IDUtils.genItemId();
        // 2、补全TbItem对象的属性
        item.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        // 3、向商品表插入数据
        itemMapper.insert(item);
        // 4、创建一个TbItemDesc对象
        TbItemDesc itemDesc = new TbItemDesc();
        // 5、补全TbItemDesc的属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 6、向商品描述表插入数据
        itemDescMapper.insert(itemDesc);
        // 7、E3Result.ok()
        return E3Result.ok();
	}


}