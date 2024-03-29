package be.ticket.common;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

public abstract class AbstractArquillianTestCase {
	
	/**
	 * To log the contents of the archive, use the following: 
	 * System.out.println(archive.toString(Formatters.VERBOSE));
	 * @return the created test archive
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		JavaArchive archive = ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addPackages(true, "be.ticket")
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsResource("import.sql", "import.sql")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return archive;
	}
}
