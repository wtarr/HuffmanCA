/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author William
 */
public class HuffmanTest {
    
    ArrayList<String> possible;
    
    
    public HuffmanTest() {
        possible = new ArrayList<>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        possible.clear();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test_that_frequencyMap_is_generating_correct_frequencies() {
        
        
        TreeMap<Character, Integer> test = (TreeMap)FrequencyMap.generateMap("missisippi");
        int total = 0;
        int expected = 10;
        
        Collection collection = test.values();    
        
        for (Iterator<Integer> valueIter = collection.iterator(); valueIter.hasNext(); )
        {
            total = total + valueIter.next();
        }        
        
        assertEquals(expected, total);
        
    }
    
    @Test
    public void test_the_encodingMap_is_being_generated_correctly()
    {
        HuffmanTree ht = new HuffmanTree(FrequencyMap.generateMap("missisippi"));
        
        Map<Character, String> encodingMap = ht.getEncodingMap();
        
        String i = encodingMap.get('i');
        assertEquals("0", i);
        
        String s =  encodingMap.get('s');        
        possible.add("11");
        possible.add("10");
        assertTrue(possible.contains(s));
        
        String m =  encodingMap.get('m');
        possible.clear();
        possible.add("100");
        possible.add("110");
        assertTrue(possible.contains(m));               
        
        String p =  encodingMap.get('p');
        possible.clear();
        possible.add("101");
        possible.add("111");
        assertTrue(possible.contains(p));       
        
    }
    
    @Test
    public void test_that_the_correct_encoded_string_is_returned()
    {
        String tobeencoded = "missisippi";
        
        HuffmanTree ht = new HuffmanTree(FrequencyMap.generateMap(tobeencoded));
        
        Map<Character, String> encodingMap = ht.getEncodingMap();
        
        String encoded = ht.encode(tobeencoded, encodingMap);
        
        possible.add("1100101001001111110");
        possible.add("1000111101101011010");
        
        assertTrue(possible.contains(encoded));
    }
    
    @Test
    public void test_decode()
    {
        String tobeencoded = "missisippi";
        
        HuffmanTree ht = new HuffmanTree(FrequencyMap.generateMap(tobeencoded));
        
        Map<Character, String> encodingMap = ht.getEncodingMap();
        
        String encoded = ht.encode(tobeencoded, encodingMap);
        
        String decoded = ht.decode(encoded);
        
        assertEquals(tobeencoded, decoded);
    }
}
