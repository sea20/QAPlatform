package com.service.impl;

import com.bean.result.Result;
import com.email.EmailService;
import com.mapper.HeadPictureMapper;
import com.service.HeadPictureService;
import com.utils.result.R;
import org.junit.Before;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @Auther: Maple
 * @Date: 2021/2/4
 */
@Service
@Transactional
public class HeadPictureServiceImpl implements HeadPictureService {

    @Autowired
    HeadPictureMapper headPictureMapper;
    @Autowired
    EmailService emailService;
    /*@Before
    public void before(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //System.out.println(userMapper);
        SqlSessionTemplate sqlSession = (SqlSessionTemplate) context.getBean("sqlSession");
        HeadPictureMapper mapper = sqlSession.getMapper(HeadPictureMapper.class);
    }*/
    @Override
    public Result upload(MultipartFile file, Integer uId, HttpServletRequest request) {
        String originalFilename = file.getOriginalFilename();
        String last = originalFilename.substring(originalFilename.indexOf(".")+1);
        //判断格式对不对
        if(last == null || !(last.equals("png")||last.equals("jpg"))){
            return R.Error("文件格式不正确");
        }


        //获取路径
        UUID uuid = UUID.randomUUID();
        String path = request.getSession().getServletContext().getRealPath("/headPicture");
        String realPath = path+"/"+uuid.toString()+".png";

        //存储
        try {
            InputStream is = file.getInputStream();
            OutputStream os = new FileOutputStream(realPath);
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = is.read(bytes)) != -1){
                os.write(bytes,0,len);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            return R.Error();
        }

        //判断是否需要删除图片
        String oldFileName = null;
        oldFileName = headPictureMapper.getOldFileName(uId);
        if (oldFileName != null){
            deleteFile(path+"/"+oldFileName);
        }

        //插入/更新记录
        int count = headPictureMapper.upload(uId,uuid.toString()+".png");
        if (count == 0)
            return R.Error();

        return R.Ok().add("data","http://47.108.190.196/QAPlatform/headPicture/"+uuid.toString()+".png");
    }

    @Override
    public Result getHeadPicture(Integer uId) {
        String oldFileName = headPictureMapper.getOldFileName(uId);
        if (oldFileName == null || oldFileName == ""){
            String url = "http://47.108.190.196/QAPlatform/headPicture/"+"temp.png";
            return R.Ok().add("data",url);
        }
        if(oldFileName == null){
            return R.Empty();
        }

        String url = "http://47.108.190.196/QAPlatform/headPicture/"+oldFileName;
        return R.Ok().add("data",url);
    }


    private void deleteFile(String uri) {
        System.out.println("删除");
        File file = new File(uri);
        if(file != null)
            System.out.println(file.delete());
    }

}
