
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class HuffmanTreeDriverClass {
    
    
    public static void main(String[] args) {
        String s = "missisippi";
        
        Map frequencyMap = FrequencyMap.generateMap(s);
        
        System.out.println(frequencyMap);
        
        HuffmanTree tree = new HuffmanTree(frequencyMap);
        
        Map<Character, String> encodingMap = tree.getEncodingMap();
        System.out.println(encodingMap);
        
        String encoded = tree.encode(s, encodingMap);
        System.out.println(encoded);
    }
    
    
}
