package jchatexchange;

import java.util.Optional;

import jchatexchange.util.ChatHandle;

/**
 * <p>
 * Instances of classes implementing this interface stores automatically queried
 * chat events within an active connection.
 * </p>
 * <p>
 * Such objects are expected to be thread-safe.
 * </p>
 * ListeningConnection @ jchatexchange
 *
 * @author Unihedron<<a href="mailto:vincentyification@gmail.com"
 *         >vincentyification@gmail.com</a>>
 */
public interface ListeningConnection {

    Optional<ChatHandle> queryNext();

    Optional<Iterable<ChatHandle>> queryNext(int amount);

    Iterable<ChatHandle> queryAll();

    ChatHandle queryForNext();

    Iterable<ChatHandle> queryForNext(int amount);

}
