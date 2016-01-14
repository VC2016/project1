package mathmania;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 
 *  This class contains  utility methods for performing basic numeric operations 
 *  @author KOFI ASARE
 */
public final class Math {

	// CONSTANTS
	private static final double  PI = java.lang.Math.PI;


	/**
	 *   This method allows the user to compute the square root of a number
	 *   @param   a
	 *   The number to compute its root , it shouldn't be a negative integer
	 */

	public static double mathSqrt(double a){

		return java.lang.Math.sqrt(a);
	}

	/**
	 *   This method allows the user to compute the square root of a number
	 *   @param   a
	 *   The number to compute its root , it shouldn't be a negative integer
	 */

	public static double mathPower(double a , double b){

		return java.lang.Math.pow(a, b);
	}

	public static double mathCos(double a){

		return java.lang.Math.cos(a);
	}
	public static double MathSin(double a){

		return java.lang.Math.sin(a);
	}

	public static double MathTan(double a){

		return java.lang.Math.tan(a);
	}
	public static double getPI(){
		return PI;
	}
	public static double mathSimpleMean (double ...ds){

		int arraylength = ds.length;
		double sum = 0;

		for(int i = 0 ; i < arraylength ; i++){

			sum = sum +=ds[i];
		}
		// divide by array length
		double average = sum /arraylength;

		return average;	
	}

	public static String mathToBinary(int a){

		StringBuilder repo = new StringBuilder();

		int remainder= 0; String results;

		// 128 64 32 16 8 4 2 1
		int [] bit = {128, 64 ,32, 16 ,8 ,4 ,2, 1};

		for(int i =0 ; i < 8 ; i++){
			// if you can subtract bit[i] from (a)then append 1 else 0
			if ( a - bit[i] >= 0){
				remainder = a - bit[i];
				repo.append(String.valueOf("1"));
				a = remainder;
			}
			else{
				repo.append(String.valueOf("0"));
				continue;
			}
		}
		results =  repo.toString();
		repo.delete(0, 8);
		return  results;
	}

	public static String bitPattern(String ip_address){

		// "127.0.0.1" 
		StringBuilder repo = new StringBuilder();
		String results;
		String rep = ip_address.replace(".", ":");
		String [] parse = rep.split(":");
		int count = 0;

		try{

			for( int i = 0 ; i < parse.length ; i++){
				results = Math.mathToBinary(Integer.parseInt(parse[i]));
				count++;
				if (count == 4){
					repo.append(results);	
				}else{
					repo.append(results+".");	
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("Number format exception");
		}

		String final_result = repo.toString();
		repo.delete(0, repo.length());
		count = 0;
		return  final_result;
	}

	public static String bitPatternByName(String ip_address){

		StringBuilder repo = new StringBuilder();
		String results;
		String rep = ip_address.replace(".", ":");
		String [] parse = rep.split(":");
		int count = 0;

		try{

			InetAddress ip = InetAddress.getByName(ip_address);
			String cov = ip.toString();
			parse = cov.split(":");

			for( int i = 0 ; i < parse.length ; i++){
				results = Math.mathToBinary(Integer.parseInt(parse[i]));
				count++;
				if (count == 4){
					repo.append(results);	
				}else{
					repo.append(results+".");	
				}
			}

		}catch(UnknownHostException e){
			System.out.println("Unknown host");
		}

		String final_result = repo.toString();
		repo.delete(0, repo.length());
		count = 0;
		return  final_result;
	}

	public static double MathLog(double a){
		
		return java.lang.Math.log(a);
	}

	public static double MathLog10(double a){
		return java.lang.Math.log10(a);
	}
}
