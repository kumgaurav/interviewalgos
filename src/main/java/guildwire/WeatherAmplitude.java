package guildwire;

import java.util.stream.IntStream;

public class WeatherAmplitude {
	public static void main(String[] args) {
		int [] T = {2, 1, 1, 10, 2, 13, 3, -18};
		//System.out.println("Answer -> "+solution(T));
		int T1[]= {-1,-10,10,5,30,15,20,-10,30,10,29,20};
		System.out.println("Answer -> "+solution(T1));
	}
	
	public static String solution(int[] T) {
	    final int count = T.length / 4;
	    int indx = 0;
	    int last = Integer.MIN_VALUE;
	    int max = Integer.MIN_VALUE;
	    int min = Integer.MIN_VALUE;
	    for (int i = 0; i < 4; ++i) {
	    	max = IntStream.of(T).skip(count * i).limit(count).max().getAsInt();
	    	min = IntStream.of(T).skip(count * i).limit(count).min().getAsInt();
	    	System.out.println("max ->"+max);
	    	System.out.println("min ->"+min);
	        int diff = max - min;
	        if (diff > last) {
	            indx = i;
	            last = diff;
	        }
	    }
	    final String[] seasons = { "WINTER", "SPRING", "SUMMER", "AUTUMN" };
	    return seasons[indx];
	}
	
	/*
	public static String solution(int[] T) {
        //not validating the input and going by assumtion given
        //number of data points given for each season 
		int len = T.length;
        int datapoints = len/4;
        //System.out.println("datapoints -> "+datapoints);
        String [] weather = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};
        HashMap<String, Integer> weatherAmp = new HashMap<>();
        int weatherIndex = 0;
        int maxAmp = 0;
        for(int i=0;i<len;i++) {
        	//System.out.println(i%datapoints);
        	if(i!= 0 && i%datapoints == 0) {
        		System.out.println("Final maxAmp -> "+maxAmp);
        		weatherAmp.put(weather[weatherIndex], maxAmp);
        		weatherIndex ++;
        		maxAmp = 0;
        	}
        	System.out.println("Weather -> "+weather[weatherIndex]);
        	maxAmp = maxAmp> T[i] ? maxAmp - T[i] : T[i] - maxAmp;
        	System.out.println("maxAmp -> "+maxAmp);
        }
        weatherAmp.put(weather[weatherIndex], maxAmp);
        System.out.println("WeatherMap -> "+weatherAmp);
        maxAmp = 0;
        int foundindex=0;
        
        for(int i=0;i<4;i++) {
        	//System.out.println("weather ->"+weather[i]+", "+weatherAmp.get(weather[i]));
        	//System.out.println("maxAmp ->"+maxAmp);
        	if(weatherAmp.get(weather[i])>maxAmp) {
        		maxAmp = weatherAmp.get(weather[i]);
        		foundindex=i;
        	}
        }
        System.out.println(weather[foundindex]);
		return weather[foundindex];
    }*/
}
