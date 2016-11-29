package com.ecan.mapper;

import com.ecan.model.VmanPermcolumn;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:47
 */
public interface VmanPermcolumnMapper {

	public int addEntity(VmanPermcolumn model);

	public int deleteEntity(VmanPermcolumn model);

	public int updateEntity(VmanPermcolumn model);

	public VmanPermcolumn findEntity(VmanPermcolumn model);

	public List<VmanPermcolumn> findEntityList(VmanPermcolumn model);

}
