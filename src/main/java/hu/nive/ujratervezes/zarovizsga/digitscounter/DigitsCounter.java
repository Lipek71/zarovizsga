package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class DigitsCounter {

    public int getCountOfDigits(String s){

        final String NUMBERS = "0123456789";
        //TreeMap<String, Integer> map = new TreeMap();
        Set<Character> set = new HashSet<>();
        if (s == null || s.isEmpty()){
            return 0;
        }

        for (int i = 0; i < s.length(); i++){
            //if(NUMBERS.contains(s.substring(i,i+1))){
            //    map.put(s.substring(i,i+1),0);
            //}
            if(Character.isDigit(s.charAt(i))){
                set.add(s.charAt(i));
            }
        }

        //return map.size();
        return set.size();
    }
}
