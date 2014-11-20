package jchatexchange.factory;

public interface ServiceProvider<T, R> {

    R request(WebAgent agent, T object);

}
