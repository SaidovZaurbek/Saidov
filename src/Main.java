import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);  //считываю значение с консоли

    public static String calc(String input) throws Exception {
        String[] strings = input.split(" "); //вынимаю данные из строки и кладу значения в массив

        //установил условие, при котором выдается ошибка, если введено больше/меньше значений
        if (strings.length!=3 || strings[1]==null || strings[2]==null){
            throw new Exception("Ошибка! Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *), каждый из которых указан через пробел.");
        }

        //присвоил переменным значения из массива, куда поместил введенные данные ранее
        String a = strings[0];
        String b = strings[2];
        String c = strings[1];

        //создал два массива
        String[] chislaArab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] chislaRim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        //ввел данный тип данных, чтобы в дальнейшем с их помощью указать, как необходимо поступить
        boolean X = false;
        boolean Y = false;

        //проверяю относятся ли к арабским числам значения А и В
        for (String i : chislaArab) {
            if (i.equals(a)) {
                for (String z : chislaArab) {
                    if (z.equals(b)) {
                        X = true;
                        break;
                    }
                }
            }
        }

        //проверяю относятся ли к римским числам значения А и В
        for (String i : chislaRim) {
            if (i.equals(a)) {
                for (String z : chislaRim) {
                    if (z.equals(b)) {
                        Y = true;
                        break;
                    }
                }
            }
        }

        if ((!X) && (!Y)) //если оба значения (А и В) не относятся к арабским или римским (от 1 до 10 включительно), выдаю уведомление
        {
            throw new Exception ("Ошибка! Оба значения должны быть римскими или арабскими от 1 до 10 включительно.");
        }

        int A = 0;
        int B = 0;
        int reshenie = 0;

        switch (a) // определение значения А
        {
            case "1", "I":
                A = 1;
                break;
            case "2", "II":
                A = 2;
                break;
            case "3", "III":
                A = 3;
                break;
            case "4", "IV":
                A = 4;
                break;
            case "5", "V":
                A = 5;
                break;
            case "6", "VI":
                A = 6;
                break;
            case "7", "VII":
                A = 7;
                break;
            case "8", "VIII":
                A = 8;
                break;
            case "9", "IX":
                A = 9;
                break;
            case "10", "X":
                A = 10;
                break;
            default:
        }

        switch (b) // определение значения B
        {
            case "1", "I":
                B = 1;
                break;
            case "2", "II":
                B = 2;
                break;
            case "3", "III":
                B = 3;
                break;
            case "4", "IV":
                B = 4;
                break;
            case "5", "V":
                B = 5;
                break;
            case "6", "VI":
                B = 6;
                break;
            case "7", "VII":
                B = 7;
                break;
            case "8", "VIII":
                B = 8;
                break;
            case "9", "IX":
                B = 9;
                break;
            case "10", "X":
                B = 10;
                break;
            default:
        }

        switch (c) // определение действия
        {
            case "+":
                reshenie = A + B;
                break;
            case "-":
                reshenie = A - B;
                break;
            case "*":
                reshenie = A * B;
                break;
            case "/":
                reshenie = A / B;
                break;
            default:
                throw new Exception ("Введено неверное действие (+,-,/,*)!");
        }

        //если оба значения относятся к римским числам, то необходимо преобразовать ответ
        if (Y)
        {
            //условие, чтобы при вводе римских значений ответ не был меньше 1
            if(reshenie>=1)
            {
                String [] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                        "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                        "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                        "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                        "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV",
                        "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI",
                        "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                        "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                        "XCVIII", "XCIX", "C"};
                return rim[reshenie-1];
            } else {
                throw new Exception ("При решении было получено значение меньше 1, что не допустимо при использовании римских чисел!");
            }
        }
        return String.valueOf(reshenie);
    }
    public static void main(String[] args) throws Exception {
        System.out.println(calc(in.nextLine())); //выполняю код calc(), передавая значение того, что ввёл пользователь в консоли
    }
}