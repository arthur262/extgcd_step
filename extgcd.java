import java.util.ArrayList;

public class extgcd {
    public static int counts=0;
    public static int div(int x,int y){
        int left=0;
        int right=0;
        if (x>y){
            left=x;
            right=y;
        }
        else {
            left=y;
            right=x;
        }
        int count=0;
        while (left>=right){
            left=miunes(left,right);
            count++;
        }
        return count;
    }
    public static int mod(int x,int y) {
    return x%y;
    }
    public static int[] extgcd(int p, int q){
        if (q==0){
            return new int[] { p, 1, 0 };
        }
        System.out.println("ExtGcd("+p+","+q+")=(g"+counts+",t"+counts+",s"+counts+"-q"+counts+"t"+counts+")");
        System.out.println("q"+counts+",r"+counts+" =divmod("+p+","+q+")=("+div(p,q)+","+mod(p,q)+")");
        System.out.println("g"+counts+",s"+counts+",t"+counts+"=(ExtGcd "+q+","+mod(p,q)+")");
        System.out.println();
        counts++;
        int[] vals = extgcd(q, p % q);
        int d = vals[0];
        int a = vals[2];
        int b = vals[1] - (p / q) * vals[2];
        System.out.println("g"+counts+",s"+counts+",t"+counts+"=(ExtGcd "+q+","+mod(p,q)+")="+d+","+a+","+vals[1]+"-"+(p / q)+"*"+vals[2]+"=("+d+","+a+","+b+")");
        counts--;

        return new int[] { d, a, b };


    }

    public static void main(String[] args) {
        int p=232;
        int q=89;
        int[] vals=extgcd(p,q);
        System.out.println("\ngcd(" + p + ", " + q + ") = " + vals[0]);
        System.out.println(vals[1] + "(" + p + ") + " + vals[2] + "(" + q + ") = " + vals[0]);
    }
    public static int miunes(int x,int y){
        return x-y;
    }
}
