package lpgs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * LPGStest.java
 *
 *
 * A collection of JUNIT tests to test whether LPGS, the license plate game,
 * performs as planned.
 *
 * @author Blaez Jibben
 * @version 02/7/2024
 */
public class LPGSTest
{

	private LPGS lpgsTest;
	

	/**
 	* Before Each Method, declares a new object every new test
 	*
 	* @param
 	* @return void returns nothing,
 	*/
	@BeforeEach
	public void BeforeEach()
	{
		lpgsTest = new LPGS();
	}
	

	/**
 	*
 	*
 	*
 	*/
	@Test
	public void testGetDictionary()
				

	{
		//test the size of the array list versus 
		String file = "src/main/lpgs/dictionary.txt";
		assertEquals(file, lpgsTest.getDictionaryFile());
	}

	/**
	* Checks to see if WriteAnswers correctly writes to file by writing 3 strings,
	* then reading those strings.
	*
	* @param
	* @return void - returns nothing
	*/
	@Test
	public void testWriteAnswers()
	{
		//checks file to see if answers are succesfully written
		//to the file
		ArrayList<String> john = new ArrayList<String>();
		john.add("Test");
		john.add("Test2");
		john.add("Test3");

		lpgsTest.writeAnswers(john);
		
		ArrayList<String> realJohn = new ArrayList<String>();
		try {
			Scanner reader = new Scanner(new File(lpgsTest.getanswersFileName()));
				while(reader.hasNextLine())
				{
					realJohn.add(reader.nextLine());
				}
		}
		catch (FileNotFoundException e) {
			System.out.print("Error");
			return;
		}
			assertEquals(john, realJohn, "File is written incorrectly in writeAnswers"); //checks to see if both ArrayLists are equal
	}

	


}
