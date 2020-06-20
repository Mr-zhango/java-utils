package cn.myfreecloud.javautils.regex;

public class RegexFilter {


    public static void main(String[] args) {
        String s = "1223\u000B\u000B\u000B\u000B\u000B   \u000B\u000B\u000B\u000B\u000B5125   你好+中国&*^5765";

        String s1 = filterSpecialCharOfXml(s);
        System.out.println(s1);
    }

    public static String filterSpecialCharOfXml(String txt){
        String res = "";
        for(int i = 0; i < txt.length(); ++i){
            char ch = txt.charAt(i);
            if(	Character.isDefined(ch) &&
                    ch!= '&' && ch != '<' && ch != '>' &&
                    !Character.isHighSurrogate(ch) &&
                    !Character.isISOControl(ch) &&
                    !Character.isLowSurrogate(ch)
            ){
                res = res + ch;
            }
        }
        return res;
    }


}
