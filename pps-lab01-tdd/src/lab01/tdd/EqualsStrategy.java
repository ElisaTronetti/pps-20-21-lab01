package lab01.tdd;

public class EqualsStrategy implements SelectStrategy{
    private final int currentElement;

    public EqualsStrategy(final int currentElement){
        this.currentElement = currentElement;
    }

    @Override
    public boolean apply(int element) {
        return currentElement == element;
    }
}
