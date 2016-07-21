package com.ecan.mapper;

import com.ecan.model.VmanDicCode;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-07-21 18:06:53
 */
public interface VmanDicCodeMapper {

	public int addEntity(VmanDicCode model);

	public int deleteEntity(VmanDicCode model);

	public int updateEntity(VmanDicCode model);

	public VmanDicCode findEntity(VmanDicCode model);

	public List<VmanDicCode> findEntityList(VmanDicCode model);

}
