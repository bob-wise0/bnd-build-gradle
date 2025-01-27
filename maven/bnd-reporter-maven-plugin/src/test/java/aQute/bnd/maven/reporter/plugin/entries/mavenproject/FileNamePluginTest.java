package aQute.bnd.maven.reporter.plugin.entries.mavenproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.maven.project.MavenProject;
import org.junit.jupiter.api.Test;

import aQute.bnd.maven.reporter.plugin.MavenProjectWrapper;

public class FileNamePluginTest {

	@Test
	public void testWorkspaceSettingsEntry() throws Exception {

		final FileNamePlugin s = new FileNamePlugin();

		final File file = File.createTempFile("test", "test");
		file.deleteOnExit();

		MavenProjectWrapper pr = getProject();
		pr.getProject()
			.setFile(file);

		assertEquals(file.getParentFile()
			.getName(), s.extract(pr, Locale.forLanguageTag("und")));
	}

	private MavenProjectWrapper getProject() throws Exception {
		List<MavenProject> ps = new ArrayList<>();
		MavenProject p = new MavenProject();

		ps.add(p);

		return new MavenProjectWrapper(ps, p);
	}
}
