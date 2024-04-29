package com.vigna.business.sys.service;

import com.mybatisflex.core.service.IService;
import com.vigna.business.sys.domain.SysRouter;
import com.vigna.business.sys.service.impl.SysRouterServiceImpl;
import com.vigna.business.sys.vo.SysRoutesVO;
import com.vigna.common.api.Result;

import java.util.List;
import java.util.Map;

public interface SysRouterService extends IService<SysRouter> {

    Result<Map<String, Object>> getUserRoutes();

    Result<List<SysRoutesVO>> getConstantRoutes();
}
