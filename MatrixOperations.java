import java.util.Arrays;

public class Matrix {

    //matrix multiplication
    public static double[][] multiply(double[][] M, double[][] N) {
        double [][] result = new double[M.length][N[0].length];
        if (M[0].length == N.length){
            for(int i=0;i<M.length;i++){
                for(int j=0;j<N[0].length;j++){
                    for(int k=0;k<M[0].length;k++){
                        result[i][j]+=M[i][k]*N[k][j];
                    }
                }
            }
        }
        else{
            System.out.println("Matrisler çarpılamaz.");
        }
        return result;
    }

    //returns a new matrix that is the transpose of the matrix M
    public static double[][] transpose(double[][] M){
        double[][] tranposeMatrix = new double[M[0].length][M.length];
        for(int i =0; i<M[0].length;i++){
            for(int j=0;j<M.length;j++){
                tranposeMatrix[i][j] = M[j][i];
            }
        }
        return tranposeMatrix;
    }

    //returns true if the matrix M is symmetric
    public static boolean isSymmetric(double[][] M){

        double[][] copiedMatrix = M;
        int flag =0;
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(i==j){
                    break;
                }
                else{
                    if(copiedMatrix[i][j]==M[j][i]){
                        flag ++;//kaç tane hanenin birbirine eşit olduğunun sayısı
                    }
                    else{
                        break;
                    }
                }
            }
        }
        int indexCount =((M.length*M[0].length)-M.length)/2;
        /*Eğer köşegen indekslerde bulunan eleman sayısını çıkartırsak geriye karşılaştırmamız gerekenler elemanların sayısı kalır.
        Elimizde kalan sayının yarısı (iki haneyi karşılaştırdığımız için) bizim flag sayımıza eşit ise simetrik matristir.*/
        if(flag==indexCount){
            return true;
        }
        else{
            return false;
        }

    }

    // returns string representation of the matrix M
    public static String toString(double[][] M){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M.length;i++){
            sb.append(Arrays.toString(M[i]));
            sb.append("\n");
        }
        String str = sb.toString();
        return str;
    }

    public static void main(String[] args) {    //to test Matrix class
        double[][] A = { { 4.0, 3.0 }, { 2.0, 1.0 } };
        double[][] B = { { -0.5, 1.5 }, { 1.0, -2.0 } };
        double[][] result;

        try{
            result = Matrix.multiply(A, B);
            System.out.println(Matrix.toString(result));
        }catch (Exception e){
            System.out.println("Try again");
        }

        double[][] C = { { 2.0, -1.0, 3.0}, {-1.0, 0.0, 5.0}, { 3.0, 5.0, 6.0}};
        boolean sym = Matrix.isSymmetric(C);
        System.out.println(sym);

        double[][] D = { { 4.0, 3.0, 2.0 }, { 2.0, 1.0, -2.0 } };
        double[][] DT = Matrix.transpose(D);
        System.out.println(Matrix.toString(DT));
    }
}
