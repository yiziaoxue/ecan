package com.ecan.mapper;

import com.ecan.model.YqUsers;
import java.util.List;

public interface YqUsersMapper {

	public int addEntity(YqUsers model);

	public int deleteEntity(YqUsers model);

	public int updateEntity(YqUsers model);

	public YqUsers findEntity(YqUsers model);

	public List<YqUsers> findEntityList(YqUsers model);

}
