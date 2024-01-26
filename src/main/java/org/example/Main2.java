package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	private static int start;
	private static int end;
	private static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		go(0);
		System.out.println(count);
	}

	private static void go(long num) {
		if(num>end){
			return;
		}
		if(num>=start){
			count++;
		}
		go(num * 10 + 4);
		go(num * 10 + 7);
	}

}