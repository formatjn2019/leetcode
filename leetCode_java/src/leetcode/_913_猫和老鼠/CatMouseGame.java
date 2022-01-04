package leetcode._913_猫和老鼠;

import leetcode.Tools;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class CatMouseGame {
    private static int MOUSE_WIN=1;
    private static int DRAW=2;
    private static int CAT_WIN=3;

    public int catMouseGame(int[][] graph) {
        int n=graph.length;
        int []translate=new int[]{0,1,0,2};
        int [][][] memMat=new int[2*n][n][n];
        //省去矩阵置-1步骤，采取整体结果加一代替，对返回结果进行修正
        return translate[dfs(memMat,graph,0,1,2)];
    }
    private int dfs(int [][][]memMat,int [][]graph,int depth,int mouse,int cat){
        if (depth==memMat.length){
            return DRAW;
        }else if (mouse==cat){
            return CAT_WIN;
        }else if (mouse == 0){
            return MOUSE_WIN;
        }
        //未计算则开始计算
        if (memMat[depth][mouse][cat]==0){

            //老鼠走
            if (depth%2==0){
                //老鼠倾向于更小的结果
                int result=CAT_WIN;
                for (int next : graph[mouse]) {
                    result=Math.min(result,dfs(memMat,graph,depth+1,next,cat));
                    if (result==MOUSE_WIN){
                        break;
                    }
                }
                memMat[depth][mouse][cat]=result;
            }
            //猫走
            else {
                //猫倾向于更大的结果
                int result=MOUSE_WIN;
                for (int next : graph[cat]) {
                    if (next!=0){
                        result=Math.max(result,dfs(memMat,graph,depth+1,mouse,next));
                    }
                    if (result==CAT_WIN){
                        break;
                    }
                }
                memMat[depth][mouse][cat]=result;
            }

        }

        return  memMat[depth][mouse][cat];
    }
    public static void main(String[] args) {
        CatMouseGame catMouseGame = new CatMouseGame();
        int[][] grap = Tools.parseArray("[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]");
        System.out.println(catMouseGame.catMouseGame(grap));


        grap=Tools.parseArray("[[1,3],[0],[3],[0,2]]");
        System.out.println(catMouseGame.catMouseGame(grap));
        grap=Tools.parseArray("[[2,3],[3,4],[0,4],[0,1],[1,2]]");
        System.out.println(catMouseGame.catMouseGame(grap));
        grap = Tools.parseArray("[[3,4],[3,5],[3,6],[0,1,2],[0,5,6],[1,4],[2,4]]");
        System.out.println(catMouseGame.catMouseGame(grap));
    }
}
