package com.ecan.service;

import com.ecan.model.VmanRolePermRela;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-22 00:56:22
 */
public interface VmanRolePermRelaService {

	//增加实体
	public int addEntity(VmanRolePermRela model) throws Exception;

	//删除实体
	public int deleteEntity(VmanRolePermRela model) throws Exception;

	//修改实体
	public int updateEntity(VmanRolePermRela model) throws Exception;

	//查询实体
	public VmanRolePermRela findEntity(VmanRolePermRela model) throws Exception;

	//查询实体List
	public List<VmanRolePermRela> findEntityList(VmanRolePermRela model) throws Exception;

}
