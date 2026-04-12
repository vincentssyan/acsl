import java.io.*;;
class Result {

    public static String verifyPlate(String plate, String day) {
        // Valid plate: 
        // 1. 7 <= length <=8 AND
        // 2. letterCount>0 & numberCounter>0  AND
        // 3.  symbolCount = 0 except "." AND 
        // 4. plate[0] is letter AND
        // 5. dotCount = 1 &U plate[1]='.'
        Boolean valid = (plate!=null) && 
                        (plate.length()<=8 && plate.length()>=7) && 
                        (Character.isLetter(plate.charAt(0)) && plate.charAt(1)=='.'); 
        if(!valid) 
            return "Invalid";

        int letterCount = 0;
        int numberCount = 0;
        int symbolsCount = 0;
        String lettersFound = "";
        String numbersFound = "";
        for (int i = 0; i < plate.length(); i++) {
            if(i==1)
                continue; // skip "."
            char c = plate.charAt(i);
            if (Character.isLetter(c)) {
                letterCount++;
                lettersFound += c + " ";
            } else if (Character.isDigit(c)) {
                numberCount++;
                numbersFound += c + " ";
            } else {
                symbolsCount++;
            }
        }
        valid = letterCount>0 && numberCount>0 && symbolsCount==0; 
        if(!valid) 
            return "Invalid";

        // LUCKY RULE (repeated 6,8,9)
        int count6 = 0, count8 = 0, count9 = 0;
        for (int i = 0; i < plate.length(); i++) {
            char c = plate.charAt(i);
            if (c == '6')
                count6++;
            else if (c == '8')
                count8++;
            else if (c == '9')
                count9++;
        }
        if (count6 > 1 || count8 > 1 || count9 > 1)
            return "lucky";

        // FORTUNATE RULE (3 consecutive numbers or letters)
        for (int i = 0; i < plate.length() - 2; i++) {
            char c1 = plate.charAt(i);
            char c2 = plate.charAt(i + 1);
            char c3 = plate.charAt(i + 2);
            // number sequence
            if (Character.isDigit(c1) && c2 == c1 + 1 && c3 == c2 + 1)
                return "fortunate";
            // letter sequence
            if (Character.isLetter(c1) && Character.isLetter(c2) && Character.isLetter(c3)) {
                char l1 = Character.toLowerCase(c1);
                char l2 = Character.toLowerCase(c2);
                char l3 = Character.toLowerCase(c3);
                if (l2 == l1 + 1 && l3 == l2 + 1)
                    return "fortunate";
            }
        }

        int total = letterCount + numberCount;
        // BLUE (has to have 7 digits) RESTRICTED(If the lst digits of blue is a odd number)
        if (total == 8 || total == 6) {
            char lastChar = plate.charAt(plate.length() - 1);
            if (Character.isDigit(lastChar)) {
                int digit = lastChar - '0';
                if (digit % 2 != 0)
                    return "restricted";
            } else if (Character.isLetter(lastChar)) {
                int pos = Character.toLowerCase(lastChar) - 'a';
                if (pos % 2 != 0)
                    return "restricted";
            }
            return "blue";
        }

        // GREEN (There are 8 digits)
        if (total == 7)
            return "green";

        return "Letters (" + letterCount + "): " + lettersFound + " | Numbers (" + numberCount + "): " + numbersFound;
    }
}


public class Contest2 {

    public static void main(String[] args) throws IOException {

        String day = "Monday";

        // test cases
        // String plate = "F.53A12";
        // String plate = "P.GG123";
        // String plate = "P.GA513";
        // String plate = "";
        // String plate = "afasdfw 2@#$!@#$!$%@#%!a55a4faafa";
        // String plate = "    ";
        // String plate = "1.ABCD5";
        // String plate = "A.AAAAA1";

        String plate = "A.BB1234111111111";

        String result = Result.verifyPlate(plate, day);

        System.out.println(result);
    }
}