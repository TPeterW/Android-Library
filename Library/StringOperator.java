package com.peter.library;

import java.util.LinkedList;

/**
 * 
 * @author Tao Peter Wang
 * 
 * boolean isAnagram(String s, String t)
 * 		checks if two String's are anagrams
 * 		@param s
 * 		@param t
 * 		@return true or false
 * 
 * String zigZagConvert(String s, int numRows)
 * 		convert a String in zigzag form
 * 		@param s
 * 		@param numRows
 * 		@return converted String
 */

public class StringOperator {
	/**
	 * convert a String in zigzag form
	 * @param s
	 * @param numRows
	 * @return converted String
	 */
	public String zigZagConvert(String s, int numRows) {
        int sLength = s.length();
        int numEachGroup = numRows + numRows - 2;

        int numColumns = (sLength / numEachGroup) * 2 + ((sLength % numEachGroup) >= numRows ? 1 : 0);
//        System.out.println(numColumns);
        
        char[][] normalRows = new char[numRows][sLength];
        
        // initialise
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < sLength; j++){
                normalRows[i][j] = '$';
            }
        }
        
        
        if(numRows == 1)
            return s;
            
        if(numRows == 2){
            for(int i = 0; i < sLength; i++){
                normalRows[i%2][i/2] = s.charAt(i);
            }
            
            String result = "";
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < sLength; j++){
                    if(normalRows[i][j] != '$')
                        result += normalRows[i][j];
                }
            }
            return result;
        }
        
        if(numRows == 3){
            for(int i = 0; i < sLength; i++){
                normalRows[i % 4 == 3 ? 1 : i % 4][(i / 4) * 2 + (i % 4 == 3 ? 1 : 0)] = s.charAt(i);
            }
            String result = "";
            for(int i = 0; i < numRows; i++){
            	for(int j = 0; j < sLength; j++){
            		if(normalRows[i][j] != '$')
            			result += normalRows[i][j];
            	}
            }
            return result;
        }
        
        for(int i = 0; i < sLength; i++){
            int columnNumber = (i/numEachGroup) * 2 + ((i % numEachGroup) >= numRows ? 1 : 0);
            int rowNumber = columnNumber % 2 == 0 ? (i % numEachGroup % numRows):(numRows - 2 - (i % numEachGroup % numRows));
//            System.out.print(rowNumber);
            normalRows[rowNumber][columnNumber] = s.charAt(i);
        }
        
        String result = "";
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < sLength; j++){
                if(normalRows[i][j] != '$'){
                	result += normalRows[i][j];
//                	System.out.print(normalRows[i][j] + " ");
                }
//                System.out.println();
            }
        }
        
//        System.out.println();
        return result;
    }
	
	/**
	 * checks if two String's are anagrams
	 * @param s
	 * @param t
	 * @return true or false
	 */
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        LinkedList<Character> sList = new LinkedList<Character>();
        LinkedList<Character> tList = new LinkedList<Character>();
        
        for (int i = 0; i < s.length(); i++){
            sList.add(sChars[i]);
            tList.add(tChars[i]);
        }
        
        for (int j = 0; j < s.length(); j++){
        	if(tList.contains(sList.getFirst())){
        		tList.remove(sList.getFirst());
        		sList.removeFirst();
        	}
        	else {
        		return false;
        	}
        }
        
		return true;
    }
}
