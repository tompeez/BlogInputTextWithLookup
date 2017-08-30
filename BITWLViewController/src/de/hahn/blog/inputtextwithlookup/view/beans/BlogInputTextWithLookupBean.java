package de.hahn.blog.inputtextwithlookup.view.beans;

import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;

public class BlogInputTextWithLookupBean {
    public BlogInputTextWithLookupBean() {
    }

    public void dialogListener(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().equals(DialogEvent.Outcome.ok)) {
            // GET A METHOD FROM PAGEDEF AND EXECUTE IT
            // get the binding container
            BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
            // get an ADF attributevalue from the ADF page definitions
            AttributeBinding attr = (AttributeBinding)bindings.getControlBinding("EmailPopup");
            // set the value into the other attribute
            Object inputValue = attr.getInputValue();
            attr = (AttributeBinding)bindings.getControlBinding("Email");
            attr.setInputValue(inputValue);
        }
    }
}
