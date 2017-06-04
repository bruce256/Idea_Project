package zip;

import info.monitorenter.cpdetector.io.*;
import org.apache.tools.zip.ZipFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.ZipException;

/**
 * @author 儒尊
 * @date 2017/06/02
 */

/**
 * Created by muhua.gmh on 2017/5/27.
 */
public class AutoDetectZipFile extends ZipFile {

	private HashMap<String, Charset> charsetHashMap = new HashMap<>();

	public AutoDetectZipFile(File f) throws IOException {
		super(f);
	}

	public AutoDetectZipFile(String name) throws IOException {
		super(name);
	}

	public AutoDetectZipFile(String name, String encoding) throws IOException {
		super(name);
	}

	public AutoDetectZipFile(File f, String encoding) throws IOException {
		super(f, encoding);
	}

	@Override
	protected String getString(byte[] bytes) throws ZipException {
		CodepageDetectorProxy codePageDetector = CodepageDetectorProxy.getInstance();
		codePageDetector.add(new ParsingDetector(false));
		codePageDetector.add(JChardetFacade.getInstance());
		codePageDetector.add(new ByteOrderMarkDetector());
		codePageDetector.add(ASCIIDetector.getInstance());
		codePageDetector.add(UnicodeDetector.getInstance());

		if (this.charsetHashMap == null) {
			this.charsetHashMap = new HashMap<>();
		}
		Charset charset = Charset.forName("utf-8");
		try {
			charset = codePageDetector.detectCodepage(new ByteArrayInputStream(bytes), bytes.length);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		String decodedString = new String(bytes, charset);
		if (!"".equals(decodedString)) {
			charsetHashMap.put(decodedString, charset);
		}
		return decodedString;
	}

	public HashMap<String, Charset> getCharsetHashMap() {
		return charsetHashMap;
	}

	public AutoDetectZipFile setCharsetHashMap(HashMap<String, Charset> charsetHashMap) {
		this.charsetHashMap = charsetHashMap;
		return this;
	}


}