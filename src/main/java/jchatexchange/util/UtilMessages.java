package jchatexchange.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.github.fge.msgsimple.bundle.MessageBundle;
import com.github.fge.msgsimple.bundle.PropertiesBundle;

class UtilMessages {

    public static MessageBundle bundle;
    private Lock                lock = new ReentrantLock();

    public MessageBundle ex() {
        if (null == bundle)
            if (lock.tryLock())
                try {
                    bundle = PropertiesBundle.forPath("jchatexchange.exceptions");
                }
        finally {
            lock.unlock();
            // Ditch the lock, we'll never need it again.
            lock = null;
        }
            else while (null == bundle)
                ;
        return bundle;
    }

}
