package lang;

import java.io.ObjectStreamField;

/**
 * @author luzc
 * @date 2020/8/31 14:28
 * @desc
 */
public final class StringCopy
        implements java.io.Serializable,Comparable<StringCopy>,CharSequence{

    private final char value[];

    private int hash;

    private static final long serialVersionUID = -6849794470754667710L;

    private static final ObjectStreamField[] serialPersistentFields =
            new ObjectStreamField[0];

    public StringCopy(char[] value) {
        this.value = value;
    }




    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public int compareTo(StringCopy o) {
        return 0;
    }
}
