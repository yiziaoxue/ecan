package com.ecan.mapper;

import com.ecan.model.VmanOrder;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2017-01-03 22:23:31
 */
public interface VmanOrderMapper {

	public int addEntity(VmanOrder model);

	public int deleteEntity(VmanOrder model);

	public int updateEntity(VmanOrder model);

	public VmanOrder findEntity(VmanOrder model);

	public List<VmanOrder> findEntityList(VmanOrder model);

}
