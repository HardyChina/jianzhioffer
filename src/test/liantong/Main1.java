package test.liantong;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i].split(":")[0],Integer.valueOf(strings[i].split(":")[1]));
        }
        map = sortByValue(map);
        Set mapSet = map.entrySet();
        for (Object object :mapSet
             ) {
            Map.Entry me=(Map.Entry) object;
            Object key=me.getKey();
            Object value=me.getValue();
            System.out.print((String)key+":"+(Integer)value+" ");

        }
        

    }
    public static LinkedHashMap sortByValue(Map map) {

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //return o1.getValue().compareTo(o2.getValue());//升序
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        LinkedHashMap newMap = new LinkedHashMap();
        Iterator<Map.Entry<String, Integer>> iter = list.iterator();
        Map.Entry tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            newMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }

        return newMap;
    }


}
