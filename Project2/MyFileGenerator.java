import java.util.*;
import java.lang.*;
import java.util.Collections;
import java.io.PrintWriter;
import java.util.Random;

public class MyFileGenerator{

	private Random r;
	public MyFileGenerator(long seed){
		this.r = new Random(seed);
	}

	public static void main(String[] args){
		
        long[] seeds = {4358712, 1980234, 9928374};
        int[] sizes = {500,700,800,1000,1500,2000,2500,3000,3500,4000,4500,5000};
        
        try {
            for(int i = 0; i < sizes.length; i++){
                int size = sizes[i];
                for(int j =0; j < seeds.length; j++){
                	MyFileGenerator t = new MyFileGenerator(seeds[j]);
                    String outfile = "data_" + size + "_seed" + (j+1) + ".txt";
                    PrintWriter p = new PrintWriter(outfile); 
                    
                    for (int k = 0; k < size; k++){
                        ArrayList<String> data = new ArrayList<String>();
                
                        data.add(t.randomName());
                        data.add(t.randomDate());
                        if(t.randomBoolean()) data.add(t.randomOrg()); 
                        if(t.randomBoolean()) data.add(t.randomLocation()); 
                        if(t.randomBoolean()) data.add(t.randomType());
        
                        Collections.shuffle(data); 

                        for(int g = 0; g < data.size(); g++){ 
                            p.println(data.get(g));
                        }
                        p.println();
                    }
                    p.close();   
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
	}

	public boolean randomBoolean(){
		return r.nextFloat() < 0.5;
	}

	public String randomName(){
		int randomInt = r.nextInt(2147483647);
		return "name: name_" + randomInt;
	}

	public String randomLocation(){
		int randomInt = r.nextInt(2147483647);
		return "location: location_" + randomInt;
	}

	public String randomType(){
		String[] types = {"art", "music", "athletics", "art", "talk", "academic"};
		int randomInt = r.nextInt(5);
		return "type: " + types[randomInt];
	}

	public String randomOrg(){
		int numOrgs = r.nextInt(5);
		String orgs = "organization: ";
		for (int i = 0; i < numOrgs-1; i++){
			orgs = orgs + "org_" + r.nextInt(2147483647) + ", ";
		}
		orgs = orgs + "org_" + r.nextInt(2147483647);
		return orgs;
	}

	public String randomDate(){
		int min = 1968;
		int max = 2017; 
		int eventYear = 1968 + r.nextInt(max - min + 1);
		String date = "date: ";

		boolean singleDate = this.randomBoolean();
		if (singleDate){
			int month = 1 + r.nextInt(12);
			int day = 1 + r.nextInt(31);
			date = date + day + "/" + month + "/" + eventYear;
		} else {
			int startMonth = 1+ r.nextInt(12); 
			int endMonth = startMonth + r.nextInt(12-startMonth+1);
			if (startMonth == endMonth){
				int startDay = 1 + r.nextInt(31);
				int endDay = startDay + r.nextInt(31-startDay+1);
				date = 	date + startDay + "/" + startMonth + "/" +eventYear + " " + endDay + "/" + endMonth + "/" + eventYear;
			} else {
				int startDay = 1 + r.nextInt(31);
				int endDay = 1 + r.nextInt(31);
				date = date + startDay + "/" + startMonth +  "/" +eventYear + " " + endDay + "/" + endMonth + "/" + eventYear;
			}

		}
		return date; 
	}
}