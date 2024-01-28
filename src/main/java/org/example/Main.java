package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(st2.nextToken());
		}
		int sum =0,lt=0;
		int answer = 0;
		for (int rt = 0; rt < N; rt++) {
			sum = sum+arr[rt];
			while(sum>M){
				sum = sum - arr[lt++];
			}
			if(sum==M){
				answer++;
			}
		}
		System.out.println(answer);
	}
}