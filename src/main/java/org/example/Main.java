package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int k = 0;
		int[] arr = new int[n];
		while(st2.hasMoreElements()){
			arr[k]= Integer.parseInt(st2.nextToken());
			k++;
		}
		int answer = 0,sum=0,lt=0;
		for (int rt = 0; rt < n; rt++) {
			sum= sum+arr[rt];
			if(sum==m){
				answer++;
			}
			while(sum>=m){
				sum-=arr[lt++];
				if(sum==m){
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}