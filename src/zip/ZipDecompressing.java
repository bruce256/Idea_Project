package zip;

import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.zip.ZipFile;
import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author 儒尊
 * @date 2017/05/27
 */
public class ZipDecompressing {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		try {
			String   Parent = "/temp"; //输出路径（文件夹目录）
			File     destFile;
			ZipEntry entry;
			try (ZipInputStream Zin = new ZipInputStream(new FileInputStream("/Users/lvsheng/Downloads/测试品牌.zip"));//输入源zip路径
			     BufferedInputStream Bin = new BufferedInputStream(Zin);) {
				while ((entry = Zin.getNextEntry()) != null && !entry.isDirectory()) {
					destFile = new File(Parent, entry.getName());
					if (!destFile.exists()) {
						(new File(destFile.getParent())).mkdirs();
					}
					FileOutputStream     out  = new FileOutputStream(destFile);
					BufferedOutputStream Bout = new BufferedOutputStream(out);
					int                  b;
					while ((b = Bin.read()) != -1) {
						Bout.write(b);
					}
					Bout.close();
					out.close();
					System.out.println(destFile + "解压成功");
				}
				Bin.close();
				Zin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("耗费时间： " + (endTime - startTime) + " ms");
	}

	@Test
	public void unCompress() {
		Expand expand = new Expand();
		expand.setOverwrite(true);
		expand.setSrc(new File("/Users/lvsheng/Downloads/测试品牌.zip"));
		expand.setDest(new File("/temp"));
		expand.execute();
	}

	@Test
	public void decompress() throws IOException{
		ZipFile                                    zipFile = new ZipFile("/Users/lvsheng/Downloads/测试品牌.zip");
		Enumeration<org.apache.tools.zip.ZipEntry> entries = zipFile.getEntries();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			System.out.println(entry.getName());
		}
		/*Expand expand = new Expand();
		expand.setEncoding("utf-8");
		expand.setOverwrite(true);
		expand.setSrc(new File("/Users/lvsheng/Downloads/全渠道批量发布模板-daily.xlsx.zip"));
		expand.setDest(new File("/temp"));
		expand.execute();*/
	}
}
