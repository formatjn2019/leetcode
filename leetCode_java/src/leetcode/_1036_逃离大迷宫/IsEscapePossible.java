package leetcode._1036_逃离大迷宫;

import leetcode.Tools;

import java.util.*;


public class IsEscapePossible {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockSet = new HashSet<>();
        for (int[] ints : blocked) {
            long l = ints[0];
            l = (l << 20) + ints[1];
            blockSet.add(l);
        }
        int ste = bfsSearch(source, target, blockSet);
        if (ste == 1) {
            return true;
        } else if (ste == 0) {
            return bfsSearch(target, source, blockSet) >= 0;
        }
        return false;
    }

    // -1 拓展失败 0 拓展成功，但未和目标进行连接 1 和目标进行连接成功
    public int bfsSearch(int[] start, int[] end, Set<Long> blocket) {
        //面积再加上额外的斜边的长度
        int endSize = blocket.size() * (blocket.size()-1) / 2 +blocket.size();
        Set<Long> extended = new HashSet<>();
        int[][] extendDir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> newNode = new ArrayList<>();
        newNode.add(start);
        while (newNode.size() > 0) {
            List<int[]> nextLevel = new ArrayList<>();
            for (int[] nn : newNode) {
//                System.out.println("nn"+Arrays.toString(nn));
                for (int[] nd : extendDir) {
                    int lineIndex = nn[0] + nd[0], rowIndex = nn[1] + nd[1];
//                    System.out.println(lineIndex+"\t"+rowIndex);
                    //在边界以内
                    if (lineIndex >= 0 && lineIndex < 1000000 && rowIndex >= 0 && rowIndex < 1000000) {
                        //已经碰到了目标，不需要再找了
                        if (lineIndex == end[0] && rowIndex == end[1]) {
                            return 1;
                        }
                        // 2**20=1048576
                        long eigenvalues = lineIndex;
                        eigenvalues = (eigenvalues << 20) + rowIndex;
                        //是新节点且不被阻隔
                        if (extended.add(eigenvalues) && !blocket.contains(eigenvalues)) {
                            nextLevel.add(new int[]{lineIndex, rowIndex});
                        }
                        if (extended.size() > endSize) {
                            return 0;
                        }
                    }
                }
            }
            newNode = nextLevel;
        }
        return -1;
    }

    public static void main(String[] args) {
        IsEscapePossible isEscapePossible = new IsEscapePossible();
        System.out.println(isEscapePossible.isEscapePossible(Tools.parseArray("[[0,1],[1,0]]"), new int[]{0, 0}, new int[]{0, 2}));
        System.out.println(isEscapePossible.isEscapePossible(Tools.parseArray("[[0,1],[2,0]]"), new int[]{0, 0}, new int[]{0, 2}));
        System.out.println(isEscapePossible.isEscapePossible(Tools.parseArray("[[0,199],[1,198],[2,197],[3,196],[4,195],[5,194],[6,193],[7,192],[8,191],[9,190],[10,189],[11,188],[12,187],[13,186],[14,185],[15,184],[16,183],[17,182],[18,181],[19,180],[20,179],[21,178],[22,177],[23,176],[24,175],[25,174],[26,173],[27,172],[28,171],[29,170],[30,169],[31,168],[32,167],[33,166],[34,165],[35,164],[36,163],[37,162],[38,161],[39,160],[40,159],[41,158],[42,157],[43,156],[44,155],[45,154],[46,153],[47,152],[48,151],[49,150],[50,149],[51,148],[52,147],[53,146],[54,145],[55,144],[56,143],[57,142],[58,141],[59,140],[60,139],[61,138],[62,137],[63,136],[64,135],[65,134],[66,133],[67,132],[68,131],[69,130],[70,129],[71,128],[72,127],[73,126],[74,125],[75,124],[76,123],[77,122],[78,121],[79,120],[80,119],[81,118],[82,117],[83,116],[84,115],[85,114],[86,113],[87,112],[88,111],[89,110],[90,109],[91,108],[92,107],[93,106],[94,105],[95,104],[96,103],[97,102],[98,101],[99,100],[100,99],[101,98],[102,97],[103,96],[104,95],[105,94],[106,93],[107,92],[108,91],[109,90],[110,89],[111,88],[112,87],[113,86],[114,85],[115,84],[116,83],[117,82],[118,81],[119,80],[120,79],[121,78],[122,77],[123,76],[124,75],[125,74],[126,73],[127,72],[128,71],[129,70],[130,69],[131,68],[132,67],[133,66],[134,65],[135,64],[136,63],[137,62],[138,61],[139,60],[140,59],[141,58],[142,57],[143,56],[144,55],[145,54],[146,53],[147,52],[148,51],[149,50],[150,49],[151,48],[152,47],[153,46],[154,45],[155,44],[156,43],[157,42],[158,41],[159,40],[160,39],[161,38],[162,37],[163,36],[164,35],[165,34],[166,33],[167,32],[168,31],[169,30],[170,29],[171,28],[172,27],[173,26],[174,25],[175,24],[176,23],[177,22],[178,21],[179,20],[180,19],[181,18],[182,17],[183,16],[184,15],[185,14],[186,13],[187,12],[188,11],[189,10],[190,9],[191,8],[192,7],[193,6],[194,5],[195,4],[196,3],[197,2],[198,1],[199,0]]"), new int[]{0, 0}, new int[]{200, 200}));
    }

}
