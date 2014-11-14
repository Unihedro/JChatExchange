package jchatexchange.room;

import java.lang.ref.WeakReference;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public final class SEChat {

    private static final PopulatedEnumMap map = new PopulatedEnumMap();

    public final int                      id;
    String                                dir;
    public final String                   rootUrl;
    String                                loginUrl;

    public String getUrl() {
        if (null != dir)
            return dir;
        return dir = rootUrl + id;
    }

    public String getLoginUrl() {
        if (null != loginUrl)
            return loginUrl;
        return loginUrl = rootUrl + "users/login";
    }

    private SEChat(String dir, int id) {
        rootUrl = dir;
        this.id = id;
    }

    static SEChat of(SESite key, int id) {
        Set<WeakReference<SEChat>> set = map.get(key);
        Iterator<WeakReference<SEChat>> iterator = set.iterator();
        while (iterator.hasNext()) {
            WeakReference<SEChat> next = iterator.next();
            if (next.get() == null)
                iterator.remove();
            else if (next.get().id == id)
                return next.get();
        }
        SEChat obj = new SEChat(key.dir, id);
        set.add(new WeakReference<SEChat>(obj) {

            @Override
            public int hashCode() {
                return obj.hashCode();
            }

        });
        return obj;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        return ((SEChat) object).hashCode() == hashCode();
    }

}

class PopulatedEnumMap extends EnumMap<SESite, Set<WeakReference<SEChat>>> {

    PopulatedEnumMap() {
        super(SESite.class);
    }

    public Set<WeakReference<SEChat>> get(SESite key) {
        Set<WeakReference<SEChat>> get = super.get(key);
        if (get != null)
            return get;
        put(key, get = new TreeSet<WeakReference<SEChat>>());
        return get;
    }

}
