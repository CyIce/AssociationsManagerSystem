package com.cyice.ams.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileInput {

	public static List<String> readFile(String fileName) {

		List<String> allString = new ArrayList<>();
		String fileUrl = System.getProperty("user.dir") + "/file/documents/" + fileName + ".csv";
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader;
		FileInputStream fileInputStream;

		try {
			fileInputStream = new FileInputStream(fileUrl);
			inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
			bufferedReader = new BufferedReader(inputStreamReader);

			String line;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				i++;
				if (i <= 2) {
					continue;
				} else {
					allString.add(line);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return allString;

	}
}
