class Solution {
    public int trap(int[] height) {
        
    //    //water[i]=Math.min(leftMax[i],rightMax[i])-height[i];
    //    if (height == null){
    //         return 0;
    //    }
    //    int n = height.length;
    //    int[] leftMax = new int [n];
    //    int[] rightMax = new int [n];
    //    int totalWater = 0;
    //    leftMax[0] = height[0];
    //    rightMax[n-1] = height[n-1];

    //    //Precompute boundaries 
    //    for (int i=1; i<n; i++){
    //     leftMax[i]=Math.max(leftMax[i-1],height[i]);
    //    }

    //    for (int i=n-2; i>=0; i--){
    //     rightMax[i]=Math.max(rightMax[i+1],height[i]);
    //    }

    //    for (int i=0; i<n; i++){
    //     totalWater = totalWater + (Math.min(leftMax[i],rightMax[i])-height[i]);
    //    }

    //    return totalWater;

    // w[i] = min(leftMax,rightMax)-height[i]
    //if leftMax < rightmAx
    // w[i]=leftMAx-height[i]
    if (height == null){
        return 0;
    }
    int left=0;
    int right=height.length-1;
    int leftMax=0;
    int rightMax=0;

    int tWater = 0;

    while (left<right){
        if(height[left]<height[right]){
            leftMax = Math.max(leftMax,height[left]);
            tWater = tWater + (leftMax - height[left]);
            left++;
        }
        else{
            rightMax = Math.max(rightMax,height[right]);
            tWater = tWater + (rightMax - height[right]);
            right--;
        }
    }
    return tWater;

    }
}
