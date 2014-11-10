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

    public ChatMessage(final int user_id, final String content) {
        this.user_id = user_id;
        // Validate.notNull(sender, "sender cannot be null for public ChatMessage()");
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
        if (null == user_id)
            throw new IllegalArgumentException("");
        this.user_id = (Integer) user_id;

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
