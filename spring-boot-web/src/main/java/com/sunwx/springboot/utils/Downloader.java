package com.sunwx.springboot.utils;

import java.io.OutputStream;

public interface Downloader {
    void download(OutputStream os);
}
