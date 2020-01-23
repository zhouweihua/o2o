package com.zwh.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {

	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r = new Random();
	private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

	/**
	 * 处理缩略图并返回新生成图片的相对值路径
	 * 
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(File thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtesion(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		logger.error("current relativeAddr is:" + relativeAddr);
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		logger.debug("current complete addr is :" + PathUtil.getImgBasePath() + relativeAddr);

		logger.debug("current basePath addr is :" + basePath);
		try {
			Thumbnails.of(thumbnail).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/waterfall.png")), 0.25f)
					.outputQuality(0.8).toFile(dest);
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return relativeAddr;
	}

	/**
	 * 生成随机文件名，当前年月是小时分钟秒钟+五位随机数
	 * 
	 * @return
	 */
	public static String getRandomFileName() {
		// 获取随机的五位数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		return nowTimeStr + rannum;
	}
	
	/**
	 * 将CommonsMultipartFile转换成file
	 * 
	 * @param cFile
	 * @return
	 */
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException e) {
			logger.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return newFile;
	}

	/**
	 * 创建目标路径涉及的目录
	 * 
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 获取输入文件的扩展名
	 * 
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtesion(File cFile) {
		String originalFilename = cFile.getName();
		return originalFilename.substring(originalFilename.lastIndexOf("."));
	}


}

//public static void main(String[] args) throws IOException {
//    String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//    Thumbnails.of(new File("/Users/zhouweihua/Downloads/xxx.png")).size(617, 170)
//    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/waterfall.png")),0.25f)
//    .outputQuality(0.8f).toFile("/Users/zhouweihua/Downloads/timgnew.png");
//}
