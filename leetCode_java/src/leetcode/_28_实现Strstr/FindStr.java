package leetcode._28_实现Strstr;


public class FindStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")){
            return 0;
        }
        char[] origin = haystack.toCharArray();
        char[] search = needle.toCharArray();
        int op=0,sp=0;
        for (;op<origin.length&&sp<search.length;op++){
            if (origin[op]==search[sp]){
                sp++;
            }else {
                op-=sp;
                sp=0;
            }
        }
        if (sp==search.length){
            return op-sp;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindStr().strStr("ppppppppppp", "ppppu"));
    }
}
