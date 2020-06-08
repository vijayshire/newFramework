/*
-----------------------------------------------------------------------------------------------------
|	Developer	: 	Vijay Hire												 					 	 	
*	Project		: 	NewFramework																 
|	Location	: 	Pune																		 
*	Date		: 	2020-06-08											 
|	File		:	caller.java																 
*	Copyright (C) Abibue Tech - All Rights Reserved												 
|   		Unauthorized copying of this file, via any medium is strictly prohibited			 
*   		Proprietary and confidential														 
|  			Written by Vijay Hire <iamvijayhire@gmail.com>.
-----------------------------------------------------------------------------------------------------										 
*/

package pkjConfigClasses;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Config {

	public File parentFolder;
	public String varTimeStamp;
	public String varPathforSubFolder;
	public File subFolder;

	public void mthdCreateParentFolder() {

		try {
			varTimeStamp = new SimpleDateFormat("dd-MMM-yyyy hh.mm a").format(Calendar.getInstance().getTime());

			parentFolder = new File("C:\\Users\\vijay\\git\\newFramework\\NewFramework\\test-output\\" + varTimeStamp);

			if (!parentFolder.exists()) {

				parentFolder.mkdir();
				System.out.println("Parent Folder Created..." + parentFolder);
			}

			varPathforSubFolder = parentFolder.getAbsolutePath();
		}

		catch (Exception e) {

			System.out.println(e.getStackTrace());
		}

	}

	public void mthdCreateSubfolder(String varTestCaseName) {

		try {
			subFolder = new File(varPathforSubFolder + "//" + varTestCaseName);
			if (!subFolder.exists()) {

				subFolder.mkdir();
				System.out.println("Sub Folder Created...." + subFolder);
			}
		} catch (Exception e) {

			System.out.println(e.getStackTrace());
		}
	}

	public static void main(String args[]) {

		Config obj = new Config();

		obj.mthdCreateParentFolder();
		obj.mthdCreateSubfolder("test1");

	}

}
