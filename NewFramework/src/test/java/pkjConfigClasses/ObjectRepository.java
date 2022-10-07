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
import java.io.FileInputStream;
import java.util.Properties;

public class ObjectRepository {

	public Properties objRepo;
	public File propFile;
	public FileInputStream propFileInputStream;

	public void mthdCreateObjectRepository() {
		try {

			propFile = new File("C:\\Users\\vijay\\git\\newFramework\\NewFramework\\ObjectRepository.Properties");
			propFileInputStream = new FileInputStream(propFile);
			objRepo = new Properties();
			objRepo.load(propFileInputStream);

		}

		catch (Exception e) {
			System.out.println("Error Occured in Reading Object Repository" + e.getStackTrace());
		}
	}
}
