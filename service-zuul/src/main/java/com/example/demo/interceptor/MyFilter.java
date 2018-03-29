package com.example.demo.interceptor;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author huangcanjia
 * @create 2018-03-29 18:28
 */
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();

        String token = request.getParameter("token");
        if (token == null || "".equals(token.trim())) {
            System.err.println("木有权限");

            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);

            try {
                currentContext.getResponse().getWriter().write("token is null");

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        System.err.println("有权限"+token);
        return null;
    }
}
