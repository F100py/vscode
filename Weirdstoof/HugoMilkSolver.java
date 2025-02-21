package Weirdstoof;

public class HugoMilkSolver{
    public static void main(String[] args){
         int capacity = HOMOSEXUALITYWAY(17, 25, 77);
         int acccapacity = dpway(17, 25, 77);
         System.out.println(capacity+", dp: " + acccapacity);
    }
    public static int HOMOSEXUALITYWAY(int x, int y, int m){
         if (m%y%x==0)
             return m;
         int ans = 0;
         for (int i = 0; i<m/y; i++){
             if(((m-y*i)%x==0))
                 return m;
             else
                 ans = Math.max(m-((m-y*i)%x), ans);
         }
         return ans;
         
    }
     public static int dpway(int x, int y, int m){
         if (m%y%x==0)
             return m;
         return 69;
         
    }
}