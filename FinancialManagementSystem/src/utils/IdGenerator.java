package utils;

import java.util.HashMap;

public class IdGenerator {
    private static IdGenerator instance;
    private static Object mutex = new Object();
    private HashMap<String, Integer> store;

    private IdGenerator() {
        store = new HashMap<>();
    }

    public static int next() {
        return next("DEFAULT");
    }

    public static int next(String tag) {
        var result = getInstance().store.get(tag);
        if (result == null) {
            synchronized (mutex) {
                result = getInstance().store.get(tag);
                if (result == null) {
                    getInstance().store.put(tag, 0);
                    result = getInstance().store.get(tag);
                }
            }
        }
        synchronized (mutex) {
            getInstance().store.put(tag, result + 1);
        }
        return result + 1;
    }

    private static IdGenerator getInstance() {
        var result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new IdGenerator();
                }
            }
        }

        return result;
    }
}
