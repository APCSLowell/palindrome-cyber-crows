import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  word=word.toLowerCase();
  word=onlyLetters(word);
  word=noSpaces(word);
  if (word.equals(reverse(word)))
    return true;
  return false;
}


public String reverse(String str)
{
  str=str.toLowerCase();
  str=onlyLetters(str);
  str=noSpaces(str);
  String answer="";
  int count=0; 
  for (int i=1;i<str.length()+1;i++){
    answer+=str.substring(str.length()-i,str.length()-count);
    count++;
  }
  return answer;
}

public String onlyLetters(String sString){
  String answer="";
  for(int i=0;i<sString.length();i++){
    if(Character.isLetter(sString.charAt(i)))
      answer+=sString.charAt(i);
  }
  return answer; 
}

public String noSpaces(String sWord) {
    String answer = ""; // Initialize an empty string to store result

    for (int i = 0; i < sWord.length(); i++) { // Loop through each character
        if (sWord.charAt(i) != ' ') { // Check if character is not a space
            answer += sWord.charAt(i); // Append non-space character to answer
        }
    }

    return answer; // Return the modified string
}
}//end of class
