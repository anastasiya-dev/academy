package by.academy.lesson12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task3 {
	public static void main(String[] args) {
			
		try (BufferedReader br = new BufferedReader(new FileReader("src\\by\\academy\\DealApplication\\cheque1.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("src\\by\\academy\\DealApplication\\cheque1_copy.txt"))) {
			
			int a;
			while((a = br.read()) != -1) {
				bw.write(a);
			}			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}	
}
