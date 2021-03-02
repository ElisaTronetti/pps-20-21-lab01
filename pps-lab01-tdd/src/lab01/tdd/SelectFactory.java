package lab01.tdd;

/**
 * Factory used to create different kind of strategy.
 */
public interface SelectFactory {

    /**
     * Create an EqualsStrategy instance,
     * used to find the next element in the list the is equal to the one specified.
     * @param valueToCompare the value that is used to compare with the current element in the list.
     * @return the actual EqualsStrategy instance.
     */
    EqualsStrategy createEqualsStrategy(final int valueToCompare);

    /**
     * Create an EvenStrategy instance, used to find the next element in the list that is even.
     * @return the actual EvenStrategy instance.
     */
    EvenStrategy createEvenStrategy();

    /**
     * Create a MultipleOfStrategy,
     * used to find the next element in the list that is multiple of the one specified.
     * @param valueToCompare the value that is used to compare with the current element in the list.
     * @return the actual MultipleOfStrategy.
     */
    MultipleOfStrategy createMultipleOfStrategy(final int valueToCompare);
}
