package lotto;

import java.text.NumberFormat;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    MISS(0, 0, "꽝");

    private static final List<LottoRank> PRINTABLE_RANKS = List.of(
            FIFTH, FOURTH, THIRD, SECOND, FIRST
    );

    private final int matchCount;
    private final int winnings;
    private final String description;

    LottoRank(int matchCount, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.winnings = prizeMoney;
        this.description = description;
    }

    public int getWinnings() {
        return winnings;
    }

    public String getDescription() {
        return description;
    }

    public String getFormattedPrizeMoney() {
        return NumberFormat.getInstance().format(winnings);
    }

    public static List<LottoRank> getPrintableRanks() {
        return PRINTABLE_RANKS;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS;
    }
}