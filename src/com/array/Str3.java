/*
Mr. Jim likes playing with strings a lot, so Mrs. Pam gifted him a string A which has some very unique magical powers. The string consists of lowercase latin letters 'p','a' and 'm' only.

In one wish, Mr Jim can perform one of the following operations:

    Remove exactly one occurrence of 'p' and exactly one occurrence of 'm', from anywhere inside string A.
    Remove exactly one occurrence of 'a' and exactly one occurrence of 'm', from anywhere inside string A.

Now Mr. Jim wants to know if after some number of wishes is it possible to make string A empty.

Return 1 if it is possible to make string A empty after some number of operations otherwise Return 0
 */
/*
package com.oracle;

public class Str3 {
    public static void main(String[] args){
        String A = "mpampamm";
        String c1 = "a";
        String c2 = "n";
        String c3 = "m";

        StringBuilder sb = new StringBuilder(A);
        while (true){
     //       boolean b = (sb.toString().contains("n")) || (sb.toString().contains("m"));
            if (sb.toString().contains(c1)) {
               int in1 = A.indexOf(c1);
               sb.delete(in1, in1+1);
            } else if (sb.toString().contains(c2)) {
                int in1 = A.indexOf(c2);
                sb.delete(in1, in1+1);
            }else if (sb.toString().contains(c3)) {
                int in1 = A.indexOf(c3);
                sb.delete(in1, in1+1);
            }
            else
        }

    }
}
*/