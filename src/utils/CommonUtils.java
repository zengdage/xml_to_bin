package utils;

public class CommonUtils {
	    //��λ��ǰ����λ�ں�  
	    public static byte[] int2bytesLittle(int num){  
	        byte[] result = new byte[4];  
	        result[0] = (byte)((num >>> 24) & 0xff);//˵��һ  
	        result[1] = (byte)((num >>> 16)& 0xff );  
	        result[2] = (byte)((num >>> 8) & 0xff );  
	        result[3] = (byte)((num >>> 0) & 0xff );  
	        return result;  
	    }  
	      
	    //��λ��ǰ����λ�ں�  
	    public static int bytes2intLittle(byte[] bytes){  
	        int result = 0;  
	        if(bytes.length == 4){  
	            int a = (bytes[0] & 0xff) << 24;//˵����  
	            int b = (bytes[1] & 0xff) << 16;  
	            int c = (bytes[2] & 0xff) << 8;  
	            int d = (bytes[3] & 0xff);  
	            result = a | b | c | d;  
	        }  
	        return result;  
	    }  
	    
	    //��λ�ں󣬵�λ��ǰ
	    public static byte[] int2bytesBig(int num){  
	        byte[] result = new byte[4];  
	        result[3] = (byte)((num >>> 24) & 0xff);//˵��һ  
	        result[2] = (byte)((num >>> 16)& 0xff );  
	        result[1] = (byte)((num >>> 8) & 0xff );  
	        result[0] = (byte)((num >>> 0) & 0xff );  
	        return result;  
	    }  
	      
	    //��λ�ں󣬵�λ��ǰ  
	    public static int bytes2intBig(byte[] bytes){  
	        int result = 0;  
	        if(bytes.length == 4){  
	            int a = (bytes[3] & 0xff) << 24;//˵����  
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
}
