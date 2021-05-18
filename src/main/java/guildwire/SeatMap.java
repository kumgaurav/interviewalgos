package guildwire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SeatMap {

	public static void main(String[] args) {
		

	}
	
	public int solution(int N, String S) {
        Map<Integer, ArrayList<ArrayList<String>>> allSeatMap = new HashMap<>();
        for (int rowCount = 1; rowCount <= N; rowCount++) {
        	ArrayList<ArrayList<String>> row = new ArrayList<>(3);
        	ArrayList<String> c1 = new ArrayList<>(3);
        	 c1.add(rowCount+"A");
        	 c1.add(rowCount+"B");
        	 c1.add(rowCount+"C");
        	 ArrayList<String> c2 = new ArrayList<>(4);
        	 c2.add(rowCount+"D");
        	 c2.add(rowCount+"E");
        	 c2.add(rowCount+"F");
        	 c2.add(rowCount+"G");
        	 ArrayList<String> c3 = new ArrayList<>(3);
        	 c3.add(rowCount+"H");
        	 c3.add(rowCount+"J");
        	 c3.add(rowCount+"K");
        	row.add(c1);
        	 row.add(c2);
        	 row.add(c3);
        	 allSeatMap.put(rowCount, row);
		}
        //remove used seat first
        String []usedRow = S.split(" ");
        int usedRowLen = usedRow.length;
        if (usedRowLen>0) {
			for (int rowCount = 1; rowCount <= N; rowCount++) {
				ArrayList<ArrayList<String>> row = allSeatMap.get(rowCount);

			} 
		}
		return N;
    }

}
