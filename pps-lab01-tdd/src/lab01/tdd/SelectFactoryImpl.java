package lab01.tdd;

public class SelectFactoryImpl implements SelectFactory{

    @Override
    public EqualsStrategy createEqualsStrategy(final int valueToCompare) {
        return new EqualsStrategy(valueToCompare);
    }

    @Override
    public EvenStrategy createEvenStrategy() {
        return new EvenStrategy();
    }

    @Override
    public MultipleOfStrategy createMultipleOfStrategy(final int valueToCompare) {
        return new MultipleOfStrategy(valueToCompare);
    }
}
