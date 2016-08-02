package com.ecan.service.impl;

import com.ecan.model.VmanRole;
import com.ecan.mapper.VmanRoleMapper;
import com.ecan.service.VmanRoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-30 20:39:09
 */
@Service("vmanRoleService")
public class VmanRoleServiceImpl implements VmanRoleService {

	private Logger log = Logger.getLogger(VmanRoleServiceImpl.class);

	@Autowired
	private VmanRoleMapper vmanRoleMapper;

	@Override
	public int addEntity(VmanRole model) throws Exception {
		try {
			log.info("addEntity");
			vmanRoleMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(VmanRole model) throws Exception {
		try {
			log.info("deleteEntity");
			return vmanRoleMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(VmanRole model) throws Exception {
		try {
			log.info("updateEntity");
			vmanRoleMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public VmanRole findEntity(VmanRole model) throws Exception {
		try {
			log.info("findEntity");
			return vmanRoleMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<VmanRole> findEntityList(VmanRole model) throws Exception {
		try {
			log.info("findEntityList");
			return vmanRoleMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
