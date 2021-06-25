package com.daike.file;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

/**
 * File 测试
 *
 * @author PigPig
 * @date 2021/06/24 14:17
 **/
public class Demo {

	@Test
	public void test() {
		String url = "D:/xdlt_data_home/music_data/PRS/时/20210623/Z_NAFP_C_BABJ_20210623002828_P_CLDAS_RT_ASI_0P0625_HOR-PRS-2021062300.nc";
		File file = new File(url);
		String parent = file.getParent();
		if (!file.isFile()) {
			File parentFile = new File(parent);
			if (!parentFile.exists()) {
				System.out.println(parentFile.exists());
				parentFile.mkdirs();
			}
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(file.isFile());
	}

	@Test
	public void testStr() {
		String filePath = "X:\\xdlt_data_home\\product\\ZBSTZL\\贵州\\ACCNPP\\INDC\\NMC";
		String[] split = filePath.split("/|\\\\");
		String substring = filePath.substring(filePath.indexOf(split[2]));
		System.out.println(substring);
	}

}
