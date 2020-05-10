package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FormingQuizTeams {

    static double positions[][], dist [][] , dp[];
    static int maxPairs, players;

    public static void main(String args []) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n , t = 1;
        while((n = Integer.parseInt(in.readLine().trim())) != 0) {

            players = 2*n;
            maxPairs = (1<<(2*n))-1;;
            positions = new double[players][2];
            dp = new double[maxPairs];
            dist = new double[players][players];

            Arrays.fill(dp,-1);

            for(int i = 0; i < players; i++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                st.nextToken();
                positions[i][0] = Double.parseDouble(st.nextToken());
                positions[i][1] = Double.parseDouble(st.nextToken());
            }

            for(int i = 0; i < players; i++){
                for (int j = i+1; j < players; j++) {
                    dist[i][j] = dist[j][i] = dist(i,j);
                }
            }

            double sol = dp(0);

            out.printf("Case %d: %.2f%n",t,sol);

            t++;
        }

        out.close();
        in.close();
    }

    static double dist(int jugador1, int jugador2){
        double dist2 = (positions[jugador1][0] - positions[jugador2][0])*(positions[jugador1][0] - positions[jugador2][0]) +
                (positions[jugador1][1] - positions[jugador2][1])*(positions[jugador1][1] - positions[jugador2][1]);
        return Math.sqrt(dist2);
    }

    static double dp(int actualPairs){

        if(actualPairs== maxPairs) return 0;

        if(dp[actualPairs]!=-1) return dp[actualPairs];

        double min=Double.MAX_VALUE;

        for(int i = 0; i < players; i++) {
            if( ( actualPairs & (1<<i) ) == 0 ) {
                for(int j = i+1; j< players; j++) {
                    if( ( actualPairs & (1<<j) ) == 0 ) {
                        min = Math.min(min,dist[i][j]+dp(actualPairs|(1<<i)|(1<<j)));
                    }
                }
            }
        }
        return dp[actualPairs]=min;

    }
}
