package lotto.service;

public enum Rank {
    FIRST(6,2000000000),SECOND(5,30000000),
    THIRD(5,1500000), FOURTH(4,50000), FIFTH(3, 5000);

    private final int numberOfMatches;
    private final int price;

    Rank(int numberOfMatches, int price) {
        this.numberOfMatches = numberOfMatches;
        this.price = price;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrice() {
        return price;
    }
}
