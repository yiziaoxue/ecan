package com.ecan.service.impl;

import com.ecan.model.VmanUser;
import com.ecan.mapper.VmanUserMapper;
import com.ecan.service.VmanUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:48
 */
@Service("vmanUserService")
public class VmanUserServiceImpl implements VmanUserService {

	private Logger log = Logger.getLogger(VmanUserServiceImpl.class);

	@Autowired
	private VmanUserMapper vmanUserMapper;

	@Override
	public int addEntity(VmanUser model) throws Exception {
		try {
			log.info("addEntity");
			vmanUserMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(VmanUser model) throws Exception {
		try {
			log.info("deleteEntity");
			return vmanUserMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(VmanUser model) throws Exception {
		try {
			log.info("updateEntity");
			vmanUserMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public VmanUser findEntity(VmanUser model) throws Exception {
		try {
			log.info("findEntity");
			return vmanUserMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<VmanUser> findEntityList(VmanUser model) throws Exception {
		try {
			log.info("findEntityList");
			return vmanUserMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
