package com.mandu.yamyam.eqp.web;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mandu.yamyam.eqp.service.EqpVO;

@Controller
public class EqpInsertUpdateController {

	private String path="C:\\Dev\\upload";
	
	@PostMapping("/eqpInsert")
    public String result(EqpVO eqpVO, MultipartFile multi, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(eqpVO.getActCd());
        String url = null;
        try {
 
            //String uploadpath = request.getServletContext().getRealPath(path);
            String uploadpath = path;
            String originFilename = multi.getOriginalFilename();
            String extName = originFilename.substring(originFilename.lastIndexOf("."),originFilename.length());
            long size = multi.getSize();
            String saveFileName = genSaveFileName(extName);
            
            System.out.println("uploadpath : " + uploadpath);
            
            System.out.println("originFilename : " + originFilename);
            System.out.println("extensionName : " + extName);
            System.out.println("size : " + size);
            System.out.println("saveFileName : " + saveFileName);
            
            if(!multi.isEmpty()) {
                File file = new File(uploadpath, saveFileName);
                multi.transferTo(file);
                eqpVO.setImg(saveFileName);
                
                // insert하고 돌아오기.
                //model.addAttribute("filename", multi.getOriginalFilename());
                //model.addAttribute("uploadPath", file.getAbsolutePath());
                
                return "eqp/eqpAd";
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return "eqp/eqpAd";
    }
    
    // 현재 시간을 기준으로 파일 이름 생성
    private String genSaveFileName(String extName) {
        String fileName = "";
        
        Calendar calendar = Calendar.getInstance();
        fileName += calendar.get(Calendar.YEAR);
        fileName += calendar.get(Calendar.MONTH);
        fileName += calendar.get(Calendar.DATE);
        fileName += calendar.get(Calendar.HOUR);
        fileName += calendar.get(Calendar.MINUTE);
        fileName += calendar.get(Calendar.SECOND);
        fileName += calendar.get(Calendar.MILLISECOND);
        fileName += extName;
        
        return fileName;
    }
    
    // download만들기
}
