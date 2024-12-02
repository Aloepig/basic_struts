package effective.part1.item02;

import java.util.EnumSet;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, ONION, PEPPER}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        Set<Topping> builderTopping = EnumSet.noneOf(Topping.class);

        public T addToppings(Topping topping) {
            builderTopping.add(topping);
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.builderTopping;
    }
}
