package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        System.out.println("рядки : " + matrix.size() + " парность " + matrix.size()%2);
        System.out.println("стовбці : " + matrix.get(0).size() + " парность " + matrix.get(0).size()%2);

        for(int count = 0; count<r; count++ ) { // Сколько раз будем крутить ввесь масив
            int el = 0; //подставная переменная
            int shorterSide = Math.min(matrix.size(), matrix.get(0).size()); // определяем коротшую сторону
            int recursion=0;
            for(;recursion<(shorterSide/2); recursion++) { // Сколько квадратов внутри масива
                for (int line = (recursion); line < matrix.size() - 1; line++) { // проходимся по каждой строчке масива
                    if (line == recursion) { //первый столбик двегаем вниз
                        el = matrix.get(line).remove(recursion);
                        matrix.get(line + 1).add(recursion, el);
                    } else if (line != matrix.size() - (1 + recursion)) {
                        el = matrix.get(line).remove(1 + recursion);
                        matrix.get(line + 1).add(recursion, el);
                    }
                    if (line != matrix.size() - (1 + recursion)) {//последний столбик двегаем вверх
                        el = matrix.get(line + 1).remove(matrix.get(line + 1).size() - (1 + recursion));
                        matrix.get(line).add(matrix.get(line + 1).size() - (1 + recursion), el);
                    }
                }
            }
             if(matrix.get(0).size() - matrix.size() > 0){ // Рухаємо цент
                el = matrix.get(matrix.size()/2).remove(matrix.get(matrix.size()/2).size() - (1 + recursion));
                System.out.println("ele: " + el);
                matrix.get(matrix.size()/2).add(recursion, el);
            }
        }

//Вывод массива
        System.out.println();
        for(List<Integer> list : matrix) {
            for(Integer num : list ) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}