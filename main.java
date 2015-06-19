import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.math.*;


public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br1 = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("Parks.csv")
						)
				);
		int[][] Parks = new int[2][4154];
		
		String line;
		String x;
		String y;
		
		float a,b;
		
		int n=0;
		while ( (line = br1.readLine()) != null ) { 
			String[] info = line.split(",");
			   x = info[4].trim();
			   y = info[5].trim();
			   if(n!=0){
				   a=Float.parseFloat(x);
				   b=Float.parseFloat(y);
				   Parks[0][n] = (int) a;
				   Parks[1][n] = (int) b;		   
//				   System.out.print(n + ". X COORDINATE: " + Parks[0][n] +"\t" + "Y COORDINATE: " + Parks[1][n] + "\n");
			   }
			   n++;	
		}
		
		BufferedReader br2 = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("Crimes.csv")
						)
				);
		
		String PRIMARY,DATE;
		int Cx,Cy;
		int number=0;
		n=0;
		while ( (line = br2.readLine()) != null ) { 
			String[] info = line.split(",");
			if(n!=0)
			{
				if(info.length>13)
				{
					x = info[12].trim();				
					y = info[13].trim();
					a=Float.parseFloat(x);
					b=Float.parseFloat(y);
					Cx=(int) a;
					Cy=(int) b;
//					System.out.print(n + ". X COORDINATE: " + Cx +"\t" + "Y COORDINATE: " + Cy + "\n");
					int i;
					for(i=1;i<4153;i++)
					{
						if(Math.abs(Cx-Parks[0][i])<50 && Math.abs(Cy-Parks[1][i])<50)
						{
							number++;
							DATE = info[1].trim();
							PRIMARY = info[4].trim();
							System.out.print(number+ ". " + DATE + " " +PRIMARY + " X COORDINATE: " + Cx +"\t" + "Y COORDINATE: " + Cy + "\n");
						}
					}
			   }
			}
			n++; 
		}

		
		
	
	}
}




