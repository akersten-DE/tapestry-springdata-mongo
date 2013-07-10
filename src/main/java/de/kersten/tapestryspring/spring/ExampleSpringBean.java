package de.kersten.tapestryspring.spring;

public class ExampleSpringBean {

    private String productionMode;

    /**
     * @return the productionMode
     */
    public String getProductionMode() {
        return productionMode;
    }

    /**
     * @param productionMode
     *            the productionMode to set
     */
    public void setProductionMode(final String productionMode) {
        this.productionMode = productionMode;
    }
}
