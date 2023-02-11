import java.util.*;

public class Main {
    public static void main(String[] args) {
        // ex0(20);
        // ex1();
        ex2();
    }

    static void ex0(int n) {
        System.out.print("\nЗадание 1. Пусть дан произвольный список целых чисел, удалить из него четные числа.\n");

        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println("Начальный массив -> " + list);

        List<Integer> list2 = new ArrayList<>();

        for (int item : list) {
            if (item % 2 != 0) {
                list2.add(item);
            }
        }
        System.out.println("Итоговый массив -> " + list2);
    }

    static void ex1() {
        System.out.print("\nЗадание 2. Задан целочисленный список ArrayList. Найти минимальное, " +
                "максимальное и среднее арифметическое из этого списка. Collections.max().\n");

        List<Integer> list = Arrays.asList(63, 25, 33, 15, 54, 2, 57, 29, 98, 42, 27, 50, 31, 16, 73, 46, 83);
        System.out.println("Заданный массив -> " + list);

        double sum = 0;
        for (int item : list) {
            sum += item;
        }

        double average = sum / list.size();

        System.out.println("Минимальное значение -> " + Collections.min(list));
        System.out.println("Максимальное значение -> " + Collections.max(list));
        System.out.printf("Среднее арифметическое -> %.2f\n", average);
    }

    static void ex2() {


        System.out.print("\nЗадание 3. Реализовать алгоритм сортировки слиянием.\n");

        int[] arr = new int[]{63, 25, 33, 15, 54, 2, 57, 29, 98, 42, 27, 50, 31, 16, 73, 46, 83};
        System.out.println("Заданный массив -> " + Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        System.out.println("Отсортированный массив -> " + Arrays.toString(arr));
    }

    static void sort(int[] array, int start, int end) {
        if (end > start) {
            int middle = (start + end) / 2;
            sort(array, start, middle);
            sort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    static void merge(int[] ar, int st, int mid, int en) {
        int[] arNew = new int[en + 1 - st];
        for (int i = st, j = mid + 1, k = 0; k < arNew.length - 1; k++) {
            if (ar[i] > ar[j]) {
                arNew[k] = ar[j];
                if (j != en) {
                    j++;
                }
            } else {
                arNew[k] = ar[i];
                if (i != mid) {
                    i++;
                }
            }
        }

        if (ar[mid] > ar[en]) {
            arNew[arNew.length - 1] = ar[mid];
        } else {
            arNew[arNew.length - 1] = ar[en];
        }

        for (int l = 0, m = st; l < arNew.length; l++, m++) {
            ar[m] = arNew[l];
        }
    }
}