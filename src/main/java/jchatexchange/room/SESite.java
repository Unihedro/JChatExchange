package jchatexchange.room;

public enum SESite {
    STACK_OVERFLOW("stackoverflow"),
    STACK_EXCHANGE("stackexchange"),
    META_STACK_EXCHANGE("meta." + STACK_EXCHANGE.dir);

    final String dir;

    SESite(String dir) {
        this.dir = "https://" + dir + ".com/";
    }

    public SEChat getRoom(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("id must be a positive number.");
        return SEChat.of(this, id);
    }

}
