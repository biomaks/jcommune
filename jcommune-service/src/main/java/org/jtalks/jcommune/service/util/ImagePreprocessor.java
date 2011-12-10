/**
 * Copyright (C) 2011  JTalks.org Team
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.jtalks.jcommune.service.util;

import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class for preparing image to save.
 *
 * @author Eugeny Batov
 * @author Alexandre Teterin
 */
@Component
public class ImagePreprocessor {

    public static final String HTML_SRC_TAG_PREFIX = "data:image/jpeg;base64,";
    public static final int AVATAR_MAX_HEIGHT = 100;
    public static final int AVATAR_MAX_WIDTH = 100;

    /**
     * Perform image resizing and processing
     *
     * @param image for processing
     * @return processed image bytes
     * @throws IOException image processing problem
     */
    public byte[] preprocessImage(Image image) throws IOException {
        byte[] result;
        Image outputImage = ImageUtil.resizeImage((BufferedImage) image, ImageUtil.IMAGE_JPEG, AVATAR_MAX_HEIGHT, AVATAR_MAX_WIDTH);
        result = ImageUtil.convertImageToByteArray(outputImage);
        return result;
    }

    /**
     * Perform base64 binary data to string conversion
     *
     * @param bytes for processing
     * @return converted binary data string
     */
    public String base64Coder(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }
         /**
     * Perform base64 string to binary data conversion
     *
     * @param encodedBytes string representation for processing
     * @return converted binary data
     */
    public byte[] decodeB64(String encodedBytes) {
        byte[] result = null;
        try {
            if (encodedBytes != null) {
                BASE64Decoder base64 = new BASE64Decoder();
                result = base64.decodeBuffer(encodedBytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * Perform preparing content for SRC attribute of the IMG HTML tag
     *
     * @param encodedImgBytes image payload
     * @return SRC attribute content
     */
    public String prepareHtmlImgSrc(String encodedImgBytes) {
        return HTML_SRC_TAG_PREFIX + encodedImgBytes;
    }


}