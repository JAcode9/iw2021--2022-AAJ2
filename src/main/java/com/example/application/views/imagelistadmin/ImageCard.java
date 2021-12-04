package com.example.application.views.imagelistadmin;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;

@JsModule("./views/imagelist/image-card.ts")
@Tag("image-card")
public class ImageCard extends LitTemplate {

    @Id
    private Image image;

    @Id
    private Span header;

    @Id
    private Paragraph text;


    public ImageCard(String title, String text, String url, String sinopisis) {
        this.image.setSrc(url);
        this.image.setAlt(text);
        this.header.setText(title);
        this.text.setText(
                sinopisis);
    }
}