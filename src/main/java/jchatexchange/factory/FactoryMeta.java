package jchatexchange.factory;

import jchatexchange.util.ChatMessage;

public interface FactoryMeta {

    public abstract class MessageType implements FactoryMeta, ServiceProvider<ChatMessage, String> {

        public static final MessageType MARKDOWN = new FetchByMessageType();
        public static final MessageType HTML     = new FetchByMessageType();
        public static final MessageType CLEAR    = new FetchByMessageType();

    }

}

class FetchByMessageType extends FactoryMeta.MessageType {

    @Override
    public String request(WebAgent agent, ChatMessage message) {
        return /*agent.POST();*/null;
    }

}
