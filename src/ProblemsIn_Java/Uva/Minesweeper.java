package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Minesweeper {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int fil =Integer.parseInt(st.nextToken());
		int col =Integer.parseInt(st.nextToken());
		int caso = 1;
		while(true){
			if(fil==0){
				break;
			}else{
				char array [][] = new char [fil][];
				for (int i = 0; i < fil; i++) {
					array[i] = in.readLine().toCharArray();
				}
				out.write("Field #"+caso+":"+"\n");
				String f [][] = array(array,fil,col);
				for (int i = 0; i < f.length; i++) {
					for (int j = 0; j < f[i].length; j++) {
						out.write(f[i][j]);
					}
					out.write("\n");
				}
			}
			st = new StringTokenizer(in.readLine()," ");
			fil =Integer.parseInt(st.nextToken());
			col =Integer.parseInt(st.nextToken());
			if(fil!=0){
				out.write("\n");
			}
			caso++;
		}
		
		out.close();
		in.close();
	}
	public static String [][] array(char [][]arreglo,int fil,int col){
		String array[][] = new String[fil][col];
		
		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo[i].length; j++) {
				if(arreglo[i][j]=='*'){
					array[i][j] = "*";
				}else{
					int carac = 0;
					if(i-1>-1 && j-1>-1){
						if(arreglo[i-1][j-1]=='*') carac+=1;
					}
					if(i-1 > -1){
						if(arreglo[i-1][j]=='*') carac+=1;
					}
					if(i-1 > -1 && j+1<col){
						if(arreglo[i-1][j+1]=='*') carac+=1;
					}
					if(j-1 > -1){
						if(arreglo[i][j-1]=='*') carac+=1;
					}
					if(j+1 < col){
						if(arreglo[i][j+1]=='*') carac+=1;
					}
					if(i+1 < fil && j-1 > -1){
						if(arreglo[i+1][j-1]=='*') carac+=1;
					}
					if(i+1 < fil){
						if(arreglo[i+1][j]=='*') carac+=1;
					}
					if(i+1 < fil && j+1<col){
						if(arreglo[i+1][j+1]=='*') carac+=1;
					}
					array[i][j]=carac+"";
				}
			}
		}
		
		return array;
	}
}
