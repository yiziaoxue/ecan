package com.ecan.service.impl;

import com.ecan.model.VmanRolePermRela;
import com.ecan.mapper.VmanRolePermRelaMapper;
import com.ecan.service.VmanRolePermRelaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-22 00:56:22
 */
@Service("vmanRolePermRelaService")
public class VmanRolePermRelaServiceImpl implements VmanRolePermRelaService {

	private Logger log = Logger.getLogger(VmanRolePermRelaServiceImpl.class);

	@Autowired
	private VmanRolePermRelaMapper vmanRolePermRelaMapper;

	@Override
	public int addEntity(VmanRolePermRela model) throws Exception {
		try {
			log.info("addEntity");
			vmanRolePermRelaMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(VmanRolePermRela model) throws Exception {
		try {
			log.info("deleteEntity");
			return vmanRolePermRelaMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(VmanRolePermRela model) throws Exception {
		try {
			log.info("updateEntity");
			vmanRolePermRelaMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public VmanRolePermRela findEntity(VmanRolePermRela model) throws Exception {
		try {
			log.info("findEntity");
			return vmanRolePermRelaMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<VmanRolePermRela> findEntityList(VmanRolePermRela model) throws Exception {
		try {
			log.info("findEntityList");
			return vmanRolePermRelaMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
