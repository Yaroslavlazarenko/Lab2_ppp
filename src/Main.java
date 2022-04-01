public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    /**
     * Дана последовательность вещественных чисел а1, а2, ..., an. Выяснить, является ли она возрастающей.
     */
    private static void task1() {
        final byte N = 5;
        float number1 = (float) (Math.random() * 50 - 25), number2;
        boolean increasing = true;

        //рандомайзер чисел и сразу проверка на возрастающую последовательность
        for (byte i = 1; i <= N; i++) {
            number2 = (float) (Math.random() * 50 - 25);
            if (number2 > number1)
                number1 = number2;
            else {
                increasing = false;
                break;
            }
        }

        //вывод результатов
        if (increasing)
            System.out.println("Последовательность возрастающая");
        else
            System.out.println("Последоватьность не возрастающая");
    }

    /**
     * Сформировать массив простых чисел, не превышающих заданное натуральное число N.
     */
    private static void task2() {
        short N = 24,k=0;
        boolean[] a = new boolean[N];
        short[] Array = new short[N/2];

        for (short i = 2; i<N; i++)
            a[i] = true;

        for (short i = 2; i<N; i++)
            for (int j = i; j*i < N; j++)
                a[i*j] = false;

        for (short i = 2; i < N; i++)
            if (a[i]) {
                Array[k]=i;
                System.out.print(Array[k] + " ");
                k++;
            }
    }

    /**
     * Известны оценки по информатике 28 учеников класса. Выяснить, есть ли среди них двойки и сколько.
     */
    private static void task3() {
        byte grade, deuces = 0;

        //расчет оценок и подсчет двоек
        for (byte i = 1; i <= 28; i++) {
            grade = (byte) (Math.random() * 5 + 1);
            System.out.print(grade + " ");
            if (grade == 2)
                deuces++;
        }

        //вывод результатов
        System.out.println();
        if (deuces > 0)
            System.out.println("Двоек: " + deuces);
        else
            System.out.println("Двоек нет");
    }

    /**
     * Удалить элемент одномерного массива целых чисел M[n], удовлетворяющий условию: D[i] = 2D[i + 1].
     * Если таких элементов нет, выдать сообщение «элементы для удаления не найдены», иначе удалить первый из найденных.
     */
    private static void task4() {
        byte N = 25;
        short[] Array = new short[N];
        boolean completed = false;

        //заполнение массива и сразу поиск подходящего числа с последующей его заменой и сдвигом
        Array[0] = (short) (Math.random() * 200 - 100);
        for (byte i = 1; i < N; i++) {
            Array[i] = (short) (Math.random() * 200 - 100);
            if (Array[i - 1] == 2 * Array[i] && !completed) {
                Array[i - 1] = Array[i];
                i--;
                N--;
                completed = true;
            }
        }

        //вывод результатов
        if (!completed)
            System.out.println("элементы для удаления не найдены");
        else
            System.out.println("число удалено");
    }

    /**
     * Дана последовательность вещественных чисел а1 ≤ а2 ≤ ... ≤ аn. Вставить в нее вещественное число b так,
     * чтобы последовательность осталась неубывающей.
     */
    private static void task5() {
        final byte N = 10;
        final float b = 80;
        float[] Array = new float[N + 1];

        //создание возростающей последовательности
        Array[0] = -100;
        System.out.print(Array[0] + " ");
        for (byte i = 1; i < N; i++) {
            do
                Array[i] = (float) (Math.random() * 200 - 100);
            while (Array[i] <= Array[i - 1]);
            System.out.print(Array[i] + " ");
        }

        //замена елемента и сдвиг
        System.out.println();
        for (int i = 1; i < N; i++) {
            if (b >= Array[i - 1] && b <= Array[i]) {
                for (byte copy = N; copy > i; copy--)
                    Array[copy] = Array[copy - 1];
                Array[i] = b;
                break;
            }
        }

        //вывод измененноого массива
        for (float i : Array)
            System.out.print(i + " ");
    }
}