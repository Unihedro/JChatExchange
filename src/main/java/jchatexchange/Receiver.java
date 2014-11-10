package jchatexchange;

import jchatexchange.util.ReceivableChatHandle;

public interface Receiver<T extends ReceivableChatHandle> {

    /**
     * @param room
     *        An instance of a chat room connection returned by a successful
     *        call of {@link ZZZ#connectToRoom()}.
     * @see ListeningConnection
     * @return The next available <tt>T</tt>. This should never be <tt>null</tt>
     *         . If there are no <tt>T</tt> suppliable, implementing classes may
     *         choose to throw an {@link IllegalStateException}.
     * @throws IllegalArgumentException
     *         (optional) If the implementing class defines constraints on the
     *         {@link ListeningConnection room} parameter, and are not met.
     *         IllegalStateException (optional) When the implementing class is
     *         defined to signal with the exception when there are no <tt>T</tt>
     *         suppliable.
     */
    T readFromChat(ListeningConnection room) throws IllegalArgumentException, IllegalStateException;

}
