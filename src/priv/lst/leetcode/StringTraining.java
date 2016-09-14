package priv.lst.leetcode;

public class StringTraining {
	public static void main(String[] args) {
		new StringTraining().compareVersion("1", "0");
	}
	
	 public int compareVersion(String version1, String version2) {
	        String [] strs1 = version1.split("\\.");
	        String [] strs2 = version2.split("\\.");
	        int i = 0;
	        System.out.println(strs1.length);
	                System.out.println(strs2.length);
	        for(; i < strs1.length && i < strs2.length; i++){
	            String str1 = strs1[i];
	            String str2 = strs2[i];
	            
	            if(Integer.valueOf(str1) > Integer.valueOf(str2)){
	                return 1;
	            }
	            if(Integer.valueOf(str1) < Integer.valueOf(str2)){
	                return -1;
	            }
	        }
	        
	        if(i < strs1.length){
	            return 1;
	        }
	        
	        if(i < strs2.length){
	            return -1;
	        }
	        
	        return 0;
	    }
}
