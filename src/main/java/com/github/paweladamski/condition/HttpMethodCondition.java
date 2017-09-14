package com.github.paweladamski.condition;

import com.github.paweladamski.condition.Condition;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;


public class HttpMethodCondition implements Condition {


    private String method;

    public HttpMethodCondition(String method) {
        this.method = method;
    }

    @Override
    public boolean matches(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return httpRequest.getRequestLine().getMethod().equals(method);
    }
}