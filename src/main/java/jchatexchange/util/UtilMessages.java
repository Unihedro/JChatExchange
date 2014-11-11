package jchatexchange.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.bundle.PropertiesBundle;
import com.github.fge.msgsimple.load.MessageBundleLoader;

/**
 * This class supplies a {@link com.github.fge.msgsimple.bundle.MessageBundle
 * MessageBundle} for messages used by the objects in the <tt>util</tt> package.<br>
 * UtilMessages @ jchatexchange.util
 *
 * @author Unihedron<<a href="mailto:vincentyification@gmail.com"
 *         >vincentyification@gmail.com</a>>
 */
class UtilMessages implements MessageBundleLoader {

    public static MessageBundle bundle;
    private Lock                lock = new ReentrantLock();

    public MessageBundle getBundle() {
        if (null != bundle)
            init();
        return bundle;
    }

    private void init() {
        if (lock.tryLock())
            try {
                bundle = PropertiesBundle.forPath("jchatexchange.exceptions");
            }
            finally {
                lock.unlock();
                // Ditch the lock, it's not needed.
                lock = null;
            }
        else lock.lock();
    }

}
