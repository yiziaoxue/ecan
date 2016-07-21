package com.ecan.mapper;

import com.ecan.model.VmanUser;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-07-21 18:06:53
 */
public interface VmanUserMapper {

	public int addEntity(VmanUser model);

	public int deleteEntity(VmanUser model);

	public int updateEntity(VmanUser model);

	public VmanUser findEntity(VmanUser model);

	public List<VmanUser> findEntityList(VmanUser model);

}
