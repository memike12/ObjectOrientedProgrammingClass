public class Lab6 {
    public static void main(String[] args) {
        // Test 0 - ICString
        ICString i = new ICString("test");
        System.out.println(i);
        System.out.println(i.length());
        System.out.println();

        // Test 1 - MString
        MString m = new MString("Mutable String");
        System.out.println(m);
        boolean b;
        b = m.setCharAt(0, 'X');
        System.out.println(m + "   " + b);
        b = m.setCharAt(-1, 'z');
        System.out.println(m + "   " + b);
        b = m.setCharAt(13, 'Y');
        System.out.println(m + "   " + b);
        b = m.setCharAt(14, 'z');
        System.out.println(m + "   " + b);
        m.reverse();
        System.out.println(m);
        System.out.println();

        // Test 2 - UString
        UString u = new UString("Upper-Case String");
        System.out.println(u);
        b = u.setCharAt(1, 'x');
        System.out.println(u + "   " + b);
        b = u.setCharAt(-1, 'A');
        System.out.println(u + "   " + b);
        u.reverse();
        System.out.println(u);
        System.out.println();

        // Test 3 - LString
        LString l = new LString("Lower-Case String");
        System.out.println(l);
        b = l.setCharAt(1, 'X');
        System.out.println(l + "   " + b);
        b = l.setCharAt(-1, 'A');
        System.out.println(l + "   " + b);
        l.reverse();
        System.out.println(l);
        System.out.println();
    }
}