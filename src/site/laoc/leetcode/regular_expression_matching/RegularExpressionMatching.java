package site.laoc.leetcode.regular_expression_matching;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if(p.isEmpty())
            return s.isEmpty();

        if(p.length() == 1)
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.charAt(1) != '*'){
            if(s.isEmpty()){
                return false;
            }

            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1),p.substring(1));
        }

        while(!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
            if(isMatch(s,p.substring(2))) return true;
            s = s.substring(1);
        }

        return isMatch(s,p.substring(2));
    }

    public static void main(String [] args){

        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();

        String s = "aaa";
        String p = "aaaa";

        boolean matching = regularExpressionMatching.isMatch(s,p);
        System.out.println(matching);
    }
}