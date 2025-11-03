package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ResultSheet {

    private final Map<Rank, Integer> resultSheet = new LinkedHashMap<>();

    public ResultSheet() {
        resultSheet.put(Rank.FIFTH, 0);
        resultSheet.put(Rank.FOURTH, 0);
        resultSheet.put(Rank.THIRD, 0);
        resultSheet.put(Rank.SECOND, 0);
        resultSheet.put(Rank.FIRST, 0);
    }

    public Map<Rank, Integer> getResultSheet() {
        return resultSheet;
    }

    public void increase(Rank rank) {
        resultSheet.put(rank, resultSheet.get(rank) + 1);
    }

    public int calculateProceeds() {
        int proceeds = 0;
        for (Entry<Rank, Integer> entry : resultSheet.entrySet()) {
            proceeds += entry.getKey().getPrice() * entry.getValue();
        }
        return proceeds;
    }
}
