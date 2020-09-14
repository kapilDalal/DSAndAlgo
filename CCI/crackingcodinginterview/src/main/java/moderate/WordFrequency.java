package moderate;

public class WordFrequency {

    /*
    * There are two ways of doing this
    * first is map reduce
    * second is Trie(if preprocessing is allowed),
    * store everything beforehand in trie and call getFrequency for a word
    * */

    //second approach
    static class Trie{
        boolean eow;
        int freq;
        Trie[] children;
        public Trie(){
            this.freq = 0;
            this.eow = false;
            this.children = new Trie[26];
        }
    }
    Trie root = new Trie();

    public void store(String str){
        Trie temp = root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(temp.children[ch-'a']==null){
                temp.children[ch-'a'] = new Trie();
            }
            temp = temp.children[ch-'a'];
        }
        temp.eow = true;
        temp.freq += 1;
    }

    public int getFrequency(String str){
        Trie temp = root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(temp.children[ch-'a']==null){
                return 0;
            }
            temp = temp.children[ch-'a'];
        }
        return temp.eow?temp.freq:0;
    }

    public static void main(String[] args) {

        WordFrequency wf = new WordFrequency();
        wf.store("kapil");
        wf.store("dalal");
        wf.store("kapil");
        System.out.println(wf.getFrequency("kapil"));


    }







}
