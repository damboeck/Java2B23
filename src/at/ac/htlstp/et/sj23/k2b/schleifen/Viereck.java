package at.ac.htlstp.et.sj23.k2b.schleifen;

public class Viereck {

    public static void vLinie(int size,char rand, char innen) {
        System.out.print(rand);
        for (int i=0;i<size;i++)
            System.out.print(innen);
        System.out.println(rand);
    }

    public static void viereck(int size) {
        vLinie(size,'+','-');
        for (int i=0;i<size;i++)
            vLinie(size,'|',' ');
        vLinie(size,'+','-');
    }

    public static void main(String[] args) {
        int size = 7;
        viereck(size);
    }
}
