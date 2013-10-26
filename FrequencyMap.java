import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class FrequencyMap {
    
    public static Map<Character, Integer> generateMap(String s)
    {
        Map<Character, Integer> freq = new TreeMap<>();
        
        for (char c : s.toCharArray()) {           
            
            if (freq.containsKey(c))
            {
                //Its already there so update the value
                int value = freq.get(c);
                value++;
                freq.remove(c);
                freq.put(c, value);
            }
            else
            {
                //Its new so add 1
                freq.put(c, 1);
            }
            
        }
        
        return freq;
        
    }

}
