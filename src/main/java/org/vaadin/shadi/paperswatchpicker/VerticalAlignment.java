package org.vaadin.shadi.paperswatchpicker;

public enum VerticalAlignment {

    Bottom("bottom"), TOP("top");

    private String value;

    VerticalAlignment(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
