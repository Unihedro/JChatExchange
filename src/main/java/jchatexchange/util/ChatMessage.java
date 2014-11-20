package jchatexchange.util;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import jchatexchange.factory.FactoryMeta;

/**
 * <p>
 * This class represents a chat message. It may be constructed on demand for
 * sending as a message, or through a JSON Object.
 * </p>
 * ChatMessage @ jchatexchange.util
 *
 * @author Unihedron<<a href="mailto:vincentyification@gmail.com"
 *         >vincentyification@gmail.com</a>>
 */
@ThreadSafe
public abstract class ChatMessage implements ReceivableChatHandle, SendableChatHandle, Serializable {

    static final int       NONE = 0;

    public final int       userId;
    public final int       messageId;
    public final String    content;

    private transient User user;

    protected ChatMessage(User user, String content) {
        this(user.id, NONE, content);
        this.user = user;
    }

    protected ChatMessage(int userId, int messageId, String content) {
        this.userId = userId;
        this.messageId = messageId;
        this.content = content;
    }

    /**
     * Gets the latest contents of the message. Depending on settings of the
     * library, this may be arbitrarily unhelpful; By default, HTML is returned.
     *
     * @return The contents of the message. This can be expected to be of the
     *         latest version.
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets the contents of the message in specified message type.
     * Implementation dependent.
     *
     * @param type
     *        The type of the message to retrieve. Custom
     *        {@link FactoryMeta.MessageType MessageType}s should be handled by
     *        its subclasses.
     * @return The contents of the message. If it's not found, <tt>null</tt>
     *         should be returned.
     * @throws IllegalStateException
     *         When this <tt>ChatMessage</tt> object was not received from the
     *         server, instead constructed and doesn't include a proper type.
     * @throws UnauthorizedInvocationException
     *         When the {@link jchatexchange.factory.Factory Factory} creating
     *         the agent which created this <tt>ChatMessage</tt> object was
     *         specified to throw an exception on invocation of this method.
     * @see FactoryMeta.MessageType#request(jchatexchange.factory.WebAgent,
     *      ChatMessage)
     */
    @Nullable
    protected abstract String getContent(@Nonnull FactoryMeta.MessageType type) throws IllegalStateException, UnauthorizedInvocationException;

    /**
     * The history of this message. This is expected to be of chronological
     * order where the first element is the first version of the message ever
     * posted.
     *
     * @param meta
     *        The details of retrieving the history of this <tt>ChatMessage</tt>
     *        object as. The metadata object does not need to specify this
     *        implementation, as the {@link jchatexchange.factory.Factory
     *        Factory} the meta object links to should include information
     *        required. TODO document <tt>null</tt>
     * @return The history of this message. Due to technical limitations, this
     *         should always return text sent in its markdown format.
     * @throws IllegalStateException
     *         When this <tt>ChatMessage</tt> object was not received from the
     *         server, instead constructed and doesn't include a proper type.
     * @throws UnauthorizedInvocationException
     *         When the {@link jchatexchange.factory.Factory Factory} creating
     *         the agent which created this <tt>ChatMessage</tt> object was
     *         specified to throw an exception on invocation of this method.
     */
    @Nullable
    public abstract List<String> getHistoryAs(@Nullable FactoryMeta meta) throws IllegalStateException, UnauthorizedInvocationException;

    /**
     * <p>
     * Gets the corresponding {@link User} object. If the object is absent from
     * the cache pool, we will attempt to ask the corresponding {@link ZZZ Chat}
     * instance to parse the room response string after a refresh of the room.
     * </p>
     * <p>
     * There is no guarantee for thread-safetiness of the implementation or
     * execution of this method, however in future implementations this method
     * will be thread-safe.
     * </p>
     * <p>
     * However, for all {@link User} objects returned by calling this method, it
     * is guaranteed that the user is online at the moment of calling.
     * Otherwise, <tt>null</tt> is returned.
     * </p>
     *
     * @return The user, <tt>null</tt> if the sender of this message is not
     *         online or the user ID is invalid.
     */
    public User getUser() {
        // if (null == user)
        //     user = magic.get(user_id); // get from cache
        return user;
    }

    /**
     * Chat messages has an ID of 1. The <tt>event_type</tt> of a JSONevent
     * response from the chat servers are <tt>1</tt>, hence this value.
     */
    @Override
    public int getId() {
        return 1;
    }

}
