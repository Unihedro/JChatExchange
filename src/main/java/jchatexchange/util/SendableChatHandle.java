package jchatexchange.util;

/**
 * <p>
 * This type represents elements or constructs that defines an action that can
 * be submitted to an active {@link ZZZ Chat} instance to perform an action,
 * such as editing or posting a new message. It is also possible, but not
 * strictly necessary for {@link jchatexchange.ListeningConnection
 * ListeningConnection} instances to prevent picking up the side effect as
 * echos.
 * </p>
 * <p>
 * Note that most of these objects do not actually need to be constructed - The
 * {@link ZZZ Chat} instance object is capable of accepting
 * {@link org.json.simple.JSONObject JSONObject}s or simply calling methods with
 * parameters. There are no major advantages to constructing these objects,
 * except for a few in particular where metadata can be tracked or retrieved.
 * </p>
 * SendableChatHandle @ jchatexchange.util
 *
 * @author Unihedron<<a href="mailto:vincentyification@gmail.com"
 *         >vincentyification@gmail.com</a>>
 */
public interface SendableChatHandle extends ChatHandle {}
