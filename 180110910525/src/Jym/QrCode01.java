package Jym;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@WebServlet("/QrCode")
public class QrCode01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取信息
		request.setCharacterEncoding("utf-8");
		String text = request.getParameter("input_text");
		String size = request.getParameter("size");
		int width = 300;

		HashMap hints = new HashMap();
		// 字符编码
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		// 容错级别
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

		try {
			//定义二维码对象
			BitMatrix bitMatrix = new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE,width,width,hints);
			//定义一个输出流
			
			//获取物理路径
			String appPath = this.getServletContext().getRealPath("/");
		    
			//实际的上传路径
			String path = appPath + File.separator + "qrimg" + File.separator;
			
			//设置当前时间作为文件名
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
			String filename = sdf.format(d) + ".jpg";
			OutputStream os = new FileOutputStream(path+filename);
			
			//输出到指定文件
			MatrixToImageWriter.writeToStream(bitMatrix, "jpg", os);
			
			//转发
			request.setAttribute("img_filename", filename);
			 request.setAttribute("img_txt", text);
			request.getRequestDispatcher("WEB-INF/jsp/qrcode.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
