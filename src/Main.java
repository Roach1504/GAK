import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {


    // _________ЧИСЛА________

    // считывание из файла чисел
    public static ArrayList<Integer> fileToInteger() {
        ArrayList<Integer> ch = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("D://eclipse/workspace/Code/src/1.txt"))) {
            String s = "";
            while ((s = in.readLine()) != null)
                for (String r : s.split(" ")) {
                    ch.add(Integer.parseInt(r));
                }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return ch;
    }

    // поиск среднего значения
    static double sred(ArrayList<Integer> ch) {
        double sr = 0;
        for (int i : ch) {
            sr += i;
        }
        sr = sr / ch.size();
        return sr;
    }

    // поиск наименьшего отличия от среднего значения
    static double naim_otl(ArrayList<Integer> ch, double sr) {
        double naim = Math.abs(ch.get(0) - sr);
        for (int i = 1; i < ch.size(); i++) {
            if (Math.abs(ch.get(i) - sr) < naim)
                naim = Math.abs(ch.get(i) - sr);
        }
        return naim;
    }

    // удаление наименьшего отличия от среднего
    static void del_otl(ArrayList<Integer> ch, double sr, double otl) {
        for (int i = 0; i < ch.size(); i++) {
            if (Math.abs(ch.get(i) - sr) == otl) {
                ch.remove(i);
                i--;
            }
        }
        System.out.println(ch);
    }

    // удаление повторов чисел
    static ArrayList<Integer> notRepeatInteger(ArrayList<Integer> str) {
        HashSet<Integer> hs = new HashSet<>(str);
        ArrayList<Integer> s = new ArrayList<>(hs);
        return s;
    }

    // сортировка чисел пузырьком
    static void bubbleSort(ArrayList<Integer> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int t = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, t);
                }
            }
        }
    }

    // поиск первого вхождения числа с выводом позиции
    static Integer findInteger(ArrayList<Integer> arr, int f) {
        int pos = 0;
        for (int i : arr) {
            if (i == f)
                return pos;
            else
                pos++;
        }
        return (Integer) null;
    }

    // проверка на однозначность числа
    static boolean odnoz(Integer ch) {
        String s = ch.toString();
        if (s.length() > 1)
            return false;
        else
            return true;
    }

    // проверка на четность цифр
    static boolean chetNum(Integer ch) {
        char[] s = ch.toString().toCharArray();
        int n = 0;
        for (int i : s) {
            if (((i - 48) % 2 == 0) && (i != 48))
                n++;
            System.out.println(i);
        }
        if(n == s.length)
            return true;
        else
            return false;
    }
    // проверка на четность цифры v2.0
    static boolean chetNum2(Integer ch){
        int ch1 = Math.abs(ch);
        while(ch1>10){
            int ost = ch1%10;
            if((ost%2)>0){
                return false;
            }
            ch1 = ch1/10;
        }
        if(ch1%2>0){
            return false;
        }
        return true;
    }

    // проверка на различность цифр в числе
    static boolean razlichChisla(Integer ch) {
        char[] a = ch.toString().toCharArray();
        HashSet<String> c = new HashSet<>();
        for (char k : a) {
            c.add(String.valueOf(k));
        }
        if (c.size() == a.length)
            return true;
        else
            return false;
    }

    // проверка на цифры по возрастанию
    static boolean vozrastChisla(Integer ch) {
        char[] a = ch.toString().toCharArray();
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                return false;
        }
        return true;
    }

    // проверка на простоту числа
    static boolean isprime(int n) {
        if (n == 1)
            return false;
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0)
                return false;
        }
        return true;
    }

    // проверка на число фибоначчи
    static boolean fib(int n) {
        int fib = 0;
        int a = 1;
        int b = 1;
        int i = 0;
        while (i < n && fib <= n) {
            fib = a + b;
            if (fib == n)
                return true;
            a = b;
            b = fib;
            i++;
        }
        return false;
    }

    // _____________СТРОКИ__________

    // считывание из файла строк
    public static ArrayList<String> fileToString() {
        ArrayList<String> ch = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("D://eclipse/workspace/Code/src/1.txt"))) {
            String s = "";
            while ((s = in.readLine()) != null)
                ch.add(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ch;
    }

    // разделение строки на слова
    static ArrayList<String> splitString(String str) {
        ArrayList<String> s = new ArrayList<>();
        for (String i : str.split(" "))
            s.add(i);
        return s;
    }

    // поиск первого вхождения слова с выводом позиции
    static Integer findString(ArrayList<String> arr, String f) {
        int pos = 0;
        for (String i : arr) {
            if (i == f)
                return pos;
            else
                pos++;
        }
        return (Integer) null;
    }

    // сортировка строки по длинне слов
    static void stringSort(ArrayList<String> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j).length() > arr.get(j + 1).length()) {
                    String t = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, t);
                }
            }
        }
    }

    // проверка на полиндром
    static boolean polindrom(String str) {
        int n = 0;
        for (int k = 0; k < str.length() / 2; k++) {

            if (str.charAt(k) == str.charAt((str.length() - 1 - k))) {
                n++;
            }
        }
        if (n == str.length() / 2)
            return true;
        else
            return false;
    }

    // удаление повторов слов
    static ArrayList<String> notRepeatString(ArrayList<String> str) {
        HashSet<String> hs = new HashSet<>(str);
        ArrayList<String> s = new ArrayList<>(hs);
        return s;
    }

    // поиск буквы в слове
    static boolean findLetter(String str,String let){
        for (int k = 0; k < str.length(); k++) {
            if (str.charAt(k)==let.charAt(0)){
                return true;
            }
        }
        return false;
    }

    //удаления лишних пробелов
    static String delProbel(String str){
        char[] ch = str.toCharArray();
        String rez = "";
        int flag = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != ' '){
                rez = rez + ch[i];
                flag = 0;
            }
            else{
                flag++;
            }
            if(flag==1){
                rez = rez + " ";
            }
        }
        return rez;
    }

    //проверка на наличие слова в слове
    static boolean findStringToSring(String str, String str1){
        if(str1.length()>str.length()){
            return false;
        }
        else{
            String[] ss = str.split(str1);
            if(ss[0].equals(str)){
                return false;
            }
            else{
                return true;
            }
        }
    }

    //сортировка по алфавиту
    static void sortAlfavit(ArrayList<String> arr){
        Collections.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(arr);
    }
    public static void main(String[] args) {
        String probel = "abs";
        String probel1 = "bsa";

        ArrayList<String> ff = new ArrayList<String>();
        ff.add("a");
        ff.add("a");
        ff.add("b");
        ff.add("bc");
        ff.add("ba");
        ff.add("bas");
        ff.add("abf");
        ff.add("df");
        System.out.println(ff);
        sortAlfavit(ff);
    }
}
