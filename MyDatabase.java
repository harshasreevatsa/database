import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.ObjectInputStream.GetField;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class MyDatabase {
	static HashMap id_map = new HashMap();
	static HashMap company_map = new HashMap();
	static HashMap drug_id_map = new HashMap();
	static HashMap trials_map = new HashMap();
	static HashMap patients_map = new HashMap();
	static HashMap dosage_map = new HashMap();
	static HashMap reading_map = new HashMap();
	static HashMap double_blind_map = new HashMap();
	static HashMap controlled_study_map = new HashMap();
	static HashMap govt_funded_map = new HashMap();
	static HashMap fda_approved_map = new HashMap();

	static ArrayList id_list = new ArrayList();
	static ArrayList company_list = new ArrayList();
	static ArrayList drug_id_list = new ArrayList();
	static ArrayList trials_list = new ArrayList();
	static ArrayList patients_list = new ArrayList();
	static ArrayList dosage_list = new ArrayList();
	static ArrayList reading_list = new ArrayList();
	static ArrayList double_blind_list = new ArrayList();
	static ArrayList controlled_study_list = new ArrayList();
	static ArrayList govt_funded_list = new ArrayList();
	static ArrayList fda_approved_list = new ArrayList();
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String name="harsha";
		Integer num = 819;
		Scanner sc1 = new Scanner(System.in);
		byte[] b = name.getBytes(Charset.forName("UTF-8"));
		RandomAccessFile r = new RandomAccessFile("data.db","rw");
		System.out.println("please enter the file path ");
		String path = sc1.next();
		BufferedReader in = new BufferedReader(new FileReader(path));
		String line="";
		System.out.println("please enter 1 to parse the csv file");
		System.out.println("please enter 2 to query");
		String decide = sc1.next();
		if(decide.equals("1"))
		{
			line = in.readLine();
			int offset = 0;
			while((line = in.readLine())!=null)
			{
				offset =  (offset + setit(line,r,offset));
			}
			
			  OutputStream file1 = new FileOutputStream("id.ndx");
		      OutputStream buffer1 = new BufferedOutputStream(file1);
		      ObjectOutput output1 = new ObjectOutputStream(buffer1);
		      output1.writeObject(id_map);
		      output1.close();
		      file1.close();
		      
		      
		      OutputStream file2 = new FileOutputStream("company.ndx");
		      OutputStream buffer2 = new BufferedOutputStream(file2);
		      ObjectOutput output2 = new ObjectOutputStream(buffer2);
		      output2.writeObject(company_map);
		      output2.close();
		      file2.close();
		      
			
		      OutputStream file3 = new FileOutputStream("drug_id.ndx");
		      OutputStream buffer3 = new BufferedOutputStream(file3);
		      ObjectOutput output3 = new ObjectOutputStream(buffer3);
		      output3.writeObject(drug_id_map);
		      output3.close();
		      file3.close();
		      
		      OutputStream file4 = new FileOutputStream("trials.ndx");
		      OutputStream buffer4 = new BufferedOutputStream(file4);
		      ObjectOutput output4 = new ObjectOutputStream(buffer4);
		      output4.writeObject(trials_map);
		      output4.close();
		      file4.close();
		      
		      
		      OutputStream file5 = new FileOutputStream("patients.ndx");
		      OutputStream buffer5 = new BufferedOutputStream(file5);
		      ObjectOutput output5 = new ObjectOutputStream(buffer5);
		      output5.writeObject(patients_map);
		      output5.close();
		      file5.close();
		      
		      
		      OutputStream file6 = new FileOutputStream("dosage_mg.ndx");
		      OutputStream buffer6 = new BufferedOutputStream(file6);
		      ObjectOutput output6 = new ObjectOutputStream(buffer6);
		      output6.writeObject(dosage_map);
		      output6.close();
		      file6.close();
		      
		      
		      OutputStream file7 = new FileOutputStream("reading.ndx");
		      OutputStream buffer7 = new BufferedOutputStream(file7);
		      ObjectOutput output7 = new ObjectOutputStream(buffer7);
		      output7.writeObject(reading_map);
		      output7.close();
		      file7.close();
		      
		      
		      OutputStream file8 = new FileOutputStream("double_blind.ndx");
		      OutputStream buffer8 = new BufferedOutputStream(file8);
		      ObjectOutput output8 = new ObjectOutputStream(buffer8);
		      output8.writeObject(double_blind_map);
		      output8.close();
		      file8.close();
		      
		      
		      OutputStream file9 = new FileOutputStream("controlled_study.ndx");
		      OutputStream buffer9 = new BufferedOutputStream(file9);
		      ObjectOutput output9 = new ObjectOutputStream(buffer9);
		      output9.writeObject(controlled_study_map);
		      output9.close();
		      file9.close();
		      
		      
		      OutputStream file10 = new FileOutputStream("govt_funded.ndx");
		      OutputStream buffer10 = new BufferedOutputStream(file10);
		      ObjectOutput output10 = new ObjectOutputStream(buffer10);
		      output10.writeObject(govt_funded_map);
		      output10.close();
		      file10.close();
		      
		      
		      OutputStream file11 = new FileOutputStream("fda_approved.ndx");
		      OutputStream buffer11 = new BufferedOutputStream(file11);
		      ObjectOutput output11 = new ObjectOutputStream(buffer11);
		      output11.writeObject(fda_approved_map);
		      output11.close();
		      file11.close();
		      
		      
		      
		      System.out.println("the input file has been parsed and the index files have been generated");
			  System.out.println("");
			  System.out.println("if you want to query, please enter 2");
			  System.out.println("");
			  System.out.println("enter any other key to exit");
		      decide = sc1.next();
		}
		
		/*this section for serializing the hashmap objects
		 * 
		 * 
		 * */
		if(decide.equals("2"))
		{
			
			  InputStream file1 = new FileInputStream("id.ndx");
		      InputStream buffer1 = new BufferedInputStream(file1);
		      ObjectInput input1 = new ObjectInputStream (buffer1);
		      HashMap id_map1 = (HashMap)input1.readObject();
		      
		      
		      InputStream file2 = new FileInputStream("company.ndx");
		      InputStream buffer2 = new BufferedInputStream(file2);
		      ObjectInput input2 = new ObjectInputStream (buffer2);
		      HashMap company_map1 = (HashMap)input2.readObject();
		      
		      InputStream file3 = new FileInputStream("drug_id.ndx");
		      InputStream buffer3 = new BufferedInputStream(file3);
		      ObjectInput input3 = new ObjectInputStream (buffer3);
		      HashMap drug_id_map1 = (HashMap)input3.readObject();
		     
              
		      InputStream file4 = new FileInputStream("trials.ndx");
		      InputStream buffer4 = new BufferedInputStream(file4);
		      ObjectInput input4 = new ObjectInputStream (buffer4);
		      HashMap trials_map1 = (HashMap)input4.readObject();
		      
		      
		      InputStream file5 = new FileInputStream("patients.ndx");
		      InputStream buffer5 = new BufferedInputStream(file5);
		      ObjectInput input5 = new ObjectInputStream (buffer5);
		      HashMap patients_map1 = (HashMap)input5.readObject();
		      
		      InputStream file6 = new FileInputStream("dosage_mg.ndx");
		      InputStream buffer6 = new BufferedInputStream(file6);
		      ObjectInput input6 = new ObjectInputStream (buffer6);
		      HashMap dosage_map1 = (HashMap)input6.readObject();
		      
		      InputStream file7 = new FileInputStream("reading.ndx");
		      InputStream buffer7 = new BufferedInputStream(file7);
		      ObjectInput input7 = new ObjectInputStream (buffer7);
		      HashMap reading_map1 = (HashMap)input7.readObject();
		      
		      
		      InputStream file8 = new FileInputStream("double_blind.ndx");
		      InputStream buffer8 = new BufferedInputStream(file8);
		      ObjectInput input8 = new ObjectInputStream (buffer8);
		      HashMap double_blind_map1 = (HashMap)input8.readObject();
		      
		      InputStream file9 = new FileInputStream("controlled_study.ndx");
		      InputStream buffer9 = new BufferedInputStream(file9);
		      ObjectInput input9 = new ObjectInputStream (buffer9);
		      HashMap controlled_study_map1 = (HashMap)input9.readObject();
		      
		      InputStream file10 = new FileInputStream("govt_funded.ndx");
		      InputStream buffer10 = new BufferedInputStream(file10);
		      ObjectInput input10 = new ObjectInputStream (buffer10);
		      HashMap govt_funded_map1 = (HashMap)input10.readObject();
		      
		      
		      InputStream file11 = new FileInputStream("fda_approved.ndx");
		      InputStream buffer11 = new BufferedInputStream(file11);
		      ObjectInput input11 = new ObjectInputStream (buffer11);
		      HashMap fda_approved_map1 = (HashMap)input11.readObject();
		      
		      
		      
		      
			System.out.println("please enter 1 for chosing id");
			System.out.println("plesae enter 2 for chosing company");
			System.out.println("please enter 3 for chosing drug_id");
			System.out.println("please enter 4 for chosing trials");
			System.out.println("please enter 5 for chosing patients");
			System.out.println("please enter 6 for chosing dosage_mg");
			System.out.println("please enter 7 for chosing reading");
			System.out.println("please enter 8 for chosing double_blind");
			System.out.println("please enter 9 for chosing controlled_study");
			System.out.println("please enter 10 for chosing govt_funded");
			System.out.println("please enter 11 for chosing fda_approved");
			//System.out.println("please enter 8 for chosing double_blind");
			Scanner sc = new Scanner(System.in);
			String column_name = sc.nextLine();
			String operator="";
			int bool_number=0;
			String val="";
			if((!column_name.equals("8"))&&(!column_name.equals("9"))&&(!column_name.equals("10"))&&(!column_name.equals("11")))
			{
				System.out.println("please enter 1 for chosing =");
				System.out.println("plesae enter 2 for chosing >");
				System.out.println("please enter 3 for chosing <");
				System.out.println("please enter 4 for chosing >=");
				System.out.println("please enter 5 for chosing <=");
				System.out.println("please enter 6 for chosing !=");
				operator = sc.nextLine();
				System.out.println("please enter the value");
				val = sc.nextLine();
			}
			else
			{
				System.out.println("please enter 1 for true");
				System.out.println("please enter 2 for false");
				bool_number = Integer.parseInt(sc.nextLine());
			}
			ArrayList parse;
			if(column_name.equals("8"))
			{
				if(bool_number==1)
				{
					parse = (ArrayList) double_blind_map1.get("true");
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				else
				{
					parse = (ArrayList) double_blind_map1.get("false");
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
			}
			if(column_name.equals("9"))
			{
				if(bool_number==1)
				{
					parse = (ArrayList) controlled_study_map1.get("true");
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				else
				{
					parse = (ArrayList) controlled_study_map1.get("false");
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
			}

			if(column_name.equals("10"))
			{
				if(bool_number==1)
				{
					parse = (ArrayList) govt_funded_map1.get("true");
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				else
				{
					parse = (ArrayList) govt_funded_map1.get("false");
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				//}
			}

			if(column_name.equals("11"))
			{
				if(bool_number==1)
				{
					parse = (ArrayList) fda_approved_map1.get("true");
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				else
				{
					parse = (ArrayList) fda_approved_map1.get("false");
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
			}
			int val1=0;
			if(column_name.equals("1"))
				val1 = Integer.parseInt(val);

			int parse1=0;
			if(column_name.equals("1"))
			{
				if(operator.equals("1"))
				{
					parse1 = (int) id_map1.get(val1);
					show_output_id(r,parse1);
				}
				else if(operator.equals("2"))
				{
					Set key = id_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (int) setitr.next() + "";
						if(Integer.parseInt(number)>Integer.parseInt(val))
						{
							parse1 = (int) id_map1.get(Integer.parseInt(number));
							show_output_id(r,parse1);
						}
					}
				}
				else if(operator.equals("3"))
				{
					Set key = id_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (int) setitr.next() + "";
						if(Integer.parseInt(number)<Integer.parseInt(val))
						{
							parse1 = (int) id_map1.get(Integer.parseInt(number));
							show_output_id(r,parse1);
						}
					}

				}
				else if(operator.equals("4"))
				{
					Set key = id_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (int) setitr.next() + "";
						if(Integer.parseInt(number)>=Integer.parseInt(val))
						{
							parse1 = (int) id_map1.get(Integer.parseInt(number));
							show_output_id(r,parse1);
						}
					}
				}
				else if(operator.equals("5"))
				{
					Set key = id_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (int) setitr.next() + "";
						if(Integer.parseInt(number)<=Integer.parseInt(val))
						{
							parse1 = (int) id_map1.get(Integer.parseInt(number));
							show_output_id(r,parse1);
						}
					}
				}
				else if(operator.equals("6"))
				{
					Set key = id_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (int) setitr.next() + "";
						if(Integer.parseInt(number)!=Integer.parseInt(val))
						{
							parse1 = (int) id_map1.get(Integer.parseInt(number));
							show_output_id(r,parse1);
						}
					}
				}
			}
			if(column_name.equals("2"))
			{
				Set key = company_map1.keySet();
				Iterator setitr = key.iterator();
				while(setitr.hasNext())
				{
					String number = (String) setitr.next();
					if((number).contains(val))
					{
						parse = (ArrayList) company_map1.get(number);
						Iterator itr = parse.iterator();
						show_output(r,itr);
					}
				}
			}
			if(column_name.equals("3"))
			{

				Set key = drug_id_map1.keySet();
				Iterator setitr = key.iterator();
				while(setitr.hasNext())
				{
					String number = (String) setitr.next();
					if((number).contains(val))
					{
						parse = (ArrayList) drug_id_map1.get(number);
						Iterator itr = parse.iterator();
						show_output(r,itr);
					}
				}
			}
			if(column_name.equals("4"))
			{
				if(operator.equals("1"))
				{

					parse = (ArrayList) trials_map1.get(val);
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				else if(operator.equals("2"))
				{
					Set key = trials_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)>Integer.parseInt(val))
						{
							parse = (ArrayList) trials_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}

				}
				else if(operator.equals("3"))
				{
					Set key = trials_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)<Integer.parseInt(val))
						{
							parse = (ArrayList) trials_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("4"))
				{
					Set key = trials_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)>=Integer.parseInt(val))
						{
							parse = (ArrayList) trials_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("5"))
				{
					Set key = trials_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)<=Integer.parseInt(val))
						{
							parse = (ArrayList) trials_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("6"))
				{
					Set key = trials_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)!=Integer.parseInt(val))
						{
							parse = (ArrayList) trials_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
			}
			if(column_name.equals("5"))
			{
				if(operator.equals("1"))
				{

					parse = (ArrayList) patients_map1.get(val);
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				else if(operator.equals("2"))
				{
					Set key = patients_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)>Integer.parseInt(val))
						{
							parse = (ArrayList) patients_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("3"))
				{
					Set key = patients_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)<Integer.parseInt(val))
						{
							parse = (ArrayList) patients_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("4"))
				{
					Set key = patients_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)>=Integer.parseInt(val))
						{
							parse = (ArrayList) patients_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("5"))
				{
					Set key = patients_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)<=Integer.parseInt(val))
						{
							parse = (ArrayList) patients_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("6"))
				{
					Set key = patients_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)!=Integer.parseInt(val))
						{
							parse = (ArrayList) patients_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
			}
			if(column_name.equals("6"))
			{
				if(operator.equals("1"))
				{

					parse = (ArrayList) dosage_map1.get(val);
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				else if(operator.equals("2"))
				{
					Set key = dosage_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)>Integer.parseInt(val))
						{
							parse = (ArrayList) dosage_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("3"))
				{
					Set key = dosage_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)<Integer.parseInt(val))
						{
							parse = (ArrayList) dosage_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("4"))
				{
					Set key = dosage_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)>=Integer.parseInt(val))
						{
							parse = (ArrayList) dosage_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("5"))
				{
					Set key = dosage_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)<=Integer.parseInt(val))
						{
							parse = (ArrayList) dosage_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}

				}
				else if(operator.equals("6"))
				{
					Set key = dosage_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Integer.parseInt(number)!=Integer.parseInt(val))
						{
							parse = (ArrayList) dosage_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
			}
			if(column_name.equals("7"))
			{
				if(operator.equals("1"))
				{

					parse = (ArrayList) reading_map1.get(val);
					Iterator itr = parse.iterator();
					show_output(r,itr);
				}
				else if(operator.equals("2"))
				{
					Set key = reading_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Float.parseFloat(number)>Float.parseFloat(val))
						{
							parse = (ArrayList) reading_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("3"))
				{
					Set key = reading_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Float.parseFloat(number)<Float.parseFloat(val))
						{
							parse = (ArrayList) reading_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("4"))
				{
					Set key = reading_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Float.parseFloat(number)>=Float.parseFloat(val))
						{
							parse = (ArrayList) reading_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("5"))
				{
					Set key = reading_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Float.parseFloat(number)<=Float.parseFloat(val))
						{
							parse = (ArrayList) reading_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
				else if(operator.equals("6"))
				{
					Set key = reading_map1.keySet();
					Iterator setitr = key.iterator();
					while(setitr.hasNext())
					{
						String number = (String) setitr.next();
						if(Float.parseFloat(number)!=Float.parseFloat(val))
						{
							parse = (ArrayList) reading_map1.get(number);
							Iterator itr = parse.iterator();
							show_output(r,itr);
						}
					}
				}
			}			
		}
		r.close();
	}	
	public static void show_output_id(RandomAccessFile r,int offset) throws IOException
	{
		r.seek(offset);
		System.out.println("");
		System.out.println("id: "+r.readInt()+" ");
		int length = r.readByte();
		String comp_nm="";
		for(int i=0;i<length;i++)
		{
			comp_nm=comp_nm + (char)r.readByte();
		}
		String drug_id_name="";
		for(int i=0;i<6;i++)
		{
			drug_id_name= drug_id_name + (char)r.readByte();
		}
		String trials_name = (int)r.readChar() + "";
		String patients_name = (int)r.readChar() + "";
		String dosage_mg_name = (int)r.readChar() + "";
		String reading_name = r.readFloat() + "";
		byte truth = r.readByte();
		System.out.println("company: "+comp_nm + "  ");
		System.out.println("drug_id: "+drug_id_name + "  ");
		System.out.println("trials: "+trials_name + "  ");
		System.out.println("patients: "+patients_name + "  ");
		System.out.println("dosage_mg: "+dosage_mg_name + "  ");
		System.out.println("reading: "+reading_name);
		if(((truth) & (0x08))==0x08)
		{
			System.out.println("double_blind: true ");
		}
		else
		{
			System.out.println("double_blind: false ");
		}
		
		if(((truth) & (0x04))==0x04)
		{
			System.out.println("controlled_study: true ");
		}
		else
		{
			System.out.println("controlled_study: false ");
		}
		
		if(((truth) & (0x02))==0x02)
		{
			System.out.println("govt_funded: true ");
		}
		else
		{
			System.out.println("govt_funded: false ");
		} 
		
		
		if(((truth) & (0x01))==0x01)
		{
			System.out.println("fda_approved: true ");
		}
		else
		{
			System.out.println("fda_approved: false ");
		}
	}

	
	public static int setit(String line,RandomAccessFile r,int offset) throws IOException
	{
		char[] input = line.toCharArray();
		boolean byte_offset = false;
		String id="";
		int di = 0;
		int i = 0;
		int len = 0;
		byte bool = 0x00;
		while(input[i]!=',')
		{
			id = id + input[i] + "";
			i = i+1;
		}
		di = Integer.parseInt(id+"");
		Integer.toString(di,2);
		byte b = (byte)di;
		r.writeInt(di);
		id_map.put(di,offset);
		i = i + 1;
		String company = "";
		len = i+1;
		if(input[i]=='"')
		{
			byte_offset = true;
			i=i+1;
			while(input[i]!='"')
			{
				company = company + input[i];
				i = i+1;
			}
			len = (i - len);
			i = i + 1;
		}
		else
		{
			while(input[i]!=',')
			{
				company = company + input[i];
				i = i+1;
			}
			len = (i - len)+1;
		}
		r.writeByte(len);
		byte[] b2 = company.getBytes(Charset.forName("UTF-8"));
		r.write(b2);
		if(company_map.containsKey(company))
		{
			((ArrayList) company_map.get(company)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			company_map.put(company,com);
		}

		i = i + 1;
		String drug_id = "";
		while(input[i]!=',')
		{
			drug_id = drug_id + input[i];
			i = i+1;
		}
		i = i + 1;
		byte[] b3 = drug_id.getBytes(Charset.forName("UTF-8"));
		r.write(b3);
		if(drug_id_map.containsKey(drug_id))
		{
			((ArrayList) drug_id_map.get(drug_id)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			drug_id_map.put(drug_id,com);
		}

		String trials = "";
		while(input[i]!=',')
		{
			trials = trials + input[i];
			i = i+1;
		}
		i = i + 1;
		byte[] b4 = trials.getBytes(Charset.forName("UTF-8"));
		r.writeChar(Integer.parseInt(trials));
		if(trials_map.containsKey(trials))
		{
			((ArrayList) trials_map.get(trials)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			trials_map.put(trials,com);
		}
		String patients = "";
		while(input[i]!=',')
		{
			patients = patients + input[i];
			i = i+1;
		}
		i = i + 1;
		byte[] b5 = patients.getBytes(Charset.forName("UTF-8"));
		r.writeChar(Integer.parseInt(patients));
		if(patients_map.containsKey(patients))
		{
			((ArrayList) patients_map.get(patients)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			patients_map.put(patients,com);
		}
		String dosage_mg = "";
		while(input[i]!=',')
		{
			dosage_mg = dosage_mg + input[i];
			i = i+1;
		}
		i = i + 1;
		byte[] b6 = dosage_mg.getBytes(Charset.forName("UTF-8"));
		r.writeChar(Integer.parseInt(dosage_mg));
		if(dosage_map.containsKey(dosage_mg))
		{
			((ArrayList) dosage_map.get(dosage_mg)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			dosage_map.put(dosage_mg,com);
		}
		String reading = "";
		while(input[i]!=',')
		{
			reading = reading + input[i];
			i = i+1;
		}
		i = i + 1;
		byte[] b7 = reading.getBytes(Charset.forName("UTF-8"));
		r.writeFloat(Float.parseFloat(reading));
		if(reading_map.containsKey(reading))
		{
			((ArrayList) reading_map.get(reading)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			reading_map.put(reading,com);
		}
		String double_blind="";
		while(input[i]!=',')
		{
			double_blind = double_blind + input[i];
			i = i+1;
		}
		i = i + 1;
		if(double_blind.equals("true"))
		{
			bool = (byte) ((bool) | (0x08));
		}
		if(double_blind_map.containsKey(double_blind))
		{
			((ArrayList) double_blind_map.get(double_blind)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			double_blind_map.put(double_blind,com);
		}
		String controlled_study="";
		while(input[i]!=',')
		{
			controlled_study = controlled_study + input[i];
			i = i+1;
		}
		i = i + 1;
		if(controlled_study.equals("true"))
		{
			bool = (byte) ((bool) | (0x04));
		}
		if(controlled_study_map.containsKey(controlled_study))
		{
			((ArrayList) controlled_study_map.get(controlled_study)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			controlled_study_map.put(controlled_study,com);
		}
		String govt_funded="";
		while(input[i]!=',')
		{
			govt_funded = govt_funded + input[i];
			i = i+1;
		}
		i = i + 1;
		if(govt_funded.equals("true"))
		{
			bool = (byte) ((bool) | (0x02));
		}
		if(govt_funded_map.containsKey(govt_funded))
		{
			((ArrayList) govt_funded_map.get(govt_funded)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			govt_funded_map.put(govt_funded,com);
		}
		String fda_funded="";
		while(i<=(line.length()-1))
		{
			fda_funded = fda_funded + input[i];
			i = i+1;
		}
		i = i + 1;
		if(fda_funded.equals("true"))
		{
			bool = (byte) ((bool) | (0x01));
		}
		if(fda_approved_map.containsKey(fda_funded))
		{
			((ArrayList) fda_approved_map.get(fda_funded)).add(offset);
		}
		else
		{
			ArrayList com = new ArrayList();
			com.add(offset);
			fda_approved_map.put(fda_funded,com);
		}
		r.write(bool);
		offset = (byte)(22 + len);
		return offset;
	}
	public static void show_output(RandomAccessFile r,Iterator itr) throws IOException
	{
		while(itr.hasNext())
		{
			r.seek((int)itr.next());
			System.out.println("");
			System.out.println("id: "+r.readInt()+" ");
			int length = r.readByte();
			String comp_nm="";
			for(int i=0;i<length;i++)
			{
				comp_nm=comp_nm + (char)r.readByte();
			}
			String drug_id_name="";
			for(int i=0;i<6;i++)
			{
				drug_id_name= drug_id_name + (char)r.readByte();
			}
			String trials_name = (int)r.readChar() + "";
			String patients_name = (int)r.readChar() + "";
			String dosage_mg_name = (int)r.readChar() + "";
			String reading_name = r.readFloat() + "";
			byte truth = r.readByte();
			System.out.println("company: "+comp_nm + "   ");
			System.out.println("drug_id: "+drug_id_name + "   ");
			System.out.println("trials: "+trials_name + "   ");
			System.out.println("patients: "+patients_name + "   ");
			System.out.println("dosage_mg: "+dosage_mg_name + "   ");
			System.out.println("reading: "+reading_name);
			
			if(((truth) & (0x08))==0x08)
			{
				System.out.println("double_blind: true ");
			}
			else
			{
				System.out.println("double_blind: false ");
			}
			
			if(((truth) & (0x04))==0x04)
			{
				System.out.println("controlled_study: true ");
			}
			else
			{
				System.out.println("controlled_study: false ");
			}
			
			if(((truth) & (0x02))==0x02)
			{
				System.out.println("govt_funded: true ");
			}
			else
			{
				System.out.println("govt_funded: false ");
			}
			
			
			if(((truth) & (0x01))==0x01)
			{
				System.out.println("fda_approved: true ");
			}
			else
			{
				System.out.println("fda_approved: false ");
			}
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
		}
	}
}