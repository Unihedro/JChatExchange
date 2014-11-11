package jchatexchange.util;

/**
 * <p>
 * This type defines objects which can be accessed from a
 * {@link jchatexchange.ListeningConnection ListeningConnection}.
 * </p>
 * <p>
 * Most of the objects implementing this interface are immutable and therefore
 * thread-safe, however it is not necessary that no side effects may be raised
 * when these objects are being used.
 * </p>
 * AcceptableChatHandle @ jchatexchange.util
 *
 * @author Unihedron<<a href="mailto:vincentyification@gmail.com"
 *         >vincentyification@gmail.com</a>>
 */
public interface ReceivableChatHandle extends ChatHandle {}
