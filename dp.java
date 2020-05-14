public class dp{
    public static void main(String[] args){
        solve();
    }
    public static void solve(){
        basic();
    }
    public static void basic(){

        int n = 5;
        int[] dp = new int[n+1];
        int ans = 0;

        // ans = fib_memo(n,dp);
        // ans = fib_DP(n, dp);
        // ans = fact_memo(n, dp);
        // ans = fact_DP(n, dp);

        display(dp);
        System.out.print(ans);
    }
    public static void display(int[] arr){
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        System.out.println();
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

}