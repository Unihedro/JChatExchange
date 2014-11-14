package jchatexchange;

import jchatexchange.factory.Factory;
import jchatexchange.room.SEChat;

public final class ChatExchange {

    public static Factory getFactory() {
        throw new UnsupportedOperationException();
    }

    public static ListeningConnection createNewRoomListener(@SuppressWarnings("unused") boolean synchronous, @SuppressWarnings("unused") SEChat chat) {
        throw new UnsupportedOperationException();
    }

    public static Object /* CallerAwarenessEngine */getCallerAwareEngine() {
        throw new UnsupportedOperationException();
    }

}
