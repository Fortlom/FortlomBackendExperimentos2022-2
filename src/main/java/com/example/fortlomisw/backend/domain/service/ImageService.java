package com.example.fortlomisw.backend.domain.service;

public interface ImageService {

     byte[] compressBytes(byte[] data);
    byte[] decompressBytes(byte[] data);
}
