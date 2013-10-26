/** 
 *@author William
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    
   private HuffmanTree.Node root;

   /**
      Constructs a Huffman tree from given character frequencies.
      frequencies is a map whose keys are the characters to be encoded
      and whose values are the frequencies of the characters
   */
   public HuffmanTree(Map<Character, Integer> frequencies) 
   {
      PriorityQueue<HuffmanTree.Node> nodes = new PriorityQueue<>();
      for (char ch : frequencies.keySet())
      {
         HuffmanTree.Node newNode = new HuffmanTree.Node();
         newNode.character = ch;
         newNode.frequency = frequencies.get(ch);
         nodes.add(newNode);
      }
      
      Node parent;      
      
      //While there are two nodes left
      while(nodes.size() > 1)
      {   
          //Make them children of a parent whose frequency is the sum of the child freq          
          //remove the two nodes with the smallest frequeinces
          parent = new Node();
          parent.left = nodes.poll();
          parent.frequency = parent.left.frequency;          
          parent.right = nodes.poll();
          parent.frequency = parent.frequency + parent.right.frequency;        
          
          //Add the parent to the priorty queue
          nodes.add(parent);        
      }
      
        root = nodes.poll();          
      
   }
   
   public String encode(String toEncode, Map<Character, String> encodingMap)
   {
       String encoded = "";
       for (char ch : toEncode.toCharArray()) {
          encoded += encodingMap.get(ch);
       }
       return encoded;
   }


   public Map<Character, String> getEncodingMap()
   {
      Map<Character, String> map = new HashMap<>();
      if (root != null) { root.fillEncodingMap(map, ""); }
      return map;
   }
   
   public String decode(String encoded)
   {
       int start = 0;
       int end = 1;
       String decoded = "";
       
       do
       {
           String s = encoded.substring(start, end);
           Character c = contains(root, s);
           
           if (c == null)
           {
               end++;
           }
           else
           {
               decoded = decoded + c;
               start = end;
               end++;
           }                      
       } while (end != encoded.length()+1);
       
       return decoded;
   }
   
   private Character contains(Node n, String s)
   {
       Node temp = n;
       
       for ( char c : s.toCharArray())
       {
           if (c == '0')
               temp = temp.left;
           else
               temp = temp.right;         
           
       }
       
       if (temp.character == 0)
           return null;
       else
           return temp.character;
   }
   
   // inner class Node
   private class Node implements Comparable<HuffmanTree.Node>
   {
      public char character;
      public int frequency;
      public HuffmanTree.Node left;
      public HuffmanTree.Node right;

      @Override
      public int compareTo(HuffmanTree.Node other) 
      { 
          return frequency - other.frequency; 
      }

      public void fillEncodingMap(Map<Character, String> map, String prefix)
      {
         if (left == null ) // it's a leaf
         {
            map.put(character, prefix);
         }
         else
         {
            left.fillEncodingMap(map, prefix + "0");
            right.fillEncodingMap(map, prefix + "1");
         }
      }
      
      
   }
   
   


}

