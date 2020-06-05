package com.steven.filter;

import com.steven.constants.CommonResponse;
import com.steven.thread.ThreadInformation;
import com.steven.thread.ThreadInformationResource;
import com.steven.util.JacksonUtil;
import com.steven.util.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @Author steven.sheng
 * @Date 2018/12/14/014.
 */
public class ThreadInformationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadInformationFilter.class);

    @Autowired
    private ThreadInformationResource threadInformationResource;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        LOGGER.info("request url : {}",request.getRequestURL().toString());
        LOGGER.info("request getQueryString : {}",request.getQueryString());
        String system= request.getHeader("system");
        LOGGER.info(Thread.currentThread().getName()+"  clientType="+system + "  token=" + token);
        boolean isOK = true;
        if(StringUtils.isEmpty(token)){
            isOK = false;
        }
        if(!isOK){
            RestResponse cs = RestResponse.createFailed(CommonResponse.NOT_UPDATE_NEWEST_CODE, CommonResponse.NOT_UPDATE_NEWEST_MSG);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.append(JacksonUtil.toJSONString(cs));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
            return;
        }

        if(!StringUtils.isEmpty(system)){
            ThreadInformation info= threadInformationResource.getThreadInfo();
            info.setSystemName(system);
            info.setRequestTime(new Date());
            info.setThreadName(Thread.currentThread().getName());
        }
        filterChain.doFilter(request, response);

    }
}
