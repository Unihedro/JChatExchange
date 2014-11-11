package jchatexchange.util;

/**
 * Represents handle functions and events that can be used to interact with the
 * Stack Exchange chat. For example, objects that represents editing a message,
 * replying to a message, or custom objects programmed to carry specific
 * metadata constructed over library user end. <b><i>Read: <a
 * href="#">Developers - Advanced: Implementing custom objects for
 * metadata control</a> - TBD</i></b><br>
 * ChatHandle @ jchatexchange.util
 *
 * @author Unihedron<<a href="mailto:vincentyification@gmail.com"
 *         >vincentyification@gmail.com</a>>
 * @see ReceivableChatHandle
 * @see SendableChatHandle
 */
public interface ChatHandle {

    /**
     * The ID of the type represented by this Handle.
     *
     * @return An <tt>int</tt> equal to the type of the Handle, some are
     *         implementation-specific (Chat server responses for
     *         <tt>"event_id"</tt>) but most are expected to be arbitrarily
     *         defined by the <a href="http://bit.ly/jSEchat">JChatExchange</a>
     *         library. <!-- Who knows, maybe we can even set up dynamic IDs for
     *         different JChatExchange usage connections in the future.-->
     */
    int getId();

}
