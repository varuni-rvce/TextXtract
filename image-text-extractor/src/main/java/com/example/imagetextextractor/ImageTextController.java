package com.example.imagetextextractor;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.*;

import java.io.File;

import java.io.IOException;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

@RestController

@RequestMapping("/api")

public class ImageTextController {

@PostMapping("/extract-text")

public String extractTextFromImage(@RequestParam("file") MultipartFile file) {

try {

File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());

file.transferTo(convFile);

BufferedImage image = ImageIO.read(convFile);

BufferedImage processedImage = preprocessImage(image);

File processedFile = new File(System.getProperty("java.io.tmpdir") + "/processed_" + file.getOriginalFilename());

ImageIO.write(processedImage, "jpeg", processedFile);

Tesseract tesseract = new Tesseract();

tesseract.setDatapath("C://Program Files//Tesseract-OCR//tessdata");

tesseract.setLanguage("kan+san+eng");

String text = tesseract.doOCR(processedFile);

return text;

} catch (TesseractException | IOException e) {

e.printStackTrace();

return "Error occurred while extracting text from image.";

}

}

private BufferedImage preprocessImage(BufferedImage image) {

return image;

}

}

