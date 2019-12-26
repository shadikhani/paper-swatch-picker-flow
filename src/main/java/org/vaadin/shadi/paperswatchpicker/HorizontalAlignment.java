package org.vaadin.shadi.paperswatchpicker;

public enum HorizontalAlignment {

    LEFT("left"), RIGHT("right");

    private String value;

    HorizontalAlignment(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
