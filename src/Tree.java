import java.util.List;
 class Tree implements Components {
    private final List<Components> componentsList;

    public Tree(List<Components> componentsList) {
        this.componentsList = componentsList;
    }

    public void add(Components components) {
        componentsList.add(components);
    }

    public void remove(Components components) {
        componentsList.remove(components);
    }

    public List<Components> getComponentsList() {
        return componentsList;
    }

    @Override
    public double countPrice() {
        return componentsList.stream()
                .map(Components::countPrice)
                .mapToDouble(Double::doubleValue).sum();
    }

    public double countPriceBlock() {

        return countPrice()+((countPrice()*15)/100);

    }

    public double countPriceComputer() {
        return countPrice()+((countPrice()*5)/100);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "componentsList=" + componentsList +
                '}';
    }
}
