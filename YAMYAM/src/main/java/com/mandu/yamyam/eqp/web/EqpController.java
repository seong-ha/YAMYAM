package com.mandu.yamyam.eqp.web;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mandu.yamyam.eqp.service.EqpService;

@Controller
public class EqpController {
	@Autowired
	EqpService eqpService;
	
	@RequestMapping("/eqpAd")
	public String eqpAd(Model model) {
		model.addAttribute("eqpActList", eqpService.getEqpActList());
		model.addAttribute("eqpStsList", eqpService.getEqpStsList());
		return "eqp/eqpAd";
	}
	

	@RequestMapping("/uopAd")
	public String uopAd() {
		return "eqp/uopAd";
	}
	
	@RequestMapping("/eqpChkAd")
	public String eqpChkAd() {
		// 설비구분 데이터들 가져와서 model로 내려주기
		return "eqp/eqpChkAd";
	}
	
	
	private String path="/images";
	
	@RequestMapping("/result")
    public String result(@RequestParam("img") MultipartFile multi,HttpServletRequest request,HttpServletResponse response, Model model)
    {
        String url = null;
        
        try {
 
            //String uploadpath = request.getServletContext().getRealPath(path);
            String uploadpath = request.getContextPath();
            String originFilename = multi.getOriginalFilename();
            String extName = originFilename.substring(originFilename.lastIndexOf("."),originFilename.length());
            long size = multi.getSize();
            String saveFileName = genSaveFileName(extName);
            
            System.out.println("uploadpath : " + uploadpath);
            
            System.out.println("originFilename : " + originFilename);
            System.out.println("extensionName : " + extName);
            System.out.println("size : " + size);
            System.out.println("saveFileName : " + saveFileName);
            
            if(!multi.isEmpty())
            {
                File file = new File(uploadpath, multi.getOriginalFilename());
                multi.transferTo(file);
                
                model.addAttribute("filename", multi.getOriginalFilename());
                model.addAttribute("uploadPath", file.getAbsolutePath());
                
                return "eqp/eqpAd";
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return "redirect:form";
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
	
	
	
	
}
