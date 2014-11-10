package jchatexchange.util;

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
