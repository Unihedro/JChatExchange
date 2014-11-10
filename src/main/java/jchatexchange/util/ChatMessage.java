package jchatexchange.util;

import java.util.Map;

import org.json.simple.JSONObject;

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
// @ThreadSafe
public final class ChatMessage implements ReceivableChatHandle, SendableChatHandle /*, Serializable*/{

    public final int       user_id;
    public final String    content;

    private transient User user;

    /**
     * This constructor writes to the <tt>final</tt> fields with the given
     * <tt>user_id</tt> and <tt>content</tt>. If <tt>content</tt> is
     * <tt>null</tt>, an empty {@link String} literal is used instead:
     * <p>
     * <tt>""</tt>
     * </p>
     *
     * @param user_id
     *        The user.
     * @param content
     *        The message itself.
     */
    public ChatMessage(final int user_id, final String content) throws IllegalArgumentException {
        if (user_id < 0)
            throw new IllegalArgumentException("\"user_id\" is negative: " + user_id);
        this.user_id = user_id;
        if (null == content)
            this.content = "";
        else this.content = content;
    }

    /**
     * This constructor calls an underlying package-level constructor.
     *
     * @param jsonObject
     *        A JSONObject which includes values mapped by <tt>user_id</tt> and
     *        <tt>content</tt>.
     * @throws IllegalArgumentException
     *         When <tt>jsonObject.get("user_id")</tt> is <tt>null</tt>.
     */
    public ChatMessage(final JSONObject jsonObject) throws IllegalArgumentException {
        // For public invocation, we only allow JSONObjects.
        this((Map) jsonObject);
    }

    ChatMessage(final Map<String, Object> jsonObject) throws IllegalArgumentException {
        final Object user_id = jsonObject.get("user_id");
        try {
            if (null == user_id || (this.user_id = (Integer) user_id) < 0)
                throw new IllegalArgumentException("jsonObject.get(\"user_id\") is not a positive integer: " + user_id);
        } catch(ClassCastException ex) {
            throw new IllegalArgumentException("jsonObject.get(\"user_id\") object is not Integer: " + user_id);
        }

        final Object content = jsonObject.get("content");
        if (null == content)
            this.content = "";
        else this.content = (String) content;
    }

    public User getUser() {
        // if (null == user)
        //     user = magic.get(user_id); // get from cache
        return user;
    }

    public int getId() {
        return 1;
    }
}
