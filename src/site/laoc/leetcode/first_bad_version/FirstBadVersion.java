package site.laoc.leetcode.first_bad_version;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while(left < right){
            // 正常情况下，mid = (left + right) / 2;在这样有可能会造成溢出
            int mid = left + (right - left) / 2;

            if(isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    public static boolean isBadVersion(int num){
        if(num == 4 || num == 5){
            return true;
        }

        return false;
    }

    public static void main(String args[]){
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(5));
    }
}
