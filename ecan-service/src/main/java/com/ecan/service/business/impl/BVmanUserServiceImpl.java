package com.ecan.service.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecan.mapper.VmanPermMapper;
import com.ecan.mapper.VmanRoleMapper;
import com.ecan.mapper.VmanRolePermRelaMapper;
import com.ecan.mapper.VmanUserMapper;
import com.ecan.mapper.VmanUserRoleRelaMapper;
import com.ecan.model.VmanPerm;
import com.ecan.model.VmanRole;
import com.ecan.model.VmanRolePermRela;
import com.ecan.model.VmanUser;
import com.ecan.model.VmanUserRoleRela;
import com.ecan.service.business.BVmanUserService;

@Service("bVmanUserService")
public class BVmanUserServiceImpl implements BVmanUserService {

	@Autowired
	private VmanUserMapper vmanUserMapper;
	@Autowired
	private VmanUserRoleRelaMapper vmanUserRoleRelaMapper;
	@Autowired
	private VmanRoleMapper vmanRoleMapper;
	@Autowired
	private VmanRolePermRelaMapper vmanRolePermRelaMapper;
	@Autowired
	private VmanPermMapper vmanPermMapper;
	
	@Override
	@Transactional
	public List<Map<String,Object>> getAuth(VmanUser vmanUser) throws Exception {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		VmanUser modelUser = vmanUserMapper.findEntity(vmanUser);
		if(modelUser != null){
			VmanUserRoleRela modelUserRoleRela = new VmanUserRoleRela();
			modelUserRoleRela.setUserid(modelUser.getUsid());
			List<VmanUserRoleRela> listVmanUserRoleRela = vmanUserRoleRelaMapper.findEntityList(modelUserRoleRela);
			for(VmanUserRoleRela vmanUserRoleRela : listVmanUserRoleRela){
				VmanRole modelRole = new VmanRole();
				modelRole.setRoid(vmanUserRoleRela.getRoleid());
				VmanRole vmanRole = vmanRoleMapper.findEntity(modelRole);
				Map<String,Object> mapRole = new HashMap<String,Object>();
				mapRole.put("role", vmanRole);
				list.add(mapRole);
				
				VmanRolePermRela modelRolePermRela = new VmanRolePermRela();
				modelRolePermRela.setRoleid(vmanRole.getRoid());
				List<VmanRolePermRela> listVmanRolePermRela = vmanRolePermRelaMapper.findEntityList(modelRolePermRela);
				for(VmanRolePermRela vmanRolePermRela : listVmanRolePermRela){
					VmanPerm modelPerm = new VmanPerm();
					modelPerm.setPeid(vmanRolePermRela.getPermid());
					VmanPerm vmanPerm  = vmanPermMapper.findEntity(modelPerm);
					Map<String,Object> mapPerm = new HashMap<String,Object>();
					mapRole.put("perm", vmanPerm);
					list.add(mapPerm);
				}
			}
			
		}
		return list;
	}

}
