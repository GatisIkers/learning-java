package CharacterAppearance;

import java.util.*;

public class Main {
    private static HashMap<Character, Integer> charHashMap = new HashMap<>();
    private static Char[] charArray;
    private static ArrayList<Char> charArrayList = new ArrayList<>();

    public static void main(String[] args) {
        String myString = "My Awesome String!";

        System.out.println("WITH HASHMAP:");
        findCharsWithHashMap(normalizeString(myString));

        System.out.println("\nWITH ARRAYLIST:");
        findCharsWithArrayList(normalizeString(myString));

        System.out.println("\nWITH ARRAY:");
        findCharsWithArray(normalizeString(myString));
    }

    public static void findCharsWithHashMap(char[] chars) {
        for (char character : chars) {
            Integer characterCount = charHashMap.get(character);
            if (characterCount == null) {
                characterCount = 0;
            }

            charHashMap.put(character, characterCount + 1);
        }

        TreeMap<Character, Integer> sorted = new TreeMap<>(charHashMap);
        for (Map.Entry<Character, Integer> entry : sorted.entrySet()) {
            System.out.println("Char: " + entry.getKey() + " - " + entry.getValue() + " times");
        }
    }

    public static void findCharsWithArray(char[] chars) {
        charArray = new Char[getUniqueCharsCountInArray(chars)];

        for (char character : chars) {
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == null) {
                    charArray[i] = new Char(character, 1);
                    break;
                } else if (charArray[i].getTheChar() == character) {
                    charArray[i].incrementCount();
                    break;
                }
            }
        }

        sortArrayWithBubbleSortMethod();
        for (Char aChar : charArray) {
            System.out.println("Char: " + aChar.getTheChar() + " - " + aChar.getCount() + " times");
        }
    }

    public static void findCharsWithArrayList(char[] chars) {
        for (char character : chars) {
            Char myChar = null;
            for (Char aChar : charArrayList) {
                if (aChar.getTheChar() == character) {
                    myChar = aChar;
                    break;
                }
            }

            if (myChar != null) {
                myChar.incrementCount();
            } else {
                charArrayList.add(new Char(character, 1));
            }
        }

        Collections.sort(charArrayList);
        for (Char aChar : charArrayList) {
            System.out.println("Char: " + aChar.getTheChar() + " - " + aChar.getCount() + " times");
        }
    }

    public static char[] normalizeString(String string) {
        return string
                .toLowerCase()
                .replaceAll("\\s+", "")
                .toCharArray();
    }

    public static int getUniqueCharsCountInArray(char[] chars) {
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (chars[i] == chars[j]) break;
            }

            if (i == j) count++;
        }

        return count;
    }

    public static void sortArrayWithBubbleSortMethod() {
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray.length - i - 1; j++) {
                if (charArray[j].getTheChar() > charArray[j + 1].getTheChar()) {
                    Char temp = charArray[j];
                    charArray[j] = charArray[j+1];
                    charArray[j+1] = temp;
                }
            }
        }

    }
}