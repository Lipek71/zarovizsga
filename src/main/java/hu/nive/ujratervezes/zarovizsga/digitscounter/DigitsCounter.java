package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.TreeMap;

public class DigitsCounter {

    public int getCountOfDigits(String s){

        final String NUMBERS = "0123456789";
        TreeMap<String, Integer> map = new TreeMap();

        if (s == null || s.isEmpty()){
            return 0;
        }

        for (int i = 0; i < s.length(); i++){
            if(NUMBERS.contains(s.substring(i,i+1))){
                map.put(s.substring(i,i+1),0);
            }
        }

        return map.size();
    }
}
