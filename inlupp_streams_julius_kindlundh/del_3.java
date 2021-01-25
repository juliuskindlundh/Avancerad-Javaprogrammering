package inlupp_streams_julius_kindlundh;

import java.util.Arrays;
import java.util.Random;

public class del_3 {
	public static void main(String[] args) {
		
		MyObject[] arr = generateArr();
		
		// print all objects with value > 20
		Arrays.stream(arr).filter(m -> m.getValue() > 20).forEach(a->System.out.println(a.toString()));			
		
		//get the average value
		double res = Arrays.stream(arr).mapToInt(m -> m.getValue()).average().getAsDouble();
		System.out.println("***************************\nAverage value: "+res+"\n***************************");
		
		//replace all objects with bool = true with 
		Arrays.stream(arr).map(m->{
			if(m.getBool()) {
				MyObject mo = new MyObject("this is true",m.getValue(),m.getBool());
				return mo;
			}
			return m;
		}).forEach(m->System.out.println(m.toString()));
	}
	
	// method to generate an array of 50 MyObjects
    public static MyObject[] generateArr() {
    	Random rng = new Random();
    	long time = System.currentTimeMillis();
    	MyObject[] arr = new MyObject[50];
    	for(int i = 0; i < 50; i++) {
    		String name = generateRandomName(i,time);
    		int value = rng.nextInt(50)+1;
    		boolean bool = rng.nextBoolean();  		
    		arr[i] = new MyObject(name,value,bool);
    	}
    	return arr;
    }

    //method to generate a random name
	// every name is generated from a different seed
	private static String generateRandomName(int seed, long time) {
		Random rng = new Random();
		rng.setSeed(seed+time);
		int bound = rng.nextInt(5);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < bound + 10; i++) {
			sb.append((char)(97+rng.nextInt(25)));
		}
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}

}
