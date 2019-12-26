package org.vaadin.shadi.paperswatchpicker;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.TestBenchElement;

public class ViewIT extends AbstractViewTest {

    @Test
    public void componentWorks() {
        final TestBenchElement paperSwatchPicker = $("paper-swatch-picker").first();
        // Check that paper-swatch-picker contains at least one other element, which means that
        // is has been upgraded to a custom element and not just rendered as an empty
        // tag
        Assert.assertTrue(
                paperSwatchPicker.$(TestBenchElement.class).all().size() > 0);
    }
}
