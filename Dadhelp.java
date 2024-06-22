/* This program takes the dates from the medisoft software that are placed
in the input.txtfile and converts themn into the date in correct format in
theDad'sDatesFixed file.
By: Kyle Dramov
*/
import java.text.*;
import java.util.*;
import java.io.*;
public class Dadhelp
{
   public static void main(String[]args) throws IOException
   {
      //Define variables
      String date, day, month, year, doneYear, doneMonth, doneDay;
      
      //create 2 decimal formats and scanner
      DecimalFormat dayFormat= new DecimalFormat ("00");
      DecimalFormat yearFormat= new DecimalFormat ("0000");
      //Creates a new file and prints into it all the dates in correct format
      FileWriter fw= new FileWriter("Dad'sDatesFixed1.txt", false);
      PrintWriter pw=new PrintWriter(fw);
      File inputFile= new File("input.txt");
      Scanner file= new Scanner(inputFile);
      while (file.hasNext())
      {
       //Get date in wrong format
     
         date= file.next();
         int length = date.length();
      // create an index for both slashes
         int slash= date.indexOf("/");
         int lastSlash= date.lastIndexOf("/");
      //Substring each section
         day= date.substring(0,slash);
         month= date.substring(slash+1,lastSlash);
         year= date.substring(lastSlash+1,length);
      //Parse each section
         int correctDay= Integer.parseInt(day);
         int correctMonth= Integer.parseInt(month);
         int correctYear= Integer.parseInt(year);
      //Put each section into the correct format
         doneDay= dayFormat.format(correctDay);
         doneMonth= dayFormat.format(correctMonth);
         doneYear= yearFormat.format(correctYear);
         pw.println(doneDay+"/"+doneMonth+"/"+doneYear);
         }
      pw.println("End of file deteceted I really hope this works Dad"); 
      pw.close();
    }
}