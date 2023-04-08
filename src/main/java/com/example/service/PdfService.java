package com.example.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.hibernate.annotations.CreationTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


@Service
public class PdfService {
    private Logger logger = LoggerFactory.getLogger(PdfService.class);

    public ByteArrayInputStream createPdf() {
        logger.info("Crete PDF started : ");

        String title = "Welcome to World";
        String content = "Happiness is the only thing that multiplies when you share it";

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();

        PdfWriter.getInstance(document, out);

        // footer
        HeaderFooter footer = new HeaderFooter(true, new Phrase(" kumar"));
        footer.setAlignment(Element.ALIGN_CENTER);
        footer.setBorderWidthBottom(0);
        document.setFooter(footer);

        document.open();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);

        Paragraph tittlePara = new Paragraph(title, titleFont);
        tittlePara.setAlignment(Element.ALIGN_CENTER);
        document.add(tittlePara);


        Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 18);
        Paragraph paragraph = new Paragraph(content, paraFont);
        paragraph.add(new Chunk(" wow this ext is added after creating program"));
        document.add(paragraph);



        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
