package utils;

public class CommonUtils {
	    //高位在前，低位在后  
	    public static byte[] int2bytesLittle(int num){  
	        byte[] result = new byte[4];  
	        result[0] = (byte)((num >>> 24) & 0xff);//说明一  
	        result[1] = (byte)((num >>> 16)& 0xff );  
	        result[2] = (byte)((num >>> 8) & 0xff );  
	        result[3] = (byte)((num >>> 0) & 0xff );  
	        return result;  
	    }  
	      
	    //高位在前，低位在后  
	    public static int bytes2intLittle(byte[] bytes){  
	        int result = 0;  
	        if(bytes.length == 4){  
	            int a = (bytes[0] & 0xff) << 24;//说明二  
	            int b = (bytes[1] & 0xff) << 16;  
	            int c = (bytes[2] & 0xff) << 8;  
	            int d = (bytes[3] & 0xff);  
	            result = a | b | c | d;  
	        }  
	        return result;  
	    }  
	    
	    //高位在后，低位在前
	    public static byte[] int2bytesBig(int num){  
	        byte[] result = new byte[4];  
	        result[3] = (byte)((num >>> 24) & 0xff);//说明一  
	        result[2] = (byte)((num >>> 16)& 0xff );  
	        result[1] = (byte)((num >>> 8) & 0xff );  
	        result[0] = (byte)((num >>> 0) & 0xff );  
	        return result;  
	    }  
	      
	    //高位在后，低位在前  
	    public static int bytes2intBig(byte[] bytes){  
	        int result = 0;  
	        if(bytes.length == 4){  
	            int a = (bytes[3] & 0xff) << 24;//说明二  
	            int b = (bytes[2] & 0xff) << 16;  
	            int c = (bytes[1] & 0xff) << 8;  
	            int d = (bytes[0] & 0xff);  
	            result = a | b | c | d;  
	        }  
	        return result;  
	    }  
	    
	    public static byte[] int2bytes(int num){  
	        return int2bytesBig(num);  
	    }  

	    public static int bytes2int(byte[] bytes){  
	        return bytes2intBig(bytes);  
	    }  
	    
	    public static int alignStringTo4byte(String string) {
	    	if(string.length() % 4 != 0) {
	    		return (string.length() / 4 + 1) * 4;
	    	}else {
	    		return string.length();
	    	}
	    }
}
