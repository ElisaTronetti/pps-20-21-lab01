package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements  CircularList{

    private final List<Integer> circularList;
    private int currentPositionInList;

    public CircularListImpl(){
        this.circularList = new ArrayList<>();
        this.currentPositionInList = 0;
    }

    @Override
    public void add(final int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> nextElement = Optional.empty();
        if(!isEmpty()){
            nextElement = Optional.of(this.circularList.get(this.currentPositionInList));
            if(checkIfLastElement()){
                restartInHead();
            } else {
                this.currentPositionInList++;
            }
        }

        return nextElement;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> previousElement = Optional.empty();
        if(!isEmpty()){
            if(checkIfFirstElement()){
                restartInTail();
            } else {
                this.currentPositionInList--;
            }
            previousElement = Optional.of(this.circularList.get(this.currentPositionInList));
        }
        return previousElement;
    }

    @Override
    public void reset() {
        restartInHead();
    }

    @Override
    public Optional<Integer> next(final SelectStrategy strategy) {
        Optional<Integer> nextElement;
        int saveHead = this.currentPositionInList;

        if(!this.circularList.isEmpty()){
            do{
                nextElement = next();
                if(nextElement.isPresent() && strategy.apply(nextElement.get())){
                    return nextElement;
                }
            } while (this.currentPositionInList != saveHead);
        }

        return Optional.empty();
    }

    private boolean checkIfLastElement(){
        return this.currentPositionInList >= (this.circularList.size() - 1);
    }

    private void restartInHead(){
        this.currentPositionInList = 0;
    }

    private boolean checkIfFirstElement(){
       return this.currentPositionInList == 0;
    }

    private void restartInTail(){
        this.currentPositionInList = this.circularList.size() - 1;
    }

}
