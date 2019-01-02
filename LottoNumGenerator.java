import java.util.*;
public class LottoNumGenerator{
	private int minVal;
	private int maxVal;
	private int lengthVal;
	private int[] lotto;

	public void setMin(int min){
	  minVal = min;
	}
	public int getMin(){
	  return minVal;
	}
	public void setMax(int max){
	  maxVal = max;
	}
	public int getMax(){
	  return maxVal;
	}  
	public void setLength(int len){
	  lengthVal = len;
	}
	public int getLength(){
	  return lengthVal;
	}
	public static int[] getLottoNums(int min, int max, int length){
	  int[] lottoNums = new int[length];
	  int num = min + ((int)(Math.random()*max));
	  lottoNums[0] = num;
	  for(int i = 1; i < length; i++) {
	    num = min + ((int)(Math.random()*max));
	    for(int prev = 0; prev < i; prev++) {
	      if(num == lottoNums[prev])
	        num = min + ((int)(Math.random()*max));
	    }
	    lottoNums[i] = num;
	  }
	  return lottoNums;
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Name of the game: ");
	    String gameName = sc.nextLine();
	    System.out.print("\nEnter number of games: ");
	    int numGames = sc.nextInt();

	    System.out.print("\nEnter minimum value: ");
	    int min = sc.nextInt();
	    System.out.print("\nEnter max value: ");
	    int max = sc.nextInt();
	    System.out.print("\nEnter number of numbers to generate: ");
	    int length = sc.nextInt();
	    System.out.print("\nEnter " + gameName + " bonus min value: ");
	    int pMin = sc.nextInt();
	    System.out.print("\nEnter " + gameName + " bonus max value: ");
	    int pMax = sc.nextInt();
	    
	    System.out.println();
	    for(int i = 1; i <= numGames; i++)
	    {
	      System.out.println("Game " + i);
	      int[] lottoNums = getLottoNums(min, max, length);
	      Arrays.sort(lottoNums);
	      
	      System.out.print("Lotto Numbers: ");
	      for(int c = 0; c < lottoNums.length; c++){
	        System.out.print(lottoNums[c] + " ");
	      }

	      lottoNums = getLottoNums(pMin, pMax, 1);
	      System.out.println("\nPowerball: " + lottoNums[0]);
		 }
	  }
}
