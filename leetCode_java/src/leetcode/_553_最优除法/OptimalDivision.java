package leetcode._553_最优除法;

import java.util.List;
import java.util.Objects;

public class OptimalDivision {




    public String optimalDivision(int[] nums) {
        if (nums.length==1){
            return Integer.toString(nums[0]);
        }else if (nums.length==2){
            return String.format("%d/%d",nums[0],nums[1]);
        }else {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]);
            sb.append('/');
            sb.append('(');
            sb.append(nums[1]);
            for (int i=2;i<nums.length;i++){
                sb.append('/');
                sb.append(nums[i]);
            }
            sb.append('/');
            return sb.toString();
        }

    }


}
