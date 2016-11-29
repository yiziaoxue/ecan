package com.ecan.service;

import com.ecan.model.VmanOrder;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:47
 */
public interface VmanOrderService {

	//增加实体
	public int addEntity(VmanOrder model) throws Exception;

	//删除实体
	public int deleteEntity(VmanOrder model) throws Exception;

	//修改实体
	public int updateEntity(VmanOrder model) throws Exception;

	//查询实体
	public VmanOrder findEntity(VmanOrder model) throws Exception;

	//查询实体List
	public List<VmanOrder> findEntityList(VmanOrder model) throws Exception;

}
