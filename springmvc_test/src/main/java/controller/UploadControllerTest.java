package controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadControllerTest {
	
	@RequestMapping("toUploadPage")
    public String toUploadPage(Model model)throws Exception
	{
		return "/ImgUploadTest";
	}
	
	@RequestMapping("uploadImg")
    public String uploadImg(Model model,MultipartFile file)throws Exception
    {
		String originalFilename=file.getOriginalFilename();
		String newFileName = null;
		if(file!=null&&originalFilename!=null&&originalFilename.length()>0)
		{
			String pic_path="E:\\BUAA\\MyBatis-SpringMVC\\upload\\";
			newFileName=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile=new File(pic_path+newFileName);
			file.transferTo(newFile);
		}
		
		model.addAttribute("image", newFileName);
		return "/ImgUploadTest";
	}
}
