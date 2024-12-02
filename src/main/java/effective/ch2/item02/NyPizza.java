package effective.ch2.item02;

public class NyPizza extends Pizza {

    NyPizza(Builder builder) {
        super(builder);
    }

    public static class Builder extends Pizza.Builder<Builder> {

        @Override
        Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }
}