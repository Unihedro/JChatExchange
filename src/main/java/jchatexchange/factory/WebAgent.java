package jchatexchange.factory;

import java.util.Map;

public interface WebAgent {

    public Object/* ??? */GET(String uri);

    public Object/* ??? */GET(String uri, Map<String, String> params);

    public Object/* ??? */POST(String uri);

    public Object/* ??? */POST(String uri, Map<String, String> params);

}
