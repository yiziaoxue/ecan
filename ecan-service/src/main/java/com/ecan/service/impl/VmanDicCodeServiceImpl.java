package com.ecan.service.impl;

import com.ecan.model.VmanDicCode;
import com.ecan.mapper.VmanDicCodeMapper;
import com.ecan.service.VmanDicCodeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-07-21 18:06:54
 */
@Service("vmanDicCodeService")
public class VmanDicCodeServiceImpl implements VmanDicCodeService {

	private Logger log = Logger.getLogger(VmanDicCodeServiceImpl.class);

	@Autowired
	private VmanDicCodeMapper vmanDicCodeMapper;

	@Override
	public int addEntity(VmanDicCode model) throws Exception {
		try {
			log.info("addEntity");
			vmanDicCodeMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(VmanDicCode model) throws Exception {
		try {
			log.info("deleteEntity");
			return vmanDicCodeMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(VmanDicCode model) throws Exception {
		try {
			log.info("updateEntity");
			vmanDicCodeMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public VmanDicCode findEntity(VmanDicCode model) throws Exception {
		try {
			log.info("findEntity");
			return vmanDicCodeMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<VmanDicCode> findEntityList(VmanDicCode model) throws Exception {
		try {
			log.info("findEntityList");
			return vmanDicCodeMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
