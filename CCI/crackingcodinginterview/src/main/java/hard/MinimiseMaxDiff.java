package hard;
/*
You are given N cubes of wood arranged in increasing order.
The length of side of ith cube is arr[i] and side lengths are distinct.
The first and last cubes cannot be moved.

We have to minimize the maximum diff of cubes arrangement by removing exactly K cubes.

diff=max(arr[i+1]-arr[i]) for 1<i<-N-1

Input:
firs line single Integer N
second line N separated integer arr[i]
third line single Integer K

Example
5
1 2 3 7 8
2

output:
5

by taking ={ 1 3 8 }

 */
public class MinimiseMaxDiff {
/*
class Solution{

public:

    bool solvable(vector<int>& v,int diff,int K){

        int n=v.size();
        int prev=0;
        int removed=0;
        for(int i=1;i<n&&removed<K;i++){
            if(i==n-1 || v[i+1]-v[prev]>diff){
                if(v[i]-v[prev]>diff)return false;
                prev=i;
            }
            else removed++;
        }
        return (removed==K);
    }

    int minDiff(vector<int> v,int K){

        int hi=v.back()-v[0];
        int lo=0;

        for(int i=0;i+1<v.size();i++)lo=max(lo,v[i+1]-v[i]);

        while(lo<hi){
            int mid=(lo+hi)/2;
            if(solvable(v,mid,K))hi=mid;
            else lo=mid+1;
        }
        return lo;
    }
};
int main(void){

    Solution *s =new Solution();
    cout<<s->minDiff({1,2,3,7,8},2)<<endl;

    return 0;
}
// output: 5
    * */

}
