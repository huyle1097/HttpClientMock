package com.github.paweladamski.condition;

import com.github.paweladamski.condition.Condition;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;
import org.hamcrest.Matcher;

import java.util.Objects;

public class HeaderCondition implements Condition {
    private final String header;
    private final Matcher<String> value;

    public HeaderCondition(String header, Matcher<String> value) {
        this.header = header;
        this.value = value;
    }

    @Override
    public boolean matches(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        return httpRequest.getFirstHeader(header)!=null &&
               value.matches(httpRequest.getFirstHeader(header).getValue());
    }
}
