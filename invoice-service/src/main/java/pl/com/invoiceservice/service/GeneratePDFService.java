package pl.com.invoiceservice.service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.invoiceservice.exception.DocumentCreationException;

import java.io.ByteArrayOutputStream;

@Slf4j
@Service
public class GeneratePDFService {

	GeneratePDFService() {

	}

	public byte[] generateEmptyDocument() throws DocumentCreationException {

		Document doc = new Document();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			final PdfWriter pdfWriter = PdfWriter.getInstance(doc, byteArrayOutputStream);

			doc.open();

			pdfWriter.getInfo().put(PdfName.CREATOR, new PdfString(Document.getVersion()));

			doc.setPageSize(PageSize.A4);
			doc.newPage();
			doc.add(new Paragraph(""));
			doc.close();

			return byteArrayOutputStream.toByteArray();
		} catch (DocumentException e) {
			throw new DocumentCreationException(e.getMessage());
		}
	}
}
