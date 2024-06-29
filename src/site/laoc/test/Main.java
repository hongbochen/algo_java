package site.laoc.test;

import site.laoc.datastruct.Test1;
import site.laoc.datastruct.Test2;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class Main {
    public static void main(String args[]) throws UnsupportedEncodingException {
        String  str = "nofbwrxVImmKbf42ivxCMk20wZYz37OmRZIGNM/ktNw=";

        System.out.println(java.net.URLEncoder.encode(str, "utf-8"));
    }


}
