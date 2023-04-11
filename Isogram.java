public class Isogram {
    public static void main(String[] args) {
        System.out.println(isIsogram("Visual"));            //true
        System.out.println(isIsogram("Programming"));       //false
        System.out.println(isIsogram("JavA"));              //false
        System.out.println(isIsogram("uncopyrightable"));   //true
    }

    private static boolean isIsogram(String word){
        StringBuilder string = new StringBuilder(word);
        String word2 = word;
        int flag=0;
        for(int i=0,j=1;i<string.length(),j<string.length();i++,j++){
            if(word.charAt(i)==word2.charAt(j)){
                flag++
            }
        }
        if(flag>1){
            return false;
        }
        else{
            return true;
        }
    }
}
