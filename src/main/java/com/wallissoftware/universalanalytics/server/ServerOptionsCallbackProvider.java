package com.wallissoftware.universalanalytics.server;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.wallissoftware.universalanalytics.server.options.ServerOptionsCallback;

@Singleton
public class ServerOptionsCallbackProvider implements Filter, Provider<ServerOptionsCallback> {

    private final static int ANALYTICS_VERSION = 1;
    private final String userAccount;
    private String cookieValue;
    private final Random random = new Random();

    @Inject
    ServerOptionsCallbackProvider(@Named("gaAccount") final String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) {
            doHttpFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
        } else {
            chain.doFilter(request, response);
        }

    }

    private void doHttpFilter(final HttpServletRequest request, final HttpServletResponse response,
            final FilterChain chain) throws IOException, ServletException {
        cookieValue = null;
        final Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (final Cookie cookie : cookies) {
                if (cookie.getName().equals("_ga")) {
                    cookieValue = cookie.getValue();
                    if (cookieValue.split("\\.").length != 4) {
                        cookieValue = null;
                    }
                }
            }
        }
        final boolean createCookie = cookieValue == null;
        if (createCookie) {
            final int hostLevel = request.getServerName().split("\\.").length;
            cookieValue = "GA" + ANALYTICS_VERSION + "." + hostLevel + "." + random.nextInt(Integer.MAX_VALUE) + "."
                    + (System.currentTimeMillis() / 1000);
            final Cookie cookie = new Cookie("_ga", cookieValue);
            cookie.setPath("/");
            cookie.setMaxAge(63072000);
            response.addCookie(cookie);
        }

        chain.doFilter(request, response);

    }

    @Override
    public ServerOptionsCallback get() {
        final ServerOptionsCallback result = new ServerOptionsCallback();
        result.putText("v", ANALYTICS_VERSION + "");
        result.putText("tid", userAccount);
        final String[] split = cookieValue.split("\\.");
        result.putText("cid", split[2] + "." + split[3]);
        return result;
    }

    @Override
    public void init(final FilterConfig config) throws ServletException {
        // TODO Auto-generated method stub

    }

}
