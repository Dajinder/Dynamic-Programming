public class dp{
    public static void main(String[] args){
        solve();
    }
    public static void solve(){
        // basic();
        // pathseries();
        StringSet();
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

    //String Set ==============================================

    public static void StringSet(){
        String str = "babbac";
        int [][] dp = new int [str.length()][str.length()];


        // System.out.println(ispalindrome_iterativre(str));
        // System.out.println(longestPalindromeSubstring_dp(str,dp));
        // System.out.println(longestPalindromeSubsequence_dp(str,dp));
        // System.out.println(longestPalindromeSubsequence_memo(str, 0, str.length()-1,dp));
        // System.out.println(countpalindromeLSeq_memo(str,0,str.length()-1,dp));
        // System.out.println(countpalindromeLSeq_dp(str,0,str.length()-1,dp));


        display_2D(dp);
    }

    public static boolean ispalindrome_iterativre(String str){
        int s = 0;
        int e = str.length()-1;
        while(s<e){
            if(str.charAt(s)!=str.charAt(e)) return false;
            
            s++;
            e--;

        }
        return true;
    }

    public static int longestPalindromeSubstring_dp(String str,int[][]dp){

        int maxLength = 0;
        for(int gap=0; gap<str.length();gap++){
            for(int si=0,ei=gap;ei<str.length();si++,ei++){
                if(gap==0) dp[si][ei] = 1;
 
                else if(str.charAt(si)==str.charAt(ei) && gap==1) dp[si][ei] = 2;
                else if(str.charAt(si)==str.charAt(ei) && dp[si+1][ei-1]!=0){
                    dp[si][ei] = dp[si+1][ei-1]+2;
                }
                maxLength = Math.max(maxLength,dp[si][ei]);
            }
        }
        return maxLength ;
    }

    public static int longestPalindromeSubsequence_memo(String str,int si, int ei, int [][]dp){
        if(si>ei) return 0;
        if(si==ei) {
            dp[si][ei] = 1;
            return dp[si][ei];
        }
        if(dp[si][ei]!=0) return dp[si][ei];
        int max = 0;
        if(str.charAt(si)==str.charAt(ei)) return dp[si][ei] = longestPalindromeSubsequence_memo(str, si+1, ei-1,dp)+2;
        else{
            int withoutLastChar = longestPalindromeSubsequence_memo(str, si+1, ei,dp);
            int withoutFirstChar = longestPalindromeSubsequence_memo(str, si, ei-1,dp);
            max = Math.max(withoutLastChar,withoutFirstChar); 
        }
        dp[si][ei] = max;
        return dp[si][ei];
    }

    public static int longestPalindromeSubsequence_dp(String str,int[][]dp){
        // int[][] dp = new int [str.length()][str.length()]; 
        int max=0;
        for(int gap = 0;gap<str.length();gap++){
            for(int si=0,ei=gap;ei<str.length();si++,ei++){
                if(gap==0) dp[si][ei] = 1;
                else if(str.charAt(si)==str.charAt(ei))dp[si][ei] = dp[si+1][ei-1]+2;
                else {
                    int a = dp[si+1][ei];
                    int b = dp[si][ei-1];
                    max = Math.max(a, b);
                    dp[si][ei] = max;
                }
            }
        }
        display_2D(dp);
        return dp[0][str.length()-1];
    }

    public static int  countpalindromeLSeq_memo(String str, int si, int ei,int[][]dp){
        // dp = new int[str.length()][str.length()];
        if(si>ei) return 0;
        if(si==ei) return dp[si][ei] = 1;
        if(dp[si][ei]!=0) return dp[si][ei];
        int middleSeq = countpalindromeLSeq_memo(str, si+1, ei-1,dp);
        int withoutFirstchar = countpalindromeLSeq_memo(str, si+1, ei,dp);
        int withoutLastchar = countpalindromeLSeq_memo(str, si, ei-1,dp);

        if(str.charAt(si)==str.charAt(ei)) return dp[si][ei] = withoutFirstchar+withoutLastchar+1;
        else return dp[si][ei] = withoutFirstchar+withoutLastchar-middleSeq;
    }
    public static int countpalindromeLSeq_dp(String str, int si, int ei,int[][]dp){
        // int[][]dp = new int[str.length()][str.length()];
        for(int gap=0;gap<str.length();gap++){
            for(si=0,ei=gap;ei<str.length();si++,ei++){
                if(gap==0) dp[si][ei] = 1;
                else if(str.charAt(si)==str.charAt(ei)) dp[si][ei] = dp[si+1][ei]+dp[si][ei-1]+1;
                else dp[si][ei] = dp[si+1][ei]+dp[si][ei-1]-dp[si+1][ei-1];
            }
        }
        // display_2D(dp);
        return dp[0][str.length()-1];
    }

}