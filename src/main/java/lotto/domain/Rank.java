package lotto.domain;

public enum Rank {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int numberOfMatches;
    private final boolean hasBonus;
    private final int price;

    Rank(int numberOfMatches, boolean hasBonus, int price) {
        this.numberOfMatches = numberOfMatches;
        this.hasBonus = hasBonus;
        this.price = price;
    }

    public static Rank findByNumberOfMatchesAndHasBonus(int numberOfMatches, boolean hasBonus) {
        for (Rank rank : values()) {
            if (rank.getNumberOfMatches() == numberOfMatches && rank.hasBonus == hasBonus) {
                return rank;
            }
        }
        return null;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrice() {
        return price;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}
