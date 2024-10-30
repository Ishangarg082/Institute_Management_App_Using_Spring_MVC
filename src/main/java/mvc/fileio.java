package mvc;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.sql.ResultSet;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class fileio {
	public ArrayList<ArrayList<?>> input() {
		String line = null;
		ArrayList<ArrayList<?>> arr = new ArrayList<>();
		try {

			String File_path = "D:\\ishan\\java\\aop\\temp.txt";
			File file = new File(File_path);

			if (!file.exists()) {

				System.out.println("File not found: " + File_path);
			}

			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			while ((line = buffer.readLine()) != null) {
				ArrayList<String> lineList = new ArrayList<>(Arrays.asList(line.split("\\|")));
				arr.add(lineList);

			}

		} catch (Exception e) {

			System.out.println(e);
		}
		return arr;
	}

	public void result(StringBuffer sb) {
		FileWriter file = null;
		try {
			String File_path = "D:\\ishan\\java\\aop\\Output.txt";
			file = new FileWriter(File_path);
			String fileData = sb.toString();
			file.write(fileData);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				file.flush();
				file.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
