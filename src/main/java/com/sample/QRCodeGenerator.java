package com.sample;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeGenerator {
	public final static String tmpFileName = "tmpQR";
	public final static int imageSize = 500;

	public static byte[] gerarComZXing(String texto, String formato){
		byte[] out = null;
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BufferedImage image = generateImage(texto, formato);
			ImageIO.write(image, formato, baos);
			baos.flush();
			out = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return out;
	}
	
	
	public static void gerarComZXing(String filePath, String texto, String formato){
        try {
            
            File myFile = new File(filePath);
            BufferedImage image = generateImage(texto, formato);
            ImageIO.write(image, formato, myFile);
            JOptionPane.showMessageDialog(null, "QRCode gerado em: "+myFile.getAbsolutePath());
        } catch (IOException e) {
        	e.printStackTrace();
        }
 
	}
	
	
	private static BufferedImage generateImage(String texto, String formato) {
		BufferedImage image = null;
		
		try{
			Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
	        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix byteMatrix = qrCodeWriter.encode(texto,BarcodeFormat.QR_CODE, imageSize, imageSize, hintMap);
	        int CrunchifyWidth = byteMatrix.getWidth();
	        image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
	                BufferedImage.TYPE_INT_RGB);
	        image.createGraphics();
	
	        Graphics2D graphics = (Graphics2D) image.getGraphics();
	        graphics.setColor(Color.WHITE);
	        graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
	        graphics.setColor(Color.BLACK);
	
	        for (int i = 0; i < CrunchifyWidth; i++) {
	            for (int j = 0; j < CrunchifyWidth; j++) {
	                if (byteMatrix.get(i, j)) {
	                    graphics.fillRect(i, j, 1, 1);
	                }
	            }
	        }
		} catch (WriterException e) {
            e.printStackTrace();
		}
        
        return image;
	}


	public static void main(String[] args){
		
		
		
		String texto = "Oi";
		// Caminho de que?
		String path = "C:\\Users\\Jeillysson\\Desktop\\teste2";
		QRCodeGenerator.gerarComZXing(path, texto, "png");
	}
}
