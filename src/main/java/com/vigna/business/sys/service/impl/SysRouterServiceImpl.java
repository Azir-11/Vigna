package com.vigna.business.sys.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.vigna.business.sys.domain.SysRouter;
import com.vigna.business.sys.mapper.SysRouterMapper;
import com.vigna.business.sys.service.SysRouterService;
import com.vigna.business.sys.vo.SysRoutesVO;
import com.vigna.common.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SysRouterServiceImpl extends ServiceImpl<SysRouterMapper, SysRouter>
        implements SysRouterService {

    @Override
    public Result<Map<String, Object>> getUserRoutes() {
        return null;
    }

    @Override
    public Result<List<SysRoutesVO>> getConstantRoutes() {
        return null;
    }
}