class Solution {

    public int xor(int n){
        int x = n%4;
        if(x == 0){
            return n;
        }
        else if(x == 1){
            return 1;
        }
        else if(x == 2){
            return n+1;
        }
        else{
            return 0;
        }
    }
    public int[] decode(int[] encoded) {
        int perm[] = new int[encoded.length+1];

        int encodedXor = encoded[0];
        for(int i=2;i<encoded.length;i=i+2){
            encodedXor^=encoded[i];
        }

        int x = encodedXor^xor(perm.length);

        perm[perm.length-1]=x;
        for(int i=perm.length-2;i>=0;i--){
            perm[i]=perm[i+1]^encoded[i];
        }

        return perm;
    }
}