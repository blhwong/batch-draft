import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class createBatch {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<String>> row = new ArrayList<ArrayList<String>>();
		// TODO Auto-generated method stub
		try {
			int count = 1;
			FileReader file = new FileReader("./Chase Report.csv");
			BufferedReader input = new BufferedReader(file);
			System.out.println("Opened");
			String s;
			String[] tokens;
			try {
				input.readLine();
				while((s = input.readLine()) != null)
				{ 
					s = s.replaceAll("\"", "");
					count++;
					ArrayList<String> column = new ArrayList<String>();
					tokens = s.split(",", 14);
					if(tokens[12].equalsIgnoreCase("Bank Draft"))
					{
						System.out.println("removed bank draft at " + Integer.toString(count));
						continue;
					}
					if(!tokens[11].equalsIgnoreCase("Pending"))
					{
						System.out.println("removed " + tokens[11] +" at " + Integer.toString(count));
						continue;
					}
					if(tokens[13].contains("Cancel"))
					{
						System.out.println("removed canceled status at " + Integer.toString(count));
						continue;
					}
					if(tokens[13].contains("Collections"))
					{
						System.out.println("removed collections status at " + Integer.toString(count));
						continue;
					}
					if(tokens[3].contains("."))
					{
						tokens[3].replace(".", "");
						System.out.println("removed period from client name at " + Integer.toString(count));
					}
					if(tokens[3].contains("-"))
					{
						tokens[3].replace("-", "");
						System.out.println("removed hyphen from client name at " + Integer.toString(count));
					}
					if(tokens[3].contains("'"))
					{
						tokens[3].replace("'", "");
						System.out.println("removed apostrophe from client name at " + Integer.toString(count));
					}
					if(tokens[3].contains(","))
					{
						tokens[3].replace(",", "");
						System.out.println("removed comma from client name at " + Integer.toString(count));
					}
					
					if(tokens[9].contains("."))
					{
						tokens[9].replace(".", "");
						System.out.println("removed period from client name at " + Integer.toString(count));
					}
					if(tokens[9].contains("-"))
					{
						tokens[9].replace("-", "");
						System.out.println("removed apostrophe from client name at " + Integer.toString(count));
					}
					if(tokens[9].contains("'"))
					{
						tokens[9].replace("'", "");
						System.out.println("removed hyphen from client name at " + Integer.toString(count));
					}
					if(tokens[9].contains(","))
					{
						tokens[9].replace(",", "");
						System.out.println("removed comma from client name at " + Integer.toString(count));
					}
					
					if(tokens[10].contains("."))
					{
						tokens[10].replace(".", "");
						System.out.println("removed period from client name at " + Integer.toString(count));
					}
					if(tokens[10].contains("-"))
					{
						tokens[10].replace("-", ""); 
						System.out.println("removed apostrophe from client name at " + Integer.toString(count));
					}
					if(tokens[10].contains("'"))
					{
						tokens[10].replace("'", "");
						System.out.println("removed hyphen from client name at " + Integer.toString(count));
					}
					if(tokens[10].contains(","))
					{
						tokens[10].replace(",", "");
						System.out.println("removed comma from client name at " + Integer.toString(count));
					}
					
					if(tokens[3].length() > 21)
					{
						String t;
						System.out.println("'" + tokens[3] + "'" + " is too long of a name at " + Integer.toString(count) + ", please enter a name less than 21 characters");
						while(true)
						{
							
							BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
							t = br.readLine();
							if(t.length() > 21)
							{
								System.out.println("still too long! please try again");
								continue;
							}
							if(t.length() == 0)
							{
								System.out.println("must enter a char! try again");
							}
							if(t.contains(".") || t.contains(",") || t.contains("'") || t.contains("-"))
							{
								System.out.println("invalid char found! try again");
								continue;
							}
							else
							{
								break;
							}
						}
						tokens[3] = t;
						
						
					}
					if(tokens[9].isEmpty())
					{
						tokens[9] = tokens[3];
						System.out.println("copied name at " + Integer.toString(count));
					}
					for(int i = 0; i < 14; i++)
					{
						column.add(tokens[i]);
					}
					
					row.add(column);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error");
			}
			
			System.out.println("Done eliminating");
			System.out.println("Please enter output file name");
			BufferedReader outputname = new BufferedReader(new InputStreamReader(System.in));
			try {
				String outputnamestring = outputname.readLine();
				FileWriter fr = new FileWriter(outputnamestring + ".csv");
				BufferedWriter bw = new BufferedWriter(fr);
				
				bw.write("H,1,2_8_0,BWONG012," + outputnamestring + "," + Integer.toString(row.size()));
				bw.newLine();
				//Iterator rowi = row.iterator();
				for(int size = 0; size < row.size(); size++)
				{
					bw.write(row.get(size).get(0) + ",");
					bw.write(Integer.toString(size+1) + ",");
					bw.write(",,");
					bw.write(row.get(size).get(1) + ",");
					bw.write(row.get(size).get(2) + ",");
					bw.write(row.get(size).get(3) + ",");
					bw.write(row.get(size).get(4) + ",");
					bw.write(row.get(size).get(5) + ",");
					bw.write(row.get(size).get(6) + ",");
					bw.write(",");
					bw.write(row.get(size).get(7) + ",");
					bw.write(",,,,,,,,");
					bw.write(row.get(size).get(8) + ",");
					bw.write(",,,,");
					bw.write(row.get(size).get(9) + ",");
					bw.write(",,,,,,,,");
					bw.write(row.get(size).get(10) + ",");
					bw.write(row.get(size).get(11) + ",");
					bw.write(row.get(size).get(12) + ",");
					bw.write(row.get(size).get(13));
					bw.newLine();
				}
				bw.write("T,1");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File out error");
			}
			
			System.out.println("Batch draft created!");
			
			//BufferedReader = new BufferedReader(new InputStreamReader("./test.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!");
		}
	}

}
