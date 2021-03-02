package lab01.tdd;

public class EvenStrategy implements SelectStrategy{
    private static final int EVEN_COMPARATOR = 2;

    public EvenStrategy(){}

    @Override
    public boolean apply(final int element) {
        return ((element % EVEN_COMPARATOR) == 0);
    }
}
