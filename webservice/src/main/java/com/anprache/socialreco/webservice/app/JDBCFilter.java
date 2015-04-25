package com.anprache.socialreco.webservice.app;

import com.anprache.dao.utils.DBUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by pratyush.verma on 26/04/15.
 */
public class JDBCFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            DBUtils.init();
            chain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            DBUtils.rollback();
            throw e;
        } finally {
            DBUtils.commit();
        }
    }

    @Override
    public void destroy() {

    }
}
