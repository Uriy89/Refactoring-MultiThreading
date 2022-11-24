package ru.netology.request;

import org.apache.http.NameValuePair;

import java.util.List;
import java.util.stream.Collectors;

public class Request {
    private String method;
    private String path;
    public List<String> headers;
    public List<NameValuePair> queryParams;

    public Request(String method, String path) {
        this.method = method;
        this.path = path;
    }

    public Request(String method, String path, List<String> headers, List<NameValuePair> queryParams) {
        this.method = method;
        this.path = path;
        this.headers = headers;
        this.queryParams = queryParams;
    }

    public List <NameValuePair> getQueryParam(String name) {
        return getQueryParams().stream()
                .filter(x->x.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<NameValuePair> getQueryParams() {
        return queryParams;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }


    public List<String> getHeaders() {
        return headers;
    }

}