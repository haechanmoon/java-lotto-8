package lotto.domain;

public enum Rank {


    MISS(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int countOfMatch;
    private final boolean matchBonus;
    private final int winningMoney;

    Rank(int countOfMatch, boolean matchBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    private boolean match(int countOfMatch, boolean matchBonus) {
        if (this.countOfMatch != countOfMatch) {
            return false;
        }
        if (countOfMatch != 5) {
            return true;
        }
        return this.matchBonus == matchBonus;
    }


    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }

        for (Rank rank : values()) {
            if (rank.match(matchCount, matchBonus)) {
                return rank;
            }
        }

        return MISS;
    }

    public int getMatchCount() {
        return this.countOfMatch;
    }

    public boolean isMatchBonus() {
        return this.matchBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
