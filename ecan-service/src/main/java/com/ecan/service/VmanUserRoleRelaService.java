package com.ecan.service;

import com.ecan.model.VmanUserRoleRela;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-30 20:39:08
 */
public interface VmanUserRoleRelaService {

	//增加实体
	public int addEntity(VmanUserRoleRela model) throws Exception;

	//删除实体
	public int deleteEntity(VmanUserRoleRela model) throws Exception;

	//修改实体
	public int updateEntity(VmanUserRoleRela model) throws Exception;

	//查询实体
	public VmanUserRoleRela findEntity(VmanUserRoleRela model) throws Exception;

	//查询实体List
	public List<VmanUserRoleRela> findEntityList(VmanUserRoleRela model) throws Exception;

}
