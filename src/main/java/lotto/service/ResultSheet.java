package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultSheet {

    private Map<Rank, Integer> resultSheet = new LinkedHashMap<>();

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
}
