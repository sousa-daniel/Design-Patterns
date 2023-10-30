package Composite;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CompositeBox implements Box{

    private List<Box> children = new ArrayList<Box>();
    
    public CompositeBox(Box... boxes) {
        children.addAll(Arrays.asList(boxes));
    }

    @Override
    public double calculatePrice() {
        return children.stream()
                    .mapToDouble(Box::calculatePrice)
                    .sum();
    }
}
