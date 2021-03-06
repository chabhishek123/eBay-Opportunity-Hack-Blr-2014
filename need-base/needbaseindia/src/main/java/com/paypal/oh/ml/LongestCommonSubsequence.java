package com.paypal.oh.ml;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LongestCommonSubsequence {
	public static Logger logger = Logger.getLogger(LongestCommonSubsequence.class.getName());
	private static int[][] lcs;
	private String a, b;

	LongestCommonSubsequence(String a, String b) {
		lcs = new int[a.length()+1][b.length()+1];
		this.a = a;
		this.b = b;
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = -1;
				} else {
					lcs[i][j] = -1;
				}
			}
		}
	}

	public int getLCS() {
		return getLCS(0,0);
	}

	public int getLCS(String a,String b){
	    int[][] lengths = new int[a.length()+1][b.length()+1];
	    
	    // row 0 and column 0 are initialized to 0 already
	 
	    for (int i = 0; i < a.length(); i++)
	        for (int j = 0; j < b.length(); j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math.max(lengths[i+1][j], lengths[i][j+1]);
	 
	    // read the substring out from the matrix
	    StringBuffer sb = new StringBuffer();
	    for (int x = a.length(), y = b.length();
	         x != 0 && y != 0; ) {
	        if (lengths[x][y] == lengths[x-1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y-1])
	            y--;
	        else {
	            assert a.charAt(x-1) == b.charAt(y-1);
	            sb.append(a.charAt(x-1));
	            x--;
	            y--;
	        }
	    }
	 
	    return sb.length();
	}
	private int getLCS(int i, int j) {
		if(lcs[i][j]!=-1){
			return lcs[i][j];
		}
		
		if (a.charAt(i) == b.charAt(j)) {
			lcs[i][j] = 1 + getLCS(i + 1, j + 1);
		} else {
			lcs[i][j] = Math.max(getLCS(i, j + 1), getLCS(i + 1, j));
		}
		return lcs[i][j];

	}

	public static void main(String[] args) {
		LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence(
				"ABCDGH", "AEDFHR");
		logger.log(Level.INFO, String.valueOf(longestCommonSubsequence.getLCS("ABCDGH","AEDFHR")));

	}
}
