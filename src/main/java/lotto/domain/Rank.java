package lotto.domain;

public enum Rank {

    MISS(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int winningMoney;

    Rank(int matchCount, boolean bonusMatch, int winningMoney) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount < 3) {
            return MISS;
        }

        for (Rank rank : Rank.values()) {
            rank.match(matchCount, bonusMatch);
            return rank;
        }

        return MISS;
    }

    private boolean match(int matchCount, boolean bonusMatch) {
        if (this.matchCount != matchCount) {
            return false;
        }
        if (matchCount != 5) {
            return true;
        }
        return this.bonusMatch == bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }


}
