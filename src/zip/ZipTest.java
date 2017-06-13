package zip;

/**
 * @author 儒尊
 * @date 2017/06/02
 */

import org.apache.tools.zip.ZipEntry;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * Created by muhua.gmh on 2017/5/27.
 */
public class ZipTest {

	@Test
	public void loadMacZip() throws Exception {
		AutoDetectZipFile zipFile = new AutoDetectZipFile("/Users/lvsheng/Downloads/test.zip");
		Enumeration       e       = zipFile.getEntries();
		while (e.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) e.nextElement();
			String   name  = entry.getName();
			System.out.println(name);
		}
	}

	@Test
	public void loadMacZip2() throws Exception {
		AutoDetectZipFile zipFile = new AutoDetectZipFile("/work/商品服务/主流程模板.zip");
		Enumeration       e       = zipFile.getEntries();
		while (e.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) e.nextElement();
			String   name  = entry.getName();
			System.out.println(name);
			File file = new File("/temp/zip/windows" + File.separator + name);
			if(!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if (entry.isDirectory()) {
				file.mkdirs();
			} else {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				InputStream      inputStream      = zipFile.getInputStream(entry);
				byte[]           by               = new byte[1024];
				int              c;
				while ((c = inputStream.read(by)) != -1) {
					fileOutputStream.write(by, 0, c);
				}
				fileOutputStream.close();
				inputStream.close();
			}
		}
	}
}
