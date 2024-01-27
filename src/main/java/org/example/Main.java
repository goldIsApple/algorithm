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
		int K = Integer.parseInt(st.nextToken());


		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st2.nextToken());
		}
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum+=data[i];
		}
		int answer = sum;
		for (int i =K ; i <N ; i++) {
			sum = sum + data[i] - data[i-K];
			answer = Math.max(sum,answer);
		}
		System.out.println(answer);

	}
}
//10 3
//12 15 11 20 25 10 20 19 13 15