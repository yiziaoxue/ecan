package com.ecan.mapper;

import com.ecan.model.YqUsers;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-07-07 00:08:49
 */
public interface YqUsersMapper {

	public int addEntity(YqUsers model);

	public int deleteEntity(YqUsers model);

	public int updateEntity(YqUsers model);

	public YqUsers findEntity(YqUsers model);

	public List<YqUsers> findEntityList(YqUsers model);

}
