package medium;

public class ManReturnToOrigin {

    public static void main(String[] args) {
        // U D L R
        boolean pos = judgeCircle("UDLL");
        boolean pos1 = judgeCircle("LRUD");
        System.out.println(pos);
        System.out.println(pos1);
    }
    static boolean judgeCircle(String moves){
        int x = 0;
        int y = 0;
        if (moves.isEmpty() || moves.isBlank()) return true;
        for(Character character : moves.toCharArray()){
            if(character.equals('U')) {
                y += 1;
            }
            else if(character.equals('D')) {
                y -= 1;
            }
            else if(character.equals('R')) {
                x += 1;
            }
            else if(character.equals('L')) {
                x -= 1;
            }
        }
        return (x==0 && y==0);
    }
}
