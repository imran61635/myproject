package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import common.SetUp_API;

public class WOIDstoreInProperty extends SetUp_API {
	// This method store the generated WOID from CAWO into a WOID.property file
	public static void setWOIDinProperty(String woid) {
		WOID.setProperty("WOID", woid);
		try {
			WOID.store(new FileOutputStream("./src/test/resources/properties/WOID.properties"), null);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		
	}

}
