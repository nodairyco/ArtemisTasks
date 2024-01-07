public class Main {
    public static void main(String[] arr) {

        IndexedTree<String> t = new IndexedTree<String>();
        for (String s: arr)
            t.insert (0,s);

        var n = t.size();

        System.out.println(n);

        for(String s: t) System.out.println(s);
        for(int i= n-1;i >= 0; i--) {

            System.out.println (t.get(i));
            t.remove(1);

        }

        System.out.println(t.size());

    }
}
