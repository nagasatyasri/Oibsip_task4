import java.util.*;
public class OnlineExamManagement {
Scanner scobj = new Scanner(System.in);
HashMap<String,Integer> Details = new HashMap<String,Integer>();
    public void User_Login() {
		Details.put("satya",6523);
		System.out.println("\n --------------------------------- WELCOME TO THE ONLINE EXAM PORTAL ---------------------------------");
		String Uname;
		System.out.println("Enter UserName : ");
		Uname = scobj.next();
		int PWD;
		System.out.println("Enter Password : ");
		PWD= scobj.nextInt();
		if(Details.containsKey(Uname)) {
			if(Details.get(Uname)==PWD){
				System.out.println("\n Welcome @ User");
				Options_Menu();	}
			else {
				System.out.println("Please Enter Valid Password For: "+Uname);
				User_Login();    }
        }
		else{
			System.out.println("Please Enter Valid User Name");
		}
    
	}
	public void Options_Menu() {
		int Choice;
		System.out.println("=======User Menu=======");
		System.out.println("1.Update Profile \n 2.Write Exam \n 3.Exit ");
		System.out.println("Enter The Choice: ");
		Choice = scobj.nextInt();
		switch(Choice) {
		case 1:
			Details=Update_Details();
			Options_Menu();
			break;
		case 2:
			Examination();
			Options_Menu();
			break;
		case 3:
            System.out.println("Thanks For Using!!!");
			System.exit(0);
			break;
		default:
			System.out.println("Please Enter Number in User Menu Only");
		}
	}
	public HashMap<String,Integer> Update_Details(){
		String update_name;
		int update_pwd;
		System.out.println("updateDetails Profile");
		System.out.println("Enter The Username: ");
		update_name = scobj.next();
		if(Details.containsKey(update_name)) {
		System.out.println("Enter New Password for your Account");
		update_pwd = scobj.nextInt();
		Details.replace(update_name, update_pwd);
        System.out.println("Updated Your Details Successfully....");
		}
		else {
			System.out.println("Enter The Correct UserName");
		}
		return Details;
	}
public void Examination() {
    Calendar cr = Calendar.getInstance();
	long StartTime=System.currentTimeMillis();
	long EndTime=StartTime+30;
	int AnsweredQueries=0;
	int UserAnswer,MarksSecured;
	System.out.println("Please Start Your Exam");
	System.out.println("Examination Instructions: ");
	System.out.println("You Have To Answer 5 Questions in 30 Seconds");
	System.out.println("Each Question carries 10 marks and -5 for wrong answer");
	HashMap<String,ArrayList<String>> queries=new HashMap<String,ArrayList<String>>();
	ArrayList<String> Ques1=new ArrayList<String>();
    Ques1.add("java.lang.object");
	Ques1.add("java.lang.String");
	Ques1.add("java.lang.util");
	Ques1.add("none");
	Ques1.add("1");
	queries.put("In which of the following is toString() method defined?",Ques1);
	ArrayList<String> Ques2=new ArrayList<String>();
	Ques2.add("exception");
	Ques2.add("error");
	Ques2.add("52 I");
	Ques2.add("none");
	Ques2.add("3");
	queries.put(" from this code snippet predict the output : int a=52; \n char c= \'I\'; \n System.out.print(a);\n System.out.print(c);",Ques2);
	ArrayList<String> Ques3=new ArrayList<String>();
	Ques3.add("short to int");
	Ques3.add("byte to int");
	Ques3.add("long to int");
	Ques3.add("int to long");
	Ques3.add("4");
	queries.put("Automatic type conversion is possible in which of the possible cases?",Ques3);
	ArrayList<String> Ques4=new ArrayList<String>();
	Ques4.add("length of the array");
	Ques4.add("A copy of the array");
	Ques4.add("the reference of the array");
	Ques4.add("copy of the first element");
	Ques4.add("3");
	queries.put("In JAVA, When an array is passed to a method, what does the method receive?",Ques4);
    ArrayList<String> Ques5=new ArrayList<String>();
	Ques5.add("32 and 32");
	Ques5.add("32 and 64");
	Ques5.add("64 and 64");
	Ques5.add("64 and 32");
	Ques5.add("2");
	queries.put("What is the size of float and double in java?",Ques5);
	int sno=0;
    Set<String> set=queries.keySet(); 
    ArrayList<String> al=new ArrayList<>(set);
    int x=al.size();
	while(System.currentTimeMillis()<EndTime || sno<x) {
        String i=al.get(sno);
		System.out.println("\n\nQ."+(sno+1)+") "+i);
		System.out.println("\n(1) "+queries.get(i).get(0)+"\t"+"(2) "+queries.get(i).get(1)+"\t"+"(3) "+queries.get(i).get(2)+"\t"+"(4) "+queries.get(i).get(3)+" ");
		System.out.println("Enter Option");
		UserAnswer=scobj.nextInt();
		System.out.println("Your Answers Are Submited.....");
		if(UserAnswer==Integer.parseInt(queries.get(i).get(4))) {
			AnsweredQueries++;
		}
        sno++;
	}
	System.out.println("You Have Completed the Exam");
	MarksSecured=AnsweredQueries*10-((5-AnsweredQueries)*5); 
	System.out.println("Your score is..."+" "+MarksSecured+"/50");	
}

public static void main (String[] args)
{
	OnlineExamManagement em =new OnlineExamManagement();
		em.User_Login(); 
}
}