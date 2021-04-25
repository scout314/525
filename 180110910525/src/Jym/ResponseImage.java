package Jym;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ResponseImage")
public class ResponseImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//���������Ϊ����Ϊjpg��ͼƬ
		response.setContentType("image/jpeg");
		
		//���ڴ��д���һ��ͼƬ
		BufferedImage image = new BufferedImage(70,30,BufferedImage.TYPE_INT_RGB);
        
        Graphics g = image.getGraphics();
        
        //���ñ���
        g.setColor(Color.red);
        g.fillRect(0, 0, 70, 30);
        
        g.setColor(Color.white);
        g.setFont(new Font(null,Font.BOLD,24));
        
        
        Random r = new Random();
        int i = r.nextInt(8999)+1000;
        
        //У�����ֵ
        String vcode = String.valueOf(i);
        
        //��vcode����sesssion
        HttpSession session = request.getSession();
        session.setAttribute("verf", vcode);
        
        g.drawString(String.valueOf(i), 10, 25);
        
        
        //��ȡresponse�������
        OutputStream os = response.getOutputStream();
		ImageIO.write(image, "jpg",os);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}