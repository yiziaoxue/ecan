package com.ecan.service;

import com.ecan.model.VmanRole;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:47
 */
public interface VmanRoleService {

	//增加实体
	public int addEntity(VmanRole model) throws Exception;

	//删除实体
	public int deleteEntity(VmanRole model) throws Exception;

	//修改实体
	public int updateEntity(VmanRole model) throws Exception;

	//查询实体
	public VmanRole findEntity(VmanRole model) throws Exception;

	//查询实体List
	public List<VmanRole> findEntityList(VmanRole model) throws Exception;

}
