/**
 * 672115016 Natthapat Jagkhuruang 
 * 
 * SE102 programming assignment 953102-ADT & PROBLEM SOLVING-Lec.701[2/67]
 */


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.StringTokenizer;

public class mainData {
    public static void main(String[] args) throws FileNotFoundException{
        String file = "",choice = "", StudentName = "", choiceLetter = "", inputUser= "";
         
        Vector<Students> data = new Vector<>();
        Vector<String> tempdata = new Vector<>();
        Scanner input =new Scanner(System.in);

        System.out.println();
        System.out.println("[option] [input filePath  or fileName] for Search [option] [StudentName] [input filePath  or fileName]");
        System.out.println();
        inputUser = input.nextLine();
        System.out.println();
        StringTokenizer inu = new StringTokenizer(inputUser.trim(), " ");
        choiceLetter = inu.nextToken();
        if (choiceLetter.equals("-s")) {
            StudentName = inu.nextToken().toLowerCase();
            file = inu.nextToken();
        }else{
            file = inu.nextToken();
        }
        //class_roaster67.csv

        File f = new File(file);
        Scanner inf = new Scanner(f);

        for(int i = 0;i <7;i++){
            inf.nextLine();
        }

        while (inf.hasNextLine()) {
            String line = inf.nextLine();
            StringTokenizer stu = new StringTokenizer(line.trim(), ",");
            stu.nextToken();
            data.addElement(new Students ( stu.nextToken().trim(), stu.nextToken().trim(), stu.nextToken().trim()));
        }
        


        
        switch (choiceLetter) {
            case "-n":
                for(int i = 0;i<data.size();i++){
                tempdata.addElement(data.elementAt(i).getSID());
                }
                System.out.println("Sort by student Number");
                System.out.println();
                sortData(data, tempdata);
                   break;

            case "-f":
                for(int i = 0;i<data.size();i++){
                tempdata.addElement(data.elementAt(i).getFirstName());
                }
                System.out.println("Sort by student Firstname");
                System.out.println();
                sortData(data, tempdata);
                    break;

            case "-l":
                for(int i = 0;i<data.size();i++){
                    tempdata.addElement(data.elementAt(i).getLastName());
                }
                System.out.println("Sort by student Lastname");
                System.out.println();
                sortData(data, tempdata);
                    break;
                
            case "-s":  
                System.out.println();
                searchStudent(data, StudentName);
                    break;
        
            default: System.out.println("Please Enter again !!!!");
                    break;
            }
 
       
        

    }

    public static void sortData(Vector<Students> students, Vector<String> tempdata ){

        String tempForData ;
        
        
        
        for(int i = 0 ;i < students.size()-1;i++){
            for(int j = 0;j<students.size()-1-i;j++){
                if (tempdata.elementAt(j).compareTo(tempdata.elementAt(j + 1)) > 0) {
                    Students temp = students.elementAt(j);
                    students.set(j, students.elementAt(j+1));
                    students.set(j+1, temp);

                    
                    tempForData = tempdata.elementAt(j);
                    tempdata.set(j, tempdata.elementAt(j+1));
                    tempdata.set(j+1, tempForData);

                }
            }

        }

        for(Students i : students){
            System.out.println(i);
        }

        System.out.println();


    }

    public static void searchStudent(Vector<Students> students , String Name){

        for(int i = 0; i< students.size()+1 ;i++){
            if (i < students.size()) {
                if (((students.elementAt(i).getFirstName())).trim().toLowerCase().equals(Name.trim())) {
                    System.out.println("Found at index "+i);
                    System.out.println(students.elementAt(i));
                    System.out.println();
                    break;
                }
            }else{
                System.out.println("Not Found !!");
                System.out.println();
            }
                
            
            
        }
    }
}