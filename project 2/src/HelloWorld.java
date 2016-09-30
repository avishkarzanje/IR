import java.io.*;


public class HelloWorld {
	public void execute_query(String query)
	{
		System.out.println("\nQuery is "+query);
		System.out.println("Splitting query into terms ");
		String[] terms = query.split(" ");    

		 for ( String term : terms ) 
		 {

		       System.out.print(term+" ");
		 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
		if (args.length >= 2)
		{
			String input_file = args[0];
			String output_file = args[1];
			System.out.println("Input file is : "+ input_file);
			System.out.println("Output file is : "+ output_file);
			
			// read from the input file
			try
			{
				// Open the file
				FileInputStream fstream = new FileInputStream(input_file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	
				String strLine;
				String[] queries = new String[10]; 
				int query_count = 0;
				
				//Read File Line By Line
				while ((strLine = br.readLine()) != null)   
				{
				  // Print the content on the console
				  // System.out.println (strLine);
				  queries[query_count] = strLine;
				  query_count++;
				}
				System.out.println("Query count is : "+ query_count);
				
				// Write to the file query terms
				PrintWriter writer = new PrintWriter(output_file, "UTF-8");
				writer.println("Number of queries is "+query_count);
				for (int i=0; i< queries.length && queries[i]!= null; i++) 
				{
					writer.println(queries[i]);
					new HelloWorld().execute_query(queries[i]);
		        }
					
				writer.close();
	
				//Close the input stream
				br.close();
			}
			catch(Exception e)
			{
				//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}
		else
		{
			System.out.println("Invalid Number of argument");
		}
		
		for (String s: args) {
            //System.out.println(s);
        }
	}
}
