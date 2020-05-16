public class dp{
    public static void main(String[] args){
        solve();
    }
    public static void solve(){
        // basic();
        pathseries();
    }
    public static void basic(){

        // int n = 5;
        // int[] dp = new int[n+1];
        // int ans = 0;

        // ans = fib_memo(n,dp);
        // ans = fib_DP(n, dp);
        // ans = fact_memo(n, dp);
        // ans = fact_DP(n, dp);

        // display(dp);
        // System.out.print(ans);
    }

    public static void pathseries(){
        // int sr=0;
        // int sc=0;
        // int er=2;
        // int ec=2;
        // int ans=1;
        // int [][] dp = new int[er+1][ec+1];
    
        // ans = mazepathHV_memo(sr, sc, er, ec,dp);
        // ans = mazepathHV_DP(sr, sc, er, ec,dp);
        // ans = mazepathHVD_multi_memo(sr, sc, er, ec,dp);
        // ans = mazepathHVD_multi_DP(sr, sc, er, ec,dp);
        

        // int si=0;
        // int ei=10;
        // int ans=0;
        // int[]dp = new int[ei+1];
        // ans = boardPath_memo(si, ei,dp);
        // ans = boardPath_DP(si, ei,dp);
        // ans = boardPath_user_memo(si, ei, dp);
        // ans = boardPath_user_DP(si, ei, dp);


        // System.out.println(ans);
        // display(dp);
    }
    public static void display(int[] arr){
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display_2D(int[][]arr){
        for(int[] ar:arr){
            for(int ele:ar){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static int fib_memo(int n, int [] dp){

        if(n<=1) {
            dp[n] = n;
            return n;
        }
        if(dp[n]!=0) return dp[n];

        int ans = fib_memo(n-1,dp)+fib_memo(n-2,dp);
        return dp[n] = ans;
    }

    public static int fib_DP(int n, int[] dp){
        for(int i=0; i<=n; i++){
            if(i<=1) {
                dp[i] = i;
                continue;
            }
            // if(dp[n]!=0) return dp[n];
    
            int ans = dp[i-1]+dp[i-2];
            dp[i] = ans;
        }
        return dp[n];
    }

    public static int fact_memo(int n, int[] dp){
        if(n<1){
            dp[n] = 1;
            return dp[n];
        } 
        if(dp[n]!=0) return dp[n];
        int ans =  n*fact_memo(n-1,dp);
        return dp[n] =ans;
    }

    public static int fact_DP(int n, int[] dp){
        for(int i=0;i<=n;i++){
            if(i<1){
                dp[i] = 1;
                continue;
            } 
            // if(dp[n]!=0) return dp[n];
            int ans =  i*dp[i-1];
            dp[i] = ans;
        }
        return dp[n];
    }

      
    public static int mazepathHV_memo(int sr, int sc, int er, int ec, int[][] dp){
        if(sr==er&&sc==ec){
            dp[sr][sc] = 1;
            return dp[sr][sc];
        } 
        if(dp[sr][sc]!=0) return dp[sr][sc];
        int count = 0;
        if(sr+1<=er)  count+=mazepathHV_memo(sr+1, sc, er, ec,dp);
        if(sc+1<=ec)  count+=mazepathHV_memo(sr, sc+1, er, ec,dp);
        dp[sr][sc] = count;
        return dp[sr][sc];
    }
    
    public static int mazepathHV_DP(int sr, int sc, int er, int ec, int[][] dp){
        for(sr=er;sr>=0;sr--){
            for(sc = ec;sc>=0;sc--){
                if(sr==er&&sc==ec){
                    dp[sr][sc] = 1;
                    continue;
                } 
                // if(dp[sr][sc]!=0) return dp[sr][sc];
                int count = 0;
                if(sr+1<=er)  count+=dp[sr+1][sc];
                if(sc+1<=ec)  count+=dp[sr][sc+1];
                dp[sr][sc] = count;
            }
        }
        return dp[0][0];
    }

    public static int mazepathHVD_multi_memo(int sr, int sc, int er, int ec, int[][]dp){
        if(sr==er&&sc==ec){
            dp[sr][sc] = 1;
            return 1;
        }
        if(dp[sr][sc]!=0) return dp[sr][sc];
        int count=0;
        for(int jump=1; jump<=er;jump++){
            if(sr+jump<=er) count+=mazepathHVD_multi_memo(sr+jump, sc, er, ec,dp);
        }
        for(int jump=1; jump<=ec;jump++){
            if(sc+jump<=ec) count+=mazepathHVD_multi_memo(sr, sc+jump, er, ec,dp);
        }
        for(int jump=1; jump<=er && jump<=ec; jump++){
            if(sr+jump<=er && sc+jump<=ec) count+=mazepathHVD_multi_memo(sr+jump, sc+jump, er, ec,dp);
        }
        dp[sr][sc] = count;
        return dp[sr][sc];
    }

    public static int mazepathHVD_multi_DP(int sr, int sc, int er, int ec, int [][] dp){
        for(sr=er;sr>=0; sr--){
            for(sc=ec;sc>=0;sc--){
                if(sr==er && sc==ec){
                    dp[sr][sc] = 1;
                    continue;
                }
                // if(dp[sr][sc]!=0) return dp[sr][sc];
                int count=0;
                for(int jump=1; jump<=er;jump++){
                    if(sr+jump<=er) count+=dp[sr+jump][sc];
                }
                for(int jump=1; jump<=ec;jump++){
                    if(sc+jump<=ec) count+=dp[sr][sc+jump];
                }
                for(int jump=1; jump<=er && jump<=ec; jump++){
                    if(sr+jump<=er && sc+jump<=ec) count+=dp[sr+jump][sc+jump];
                }
                dp[sr][sc] = count;
            }
        }
        return dp[0][0];
    }

    public static int boardPath_memo(int si,int ei, int[] dp){
        if(si==ei){
            dp[si] = 1;
            return dp[si];
        }
        if(dp[si]!=0) return dp[si];
        int count = 0;
        for(int dice=1; dice<=6;dice++){
            if(si+dice<=ei) count+=boardPath_memo(si+dice, ei,dp); 
        }
        dp[si] = count;
        return dp[si];
    }

    public static int boardPath_DP(int si, int ei, int[]dp){
        for(si=ei;si>=0;si--){
            if(si==ei){
                dp[si] = 1;
                continue;
            }
            // if(dp[si]!=0) return dp[si];
            int count = 0;
            for(int dice=1; dice<=6;dice++){
                if(si+dice<=ei) count+=dp[si+dice]; 
            }
            dp[si] = count;
        }
        return dp[0];
    }

    public static int boardPath_user_memo(int si,int ei, int[] dp){
        if(si==ei){
            dp[si] = 1;
            return dp[si];
        }
        if(dp[si]!=0) return dp[si];
        int [] user = {3,5,7};
        int count=0;
        for(int i=0;i<user.length;i++){
            if(si+user[i]<=ei){
                count+=boardPath_user_memo(si+user[i], ei, dp);
            }
        }
        dp[si] = count;
        return dp[si];
    }


    public static int boardPath_user_DP(int si, int ei, int[] dp){
        for(si=ei;si>=0;si--){
            if(si==ei){
                dp[si] = 1;
                continue;
            }
            // if(dp[si]!=0) return dp[si];
            int [] user = {3,5,7};
            int count=0;
            for(int i=0;i<user.length;i++){
                if(si+user[i]<=ei){
                    count+=dp[si+user[i]];
                }
            }
            dp[si] = count;
        }
        return dp[0];
    }

    

}