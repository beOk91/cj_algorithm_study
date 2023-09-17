package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon2085 {
	
	public static int[][] arr = new int[9][9];
	
	public static void main(String[] args)  throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		doSudoku(0,0);
	
		
	}
	
	public static void doSudoku(int col, int row) {
				if (col == 9) {
					doSudoku(row + 1, 0);
					return;
				}
		 
				if (row == 9) {
					for (int i = 0; i < 9; i++) {
						for (int j = 0; j < 9; j++) {
							System.out.print(arr[i][j] + " ");
						}
						System.out.println();
					}
		 
					// 출력 뒤 시스템을 종료한다.
					System.exit(0);
				}
		 
				if (arr[row][col] == 0) {
					for (int i = 1; i <= 9; i++) {
						if (checkPossible(row, col, i)) {
							arr[row][col] = i;
							doSudoku(row, col + 1);
						}
					}
					arr[row][col] = 0;
					return;
				}
		 
				doSudoku(row, col + 1);		
	}
	
	public static boolean checkPossible(int row,int col, int value) {
		

		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == value) {
				return false;
			}
		}
 
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == value) {
				return false;
			}
		}
 
		int set_row = (row / 3) * 3; 
		int set_col = (col / 3) * 3; 
 
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (arr[i][j] == value) {
					return false;
				}
			}
		}
 
		return true; 
	}

}
