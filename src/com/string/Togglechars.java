package com.string;

public class Togglechars {
    public static void main(String[] args){
        String str = "pAtHaN";    // chars from a to z and A to Z only
        StringBuilder sb = new StringBuilder();
   //     char[] ch = str.toCharArray();

        for (char ch: str.toCharArray()) {
             if (ch >= 'A' && ch <= 'Z'){
           //      sb.append( (char) ('a'+ ch - 'A') );   }
             sb.append( (char) (ch+32) );   }
             else {
       //          sb.append( (char) ('A'+ ch - 'a') );
                  sb.append( (char) (ch-32) );   }
             }
        

//        for (int i =0; i< str.length(); i++){
//            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
//                char ch = (char) ('a'+ str.charAt(i) - 'A');
//                sb.append(ch);
//
//            } else {
//                char ch = (char) (str.charAt(i) - 32);
//                sb.append(ch);
//            }
//        }

        System.out.println(sb.toString());
    }
}
