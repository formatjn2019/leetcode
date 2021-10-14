package leetcode._126_单词接龙II;

import java.util.*;
import java.util.stream.Collectors;

public class FindLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //单词转子串
        Map<String, List<String>> wordToSubDic = new HashMap<>();
        wordList.stream()
                .map(this::createWordToSubDic)
                .forEach(wordToSubDic::putAll);
//        wordToSubDic.entrySet().stream()
//                .forEach(System.out::println);
        //子串转单词
        Map<String, List<String>> subToWordDic = new HashMap<>();
        wordToSubDic.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(value -> List.of(entry.getKey(), value)))
                .forEach(item -> subToWordDic.computeIfAbsent(item.get(1), i -> new ArrayList<>()).add(item.get(0)));
        Map<String, Set<String>> translateMap = new HashMap<>();
        //添加其余单词
        wordToSubDic.putAll(this.createWordToSubDic(beginWord));
        //单词转单词
        for (String word : wordToSubDic.keySet()) {
            for (String sub : wordToSubDic.get(word)) {
                for (String newWord : subToWordDic.getOrDefault(sub, List.of())) {
                    if (!newWord.equals(word)) {
                        translateMap.computeIfAbsent(word, wd_ -> new HashSet<>()).add(newWord);
                    }
                }
            }
        }
        translateMap.entrySet().forEach(System.out::println);


//        System.out.println(subToWordDic);
        LinkedHashSet<String> passed = new LinkedHashSet<>();
        passed.add(beginWord);

        return searchResult(endWord, translateMap, Map.of(beginWord, List.of(passed)));
    }

    public List<List<String>> searchResult(String target, Map<String, Set<String>> translateMap, Map<String, List<LinkedHashSet<String>>> nextFloor) {
        if (nextFloor.keySet().size() == 0) {
            return List.of();
        } else if (nextFloor.containsKey(target)) {
            return nextFloor.get(target)
                    .stream()
                    .map(ArrayList::new)
                    .distinct()
                    .collect(Collectors.toList());
        } else {
            Map<String, List<LinkedHashSet<String>>> newNextFloor = new HashMap<>();
            //下一层
            for (String pre : nextFloor.keySet()) {
                //下一个单词
                for (String word : translateMap.getOrDefault(pre,Set.of())) {
                    //是否增加进下一层
                    for (LinkedHashSet<String> passed : nextFloor.get(pre)) {
                        if (!passed.contains(word)) {
                            LinkedHashSet<String> newPassed = new LinkedHashSet<>(passed);
                            newPassed.add(word);
                            newNextFloor.computeIfAbsent(word, _w -> new ArrayList<>()).add(newPassed);
                        }
                    }
                }
            }
            return searchResult(target, translateMap, newNextFloor);
        }
    }

    public Map<String, List<String>> createWordToSubDic(String s) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(0, i) + " " + s.substring(i + 1));
        }
        return Map.of(s, result);
    }

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
//        System.out.println(findLadders.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
//        System.out.println(findLadders.findLadders("talk", "tail", List.of("talk", "tons", "fall", "tail", "gale", "hall", "negs")));
        System.out.println(findLadders.findLadders("cet", "ism", List.of("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob")));



    }
}
