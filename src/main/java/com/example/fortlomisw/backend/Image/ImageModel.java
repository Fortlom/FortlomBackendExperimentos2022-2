package com.example.fortlomisw.backend.Image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageModel {

    private Long id;


    private String type;



    private byte[] image;

    public ImageModel(Long id,String type, byte[] image) {
        this.id = id;
        this.type=type;
        this.image=image;
    }
}
