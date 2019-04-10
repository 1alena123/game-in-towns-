import java.io.IOException;
import java.util.*;
import java.io.*;

public class Game {

    private static ArrayList<String> towns = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        try {
            final BufferedReader in = new BufferedReader(new FileReader("src\\города.txt"));
            for (String city; (city = in.readLine()) != null; ) {
                towns.add(city);
            }
            in.close();
        }catch (IOException e) {
            e.printStackTrace();
        }


        //////////////////////////////////////////////////////////////////////

        char lastChar;
        char firstChar;
        int idx = new Random().nextInt(towns.size());

        System.out.println("Игра началась!");

        String A = (towns.get(idx));
        String B;
        System.out.println("1 игрок - " + A);
        lastChar = getLastChar(A);
        System.out.println("Последняя буква " + lastChar);
        towns.remove(A);
        while(true) {

            for (int i = 0; i < towns.size(); i++) {
                B = towns.get(i);
                firstChar = getFirstChar(B);
                if (firstChar == lastChar) {
                    System.out.println("2 игрок  " + B);
                    lastChar = getLastChar(B);
                    towns.remove(B);
                    break;
                }
            }

            System.out.println("Последняя буква " + lastChar);
            if(!isConsistWordWithFirstChar(lastChar)){
                System.out.println("Игра окончена выиграл игрок 1"); break;
            }



            for (int i = 0; i < towns.size(); i++) {
                B = towns.get(i);
                firstChar = getFirstChar(B);
                if (firstChar == lastChar) {
                    System.out.println("1 игрок  " + B);
                    lastChar = getLastChar(B);
                    towns.remove(B);
                    break;
                }

            }
            System.out.println("Последняя буква " + lastChar);
            if(!isConsistWordWithFirstChar(lastChar)){
                System.out.println("Игра окончена выиграл игрок 2"); break;
            }

        }
    }


    public static Character getFirstChar(String city) {
        return city.charAt(0);
    }


    public static Character getLastChar(String city) {
        int pos = city.length() - 1;
        char lastChar = city.toUpperCase().charAt(pos);
        if (city.toUpperCase().charAt(pos) == 'Й') {
            return 'И';
        }
        if (lastChar == 'Ь' || lastChar == 'Ы' || lastChar == 'Ъ') {
            pos--;
        }
        return city.toUpperCase().charAt(pos);
    }

    public static boolean isConsistWordWithFirstChar(char word)
    {
        for (int i = 0; i < towns.size(); i++) {

            if(getFirstChar(towns.get(i)) == word)
            {
                return true;
            }
        }
        return false;
    }
}