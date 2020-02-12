package Problem01;

public class Problem01 {
    public static void main(String[] args) {
        HitCount hitCount = HitCount.INSTANCE;

        System.out.println(hitCount.getCount());

        hitCount.hit();
        System.out.println(hitCount.getCount());
    }
}