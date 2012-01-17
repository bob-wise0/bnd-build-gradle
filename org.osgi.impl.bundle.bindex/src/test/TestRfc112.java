package test;

import java.io.File;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.TestCase;

import org.osgi.impl.bundle.bindex.Indexer;
import org.w3c.dom.Document;

public class TestRfc112 extends TestCase {
	
	public static final String NAMESPACE = "http://www.osgi.org/xmlns/obr/v1.0.0/";
	
	private File indexFile;
	
	@Override
	protected void setUp() throws Exception {
		File outputDir = new File("./generated/testoutput");
		outputDir.mkdirs();
		indexFile = File.createTempFile("repo", ".xml", outputDir);
	}
	
	@Override
	protected void tearDown() throws Exception {
		indexFile.delete();
	}

	public void testNamespace() throws Exception {
		Indexer index = new Indexer();
		index.setRepositoryFile(indexFile);
		index.run(Collections.<File>emptyList());
		
		Document doc = loadIndex(indexFile);
		assertEquals(NAMESPACE, doc.getDocumentElement().getNamespaceURI());
	}
	
	private static Document loadIndex(File file) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder builder = dbf.newDocumentBuilder();
		return builder.parse(file);
	}
}
