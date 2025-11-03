package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class ResultSheet {

    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public ResultSheet() {
        for (Rank rank : Rank.values()) {
            counts.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getCounts() {
        return Collections.unmodifiableMap(counts);
    }

    public void increase(Rank rank) {
        counts.put(rank, counts.get(rank) + 1);
    }

    public long calculateProceeds() {
        long proceeds = 0L;
        for (Rank rank : Rank.values()) {
            Integer count = counts.get(rank);
            proceeds += (long) rank.getPrice() * count;
        }
        return proceeds;
    }

    public int getCount(Rank rank) {
        return counts.get(rank);
    }
}
