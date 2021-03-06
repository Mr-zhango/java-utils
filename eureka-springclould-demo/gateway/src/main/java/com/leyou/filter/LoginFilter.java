package com.leyou.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {

        // 执行顺序
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        // 获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();

        // 获取request
        HttpServletRequest request = ctx.getRequest();

        // 判断请求参数
        String token = request.getParameter("access-token");

        if(StringUtils.isBlank(token)){
            // 不存在,去登录去
            ctx.setSendZuulResponse(false);
            // 403 没有权限
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        // 存在了,放行
        return null;
    }
}
