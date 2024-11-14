public class Main {
    public static void main(String[] args) throws Exception {
        String text1 = "Привет, мир! Как дела? 123";
        String text2 = "abcde123fghijkl";
        String text3 = "  ";
        String text4 = "12345";

        System.out.println("Текст: " + text1 + ". Подстрока: " + findLongestNonLetterSubstring(text1));
        System.out.println("Текст: " + text2 + ". Подстрока: " + findLongestNonLetterSubstring(text2));
        System.out.println("Текст: " + text3 + ". Подстрока: " + findLongestNonLetterSubstring(text3));
        System.out.println("Текст: " + text4 + ". Подстрока: " + findLongestNonLetterSubstring(text4));
    }

    public static String findLongestNonLetterSubstring(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;
        int currentLength = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!Character.isLetter(ch)) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    start = i - currentLength;
                    end = i;
                }

                currentLength = 0;
            }
        }


        if (currentLength > maxLength) {
            maxLength = currentLength;
            start = text.length() - currentLength;
            end = text.length();
        }

        return text.substring(start, end);
    }
}
