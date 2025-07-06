package pl.com.invoiceservice.service;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
public class GeneratePDFServiceTest {


	GeneratePDFService generatePDFService;

	GeneratePDFServiceTest() {
		this.generatePDFService = new GeneratePDFService();
	}

	@Test
	@SneakyThrows
	public void test_generate_empty_document() {
		File tmpFile = File.createTempFile("emptyDoc", ".pdf");

		byte[] documentPDF = generatePDFService.generateEmptyDocument();
		Files.write(tmpFile.toPath(), documentPDF);
        assertNotNull(documentPDF);

		log.info("Temporary file with empty document saved: {}", tmpFile.getAbsolutePath());
	}
}
