package com.ecan.service;

import com.ecan.model.VmanDicCode;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-08-02 15:26:36
 */
public interface VmanDicCodeService {

	//增加实体
	public int addEntity(VmanDicCode model) throws Exception;

	//删除实体
	public int deleteEntity(VmanDicCode model) throws Exception;

	//修改实体
	public int updateEntity(VmanDicCode model) throws Exception;

	//查询实体
	public VmanDicCode findEntity(VmanDicCode model) throws Exception;

	//查询实体List
	public List<VmanDicCode> findEntityList(VmanDicCode model) throws Exception;

}
