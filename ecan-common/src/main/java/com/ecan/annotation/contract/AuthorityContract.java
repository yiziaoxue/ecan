package com.ecan.annotation.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ecan.annotation.Authority;
import com.ecan.constant.Constant;
import com.ecan.exception.AuthorityException;

/**
 * 权限验证算法
 * @author TaneRoom
 * @since 2016年7月21日 上午10:46:34 
 * @version v1.0
 */
public class AuthorityContract {
	
	private HttpSession session;
	
	public AuthorityContract(HttpServletRequest request){
		this.session = request.getSession();
	}
	
	public AuthorityContract() {
		super();
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public void clear() {
        session.removeAttribute(Constant.SOLES);
        session.removeAttribute(Constant.PERMS);
    }
	
	@SuppressWarnings("unchecked")
	public Set<String> getRoles() {
        return (Set<String>) session.getAttribute(Constant.SOLES);
    }
    
    @SuppressWarnings("unchecked")
	public Set<String> getPerms() {
        return (Set<String>) session.getAttribute(Constant.PERMS);
    }
	
	public void checkPermission(Authority auth) {
		if (checkRoles(auth) && checkPerms(auth)) {
			return;
		}
      
		throw new AuthorityException("访问操作拒绝!");
	}
	
	private boolean checkRoles(Authority auth) {
		if (auth == null) {
			return true;
		}

		String[] roles = auth.role();
		if (roles == null || roles.length == 0) {
			return true;
		}
		List<String> list = new ArrayList<String>();
		for (String role : roles) {
			if (role != null && role.trim().length() > 0) {
				list.add(role.trim());
			}
		}
		if (list.isEmpty()) {
			return true;
		}

		Set<String> rs = getRoles();
		// 如果角色集为空，则不允许获取权限
		if (rs == null) {
			return false;
		}

		if (auth.roleOr()) {
			for (String role : roles) {
				if (rs.contains(role)) {
					return true;
				}
			}
		} else {
			for (String role : roles) {
				if (!rs.contains(role)) {
					return false;
				}
			}
			return true;
		}

		return false;
	}

	private boolean checkPerms(Authority auth) {
		if (auth == null) {
			return true;
		}

		String[] perms = auth.perm();
		if (perms == null || perms.length == 0) {
			return true;
		}
		List<String> list = new ArrayList<String>();
		for (String perm : perms) {
			if (perm != null && perm.trim().length() > 0) {
				list.add(perm.trim());
			}
		}
		if (list.isEmpty()) {
			return true;
		}

		Set<String> ps = getPerms();
		if (auth.permOr()) {
			for (String perm : perms) {
				if (ps.contains(perm)) {
					return true;
				}
			}
		} else {
			for (String perm : perms) {
				if (!ps.contains(perm)) {
					return false;
				}
			}
			return true;
		}

		return false;
	}
	
}
