package taskMapKey;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class FasterMap {

    public static void main(String[] args) {
        FasterMap fm = new FasterMap();
        Map hm = fm.PutMap(new HashMap<>());//1.39-1.49c в лучшем случае О(1)
        Map lhm = fm.PutMap(new LinkedHashMap<>());//1.82-2.01 в лучшем случае О(1) + немного времени на ссылки
        Map tm = fm.PutMap(new TreeMap<>());//2.63-2.77c на основе красно-черного дерева сложность О(log n)


        fm.GetElement(hm);//0.21-0.25c
        fm.GetElement(lhm);//0.14-0.18c
        fm.GetElement(tm);//0.83-0.92c
    }

    private Map PutMap(Map map){
        long start = System.nanoTime();
        for (int i = 0; i<10000000; i++){
            map.put(i,""+i);
        }
        long round = System.nanoTime()-start;
        long convert = TimeUnit.SECONDS.convert(round, TimeUnit.NANOSECONDS);
        System.out.println("Вставка 10^7: "+ map.getClass() + " " + round+ "нс или " + convert + "с");
        return map;
    }

    private void GetElement(Map map){
        long start = System.nanoTime();
        for (int i = 0; i < map.size(); i++){
            map.get(i);
        }
        long round = System.nanoTime()-start;
        long convert = TimeUnit.SECONDS.convert(round, TimeUnit.NANOSECONDS);
        System.out.println("Поиск 10^7: "+ map.getClass() + " " + round+ "мс или " + convert + "с");
    }
}
