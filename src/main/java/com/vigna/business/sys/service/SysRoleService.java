package com.vigna.business.sys.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import com.vigna.business.sys.domain.SysRole;
import com.vigna.business.sys.vo.SysRoleVO;
import com.vigna.common.api.Result;

import java.util.List;
import java.util.Map;

public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页获取数据
     *
     * @param params 查询参数
     * @return IPage<SysRole>
     */
    Page<SysRole> getPage(Map<String, Object> params);

    Result<List<SysRoleVO>> getAllRoles(String authorizationHeader);

}