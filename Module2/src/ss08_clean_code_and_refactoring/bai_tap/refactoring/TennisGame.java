package ss08_clean_code_and_refactoring.bai_tap.refactoring;

public class TennisGame {

    public static final String SCORE_0 = "Love";
    public static final String SCORE_1 = "Fifteen";
    public static final String SCORE_2 = "Thirty";
    public static final String SCORE_3 = "Forty";
    public static final String DRAW_0 = "Love-All";
    public static final String DRAW_1 = "Fifteen-All";
    public static final String DRAW_2 = "Thirty-All";
    public static final String DRAW_3 = "Forty-All";
    public static final String DRAW = "Deuce";
    public static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    public static final String PLAYER1_WIN = "Win for player1";
    public static final String PLAYER2_WIN = "Win for player2";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String result = "";
        if (player1Score==player2Score)
        {
            result = checkDraw(player1Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            result = checkAdvantageAndWin(player1Score, player2Score);
        }
        else
        {
            result = checkScore(player1Score, player2Score, result);
        }
        return result;
    }

    private static String checkScore(int player1Score, int player2Score, String result) {
        int tempScore;
        for (int playerID = 1; playerID<=2; playerID++)
        {
            if (playerID==1) {
                tempScore = player1Score;
            }
            else {
                result +="-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    result += SCORE_0;
                    break;
                case 1:
                    result += SCORE_1;
                    break;
                case 2:
                    result += SCORE_2;
                    break;
                case 3:
                    result += SCORE_3;
                    break;
            }
        }
        return result;
    }

    private static String checkAdvantageAndWin(int player1Score, int player2Score) {
        String result;
        int minusResult = player1Score - player2Score;
        if (minusResult==1) {
            result = ADVANTAGE_PLAYER1;
        }
        else if (minusResult ==-1) {
            result = ADVANTAGE_PLAYER2;
        }
        else if (minusResult>=2) {
            result = PLAYER1_WIN;
        }
        else {
            result = PLAYER2_WIN;
        }
        return result;
    }

    private static String checkDraw(int player1Score) {
        String result;
        switch (player1Score)
        {
            case 0:
                result = DRAW_0;
                break;
            case 1:
                result = DRAW_1;
                break;
            case 2:
                result = DRAW_2;
                break;
            case 3:
                result = DRAW_3;
                break;
            default:
                result = DRAW;
                break;

        }
        return result;
    }
}