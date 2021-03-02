import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int REPETITIONS = 50;

    private CircularList circularList;
    private SelectFactory selectFactory;
    private SelectStrategy strategy;

    private void initList(){
        for(int i = 0; i < REPETITIONS; i++){
            this.circularList.add(i);
        }
    }

    private void initOddList(){
        for(int i = 1; i < REPETITIONS; i += 2){
            this.circularList.add(i);
        }
    }

    private void checkIfCorrectElement(final int expectedElement, final Optional<Integer> actualElement){
        assertTrue(actualElement.isPresent());
        assertEquals(expectedElement, actualElement.get());
    }

    private void checkIfEmpty(Optional<Integer> actualElement){
        assertFalse(actualElement.isPresent());
    }

    @BeforeEach
    void beforeEach(){
        this.circularList = new CircularListImpl();
        this.selectFactory = new SelectFactoryImpl();
    }

    @Test
    void testInitialSize(){
        assertEquals(0, this.circularList.size());
    }

    @Test
    void testInitialEmpty(){
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void testInitialNext(){
        checkIfEmpty(this.circularList.next());
    }

    @Test
    void testInitialPrevious(){
        checkIfEmpty(this.circularList.previous());
    }

    @Test
    void testInitialNextEvenStrategy(){
        this.strategy = selectFactory.createEvenStrategy();
        checkIfEmpty(this.circularList.next(strategy));
    }

    @Test
    void testInitialNextMultipleOfStrategy(){
        this.strategy = selectFactory.createMultipleOfStrategy(3);
        checkIfEmpty(this.circularList.next(strategy));
    }

    @Test
    void testInitialNextEqualStrategy(){
        this.strategy = selectFactory.createEqualsStrategy(1);
        checkIfEmpty(this.circularList.next(strategy));
    }

    @Test
    void testSize(){
        initList();
        assertEquals(50, this.circularList.size());
    }

    @Test
    void testWrongSize(){
        initList();
        assertNotEquals(10, this.circularList.size());
    }

    @Test
    void testFirstElementNext(){
        initList();
        checkIfCorrectElement(0, this.circularList.next());
    }

    @Test
    void testSecondElementNext(){
        initList();
        this.circularList.next();
        checkIfCorrectElement(1, this.circularList.next());
    }

    @Test
    void testLastElementNext(){
        initList();
        for(int i = 0; i < REPETITIONS; i++){
            this.circularList.next();
        }
        checkIfCorrectElement(0, this.circularList.next());
    }

    @Test
    void testFirstElementPrevious(){
        initList();
        checkIfCorrectElement(49, this.circularList.previous());
    }

    @Test
    void testSecondElementPrevious(){
        initList();
        this.circularList.next();
        checkIfCorrectElement(0, this.circularList.previous());
    }

    @Test
    void testReset(){
        initList();

        for(int i = 0; i < REPETITIONS - 10; i++){
            Optional<Integer> nextValue = this.circularList.next();
            assertTrue(nextValue.isPresent());
            assertEquals(i, nextValue.get());
        }

        this.circularList.reset();
        checkIfCorrectElement(0, this.circularList.next());
    }

    @Test
    void testFirstElementNextEvenStrategy(){
        initList();
        this.strategy = selectFactory.createEvenStrategy();
        checkIfCorrectElement(0, this.circularList.next(strategy));
    }

    @Test
    void testSecondElementNextEvenStrategy(){
        initList();
        this.strategy = selectFactory.createEvenStrategy();
        this.circularList.next();

        checkIfCorrectElement(2, this.circularList.next(strategy));
    }

    @Test
    void testBeforeCurrentElementNextEvenStrategy(){
        this.circularList.add(2);
        initOddList();

        this.strategy = selectFactory.createEvenStrategy();
        this.circularList.next();

        checkIfCorrectElement(2, this.circularList.next(strategy));
    }

    @Test
    void testNextAfterNextEvenStrategy(){
        testSecondElementNextEvenStrategy();
        checkIfCorrectElement(3, this.circularList.next());
    }

    @Test
    void testNotFoundNextEvenStrategy(){
        initOddList();
        this.strategy = selectFactory.createEvenStrategy();
        checkIfEmpty(this.circularList.next(strategy));
    }

    @Test
    void testElementNextMultipleOfStrategy(){
        initOddList();
        this.strategy = selectFactory.createMultipleOfStrategy(3);
        checkIfCorrectElement(3, this.circularList.next(strategy));
    }

    @Test
    void testBeforeCurrentElementNextMultipleOfStrategy(){
        this.circularList.add(4);
        this.circularList.add(3);
        this.circularList.next();

        this.strategy = selectFactory.createMultipleOfStrategy(2);
        checkIfCorrectElement(4, this.circularList.next(strategy));
    }

    @Test
    void testNotFoundNextMultipleOfStrategy(){
        initOddList();
        this.strategy = selectFactory.createMultipleOfStrategy(2);
        checkIfEmpty(this.circularList.next(strategy));
    }

    @Test
    void testNextAfterNextMultipleOfStrategy(){
        testElementNextMultipleOfStrategy();
        checkIfCorrectElement(5, this.circularList.next());
    }

    @Test
    void testNextEqualStrategy(){
        initList();
        this.strategy = selectFactory.createEqualsStrategy(15);
        checkIfCorrectElement(15, this.circularList.next(strategy));
    }

    @Test
    void testBeforeCurrentElementNextEqualStrategy(){
        initList();
        this.circularList.next();
        this.strategy = selectFactory.createEqualsStrategy(0);
        checkIfCorrectElement(0, this.circularList.next(strategy));
    }

    @Test
    void testNotFoundNextEqualStrategy(){
        initOddList();
        this.strategy = selectFactory.createEqualsStrategy(2);
        checkIfEmpty(this.circularList.next(strategy));
    }

}
