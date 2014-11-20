package jchatexchange;

import java.net.URI;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketClient;
import org.eclipse.jetty.websocket.WebSocketClientFactory;

import jchatexchange.factory.Factory;
import jchatexchange.room.SEChat;
import jchatexchange.util.ChatHandle;

public final class ChatExchange {

    public static Factory getFactory() {
        throw new UnsupportedOperationException();
    }

    public static ListeningConnection createNewRoomListener(@SuppressWarnings("unused") boolean synchronous, SEChat chat) {
        while (true)
            try {
                return new Watcher(chat);
            } catch(Exception e) {
                // Try again!
            }
    }

    public static Object /* CallerAwarenessEngine */getCallerAwareEngine() {
        throw new UnsupportedOperationException();
    }
}

class Watcher implements ListeningConnection {

    Watcher(SEChat chat) throws Exception {

        WebSocketClientFactory factory = new WebSocketClientFactory();
        factory.start();

        WebSocketClient client = factory.newWebSocketClient();
        // Configure the client
        client.setOrigin(chat.rootUrl);

        WebSocket.Connection connection = client.open(new URI("ws://127.0.0.1:8080/"), new WebSocket.OnTextMessage() {

            @Override
            public void onOpen(Connection connection) {
                // open notification
            }

            @Override
            public void onClose(int closeCode, String message) {
                // close notification
            }

            @Override
            public void onMessage(String data) {
                // handle incoming message
            }
        }).get(5, TimeUnit.SECONDS);

        connection.sendMessage("Hello World");
    }

    @Override
    public Optional<ChatHandle> queryNext() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Iterable<ChatHandle>> queryNext(int amount) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<ChatHandle> queryAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ChatHandle queryForNext() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<ChatHandle> queryForNext(int amount) {
        // TODO Auto-generated method stub
        return null;
    }
}
