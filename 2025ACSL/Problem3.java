public class Problem3 {
    static String findTime(char c1, char c2, char c3, char c4, char c5) {
        char[] colors = { c1, c2, c3, c4, c5 };
        int[] deltas = { 1, 1, 2, 3, 5 };
        int hour = 0;
        int minute = 0;
        for (int i = 0; i < 5; i++) {
            hour++;
            addHour(colors[i], deltas[i]);
            minute += addMinute(colors[i], deltas[i]);
        }
        minute *= 5;
        String strHour = Integer.toString(hour);
        String strMinute = Integer.toString(minute);
        if (hour < 10) {
            strHour = "0" + strHour;
        }
        if (minute < 10) {
            strMinute = "0" + strMinute;
        }
        return strHour + ":" + strMinute;
    }

    static int addHour(char color, int delta) {
        if (color == 'R' || color == 'B') {
            return delta;
        }
        return 0;
    }

    static int addMinute(char color, int delta) {
        if (color == 'G' || color == 'B') {
            return delta;
        }
        return 0;
    }

    public static void main(String[] args) {
        //
        String result = findTime('G', 'R', 'W', 'B', 'B');
        System.out.println(result);
    }
}