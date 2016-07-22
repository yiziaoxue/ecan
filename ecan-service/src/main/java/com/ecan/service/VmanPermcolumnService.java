package com.ecan.service;

import com.ecan.model.VmanPermcolumn;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-22 00:56:22
 */
public interface VmanPermcolumnService {

	//增加实体
	public int addEntity(VmanPermcolumn model) throws Exception;

	//删除实体
	public int deleteEntity(VmanPermcolumn model) throws Exception;

	//修改实体
	public int updateEntity(VmanPermcolumn model) throws Exception;

	//查询实体
	public VmanPermcolumn findEntity(VmanPermcolumn model) throws Exception;

	//查询实体List
	public List<VmanPermcolumn> findEntityList(VmanPermcolumn model) throws Exception;

}
