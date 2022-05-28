package medium;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String s ="ab#d";
        String d ="ac#d";
        String f ="ac#f";
        boolean tru = backspaceCompare(s, d);
        boolean fal = backspaceCompare(s ,f);
        System.out.println(tru);
        System.out.println(fal);
    }

    private static boolean backspaceCompare(String oneString, String twoString) {
        int lenOne = oneString.length() - 1;
        int lenTwo = twoString.length() - 1;
        int oneSkip = 0;
        int twoSkip = 0;
        while (lenOne >= 0 || lenTwo>=0) {
            while (lenOne >= 0) {
                if (oneString.charAt(lenOne) == '#') {
                    oneSkip += 1;
                    lenOne = -1;
                } else if (oneSkip > 0) {
                    lenOne -= 1;
                    oneSkip -= 1;
                } else {
                    break;
                }
            }

            while (lenTwo >= 0) {
                if (twoString.charAt(lenTwo) == '#') {
                    twoSkip += 1;
                    lenTwo = -1;
                } else if (twoSkip > 0) {
                    lenTwo -= 1;
                    twoSkip -= 1;
                } else {
                    break;
                }
            }
        }
        if(oneSkip >= 0 && twoSkip>=0 && oneString.charAt(lenOne) != twoString.charAt(lenTwo)) return false;
        oneSkip -= -1;
        twoSkip -= -1;
        return true;
    }
}
