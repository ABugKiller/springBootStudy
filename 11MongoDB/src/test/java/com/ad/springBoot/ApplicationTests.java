package com.ad.springBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		ApplicationTests app = new ApplicationTests();
		InputStream is = app.getClass().getResourceAsStream("aa.txt");
		System.out.println((char)is.read());
		is.close();
		String encoding="GBK";
		File file = new File("classpath:\\static\\aa.txt");
		if(file.isFile() && file.exists()){ //判断文件是否存在
			InputStreamReader read = new InputStreamReader(
					new FileInputStream(file),encoding);//考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while((lineTxt = bufferedReader.readLine()) != null){
				System.out.println(lineTxt);
			}
			read.close();
		}else{
			System.out.println("找不到指定的文件");
		}
		System.out.println(file);
	}

}
