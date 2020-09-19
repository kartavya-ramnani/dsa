package pointers;

// Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
public class StringContainingBackspaces {

    public static boolean isEqual(String a, String b) {

        int aEnd = a.length() - 1;
        int bEnd = b.length() - 1;
        boolean isEqual = true;

        while (aEnd >= 0 || bEnd >= 0) {
            if (a.charAt(aEnd) == '#') {
                int countBackspaces = 1;
                aEnd--;
                while (aEnd >= 0 && a.charAt(aEnd) == '#') {
                    countBackspaces++;
                    aEnd--;
                }
                for (int i = 0; i < countBackspaces; i++) {
                    aEnd--;
                }
                if (aEnd < 0) {
                    break;
                }
            }
            if (b.charAt(bEnd) == '#') {
                int countBackspaces = 1;
                bEnd--;
                while (bEnd >= 0 && b.charAt(bEnd) == '#') {
                    countBackspaces++;
                    bEnd--;
                }
                for (int i = 0; i < countBackspaces; i++) {
                    bEnd--;
                }
                if (bEnd < 0) {
                    break;
                }
            }
            if (b.charAt(bEnd) != a.charAt(aEnd)) {
                return false;
            }
            aEnd--;
            bEnd--;
        }

        if (aEnd != bEnd) {
            isEqual = false;
        }

        return isEqual;
    }

    public static void main(String[] args) {
        System.out.println("IsSame : " + StringContainingBackspaces.isEqual("xy#z", "xzz#"));
        System.out.println("IsSame : " + StringContainingBackspaces.isEqual("xy#z", "xyz#"));
        System.out.println("IsSame : " + StringContainingBackspaces.isEqual("xp#", "xyz##"));
        System.out.println("IsSame : " + StringContainingBackspaces.isEqual("xywrrmp", "xywrrmu#p"));

    }
}
