package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String initStr = br.readLine();
		List<Character> list = new LinkedList<>();
		for (char c : initStr.toCharArray()) {
			list.add(c);
		}
		int size = Integer.parseInt(br.readLine());
		ListIterator<Character> list2 = list.listIterator();

		while(list2.hasNext()){
			list2.next();
		}
		for (int i = 0; i < size; i++) {
			String command = br.readLine();
			char com = command.charAt(0);
			if(com=='L'){
				if(list2.hasPrevious()){
					list2.previous();
				}
			}else if(com=='D'){
				if(list2.hasNext()){
					list2.next();
				}
			}else if(com=='B'){

				if(list2.hasPrevious()){
					list2.previous();
					list2.remove();
				}
			}else if(com=='P'){
				list2.add(command.charAt(2));
			}
		}
		for(Character chr : list) {
			bw.write(chr);
		}
		bw.flush();
		bw.close();
	}
}