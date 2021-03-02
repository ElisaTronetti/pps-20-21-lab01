package lab01.tdd;

public class MultipleOfStrategy implements SelectStrategy{
    private final int currentElement;

    public MultipleOfStrategy(final int currentElement){
        this.currentElement = currentElement;
    }

    @Override
    public boolean apply(int element) {
        return (element % currentElement) == 0;
    }
}
