package Problem01;

import java.util.concurrent.atomic.AtomicInteger;

public enum HitCount {
    INSTANCE;

    private AtomicInteger count = new AtomicInteger();

    public void hit() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
