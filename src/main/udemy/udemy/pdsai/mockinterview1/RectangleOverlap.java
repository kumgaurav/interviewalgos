/**
 * Given two rectangles, determine if they overlap. The rectangles are defined as a Dictionary, for example:
 * 
 * Requirements
Make sure the dictionary you output is in the same form as the input.
 */
package udemy.pdsai.mockinterview1;

/**
 * @author gkumargaur
 *
 */
public class RectangleOverlap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RectangleOverlap rv =  new RectangleOverlap();
		Rectangle r1 = rv.new Rectangle(2,4,5,12);
		Rectangle r2 = rv.new Rectangle(1,5,7,14);
		Overlap x_overlap = calculate_overlap(r1.x, r1.w, r2.x, r2.w);
		Overlap y_overlap = calculate_overlap(r1.y, r1.h, r2.y, r2.h);
		if(x_overlap == null || y_overlap == null) {
			System.out.println("No overalp");
		}
		System.out.println("x_overlap ->"+x_overlap);
		System.out.println("y_overlap ->"+y_overlap);
	}
	
	public static Overlap calculate_overlap(int cord1, int dimen1, int cord2, int dimen2) {
		RectangleOverlap rv =  new RectangleOverlap();
		Overlap ov = null;
		int max_cord = Math.max(cord1, cord2);
		int lower_cord = Math.min(cord1+dimen1, cord2+dimen2);
		if(max_cord>=lower_cord)
			return ov;
		int overlap = lower_cord - max_cord;
		ov = rv.new Overlap(max_cord, overlap);
		return ov;
	}
	
	class Rectangle{
		int x;
		int y;
		int w;
		int h;
		Rectangle(){}
		Rectangle(int x,int y, int w, int h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
		
	}
	
	class Overlap{
		int start;
		int end;
		Overlap(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "Overlap [start=" + start + ", end=" + end + "]";
		}
	}

}
