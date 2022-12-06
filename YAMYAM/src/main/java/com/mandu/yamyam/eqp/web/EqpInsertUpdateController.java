package com.mandu.yamyam.eqp.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mandu.yamyam.eqp.service.EqpService;
import com.mandu.yamyam.eqp.service.EqpVO;

@Controller
public class EqpInsertUpdateController {
	@Autowired
	EqpService eqpService;

	private static String path = "/home";
	
	@PostMapping("/eqpInsertUpdate")
	@ResponseBody
    public Map<String, Object> result(EqpVO eqpVO, MultipartFile multi, HttpServletRequest request, HttpServletResponse response, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", "예외발생");
		
        try {
            int count = 0;	// insert or update 성공건수
            
            if (!multi.isEmpty()) {	// 사진 파일이 있을 때
            	String uploadpath = path; // 파일 저장할 서버 컴퓨터의 디렉토리 
                String originFilename = multi.getOriginalFilename();
                String extName = originFilename.substring(originFilename.lastIndexOf("."),originFilename.length());
                long size = multi.getSize();
                String saveFileName = genSaveFileName(extName); // 현재 시간 기준으로 파일이름 생성하는 함수
                
                File file = new File(uploadpath, saveFileName);
                multi.transferTo(file);

                eqpVO.setImg(saveFileName);
                count = eqpService.regAndUpdateEqp(eqpVO);
            } else {	// 사진 파일이 없을 때는 사진 insert update X
            	eqpVO.setImg(null);
            	count = eqpService.regAndUpdateEqp(eqpVO);
            }
            
            
            if (count > 0) { // insert or update 성공시
        		map.put("result", "success");
        	} else { // 실패시
        		map.put("result", "fail");
        	}
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return map;
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
    
    // 파일 다운로드
    @GetMapping("/download")
    public static void fileDownload (String fileNm, HttpServletRequest request, HttpServletResponse response) throws Exception {

      File file = new File(path, fileNm);
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

      String fileName;
      
      // 브라우저에서 인코딩
      fileName = new String(fileNm.getBytes("UTF-8"), "iso-8859-1");
      
      //형식을 모르는 파일첨부용 contentType
      response.setContentType("application/octet-stream");
      //다운로드와 다운로드될 파일이름
      response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
      //파일복사
      FileCopyUtils.copy(in, response.getOutputStream());
      in.close();
      response.getOutputStream().flush();
      response.getOutputStream().close();
    }
}
